/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagercsd;

import java.util.Scanner;

/**
 *
 * @author tranp
 */
public class student {

    private int id;
    private String name;
    private int age;

    public student() {
    }

   
    Validation pr = new Validation();
    public void inputStudent() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter student ID: ");
        id = pr.checkInt();
        System.out.print("Enter studdent name: ");
        name = in.nextLine();
        System.out.print("Enter student'age: ");
        age = pr.checkInt();
        System.out.println("");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Validation getPr() {
        return pr;
    }

    public void setPr(Validation pr) {
        this.pr = pr;
    }

    public student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void showInfo() {
        System.out.println("");
        System.out.print("Student ID: " + id);
        System.out.println("");
        System.out.print("Name: " + name);
        System.out.println("");
        System.out.print("Age: " + age);
        System.out.println("");
    }
   
    
    @Override
    public String toString() {
        return "student{" + "id=" + id + ", name=" + name + ", age=" + age + ", pr=" + pr + '}';
    }
   

}
