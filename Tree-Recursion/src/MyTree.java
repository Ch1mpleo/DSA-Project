
import java.util.*;
import java.io.*;

class MyTree {

    Node root;

    // Constructor
    MyTree() {
        this.root = null;
    }

    class MyQueue {
        Node front, rear;

        // Constructor
        MyQueue() {
            front = rear = null;
        }

        // Check if the queue is empty
        boolean isEmpty() {
            return front == null;
        }

        // Add a node to the rear of the queue
        void enqueue(Node node) {
            if (isEmpty()) {
                front = rear = node;
            } else {
                rear.next = node;
                rear = node;
            }
        }

        // Remove and return the node from the front of the queue
        Node dequeue() {
            if (isEmpty()) {
                throw new NoSuchElementException("Queue is empty"); // Or handle it differently based on your requirements
            }
            Node temp = front;
            front = front.next;
            if (front == null) { // If the queue becomes empty after dequeue
                rear = null;
            }
            return temp;
        }
    }


    // Các hàm traverse

    void breadth() {
        if (root == null) return;
        MyQueue q = new MyQueue();
        q.enqueue(root);
        Node p;
        while (!q.isEmpty()) {
            p = (Node) q.dequeue();
            if (p.left != null)
                q.enqueue(p.left);
            if (p.right != null)
                q.enqueue(p.right);
            visit(p);
        }
    }


    public boolean isEmpty()
    {
        return root.left == null;
    }

    void preOrder(Node p) {
        if (p == null) return;
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    void inOrder(Node p) {
        if (p == null) return;
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    void postOrder(Node p) {
        if (p == null) return;
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }


    void visit(Node p) {
        System.out.print(p.info + " ");
    }

    public void load() {
        root = new Node(50);
        root.left = new Node(15);
        root.right = new Node(70);
        root.left.left = new Node(5);
        root.left.right = new Node(40);
        root.right.left = new Node(35);
        root.right.right = new Node(20);
        root.right.right.left = new Node(30);
        root.left.right.left = new Node(60);
        root.left.right.left.right = new Node(100);
    }

    private int computeHeight(Node t) {
        if (t == null) {
            return 0;
        } else {
            int leftHeight = computeHeight(t.left);
            int rightHeight = computeHeight(t.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    // Dùng đệ quy
    private Node InsertRec(Node p, int value) {
        if (p == null) {
            p = new Node(value);
        } else if (value < p.info) {
            p.left = InsertRec(p.left, value);
        } else if (value > p.info) {
            p.right = InsertRec(p.right, value);
        }
        return p;
    }


    //Test f1 - compute height
    public int f1() {
        return computeHeight(root);
    }

    public int countNode_Rec(Node t) {
        if (t == null) {
            return 0;
        } else {
            return countNode_Rec(t.left) + 1 + countNode_Rec(t.right);
        }
    }

    //Test f2 - count nodes
    public int f2() {
        return countNode_Rec(root);
    }

    private int countLeafNodes(Node t) {
        if (t == null) {
            return 0;
        }
        if (t.left == null && t.right == null) {
            return 1;
        }
        return countLeafNodes(t.left) + countLeafNodes(t.right);
    }

    //Test f3 - count leaf nodes
    public int f3() {
        return countLeafNodes(root);
    }

    private int computeSum(Node t) {
        if (t == null) {
            return 0;
        }
        return computeSum(t.left) + t.info + computeSum(t.right);
    }

    //Test f4 - compute sum of nodes
    public int f4() {
        return computeSum(root);
    }

    private int findMaxValue(Node t) {
        if (t == null) {
            return Integer.MIN_VALUE;
        }
        int maxRight = findMaxValue(t.right);
        int maxLeft = findMaxValue(t.left);
        return Math.max(t.info, Math.max(maxLeft, maxRight));
    }

    //Test f5 - find max
    public int f5() {
        return findMaxValue(root);
    }

    //traverse
    public void f6() {
        preOrder(root);
    }
    public void f7() {
        inOrder(root);
    }
    public void f8() {
        postOrder(root);
    }

}
