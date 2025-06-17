import java.util.PriorityQueue;

public class MinHeapExample {
    public static void main(String[] args) {
        // Create a PriorityQueue which acts as a min-heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Insert values into the min-heap
        int[] values = {20, 15, 30, 5, 10, 25};
        for (int val : values) {
            minHeap.offer(val);
        }

        // Print the min-heap elements by polling (removes elements)
        System.out.println("Min-heap elements in ascending order:");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
    }
}
