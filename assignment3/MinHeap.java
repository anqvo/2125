/*
 * A heap must be a complete binary tree where all
 *  nodes must be filled and last level must be filled
 *  as far left as possible.
 * A min-heap means that for each non-leaf node, V,
 *  the value in V is smaller than the value of its
 *  children.
 */

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MinHeap<T extends Comparable<T>> {
	private ArrayList<T> list;

	/*
	 * Default constructor. */
	public MinHeap() {
		this.list = new ArrayList<T>();
	}

	/*
	 * Insert the given T value to the end of the list. */
	public void insert(T value) {
		this.list.add(value);	// add value to end of list
		int pos = this.list.size()-1;	// current location of value
		int parent = (pos-1)/2;	// location of value's parent
		while(pos > 0 && this.list.get(parent).compareTo(this.list.get(pos)) > 0) {	// if parent is greater than value
			/*	swap value and parent */
			T tmp = this.list.get(parent);	// store parent temporarily
			this.list.set(parent, this.list.get(pos));	// place value where parent is
			this.list.set(pos, tmp);	// place parent where value was
			pos = parent;	// point to new location of value
			parent = (pos-1)/2;	// point to value's new parent
		}
	}

	/*
	 * Remove the element at front of the list (root node)
	 *  and return the removed element.
	 *
	 * @return the removed element */
	public T remove() {
		if(isEmpty()) {	// if the tree is empty
			throw new NoSuchElementException();	// throw exception
		}
		T ret = this.list.get(0);
		if(this.list.size() == 1) {
			ret = this.list.remove(0);
			return ret;
		}
		else if(this.list.size() >= 3) {	// else tree is not empty
			ret = this.list.get(0);	// store the root node that will be removed
			this.list.set(0, this.list.get(this.list.size()-1));	// place the last node to the root position
			this.list.remove(this.list.size()-1);	// remove the last node's previous position
			if(this.list.size() == 2) {
				return ret;
			}
//			if(this.list.size() >= 3) { 
				int pos = 0;	// point to the current position (root)
				int left = 2*pos+1;	// point to the current's left
				int right = 2*pos+2;	// point to the current's right
				while(this.list.get(pos).compareTo(this.list.get(left)) > 0 ||	// is current greater than its left?
						 this.list.get(pos).compareTo(this.list.get(right)) > 0) {	//  or is current greater than its right?
					if(this.list.get(left).compareTo(this.list.get(right)) < 0) {	// if current's left is less than current's right
						/* swap current with its left */
						T tmpLeft = this.list.get(left);	// temporarily store current's left
						this.list.set(left, this.list.get(pos));	// place current into left's position
						this.list.set(pos, tmpLeft);	// place left into current's previous position
						pos = left;	// point to new current position
						if(2*pos+1 >= this.list.size() || 2*pos+2 >= this.list.size()) {	// if current's children are greater than itself
							break;	// break out
						}
						else {	// else continue loop
							left = 2*pos+1;	// update current's left
							right = 2*pos+2;	// update current's right
						}
					}
					else {	// else current's right is less than its left
						/* swap current with its right */
						T tmpRight = this.list.get(right);	// temporarily store current's right
						this.list.set(right, this.list.get(pos));	// place current into right's position
						this.list.set(pos, tmpRight);	// place right into current's previous position
						pos = right;	// point to new current position
						if(2*pos+1 >= this.list.size() || 2*pos+2 >= this.list.size()) {	// if current's children are greater than itself
							break;	// break out
						}
						else {	// else continue loop
							left = 2*pos+1;	// update current's left
							right = 2*pos+2;	// update current's right
						}
					}
				}
		}
		else if(this.list.size() == 2) {
			if(this.list.get(0).compareTo(this.list.get(1)) > 0) {
				T tmpLeft = this.list.get(1);
				this.list.set(1, this.list.get(0));
				this.list.set(0, tmpLeft);
				ret = this.list.get(0);
				this.list.set(0, this.list.get(1));
				this.list.remove(1);
			}
			else {
				this.list.set(0, this.list.get(1));
				this.list.remove(1);
			}
		}
		return ret;	// return the removed element (root)
	}

	/*
	 * Check if "tree" is empty and return a boolean result
	 *  accordingly.
	 * 
	 * @return true if ... is empty
	 * 			false otherwise */
	public boolean isEmpty() {
		boolean result = false;	// placeholder for boolean return
		if(this.list.isEmpty() == true) {	// if list is empty using ArrayList's isEmpty()
			result = true;	// update placeholder for tree is empty
		}
		return result;	// tree is not empty
	}

	/*
	 * Check if "tree" is full and return a boolean result.
	 * A full tree will return an odd value otherwise
	 *  return an even meaning not full.
	 *
	 *  accordingly.
	 *
	 * @return true if "tree" is full
	 * 			false otherwise */
	public boolean isFull() {
		boolean result = false;	// placeholder for boolean return
		if(this.list.size() % 3 == 0) {	// check if odd meaning full tree
			return true;	// return tree is full
		}
		else {	// else value is even meaning tree not full
			return false;	// return tree is not full
		}
	}

	/*
	 * Create a string representation of "tree" and
	 *  return the string representation.
	 *
	 * @return the string representation */
	public String toString() {
		StringBuilder stringBuffer = new StringBuilder();	// create a StringBuilder
		if(this.list.size() == 0) {
			stringBuffer.append("");
		}
		else {
			for(int i = 0; i < this.list.size(); i++) {	// loop through list
				stringBuffer.append(this.list.get(i) + " ");	// append the value for each iteration
			}
		}
		return stringBuffer.toString();	// return the string represenation
	}

	public int size() {
		return this.list.size();
	}
}
