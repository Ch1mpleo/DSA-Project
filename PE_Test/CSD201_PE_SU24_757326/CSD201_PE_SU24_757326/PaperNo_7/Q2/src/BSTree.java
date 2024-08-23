/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

public class BSTree {

    Node root;

    BSTree() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    void clear() {
        root = null;
    }

    void visit(Node p) {
        System.out.print("p.info: ");
        if (p != null) {
            System.out.println(p.info + " ");
        }
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void breadth(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    void preOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        fvisit(p, f);
        preOrder(p.left, f);
        preOrder(p.right, f);
    }

    void inOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder(p.left, f);
        fvisit(p, f);
        inOrder(p.right, f);
    }

    void postOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder(p.left, f);
        postOrder(p.right, f);
        fvisit(p, f);
    }

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            insert(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void insert(String xPlace, int xPrice, int xType) {
        //You should insert here statements to complete this function
        // Check if the first character is not 'A'
        if (xPlace.charAt(0) != 'A') {
            root = insertRec(root, xPlace, xPrice, xType);
        }
    }

    Node insertRec(Node root, String xPlace, int xPrice, int xType) {
        if (root == null) {
            root = new Node(new Brick(xPlace, xPrice, xType));
            return root;
        }

        //Check if xType is unique
        if (xType == root.info.type) {
            return root; // Do nothing if the type already exists
        }

        if (xType < root.info.type) {
            root.left = insertRec(root.left, xPlace, xPrice, xType);
        } else if (xType > root.info.type) {
            root.right = insertRec(root.right, xPlace, xPrice, xType);
        }

        return root;
    }

//Do not edit this function. Your task is to complete insert function above only.
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        inOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        preOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        preOrder2(root, f);
        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

    //Copy preOrder but check the non-leaf nodes
    void preOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }

        // Check if it's a non-leaf node
        if (p.left != null || p.right != null) {
            f.writeBytes(p.info.toString() + " ");
        }

        preOrder2(p.left, f);
        preOrder2(p.right, f);
    }
//=============================================================

    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/

        // In-order traversal to find the 4th smallest element
        Node[] nodes = new Node[1];
        findKthSmallest(root, 4, nodes);
        if (nodes[0] != null) {
            deleteByCopying(nodes[0].info.type);
        }

        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

    // Helper method to perform in-order traversal and find the kth smallest element
    int findKthSmallest(Node node, int k, Node[] result) {
        if (node == null) {
            return 0;
        }

        int leftCount = findKthSmallest(node.left, k, result);

        if (leftCount + 1 == k) {
            result[0] = node;
            return leftCount + 1;
        }

        int rightCount = findKthSmallest(node.right, k - leftCount - 1, result);
        return leftCount + 1 + rightCount;
    }

// Helper method to delete a node by copying
    void deleteByCopying(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key) {
        if (root == null) {
            return root;
        }

        // Traverse the tree to find the node to delete
        if (key < root.info.type) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.info.type) {
            root.right = deleteRec(root.right, key);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.info = minValueNode(root.right).info;

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.info.type);
        }

        return root;
    }

    Node minValueNode(Node node) {
        Node current = node;

        // Loop down to find the leftmost leaf
        while (current.left != null) {
            current = current.left;
        }

        return current;
    }
//=============================================================

    void f4() throws Exception {
        clear();
        loadData(13);;
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/

        // Find the 3rd node with a right child in pre-order traversal
        Node[] result = new Node[1];
        findNthRightChild(root, 3, new int[1], result);
        if (result[0] != null) {
            root = rotateLeft(root, result[0]);
        }
        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }
    
    // Helper method to find the nth node with a right child in pre-order traversal
    void findNthRightChild(Node node, int n, int[] count, Node[] result) {
        if (node == null || result[0] != null) {
            return;
        }

        if (node.right != null) {
            count[0]++;
            if (count[0] == n) {
                result[0] = node;
                return;
            }
        }

        findNthRightChild(node.left, n, count, result);
        findNthRightChild(node.right, n, count, result);
    }

    // Helper method to perform a left rotation on a given node
    Node rotateLeft(Node root, Node p) {
        if (p == null || p.right == null) {
            return root;
        }

        Node newRoot = p.right;
        p.right = newRoot.left;
        newRoot.left = p;

        // If p is the root of the tree
        if (root == p) {
            return newRoot;
        }

        // Otherwise, attach newRoot back to the original parent
        Node parent = findParent(root, p);
        if (parent != null) {
            if (parent.left == p) {
                parent.left = newRoot;
            } else {
                parent.right = newRoot;
            }
        }

        return root;
    }

    // Helper method to find the parent of a given node
    Node findParent(Node root, Node child) {
        if (root == null || root == child) {
            return null;
        }

        if (root.left == child || root.right == child) {
            return root;
        }

        Node leftSearch = findParent(root.left, child);
        if (leftSearch != null) {
            return leftSearch;
        }

        return findParent(root.right, child);
    }
}
