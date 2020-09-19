/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagercsd;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.REUtil;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author tranp
 */
public class Validation {

    public  Scanner in;
    public Validation(){
        in = new Scanner(System.in);            
    }
    
    public int checkInt(){
        while(true){
            try{
                int r = Integer.parseInt(in.nextLine());
                return r;
            } catch(Exception e){
                System.out.println("Please enter integer number: ");
            }
        }
    }
    public int checkLimit(int max, int min) {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result <= min || result >= max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public int checkIdExist(ArrayList<student> studentList, int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if ((id)==studentList.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }
    
    public  String checkInputString() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }
}
