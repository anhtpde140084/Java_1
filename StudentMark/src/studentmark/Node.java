/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmark;

/**
 *
 * @author tranp
 */
public class Node {

    Student student;
    Node pre;
    Node next;

    public Node() {

    }

    public Node(Student student) {
        this.student = student;
        this.next = null;
        this.pre = null;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
