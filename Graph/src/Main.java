import java.util.Scanner;

public class Main {
    private Graph graph;

    public Main() {
        graph = new Graph();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Insert Node");
            System.out.println("2. Delete Node");
            System.out.println("3. Insert Edge");
            System.out.println("4. Delete Edge");
            System.out.println("5. Search Node");
            System.out.println("6. Display Graph");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter node value: ");
                    String value = scanner.nextLine();
                    graph.insertNode(value);
                    break;
                case 2:
                    System.out.print("Enter node value: ");
                    value = scanner.nextLine();
                    graph.deleteNode(value);
                    break;
                case 3:
                    System.out.print("Enter first node value: ");
                    String value1 = scanner.nextLine();
                    System.out.print("Enter second node value: ");
                    String value2 = scanner.nextLine();
                    graph.insertEdge(value1, value2);
                    break;
                case 4:
                    System.out.print("Enter first node value: ");
                    value1 = scanner.nextLine();
                    System.out.print("Enter second node value: ");
                    value2 = scanner.nextLine();
                    graph.deleteEdge(value1, value2);
                    break;
                case 5:
                    System.out.print("Enter node value: ");
                    value = scanner.nextLine();
                    Node node = graph.search(value);
                    if (node != null) {
                        System.out.println("Node " + value + " found.");
                    } else {
                        System.out.println("Node " + value + " not found.");
                    }
                    break;
                case 6:
                    System.out.println(graph);
                    break;
                case 7:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.run();
    }
}
