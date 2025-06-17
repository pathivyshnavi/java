public class TribonacciNumber{
    public static void main(String[] args) {
        int n = 10; // Number of terms to print
        printTribonacci(n);
    }
    public static void printTribonacci(int n) {
        if (n <= 0) {
            return;
        }
        if (n == 1) {
            System.out.print("0");
            return;
        }
        if (n == 2) {
             System.out.print("0 0");
            return;
        }
         if (n == 3) {
             System.out.print("0 0 1");
            return;
        }
        int a = 0, b = 0, c = 1;
        System.out.print(a + " " + b + " " + c + " ");
        for (int i = 4; i <= n; i++) {
            int next = a + b + c;
            System.out.print(next + " ");
            a = b;
            b = c;
            c = next;
        }
    }
}