package year2023.day8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LineParser {

    private Map map;

    public LineParser(String instruction) {
        initializeMap(instruction);
    }

    public Map getMap() {
        return map;
    }

    public void appendNode(String node) {
        this.map.addNode(createNode(node));
    }

    private void initializeMap(String instruction) {
        char[] instructions = instruction.toCharArray();
        List<String> queue = new ArrayList<>();

        for (char c : instructions) {
            queue.add(String.valueOf(c));
        }

        this.map = new Map(queue);
    }

    private Node createNode(String node) {
        String[] split = node.split("=");
        String[] otherSplit = split[1].split(",");

        String destination = split[0].trim();
        String left = otherSplit[0].replace("(", "").trim();
        String right = otherSplit[1].replace(")", "").trim();

        return new Node(destination, left, right);
    }

    public void print() {
        System.out.println("Instructions: " + Arrays.toString(getMap().getInstructions().toArray()));
        System.out.println("Instructions size: " + getMap().getInstructions().toArray().length);
        getMap().getNodes().forEach(Node::print);
    }
}
