
public class IRStatement {

	public enum Opcode {
		NOP, ADDI, ADDF, SUBI, SUBF, MULTI, MULTF, DIVI, DIVF, GT, GE, LT, LE, NE, EQ, JUMP, LABEL, READI, READF,
		WRITEI, WRITEF, WRITES, STOREI, STOREF, RETURN
	}

	//private byte opcode;
	Opcode opcode;
	private IROperand operand1, operand2, result;
	

	IRStatement() {
		opcode = Opcode.NOP;
		setOperands(null, null, null);
	}

	public IRStatement(IRStatement statement) {
		opcode = statement.opcode;
		setOperands(statement.operand1, statement.operand2, statement.result);

	}

	@Override
	public String toString() {
		String s = getOpcodeText();

		if (operand1 != null)
			s += "  " + operand1.toString();

		if (operand2 != null)
			s += "  " + operand2.toString();

		if (result != null)
			s += "  " + result.toString();

		return s;
	}

	public Opcode getOpcode() {
		return opcode;
	}

	public IROperand getOperand1() {
		return operand1;
	}

	public IROperand getOperand2() {
		return operand2;
	}

	public IROperand getResult() {
		return result;
	}

	private void setOperands(IROperand operand1, IROperand operand2, IROperand result) {
		setOperand1(operand1);
		setOperand2(operand2);
		setResult(result);
	}

	public void setOperand1(IROperand operand1) {
		if (operand1 == null)
			this.operand1 = null;
		else
			this.operand1 = new IROperand(operand1);
	}

	public void setOperand2(IROperand operand2) {
		if (operand2 == null)
			this.operand2 = null;
		else
			this.operand2 = new IROperand(operand2);
	}

	public void setResult(IROperand result) {
		if (result == null)
			this.result = null;
		else
			this.result = new IROperand(result);
	}

	// opcode
	public void setToNOP() {
		opcode = Opcode.NOP;
		setOperands(null, null, null);
	}

	public void setToADDI(IROperand operand1, IROperand operand2, IROperand result) {
		opcode = Opcode.ADDI;
		setOperands(operand1, operand2, result);
	}

	public void setToADDF(IROperand operand1, IROperand operand2, IROperand result) {
		opcode = Opcode.ADDF;
		setOperands(operand1, operand2, result);
	}

	public void setToSUBI(IROperand operand1, IROperand operand2, IROperand result) {
		opcode = Opcode.SUBI;
		setOperands(operand1, operand2, result);
	}

	public void setToSUBF(IROperand operand1, IROperand operand2, IROperand result) {
		opcode = Opcode.SUBF;
		setOperands(operand1, operand2, result);
	}

	public void setToMULTI(IROperand operand1, IROperand operand2, IROperand result) {
		opcode = Opcode.MULTI;
		setOperands(operand1, operand2, result);
	}

	public void setToMULTF(IROperand operand1, IROperand operand2, IROperand result) {
		opcode = Opcode.MULTF;
		setOperands(operand1, operand2, result);
	}

	public void setToDIVI(IROperand operand1, IROperand operand2, IROperand result) {
		opcode = Opcode.DIVI;
		setOperands(operand1, operand2, result);
	}

	public void setToDIVF(IROperand operand1, IROperand operand2, IROperand result) {
		opcode = Opcode.DIVF;
		setOperands(operand1, operand2, result);
	}

	public void setToGT(IROperand operand1, IROperand operand2, IROperand result) {
		opcode = Opcode.GT;
		setOperands(operand1, operand2, result);
	}

	public void setToGE(IROperand operand1, IROperand operand2, IROperand result) {
		opcode = Opcode.GE;
		setOperands(operand1, operand2, result);
	}

	public void setToLT(IROperand operand1, IROperand operand2, IROperand result) {
		opcode = Opcode.LT;
		setOperands(operand1, operand2, result);
	}

	public void setToLE(IROperand operand1, IROperand operand2, IROperand result) {
		opcode = Opcode.LE;
		setOperands(operand1, operand2, result);
	}

	public void setToNE(IROperand operand1, IROperand operand2, IROperand result) {
		opcode = Opcode.NE;
		setOperands(operand1, operand2, result);
	}

	public void setToEQ(IROperand operand1, IROperand operand2, IROperand result) {
		opcode = Opcode.EQ;
		setOperands(operand1, operand2, result);
	}

	public void setToJUMP(IROperand result) {
		opcode = Opcode.JUMP;
		setOperands(null, null, result);
	}

	public void setToLABEL(IROperand result) {
		opcode = Opcode.LABEL;
		setOperands(null, null, result);
	}

	public void setToREADI(IROperand result) {
		opcode = Opcode.READI;
		setOperands(null, null, result);
	}

	public void setToREADF(IROperand result) {
		opcode = Opcode.READF;
		setOperands(null, null, result);
	}

	public void setToWRITEI(IROperand result) {
		opcode = Opcode.WRITEI;
		setOperands(null, null, result);
	}

	public void setToWRITEF(IROperand result) {
		opcode = Opcode.WRITEF;
		setOperands(null, null, result);
	}

	public void setToWRITES(IROperand result) {
		opcode = Opcode.WRITES;
		setOperands(null, null, result);
	}

	public void setToSTOREI(IROperand operand1, IROperand result) {
		opcode = Opcode.STOREI;
		setOperands(operand1, null, result);
	}

	public void setToSTOREF(IROperand operand1, IROperand result) {
		opcode = Opcode.STOREF;
		setOperands(operand1, null, result);
	}

	public void setToRETURN(IROperand result) {
		opcode = Opcode.RETURN;
		setOperands(null, null, result);
	}

	public String getOpcodeText() {
		return opcode.name();
	}

}
