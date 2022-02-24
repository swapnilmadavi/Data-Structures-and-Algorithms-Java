import java.util.StringJoiner;

public class MergeSortTester {
    
    public static void main(String[] args) {
        testCase1();
        testCase2();
        testCase3();
    }

    private static void testCase1() {
        int[] array = {24, 9, 29, 14, 19, 27};
        System.out.println("Before: " + stringifyArray(array));
        MergeSort.sort(array);
        System.out.println("After: " + stringifyArray(array));
        System.out.println();
    }

    private static void testCase2() {
        int[] array = {14, 3, 17, 11, 9};
        System.out.println("Before: " + stringifyArray(array));
        MergeSort.sortIterative(array);
        System.out.println("After: " + stringifyArray(array));
        System.out.println();
    }

    private static void testCase3() {
        int[] array = {};
        System.out.println("Before: " + stringifyArray(array));
        MergeSort.sort(array);
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