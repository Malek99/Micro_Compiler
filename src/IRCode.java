import java.util.Iterator;

public class IRCode implements Iterable<IRStatement>{
	private class Node {
		IRStatement statement;
		Node next;
		
		Node(IRStatement statement) {
			this.statement = new IRStatement(statement);
		}
	}

	Node first, last;
	
	
	public IRCode() {
		first = last = null;
	}
	
	public void insertBeforeCode(IRStatement statement) {
		if(isEmpty())
		{
			first = new Node(statement);
		}
		else
		{
			Node node = new Node(statement);
			node.next = first;
			first = node;
		}
	}
	
	public void insertAfterCode(IRStatement statement) {
		if(isEmpty())
		{
			first = new Node(statement);
			last = first;
		}
		else
		{
			last.next = new Node(statement);
			last = last.next;
		}
	}
	
	public void insertBeforeCode(IRCode code) {
		code.last.next = first;
		first = code.first;
	}
	
	public void insertAfterCode(IRCode code) {
		if(isEmpty())
		{
			first = code.first;
		}
		else
		{
			last.next = code.first;			
		}
		
		last = code.last;
	}
	
	@Override
	public Iterator<IRStatement> iterator() {
		Iterator<IRStatement> it = new Iterator<IRStatement>() {
			
			Node ptr = first;
			
			
			@Override
			public IRStatement next() {
				IRStatement statement = ptr.statement;
				ptr = ptr.next;
				return statement;
			}
			
			
			@Override
			public boolean hasNext() {
				return ptr != null;
			}
			
		};
		return it;
	}
	
	
	public boolean isEmpty() {
		return first == null;
	}
	
	
	
	public void clear() {
		first = last = null;
	}
	
}
