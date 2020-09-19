/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csdminitest;

import java.util.EmptyStackException;
import java.util.Scanner;

/**
 *
 * @author tranp
 */
public class TranPhiAnh {

    /**
     * @param args the command line arguments
     */
    int S[]; //an array to store data
    int top; // store top position
    int MAX = 8; // maximum size of stack
    static TranPhiAnh st = new TranPhiAnh();

    TranPhiAnh(int size) { // initial a stack with actual size
        S = new int[size];
        top = -1;
    }

    TranPhiAnh() {
        S = new int[MAX]; // initial a stack with maximum size
        top = -1;
    }

    boolean isEmpty() { // check stack empty
        return (top == -1);
    }

    void Push(int x) {

        if (top == MAX - 1) // S is full 
        {
           
            return; // stop pushing
        } else {
            top++; // increase the top by one
            S[top] = x; // put x to top
        }
    }

    int pop() throws EmptyStackException {
        int x = -1;
        if (!isEmpty()) {
            x = S[top]; // take out the top element
            top--; // decrease the top by one

        };
        return x;
    }

    void outPut() {

        while (!isEmpty()) {
            int x = pop();
            System.out.print(x);
        }
    }

    void convertDecimaToBinary(int n) {
        int count =0;
        if (n == 0) {
            return;
        } while(n!=0){
            int res = n % 2;
            st.Push(res);
            n = (n / 2); 
            count++;
        }
         for (int i = 0; i < count; i++) {
            st.Push(0);
        }
        outPut();
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number to convert: ");
        int n = in.nextInt();
        System.out.print("After convert is: ");
        st.convertDecimaToBinary(n);
        System.out.println("");
    }

}
