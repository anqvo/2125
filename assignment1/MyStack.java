/*
 * An Vo
 * CSCI 2125-001
 * 05 September 2015
 * Assignment 1 Part 2 "MyStack.java"
 */

import java.util.NoSuchElementException;

/*
 * A Stack implementation using linked list.
 * 
 * linked list = SinglyLinkedList<AnyType>
 */
public class MyStack<AnyType> {

	private SinglyLinkedList<AnyType> linkedList;
	
	/*
	 * Instantiate/construct an empty stack.
	 */
	public MyStack() {
		linkedList = new SinglyLinkedList<AnyType>();
	}

	/*
	 * Removes the element at the top of the stack and returns that element 
	 * as the value of the function.
	 *
	 * @return AnyType element at top of stack
	 * @throws NoSuchElementException if the stack == isEmpty();
	 */
	public AnyType pop() {
		try {
			AnyType element = linkedList.getNthFromFirst(0);
			linkedList.remove(element);
			return element;
		}
		catch (IndexOutOfBoundsException e) {
			throw new NoSuchElementException();
		}
	}	// end pop method

	/*
	 * Pushes an item onto the top of the stack.
	 *
	 * @param AnyType element, the element to push
	 */
	public void push(AnyType element) {
		linkedList.insertAt(element, 0);	// insert element at front of list
													// 	(to the top of the stack)
	}	// end push method

	/*
	 * Tests if the stack is empty or not.
	 *
	 * @return true if stack == isEmpty, false otherwise.
	 */
	public boolean isEmpty() {
		return linkedList.isEmpty();
	}	// end isEmpty method

	/*
	 * Look at the element at the top of the stack without removing it.
	 * 
	 * @return AnyType element at the top of stack.
	 * @throws NoSuchElementException if the stack == isEmpty();
	 */
	public AnyType peek() {
		try {
			return linkedList.getNthFromFirst(0);
		}
		catch (IndexOutOfBoundsException e) {
			throw new NoSuchElementException();
		}
	}	// end peek method

	/*
	 * Return the size of the stack.
	 *
	 * @return int size, the current size of the stack.
	 */
	public int size() {
		return linkedList.size();
	}	// end size method

}	// end MyStack class
