/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagercsd;

/**
 *
 * @author tranp
 */
public class Manager {

    Validation check = new Validation();

    int menu() {
        System.out.println("1. Input student");
        System.out.println("2. Show info");
        System.out.println("3. Delete student");
        System.out.println("4. Update");
        System.out.println("5. Exit");
        System.out.print("Please choice: ");
        int choice = check.checkLimit(5, 1);
        return choice;
    }

}
