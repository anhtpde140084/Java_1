/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author tranp
 */
public class CSD201cPreTest {

    /**
     * @param args the command line arguments
     */
    private static final Scanner in = new Scanner(System.in);

    private int checkInput() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                return result;
            } catch (Exception e) {
                System.out.print("Please input the integer number Enter again: ");       
            }
        }
    }
    // use recursion
  /*  static int fact(int n){
        if(n == 0) return 1;
        else return n * fact(n-1);
    } */

    public static void main(String[] args) {
        // TODO code application logic here
        CSD201cPreTest pr1 = new CSD201cPreTest();
        int result = 1;
        System.out.println("Enter number: ");
        int n = pr1.checkInput();
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        System.out.println(n + "!= " + result);
    }

}
