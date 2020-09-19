/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0079;

import java.util.Scanner;

/**
 *
 * @author tranp
 */
public class Validation {

    Scanner in = new Scanner(System.in);

    public int checkIntLimit(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(in.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException e) {
                System.out.println("Enter again: ");
            }
        }
    }

    public String checkString() {
        while (true) {
            try {
                String result = in.nextLine().trim();
                if (result.length() == 0) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (Exception e) {
                System.out.println("Dot not empty!!");
                System.out.println("Enter again: ");

            }
        }
    }
}
