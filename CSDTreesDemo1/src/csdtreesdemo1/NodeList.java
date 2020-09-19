/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csdtreesdemo1;

import java.util.Scanner;

/**
 *
 * @author tranp
 */
public class NodeList {

    Node root;

    NodeList() {
        root = null;
    }

    void intput() {
        insertion(6);
        insertion(9);
        insertion(2);
        insertion(4);
        insertion(1);
        insertion(10);

    }

    Node insert(int x, Node root) {
        if (root == null) {
            root = new Node(x);
            return root;
        }
        if (x < root.data) {
            root.left = insert(x, root.left);
        }
        if (x > root.data) {
            root.right = insert(x, root.right);
        }
        if (x == root.data) {
            System.out.println(x + " is Duplication!!");

        }

        return root;
    }

    void insertion(int x) {
        root = insert(x, root);
    }

    void Preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            Preorder(root.left);
            Preorder(root.right);
        }
    }

    void printPostorder(Node root) {
        if (root != null) {

            printPostorder(root.left);
            printPostorder(root.right);
            System.out.print(root.data + " ");
        }

    }

    void printInorder(Node root) {
        if (root != null) {

            printInorder(root.left);
            System.out.print(root.data + " ");
            printInorder(root.right);
        }
    }
// breath FT tree

    void BFT(Node root) {
        if (root != null) {
            Queue Q = new Queue(10);
            Q.Enqueue(root);
            while (!Q.isEmpty()) {
                Node p = Q.dequeue();
                if (p.left != null) {
                    Q.Enqueue(p.left);
                }
                if (p.right != null) {
                    Q.Enqueue(p.right);
                }
                System.out.print(p.data + " ");
            }
        }
    }

    void printOutBFT() {
        BFT(root);
    }

    void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key) {

        if (root == null) {
            return root;
        }
        if (key < root.data) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.data) {
            root.right = deleteRec(root.right, key);
        } else {

            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.data = minValue(root.right);

            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    int minValue(Node root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    Node search(int x, Node root) {
        if (root == null) {
            return root;
        } else if (x == root.data) {
            return root;
        } else if (x < root.data) {
            return search(x, root.left);
        } else {
            return search(x, root.right);
        }

    }

}
