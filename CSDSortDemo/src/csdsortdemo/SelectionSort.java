/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csdsortdemo;

import java.util.Random;
import java.util.stream.Collectors;

/**
 *
 * @author tranp
 */
public class SelectionSort {

    /**
     * @param args the command line arguments
     */
    int A[] = new int[50];
    int n;

    public SelectionSort(int n) {
        this.n = n;
        A = new int[n];
    }

    void input() {
        Random rd = new Random();
        for (int i = 0; i < n; i++) {
            A[i] = rd.nextInt(10);
        }
    }

    void output() {
        for (int i = 0; i < n; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println("");
    }

    void swap(int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }

    //--------selection Sort ------------------------
    void selectionSort() {

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (A[j] < A[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(i, minIndex);
            }
        }
    }

    //--------Bubble sort----------------------------
    void bubbleSort() {
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j >= i + 1; j--) {
                if (A[j] < A[j - 1]) {
                    swap(j, (j - 1));
                }
            }
        }
    }

    //----------insertion sort --------------------
    void insertionSort() {
        for (int i = 1; i < n; i++) {
            int temp = A[i];
            int j = i;
            while (j > 0 && A[j - 1] > temp) {
                A[j] = A[j - 1]; //move by one position 
                j--;
            }
            A[j] = temp;
        }
    }

    //----------- Quick Sort -----------------
    void quickSort(int left, int right) {
        int priIndex;
        if (left < right) {
            int up = left; // the first element
            int down = right; // the last element
            priIndex = A[(left + right) / 2]; //  get the pivot value using the middle element
            // move all el that are smaller than x to the left of xl
            // move all el that are bigger than x to right of x;
            do {
                while (A[up] < priIndex) {
                    up++;
                }
                while (A[down] > priIndex) {
                    down--;
                }
                if (up <= down) //There is an el at up that >x
                //THere is an el at down that <x
                {
                    swap(up, down);
                    up++; //move to the next element
                    down--;
                }

            } while (up <= down);
            //2nd phase
            quickSort(left, down);
            quickSort(up, right);
        }
    }
    //----------- main run -------------------

    public static void main(String[] args) {
        // TODO code application logic here
        SelectionSort sl = new SelectionSort(5);
        sl.input();
        System.out.print("The array input: ");
        sl.output();
        System.out.print("After selection sort: ");
        sl.selectionSort();
        sl.output();
        sl.input();
        System.out.print("The array input bubble sort: ");
        sl.output();
        sl.bubbleSort();
        System.out.print("After bubble sort: ");
        sl.output();
        sl.input();
        System.out.print("The array input insertion sort: ");
        sl.output();
        sl.insertionSort();
        System.out.print("After insertion sort: ");
        sl.output();
        sl.input();
        System.out.print("The array input quick sort: ");
        sl.output();
        sl.quickSort(0, sl.n - 1);
        System.out.println("After quick sort: ");
        sl.output();
    }

}
