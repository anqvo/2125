/*
 * JUnit test class for UnboundedPriorityQueue. */

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.NoSuchElementException;

public class TestUnboundedPriorityQueue {

	@Test
	public void testEnqueue1() {
		UnboundedPriorityQueue<Integer> queue = new UnboundedPriorityQueue<Integer>();
		assertEquals(0, queue.size());
		assertTrue(queue.isEmpty());
		queue.enqueue(12);
		queue.enqueue(7);
		queue.enqueue(6);
		queue.enqueue(10);
		queue.enqueue(8);
		queue.enqueue(20);
		assertEquals(6, queue.size());
		assertFalse(queue.isEmpty());
	}

	@Test(expected = NoSuchElementException.class)
	public void testDequeueOnEmpty1() {
		UnboundedPriorityQueue<Integer> queue = new UnboundedPriorityQueue<Integer>();
		assertEquals(0, queue.size());
		assertTrue(queue.isEmpty());
		assertEquals(0, (int) queue.dequeue());
	}

	@Test
	public void testDequeueOnNotEmpty1() {
		UnboundedPriorityQueue<Integer> queue = new UnboundedPriorityQueue<Integer>();
		assertEquals(0, queue.size());
		assertTrue(queue.isEmpty());
		queue.enqueue(12);
		queue.enqueue(7);
		queue.enqueue(6);
		queue.enqueue(10);
		queue.enqueue(8);
		queue.enqueue(20);
		assertEquals(6, queue.size());
		assertFalse(queue.isEmpty());

		assertEquals(6, (int) queue.dequeue());
		assertEquals(7, (int) queue.dequeue());
		assertEquals(8, (int) queue.dequeue());
		assertEquals(10, (int) queue.dequeue());
		assertEquals(12, (int) queue.dequeue());
		assertEquals(20, (int) queue.dequeue());
		assertEquals(0, queue.size());
		assertTrue(queue.isEmpty());
	}

	@Test
	public void testIsEmptyOnEmpty1() {
		UnboundedPriorityQueue<Integer> queue = new UnboundedPriorityQueue<Integer>();
		assertEquals(0, queue.size());
		assertTrue(queue.isEmpty());
	}

	@Test
	public void testIsEmptyOnNotEmpty1() {
		UnboundedPriorityQueue<Integer> queue = new UnboundedPriorityQueue<Integer>();
		queue.enqueue(12);
		assertEquals(1, queue.size());
		assertFalse(queue.isEmpty());
	}

	@Test
	public void testSizeOnEmpty1() {
		UnboundedPriorityQueue<Integer> queue = new UnboundedPriorityQueue<Integer>();
		assertTrue(queue.isEmpty());
		assertEquals(0, queue.size());
	}

	@Test
	public void testSizeOnNotEmpty1() {
		UnboundedPriorityQueue<Integer> queue = new UnboundedPriorityQueue<Integer>();
		assertEquals(0, queue.size());
		assertTrue(queue.isEmpty());
		queue.enqueue(12);
		assertFalse(queue.isEmpty());
		assertEquals(1, queue.size());
	}
}
