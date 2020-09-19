/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csdtesting;

/**
 *
 * @author tranp
 */
public class CSDTESTING {

    /**
     * @param args the command line arguments
     */
    int fun2(int n) {
        if (n < 0) {
            return (fun2(-n));
        } else if (n < 5) {
            return 2;
        } else return (n*fun2(n-2));

    }

    void fun(int n) {
        if (n <= 0) {
            System.out.println("That all");
        } else {
            for (int i = 1; i <= n; i++) {
                System.out.print("*");
            }
            System.out.println("");
            fun(n - 2);
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        CSDTESTING c = new CSDTESTING();
        c.fun(5);
        System.out.println("" + c.fun2(5));
    }

}
