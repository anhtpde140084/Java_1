/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csdhashlist;

import java.util.LinkedList;

/**
 *
 * @author tranp
 */
public class Node {

    int data; //store data
    Node next; // pointed link to other Node

    Node() {
    } // create an empty Node

    Node(int x) // create a Node whith data x
    {
        this.data = x;
        this.next = null;
    }

}
