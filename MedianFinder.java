import java.util.PriorityQueue;
import java.util.Collections;

public class MedianFinder {

    private PriorityQueue<Integer> maxHeap; // smaller half
    private PriorityQueue<Integer> minHeap; // larger half

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // max heap
        minHeap = new PriorityQueue<>(); // min heap
    }

    public void addNum(int num) {
        // Add to max heap first
        maxHeap.offer(num);

        // Ensure every element in maxHeap <= every element in minHeap
        if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            int val = maxHeap.poll();
            minHeap.offer(val);
        }

        // Balance sizes: maxHeap can have one more element than minHeap at most
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            // Even number of elements, average of two roots
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }

    // Example usage
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();

        int[] data = {5, 15, 1, 3};

        for (int num : data) {
            mf.addNum(num);
            System.out.println("Added " + num + ", current median: " + mf.findMedian());
        }
    }
}
