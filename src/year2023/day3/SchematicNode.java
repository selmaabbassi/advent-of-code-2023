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

                                if (isAdjacentToSymbol(list[i])) {
                                        partFound = true;
                                }
                                i++;
                        }

                        if (partFound) {
                                System.out.println("Part found! " + possiblePart.toString());
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
//                System.out.println("Adjacent in current");
//                System.out.println(list[index - 1] + "|" + list[index] + "|" + list[index + 1]);
//                System.out.println("Left is symbol: " + isSymbol(list[index - 1]));
//                System.out.println("Right is symbol: " + isSymbol(list[index + 1]));
//                System.out.println("---------------------------------------------");
                return isSymbol(list[index - 1]) || isSymbol(list[index + 1]);
        }

        private boolean isAdjacentSymbolInPrevious(int index) {
//                System.out.println("Adjacent in previous");
//                System.out.println(previous.list[index - 1] + "|" + previous.list[index] + "|" + previous.list[index + 1]);
//                System.out.println("Left is symbol: " + isSymbol(previous.list[index - 1]));
//                System.out.println("Right is symbol: " + isSymbol(previous.list[index + 1]));
//                System.out.println("---------------------------------------------");
                return isSymbol(previous.list[index - 1]) || isSymbol(previous.list[index]) || isSymbol(previous.list[index + 1]);
        }

        private boolean isAdjacentSymbolInNext(int index) {
//                System.out.println("Adjacent in next");
//                System.out.println(next.list[index - 1] + "|" + next.list[index] + "|" + next.list[index + 1]);
//                System.out.println("Left is symbol: " + isSymbol(next.list[index - 1]));
//                System.out.println("Right is symbol: " + isSymbol(next.list[index + 1]));
//                System.out.println("---------------------------------------------");
                return isSymbol(next.list[index - 1]) || isSymbol(next.list[index]) || isSymbol(next.list[index + 1]);
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
