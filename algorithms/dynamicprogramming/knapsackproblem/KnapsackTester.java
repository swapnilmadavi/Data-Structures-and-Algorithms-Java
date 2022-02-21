import java.util.*;

public class KnapsackTester {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Guitar", 1500, 1));
        items.add(new Item("Stereo", 3000, 4));
        items.add(new Item("Laptop", 2000, 3));

        int knapsackWeightCapacity = 4;

        System.out.println("Items:");
        for (Item item : items) {
            System.out.println(item);
        }

        System.out.println("\nKnapsack weight capactity: " + knapsackWeightCapacity);

        System.out.println("\nMaximum value: " + KnapsackProblem.findMaximumValue(knapsackWeightCapacity, items));
    }
}