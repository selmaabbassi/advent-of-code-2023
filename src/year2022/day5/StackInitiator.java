package year2022.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackInitiator {

    List<Stack<String>> stacks;

    public StackInitiator() {
        stacks = new ArrayList<Stack<String>>();
        stacks.add(initiateStack(List.of("R", "W", "F", "H", "T", "S")));
        stacks.add(initiateStack(List.of("W", "Q", "D", "G", "S")));
        stacks.add(initiateStack(List.of("W", "T", "B")));
        stacks.add(initiateStack(List.of("J", "Z", "Q", "N", "T", "W", "R", "D")));
        stacks.add(initiateStack(List.of("Z", "T", "V", "L", "G", "H", "B", "F")));
        stacks.add(initiateStack(List.of("G", "S", "B", "V", "C", "T", "P", "L")));
        stacks.add(initiateStack(List.of("P", "G", "W", "T", "R", "B", "Z")));
        stacks.add(initiateStack(List.of("R", "J", "C", "T", "M", "G", "N")));
        stacks.add(initiateStack(List.of("W", "B", "G", "L")));
    }

    private Stack<String> initiateStack(List<String> list) {
        Stack<String> stack = new Stack<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            stack.push(list.get(i));
        }
        return stack;
    }
}
