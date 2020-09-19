/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csdhashlist;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author tranp
 */
public class Hash {

    LinkList H[]; // hash table
    int M; // size of hash table

    Hash() {
        this.M = 10;
        H = new LinkList[M];
        for (int i = 0; i < M; i++) {
            H[i] = new LinkList();

        }
    }

    Hash(int size) {
        this.M = size;
        H = new LinkList[M];
        for (int i = 0; i < M; i++) {
            H[i] = new LinkList();
        }
    }

    int HashFunction(int key) {
        return key % M; //use division function
    }

    void Hashing(int x) {
        int i = HashFunction(x); // compute the index i;
        H[i].input(x);
    }

//    void input() {
//        System.out.println("Enter the size of: ");
//        Scanner in = new Scanner(System.in);
//        int size = in.nextInt();
//        for (int i = 0; i < size; i++) {
//            System.out.print("Enter number: ");
//            int x = in.nextInt();
//            Hashing(x);
//        }
//    }
    //input random function
    void input() {
        Scanner in = new Scanner(System.in);
        Random rd = new Random();
        System.out.println("Enter the number of keys: ");
        int n = in.nextInt();
        for (int i = 0; i <= n; i++) {
            int k = rd.nextInt(100); // randomly generate numbers 0-99
            Hashing(k);
        }
    }

    void outPut() {
        System.out.println("Array is: ");
        for (int i = 0; i < M; i++) {
            H[i].traverse();
        }
    }

    int find(int x) {
        int index = HashFunction(x);
        int r = H[index].search(x);
        if (x == r) {
            return x;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Hash h = new Hash(5);
        h.input();
        h.outPut();
        System.out.println("Enter x to find: ");
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int f = h.find(x);
        if (f == -1) {
            System.out.println(x + " can not found");
        } else {
            System.out.println(x + " is found");
        }
    }

}
