import java.util.*;

public class KnapsackProblem {
    
    public static int findMaximumValue(int knapsackWeightCapacity, List<Item> items) {
        if (items.size() == 0) {
            return 0;
        }

        if (knapsackWeightCapacity == 0) {
            throw new RuntimeException("Invalid Knapsack weight capactity!");
        }

        int[][] values = new int[items.size()][knapsackWeightCapacity];
        Item currentItem;
        int subKnapsackWeightCapacity;

        for (int i = 0; i < items.size(); i++) {
            currentItem = items.get(i);
            for (int j = 0; j < knapsackWeightCapacity; j++) {
                subKnapsackWeightCapacity = j+1;
                
                if (i == 0) {
                    if (currentItem.getWeight() <= subKnapsackWeightCapacity) {
                        values[i][j] = currentItem.getValue();
                    }
                    continue;
                }

                if (currentItem.getWeight() < subKnapsackWeightCapacity) {
                    int remainingWeight = subKnapsackWeightCapacity - currentItem.getWeight();
                    int previousMaxValueForRemainingWeight = values[i-1][remainingWeight-1];

                    int previousMaxValueForSubKnapsack = values[i-1][j];

                    values[i][j] = Math.max(previousMaxValueForSubKnapsack,
                        (currentItem.getValue() + previousMaxValueForRemainingWeight));
                } else if (currentItem.getWeight() > subKnapsackWeightCapacity) {
                    values[i][j] = values[i-1][j];
                } else {
                    int previousMaxValueForSubKnapsack = values[i-1][j];
                    if (currentItem.getValue() > previousMaxValueForSubKnapsack) {
                        values[i][j] = currentItem.getValue();
                    } else {
                        values[i][j] = previousMaxValueForSubKnapsack;
                    }
                }
            }
        }

        return values[items.size() - 1][knapsackWeightCapacity - 1];
    }
}