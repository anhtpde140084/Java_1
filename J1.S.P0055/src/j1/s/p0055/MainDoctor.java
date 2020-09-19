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
public class MainDoctor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        doctorValid dr =  new doctorValid();
        Manager menu =  new Manager();
        while(true){
            int choice = menu.menu();
            switch(choice){
                case 1: dr.input();
                dr.display();
                break;
                case 2: dr.updateDoctor();
                dr.display();
                break;
                case 3: dr.deleteDoctor();
                dr.display();
                break;
                case 4: dr.searchDoctor();
                break;
                case 5: return;
            }
        }
    }
    
}
