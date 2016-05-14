/*
 * An Vo
 * CSCI 2125-001
 * 05 September 2015
 * Assignment 1 Part 1 "SinglyLinkedList.java"
 */

import java.lang.Iterable;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.IndexOutOfBoundsException;
import java.lang.UnsupportedOperationException;

public class SinglyLinkedList<AnyType> {// implements Iterable<AnyType> {

	/* Initialize the head, tail and size */
	private Node<AnyType> head, tail;
	private int size;
	
	/* Constructor for SinglyLinkedList */
	public SinglyLinkedList() {
		clear();	// build an empty SinglyLinkedList
	}

	/*
	 * Add a given element to the end of the list.
	 * @param element, the element to add.
	 */
	public void add(AnyType element) {
		insertAt(element, size);	// calls insertAt to add element at end of list
	}	// end add method

	/*
	 * Inserts a given element at a given index of the list.
	 * Counting starts with zero from the list.
	 *
	 * @param element, the element to insert.
	 * @param index, the index at where element is inserted.
	 * @throws IndexOutOfBoundsException if(index < 0 || index > size)
	 */
	public void insertAt(AnyType element, int index) {

		if(index < 0 || index > size) {	// if index is out of bounds
			throw new IndexOutOfBoundsException();
		}

		else if(index == 0) {	// insert element to front (head) of list
			if(isEmpty()) {	// if list == isEmpty(), add a head/tail
				head = new Node<AnyType>(element, null);
				tail = head;
				size++;	// increment size
//				System.out.println("head: " + head.data + ", tail: " + tail.data + ", size: " + size);	
			}
			else {
				Node<AnyType> tempHead = head;	//	temporarily store head
				head = new Node<AnyType>(element, tempHead);	// element inserted at front (head)
				size++;	// increment size
				if(tempHead.next == null) {
					tail = tempHead;	// set tail
				}
				else {
					while(tempHead.next != null) {	// assure tail is set
						tempHead = tempHead.next;
						if(tempHead.next == null) {
							tail = tempHead;	// set tail
						}
					}
				}
//				System.out.println("Inserting at front...\nhead: " + head.data + ", head's next: " + head.next.data + ", tail: " + tail.data + ", size: " + size);
			}
		}	// end (index == 0)

		else if(index == size) {	// add element to end of list
			if(tail != null) {
				tail.next = new Node<AnyType>(element, null);
			}
			tail = tail.next;	// element added to end of list
			size++;	// increment size
			Node<AnyType> tempHead = head;
			while(tempHead.next != null) {	// assure tail is set
				tempHead = tempHead.next;
				if(tempHead.next == null) {
					tail = tempHead;	// set tail
				}
			}
//			System.out.println("Inserting at end...\nhead: " + head.data + ", tail: " + tail.data + ", size: " + size);
		}	// end (index == size)

		else if(index > 0 && index < size) {	// insert element at given index between 0 and size
			Node<AnyType> tempHead = head;
			for(int i = 0; i < index - 1; i++) {
				tempHead = tempHead.next;
			}
			tempHead.next = new Node<AnyType>(element, tempHead.next);	// element inserted at given index
			size++;	// increment size
			tempHead = head;
			while(tempHead.next != null) {	// assure tail is set
				tempHead = tempHead.next;
				if(tempHead.next == null) {
					tail = tempHead;	// set tail
				}
			}
//			System.out.println("Inserting at index: " + index + "...\nhead: " + head.data + ", tail: " + tail.data + ", size: " + size);
		}	// end (0 < index < size)

	}	// end insertAt method

	/*
	 * Remove the first occurrence of the given element from the list.
	 *
	 * @param element, the element to remove.
	 * @throws NoSuchElementException if element does not exist.
	 */
	public void remove(AnyType element) {
		if(isEmpty()) {	// the list is empty, nothing to remove
			throw new NoSuchElementException();
		}

		boolean found = false;
		Node<AnyType> tempHead = head;
		while(tempHead != null && found == false) {	// traverse the list
			if(tempHead.data.equals(element)) {	// if head.data == element to remove
				if(size == 1) {	// if(head is the only element)
					clear();	// clear the list, head is removed
					if(isEmpty()) {
//						System.out.println("Removing: " + element + ", the list is cleared " + ", size: " + size);
						found = true;	// exit while loop
					}
				}
				else {	// head == element to remove && size > 1
					head = tempHead.next;	// head removed, set new head as previous head's next
					size--;	// decrement size
					tempHead = head;
					while(tempHead.next != null) {	// assure tail is set
						tempHead = tempHead.next;
						if(tempHead.next == null) {
							tail = tempHead;	// set tail
						}
					}
//					System.out.println("Removing: " + element + ", head: " + head.data + ", tail: " + tail.data + ", size: " + size);
					found = true;	// exit while loop
				}
			}

			else {	// head.data != element to remove
				Node<AnyType> temp2;
				while(tempHead.next != null || found == false) {	// traverse the list
					temp2 = tempHead;
					tempHead = tempHead.next;
					if(!(temp2.data.equals(element)) && !(tempHead.data.equals(element)) && tempHead.next == null) {
						throw new NoSuchElementException();
					}
					else if(tempHead.next.next == null && tempHead.next.data.equals(element)) {	// tail == element to remove
						tail = tempHead;	// update tail
						tail.next = null;
						size--;	// decrement size						
						tempHead = head;
						while(tempHead.next != null) {	// assure tail is set
							tempHead = tempHead.next;
							if(tempHead.next == null) {
								tail = tempHead;	// set tail
							}
						}
//						System.out.println("Removing: " + element + ", head: " + head.data + ", tail: " + tail.data + ", size: " + size);
						found = true;	// exit while loop
					}
					else if(tempHead.data.equals(element)) {	// if temphead.data (by iteration) == element to remove by
						temp2.next = tempHead.next;	//	adjust temp2's next to point to its next next
						size--;	// decrement size
						tempHead = head;
						while(tempHead.next != null) {	// assure tail is set
							tempHead = tempHead.next;
							if(tempHead.next == null) {
								tail = tempHead;	// set tail
							}
						}
//						System.out.println("Removing: " + element + ", head: " + head.data + ", tail: " + tail.data + ", size: " + size);
						found = true;	// exit while loop
					}
				}
			}
		}	// end main while loop
	}	// end remove method

	/*
	 * Remove all elements from the list.
	 */
	public void clear() {
		head = tail = null;
		size = 0;
		}
	
	/*
	 * Return true if the list is empty, false otherwise.
	 */
	public boolean isEmpty() {
		boolean result = false;
		if(head == null && size == 0) {
			result = true;
			return result;
		}
		return result;
	}	// end isEmpty method

	/*
	 * Return the number of elements currently in the list.
	 */
	public int size() {
		return size;
	}	// end size method

	/*
	 * Return the nth value from the first (count starts with zero).
	 *
	 * @param n, the index of the value from the first to return.
	 * @throws IndexOutOfBoundsException if(n < 0 || n > size).
	 */
	public AnyType getNthFromFirst(int n) {
		if(n < 0 || n >= size) {	// if index is out of bounds
			throw new IndexOutOfBoundsException();
		}

		Node<AnyType> tempHead = head;
		for(int i = 0; i < n; i++) {	// search for the node
			tempHead = tempHead.next;
		}

		return tempHead.data;	// return data
	}

	/*
	 * Return the nth value from the last (count starts with zero).
	 *
	 * @param n, the index of the value from the last to return.
	 * @throws IndexOutOfBoundsException if(n < 0 || n > size).
	 */
	public AnyType getNthFromLast(int n) {
		return getNthFromFirst(size - n - 1);
	}

	/*
	 * Return an iterator of the list.
	 */
	public Iterator<AnyType> iterator() {
		return new SinglyLinkedListIterator();
	}

	/*
	 * Return a String representing the content of the list.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node<AnyType> tempHead = head;
		while(tempHead != null) {
			sb.append(tempHead.data.toString());	// write the data
			if(tempHead.next != null) {
				sb.append(", ");	// separate data neatly
			}
			tempHead = tempHead.next;
		}
		sb.append("]");
		return sb.toString();
	}

	/*
	 *	Remember that, this class must implement the following 3 methods,
	 *		which are the members of the Iterator<T> interface.
	 */
	private class SinglyLinkedListIterator implements Iterator<AnyType> {
		private Node<AnyType> tempHead = head;

		/*
		 * Returns boolean if iteration has more elements.
		 *
		 * @return true if iteration has more elements, false otherwise.
		 */
		@Override
		public boolean hasNext() {
			return head != null;
		}

		/*
		 * Returns the next element in the iteration.
		 *
		 * @return nextData of type AnyType
		 * @throws NoSuchElementException if no element exists
		 * 	or when !hasNext
		 */
		@Override
		public AnyType next() {
			if(!hasNext()) {	// when there is nothing to return
				throw new NoSuchElementException();
			}
			AnyType nextData = head.data;	// value to return
			head = head.next;	 // iterate to next
			return nextData;
		}

		/*
		 * Method implementation is provided by Farjana Eishita.
		 * 
		 * @throws UnsupportedOperationException, this method is unsupported.
		 */
		@Override
		public void remove() {
			throw new UnsupportedOperationException("remove operation is not supported by this iterator");
		}
	}	// end SinglyLinkedListIterator class

	/*
	 * Generic inner class Node that represents an element in the list.
	 */
	private class Node<AnyType> {
		private AnyType data;
		private Node<AnyType> next;

		/* Constructor for Node */
		public Node(AnyType data, Node<AnyType> next) {
			this.data = data;
			this.next = next;
		}
	}	// end Node class

}	// end SinglyLinkedList class
