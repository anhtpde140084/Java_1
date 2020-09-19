/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0055;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author tranp
 */
public class ValidationDoctor {

    public Scanner in;

    public ValidationDoctor() {
        in = new Scanner(System.in);
    }

    public int checkLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (Exception e) {
                System.err.println("Please input number in rage[" + min + "," + max + "]");
                System.out.println("Enter again:");
            }
        }
    }

    // check user input String;
    public String checkString() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("Not empty. Enter again: ");

            } else {
                return result;
            }
        }
    }

    public int checkInputInt() {
        while (true) {
            try {
                int n = Integer.parseInt(in.nextLine().trim());
                return n;
            } catch (Exception e) {
                System.out.println("Please enter integer number: ");
            }
        }
    }

    public int checkIdExist(ArrayList<Doctor> Doctor, String id) {
        for (int i = 0; i < Doctor.size(); i++) {
            if ((id) == Doctor.get(i).getCode()) {
                return i;
            }
        }
        return -1;
    }

    public  boolean checkCodeExist(ArrayList<Doctor> ld, String code) {

        for (Doctor doctor : ld) {
            if (code.equalsIgnoreCase(doctor.getCode())) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkDuplicate(ArrayList<Doctor> ld, String code,
            String name, String specialization, int availability) {
        //check from first to last list doctor
        for (Doctor doctor : ld) {
            if (code.equalsIgnoreCase(doctor.getCode())
                    && name.equalsIgnoreCase(doctor.getName())
                    && specialization.equalsIgnoreCase(doctor.getSpecialization())
                    && availability == doctor.getAvailability()) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkChangeInfo(Doctor doctor, String code,
            String name, String specialization, int availability) {
        if (doctor.getCode().equalsIgnoreCase(code)
                && doctor.getName().equalsIgnoreCase(name)
                && doctor.getSpecialization().equalsIgnoreCase(specialization)
                && doctor.getAvailability() == availability) {
            return false;
        }
        return true;
    }

}
