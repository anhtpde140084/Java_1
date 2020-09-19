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
public class StudentMark {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Validation check = new Validation();
        StudentList listOfStudent = new StudentList();
        System.out.println("===== DOUBLY LINKEDLIST MANAGER MARK OF STUDENT =====");
        while (true) {

            System.out.println("1. Add mark of student.");
            System.out.println("2. Show info. ");
            System.out.println("3. Add first. ");
            System.out.println("4. Search student.");
            System.out.println("5. Add at position.");
            System.out.println("6. Delete at position. ");
            System.out.println("7. Exit.");
            int option;
            System.out.println("Please choice: ");

            double newPractical,
                    newProgress,
                    newMid,
                    avg;
            String name;
            option = check.checkInput();

            switch (option) {
                case 1:

                    System.out.println("Enter number of student wanto add mark: ");
                    int number = check.checkInput();
                    for (int i = 0; i < number; i++) {
                        System.out.println("Enter name of student: ");
                        name = check.checkInputString();
                        System.out.println("Enter pratical point: ");
                        newPractical = in.nextDouble();
                        System.out.println("Enter progress point: ");
                        newProgress = in.nextDouble();
                        System.out.println("Enter mid point: ");
                        newMid = in.nextDouble();
                        avg = (newMid + newPractical + newProgress) / 3;
                        Student st = new Student(name, newPractical, newProgress, newMid, avg);
                        listOfStudent.add(st);
                        System.out.println("==============================");
                    }
                    break;
                case 2:
                    System.out.println("HERE IS ALL MARK OF STUDENTS");
                    listOfStudent.traverse();
                    break;
                case 3:
                    System.out.println("Enter name of student: ");
                    name = check.checkInputString();
                    System.out.println("Enter pratical point: ");
                    newPractical = in.nextDouble();
                    System.out.println("Enter progress point: ");
                    newProgress = in.nextDouble();
                    System.out.println("Enter mid point: ");
                    newMid = in.nextDouble();
                    avg = (newMid + newPractical + newProgress) / 3;
                    Student student = new Student(name, newPractical, newProgress, newMid, avg);
                    listOfStudent.addFirst(student);
                    break;
                case 4:
                    String inputName;
                    System.out.println("Enter name want to find: ");
                    inputName = check.checkInputString();
                    boolean isFound = listOfStudent.searchStudent(inputName);
                    if (isFound) {
                        System.out.println(inputName + " not found!!");
                    }
                    break;
                case 5:
                    System.out.println("Enter position want to add: ");
                    int pos = check.checkInput();
                    System.out.println("Enter name of student: ");
                    name = check.checkInputString();
                    System.out.println("Enter pratical point: ");
                    newPractical = in.nextDouble();
                    System.out.println("Enter progress point: ");
                    newProgress = in.nextDouble();
                    System.out.println("Enter mid point: ");
                    newMid = in.nextDouble();
                    avg = (newMid + newPractical + newProgress) / 3;
                    Student student1 = new Student(name, newPractical, newProgress, newMid, avg);
                    listOfStudent.insert(student1, pos);
                    break;
                case 6:
                    System.out.println("Enter name want to delete: ");
                    String nameDElete = check.checkInputString();
                    boolean isDeleteStudent = listOfStudent.delete(nameDElete);
                    if (isDeleteStudent) {
                        System.out.println("Delete failed");
                    } else {
                        System.out.println("Delete successfull!!");
                    }
                    break;
                case 7:
                    System.out.println("==== THANK YOU =====");
                    System.out.println("SEE YOU LATE");
                    return;
                default:
                    throw new AssertionError();
            }

        }

    }

}
