import java.util.StringJoiner;

public class SinglyLinkedListTester {

    public static void main(String[] args) {
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
        linkedList.add("Rose");
        System.out.println("Initial list => " + stringifyLinkedList(linkedList));
        System.out.println();

        // Add operations
        linkedList.add("Sunflower");
        System.out.println("Add Sunflower => " + stringifyLinkedList(linkedList));
        System.out.println();

        linkedList.addFirst("Lily");
        System.out.println("addFirst() Lily => " + stringifyLinkedList(linkedList));
        System.out.println();

        linkedList.addAt(1, "Orchid");
        System.out.println("addAt(1) Orchid => " + stringifyLinkedList(linkedList));
        System.out.println("Size after inserting Orchid => " + linkedList.size());
        System.out.println();

        // Remove operations
        System.out.println("Remove Rose => " + linkedList.remove("Rose"));
        System.out.println("List after removing Rose => " + stringifyLinkedList(linkedList));
        System.out.println();

        System.out.println("Remove element at index 1 => " + linkedList.removeAt(1));
        System.out.println("List after removing element at index 1 => " + stringifyLinkedList(linkedList));
        System.out.println();

        // Remove operation
        System.out.println("Remove last element => " + linkedList.removeLast());
        System.out.println("List after removing the last element => " + stringifyLinkedList(linkedList));
        System.out.println();
    }

    private static <T> String stringifyLinkedList(SinglyLinkedList<T> linkedList) {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");

        for (T element : linkedList) {
            stringJoiner.add(element.toString());
        }

        return stringJoiner.toString();
    }
}