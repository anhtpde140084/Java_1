/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computer_master_main;

import computer_master_setUp.gameSetUp;

/**
 *
 * @author tranp
 */
public class Main
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        gameSetUp game = new gameSetUp("SkyForce Game", 500, 600);  
        game.start();
    }
    
}
