package year2023.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SchematicNode {

        SchematicNode previous;
        SchematicNode next;
        char[] list;

        public SchematicNode(String line) {
                list = line.toCharArray();
        }

        public List<Integer> findParts() {
                List<Integer> parts = new ArrayList<>();

                for (int i = 0; i < list.length; i++) {
                        StringBuilder possiblePart = new StringBuilder();
                        boolean partFound = false;

                        while (i < list.length && Character.isDigit(list[i])) {
                                possiblePart.append(list[i]);

                                if (isAdjacentToSymbol(i)) {
                                        partFound = true;
                                }
                                i++;
                        }

                        if (partFound) {
                                parts.add(Integer.parseInt(possiblePart.toString()));
                        }
                }

                return parts;
        }

        private boolean isAdjacentToSymbol(int index) {
                //first node
                if (previous == null) {
                        return isAdjacentSymbolInCurrent(index) || isAdjacentSymbolInNext(index);
                }

                //last node
                if (next == null) {
                        return isAdjacentSymbolInCurrent(index) || isAdjacentSymbolInPrevious(index);
                }

                return isAdjacentSymbolInPrevious(index) || isAdjacentSymbolInCurrent(index) || isAdjacentSymbolInNext(index);
        }

        private boolean isAdjacentSymbolInCurrent(int index) {
                if (index == 0) { // only check adjacent on right side if first element
                        return isSymbol(list[index + 1]);
                } else if (index == list.length - 1) { // only check adjacent on left side if last element
                        return isSymbol(list[index - 1]);
                } else {
                        return isSymbol(list[index - 1]) || isSymbol(list[index + 1]);
                }
        }

        private boolean isAdjacentSymbolInPrevious(int index) {
                return isSymbolInAdjacentNode(index, previous);
        }

        private boolean isAdjacentSymbolInNext(int index) {
                return isSymbolInAdjacentNode(index, next);
        }

        private boolean isSymbolInAdjacentNode(int index, SchematicNode previous) {
                if (index == 0) { // only check adjacent on right side if first element
                        return isSymbol(previous.list[index]) || isSymbol(previous.list[index + 1]);
                } else if (index == list.length - 1) { // only check adjacent on left side if last element
                        return isSymbol(previous.list[index - 1]) || isSymbol(previous.list[index]);
                } else {
                        return isSymbol(previous.list[index - 1]) || isSymbol(previous.list[index]) || isSymbol(previous.list[index + 1]);
                }
        }

        private boolean isSymbol(char c) {
                return !Character.isDigit(c) && c != '.';
        }

        public void print() {
                if (previous != null) {
                        System.out.println("Previous node: " + Arrays.toString(previous.list));

                }
                System.out.println("Current node: " + Arrays.toString(list));

                if (next != null) {

                        System.out.println("Next node: " + Arrays.toString(next.list));
                }

                System.out.println("---------------------------");
        }
}
