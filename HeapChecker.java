public class HeapChecker {

    // Check if array represents a min-heap
    public static boolean isMinHeap(int[] arr) {
        int n = arr.length;

        // Only need to check nodes which are parents
        for (int i = 0; i <= (n - 2) / 2; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            // Check if left child is smaller than parent
            if (left < n && arr[i] > arr[left]) {
                return false;
            }

            // Check if right child is smaller than parent
            if (right < n && arr[i] > arr[right]) {
                return false;
            }
        }
        return true;
    }

    // Check if array represents a max-heap
    public static boolean isMaxHeap(int[] arr) {
        int n = arr.length;

        for (int i = 0; i <= (n - 2) / 2; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            // Check if left child is greater than parent
            if (left < n && arr[i] < arr[left]) {
                return false;
            }

            // Check if right child is greater than parent
            if (right < n && arr[i] < arr[right]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] minHeap = {1, 3, 5, 7, 9, 8};
        int[] maxHeap = {10, 9, 8, 7, 6, 5};
        int[] notHeap = {10, 15, 20, 17};

        System.out.println("Is minHeap a Min-Heap? " + isMinHeap(minHeap));  // true
        System.out.println("Is maxHeap a Max-Heap? " + isMaxHeap(maxHeap));  // true
        System.out.println("Is notHeap a Min-Heap? " + isMinHeap(notHeap));  // false
        System.out.println("Is notHeap a Max-Heap? " + isMaxHeap(notHeap));  // false
    }
}
