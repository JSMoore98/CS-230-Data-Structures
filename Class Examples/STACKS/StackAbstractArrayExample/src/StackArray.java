@SuppressWarnings("unchecked")
/**
 * Implements a stack using an array to show limitations and uses of
 * making a stack with an array
 * Will have an array as the main data field
 * Then it needs push, pop, and peek methods that only work on the top of the stack
 * This means we need to always identify the top of the stack
 * In this case we'll use the largest index element the top
 * It also needs to check if the stack is empty, and if it's full 
 * otherwise trying to pop or push if empty or full would throw an error
 * -Josiah Moore 2/1/19
 */

//Use this to import the generic data type
public class StackArray <T> {
	//T is a generic data type that can be defined in the driver	
	private T[] stack;
	int top;
	final int CAPACITY = 10;
	
	public StackArray() {
		top = -1;
		//Declares the array as object type, nucleus for data types, everything extends it
		//Then you cast that to the generic data type T
		stack = (T[]) new Object[CAPACITY];
	}
	
	public StackArray(int capacity) {
		if(capacity <= 0) {
			System.out.println("Invalid capactiy provides. Default capacity will be used");
			stack = (T[]) new Object[CAPACITY];
		}
		else
			stack = (T[]) new Object[CAPACITY];
		
		top = -1;
	}
	
	public StackArray(StackArray other) {
		top = other.top;
		stack = (T[]) new Object[top+10];
		for (int i=0; i <= top; i++) {
			stack[i]=(T) other.stack[i];
		}
	}
	
	public void push (T item) {
		if (isFull(top, stack)) {
			int newSize = top + 1 + CAPACITY;
			T[] newStack = (T[]) new Object[newSize];
			
			for(int i = 0; i <= top; i++) {
				newStack[i] = stack[i];
			}
			
			stack = newStack;
		}
		top++;
		stack[top] = item;
	}
	
	public boolean isFull(int top, T[] stack) {
		//A conditional statement returns true or false, so alternative:
		//return (stack.length-1 == top);
		if (stack.length - 1 == top)
			return true;
		return false;
	}
	
	public boolean isEmpty() {
		//Returns either true or false
		return (top == -1);
	}
	
	public T pop() {
		if (isEmpty()) {
			System.out.println("Error, the stack is empty.");
			//Keeps you from having to return a T object
			return null;
		}
		else {
			top --;
			return stack[top+1];
		}
	}
	
	public T peek() {
		if (isEmpty()) {
			System.out.println("Error, the stack is empty.");
			//Keeps you from having to return a T object
			return null;
		}
		else
			return stack[top];
	}
	
	//This method is just for testing, wouldn't be in the actual program
	//Normally nobody should be able to see all the items, only what's on top
	public String toString() {
		String str = "[";
		
		for (int i=0; i <= top; i++)
			str = str + stack[i] + ", ";
		str += "]";
		
		return str;
	}
	
	public StackArray copy() {
		return new StackArray(this);
	}
	
}
