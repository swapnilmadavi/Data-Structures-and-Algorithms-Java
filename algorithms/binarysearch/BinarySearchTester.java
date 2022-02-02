import java.util.StringJoiner;

public class BinarySearchTester {

    public static void main(String[] args) {
        testCase1();
        testCase2();
        testCase3();
    }

    private static void testCase1() {
        int[] inputArray = new int[] {3, 4, 5, 6, 7, 8, 9};
        int element = 5;
        int expectedOutput = 2;
        int output = BinarySearch.search(inputArray, element);
        printResult(inputArray, element, expectedOutput, output);
    }

    private static void testCase2() {
        int[] inputArray = new int[] {11, 14, 25, 30, 40, 41, 52, 57, 70};
        int element = 23;
        int expectedOutput = -1;
        int output = BinarySearch.search(inputArray, element);
        printResult(inputArray, element, expectedOutput, output);
    }

    private static void testCase3() {
        int[] inputArray = new int[] {};
        int element = 100;
        int expectedOutput = -1;
        int output = BinarySearch.search(inputArray, element);
        printResult(inputArray, element, expectedOutput, output);
    }

    private static void printResult(int[] inputArray, int element, int expectedOutput, int output) {
        System.out.println("Input array: " + stringifyArray(inputArray));
        System.out.println("Element: " + element);
        System.out.println("Expected output: " + expectedOutput);
        System.out.println("Output: " + output);
        System.out.println();
    }

    private static String stringifyArray(int[] array) {
        StringJoiner stringJoiner = new StringJoiner(", ", "{", "}");

        for (int i : array) {
            stringJoiner.add(Integer.toString(i));
        }

        return stringJoiner.toString();
    }
}