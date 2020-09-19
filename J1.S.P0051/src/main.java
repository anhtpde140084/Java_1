
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tranp
 */
public class main {

    private static final Scanner input = new Scanner(System.in);

    public int menu() {
        System.out.println("========= Calculator Program ========");
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
        System.out.print("Please choice one option: ");
        int choice = checkLimit(1, 3);
        return choice;
    }

    public int checkLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(input.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    public  String checkInputOperator() {
        String operator = input.nextLine().trim();
        while (true) {
            if (operator.isEmpty()) {
                System.err.println("Empty!!!");
            } else if (operator.equalsIgnoreCase("+") || operator.equalsIgnoreCase("-")
                    || operator.equalsIgnoreCase("*") || operator.equalsIgnoreCase("/")
                    || operator.equalsIgnoreCase("^") || operator.equalsIgnoreCase("=")) {
                return operator;
            } else {
                System.err.println("Please input (+, -, *, /, ^)");
            }
            System.out.print("Enter again: ");
        }
    }

    public  double checkInputDouble() {
        while (true) {
            try {
                double result = Double.parseDouble(input.nextLine());
                return result;
            } catch (Exception e) {
                System.err.println("Please type of number");
                System.out.println("Enter again: ");
            }
        }
    }

    public  double InputNumber() {
        System.out.print("Enter number: ");
        double number = checkInputDouble();
        return number;
    }

    public  void normalCalculator() {
        System.out.print("Enter number: ");
        double memory = checkInputDouble();
        while (true) {
            System.out.print("Enter operator: ");
            String operator = checkInputOperator();
            if (operator.equalsIgnoreCase("+")) {
                memory += InputNumber();
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("-")) {
                memory -= InputNumber();
                System.out.print("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("*")) {
                memory *= InputNumber();
                System.out.print("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("/")) {
                memory /= InputNumber();
                System.out.print("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("^")) {
                memory = Math.pow(memory, InputNumber());
                System.out.print("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("=")) {
                System.out.print("Result: " + memory);
                System.out.println("");
                return;
            }
        }
    }

    public  String BMIStatus(double bmi) {
        if (bmi < 19) {
            return "Under-standard.";
        } else if (bmi >= 19 && bmi < 25) {
            return "Standard.";
        } else if (bmi >= 25 && bmi < 30) {
            return "Overweight.";
        } else if (bmi >= 30 && bmi < 40) {
            return "Fat-should lose weight";
        } else {
            return "Very fat - should lose weight immediately";
        }
    }

    //allow user BMI calculator
    public  void BMICalculator() {
        System.out.print("Enter Weight(kg): ");
        double weight = checkInputDouble();
        System.out.print("Enter Height(cm): ");
        double height = checkInputDouble();
        double bmi = weight * 10000 / (height * height);
        System.out.printf("BMI number: %.2f\n", bmi);
        System.out.println("BMI Status: " + BMIStatus(bmi));
    }

    public static void main(String[] args) {
        main pr1 = new main();
        while (true) {
            int choice = pr1.menu();
            switch (choice) {
                case 1:
                    pr1.normalCalculator();
                    break;
                case 2:
                   pr1.BMICalculator();
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }

}
