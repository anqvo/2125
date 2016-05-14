import org.junit.Test;
import static org.junit.Assert.*;
import java.util.NoSuchElementException;

/*
 * TestQueueBT uses JUnit to test the functions of
 *  class QueueBT<T>.
 */
public class TestQueueBT {
	
	/*
	 * Test the method enqueue() using String.
	 */
	@Test
	public void testEnqueue1() {
		QueueBT<String> queue = new QueueBT<String>();
		queue.enqueue("a");
		queue.enqueue("b");
		queue.enqueue("c");
		queue.enqueue("d");
	}

	/*
	 * Test the method enqueue() using Integer.
	 */
	@Test
	public void testEnqueue2() {
		QueueBT<Integer> queue = new QueueBT<Integer>();
		queue.enqueue(0);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
	}

	/*
	 * Test the method dequeue() using String on a queue
	 *  that is empty.
	 * Do note that declaring QueueBT as String does not matter.
	 *  QueueBT could be declared as Integer as well.
	 * This method is expected to throw a NoSuchElementException
	 *  when queue is empty.
	 */
	@Test (expected = NoSuchElementException.class)
	public void testDequeue1Empty() {
		QueueBT<String> queue = new QueueBT<String>();
		queue.dequeue();

		assertTrue(queue.isEmpty());
	}

	/*
	 * Test the method dequeue() using String on a queue
	 *  that is not empty.
	 */
	@Test
	public void testDequeue1NotEmpty() {
		QueueBT<String> queue = new QueueBT<String>();
		queue.enqueue("a");
		queue.enqueue("b");
		queue.enqueue("c");
		queue.enqueue("d");

		assertEquals("a", queue.dequeue());
		assertEquals("b", queue.dequeue());
		assertEquals("c", queue.dequeue());

		assertFalse(queue.isEmpty());
	}

	/*
	 * Test the method dequeue() using Integer on a queue
	 *  that is not empty.
	 */
	@Test
	public void testDequeue2NotEmpty() {
		QueueBT<Integer> queue = new QueueBT<Integer>();
		queue.enqueue(0);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);

		assertEquals(new Integer(0), queue.dequeue());
		assertEquals(new Integer(1), queue.dequeue());
		assertEquals(new Integer(2), queue.dequeue());

		assertFalse(queue.isEmpty());
	}

	/*
	 * Test the method getSize() using Integer on a queue
	 *  that is empty.
	 */
	@Test
	public void testgetSize1Empty() {
		QueueBT<Integer> queue = new QueueBT<Integer>();
		assertEquals(0, queue.getSize());	/*	note that 0 is not declared as "new Integer(0)",
															they are not the same */
		assertTrue(queue.isEmpty());
	}

	/*
	 * Test the method getSize() using Integer on a queue
	 *  that is not empty.
	 */
	@Test
	public void testGetSize2NotEmpty() {
		QueueBT<Integer> queue = new QueueBT<Integer>();
		queue.enqueue(0);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		assertEquals(4, queue.getSize());

		queue.dequeue();
		assertEquals(3, queue.getSize());

		queue.dequeue();
		assertEquals(2, queue.getSize());

		queue.dequeue();
		assertEquals(1, queue.getSize());

		assertFalse(queue.isEmpty());
	}

	/*
	 * Test the method isEmpty() using Integer on a queue
	 *  that is empty
	 */
	@Test
	public void testisEmpty1Empty() {
		QueueBT<Integer> queue = new QueueBT<Integer>();
		assertTrue(queue.isEmpty());
	}

	/*
	 * Test the method isEmpty() using Integer on a queue
	 *  that is not empty
	 */
	@Test
	public void testisEmpty2NotEmpty() {
		QueueBT<Integer> queue = new QueueBT<Integer>();
		queue.enqueue(0);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		assertFalse(queue.isEmpty());
	}
}
