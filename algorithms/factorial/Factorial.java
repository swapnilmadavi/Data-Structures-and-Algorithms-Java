public class Factorial {

    public static int calculate(int n) {
        return factorial(n);
    }

    private static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }

    public static int calculateIteratively(int n) {
        int factorial = 1; // Defaults to 1; since minimum 1! or 0! equal to 1;
        while (n >= 2) {
            factorial = factorial * n;
            n--;
        }
        return factorial;
    }
}