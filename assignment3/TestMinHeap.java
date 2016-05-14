/*
 * JUnit test class for MinHeap. */

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.NoSuchElementException;

public class TestMinHeap {

	@Test
	public void testInsert1() {	
		MinHeap<Integer> heap = new MinHeap<Integer>();
		assertEquals(0, heap.size());
		assertTrue(heap.isEmpty());
		heap.insert(12);
		heap.insert(7);
		heap.insert(6);
		heap.insert(10);
		heap.insert(8);
		heap.insert(20);
		assertEquals(6, heap.size());
		assertFalse(heap.isEmpty());
	}

	@Test
	public void testRemoveOnNotEmpty1() {
		MinHeap<Integer> heap = new MinHeap<Integer>();
		assertEquals(0, heap.size());
		assertTrue(heap.isEmpty());
		heap.insert(12);
		heap.insert(7);
		heap.insert(6);
		heap.insert(10);
		heap.insert(8);
		heap.insert(20);
		assertEquals(6, heap.size());
		assertFalse(heap.isEmpty());

		assertEquals(6, (int) heap.remove());
		assertEquals(7, (int) heap.remove());
		assertEquals(8, (int) heap.remove());
		assertEquals(10, (int) heap.remove());
		assertEquals(12, (int) heap.remove());
		assertEquals(20, (int) heap.remove());
		assertEquals(0, heap.size());
		assertTrue(heap.isEmpty());
	}

	@Test(expected = NoSuchElementException.class)
	public void testRemoveOnEmpty1() {
		MinHeap<Integer> heap = new MinHeap<Integer>();
		assertEquals(0, heap.size());
		assertTrue(heap.isEmpty());
		assertEquals(0, (int) heap.remove());
	}

	@Test
	public void testIsEmptyOnEmpty1() {
		MinHeap<Integer> heap = new MinHeap<Integer>();
		assertEquals(0, heap.size());
		assertTrue(heap.isEmpty());
	}

	@Test
	public void testIsEmptyOnNotEmpty1() {
		MinHeap<Integer> heap = new MinHeap<Integer>();
		heap.insert(12);
		assertEquals(1, heap.size());
		assertFalse(heap.isEmpty());
	}

	@Test
	public void testIsFullOnFull1() {
		MinHeap<Integer> heap = new MinHeap<Integer>();
		heap.insert(12);
		heap.insert(7);
		assertFalse(heap.isFull());
		heap.insert(6);
		assertTrue(heap.isFull());
	}

	@Test
	public void testIsFullOnNotFull1() {
		MinHeap<Integer> heap = new MinHeap<Integer>();
		heap.insert(12);
		heap.insert(7);
		assertFalse(heap.isFull());
	}

	@Test
	public void testToStringOnEmpty1() {
		MinHeap<Integer> heap = new MinHeap<Integer>();
		assertEquals(0, heap.size());
		assertTrue(heap.isEmpty());
		assertEquals("", heap.toString());
	}
	
	@Test
	public void testToStringOnNotEmpty1() {
		MinHeap<Integer> heap = new MinHeap<Integer>();
		assertEquals(0, heap.size());
		assertTrue(heap.isEmpty());
		heap.insert(12);
		heap.insert(7);
		heap.insert(6);
		heap.insert(10);
		heap.insert(8);
		heap.insert(20);
		assertEquals("6 8 7 12 10 20 ", heap.toString());
	}

	@Test
	public void testSizeOnEmpty1() {
		MinHeap<Integer> heap = new MinHeap<Integer>();
		assertTrue(heap.isEmpty());
		assertEquals(0, heap.size());
	}

	@Test
	public void testSizeOnNotEmpty1() {
		MinHeap<Integer> heap = new MinHeap<Integer>();
		assertEquals(0, heap.size());
		assertTrue(heap.isEmpty());
		heap.insert(12);
		assertFalse(heap.isEmpty());
		assertEquals(1, heap.size());
	}
}
