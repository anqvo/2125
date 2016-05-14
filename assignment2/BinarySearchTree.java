import java.util.NoSuchElementException;

/*
 * This is a generic class which extends Comparable in order to perform
 * certain search purposes.
 * Also extends class BinaryTree<T> for in order to perform search purposes as well.
 */
public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {

	/*
	 * This constructor calls super() from its superclass BinaryTree<T>.
	 *
	 * See class BinaryTree<T> for extended comments.
	 */
	public BinarySearchTree(){
		super();
	}

	/*
	 * This constructor calls super() from its superclass BinaryTree<T>.
	 * 
	 * See class BinaryTree<T> for extended comments.
	 */
	public BinarySearchTree(T[] seq){
		super(seq);
	}

	/*
	 * This constructor calls super() from its superclass BinaryTree<T>.
	 *
	 * See class BinaryTree<T> for extended comments.
	 */
	public BinarySearchTree(T[] seq, T nullSymbol){
		super(seq, nullSymbol);
	}

	/*
	 * Adds the given element to the binary search tree
	 * (does nothing for duplicate entries).
	 *
	 * @param value the desired value to insert into the tree
	 */
	public void insert(T value) {
		BinaryNode<T> node = root;	/*	always begin at root */
		BinaryNode<T> newNode = new BinaryNode<T>(value);	/*	node that will be inserted */
		if(node != null) {	/*	if tree is not empty */
			if(value.compareTo(node.getData()) < 0) {	/*	if value is intially to the left of current node (root) */
				while(value.compareTo(node.getData()) < 0 && node.getLeftNode() != null) {	/*	traverse the left subtree */
					node = node.getLeftNode();	/*	set node to be its left node (used for while loop traverse) */
				}
				if(value.compareTo(node.getData()) < 0) {	/*	if left of current node */
					node.setLeftNode(newNode);	/*	insert new node as current node's left */
				} else if(value.compareTo(node.getData()) > 0) {	/*	else if right of current node */
					node.setRightNode(newNode);	/* insert new node as current node's right */
				}
			} else if(value.compareTo(node.getData()) > 0) {	/*	else if value is initially to right of current node (root) */
				while(value.compareTo(node.getData()) > 0 && node.getRightNode() != null) {	/*	traverse the right subtree */
					node = node.getRightNode();	/*	set node to be its right node (used for while loop traverse) */
				}
				if(value.compareTo(node.getData()) < 0) {	/*	if left of current node */
					node.setLeftNode(newNode);	/*	insert new node as current node's left */
				} else if(value.compareTo(node.getData()) > 0) {	/*	else if right of current node */
					node.setRightNode(newNode);	/*	insert new node as current node's right */
				}
			}
		} else {	/*	if tree is empty */
			 root = newNode;	/*	insert value as root */
		}

	}

	/*
	 * Removes the given value from the binary search
	 * tree.
	 *
	 * @param value the desired value to remove from the tree
	 */
	public void remove(T value) {
		root = remove(root, value);	/*	always begin at root (send to other remove method) */
	}

	/*
	 * Removes the given value from the binary search tree.
	 * Begin from the given node.
	 *
	 * @param node the node to begin searching the tree with
	 * @param value, the desired value to remove from the tree
	 * @return a BinaryNode<T> containing the value to be removed
	 */
	private BinaryNode<T> remove(BinaryNode<T> node, T value) {
		if(node == null) {	/*	if tree is empty */
			throw new NoSuchElementException("The tree is empty, thus there is nothing to remove.");	/*	throw NoSuchElementException() for the empty tree */
		} else {	/*	else tree is not empty */
			int result = value.compareTo(node.getData());	/*	compare value to current node's data (root) */

			if(result < 0) {	/*	if value is to left */
				node.setLeftNode(remove(node.getLeftNode(), value));	/*	move onto next left node to do same (recursion) */
			} else if(result > 0) {	/*	else if value is to right */
				node.setRightNode(remove(node.getRightNode(), value));	/*	move onto next right node to do same (recursion) */
			} else if(node.getLeftNode() != null && node.getRightNode() != null) {	/*	else if node has two children */
				node.setData(findMin(node.getRightNode()).getData());	/*	get the node with the smallest value on the right subtree of root,
																							hence, everything on the left of this node should be less than itself,
																							thus, this node will replace root once root is removed */
				node.setRightNode(remove(node.getRightNode(), node.getData()));	/* delete the old position of the node that was just used to replace root */
			} else {
				node = (node.getLeftNode() != null) ? node.getLeftNode() : node.getRightNode();
			}
			return node;	/*	mark the node as deleted */
		}
	}

	/*
	 * Finds the smallest node in the binary search tree.
	 * Starting from the given node, search until finding
	 *  the leftmost node in the tree.
	 * @param node the node to begin searching the tree
	 * @return a BinaryNode<T> that is the smallest node in the tree
	 * 			from the given starting-point node
	 */
	private BinaryNode<T> findMin(BinaryNode<T> node) {
		if(node == null) {	/*	if node is null */
			throw new NoSuchElementException("That node is null.");	/*	throw NoSuchElementException for node is null */
		} else if(node.getLeftNode() == null) {	/*	else if given node is already the smallest node */
			return node;	/*	return the given node */
		} else {	/*	else if node contains a left */
			return (findMin(node.getLeftNode()));	/* move onto next left node (recursion) */
		}
	}

	/*
	 * Returns true if the given value is found in the
	 * binary search tree, and false otherwise.
	 *
	 * @return true if(found) else return false for
	 * 			!found
	 */
	public boolean contains(T value) {
		BinaryNode<T> node = root;	/*	begin at the node */
		boolean contained = false;	/*	boolean to be returned (also used for a controlled loop) */
		if(root == null) {	/*	if tree is empty */
			throw new NoSuchElementException("The tree is empty.");	/*	throw NoSuchElementException for the empty tree */
		} else {	/*	else tree is not empty */
			while(node != null && !contained) {	/*	loop while conditions are stable */
				if(value.compareTo(node.getData()) == 0) {	/*	if value is found */
					contained = true;	/*	break the loop */
				} else if(value.compareTo(node.getData()) < 0) {	/*	else if value is to left of current node */
					node = node.getLeftNode();	/*	move into left subtree */
				} else {	/*	else value is to right of current node */
					node = node.getRightNode();	/*	move into right subtree */
				}
			}
		}
		return contained;	/*	return boolean for contains */
	}
}
