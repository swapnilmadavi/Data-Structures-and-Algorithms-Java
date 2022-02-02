import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Factorial {
	private static final String TEST_FILE = "tc_factorial.txt";

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

	public static void main(String[] args) {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(TEST_FILE))) {
			String line;
			String[] testCase;
			int result;
			
			while ((line = bufferedReader.readLine()) != null) {
				testCase = line.split(" ");
				result = Factorial.calculate(Integer.parseInt(testCase[0]));
				System.out.println("Input: " + testCase[0]);
				System.out.println("Expected output: " + testCase[1]);
				System.out.println("Result: " + result);
				System.out.println();
			}
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}
}