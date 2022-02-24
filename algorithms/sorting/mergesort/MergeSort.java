public class MergeSort {
    
    public static void sort(int[] inputArray) {
        mergeSort(inputArray, 0, inputArray.length - 1);        
    }

    private static void mergeSort(int[] inputArray, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(inputArray, start, mid); 
            mergeSort(inputArray, mid + 1, end); 
            merge(inputArray, start, mid, end);
        }
    }

    private static void merge(int[] inputArray, int start, int mid, int end) {
        int[] mergedArray = new int[end - start + 1];
        int mergeIndex = 0;
        int i = start;
        int j = mid + 1;

        while (i <= mid && j <= end) {
            if (inputArray[i] < inputArray[j]) {
                mergedArray[mergeIndex++] = inputArray[i];
                i++;
            } else {
                mergedArray[mergeIndex++] = inputArray[j];
                j++;
            }
        }

        // Copy any remaining elements from left sub-array
        for (; i <= mid; i++) {
            mergedArray[mergeIndex++] = inputArray[i];
        }


        // Copy any remaining elements from right sub-array
        for (; j <= end; j++) {
            mergedArray[mergeIndex++] = inputArray[j];
        }

        // Copy back sorted elements into the input array
        for (i = start; i <= end; i++) {
            inputArray[i] = mergedArray[i - start];
        }
    }

    public static void sortIterative(int[] inputArray) {
        int start1, start2, end1, end2;
        for (int i = 1; i < inputArray.length; i = i * 2) {
            for (int j = 0; j < inputArray.length; j = j + (i * 2)) {
                start1 = j;
                end1 = start1 + i - 1;

                start2 = end1 + 1;
                end2 = start2 + i - 1;

                if (start2 >= inputArray.length) {
                    break;
                }
                
                if (end2 >= inputArray.length) {
                    end2 = inputArray.length - 1;
                }

                twoWayMerge(inputArray, start1, end1, start2, end2);
            }
        }
    }

    private static void twoWayMerge(int[] inputArray, int start1, int end1, int start2, int end2) {
        int[] mergedArray = new int[(end1 - start1 + 1) + (end2 - start2 + 1)];
        int mergeIndex = 0;
        int i = start1;
        int j = start2;

        while (i <= end1 && j <= end2) {
            if (inputArray[i] < inputArray[j]) {
                mergedArray[mergeIndex++] = inputArray[i];
                i++;
            } else {
                mergedArray[mergeIndex++] = inputArray[j];
                j++;
            }
        }

        // Copy any remaining elements from left sub-array
        for (; i <= end1; i++) {
            mergedArray[mergeIndex++] = inputArray[i];
        }


        // Copy any remaining elements from right sub-array
        for (; j <= end2; j++) {
            mergedArray[mergeIndex++] = inputArray[j];
        }

        // Copy back sorted elements into the input array
        for (i = start1; i <= end2; i++) {
            inputArray[i] = mergedArray[i - start1];
        }
    }
}