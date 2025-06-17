import java.util.PriorityQueue;
import java.util.Scanner;

public class SortedRemoval {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        System.out.print("Enter number of elements: ");
        int N = scanner.nextInt();

        System.out.println("Enter " + N + " elements:");
        for (int i = 0; i < N; i++) {
            int num = scanner.nextInt();
            pq.add(num);  // Insert into min-heap
        }

        System.out.println("Elements in sorted order:");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());  // Removes smallest element
        }

        scanner.close();
    }
}
