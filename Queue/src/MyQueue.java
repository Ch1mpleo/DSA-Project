import java.util.*;
import java.io.*;

class MyQueue {
    Node head, tail;
 
    public MyQueue() 
	{ 
		this.head = this.tail = null; 
	}
 
    // Method to add an key to the queue.
    void enqueue(int key)
    {
        Node newNode = new Node(key);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode; // đẩy đuôi thêm 1 node
            tail = newNode;      // gán đuôi mới là tail
        }
    }
 
    // Method to remove an key from queue.
    void dequeue()
    {
        if (isEmpty()) {
            System.out.println("Queue is empty, there is nothing to dequeue");
        }
        head = head.next;
    }
     public void load() // insert at the beginning
    {
        this.enqueue(10);
        this.enqueue(14);
        this.enqueue(7);
        this.enqueue(7);
        this.enqueue(3);
        this.enqueue(2);
        this.enqueue(15);
        this.enqueue(9);
    }
 
    // Utility function to check if the stack is empty or
    // not
    public boolean isEmpty() 
	{ 
        return tail == null; //khi list queue rỗng chỉ cần ktr head, tail (1 cái null là done)
	}
 
    // Utility function to return top element in a stack
    public int front()
    {
        if (isEmpty()) {
            System.out.println("Queue is empty, no head to check");
        }
        int temp = head.info;
        return temp;
    }
   
 
    public void display()
    {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.info + " ");
            current = current.next;
        }
    }

    class PriorityNode {
        Node node;  // The original Node object
        int priority_level;

        PriorityNode(Node node, int priority_level) {
            this.node = node;
            this.priority_level = priority_level;
        }
    }
//	void enqueueWithPriority(int key, int priority_level)
//    {
//        Node newNode = new Node(key);
//        PriorityNode newPriorityNode = new PriorityNode(newNode, priority_level);
//        if (isEmpty() || priority_level > newPriorityNode.priority_level) {
//            if (head != null) {
//                newPriorityNode.node.next = head;
//            } else {
//                newPriorityNode.node.next = null;
//            }
//            head = newPriorityNode.node;
//            if (tail == null) {
//                tail = newPriorityNode.node;
//            }
//            return;
//        }
//        // Find the correct insertion point based on priority
//        PriorityNode current = head;
//        while (current.node.next != null &&
//                priorityLevel <= ((PriorityNode) current.node.next).priorityLevel) {
//            current = (PriorityNode) current.node.next;
//        }
//
//        // Insert the new node
//        newPriorityNode.node.next = current.node.next;
//        current.node.next = newPriorityNode;
//
//        // Update rear if necessary
//        if (newPriorityNode.node.next == null) {
//            rear = newPriorityNode;
//        }
//
//    }
   
}
