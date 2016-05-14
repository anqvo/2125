@name	An Vo
@email	aqvo1@uno.edu



Part 1:
	Necessary changes to code:
		1)	line 55 - nodes.length was changed to nodes.size()
		2)	line 65 - HandelNullParentNode was changed to HandleNullParentNode
	Implementing class QueueBT<T>:
		1)	I implemented class QueueBT<T> using JAVA's LinkedList API instead
			 of using my SinglyLinkedList from Assignment1 because it was more
			 simple and straightforward.
	Testing class QueueBT<T> with JUnit:
		1)	Some methods were tested using both String and Integer values while
			 other methods only used Integer. This is because the methods using
			 only Integer did not really depend on the type being declared.
Part 2:
	Implementing class BinarySearchTree<T>:
		1)	In the class declaration, generic T extends Comparable<T> in order to
			 be able to compare @param "T value" in certain required methods.
		2)	I decided to implement methods insert() and contains() as nonrecursive,
			 but however, implemented method remove as recursive. Nonrecursive was
			 too challenging.
		3)	Thus for the recursion, I have two remove methods: one declared as void
			 which calls the other that is private and is declared to return to
			 the void method a BinaryNode<T>.
		4)	I added a private method findMin which takes a BinaryNode<T> object
			 and returns a BinaryNode<T> object. This method assists with the
			 remove method.
