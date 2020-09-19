/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csdhash;

import java.util.Scanner;

/**
 *
 * @author tranp
 */
public class CSDHash {

    /**
     * @param args the command line arguments
     */
    int M; //store size of hash table
    int H[]; // table store

    CSDHash(int size) {
        this.M = size;
        this.H = new int[M];
    }

    // this default size m = 10;
    public CSDHash() {
        M = 10;
        H = new int[M];
    }

    //-----------------------------------
    // this is division function
    int HashFunction(int key) {
        return key % M;
    }

    //-----------------------------------
    // put x into hash table
    void hashing(int x) {
        int i = HashFunction(x); // compute the index i;
        H[i] = x;               // put x into slot indexed by i

    }

    void linearProbing(int x) {
        int i = 0;
        int index;
        index = HashFunction(x); // calculate the index for the first time;
        while (i < M && H[index] > 0) // if I< m and at position at index have data
        {
            i++;
            index = HashFunction(x) + i;
        }
        if (i == M) {
            System.out.println(x + " can not be hashed.");
        } else {
            H[index] = x;
        }
    }

    void Quadratic(int x) {
        int i = 0;
        int index = HashFunction(x);
        while (i < M && H[index] > 0) {//
            i++;
            index = (int) (HashFunction(x) + Math.sqrt(i));
        }
        if (i == M) {
            System.out.println(x + " can not be hashed");
        } else {
            H[index] = x;
        }
    }

    void input() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of array: ");
        int size = in.nextInt();
        for (int i = 0; i < size; i++) {
            System.out.print("Enter number: ");
            int x = in.nextInt();
            // hashing(x);
            //linearProbing(x);
            Quadratic(x);
        }
    }

    void output() {
        System.out.print("Array is: ");
        for (int i = 0; i < M; i++) {
            System.out.print(" " + H[i]);
        }
    }

    int Find(int x) {

        int index = HashFunction(x); //get the index
        int r = H[index]; // get the value at table
        if (x == r) {
            return x;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        CSDHash hash = new CSDHash(5);
        hash.input();
        hash.output();
        System.out.println(" ");
        System.out.println("Enter x to find: ");
        int x = in.nextInt();
        int f = hash.Find(x);
        if (f == -1) {
            System.out.println(x + " is not found");
        } else {
            System.out.println("Vi tri cua " + x + " la: " + hash.Find(x));
        }

    }

}
