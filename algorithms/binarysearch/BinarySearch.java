import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BinarySearch {
	private static final String TEST_FILE = "tc_binary_search.txt";

	public static int search(int[] inputArray, int element) {
		int low = 0;
		int high = inputArray.length - 1;
		int mid;
		int middleElement;
		while (low <= high) {
			mid = (low + high) / 2;
			middleElement = inputArray[mid];

			if (middleElement == element) {
				return mid; // found! return index
			} else if (middleElement > element) {
				high = mid - 1; // reduce the search to left sub-array
			} else {
				low = mid + 1; // reduce the search to right sub-array
			}
		}

		return -1;
	}

	public static int searchRecursively(int[] inputArray, int element) {
		return binarySearchRecursive(inputArray, 0, inputArray.length - 1, element);
	}

	private static int binarySearchRecursive(int[] inputArray, int low, int high, int element) {
		if (low > high) {
			return -1;
		}

		int mid = (low + high) / 2;
		int middleElement = inputArray[mid];

		if (middleElement == element) {
			return mid; // found! return index
		} else if (middleElement > element) {
			return binarySearchRecursive(inputArray, low, mid - 1, element); // search in the left sub-array
		} else {
			return binarySearchRecursive(inputArray, mid + 1, high, element); // search in the right sub-array
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
}