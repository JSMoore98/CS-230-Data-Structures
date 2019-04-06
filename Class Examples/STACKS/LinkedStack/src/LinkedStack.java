@SuppressWarnings("unchecked")
/**
* Each entry consists of a node, which has a data field and a link field, which has a reference to the next node
* The stack itself starts with a reference to the first node, which is null at first
* The top variable will be the last linked node
* Still uses push, pop, peek
* Can create a new link using new Node(4); Where 4 is the data in the node, and the memory address is returned to the previous node's link
* With pop, you return the data in the top link, then move top back to the previous link, so you'd have to start at the base of the stack and work back up to top-1
* The better way is to use top.next to point at the previous node, with the newest being to the left, and older node being to the right, so the node references the previous node instead of the newer node
 */
public class LinkedStack<T> {
	/**
	 * Node is a nested class so we don't need two files
	 */
	private class Node<T> {
		private T data;
		//References another Node class object, called self-referential
		private Node<T> next;
		
		public Node(T data) {
			this.data = data;
			this.next = null;
		}
	}
	
	Node<T> top;
	
	public LinkedStack() {
		top = null;
	}
	
	//Can create a new link using new Node(4); Where 4 is the data in the node, and the memory address is returned to the previous node's link.
	//This would be very inefficient, the other solution is to set top = newNode;, newNode.next = top;, 
	//top = newNode;... repeat to be more efficient, so that the newer node is pointing to the older one instead
	public void push(T data) {
		Node<T> newNode = new Node(data);
		if (isEmpty())
			top = newNode;
		else {
			newNode.next = top;
			top = newNode;
		}
	}
	
	public T pop() {
		T data = null;
		if (isEmpty()) {
			System.out.println("The stack is empty");
			return data;
		}
		data = top.data;
		top = top.next;
		return data;
	}
	
	public T peek() {
		if (isEmpty()) {
			System.out.println("The stack is empty");
			return null;
		}
		return top.data;
	}
	
	public boolean isEmpty() {
		return(top == null);
	}
	
	public String toString() {
		String str = "";
		Node<T> tempTop = top;
		
		while(tempTop != null) {
			str = str + tempTop.data + " ";
			tempTop = tempTop.next;
		}
			
		return str;
	}
}
