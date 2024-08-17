import java.util.HashMap;
import java.util.Map;

public class Graph {
    private Map<String, Node> nodes;

    public Graph() {
        nodes = new HashMap<>();
    }

    public void insertNode(String value) {
        if (!nodes.containsKey(value)) {
            nodes.put(value, new Node(value));
        } else {
            System.out.println("Node with value " + value + " already exists.");
        }
    }

    public void deleteNode(String value) {
        if (nodes.containsKey(value)) {
            Node nodeToDelete = nodes.get(value);
            nodes.remove(value);
            for (Node node : nodes.values()) {
                node.removeEdge(nodeToDelete);
            }
        } else {
            System.out.println("Node with value " + value + " does not exist.");
        }
    }

    public void insertEdge(String value1, String value2) {
        if (nodes.containsKey(value1) && nodes.containsKey(value2)) {
            nodes.get(value1).addEdge(nodes.get(value2));
        } else {
            System.out.println("One or both nodes with values " + value1 + " and " + value2 + " do not exist.");
        }
    }

    public void deleteEdge(String value1, String value2) {
        if (nodes.containsKey(value1) && nodes.containsKey(value2)) {
            nodes.get(value1).removeEdge(nodes.get(value2));
        } else {
            System.out.println("One or both nodes with values " + value1 + " and " + value2 + " do not exist.");
        }
    }

    public Node search(String value) {
        return nodes.get(value);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Node node : nodes.values()) {
            result.append(node.getValue()).append(": ");
            for (Node edge : node.getEdges()) {
                result.append(edge.getValue()).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
