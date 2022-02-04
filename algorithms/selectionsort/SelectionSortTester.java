import java.util.StringJoiner;

public class SelectionSortTester {

    public static void main(String[] args) {
        testCase1();
        testCase2();
        testCase3();
    }

    private static void testCase1() {
        int[] array = {4, 7, 11, 2, 16, 25, 19};
        selectionSortAndPrint(array);
    }

    private static void testCase2() {
        int[] array = {10, 7, 8, 9, 1, 5};
        selectionSortAndPrint(array);
    }

    private static void testCase3() {
        int[] array = {};
        selectionSortAndPrint(array);
    }

    private static void selectionSortAndPrint(int[] array) {
        System.out.println("Before: " + stringifyArray(array));
        SelectionSort.sort(array);
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