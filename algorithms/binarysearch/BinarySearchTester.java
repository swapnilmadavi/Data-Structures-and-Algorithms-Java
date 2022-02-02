import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BinarySearchTester {
    private static final String TEST_FILE = "tc_binary_search.txt";

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(TEST_FILE))) {
            String line;
            String[] testCase;
            int[] inputArray;
            int result;
            
            while ((line = bufferedReader.readLine()) != null) {
                testCase = line.split(" ");
                inputArray = parseIntArray(testCase[0]);
                result = BinarySearch.search(inputArray, Integer.parseInt(testCase[1]));
                System.out.println("Input array: " + testCase[0]);
                System.out.println("Element: " + testCase[1]);
                System.out.println("Expected output: " + testCase[2]);
                System.out.println("Result: " + result);
                System.out.println();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private static int[] parseIntArray(String arrayString) {
        String[] arrayElements = arrayString.substring(1, arrayString.length() - 1).split(",");
        
        // Quick & Hacky way to handle empty array
        if (arrayElements.length == 1 && arrayElements[0].isEmpty()) {
            return new int[0];
        }

        int[] intArray = new int[arrayElements.length];
        for (int i = 0; i < arrayElements.length; i++) {
            intArray[i] = Integer.parseInt(arrayElements[i]);
        }
        return intArray;
    }
}