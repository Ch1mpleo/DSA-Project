// =========================================================
// Do NOT modify this file 
// =========================================================

import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws Exception {
        
        MyList t = new MyList();
        Scanner sca = new Scanner(System.in);
        System.out.print("Size of list:   ");
        int size = sca.nextInt();
        
        t.loadData(size);
        
        printMenu();
        
        int choice = sca.nextInt();
        sca.nextLine();

        switch(choice) {
            case 0:
                return;
            case 1:
                t.f1();
                break;
            case 2:
                t.f2();
                break;
            case 3: 
                t.f3();
                break;
            case 4: 
                t.f4();
                break;
            case 5: 
                t.f5();
                break;
            case 6:
                t.f6();
                break;
            case 7:
                t.f7();
                break;
            case 8:
                t.f8();
                break;
            case 9:
                t.f9();
                break;
            case 10:
                t.f10();
                break;
            default: 
                System.out.println("Invalid choice");
        }
        
        System.out.println();
    }  
    
    private static void printMenu() {
        System.out.println("=============MENU=============");
        System.out.println("1. Test f1: Add 1 node to head");
        System.out.println("2. Test f2: Add 1 node to tail");
        System.out.println("3. Test f3: Add 1 node tại vị trí k");
        System.out.println("4. Test f4: Remove 1 node from head");
        System.out.println("5. Test f5: Remove 1 node from tail");
        System.out.println("6. Test f6: Remove node > 500 value ");
        System.out.println("===========Homework===========");
        System.out.println("7. Test f7: Sum các node trong list");
        System.out.println("8. Test f8: Tìm min/max node trong list");
        System.out.println("9. Test f9: Xóa số lớn nhất trong list");
        System.out.println("10. Test f10: Đảo ngược list");
        System.out.println("==============================");
        System.out.print("Enter your choice [0 --> 9]: ");
    }
}
