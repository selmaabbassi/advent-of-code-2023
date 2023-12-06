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

        public List<Integer> findGearParts() {
                List<Integer> gearParts = new ArrayList<>();

                for (int i = 0; i < list.length; i++) {
                        if (list[i] == '*') {
                                System.out.println("found gear * at index " + i);
                                List<Integer> adjacentParts = findAdjacentParts(i);
                                gearParts.add(adjacentParts.get(0) * adjacentParts.get(1));
                        }
                }

                return gearParts;
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

        private boolean isSymbolInAdjacentNode(int index, SchematicNode node) {
                if (index == 0) { // only check adjacent on right side if first element
                        return isSymbol(node.list[index]) || isSymbol(node.list[index + 1]);
                } else if (index == list.length - 1) { // only check adjacent on left side if last element
                        return isSymbol(node.list[index - 1]) || isSymbol(node.list[index]);
                } else {
                        return isSymbol(node.list[index - 1]) || isSymbol(node.list[index]) || isSymbol(node.list[index + 1]);
                }
        }

        private boolean isSymbol(char c) {
                return !Character.isDigit(c) && c != '.';
        }

        private List<Integer> findAdjacentParts(int index) {
                List<Integer> adjacentParts = new ArrayList<>();

                /**
                 * 1 * 1        1 2 3           . . .
                 * 1 2 3        2 * 2           1 2 3
                 * . . .        2 2 3           2 * 1
                 */

                //first node
                if (previous == null) {
                        adjacentParts.add(getAdjacentPart(index, this));
                        adjacentParts.add(getAdjacentPart(index, next));
                } else if (next == null) { //last node
                        adjacentParts.add(getAdjacentPart(index, this));
                        adjacentParts.add(getAdjacentPart(index, previous));
                } else {
                        adjacentParts.add(getAdjacentPart(index, previous));
                        adjacentParts.add(getAdjacentPart(index, this));
                        adjacentParts.add(getAdjacentPart(index, next));
                }

                return adjacentParts;
        }

        private int getAdjacentPart(int index, SchematicNode node) {
                if (index == 0) { //first element: only check right adjacent
                        if (Character.isDigit(node.list[index + 1])) {
                                return getRightPart(index, node);
                        }
                } else if (index == node.list.length - 1) { // last element: only check left adjacent
                        if (Character.isDigit(node.list[index - 1])) {
                                return getLeftPart(index, node);
                        }
                } else {
                        if (Character.isDigit(node.list[index + 1])) {
                                return getRightPart(index, node);
                        }
                        if (Character.isDigit(node.list[index - 1])) {
                                return getLeftPart(index, node);
                        }
                }
                return -1;
        }

        private int getRightPart(int index, SchematicNode node) {
                StringBuilder builder = new StringBuilder();

                for (int i = index + 1; Character.isDigit(node.list[i]); i++) {
                        builder.append(node.list[i]);
                }

                return Integer.parseInt(builder.toString());
        }

        private int getLeftPart(int index, SchematicNode node) {
                StringBuilder builder = new StringBuilder();

                for (int i = index - 1; i > -1 && Character.isDigit(node.list[i]); i--) {
                        builder.append(node.list[i]);
                }

                return Integer.parseInt(builder.toString());
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
