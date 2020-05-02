import java.util.Hashtable;
import java.util.LinkedList;


public class TinyCodeGenerator {
	private LinkedList<TinyStatement> code;
	private TinyOperand op1, op2;
	private Hashtable<Integer, Integer> tempToReg;
	private int regID;
	private ScopeTree scopeTree;

	public TinyCodeGenerator(ScopeTree scopeTree) {
		code = new LinkedList<TinyStatement>();
		op1 = new TinyOperand();
		op2 = new TinyOperand();
		tempToReg = new Hashtable<Integer, Integer>();
		this.scopeTree = scopeTree;
		TinyStatement.setScopeTree(scopeTree);
		regID = 0;
	}

	public LinkedList<TinyStatement> generate(IRCode irCode) {
		
		LinkedList<Symbol> symbols = scopeTree.getSymbolTable().getAllSymbols();
		
		for (Symbol symbol : symbols) {
			
			op1.setToMemory(symbol.info.getID());
			
			if(symbol.info.isString())
				code.add(new TinyStatement(TinyStatement.Opcode.str, op1)); 
			else
				code.add(new TinyStatement(TinyStatement.Opcode.var, op1));
		}

		for (IRStatement irStatement : irCode) {

			switch (irStatement.getOpcode()) {
			case ADDI:
				convertADDI(irStatement);
				break;
			case ADDF:
				convertADDF(irStatement);
				break;
			case SUBI:
				convertSUBI(irStatement);
				break;
			case SUBF:
				convertSUBF(irStatement);
				break;
			case MULTI:
				convertMULTI(irStatement);
				break;
			case MULTF:
				convertMULTF(irStatement);
				break;
			case DIVI:
				convertDIVI(irStatement);
				break;
			case DIVF:
				convertDIVF(irStatement);
				break;
			case GT:
				convertGT(irStatement);
				break;
			case GE:
				convertGE(irStatement);
				break;
			case LT:
				convertLT(irStatement);
				break;
			case LE:
				convertLE(irStatement);
				break;
			case NE:
				convertNE(irStatement);
				break;
			case EQ:
				convertEQ(irStatement);
				break;
			case JUMP:
				convertJUMP(irStatement);
				break;
			case LABEL:
				convertLABEL(irStatement);
				break;
			case READI:
				convertREADI(irStatement);
				break;
			case READF:
				convertREADF(irStatement);
				break;
			case WRITEI:
				convertWRITEI(irStatement);
				break;
			case WRITEF:
				convertWRITEF(irStatement);
				break;
			case WRITES:
				convertWRITES(irStatement);
				break;
			case STOREI:
				convertSTORE(irStatement);
				break;
			case STOREF:
				convertSTORE(irStatement);
				break;
			case RETURN:
				convertRETURN(irStatement);
				break;
			default:
				break;
			}

		}

		return code;
	}
	
	private TinyOperand getOperand(IROperand irOperand) {
		TinyOperand op = new TinyOperand();
		
		if(irOperand.isIntegerImmediate())
			op.setToInt(irOperand.getValue());
		else if(irOperand.isFloatImmediate())
			op.setTofloat(irOperand.getFvalue());
		else if(irOperand.isLabel())
			op.setTolabel(irOperand.getValue());
		else if(irOperand.isSymbol())
			op.setToMemory(irOperand.getValue());
		else if(irOperand.isTemporary())
			op.setToRegister(tempToReg.get(irOperand.getValue()));
			
		return op;
	}
	
	private void convertArithmetic(TinyStatement.Opcode opcode, IRStatement irStatement) {
		op1 =  getOperand(irStatement.getOperand1());
		op2.setToRegister(++regID);
		
		code.add(new TinyStatement(TinyStatement.Opcode.move, op1, op2));
		
		
		op1 = getOperand(irStatement.getOperand2());
		code.add(new TinyStatement(opcode, op1, op2));
		
		tempToReg.put(irStatement.getResult().getValue(), regID);
	}
	
	private void convertConditionalJump(TinyStatement.Opcode opcode, IRStatement irStatement) {
		op1 = getOperand(irStatement.getOperand2());
		op2.setToRegister(++regID);
		
		code.add(new TinyStatement(TinyStatement.Opcode.move, op1, op2));
		
		op1 = getOperand(irStatement.getOperand1());
		
		
		code.add(new TinyStatement(TinyStatement.Opcode.cmpi, op1, op2));
		
		op1 = getOperand(irStatement.getResult());
		
		code.add(new TinyStatement(opcode, op1));
	}
	
	private void convertOneOperandStatement(TinyStatement.Opcode opcode, IRStatement irStatement) {
		op1 = getOperand(irStatement.getResult());
		code.add(new TinyStatement(opcode, op1));
	}
	
	
	private void convertSTORE(IRStatement irStatement) {
		
		op1 = getOperand(irStatement.getOperand1());
		
		if(irStatement.getResult().isSymbol() && irStatement.getOperand1().isSymbol())
		{
			op2.setToRegister(++regID);
			code.add(new TinyStatement(TinyStatement.Opcode.move, op1, op2));
			
			op1.copy(op2);
		}
		
		op2 = getOperand(irStatement.getResult());
		code.add(new TinyStatement(TinyStatement.Opcode.move, op1, op2));
		
	}

	public void convertADDI(IRStatement irStatement) {
		convertArithmetic(TinyStatement.Opcode.addi, irStatement);
	}

	public void convertADDF(IRStatement irStatement) {
		convertArithmetic(TinyStatement.Opcode.addr, irStatement);
	}

	public void convertSUBI(IRStatement irStatement) {
		convertArithmetic(TinyStatement.Opcode.subi, irStatement);
	}

	public void convertSUBF(IRStatement irStatement) {
		convertArithmetic(TinyStatement.Opcode.subr, irStatement);
	}

	public void convertMULTI(IRStatement irStatement) {
		convertArithmetic(TinyStatement.Opcode.muli, irStatement);
	}

	public void convertMULTF(IRStatement irStatement) {
		convertArithmetic(TinyStatement.Opcode.mulr, irStatement);
	}

	public void convertDIVI(IRStatement irStatement) {
		convertArithmetic(TinyStatement.Opcode.divi, irStatement);
	}

	public void convertDIVF(IRStatement irStatement) {
		convertArithmetic(TinyStatement.Opcode.divr, irStatement);
	}

	public void convertGT(IRStatement irStatement) {
		convertConditionalJump(TinyStatement.Opcode.jgt, irStatement);
	}

	public void convertGE(IRStatement irStatement) {
		convertConditionalJump(TinyStatement.Opcode.jge, irStatement);
	}

	public void convertLT(IRStatement irStatement) {
		convertConditionalJump(TinyStatement.Opcode.jlt, irStatement);
	}

	public void convertLE(IRStatement irStatement) {
		convertConditionalJump(TinyStatement.Opcode.jle, irStatement);
	}

	public void convertNE(IRStatement irStatement) {
		convertConditionalJump(TinyStatement.Opcode.jne, irStatement);
	}

	public void convertEQ(IRStatement irStatement) {
		convertConditionalJump(TinyStatement.Opcode.jeq, irStatement);
	}

	public void convertJUMP(IRStatement irStatement) {
		convertOneOperandStatement(TinyStatement.Opcode.jmp, irStatement);
	}

	public void convertLABEL(IRStatement irStatement) {
		convertOneOperandStatement(TinyStatement.Opcode.label, irStatement);
	}

	public void convertREADI(IRStatement irStatement) {
		convertOneOperandStatement(TinyStatement.Opcode.sys_readi, irStatement);
	}

	public void convertREADF(IRStatement irStatement) {
		convertOneOperandStatement(TinyStatement.Opcode.sys_readr, irStatement);
	}

	public void convertWRITEI(IRStatement irStatement) {
		convertOneOperandStatement(TinyStatement.Opcode.sys_writei, irStatement);
	}

	public void convertWRITEF(IRStatement irStatement) {
		convertOneOperandStatement(TinyStatement.Opcode.sys_writer, irStatement);
	}

	public void convertWRITES(IRStatement irStatement) {
		convertOneOperandStatement(TinyStatement.Opcode.sys_writes, irStatement);

	}

	@Deprecated
	public void convertSTOREI(IRStatement irStatement) {
		op1 = getOperand(irStatement.getOperand1());
		op2 = getOperand(irStatement.getResult());
		code.add(new TinyStatement(TinyStatement.Opcode.move, op1, op2));
	}

	@Deprecated
	public void convertSTOREF(IRStatement irStatement) {
		op1 = getOperand(irStatement.getOperand1());
		op2 = getOperand(irStatement.getResult());
		code.add(new TinyStatement(TinyStatement.Opcode.move, op1, op2));
	}

	public void convertRETURN(IRStatement irStatement) {

	}

}
