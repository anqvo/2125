public class TestHeap {
	public static void main(String[] args) {
		MinHeap<Integer> heap = new MinHeap<Integer>();

		heap.insert(12);
		heap.insert(7);
		heap.insert(6);
		heap.insert(10);
		heap.insert(8);
		heap.insert(20);
		System.out.println("size: " + heap.size());

		int r = (int) heap.remove();
		System.out.println("removed: " + r + " size = " + heap.size());
		r = (int) heap.remove();
		System.out.println("removed: " + r + " size = " + heap.size());
		r = (int) heap.remove();
		System.out.println("removed: " + r + " size = " + heap.size());
		r = (int) heap.remove();
		System.out.println("removed: " + r + " size = " + heap.size());
		r = (int) heap.remove();
		System.out.println("removed: " + r + " size = " + heap.size());
		r = (int) heap.remove();
		System.out.println("removed: " + r + " size = " + heap.size());

	}
}
