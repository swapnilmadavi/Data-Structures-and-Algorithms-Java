public class BinarySearch {
    
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
}