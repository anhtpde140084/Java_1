/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csdgraphdemo;

import java.util.EmptyStackException;
import java.util.Scanner;

/**
 *
 * @author tranp
 */
public class Stack {

    /**
     * @param args the command line arguments
     */
    int S[]; //an array to store data
    int top; // store top position
    int MAX = 100; // maximum size of stack

    Stack(int size) { // initial a stack with actual size
        S = new int[size];
        top = -1;
    }

    Stack() {
        S = new int[MAX]; // initial a stack with maximum size
        top = -1;
    }

    boolean isEmpty() { // check stack empty
        return (top == -1);
    }

    void Push(int x) {
        if (top == MAX - 1) // S is full 
        {
            System.out.println("Stack is full. " + x + "is not adding.");
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
    void outPut(){
        while(!isEmpty()){
            int x = pop();
            System.out.println(x + " ");
        }
    }
    void input() {
        System.out.print("Enter number of stack: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            int x = sc.nextInt();
            Push(x);
        }
    }

   

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        Stack pr = new Stack(); // we use struct with 5 elements
        Stack A = new Stack(); //we use struct with 100 elements
        pr.input();
        System.out.println("This is stack when take out");
        System.out.println("----");
        pr.outPut();
        System.out.println("----");
    }

}
