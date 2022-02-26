import java.util.StringJoiner;

public class BubbleSortTester {
    
    public static void main(String[] args) {
        testCase1();
        testCase2();
        testCase3();
    }

    private static void testCase1() {
        int[] array = {24, 9, 29, 14, 19, 27};
        bubbleSortAndPrint(array);
    }

    private static void testCase2() {
        int[] array = {14, 3, 17, 11, 9};
        bubbleSortAndPrint(array);
    }

    private static void testCase3() {
        int[] array = {};
        bubbleSortAndPrint(array);
    }

    private static void bubbleSortAndPrint(int[] array) {
        System.out.println("Before: " + stringifyArray(array));
        BubbleSort.sort(array);
        System.out.println("After: " + stringifyArray(array));
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