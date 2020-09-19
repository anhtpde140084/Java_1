/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csdqueuedemo2;

/**
 *
 * @author tranp
 */
public class CSDQueueDemo2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        NodeList pr = new NodeList();
        pr.input();
        System.out.println("Get First data in QUEUE: ");
        System.out.println(pr.getFirst());
        System.out.println("Taken all data in QUEUE: ");
        pr.outPut();
            
        
    }
    
}
