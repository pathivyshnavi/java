import java.util.PriorityQueue;
import java.util.Collections;

public class MaxHeapExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add elements
        maxHeap.add(10);
        maxHeap.add(30);
        maxHeap.add(20);

        // Print and remove the maximum element
        System.out.println("Max value: " + maxHeap.poll());

        // Remaining elements in the max-heap order
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll());
        }
    }
}
