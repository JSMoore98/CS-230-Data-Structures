@SuppressWarnings("unchecked")

/**
* insertAtFront() * insertAtBack() * insertBefore/After() //Either before or after works, up to you
* removeFromFront() * removeFromBack() * remove() //Removes a specific item that's in the middle
* find //finds a specific item that you are looking for and gets the location, not required but useful
* Other usual data structure methods (peek, copy, toString, isFull/Empty, etc.)
 */

public class ABList<T> {

	private T [] list;
	private int location;
	private boolean found;
	private int itemsCount;
	private final int DEFAULTCAP = 20;
	
	public ABList() {
		
		location = 0;
		found = false;
		itemsCount = 0;
		list = (T[]) new Object[DEFAULTCAP];
	}

	public ABList( int capacity) {
		
		location = 0;
		found = false;
		itemsCount = 0;
		
		if( capacity > 0)
			list = (T[]) new Object[capacity];
		else {
			System.out.println( "Invalid capacity given. The default capacity is being used instead.");
			list = (T[]) new Object[DEFAULTCAP];
		}
	}

	//Note that it's private
	private void find( T target) {
		
		location = 0;
		found = false;
		
		//Just uses linear search, binary search would be more efficient
		while( location < itemsCount) {
			if( list[location].equals( target)) {
				found = true;
				return;
			}
			else
				location++;
		}
		
		return;
	}

	public int size() {
		
		return itemsCount;
	}

	public boolean isFull() {
		
		return( itemsCount == list.length);
	}

	public boolean isEmpty() {
		
		return( itemsCount == 0);
	}
	
	public int indexOf( T element) {
		
		find( element);
		
		if( found)
			return location;
		else
			return -1;
	}

	public boolean contains( T element) {
		
		find( element);
		
		if( found)
			return true;
		else
			return false;
	}

	public void reset() {
		
		location = 0;
		found = false;
		itemsCount = 0;
		list = (T[]) new Object[DEFAULTCAP];
		return;
	}
	
	public void set( T element, int index) {
		
		if( index >= 0 && index <= itemsCount) {
			list[index] = element;
		}
		else
			System.out.println( "Invalid index.");
		
		return;
	}
	
	public T get( int index) {
		
		if( isEmpty()) {
			System.out.println( "List is empty.");
			return null;
		}
		
		if( index < 0 || index >= itemsCount) {
			System.out.println( "Invalid index.");
			return null;
		}
		
		return list[index];
	}

	private void enlargeList() {
		int newSize = itemsCount + 10;
		T[] newList = (T[]) new Object[newSize];
		for(int i=0; i < itemsCount ; i++)
			newList[i] = list[i];
		list = newList;
	}
	
	public boolean insert( T element) {
		
		if( isFull()) {			
			enlargeList();
		}
		list[itemsCount] = element;
		itemsCount++;
		return true;
	}

	public void insert( T element, int index) {
	
		if( index < 0) {
			System.out.println( "Invalid index.");
			return;
		}
		
		if( isFull()) {
			enlargeList();
		}		
		
		if(index >= itemsCount) {
			list[itemsCount] = element;
			itemsCount++;
			return;
		}
		
		for(int i = itemsCount ; i > index ; i-- )
			list[i] = list[i-1];	
		
		list[index] = element;
		itemsCount++;	
		
		return;
	}

	public void remove( int index) {
		
		if( isEmpty()) {
			System.out.println( "List is empty.");
			return;
		}
		
		if( index < 0 || index >= itemsCount) {
			System.out.println( "Invalid index.");
			return;
		}
		
		for( int i = index ; i < itemsCount-1 ; i++) 
			list[i] = list[i+1];
	
		itemsCount--;
		return;

	}

	public boolean remove( T element) {
		
		if( isEmpty()) {
			System.out.println( "List is empty.");
			return false;
		}
		
		find( element);
		
		if( found)
			for( int i = location ; i < itemsCount-1 ; i++) 
				list[i] = list[i+1];
		
		itemsCount--;
		
		return true;
	}

	public String toString() {
		
		String str = "[";
		
		for( int index = 0 ; index < itemsCount ; index++ )
			str = str + list[index] + " ";
		str += "]";
		
		return str;
	}

}
