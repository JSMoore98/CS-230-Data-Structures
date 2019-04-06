package ABStack;

public class StackTester {

	public static void main(String[] args) {
		ABStack stack1 = new ABStack();
		ABStack stack3 = new ABStack();
		for(int i=0;i <=150; i++) {
			stack1.push(i);
		}
		for(int i=5;i <=150; i++) {
			stack3.push(i);
		}
		ABStack stack2 = new ABStack(stack1);
		System.out.println(stack1.toString());
		System.out.println(stack2.toString());
		System.out.println(stack3.toString());
		
		stack1.copy(stack3);
		ABStack stack4 = stack2.copy();
		System.out.println(stack1.toString());
		System.out.println(stack2.toString());
		System.out.println(stack4.toString());
		
		System.out.println(stack3.copy());

	}

}
