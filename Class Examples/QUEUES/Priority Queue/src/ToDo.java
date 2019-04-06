/**
 * Creates task objects to create a ToDo list as a priority queue
 */
public class ToDo {

	public static void main(String[] args) {

		PQueue<Task> toDoList = new PQueue<Task>();
		
		toDoList.enqueue( new Task( "Take out trash", 'B', 1));
		toDoList.enqueue( new Task( "Go to the Movies", 'C', 1));
		toDoList.enqueue( new Task( "Do Homework", 'B', 2));
		toDoList.enqueue( new Task( "Do the Dishes", 'A', 1));
		toDoList.enqueue( new Task( "Play Video Games", 'C', 3));
		toDoList.enqueue( new Task( "Program", 'C', 2));

		while( !toDoList.isEmpty())
				System.out.println( toDoList.dequeue());
	}

}
