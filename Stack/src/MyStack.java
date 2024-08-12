import java.util.*;
import java.io.*;

class MyStack {
    Node top;
    // Constructor
    MyStack() { this.top = null; }
 
    public void push(int x) // insert at the beginning
    {
        Node newNode = new Node(x);
        if (isEmpty()) {
            top = newNode;
        } else {
            newNode.next = top; // đẩy giá trị của top đầu xuống
            top = newNode;      // gán giá trị mới vào top
        }
    }
    
     public void load() // insert at the beginning
    {
        this.push(10);
        this.push(14);
        this.push(7);
        this.push(7);
        this.push(3);
        this.push(2);
        this.push(15);
        this.push(9);
    }
 
    // Utility function to check if the stack is empty or
    // not
    public boolean isEmpty() { return top == null; }
 
    // Utility function to return top element in a stack
    public int peek()
    {
        if (isEmpty()) {
            System.out.println("Stack is empty, no top to peek");
        }
        int temp = top.info;
        System.out.print("\nTop info: " + top.info);
        return temp;
    }
 
    // Utility function to pop top element from the stack
    public void pop() // remove at the beginning
    {
        if (isEmpty()) {
            System.out.println("Stack is empty no need to pop");
        } else {
            top = top.next;
        }
    }
 
    public void display()
    {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        }
		Node current = top;
        while (current != null) {
            System.out.print(current.info + " ");
            current = current.next;
        }
    }
}
