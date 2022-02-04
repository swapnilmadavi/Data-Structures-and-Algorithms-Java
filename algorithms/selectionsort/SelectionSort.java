public class SelectionSort {
    
    public static void sort(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            int indexOfSmallestElement = findIndexOfSmallestElement(inputArray, i);
            if (indexOfSmallestElement != i) {
                int temp = inputArray[i];
                inputArray[i] = inputArray[indexOfSmallestElement];
                inputArray[indexOfSmallestElement] = temp;
            }
        }
    }

    private static int findIndexOfSmallestElement(int[] inputArray, int start) {
        if (inputArray.length == 0 || start < 0 || start >= inputArray.length) {
            return -1;
        }

        int indexOfSmallestElement = start;
        int smallestElement = inputArray[start];

        for (int i = start + 1; i < inputArray.length; i++) {
            if (inputArray[i] < smallestElement ) {
                indexOfSmallestElement = i;
                smallestElement = inputArray[i];
            }
        }

        return indexOfSmallestElement;
    }
}