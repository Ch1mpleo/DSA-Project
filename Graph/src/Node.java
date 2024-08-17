import java.util.ArrayList;
import java.util.List;

public class Node {
    private String value;
    private List<Node> edges;

    public Node(String value) {
        this.value = value;
        this.edges = new ArrayList<>();
    }

    public String getValue() {
        return value;
    }

    public List<Node> getEdges() {
        return edges;
    }

    public void addEdge(Node node) {
        if (!edges.contains(node)) {
            edges.add(node);
            node.getEdges().add(this);  // Undirected graph
        }
    }

    public void removeEdge(Node node) {
        if (edges.contains(node)) {
            edges.remove(node);
            node.getEdges().remove(this);
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
