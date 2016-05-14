import java.util.List;
import java.util.ArrayList;

public class BinaryTree<T>{
	BinaryNode<T> root = null;	
	
	private T nullSymbol = null;

	/*
	 * Default constructor
	 */
	public BinaryTree(){
	
	}

	/*
	 *	This constructor is useful for test purposes,
	 *  not meant for use in general.
	 *
	 *  Constructs a binary tree from a given valid breadth-first traversal sequence.
	 *  @param seq is an array containing breadth-first traversal sequence of the nodes of a tree.
	 */
	public BinaryTree(T[] seq){
		initFromBfsSequence(seq);
	}

	/*
	 *	This constructor is useful for test purposes,
	 *  not meant for use in general.
	 *
	 *  Constructs a binary tree from a given valid breadth-first traversal sequence. 
	 *	A given special symbol (nullSymbol) in the sequence is interpreted as absence of node. 
	 *	During construction of the tree, when such a special symbol is encountered, 
	 *	that is considered to be an absent node, and thus no corresponding node is added to the tree.
	 * 	
	 * 	@param seq is an array containing breadth-first traversal sequence of the nodes of a tree.
	 * 	@param nullSymbol is a special symbol in the given sequence that denotes absence of a node.
	 */
	public BinaryTree(T[] seq, T nullSymbol){
		this.nullSymbol = nullSymbol;
		initFromBfsSequence(seq);
	}

	private void initFromBfsSequence(T[] seq){
		if(seq.length == 0)
			throw new IllegalArgumentException("Cannot build tree from empty sequence");
		
		if(seq[0].equals(nullSymbol))
			throw new IllegalArgumentException("Symbol for root cannot be nullSymbol");
				
		List<BinaryNode<T>> nodes = new ArrayList<BinaryNode<T>>(seq.length);
		this.root = new BinaryNode<T>(seq[0]);
		nodes.add(root);

		for(int i = 0; i < nodes.size(); i++){			
			if(nodes.get(i) == null){ 				
				handleNullParentNode(nodes, i, seq.length);				
			}else{				
				handleNonNullParentNode(nodes, i, seq);				
			}
		}		
	}

	// This method will handle the null nodes in the iteration of nodes.get(i) in initFromBfsSequence method.
	private void handleNullParentNode(List<BinaryNode<T>> nodes, 
						int nullNodeIndex, int seqLength){
		int leftIndex = (nullNodeIndex * 2) + 1; // finding the left child index from formula 
				
		if(leftIndex < seqLength){
			nodes.add(null);

			int rightIndex = (nullNodeIndex * 2) + 2; // finding the right child index from formula
			if(rightIndex < seqLength){
				nodes.add(null);
			}
		}
	}

	// This method will handle the non-null nodes in the iteration of nodes.get(i) in initFromBfsSequence method.
	private void handleNonNullParentNode(List<BinaryNode<T>> nodes, 
								int parentIndex, T[] seq){
		int leftIndex = (parentIndex * 2) + 1;			
		if(leftIndex < seq.length){ //need to check if the index falls outdise of the list index
			BinaryNode<T> leftNode = null;
			if(!seq[leftIndex].equals(nullSymbol)){
				leftNode = new BinaryNode<T>(seq[leftIndex]);
			}
			nodes.get(parentIndex).leftNode = leftNode;
			nodes.add(leftNode);

			int rightIndex = (parentIndex * 2) + 2;				
			if(rightIndex < seq.length){
				BinaryNode<T> rightNode = null;
				if(!seq[rightIndex].equals(nullSymbol)){
					rightNode = new BinaryNode<T>(seq[rightIndex]);
				}
				nodes.get(parentIndex).rightNode = rightNode;
				nodes.add(rightNode);			
			}
		}
	}

	public int height(){
		if (root == null) return 0;	
		return root.height();
	}

	/*	Computes and returns the width of the tree.
	 *
	 *	@return the width of the tree
	 */
	public int width(){
		int maxWidth = 0;	/*	the width value to be returned */
		if(root == null) {	/*	if tree is empty */
			return maxWidth;	/*	return width = 0 */
		}
		QueueBT<BinaryNode<T>> queue = new QueueBT<BinaryNode<T>>();	/*	create a queue which will traverse the tree to calculate width */
		int levelNodes = 0;	/*	keep a record of nodes of each level of the tree */
		queue.enqueue(root);	/*	add the root to the queue to traverse the tree and calculate the width */
		while(queue.isEmpty() == false) {	/*	begin traversing the tree in a loop until condition breaks */
			levelNodes = queue.getSize();	/*	set levelNodes as the current size of queue (current level) */
			if(levelNodes > maxWidth) {	/*	if current level is larger than current maxWidth */
				maxWidth = levelNodes;	/*	update the maxWidth to be the current level size */
			}
			while(levelNodes > 0) {	/*	loop until there are no more levels to traverse */
				BinaryNode<T> node = queue.dequeue();	/*	node used to check values of Left/Right nodes */
				if(node.getLeftNode() != null) {	/*	if there is a left node */
					queue.enqueue(node.getLeftNode());	/*	retrieve the left node */
				}
				if(node.getRightNode() != null) {	/*	if there is a right node */
					queue.enqueue(node.getRightNode());	/*	retrieve the right node */
				}
				levelNodes--;	/*	decrement levelNodes until condition breaks the loop */
			}
		}
		return maxWidth;	/*	return the width of the tree */
	}

	/*	Traverses the tree in breadth-first order and returns a
	 *	string that represents the breadth-first traversal sequence
	 *	of the tree.
	 *
	 *	@return a string representation of the breadth-first traversal
	 */
	public String breadthFirstTraverse(){
		String empty = "";	/*	a placeholder for an empty string */
		if(root == null) {	/*if the tree is empty */
			return empty;	/*	return empty */
		}
		StringBuilder stringBuffer = new StringBuilder();	/*	create a StringBuilder for append purposes */
		QueueBT<BinaryNode<T>> queue = new QueueBT<BinaryNode<T>>();	/*	create a queue which will traverse the tree */
		queue.enqueue(root);	/*	begin at the root node */
		while(queue.isEmpty() == false) {	/*	begin traversing the tree in a loop until condition breaks */
			BinaryNode<T> node = queue.dequeue();	/*	retrieve the first node */
			stringBuffer.append(" " + node.getData().toString());	/*	append the retrieved node's data in a string */
			if(node.getLeftNode() != null) {	/*	if there is a left node */
				queue.enqueue(node.getLeftNode());	/*	retrieve the left node */
			}
			if(node.getRightNode() != null) {	/*	if there is a right node */
				queue.enqueue(node.getRightNode());	/*	retrieve the right node */
			}
		}
		return stringBuffer.toString().trim();	/*	return the string containing all appended data */
	}

	public String preOrderTraverse(){
		return root.preOrderTraverse().trim();				
	}

	public String postOrderTraverse(){
		return root.postOrderTraverse().trim();
	}

	public String inOrderTraverse(){
		return root.inOrderTraverse().trim();
	}
	
	class BinaryNode<T>{
		private T data = null;
		private BinaryNode<T> leftNode = null;
		private BinaryNode<T> rightNode = null;

		public BinaryNode(T data){
			this.data = data;			
		}

		public String toString(){
			return "" + data;
		}

		public BinaryNode<T> getLeftNode(){
			return this.leftNode;
		}

		public BinaryNode<T> getRightNode(){
			return this.rightNode;
		}

		public void setLeftNode(BinaryNode<T> node){
			this.leftNode = node;
		}

		public void setRightNode(BinaryNode<T> node){
			this.rightNode = node;
		}

		public T getData(){
			return this.data;
		}

		public void setData(T data){
			this.data = data;
		}

		public int height(){
			if(isLeaf()) return 0;
			
			int leftHeight = 0;
			int rightHeight = 0;

			if(leftNode != null){ 
				leftHeight = leftNode.height();
			}

			if(rightNode != null){
				rightHeight = rightNode.height();
			}
			
			int maxHeight = leftHeight > rightHeight? leftHeight: rightHeight;

			return maxHeight + 1 ;
		}

		public boolean isLeaf(){
			return (leftNode == null && rightNode == null);
		}


		public String preOrderTraverse(){
			StringBuilder stringBuffer = new StringBuilder();			
			
			stringBuffer.append(" " + data);
			
			if(leftNode != null){
				stringBuffer.append(leftNode.preOrderTraverse());				
			}
			
			if(rightNode != null){
				stringBuffer.append(rightNode.preOrderTraverse());
			}

			return stringBuffer.toString();				
		}

		/*
		 * Traverses the tree in post order and returns a string
		 * that represents the post order depth first traversal
		 * sequence of the tree.
		 *
		 * @return a string representation of the post order traversal
		 */
		public String postOrderTraverse(){
			StringBuilder stringBuffer = new StringBuilder();	/*	create a StringBuilder for append purposes */
			if(leftNode != null) {	/*	if there is a left node */
				stringBuffer.append(leftNode.postOrderTraverse());	/*	recursively append left node until no more left */
			}
			if(rightNode != null) {	/*	if there is a right node */
				stringBuffer.append(rightNode.postOrderTraverse());	/*	recursively append right node until no more right */
			}
			stringBuffer.append(" " + data);	/*	append the root node (may be root of subtree and not actual root of entire tree) */
			return stringBuffer.toString();	/*	return the string containing all appended data */
		}

		/*
		 * Traverses the tree in order and returns a string that
		 * represents the in order depth first traversal sequence
		 * of the tree.
		 *
		 * @return a string representation of in order traversal
		 */
		public String inOrderTraverse(){
			StringBuilder stringBuffer = new StringBuilder();	/*	create a StringBuilder for append purposes */
			if(leftNode != null) {	/*	if there is a left node */
				stringBuffer.append(leftNode.inOrderTraverse());	/*	recursively append left node until no more left */
			}
			stringBuffer.append(" " + data);	/*	append the root node (may be root of subtree and not actual root of entire tree */
			if(rightNode != null) {	/*	if there is a right node */
				stringBuffer.append(rightNode.inOrderTraverse());	/*	recursively append right node until no more right */
			}
			return stringBuffer.toString();	/*	return the string containing all appended data */
		}
	}
}
