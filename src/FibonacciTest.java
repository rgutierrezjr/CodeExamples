public class FibonacciTest {

    public static int fibonacci(int n) {
        // base class
        if( n <= 0) {
            return 0;
        } else if( n == 1) {
            return n;
        }

        // recurse, n - 1 + n - 2
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {

        System.out.println(fibonacci(2));
    }
}
