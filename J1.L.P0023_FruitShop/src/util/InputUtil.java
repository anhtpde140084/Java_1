package util;

import java.util.Scanner;

public class InputUtil {

    /**
     * getStringInput
     *
     * @param sc
     * @param msg
     * @param errMsg
     * @return validated string
     */
    public static String getStringInput(Scanner sc, String msg, String errMsg) {
        String s;
        while (true) {
            System.out.print(msg);
            s = sc.nextLine();
            if (s == null || s.trim().isEmpty()) {
                System.err.println(errMsg);
                continue;
            }
            break;
        }
        return s;
    }

    /**
     * getDouble
     *
     * @param sc
     * @param msg
     * @return Double
     */
    public static Double getDouble(Scanner sc, String msg) {
        String s;
        Double db;
        while (true) {
            try {
                System.out.print(msg);
                s = sc.nextLine();
                db = Double.parseDouble(s);
                if (db > 0) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.err.println("Not a valid number");
            }

        }
        return db;
    }

    /**
     * getInt
     *
     * @param sc
     * @param msg
     * @return int
     */
    public static int getInt(Scanner sc, String msg) {
        String s;
        int in;
        while (true) {
            try {
                System.out.print(msg);
                s = sc.nextLine();
                in = Integer.parseInt(s);
                if (in > 0) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.err.println("Not a valid number");
            }

        }
        return in;
    }

}
