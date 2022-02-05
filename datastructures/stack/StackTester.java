import java.util.StringJoiner;

public class StackTester {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(4);
        stack.push(12);
        stack.push(41);
        stack.push(29);
        System.out.println("Initial stack =>\n" + stringifyStack(stack));
        System.out.println();

        // Push operation
        stack.push(7);
        System.out.println("Push 7 =>\n" + stringifyStack(stack));
        System.out.println("Size after inserting 7 => " + stack.size());
        System.out.println();

        // Pop operation
        System.out.println("Element at top => " + stack.peek());
        System.out.println("Pop => " + stack.pop());
        System.out.println("Stack after pop operation =>\n" + stringifyStack(stack));
        System.out.println();

        stack.push(38);
        System.out.println("Push 38 =>\n" + stringifyStack(stack));
        System.out.println();

        // Stack overflow error
        System.out.println("Trying to push 12 again in an already full stack; should throw an error");
        stack.push(12);
    }

    private static <T> String stringifyStack(Stack<T> stack) {
        StringJoiner stringJoiner = new StringJoiner("\n");

        for (T element : stack) {
            stringJoiner.add(element.toString());
        }

        return stringJoiner.toString();
    }
}