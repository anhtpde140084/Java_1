/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmark;

import java.util.Scanner;

/**
 *
 * @author tranp
 */
public class Validation {
    Scanner in = new Scanner(System.in);
    public  int checkInput() {
        while (true) {
            try {
                 int result = java.lang.Integer.parseInt(in.nextLine().trim());
                return result;
            } catch(Exception e){
                System.out.println("Please enter integer number: ");
        }
    }
    }
     public  String checkInputString() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }
}
