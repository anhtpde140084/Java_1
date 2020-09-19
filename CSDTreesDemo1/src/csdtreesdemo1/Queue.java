/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csdtreesdemo1;

import java.util.Scanner;

/**
 *
 * @author tranp
 */
public class Queue {

    Node S[];
    int last, first; // keep the first and last position in array
    int MAX = 100;

    Queue() {
        S = new Node[MAX];
        first = last = 0;
    }

    Queue(int size) {
        MAX = size;
        S = new Node[MAX];
        first = last = 0;
    }

    void Enqueue(Node x) { // enter data into queue
        if (NumberOfEle() == MAX) // if S is full
        {
            return;
        } else {
            S[last] = x;
            last = (last + 1) % MAX; // set last to new slot
        }
    }

    Node dequeue() { //output data 
        Node x = S[first];
        first = (first + 1) % MAX; // get first 
        return x;
    }

    Node getFirst() { // return the first element without removing it
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
            Node x = dequeue();
            System.out.println(x + " ");
        }
    }
    

}
