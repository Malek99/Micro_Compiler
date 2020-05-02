
public class TinyOperand {
	private char type;
	private int value;
	private float floatValue;

	public TinyOperand() {
		type = 'u';
		value = 0;
		floatValue = 0;
	}

	TinyOperand(TinyOperand operand) {
		copy(operand);
	}

	void copy(TinyOperand opernad) {
		type = opernad.type;
		value = opernad.value;
		floatValue = opernad.floatValue;
	}

	void setTofloat(float floatValue) {
		this.floatValue = floatValue;
		type = 'f';
	}

	void setToInt(int value) {
		this.value = value;
		type = 'i';
	}

	void setToRegister(int value) {
		this.value = value;
		type = 'r';
	}

	void setToMemory(int SymbolID) {
		this.value = SymbolID;
		type = 'm';
	}

	void setTolabel(int labelID) {
		this.value = labelID;
		type = 'l';
	}

	boolean isInt() {
		return type == 'i';
	}

	boolean isFloat() {
		return type == 'f';
	}

	boolean isRegister() {
		return type == 'r';
	}

	boolean isMemory() {
		return type == 'm';
	}

	boolean isLabel() {
		return type == 'l';
	}



	@Override
	public String toString() {
		switch (type) {
		case 'i': {
			return Integer.toString(value);
		}
		case 'f': {
			return Float.toString(floatValue);
		}
		case 'r': {
			return "r" + value;
		}
		case 'm': {
			return IROperand.symbolName.get(value);
		}
		case 'l': {
			return IROperand.labels.get(value);
		}
		default: {
			return "Unknown operand";
		}
		}
	}

}
