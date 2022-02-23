public class Fibonacci {
    
    public static int calculate(int n) {
        int first = 0;
        int second = 1;

        if (n <= 0) {
            return first;
        }

        if (n == 1) {
            return second;
        }

        int result = 0;

        for (int i = 2; i <= n; i++) {
            result = second + first;
            first = second;
            second = result;
        }

        return result;
    }

    public static int calculateRecursive(int n) {
        return fibonacci(n);
    }

    private static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
}