package csdhash;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tranp
 */
public class Node {

    int data;
    Node next;

    Node() {

    }
    Node(int x) // create a Node whith data x
    {
        this.data = x;
        this.next = null;
    }
}
