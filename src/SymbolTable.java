import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;

public class SymbolTable {
	private Hashtable<String, SymbolInfo> table;
	
	public SymbolTable() {
		table = new Hashtable<String, SymbolInfo>();
	}

	public void addSymbol(String name, SymbolInfo info) {
		table.put(name, info);
	}

	public SymbolInfo getSymbolInfo(String name) {
		return table.get(name);
	}
	
	public LinkedList<Symbol> getAllSymbols() {
		Enumeration<String> e = table.keys();
		LinkedList<Symbol> list = new LinkedList<Symbol>();
		while(e.hasMoreElements())
		{
			String key = e.nextElement();
			list.add(new Symbol(key, table.get(key)));
		}
		
		return list;
	}
	
	@Override
	public String toString() {
		String s = "";
		
		LinkedList<Symbol> list = getAllSymbols();
		Iterator<Symbol> it = list.iterator();
		while(it.hasNext())
		{
			Symbol symbol = it.next();
			s = s + symbol.toString() + "\n";
		}
		return s;
	}
}


class Symbol {
	String name;
	SymbolInfo info;
	public Symbol(String name, SymbolInfo info) {
		this.name = name;
		this.info = info;
	}
	
	@Override
	public String toString() {
		String s = "name " + name + " type " + info.getTypeName();
		if(info instanceof Str_Info)
			s = s + " value " + ((Str_Info) info).getString();
		return s;
	}
}

class SymbolInfo {
	private char type;
	
	
	public SymbolInfo() {
		type = 'u';
	}
	
	SymbolInfo(SymbolInfo type) {
		if(type.isString())
			setTypeToString();
		else if(type.isInt())
			setTypeToInt();
		else if(type.isFloat())
			setTypeToFloat();
		else
			this.type = 'u';
	}
	

	public void setTypeToString() {
		type = 's';
	}
	
	public void setTypeToInt() {
		type = 'i';
	}
	
	public void setTypeToFloat() {
		type = 'f';
	}
	
	public boolean isString() {
		return type == 's';
	}
	
	public boolean isInt() {
		return type == 'i';
	}
	
	public boolean isFloat() {
		return type == 'f';
	}


	public String getTypeName() {
		String s;

		switch (type) {
		case 's':
			s = "STRING";
			break;
		case 'i':
			s = "INT";
			break;
		case 'f':
			s = "FLOAT";
			break;
		default:
			s = "Undefined";
		}
		
		return s;
	}
}

class Str_Info extends SymbolInfo {
	private String value;

	public Str_Info(String value) {
		setTypeToString();
		this.value = value;
	}

	public String getString() {
		return value;
	}
}