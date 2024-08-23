/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
     */
    void addLast(String xPlace, int xPrice, int xType) {
        //You should write here appropriate statements to complete this function.
        if (xPlace.charAt(0) != 'A') {
            Brick newBrick = new Brick(xPlace, xPrice, xType);
            Node newNode = new Node(newBrick);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
    }

//You do not need to edit this function. Your task is to complete the addLast function above only.
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        Brick x, y, z;
        x = new Brick("X", 1, 2);
        y = new Brick("Y", 2, 3);
        z = new Brick("Z", 3, 4);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node temp = head;

        // Insert x at position 1 (after head)
        Node xNode = new Node(x, temp.next);
        temp.next = xNode;
        temp = temp.next;

        // Insert y at position 2
        Node yNode = new Node(y, temp.next);
        temp.next = yNode;
        temp = temp.next;

        // Traverse to position 5 - (from node 2 -> 5) 
        for (int i = 0; i < 2; i++) {
            temp = temp.next;
        }

        // Insert z at position 5
        Node zNode = new Node(z, temp.next);
        temp.next = zNode;
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

        //Search node E and G
        Node prevE = null, currE = head;
        while (currE != null && !currE.info.place.equals("E")) {
            prevE = currE;
            currE = currE.next;
        }

        Node prevG = null, currG = head;
        while (currG != null && !currG.info.place.equals("G")) {
            prevG = currG;
            currG = currG.next;
        }

        // Handle case where "E" or "G" is not found
        if (currE == null || currG == null) {
        } else {
            // Swap the nodes
            if (prevE != null) {
                prevE.next = currG;
            } else {
                head = currG;
            }

            if (prevG != null) {
                prevG.next = currE;
            } else {
                head = currE;
            }

            Node temp = currE.next;
            currE.next = currG.next;
            currG.next = temp;
        }
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        
       
        Node p = head;
        Node prev = null;
        Node lastSortedNode = null;
        Node startNode = head;

         // Find the node with place = "I"
        while (p != null && !p.info.place.equals("I")) {
            lastSortedNode = prev;
            prev = p;
            p = p.next;
        }

        // If the node with place = "I" is found
        if (p != null && p.info.place.equals("I")) {
            // Now sort the nodes before the node p
            Node current = startNode;
            while (current != p) {
                Node nextNode = current.next;
                Node minNode = current;

                Node iter = current.next;
                while (iter != p) {
                    if (iter.info.type < minNode.info.type) {
                        minNode = iter;
                    }
                    iter = iter.next;
                }

                // Swap the data if a smaller type is found
                if (minNode != current) {
                    Brick temp = current.info;
                    current.info = minNode.info;
                    minNode.info = temp;
                }

                current = current.next;
            }
        }

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

}
