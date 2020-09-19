
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tranp
 */
public class CSD201RandomArray {

    private  final Scanner in = new Scanner(System.in);
    int[] A;
    int n = checkInput();
    int checkInput() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                return result;
            } catch (Exception e) {
                System.out.print("Please input the integer number Enter again: ");
            }
        }
    }

    int numberOfArray() {
        System.out.print("Enter number of array: ");
        int n = checkInput();
        return n;
    }

    void outPut(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println("A[" + i + "] = " + a[i]);
        }
        System.out.println("Array is: ");
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("]");
    }

    /* void find(int[] a, int x){
        for (int i = 0; i < a.length ; i++) {
            if(a[i] == x) {
                System.out.println(x + " possition is: " + i);
            }
             else  if(a[i] != x)
            {
                System.out.println(x+ " Not found!!!");
                break;
            } 
        }
    } */
    void find(int[] a, int x) {
        int i = 0;
        while (i < n) {
            if (a[i] == x) {
                System.out.println("\n" + x + "is found at " + i);
                break; //stop while
            }
            i++;
        }
        if (i >= n) {
            System.out.println("\n" + x + " is not found.");
        }
    }

    void insert(int[] a, int length, int x,int p) {
        length++;
        for (int i = length; i > p; i--) {
            a[i] = a[i - 1];
        }
        a[p] = x;
    }

    public static void main(String[] args) {
        CSD201RandomArray pr = new CSD201RandomArray();
        
        int[] A = new int[100];
        int length = pr.checkInput();
        for (int i = 0; i < length; i++) {
            A[i] = new Random().nextInt(length);
        }
        pr.outPut(A);
        System.out.print("Enter number want to find: ");
        int x = pr.checkInput();
        pr.find(A, x);
        System.out.println("Enter number want to insert: ");
        int m = pr.checkInput();
        System.out.println("Enter possiton want to put");
        int p = pr.checkInput();
        pr.insert(A, length,m, p);
        pr.outPut(A);
    }
}
