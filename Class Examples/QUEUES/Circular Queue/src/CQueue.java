@SuppressWarnings("unchecked")

/**
*Queue using an array where the front moves up the array, then back of queue is moved around the array inserting items, 
*where it goes up until it loops around behind front, where it is full at that point, so you don't need to shift array 
*elements back to starting at index 0 each time you pop, it's more efficient
*
* Uses the <T> generic data type:
* Enqueue: Adds the element to the back of the queue, "push". In a circular queue, the back can now wrap around to the beginning of the queue to fill empty cells behind it.
    * Can be done using (back + 1) % length
* Dequeue: Removes the first element from the front of the queue, or whatever has priority, "pop"
* PeekAtFront: Returns the first element in the queue without removing it
* peekAtBack: Returns the last element in the queue at the back without removing it
* toString: To display entire queue
* isEmpty/isFull
* A new field size will be used in a circular queue to test whether the queue is empty, "0", or full "!0".
 */
public class CQueue<T> {

	private int back;
	private int front;
	private int size;
	private T[] queue;

	public CQueue() {

		back = 0;
		front = 0;
		size = 0;
		queue = (T[]) new Object[100];
	}

	public CQueue(int capacity) {

		back = 0;
		front = 0;
		size = 0;
		if (capacity > 0)
			queue = (T[]) new Object[capacity];
		else
			queue = (T[]) new Object[1000];
	}

	public void enqueue(T element) {

		if (isFull()) {
			T[] newQueue = (T[]) new Object[queue.length + 50];
			for (int i = 0; i < queue.length; i++)
				newQueue[i] = queue[i];
			back = queue.length;
			queue = newQueue;
		}
		
		queue[back] = element;
		back = (back+1) % queue.length;
		size++;
		return;
	}

	public T dequeue() {

		T item = null;

		if (isEmpty()) {
			System.out.println("Empty queue...");
			return item;
		}

		item = queue[front];
		front = (front+1) % queue.length;
		size--;
		return item;
	}

	public T peekAtFront() {

		T frontItem = null;

		if (isEmpty()) {
			System.out.println("Queue is empty");
			return frontItem;
		}

		frontItem = queue[front];

		return frontItem;
	}

	public T peekAtBack() {

		T backItem = null;

		if (isEmpty()) {
			System.out.println("Queue is empty");
			return backItem;
		}

		if(back == 0)
			backItem = queue[queue.length-1];
		else
			backItem = queue[back - 1];

		return backItem;
	}

	public String toString() {

		String str = "[ ";
		
		if (isEmpty()) {
			System.out.println("Queue is empty");
			str += "]";
			return str;
		}
		
		if (front < back)
			for (int index = front; index < back; index++)
				str = str + queue[index] + " ";
		else {
			int index = front;
			while(index < queue.length) {
				str = str + queue[index] + " ";
				index++;
			}
			for (index = 0; index < back; index++)
				str = str + queue[index] + " ";
		}

		str += "]";

		return str;
	}

	public int size() {

		return (size);
	}

	public boolean isFull() {

		return (size == queue.length);
	}

	public boolean isEmpty() {

		return (size == 0);
	}
}
