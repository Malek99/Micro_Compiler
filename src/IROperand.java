import java.util.Hashtable;

class IROperand {
	private char type;
	private int value;
	private float floatValue;
	private boolean isInt;

	public static Hashtable<Integer, String> labels;
	public static Hashtable<Integer, String> symbolName;

	public IROperand() {
		type = 'u'; // undefined
		value = 0;
		floatValue = 0;
		isInt = false;
	}
	
	public IROperand(IROperand operand) {
		copy(operand);
	}
	
	
	public static void setLabels(Hashtable<Integer, String> labels) {
		IROperand.labels = labels;
	}

	public static void setSymbolName(Hashtable<Integer, String> symbolName) {
		IROperand.symbolName = symbolName;
	}


	public int getValue() {
		return value;
	}
	
	public float getFvalue() {
		return floatValue;
	}

	public void setToIntType() {
		isInt = true;
	}
	
	public void setToFloatType() {
		isInt = false;
	}
	
	public boolean isIntType() {
		return isInt;
	}
	
	public boolean isFloatType() {
		return isInt == false;
	}

	private void setValue(int value) {
		this.value = value;
	}

	private void setValue(float floatValue) {
		this.floatValue = floatValue;
	}
	
	public void setToIntegerImmediate(int intValue) {
		type = 'i';
		setToIntType();
		setValue(intValue);
	}
	
	public void setToFloatImmediate(float floatValue) {
		type = 'f';
		setToFloatType();
		setValue(floatValue);
	}

	public void setToSymbol(int symbolID, boolean isInt) {
		type = 's';
		if(isInt) setToIntType();
		else setToFloatType();
		setValue(symbolID);
	}

	public void setToTemporary(int tmpID, boolean isInt) {
		type = 't';
		if(isInt) setToIntType();
		else setToFloatType();
		setValue(tmpID);
	}

	public void setToLabel(int labelID) {
		type = 'l';
		setValue(labelID);
	}

	public boolean isIntegerImmediate() {
		return type == 'i';
	}

	public boolean isFloatImmediate() {
		return type == 'f';
	}
	
	public boolean isSymbol() {
		return type == 's';
	}

	public boolean isTemporary() {
		return type == 't';
	}

	public boolean isLabel() {
		return type == 'l';
	}

	
	public void copy(IROperand operand) {
		type = operand.type;
		value = operand.value;
		floatValue = operand.floatValue;
		isInt = operand.isInt;
	}
	
	
	@Override
	public String toString() {
		String s;
		
		if (isIntegerImmediate())
			s = Integer.toString(value);
		else if(isFloatImmediate())
			s = Float.toString(floatValue);
		else if (isLabel())
			s = labels.get(value);
		else if (isSymbol())
			s = symbolName.get(value);
		else
			s = "$T" + value;
		
		return s;
	}
}