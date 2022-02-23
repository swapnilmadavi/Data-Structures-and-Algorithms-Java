/**
 * Usage: java FibonacciTester [-r] number
 * -r : recursive method
 */
public class FibonacciTester {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, result;

        if (args.length == 0 || args.length > 2) {
            System.out.println("Usage: java FibonacciTester [-r] number\n-r : recursive method");
            return;
        }

        if (args.length == 2 && args[0].equals("-r")) {
            n = Integer.parseInt(args[1]);
            result = Fibonacci.calculateRecursive(n);
        } else {
            n = Integer.parseInt(args[0]);
            result = Fibonacci.calculate(n);
        }

        System.out.println(n + "th fibonacci = " + result);  
    }
}