package year2023.day8;

public class Node {
    private final String destination;
    private final String left;
    private final String right;

    public Node(String destination, String left, String right) {
        this.destination = destination;
        this.left = left;
        this.right = right;
    }

    public String getDestination() {
        return destination;
    }

    public String getLeft() {
        return left;
    }

    public String getRight() {
        return right;
    }

    public void print() {
        System.out.println(destination + " = " + left + "," + right);
    }
}
