/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0055;

/**
 *
 * @author tranp
 */
public class Manager {
    ValidationDoctor pr = new ValidationDoctor();
    int menu(){
        System.out.println("1. Add doctor. ");
        System.out.println("2. Update doctor.");
        System.out.println("3. Delete doctor.");
        System.out.println("4. Search doctor.");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        int choice = pr.checkLimit(1, 5);
        return choice;
    }
}
