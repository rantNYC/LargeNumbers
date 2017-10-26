
/**
 * Friendly class Node
 * @author Rafael Ninalaya
 * @param Node 
 * @param element 
 */
public class Node {
	private int element;
	private Node next;
	
	//constructor
	Node(){
		this(0,null);
	}

	//constructor
	public Node(int e, Node n) {
		element = e;
		next = n;
	}
	
	//update methods
	void setElement(int newElement){
		element = newElement;
	}
	
	void setNext(Node newNext){
		next = newNext;
	}
	
	//get methods 
	int getElement(){
		return element;
	}
	
	Node getNext(){
		return next;
	}
}
