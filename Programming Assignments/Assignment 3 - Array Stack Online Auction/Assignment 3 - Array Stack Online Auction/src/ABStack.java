@SuppressWarnings("unchecked")
public class ABStack<T>{

	private T[] stack;
	int top;
	final int CAPACITY = 10;
	
	public ABStack() {
		top = -1;
		stack = (T[]) new Object[CAPACITY];
	}
	
	public ABStack(int capacity) {
		if(capacity <= 0) {
			System.out.println("Invalid capactiy provides. Default capacity will be used");
			stack = (T[]) new Object[CAPACITY];
		}
		else
			stack = (T[]) new Object[CAPACITY];
		
		top = -1;
	}
	
	public ABStack(ABStack other) {
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
		if (stack.length - 1 == top)
			return true;
		return false;
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public T pop() {
		if (isEmpty()) {
			System.out.println("Error, the stack is empty.");
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
			return null;
		}
		else
			return stack[top];
	}
	
	public String toString() {
		String str = "[";
		
		for (int i=0; i <= top; i++)
			str = str + stack[i] + ", ";
		str += "]";
		
		return str;
	}
	
	public ABStack copy() {
		return new ABStack(this);
	}
}
