/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd201recursiondemo1;

import java.util.Scanner;
import java.util.Stack;
import jdk.nashorn.internal.objects.NativeArray;

/**
 *
 * @author tranp
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    // factor
    static double fact(double x) {
        if (x == 1 || x == 0) {
            return 1;
        } else {
            return x * fact(x - 1);
        }
    }

    // fibonancy
    static int fibonancy(int n) {
        if (n == 0) {
            return 0;
        } else if (n < 2) {
            return 1;
        } else {
            return (fibonancy(n - 1) + fibonancy(n - 2));
        }

    }

    // print digits fibonanci
    static int fibonanciLoop(int n) {
        int f0 = 0, f1 = 1, fn = 1;
        if (n < 0) {
            return -1;
        } else if (n < 2) {
            return n;
        } else {
            for (int i = 2; i < n; i++) {
                f0 = f1;
                f1 = fn;
                fn = f0 + f1;
            }
        }
        return fn;
    }

    //print Fibo
    static void printFibo(int x) {

        for (int i = 0; i < x; i++) {
            System.out.print(" " + fibonancy(i));
        }
        System.out.println("");

    }

    // print Loop
    static void printFiboLoop(int x) {
        for (int i = 0; i < x; i++) {
            System.out.print(" " + fibonanciLoop(i));
        }
        System.out.println("");
    }

    // convert Decima to Binary
    static void DecToBinary(int n) {

        int res;
        if (n == 0) {
            return;
        } else {
            res = n % 2;
            // this is also stack
            DecToBinary(n / 2);
            System.out.print(res);
        }

    }

    // using stack
    static void convertDecToBi(int n) {
        Stack<Integer> stk = new Stack<Integer>();
        while (n != 0) {
            int res = n % 2;
            stk.push(res);
            n /= 2;
        }
        while (!stk.isEmpty()) {
            System.out.print(stk.pop());
        }
    }

    // hanoi tower math   
    static void HanoiTowel(int n, char A, char B, char C) {
        if (n == 1) {
            System.out.println("Move disk " + n + " from " + A + " to " + C);
            return;
        } else {
            HanoiTowel(n - 1, A, C, B);
        }
        System.out.println("Move disk " + n + " from " + A + " to " + C);
        HanoiTowel(n - 1, B, A, C);
    }

    // SUM of decres of N
    static int SumOfdigits(int n) {
        int sum = 0;
        if (n == 0) {
            return 0;
        } else {
            int res = n % 10;
            sum = res + SumOfdigits(n / 10);
        }

        return sum;
    }

    // main function
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number: ");
        double n = in.nextLong();
        System.out.println(n + "!= " + fact(n));
        System.out.print("Enter number of fibonaci: ");

        int x = in.nextInt();
        double start = System.currentTimeMillis();
        printFibo(x);

        double end = System.currentTimeMillis();
        double d = end - start;

        double st = System.currentTimeMillis();
        printFiboLoop(x);
        double e = System.currentTimeMillis();
        double t = e - st;
        System.out.println(" Running time for recursion fibo: " + d);
        System.out.println(" Running time for loop fibo: " + t);
        System.out.println("Using loop to convert: ");
        DecToBinary(8);
        // convert
        System.out.println("Using stack to convert: ");
        convertDecToBi(8);
        System.out.println("");
        HanoiTowel(3, 'A', 'B', 'C');
        // sum of digit
        System.out.println("Enter digits to sum: ");
        int l = in.nextInt();
        System.out.println("SUM(" + l + ") = " + SumOfdigits(l));

    }
}
