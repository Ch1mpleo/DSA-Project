
import java.util.*;
import java.io.*;

class MyTree {

    Node root;

    MyTree() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node p, int value) {
        if (p == null) {
            p = new Node(value);
        } else if (value < p.info) {
            p.left = insertRec(p.left, value);
        } else if (value > p.info) {
            p.right = insertRec(p.right, value);
        }
        return p;
    }

    public void load() {
        insert(20);
        insert(10);
        insert(30);
        insert(5);
        insert(15);
        insert(25);
        insert(35);
        insert(100);

    }

    int search(Node p, int x) {
        if (p == null) {
            return 0;
        }
        if (p.info == x) {
            return 1;
        }
        if (x < p.info) {
            return (search(p.left, x));
        } else {
            return (search(p.right, x));
        }
    }

    public int f1() {
        return 0;
    }

    public int f2() {
        return 0;
    }

    public int f3() {
        return 0;
    }

    public int f4() {
        return 0;
    }

    void visit(Node p) {
        System.out.print(p.info + "  ");
    }

    void preOrder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    void f5() {
        preOrder(root);
    }

    void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    void f6() {
        inOrder(root);
    }

    void postOrder(Node p) {
        if (p == null) {
            return;
        }
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }

    void f7() {
        postOrder(root);
    }

    int f8(int n) {
        return search(root, n);
    }

    void f9() {
        printEvenAscending(root);
    }

    //Hàm lấy số chẵn tăng dần - giống như InOrder trên add thêm if statement
    void printEvenAscending(Node p) {
        if (p == null) {
            return;
        }
        printEvenAscending(p.left);
        if (p.info % 2 == 0) {
            visit(p);
        }
        printEvenAscending(p.right);
    }
    void f10() {

    }
    void f11() {

    }
    void f12() {

    }

    class Rotations
    {
        /**
         * Rotate binary tree node with left child.
         * For AVL trees, this is a single rotation for case 1.
         */
        static Node rotateWithLeftChild( Node k2 )
        {
            Node k1 = k2.left;
            k2.left = k1.right;
            k1.right = k2;
            return k1;
        }


        /**
         * Rotate binary tree node with right child.
         * For AVL trees, this is a single rotation for case 4.
         */
        static Node rotateWithRightChild( Node k1 )
        {
            Node k2 = k1.right;
            k1.right = k2.left;
            k2.left = k1;
            return k2;
        }

        /**
         * Double rotate binary tree node: first left child
         * with its right child; then node k3 with new left child.
         * For AVL trees, this is a double rotation for case 2.
         */
        static Node doubleRotateWithLeftChild( Node k3 )
        {
            k3.left = rotateWithRightChild( k3.left );
            return rotateWithLeftChild(k3);
        }

        /**
         * Double rotate binary tree node: first right child
         * with its left child; then node k1 with new right child.
         * For AVL trees, this is a double rotation for case 3.
         */
        static Node doubleRotateWithRightChild( Node k1 )
        {
            k1.right = rotateWithLeftChild( k1.right );
            return rotateWithRightChild(k1);
        }

        static void visualizeTree(Node node, String prefix, boolean isLeft) {
            if (node == null) {
                return;
            }

            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.info);
            visualizeTree(node.left, prefix + (isLeft ? "│   " : "    "), true);
            visualizeTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
        }
    }


}
