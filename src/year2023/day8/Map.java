package year2023.day8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Map {

    private final List<String> instructions;
    private final List<Node> nodes;

    public Map(List<String> instructions) {
        this.instructions = instructions;
        this.nodes = new ArrayList<>();
    }

    public List<String> getInstructions() {
        return instructions;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void addNode(Node node) {
        this.nodes.add(node);
    }

    public int calculateSteps() {
        Queue<Node> nodes = new LinkedList<>();

        nodes.offer(getFirstNode());

        int steps = 0;
        int counter = 0;

        while (!nodes.isEmpty()) {
            int nodesInQueue = nodes.size();

            for (int i = 0; i < nodesInQueue; i++) {
                Node currentNode = nodes.poll();

                if (currentNode.getDestination().equals("ZZZ")) {
                    System.out.println("ZZZ found after " + steps + " steps");
                    return steps;
                }

                if (counter > instructions.size() - 1) {
                    counter = 0;
                }

                String instruction = instructions.get(counter);

                if (instruction.equals("L")) {
                    nodes.add(getNextNode(currentNode.getLeft()));
                } else {
                    nodes.add(getNextNode(currentNode.getRight()));
                }
                counter++;
            }
            steps++;
        }

        return -1;
    }

    private Node getFirstNode() {
        return nodes.stream()
                .filter(node -> node.getDestination().equals("AAA"))
                .findFirst().orElseThrow();
    }

    private Node getNextNode(String destination) {
        return this.nodes.stream()
                .filter(node -> node.getDestination().equals(destination))
                .findFirst().orElseThrow();
    }
}
