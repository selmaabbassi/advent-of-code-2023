package year2022.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CrateSorter {

    StackInitiator stackInitiator;

    public CrateSorter() {
        this.stackInitiator = new StackInitiator();
    }

    public void sortCrates(String str) {
        int[] moves = extractInt(str);
        int numberOfCrates = moves[0];

        int stackToMoveFromIndex = moves[1];
        int stackToMoveToIndex = moves[2];

        for (int i = 0; i < numberOfCrates; i++) {
            Stack<String> stackToMoveFrom = stackInitiator.stacks.get(stackToMoveFromIndex-1);
            Stack<String> stackToMoveTo = stackInitiator.stacks.get(stackToMoveToIndex-1);

            stackToMoveTo.push(stackToMoveFrom.pop());
        }
    }

    public List<String> getTopOfStacks() {
        return stackInitiator.stacks.stream().map(s -> !s.isEmpty() ? s.peek() : "").toList();
    }

    private int[] extractInt(String str) {
        str = str.replaceAll("[^0-9]", " ");
        str = str.replaceAll(" +", " ");

        if (str.equals(""))
            return new int[0];

        str = str.trim();
        return convertToArray(str);
    }

    private int[] convertToArray(String str) {
        String[] stringArray = str.split(" ");

        int[] intArray = new int[stringArray.length];

        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }

        return intArray;
    }


}
