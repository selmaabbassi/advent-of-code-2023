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

    public int calculateStepsPart1() {
        Queue<Node> queue = new LinkedList<>();

        queue.offer(getFirstNode());

        int steps = 0;
        int counter = 0;

        while (!queue.isEmpty()) {
            int nodesInQueue = queue.size();

            for (int i = 0; i < nodesInQueue; i++) {
                Node currentNode = queue.poll();

                if (currentNode.getDestination().equals("ZZZ")) {
                    return steps;
                }

                if (counter > instructions.size() - 1) {
                    counter = 0;
                }

                String instruction = instructions.get(counter);

                if (instruction.equals("L")) {
                    queue.add(getNextNode(currentNode.getLeft()));
                } else {
                    queue.add(getNextNode(currentNode.getRight()));
                }
                counter++;
            }
            steps++;
        }

        return -1;
    }

    public int calculateStepsPart2() {

        List<Node> startingNodes = getTwoFirstNodes();
        System.out.println("Starting nodes: " + startingNodes.get(0).toString() + " " + startingNodes.get(1).toString());
        Queue<Node> queue = new LinkedList<>(startingNodes);

        int steps = 0;
        int counter = 0;

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            if (currentNode.getDestinationLastChar().equals("Z")) {
                continue;
            }

            if (counter > instructions.size() - 1) {
                counter = 0;
            }

            String instruction = instructions.get(counter);

            if (instruction.equals("L")) {
                queue.add(getNextNode(currentNode.getLeft()));
            } else {
                queue.add(getNextNode(currentNode.getRight()));
            }


            if (queue.stream().allMatch(node -> node.getDestinationLastChar().equals("Z"))) {
                return steps;
            }
            
            counter++;
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

    private List<Node> getTwoFirstNodes() {
        List<Node> nodes = this.nodes.stream()
                .filter(node -> node.getDestinationLastChar().equals("A")).toList();

        return List.of(nodes.get(0), nodes.get(1));

    }
}
