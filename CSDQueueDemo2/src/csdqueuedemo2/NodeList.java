/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csdqueuedemo2;

import java.util.Scanner;

/**
 *
 * @author tranp
 */
public class NodeList {

    Node head, tail;

    void Enqueue(int x) {
        Node p = new Node(x);
        if (head == null) {
            head = tail = p;
        } else {

            tail.link = p;
            tail = p;
        }
    }

    int Dequeue() {
        int x = head.data;
        head = head.link;
        return x;
    }

    int getFirst() {
        return head.data;
    }

    void outPut() {
        while (!isEmpty()) {
            int x = Dequeue();
            System.out.println(x + " ");
        }
    }

    boolean isEmpty() {
        return (head == null);
    }

    void input() {
        System.out.print("Enter number of Queue: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            int x = sc.nextInt();
            Enqueue(x);
        }
    }

}
