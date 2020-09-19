/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagercsd;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author tranp
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<student> studentList = new ArrayList<>();

        Validation pr = new Validation();

        while (true) {
            Manager menu = new Manager();
            int choice = menu.menu();
            switch (choice) {
                case 1:
                    System.out.println("----- Students ------");
                    System.out.println("Enter number of student need add: ");
                    int n = pr.checkInt();
                    for (int i = 0; i < n; i++) {
                        student std = new student();
                        std.inputStudent();
                        studentList.add(std);
                    }
                    break;
                case 2:
                    System.out.println("------- Show information -----------------");
                    if (studentList.isEmpty()) {
                        System.out.println("Chua co thong tin sinh vien");
                    }
                    for (int i = 0; i < studentList.size(); i++) {
                        studentList.get(i).showInfo();
                    }
                    break;
                case 3:
                    System.out.println("------ Delete student ---------------");
                    if (studentList.isEmpty()) {
                        System.err.println("List empty.");
                    }
                    System.out.println("Enter ID to update: ");
                    int id = pr.checkInt();
                    int pos = pr.checkIdExist(studentList, id);
                    if (pos == -1) {
                        System.out.println("Not found!.");
                    } else {
                        studentList.remove(pos);
                        System.err.println("Delete success");
                    }
                    break;
                case 4:

                    if (studentList.isEmpty()) {
                        System.err.println("List empty.");
                        continue;
                    }
                    System.out.println("Enter ID to update: ");
                    id = pr.checkInt();

                    pos = pr.checkIdExist(studentList, id);
                    if (pos == -1) {
                        System.out.println("Not found Student.");
                    } else {
                        System.out.print("Enter name:  ");
                        String nname = pr.checkInputString();
                        System.out.print("Enter age: ");
                        int d = pr.checkInt();
                        studentList.get(pos).setAge(d);
                        studentList.get(pos).setName(nname);
                        System.out.println("Information of student has been updated");
                    }
                    break;
                case 5:
                    return;
            }
        }
    }
}
