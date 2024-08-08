import java.util.*;
import java.io.*;

public class MyList {
    Node head, tail;
    int size;

    MyList() {
        this.head = null;
        this.tail=null;
        this.size = 0;
    }
    
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while(p != null) {
            f.writeBytes(p.info.name + "-" + p.info.price + "     "); // write data in the node p to the file f
            p = p.next;
        }
        
        f.writeBytes("\r\n");
    }
    
    void loadData(int k) {
        String [] a = Lib.readLineToStrArray("data.txt", k);
        String [] b = Lib.readLineToStrArray("data.txt", k+1);
        int n = a.length;
        for(int i = 0; i < n; i++) 
        {
            int p = Integer.parseInt(b[i]);
            
            addLast(a[i], p);
        }
    }
     
    void addLast(String n, int p) {
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        Phone data = new Phone(n,p);
        Node tmp_Node = new Node(data);

           
       if (head == null)
       {
           head = tail = tmp_Node;
       }
       else
       {
           tail.next = tmp_Node;
           tail = tail.next;
       }
       size++;
        
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
    }
    
	// f1: ham nay se goi ham addLast nhieu lan
    void f1() throws Exception {
        clear();
        loadData(0);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw"); 
        ftraverse(f);
        f.close();
    }
    
	// f2: ham addFirst ==> du lieu nhap tu ban phim
    void f2() throws Exception {
        clear();
        loadData(0);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
        ftraverse(f);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        head = new Node();

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    
    // f3: ham computeSum ==> tinh tong gia tri cua tat ca cac Phone co trong list
    void f3() throws Exception {
        clear();
        loadData(0);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
        ftraverse(f);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        int sum = 0;
        Node t = head;
        while(t != null) {
            sum = sum + t.info.price;
            t = t.next;
        }
        System.out.println("Sum of list: " + sum);
        

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    
	// f4: remove the most expensive Phone
    void f4() throws Exception {
        clear();
        loadData(0);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw"); 
        ftraverse(f);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        findMaxAndRemove();
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void findMaxAndRemove() {
        if (head == null) return; // Empty list

        Node maxNode = head;
        Node prevMaxNode = null;
        Node current = head;
        Node prev = null;

        // Find the node with the maximum price and its previous node
        while (current != null) {
            if (current.info.price > maxNode.info.price) {
                maxNode = current;
                prevMaxNode = prev;
            }
            prev = current;
            current = current.next;
        }

        // Remove the maxNode
        if (maxNode == head) { // Max is at the head
            head = head.next;
        } else {
            prevMaxNode.next = maxNode.next;
        }

        System.out.println("Removed the most expensive phone: " + maxNode.info.name + " (Price: " + maxNode.info.price + ")");
    }




    // f5: discount all Phone 'S' with 10%
	 void f5() throws Exception {
        clear();
        loadData(0);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
        ftraverse(f);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        discountPhonesS();

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void discountPhonesS() {
        Node current = head;
        while (current != null) {
            if (current.info.name.equalsIgnoreCase("S")) { // Case-insensitive comparison
                current.info.price = (int) (current.info.price * 0.9); // Apply 10% discount
                System.out.println("Discounted phone 'S': New price = " + current.info.price);
            }
            current = current.next;
        }
    }
  
}

