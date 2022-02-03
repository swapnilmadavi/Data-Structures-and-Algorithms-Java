public class FactorialTester {

    public static void main(String[] args) {
        testCase1();
        testCase2();
        testCase3();
        testCase4();
        testCase5();
    }

    private static void testCase1() {
        int input = 5;
        int output = Factorial.calculate(input);
        printResult(input, 120, output);
    }

    private static void testCase2() {
        int input = 8;
        int output = Factorial.calculate(input);
        printResult(input, 40320, output);
    }

    private static void testCase3() {
        int input = 0;
        int output = Factorial.calculate(input);
        printResult(input, 1, output);
    }

    private static void testCase4() {
        int input = 1;
        int output = Factorial.calculate(input);
        printResult(input, 1, output);
    }

    private static void testCase5() {
        int input = 4;
        int output = Factorial.calculate(input);
        printResult(input, 24, output);
    }

    private static void printResult(int input, int expectedOutput, int output) {
        System.out.println("Input: " + input);
        System.out.println("Expected output: " + expectedOutput);
        System.out.println("Output: " + output);
        System.out.println();
    }
}