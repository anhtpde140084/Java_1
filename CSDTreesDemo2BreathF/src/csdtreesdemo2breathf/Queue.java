/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csdtreesdemo2breathf;

import java.util.Scanner;

/**
 *
 * @author tranp
 */

public class Queue {

    int S[];
    int last, first; // keep the first and last position in array
    int MAX = 100;

    Queue() {
        S = new int[MAX];
        first = last = 0;
    }

    Queue(int size) {
        MAX = size;
        S = new int[MAX];
        first = last = 0;
    }

    void Enqueue(int x) { // enter data into queue
        if (NumberOfEle() == MAX) // if S is full
        {
            return;
        } else {
            S[last] = x;
            last = (last + 1) % MAX; // set last to new slot
        }
    }

    int dequeue() { //output data 
        int x = S[first];
        first = (first + 1) % MAX; // get first 
        return x;
    }
    int getFirst(){ // return the first element without removing it
        return S[first];
    }
    boolean isEmpty() {
        return (first == last);
    }

    int NumberOfEle() { // return the number of element
        return (MAX + last - first) % MAX;
    }

    void outPut() {
        while (!isEmpty()) {
            int x = dequeue();
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
            Enqueue(x);
        }
    }

    public static void main(String[] args) {
        Queue pr = new Queue(); // create a queue pr with 5 elements
        pr.input();
        System.out.println("First number of Queue: " +  pr.getFirst());
        System.out.println("Result after take out");
        pr.outPut();
    }

}


