import java.util.LinkedList;
import java.util.NoSuchElementException;

/*
 * QueueBT<T> is an implementation of a LinkedList
 *  using JAVA's LinkedList API.
 */
public class QueueBT<T> {
	
	/*
	 * Initialize the instance variable list of type LinkedList<T>.
	 */
	private LinkedList<T> list;

	/*
	 * The constructor of QueueBT to build a new LinkedList<T>.
	 */
	public QueueBT() {
		list = new LinkedList<T>();	/*	assign list to be a new generic LinkedList<T> */
	}

	/*
	 * Adds the given value to the end of the list.
	 *
	 * @param value the desired value to insert
	 */
	public void enqueue(T value) {
		list.add(value);	/*	make use of LinkedList API's add method
									add() inserts the given element to the end of the list */
	}

	/*
	 * Removes the first value in list and returns it.
	 *
	 * @return the item that was removed
	 */
	public T dequeue() {
		try {	/*	try to remove */
			T value = list.removeFirst();	/*	make use of LinkedList API's removeFirst method
														removeFirst() removes and returns the first element
														from the list */
			return value;	/*	return the value removed */
		} catch(IndexOutOfBoundsException e) {	/*	if error, catch IndexOutOfBoundsException */
			throw new NoSuchElementException(); /*	throw NoSuchElementException */
		}
	}

	/*
	 * Returns the size of the list.
	 *
	 * @return the the number of elements in the list.
	 */
	public int getSize() {
		int size = list.size();	/*	make use of LinkedList API's size method
											size() returns the number of elements in the list */
		return size;
	}

	/*
	 * Returns whether the list is empty or not.
	 *
	 * @return true if list is empty,
	 * 			false otherwise.
	 */
	public boolean isEmpty() {
		boolean empty = true;	/*	boolean to be returned */
		if(list.peekFirst() != null) {	/*	make use of LinkedList API's peekFirst method
														peekFirst() returns the first element of the list,
														otherwise null if the list is empty */
			empty = false;	/*	list is not empty */
		}
		return empty;	/* return boolean for isEmpty() */
	}
}
