import java.util.PriorityQueue;

public class KLargestElements {

    public static int[] findKLargest(int[] arr, int k) {
        // Min heap to store k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : arr) {
            minHeap.offer(num);

            if (minHeap.size() > k) {
                minHeap.poll();  // remove smallest among heap
            }
        }

        // Extract k largest elements from heap into array
        int[] result = new int[k];
        int i = 0;
        while (!minHeap.isEmpty()) {
            result[i++] = minHeap.poll();
        }

        return result;  // elements will be in ascending order
    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;

        int[] kLargest = findKLargest(arr, k);

        System.out.println("K largest elements:");
        for (int num : kLargest) {
            System.out.print(num + " ");
        }
    }
}
