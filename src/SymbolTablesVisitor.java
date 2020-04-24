public class SymbolTablesVisitor extends MicroBaseVisitor<ScopeTree> {

	ScopeTree scopeTree;
	SymbolInfo info;

	// opening scopes
	@Override
	public ScopeTree visitProgram(MicroParser.ProgramContext ctx) {
		info = new SymbolInfo();
		scopeTree = new ScopeTree();
		visitChildren(ctx);
		scopeTree.closeScope();
		return scopeTree;
	}

	@Override
	public ScopeTree visitFunc_decl(MicroParser.Func_declContext ctx) {
		scopeTree.openScope(ctx.function_name.getText());
		visitChildren(ctx);
		scopeTree.closeScope();
		return null;
	}

	@Override
	public ScopeTree visitIf_stmt(MicroParser.If_stmtContext ctx) {
		scopeTree.openScope();
		visitChildren(ctx);
		scopeTree.closeScope();
		return null;
	}

	@Override
	public ScopeTree visitElseRule(MicroParser.ElseRuleContext ctx) {
		scopeTree.openScope();
		visitChildren(ctx);
		scopeTree.closeScope();
		return null;
	}

	@Override
	public ScopeTree visitFor_stmt(MicroParser.For_stmtContext ctx) {
		scopeTree.openScope();
		visitChildren(ctx);
		scopeTree.closeScope();
		return null;
	}

	// declarations
	@Override
	public ScopeTree visitString_decl(MicroParser.String_declContext ctx) {
		scopeTree.enterSymbol(ctx.variable_name.getText(), new Str_Info(ctx.string_value.getText()));
		visitChildren(ctx);
		return null;
	}

	@Override
	public ScopeTree visitDeclareInt(MicroParser.DeclareIntContext ctx) {
		info.setTypeToInt();
		visitChildren(ctx);
		return null;
	}

	@Override
	public ScopeTree visitDeclareFloat(MicroParser.DeclareFloatContext ctx) {
		info.setTypeToFloat();
		visitChildren(ctx);
		return null; 
	}

	@Override
	public ScopeTree visitId_list(MicroParser.Id_listContext ctx) {
		scopeTree.enterSymbol(ctx.variable_name.getText(), info);
		visitChildren(ctx);
		return null;
	}

	@Override
	public ScopeTree visitId_tail(MicroParser.Id_tailContext ctx) {
		
		if(ctx.variable_name != null)
			scopeTree.enterSymbol(ctx.variable_name.getText(), info);
		visitChildren(ctx);
		return null;
	}

	@Override
	public ScopeTree visitParameter_decl(MicroParser.Parameter_declContext ctx) {
		scopeTree.enterSymbol(ctx.variable_name.getText(), info);
		visitChildren(ctx);
		return null;
	}

}
