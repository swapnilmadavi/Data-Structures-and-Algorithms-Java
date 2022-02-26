import java.util.StringJoiner;

public class DynamicArrayTester {

    public static void main(String[] args) {
        DynamicArray<String> dynamicArray = new DynamicArray<>(3);
        dynamicArray.add("Rose");
        dynamicArray.add("Lily");
        dynamicArray.add("Orchid");
        System.out.println("Initial array => " + stringifyArray(dynamicArray));
        System.out.println();

        // Add operation
        dynamicArray.add("Sunflower");
        System.out.println("Add Sunflower => " + stringifyArray(dynamicArray));
        System.out.println("Size after inserting Sunflower => " + dynamicArray.size());
        System.out.println();

        // RemoveAt operation
        System.out.println("Remove element at 0 => " + dynamicArray.removeAt(0));
        System.out.println("Array after removeAt(0) operation => " + stringifyArray(dynamicArray));
        System.out.println();


        // Set operation
        System.out.println("Set element at index 1 to Tulip, old element => " + dynamicArray.set(1, "Tulip"));
        System.out.println();

        // Remove operation
        System.out.println("Remove last element => " + dynamicArray.remove());
        System.out.println("Array after removing the last element => " + stringifyArray(dynamicArray));
        System.out.println();
    }

    private static <T> String stringifyArray(DynamicArray<T> array) {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");

        for (T element : array) {
            stringJoiner.add(element.toString());
        }

        return stringJoiner.toString();
    }
}