/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csdmidtermtest;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author tranp
 */
public class Queue {

    int last, first;
    char Q[];
    int max;

    boolean full = false;

    public Queue(int size) {
        max = size;
        Q = new char[max];
        last = 0;
        first = 0;
    }

    boolean isEmpty() {
        return last == first;
    }

    int numOfEle() {
        return (max + last - first) % max;
    }

    void enQueue(char x) {

        Q[last] = x;
        last = (last + 1) % max;

    }

    char deQueue() {

        char x = Q[first];
        first = (first + 1) % max;

        return x;

    }

    String transfer(String s) {
        String dest = "";
        int count = 0;
        for (int i = 0; i < s.length(); i++) {

            enQueue(s.charAt(i));
            if ((numOfEle() == max - 1) || (i == s.length() - 1)) {
                while (first != last) {
                    char x = deQueue();
                    dest = dest + x;
                }
                count++;
            }
        }
        System.out.println("number of buffer: " + count);
        return dest;
    }
    void test(String s){
        while(!s.isEmpty()){
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i)=='*'){
                    char x = deQueue();
                } else enQueue(s.charAt(i));
            }
              while(!s.isEmpty()){
            System.out.println(deQueue());
        }
        }
      
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue Q = new Queue(10);
//        System.out.println("Enter String 1: ");
//        String S = in.nextLine();
//        System.out.println("Lenght of string:  " + S.length());
//        double st = System.currentTimeMillis();
//        System.out.println(Q.transfer(S));
//        double e = System.currentTimeMillis();
//        double t = e - st;
//        System.out.println(" Running time for transfer: " + t);
        Q.test("HowAre***You**To**Day");
    }
}
