/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csdgraphdemo;

import java.util.Scanner;

/**
 *
 * @author tranp
 */
public class Queue {

    int Q[];
    int last, first; // keep the first and last position in array
    int MAX = 100;

    Queue() {
        Q = new int[MAX];
        first = last = 0;
    }

    Queue(int size) {
        MAX = size;
        Q = new int[MAX];
        first = last = 0;
    }

    void Enqueue(int x) { // enter data into queue
        if (NumberOfEle() == MAX) // if S is full
        {
            return;
        } else {
            Q[last] = x;
            last = (last + 1) % MAX; // set last to new slot
        }
    }

    int dequeue() { //output data 
        int x = Q[first];
        first = (first + 1) % MAX; // get first 
        return x;
    }
   
    boolean isEmpty() {
        return (first == last);
    }

    int NumberOfEle() { // return the number of element
        return (MAX + last - first) % MAX;
    }


}
