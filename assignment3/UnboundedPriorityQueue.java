/*
 * This class will use (by composition) a MinHeap. The implementation
 *  must not be restricted/fixed in a particular size/capacity and it
 *  must seamlessly work with rest of the program provided.
 */

public class UnboundedPriorityQueue<T extends Comparable<T>> extends MinHeap<T>{

	/*
	 * Default constructor. */
	public UnboundedPriorityQueue() {
		super();	// calls its superclass MinHeap's constructor
	}

	/*
	 * Insert the given T value to the front of the list. */
	public void enqueue(T value) {
		super.insert(value);	// calls its superclass MinHeap's insert()
	}

	/*
	 * Remove the element in the front of the list and return
	 *  the removed value.
	 *
	 * @return the removed value*/
	public T dequeue() {
		T value = super.remove();	// calls its superclass MinHeap's remove()
		return value;	// return the removed value
	}

	/*
	 * Check if the the list is empty and return a boolean
	 *  result accordingly.
	 *
	 * @return true for the list is empty
	 * 			false otherwise */
	public boolean isEmpty() {
		boolean result = super.isEmpty();	// calls its superclass MinHeap's isEmpty()
		return result;	// return whether empty or not
	}

	public int size() {
		int size = super.size();
		return size;
	}
}
