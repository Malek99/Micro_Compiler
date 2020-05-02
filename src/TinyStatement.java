
public class TinyStatement {

	public static enum Opcode {
		nop, var, str, label, move, addi, addr, subi, subr, muli, mulr, divi, divr, inci, deci, cmpi, cmpr, jmp, jgt, jlt,
		jge, jle, jne, jeq, sys_readi, sys_readr, sys_writei, sys_writer, sys_writes
	}

	Opcode opcode;
	TinyOperand op1, op2;
	
	private static ScopeTree scopeTree;
	
	public TinyStatement(Opcode opcode, TinyOperand op) {
		this.op1 = new TinyOperand();
		setInstruction(opcode, op);
	}
	
	public TinyStatement(Opcode opcode, TinyOperand op1, TinyOperand op2) {
		this.op1 = new TinyOperand();
		this.op2 = new TinyOperand();
		setInstruction(opcode, op1, op2);
	}

	public String getOpcodeText() {
		switch (opcode) {
		case sys_readi:
			return "sys readi";
		case sys_readr:
			return "sys readr";
		case sys_writei:
			return "sys writei";
		case sys_writer:
			return "sys writer";
		case sys_writes:
			return "sys writes";
		default:
			return opcode.name();
		}
	}

	public void setInstruction(Opcode opcode, TinyOperand op) {
		this.opcode = opcode;
		this.op1.copy(op);
		this.op2 = null;
	}

	public void setInstruction(Opcode opcode, TinyOperand op1, TinyOperand op2) {
		this.opcode = opcode;
		this.op1.copy(op1);
		this.op2.copy(op2);
	}
	
	

	public static void setScopeTree(ScopeTree scopeTree) {
		TinyStatement.scopeTree = scopeTree;
	}

	@Override
	public String toString() {
		String s = getOpcodeText();
		if(op1 != null)
			s = s + " " + op1.toString();
		
		if(op2 != null)
			s = s + " " + op2.toString();
		
		if(opcode == Opcode.str) {
			String strVal = ((Str_Info) scopeTree.declaredLocally(op1.toString())).getString();
			s = s + " " + strVal;
		}
			
			
		return s;
	}

}
