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
    void addLast(String xId, int xWeight, int xPrice) {
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        // Check if weight and price are positive
        if (xWeight > 0 && xPrice > 0) {

            // 1. Check for duplicate ID
            Node current = head;
            while (current != null) {
                if (current.info.id.equals(xId)) {
                    return; // Duplicate ID found, do not add
                }
                current = current.next;
            }

            // 2. Create new Phone and Node
            Phone newPhone = new Phone(xId, xWeight, xPrice);
            Node newNode = new Node(newPhone);

            // 3. Add to the end of the list
            if (head == null) { // Empty list
                head = tail = newNode;
            } else { // Non-empty list
                tail.next = newNode;
                tail = newNode;
            }
        }
        //---------------------------------------------------------
    }

    //==================================================================
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
        Node v = new Node(new Phone("New", 8, 9));
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        Node temp = head;

        // Traverse to the 2nd node (index 1)
        for (int i = 0; i < 1 && temp != null; i++) {
            temp = temp.next;
        }

        // If the list has at least 3 elements, insert 'v' after the 2nd node
        if (temp != null && temp.next != null) {
            v.next = temp.next;
            temp.next = v;
        }

        //---------------------------------------------------------
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
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        // Empty list, nothing to delete
        if (head == null) {
            return;
        }
        Node maxWeightNode = head, prevMax = null, current = head;
        int maxWeight = head.info.weight;

        // Find the first node with the maximum weight
        while (current.next != null) {
            if (current.next.info.weight > maxWeight) {
                maxWeight = current.next.info.weight;
                maxWeightNode = current.next;
                prevMax = current;
            }
            current = current.next;
        }

        // Delete the maxWeightNode
        if (prevMax == null) { // Max weight node is the head
            head = head.next;
        } else {
            prevMax.next = maxWeightNode.next;
            if (maxWeightNode == tail) { // Max weight node is the tail
                tail = prevMax;
            }
        }
        //---------------------------------------------------------
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
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------

        int k = countSomeThing(); // Call the helper function
        f.writeBytes(k + "\n");  // Write the count to the file

        // hint: you should write a new function named countSomeThing() for this question,
        // then assign int k = this.countSomeThing()
        // finally, you just call f.writeBytes(k + "") to complete this question.
        //---------------------------------------------------------
        f.close();
    }

    // Function to count phones with price > 5
    int countSomeThing() {
        int count = 0;
        Node current = head;
        while (current != null) {
            if (current.info.price > 5) {
                count++;
            }
            current = current.next;
        }
        return count;
    }

//==================================================================
    void f5() throws Exception {
        clear();
        loadData(17);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        
        // 1. Delete the first node
        if (head != null) {
            head = head.next;
        }

        // 2. Sort the remaining list in descending order by weight (using insertion sort)
        Node sorted = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            if (sorted == null || sorted.info.weight <= current.info.weight) {
                current.next = sorted;
                sorted = current;
            } else {
                Node temp = sorted;
                while (temp.next != null && temp.next.info.weight > current.info.weight) {
                    temp = temp.next;
                }
                current.next = temp.next;
                temp.next = current;
            }
            current = next;
        }
        head = sorted;
        //---------------------------------------------------------
        ftraverse(f);
        f.close();
    }
}
