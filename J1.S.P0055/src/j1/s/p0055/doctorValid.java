/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0055;

import java.util.ArrayList;

/**
 *
 * @author tranp
 */
public class doctorValid {

    ArrayList<Doctor> Doctor = new ArrayList<>();
    ValidationDoctor pr = new ValidationDoctor();
    Doctor dr = new Doctor();

    void input() {
        System.out.print("Enter code: ");
        String code = pr.checkString();
        System.out.print("Enter name: ");
        String name = pr.checkString();
        System.out.print("Enter specialization: ");
        String speci = pr.checkString();
        System.out.print("Enter availability: ");
        int availability = pr.checkInputInt();
        Doctor.add(new Doctor(code, name, speci, availability));
        System.out.println("Add successfull!!");
    }

    void display() {
        System.out.printf("%-15s%-20s%-20s%s\n", "Id", "Name", "Speci", "Avai");
        for (Doctor dr : Doctor) {
            System.out.printf("%-15s%-20s%-20s%d\n", dr.getCode(), dr.getName(), dr.getSpecialization(), dr.getAvailability());
        }

    }

    void updateDoctor() {
        System.out.print("Enter code to check: ");
        String code = pr.checkString();

        if (pr.checkCodeExist(Doctor, code)) {
            System.err.println("Not found doctor");
            return;
        }
        System.out.print("Enter code to update ");
        String codeUpdate = pr.checkString();
        Doctor doctor = getDoctorByCode(Doctor, code);
        System.out.print("Enter name: ");
        String name = pr.checkString();
        System.out.print("Enter specialization: ");
        String specialization = pr.checkString();
        System.out.print("Enter availability: ");
        int availability = pr.checkInputInt();
        //check user change infomation or not
        if (!pr.checkChangeInfo(doctor, code, name, specialization, availability)) {
            System.err.println("No change");
            return;
        }
        doctor.setCode(codeUpdate);
        doctor.setName(name);
        doctor.setSpecialization(specialization);
        doctor.setAvailability(availability);
        System.err.println("Update successful");
    }

    void deleteDoctor() {
        System.out.print("Enter code: ");
        String code = pr.checkString();
        Doctor doctor = getDoctorByCode(Doctor, code);
        if (doctor == null) {
            System.err.println("Not found doctor.");
            return;
        } else {
            Doctor.remove(doctor);
        }
        System.err.println("Delete successful.");
    }

    void searchDoctor() {
        System.out.print("Enter name: ");
        String nameSearch = pr.checkString();
        ArrayList<Doctor> listFoundByName = listFoundByName(Doctor, nameSearch);
        if (listFoundByName.isEmpty()) {
            System.err.println("List empty.");
        } else {
            System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name",
                    "Specialization", "Availability");
            for (Doctor doctor : listFoundByName) {
                System.out.printf("%-10s%-15s%-25s%-20d\n", doctor.getCode(),
                        doctor.getName(), doctor.getSpecialization(),
                        doctor.getAvailability());
            }
        }
    }

    //get docter by code
    public  Doctor getDoctorByCode(ArrayList<Doctor> Doctor,String code) {
        for (Doctor doctor : Doctor) {
            if (doctor.getCode().equalsIgnoreCase(code)) {
                return doctor;
            }
        }
        return null;
    }

        public  ArrayList<Doctor> listFoundByName(ArrayList<Doctor> Doctor, String name) {
        ArrayList<Doctor> listFoundByName = new ArrayList<>();
        for (Doctor doctor : Doctor) {
            if (doctor.getName().contains(name)) {
                listFoundByName.add(doctor);
            }
        }
        return listFoundByName;
    }
}

