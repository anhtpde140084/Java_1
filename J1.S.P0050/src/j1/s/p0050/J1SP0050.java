package j1.s.p0050;

import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J1SP0050 {

    private static final Scanner in = new Scanner(System.in);

    private int menu() {

        System.out.println("======= Equation program");
        System.out.println("=======");
        System.out.println("1. Calculate Superlative Equation");
        System.out.println("2. Calculate Quadratic Equation");
        System.out.println("3. Exit");
        int choice = checkLimit(3,1);
        return choice;
    }

    public int checkLimit(int max, int min) {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
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

    /*public static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                return result;
            } catch (Exception e) {
                System.err.println("Please type the number: ");
                System.out.println("Enter again: ");
            }
        }
    } */

    public static double checkInputDouble() {

        while (true) {
            try {
                double result = Double.parseDouble(in.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Must be input double");
                System.out.print("Enter again: ");
            }

        }
    }

    public boolean isOdd(int x) {
        if (x % 2 == 1) {
            return true;
        }
        return false;
    }

    public boolean isEven(int x) {
        if (x % 2 == 0) {
            return true;
        }
        return false;
    }

    public boolean isPerfectSquare(double x) {
        if (x == 0) {
            return false;
        }
        int temp = (int) Math.sqrt(x);
        if (temp * temp == (int) x) {
            return true;
        }
        return false;
    }

    public List<Double> calculateEquation(double a, double b) {
        List<Double> result = new ArrayList<>();
        if (a == 0 && b == 0) {
            result.add(a);
            result.add(a);
            return result;
        }
        if (a == 0 && b != 0) {
            return result;
        }

        result.add(-b / a);
        return result;
    }

    public List<Double> calculateQuadraticEquation(double a, double b, double c) {
        List<Double> result = new ArrayList<>();
        if ((a == 0) && (b == 0) && (c == 0)) {
            result.add(a);
            result.add(a);
            result.add(a);
            return result;
        }

        double denta = (Math.pow(b, 2) - 4 * a * c);
        if (denta < 0) {
            return result;
        }

        if (denta == 0) {
            result.add(-b / (2 * a));
            return result;
        }

        double x1 =  ((-b - Math.sqrt(denta)) / (2 * a));
        double x2 =  ((-b + Math.sqrt(denta)) / (2 * a));
        result.add(x1);
        result.add(x2);
        return result;
    }
    void function1(){
        System.out.println("Enter A: ");
        double a = checkInputDouble();
        System.out.println("Enter B: ");
        double b = checkInputDouble();
        List<Double> result = new ArrayList<>();
        result = calculateEquation(a, b);
        if(result.isEmpty()) {
            System.out.println("NO SOLUTION !");
        }
        else if (result.size()==1){
            System.out.printf("|SOLUTION| x =  %.2f\n",result.get(0));
        }
        else {
            System.out.println("INFINITY SOLUTION ! ");
        }

        double[] arr=new double[] {a,b};
        int[] check=new int[2];

        for (int i=0;i<2;i++)
            if (isOdd((int)arr[i])) check[i]=0; else check[i]=1;
        System.out.print("ODD NUMBER: ");
        for (int i=0;i<2;i++) 
            if (check[i]==0) System.out.printf("%.1f ",arr[i]);
        System.out.println("");
        System.out.print("EVEN NUMBER: ");
        for (int i=0;i<2;i++) 
            if (check[i]==1) System.out.printf("%.1f ",arr[i]);
        System.out.println("");

        for (int i=0;i<2;i++)
            if (isPerfectSquare(arr[i])) check[i]=2;
        System.out.print("PERFECT SQUARE NUMBER: ");
        for (int i=0;i<2;i++) 
            if (check[i]==2) System.out.printf("%.1f ",arr[i]);
        System.out.println("");
    }
    
    void function2(){
        System.out.print("Enter A: ");
        double a=checkInputDouble();
        System.out.print("Enter B: ");
        double b=checkInputDouble();
        System.out.print("Enter C: ");
        double c=checkInputDouble();

        List<Double> resulf=new ArrayList<>();
        resulf=calculateQuadraticEquation(a, b, c);
        if (resulf.isEmpty()) 
            System.out.println("NO SOLUTION !");
      
        else if (resulf.size()==1){
            System.out.printf("|DOUBLE SOLUTION| x1 = x2 = %.2f\n",resulf.get(0));
        }
        else if (resulf.size()==2){
            System.out.printf("|SOLUTION| x1 = %.2f and x2 = %.2f\n",resulf.get(0),resulf.get(1));
        }
        else {
            System.out.println("INFINITY SOLUTION ! ");
        }

        double[] arr=new double[] {a,b,c};
        int[] check=new int[3];

        for (int i=0;i<3;i++)
            if (isOdd((int)arr[i])) check[i]=0; else check[i]=1;
        System.out.print("ODD NUMBER: ");
        for (int i=0;i<3;i++) 
            if (check[i]==0) System.out.printf("%.1f ",arr[i]);
        System.out.println("");
        System.out.print("EVEN NUMBER: ");
        for (int i=0;i<3;i++) 
            if (check[i]==1) System.out.printf("%.1f ",arr[i]);
        System.out.println("");

        for (int i=0;i<3;i++)
            if (isPerfectSquare(arr[i])) check[i]=2;
        System.out.print("PERFECT SQUARE NUMBER: ");
        for (int i=0;i<3;i++) 
            if (check[i]==2) System.out.printf("%.1f ",arr[i]);
        System.out.println("");
    }
    public static void main(String[] args) {
        J1SP0050 pr1 = new J1SP0050();
        while(true){
            int choice=pr1.menu();

            switch(choice){
                case 1: pr1.function1();
                        break;
                case 2: pr1.function2();
                        break;
                case 3: System.exit(0);
                       
            }
        }
    }

}
