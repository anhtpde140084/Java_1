/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csdhashlist;

/**
 *
 * @author tranp
 */
public class LinkList {

    Node head, tail;

    public LinkList() {
        head = tail = null;
    }

    void input(int x) {
        Node p = new Node(x);
        if (head == null) {
            head = p;
            tail = p;
        } else {
            tail.next = p;
            tail = p;
        }
    }

    void traverse() // printOUt data of list
    {
        Node p = head;

        while (p != null) {
            System.out.print(" " + p.data);
            p = p.next;
        }
        System.out.println("");

    }

    int search(int x) {
        Node p = head;
        while (p != null && x != p.data) {
            p = p.next;
        }
        if (p == null) {
            return -1; // x is not found
        } else {
            return x;
        }

    }

}
