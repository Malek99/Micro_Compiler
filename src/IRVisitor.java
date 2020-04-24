import java.util.Hashtable;
import java.util.Stack;

public class IRVisitor extends MicroBaseVisitor<IRCode> {

	private ScopeTree scopeTree;
	private IRCode code;
	private Hashtable<Integer, String> labels;
	private Stack<Operand> operand1_st, operand2_st;

	private int tmpID, labelID;
	private Operand operand1, operand2, result;
	private IRStatement statement;
	private boolean read;
	
	private char op;

	public IRVisitor(ScopeTree scopeTree) {
		this.scopeTree = scopeTree;
		code = new IRCode();
		tmpID = 0;
		labelID = 0;
		operand1 = new Operand();
		operand2 = new Operand();
		result = new Operand();
		statement = new IRStatement();
		labels = new Hashtable<Integer, String>();
		operand1_st = new Stack<Operand>();
		operand2_st = new Stack<Operand>();
	}

	private void saveOperands() {
		operand1_st.push(new Operand(operand1));
		operand2_st.push(new Operand(operand2));
	}

	private void restoreOperands() {
		operand1 = operand1_st.pop();
		operand2 = operand2_st.pop();
	}

	private void addReadOrWriteStatement(String symbol) {
		SymbolInfo info = scopeTree.retrieveSymbol(symbol);
		result.setToSymbol(info.getID(), info.isInt());

		if (read) {
			if (info.isFloat())
				statement.setToREADF(result);
			else
				statement.setToREADI(result);
		} else {
			if (info.isFloat())
				statement.setToWRITEF(result);
			else if (info.isInt())
				statement.setToWRITEI(result);
			else
				statement.setToWRITES(result);
		}

		code.insertAfterCode(statement);
	}

	private void addExitStatement(String compareOP) {
		statement.setToNOP();

		if (compareOP.equals("="))
			statement.setToNE(operand1, operand2, result);
		else if (compareOP.equals("!="))
			statement.setToEQ(operand1, operand2, result);
		else if (compareOP.equals("<"))
			statement.setToGE(operand1, operand2, result);
		else if (compareOP.equals(">"))
			statement.setToLE(operand1, operand2, result);
		else if (compareOP.equals("<="))
			statement.setToGT(operand1, operand2, result);
		else if (compareOP.equals(">="))
			statement.setToLT(operand1, operand2, result);

		code.insertAfterCode(statement);
	}

	private void addNumberedLabel(int label) {
		labels.put(label, "L" + label);
	}
	
	private void setStatement() {
		if(op == '*')
			if (result.isIntType())
				statement.setToMULTI(operand1, operand2, result);
			else
				statement.setToMULTF(operand1, operand2, result);
		else if(op == '/')
			if (result.isIntType())
				statement.setToDIVI(operand1, operand2, result);
			else
				statement.setToDIVF(operand1, operand2, result);
		else if(op == '+')
			if (result.isIntType())
				statement.setToADDI(operand1, operand2, result);
			else
				statement.setToADDF(operand1, operand2, result);
		else if(op == '-')
			if (result.isIntType())
				statement.setToSUBI(operand1, operand2, result);
			else
				statement.setToSUBF(operand1, operand2, result);
	}

	@Override
	public IRCode visitProgram(MicroParser.ProgramContext ctx) {
		scopeTree.openRootScope();
		visit(ctx.pgm_body().func_declarations());
		Operand.setLabels(labels);
		Operand.setSymbolName(scopeTree.getGlobalSymbols());
		return code;
	}

	@Override
	public IRCode visitFunc_decl(MicroParser.Func_declContext ctx) {

		// new label statement
		labels.put(labelID, ctx.function_name.getText());
		result.setToLabel(labelID);
		statement.setToLABEL(result);

		// insert statement
		code.insertAfterCode(statement);

		visit(ctx.func_body().stmt_list());

		return null;
	}

	// assign statements

	@Override
	public IRCode visitAssign_stmt(MicroParser.Assign_stmtContext ctx) {

		SymbolInfo info = scopeTree.retrieveSymbol(ctx.id().getText());

		visit(ctx.expr());
		operand1.copy(result);

		result.setToSymbol(info.getID(), info.isInt());

		if (result.isIntType())
			statement.setToSTOREI(operand1, result);
		else
			statement.setToSTOREF(operand1, result);
		code.insertAfterCode(statement);

		return null;
	}

	// read and write statements
	@Override
	public IRCode visitRead_stmt(MicroParser.Read_stmtContext ctx) {
		read = true;
		visit(ctx.var_list());
		return null;
	}

	@Override
	public IRCode visitWrite_stmt(MicroParser.Write_stmtContext ctx) {
		read = false;
		visit(ctx.var_list());
		return null;
	}

	@Override
	public IRCode visitVar_list(MicroParser.Var_listContext ctx) {
		addReadOrWriteStatement(ctx.variable_name.getText());
		visit(ctx.var_list_tail());
		return null;
	}

	@Override
	public IRCode visitVar_list_tail(MicroParser.Var_list_tailContext ctx) {
		if (ctx.variable_name != null) {
			addReadOrWriteStatement(ctx.variable_name.getText());
			visit(ctx.var_list_tail());
		}

		return null;
	}

	// return statement

	@Override
	public IRCode visitReturn_stmt(MicroParser.Return_stmtContext ctx) {

		visit(ctx.expr());
		statement.setToRETURN(result);
		code.insertAfterCode(statement);

		return null;
	}

	// if statement

	@Override
	public IRCode visitIf_stmt(MicroParser.If_stmtContext ctx) {

		int jumpLabel = ++labelID;
		addNumberedLabel(jumpLabel);

		saveOperands();

		visit(ctx.condition());
		result.setToLabel(jumpLabel);
		addExitStatement(ctx.condition().compare().getText());

		restoreOperands();

		visit(ctx.stmt_list());

		if (ctx.else_part().children != null) { // else part isn't empty
			int exitLabel = ++labelID;
			addNumberedLabel(exitLabel);

			result.setToLabel(exitLabel);
			statement.setToJUMP(result);
			code.insertAfterCode(statement);

			result.setToLabel(jumpLabel);
			statement.setToLABEL(result);
			code.insertAfterCode(statement);

			visit(ctx.else_part());

			result.setToLabel(exitLabel);
			statement.setToLABEL(result);
			code.insertAfterCode(statement);

		} else {
			result.setToLabel(jumpLabel);
			statement.setToLABEL(result);
			code.insertAfterCode(statement);
		}

		return null;
	}

	@Override
	public IRCode visitCondition(MicroParser.ConditionContext ctx) {

		visit(ctx.expr1());
		operand1.copy(result);

		visit(ctx.expr2());
		operand2.copy(result);

		return null;
	}

	// for statement

	@Override
	public IRCode visitFor_stmt(MicroParser.For_stmtContext ctx) {

		visit(ctx.init_stmt());

		int loopBeginning = ++labelID;
		addNumberedLabel(loopBeginning);
		result.setToLabel(loopBeginning);
		statement.setToLABEL(result);
		code.insertAfterCode(statement);

		int exitLabel = ++labelID;
		addNumberedLabel(exitLabel);

		saveOperands();
		visit(ctx.condition());
		result.setToLabel(exitLabel);
		addExitStatement(ctx.condition().compare().getText());
		restoreOperands();

		visit(ctx.stmt_list());
		
		visit(ctx.incr_stmt());

		result.setToLabel(loopBeginning);
		statement.setToJUMP(result);
		code.insertAfterCode(statement);

		result.setToLabel(exitLabel);
		statement.setToLABEL(result);
		code.insertAfterCode(statement);

		return null;
	}

	// expressions

	@Override
	public IRCode visitExpr(MicroParser.ExprContext ctx) {
		
		if(ctx.expr_prefix().children == null)
		{
			visit(ctx.term());
			return null;
		}

		saveOperands();
		
		visit(ctx.expr_prefix());
		operand1.copy(result);
		
		char tmp_op = op;
		
		visit(ctx.term());
		operand2.copy(result);
		
		op = tmp_op;
		
		result.setToTemporary(++tmpID, operand1.isIntType() && operand2.isIntType());
		
		setStatement();
		
		code.insertAfterCode(statement);
		

		restoreOperands();
		return null;
	}

	@Override
	public IRCode visitExpr_prefix(MicroParser.Expr_prefixContext ctx) {
		if(ctx.expr_prefix().children == null) {
			visit(ctx.term());
			op = ctx.op.getText().charAt(0);
			return null;
		}

		saveOperands();

		visit(ctx.expr_prefix());
		operand1.copy(result);
		
		char tmp_op = op;
		
		visit(ctx.term());
		operand2.copy(result);
		
		op = tmp_op;
		
		result.setToTemporary(++tmpID, operand1.isIntType() && operand2.isIntType());

		setStatement();
		code.insertAfterCode(statement);
		
		op = ctx.op.getText().charAt(0);
		
		restoreOperands();

		return null;
	}



	@Override
	public IRCode visitTerm(MicroParser.TermContext ctx) {
		
		
		if(ctx.factor_prefix().children == null)
		{
			visit(ctx.factor());
			return null;
		}

		saveOperands();
		
		visit(ctx.factor_prefix());
		operand1.copy(result);

		char tmp_op = op;
		
		visit(ctx.factor());
		operand2.copy(result);
		
		op = tmp_op;
		
		result.setToTemporary(++tmpID, operand1.isIntType() && operand2.isIntType());
		setStatement();
		code.insertAfterCode(statement);
		
		restoreOperands();
		
		return null;
	}
	
	@Override
	public IRCode visitFactor_prefix(MicroParser.Factor_prefixContext ctx) {
		
		if(ctx.factor_prefix().children == null) {
			visit(ctx.factor());
			op = ctx.op.getText().charAt(0);
			
			return null;
		}
		
		saveOperands();
		
		visit(ctx.factor_prefix());
		operand1.copy(result);
		
		char tmp_op = op;
		
		visit(ctx.factor());
		operand2.copy(result);
		
		op = tmp_op;
		
		result.setToTemporary(++tmpID, operand1.isIntType() && operand2.isIntType());
		
		setStatement();
		
		code.insertAfterCode(statement);
		
		op = ctx.op.getText().charAt(0);
		
		restoreOperands();
		
		return null;
	}

	@Override
	public IRCode visitExprFactor(MicroParser.ExprFactorContext ctx) {
		visit(ctx.expr());
		return null;
	}

	@Override
	public IRCode visitIntImmediateFactor(MicroParser.IntImmediateFactorContext ctx) {
		String intValue = ctx.INTLITERAL().getText();
		result.setToIntegerImmediate(Integer.parseInt(intValue));
		return null;
	}

	@Override
	public IRCode visitFloatImmediateFactor(MicroParser.FloatImmediateFactorContext ctx) {
		String floatValue = ctx.FLOATLITERAL().getText();
		result.setToFloatImmediate(Float.parseFloat(floatValue));
		return null;
	}

	@Override
	public IRCode visitSymbolFactor(MicroParser.SymbolFactorContext ctx) {
		SymbolInfo info = scopeTree.retrieveSymbol(ctx.id().getText());
		result.setToSymbol(info.getID(), info.isInt());
		return null;
	}

}
