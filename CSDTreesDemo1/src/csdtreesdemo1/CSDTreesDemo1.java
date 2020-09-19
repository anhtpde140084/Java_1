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
public class CSDTreesDemo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NodeList nl = new NodeList();
        Scanner in = new Scanner(System.in);
        nl.intput();
        System.out.println("=============BST===============");
        System.out.print("**  Preorder: ");
        nl.Preorder(nl.root);
        System.out.print("   *");
        System.out.print("\n**  Inroder: ");
        nl.printInorder(nl.root);
        System.out.print("    *");
        System.out.print("\n**  PostOrder: ");
        nl.printPostorder(nl.root);
        System.out.print("  *");
        System.out.println("");
        System.out.println("===============================");
        System.out.print("Breath Frist tree: ");
        nl.printOutBFT();
        System.out.println("Enter node want to delete: ");
        int x = in.nextInt();
        nl.deleteKey(x);
        nl.Preorder(nl.root);
        nl.search(2, nl.root);
    }
    
}
