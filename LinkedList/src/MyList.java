import java.util.*;
import java.io.*;

public class MyList {
    Node head;

    MyList() {
        this.head = null;
    }
    
    public boolean isEmpty() {
        return this.head == null;
    }
    
    public void clear() {
        this.head = null;
    }
    
    void traverse(){
        Node p = head;
        while(p != null) {
            System.out.print(p.info);
            System.out.print("   ");
            p = p.next;
        }
    }
    
    void loadData(int k) {
        for(int i = 0; i < k; i++) 
        {
            Random generator = new Random();
            int number = generator.nextInt(1000) + 1;
            addFirst(number);
        }
    }
     
    void addFirst(int n) {
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        head = new Node(n, head);       //Khởi tạo head first

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
    }
    
    void addLast(int n) {
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------

        //Check head
        if (head == null) {
            head = new Node(n, null);
        }
        //Khai báo tail
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = new Node(n);
        
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
    }
    
    void f1(){
        System.out.print("Linked list:   ");
        this.traverse();
    }
    
    // f2: ham addLast ==> du lieu nhap tu ban phim
    void f2(){
        System.out.print("Before:   ");
        this.traverse();
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------

        Scanner sca = new Scanner(System.in);
        System.out.print("\nAdd new tail: ");
        int k = sca.nextInt();
        this.addLast(k);

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        System.out.print("After:    ");
        this.traverse();
    }
    
    // f3: ham addPos ==> them node vao vi tri thu k, trong do node moi va chi so k duoc nhap tu ban phim
    void f3(){
        System.out.print("Before:   ");
        this.traverse();
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("\nEnter the index you want to insert: ");
            int k = scanner.nextInt();
            System.out.print("Enter the value to insert: ");
            int value = scanner.nextInt();

            Node newNode = new Node(value);

            // Insert at the beginning
            if (k == 0) {
                newNode.next = head;
                head = newNode;
            } else {
                Node current = head;
                int count = 0;
                while (current != null && count < k - 1) {
                    current = current.next;
                    count++;
                }

                if (current == null) {
                    System.out.println("Invalid index. Index out of bounds.");
                    return;
                }

                newNode.next = current.next;
                current.next = newNode;
            }
        } catch (Exception e) {}


        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        System.out.print("After:    ");
        this.traverse();
    }
    
    // f4: removeFirst
    void f4() {
        System.out.print("Before:   ");
        this.traverse();
        System.out.println();
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        if (head != null) {
            head = head.next;   //đẩy head qua cái mói
        }
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        System.out.print("After:    ");
        this.traverse();
    }
	
    // f5: removeLast
    void f5() throws Exception {
        System.out.print("Before:   ");
        this.traverse();
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------

        // Check list có rỗng thì ko cần remove
        if (head == null) {
            throw new IllegalStateException("Empty list");
        }

        // Nếu chỉ còn 1 node, set head = null
        if (head.next == null) {
            head = null;
            return;
        }

        // Đặt 1 node flag
        Node secondToLast = head;
        while (secondToLast.next.next != null) {
            secondToLast = secondToLast.next;
        }

        // Set the next of the second-to-last node to null, effectively deleting the last node
        secondToLast.next = null;

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        System.out.print("After:    ");
        this.traverse();
    }

    // f6: remove số lớn hơn 500 - sửa lại
    void f6() throws Exception {
        System.out.print("Before:   ");
        this.traverse();
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        if (head == null) {
            throw new IllegalStateException("Empty list");
        }

        // Handle the head separately
        while (head != null && head.info > 500) { // Remove leading nodes > 500
            System.out.println("Deleting node with value: " + head.info);
            head = head.next;
        }

        // The entire list might have been removed
        if (head == null) {
            return;
        }

        // Now traverse and remove nodes after the head
        Node current = head;
        while (current.next != null) {
            if (current.next.info > 500) { // Found a node > 500
                System.out.println("\nDeleting node with value: " + current.next.info);
                current.next = current.next.next; // Skip over it
            } else {
                current = current.next; // Move to the next node
            }
        }
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        System.out.print("\nAfter:    ");
        this.traverse();
    }

    // f7: Sum các node trong list
    void f7() throws Exception {
        System.out.print("Before:   ");
        this.traverse();
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        if (head == null) {
            throw new IllegalStateException("Empty list");
        }
        int flag = 0;
        Node currentNode = head;
        while (currentNode != null) {
            flag += currentNode.info;
            currentNode = currentNode.next;
        }
        System.out.println("\nSum all node: " + flag);
    }

    void f8() throws Exception {
        System.out.print("Before:   ");
        this.traverse();
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        System.out.println("\nNode max trong list: " + findMaxValue());
        System.out.println("Node min trong list: " + findMinValue());
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------

    }

    public int findMinValue() {
        if (head == null) {
            throw new IllegalStateException("Empty list");
        }
        int minValue = head.info;
        Node current = head.next;
        while (current != null) {
            if (current.info < minValue) {
                minValue = current.info;
            }
            current = current.next;
        }
        return minValue;
    }

    public int findMaxValue() {
        if (head == null) {
            throw new IllegalStateException("Empty list");
        }
        int maxValue = head.info;
        Node current = head.next;
        while (current != null) {
            if (current.info > maxValue) {
                maxValue = current.info;
            }
            current = current.next;
        }
        return maxValue;
    }



    void f9() throws Exception {
        System.out.print("Before:   ");
        this.traverse();
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        if (head == null) {
            throw new IllegalStateException("Empty list");
        }

        //Dùng hàm trên
        int maxValue = findMaxValue();

        //Check nếu max là head
        if (head.info == maxValue) {
            head = head.next;
            return;
        }

        Node current = head;
        //Tìm node trước max
        while (current.next != null && current.next.info != maxValue) {
            current = current.next;
        }

        //Delete max node
        if (current.next != null) {
            System.out.println("\nNode max đã bị xóa: " + maxValue);
            current.next = current.next.next;
        }
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        System.out.print("After:    ");
        this.traverse();
    }

    void f10() throws Exception {
        System.out.print("Before:   ");
        this.traverse();
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        //Check node null hoặc single node
        if (head == null || head.next == null) {
            return;
        }
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;  //update lại head
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        System.out.print("\nAfter:    ");
        this.traverse();
    }


}

