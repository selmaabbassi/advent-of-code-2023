package year2023.day3;

import java.util.ArrayList;
import java.util.List;

public class LinkedSchematics {

        List<SchematicNode> schematics;
        List<Integer> parts;

        public LinkedSchematics() {
                schematics = new ArrayList<>();
        }

        public void append(String line) {
                schematics.add(new SchematicNode(line));
        }

        @Override
        public String toString() {
                StringBuilder builder = new StringBuilder();
                schematics.forEach(node -> builder.append(node.toString()));
                return builder.toString();
        }

        public void print() {
                schematics.forEach(SchematicNode::print);
        }

        public void linkSchematicNodes() {
                for (int i = 0; i < schematics.size(); i++) {
                        if (i == 0) {
                                SchematicNode first = schematics.get(i);
                                first.previous = null;
                                first.next = schematics.get(i + 1);
                        } else if (i == schematics.size() - 1) {
                                SchematicNode last = schematics.get(i);
                                last.previous = schematics.get(i - 1);
                                last.next = null;
                        } else {
                                SchematicNode middle = schematics.get(i);
                                middle.previous = schematics.get(i - 1);
                                middle.next = schematics.get(i + 1);
                        }

                }
        }
}
