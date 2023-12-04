package year2023.day3;

import java.util.Arrays;
import java.util.List;

public class SchematicNode {

        SchematicNode previous;
        SchematicNode next;
        char[] list;

        List<Integer> parts;

        public SchematicNode(String line) {
                list = line.toCharArray();
        }

        private void findParts() {
                StringBuilder part = new StringBuilder();

                for (int i = 0; i < list.length; i++) {
                        boolean partFound = false;

                        if (partFound) {
                                parts.add(Integer.parseInt(part.toString()));
                                partFound = false;
                                part = new StringBuilder();
                        }

                        if (Character.isDigit(list[i])) {
                                //find adjacent symbols
                                boolean isAdjacent = isAdjacentToSymbol(list[i]);
                                part.append(list[i]);
                                //save part String until adjacent of digit is not a digit.

                        }
                }


        }

        public void print() {
                System.out.println(Arrays.toString(list));
        }

        private boolean isAdjacentToSymbol(int index) {
                return false;
        }
}
