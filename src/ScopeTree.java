import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;

public class ScopeTree {

	private class Scope {
		String name;

		LinkedList<Scope> children;
		Scope parent;

		Iterator<Scope> childrenIterator;

		SymbolTable symbolTable;

		public Scope(String name) {
			this.name = name;
			children = new LinkedList<Scope>();
			parent = null;
			symbolTable = new SymbolTable();
		}

		public void resetIterator() {
			childrenIterator = children.iterator();
		}

	}

	private Scope root, currentScope;
	private int blockID, numberOfSymbols;

	public ScopeTree() {
		root = new Scope("Global");
		currentScope = root;
		blockID = 1;
		numberOfSymbols = 0;
	}

	public void openScope() {
		String name = "BLOCK #" + blockID;
		blockID++;
		openScope(name);
	}

	public void openScope(String name) {
		Scope newScope = new Scope(name);
		newScope.parent = currentScope;
		currentScope.children.add(newScope);
		currentScope = newScope;
	}

	public void closeScope() {
		if(currentScope != null)
			currentScope = currentScope.parent;
	}

	public void enterSymbol(String name, SymbolInfo info) {
		numberOfSymbols++;
		currentScope.symbolTable.addSymbol(name, new SymbolInfo(info, numberOfSymbols));
	}

	public SymbolInfo retrieveSymbol(String name) {
		Scope ptr = currentScope;

		while (ptr != null) {
			SymbolInfo info = ptr.symbolTable.getSymbolInfo(name);

			if (info != null)
				return info;

			ptr = ptr.parent;
		}
		return null;
	}

	public SymbolInfo declaredLocally(String name) {
		SymbolInfo info = currentScope.symbolTable.getSymbolInfo(name);
		return info;
	}

	public void openRootScope() {
		resetPointer(root);
		currentScope = root;
	}

	private void resetPointer(Scope root) {
		Iterator<Scope> it = root.children.iterator();
		while (it.hasNext()) {
			resetPointer(it.next());
		}
		root.resetIterator();
	}

	public boolean hasNextScope() {
		return currentScope != null;
	}
	
	public void moveToNextScope() {
		while (currentScope.childrenIterator.hasNext() == false) {
			currentScope = currentScope.parent;

			if (currentScope == null)
				return;
		}

		currentScope = currentScope.childrenIterator.next();
	}

	public SymbolTable getSymbolTable() {
		return currentScope.symbolTable;
	}
	
	public String getScopeName() {
		return currentScope.name;
	}
	
	public Hashtable<Integer, String> getGlobalSymbols() {
		Hashtable<Integer, String> table = new Hashtable<Integer, String>();
		
		LinkedList<Symbol> symbols =  root.symbolTable.getAllSymbols();
		Iterator<Symbol> it = symbols.iterator();
		while(it.hasNext()) {
			Symbol symbol = it.next();
			table.put(symbol.info.getID(), symbol.name);
		}
		
		return table;
	}

}
