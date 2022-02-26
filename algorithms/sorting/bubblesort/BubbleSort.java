public class BubbleSort {
    
    public static void sort(int[] array) {
        boolean elementsSwapped;
        for (int i = 0; i < array.length; i++) { // number of passes
            elementsSwapped = false;
            for (int j = 0; j < array.length - i - 1; j++) { // comparing adjecent elements
                if (array[j] > array[j+1]) {
                    swap(array, j, j+1);
                    elementsSwapped = true;
                }
            }

            // No need to perform further passes, if all elements have been placed in-order
            if (!elementsSwapped) {
                break;
            }
        }
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}