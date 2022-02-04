public class QuickSort {
    
    public static void sort(int[] inputArray) {
        quickSort(inputArray, 0, inputArray.length - 1);
    }

    private static void quickSort(int[] inputArray, int start, int end) {
        if (start < end) {
            int pivotIndex = doPartition(inputArray, start, end);
            quickSort(inputArray, start, pivotIndex - 1); // recursively sort the left sub-array
            quickSort(inputArray, pivotIndex + 1, end); // recursively sort the right sub-array
        }
    }

    private static int doPartition(int[] inputArray, int start, int end) {
        int pivot = inputArray[end];
        int leftIndex = start - 1;

        for (int i = start; i<end; i++) {
            if (inputArray[i] < pivot) {
                leftIndex++;
                swap(inputArray, i, leftIndex);
            }
        }

        int pivotIndex = leftIndex + 1;
        swap(inputArray, end, pivotIndex);
        return pivotIndex;
    }

    private static void swap(int[] inputArray, int i, int j) {
        int temp = inputArray[i];
        inputArray[i] = inputArray[j];
        inputArray[j] = temp;
    }
}