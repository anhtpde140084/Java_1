    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmark;

import java.util.Random;

/**
 *
 * @author tranp
 */
public class StudentList {

    private Node head, tail;

    StudentList() {
        this.head = this.tail = null;
    }

    public void add(Student student) {

        if (head == null) {
            this.head = this.tail = new Node(student);
            head.pre = null;
            tail.next = null;
        } else {
            Node newNode = new Node(student);
            this.tail.setNext(newNode);
            newNode.pre = tail;
            tail = newNode;
            tail.next = null;
        }
    }

    void traverse() {
        Node current = this.head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        while (current != null) {
            System.out.println("Name of student: " + current.getStudent().getName());
            System.out.println("Practical point: " + current.getStudent().getPractical());
            System.out.println("Progress point: " + current.getStudent().getProgress());
            System.out.println("Mid point: " + current.getStudent().getMid());
            System.out.println("Avg point: " + current.getStudent().getAvg());
            System.out.println("===========================================");
            System.out.println("===========================================");
            current = current.next;
        }
    }

    void addFirst(Student student) {
        Node newNode = new Node(student);
        if (head == null) {
            tail = newNode;
        } else {
            head.pre = newNode;
        }
        newNode.next = head;
        head = newNode;
    }

    Node find(int pos) {
        Node p = head;
        int count = 0;
        while (p != null & count != pos) {
            p = p.next;
            count++;
        }
        return p;
    }

    boolean searchStudent(String student) {
        boolean isFound = false;
        Node newNode = this.head;
        while (newNode != null) {
            if (newNode.getStudent().getName().contains(student)) {
                System.out.println("Name of student: " + newNode.getStudent().getName());
                System.out.println("Practical point: " + newNode.getStudent().getPractical());
                System.out.println("Progress point: " + newNode.getStudent().getProgress());
                System.out.println("Mid point: " + newNode.getStudent().getMid());
                System.out.println("Avg point: " + newNode.getStudent().getAvg());
                isFound = true;
            }
            newNode = newNode.getNext();
        }
        if (isFound) {
            return false;
        }
        return true;
    }

    void insert(Student student, int pos) {
        Node p = new Node(student);
        Node q = find(pos - 1);
        p.next = q.next;
        q.next = p;
    }

    boolean delete(String name) {
        Node p = this.head;
        if (head == null) {
            System.out.println("List is empty");           
        }
        if (this.head.getStudent().getName().contains(name)) {
            this.head = this.head.getNext();
            return true;
        }
        while (p != null) {
            if (p.getNext().getStudent().getName().contains(name)) {
                p.setNext(p.getNext().getNext());
            }
            p = p.getNext();
        }
        return false;
    }
}
