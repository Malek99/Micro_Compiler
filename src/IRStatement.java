
public class IRStatement {
	private byte opcode;
	private Operand operand1, operand2, result;
	private static String[] opcodeText = { "NOP", "ADDI", "ADDF", "SUBI", "SUBF", "MULTI", "MULTF", "DIVI", "DIVF",
			"GT", "GE", "LT", "LE", "NE", "EQ", "JUMP", "LABEL", "READI", "READF", "WRITEI", "WRITEF", "WRITES",
			"STOREI", "STOREF", "RETURN" };

	IRStatement() {
		opcode = 0;
		setOperands(null, null, null);
	}

	public IRStatement(IRStatement statement) {
		opcode = statement.opcode;
		setOperands(statement.operand1, statement.operand2, statement.result);

	}
	
	@Override
	public String toString() {
		String s = getOpcodeText();
		
		if(operand1 != null) s += "  " + operand1.toString();
		
		if(operand2 != null) s += "  " +operand2.toString();
		
		if(result != null) s += "  " +result.toString();
		
		return s;
	}
	
	

	public byte getOpcode() {
		return opcode;
	}

	public Operand getOperand1() {
		return operand1;
	}

	public Operand getOperand2() {
		return operand2;
	}

	public Operand getResult() {
		return result;
	}

	private void setOperands(Operand operand1, Operand operand2, Operand result) {
		setOperand1(operand1);
		setOperand2(operand2);
		setResult(result);
	}

	public void setOperand1(Operand operand1) {
		if (operand1 == null)
			this.operand1 = null;
		else
			this.operand1 = new Operand(operand1);
	}

	public void setOperand2(Operand operand2) {
		if (operand2 == null)
			this.operand2 = null;
		else
			this.operand2 = new Operand(operand2);
	}

	public void setResult(Operand result) {
		if (result == null)
			this.result = null;
		else
			this.result = new Operand(result);
	}

	// opcode
	public void setToNOP() {
		opcode = 0;
		setOperands(null, null, null);
	}

	public void setToADDI(Operand operand1, Operand operand2, Operand result) {
		opcode = 1;
		setOperands(operand1, operand2, result);
	}

	public void setToADDF(Operand operand1, Operand operand2, Operand result) {
		opcode = 2;
		setOperands(operand1, operand2, result);
	}

	public void setToSUBI(Operand operand1, Operand operand2, Operand result) {
		opcode = 3;
		setOperands(operand1, operand2, result);
	}

	public void setToSUBF(Operand operand1, Operand operand2, Operand result) {
		opcode = 4;
		setOperands(operand1, operand2, result);
	}

	public void setToMULTI(Operand operand1, Operand operand2, Operand result) {
		opcode = 5;
		setOperands(operand1, operand2, result);
	}

	public void setToMULTF(Operand operand1, Operand operand2, Operand result) {
		opcode = 6;
		setOperands(operand1, operand2, result);
	}

	public void setToDIVI(Operand operand1, Operand operand2, Operand result) {
		opcode = 7;
		setOperands(operand1, operand2, result);
	}

	public void setToDIVF(Operand operand1, Operand operand2, Operand result) {
		opcode = 8;
		setOperands(operand1, operand2, result);
	}

	public void setToGT(Operand operand1, Operand operand2, Operand result) {
		opcode = 9;
		setOperands(operand1, operand2, result);
	}

	public void setToGE(Operand operand1, Operand operand2, Operand result) {
		opcode = 10;
		setOperands(operand1, operand2, result);
	}

	public void setToLT(Operand operand1, Operand operand2, Operand result) {
		opcode = 11;
		setOperands(operand1, operand2, result);
	}

	public void setToLE(Operand operand1, Operand operand2, Operand result) {
		opcode = 12;
		setOperands(operand1, operand2, result);
	}

	public void setToNE(Operand operand1, Operand operand2, Operand result) {
		opcode = 13;
		setOperands(operand1, operand2, result);
	}

	public void setToEQ(Operand operand1, Operand operand2, Operand result) {
		opcode = 14;
		setOperands(operand1, operand2, result);
	}

	public void setToJUMP(Operand result) {
		opcode = 15;
		setOperands(null, null, result);
	}

	public void setToLABEL(Operand result) {
		opcode = 16;
		setOperands(null, null, result);
	}

	public void setToREADI(Operand result) {
		opcode = 17;
		setOperands(null, null, result);
	}

	public void setToREADF(Operand result) {
		opcode = 18;
		setOperands(null, null, result);
	}

	public void setToWRITEI(Operand result) {
		opcode = 19;
		setOperands(null, null, result);
	}

	public void setToWRITEF(Operand result) {
		opcode = 20;
		setOperands(null, null, result);
	}

	public void setToWRITES(Operand result) {
		opcode = 21;
		setOperands(null, null, result);
	}

	public void setToSTOREI(Operand operand1, Operand result) {
		opcode = 22;
		setOperands(operand1, null, result);
	}

	public void setToSTOREF(Operand operand1, Operand result) {
		opcode = 23;
		setOperands(operand1, null, result);
	}

	public void setToRETURN(Operand result) {
		opcode = 24;
		setOperands(null, null, result);
	}

	public String getOpcodeText() {
		return opcodeText[opcode];
	}

}


