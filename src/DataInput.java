import com.sun.jdi.IntegerValue;

import java.io.*;

public final class DataInput {

    public static Long getLong(String text) {
        String s = getString(text);
        return Long.valueOf(s);

    }

    public static char getChar(String text) {
        String s = getString(text);
        return s.charAt(0);
    }

    public static Integer getInt(String text) {
        String s = getString(text);
        while (containNotDigits(s)) {
            System.out.println("Invalid input. Please try again");
            s = getString(text);
        }
        Integer value = Integer.valueOf(s);
        return value;

    }

    public static Double getDouble(String text) {
        String s = getString(text);
        while (!validDouble(s)) {
            System.out.println("Invalid input. Please try again");
            s = getString(text);
        }
        Double value = Double.valueOf(s);
        return value;
    }

    private static boolean validDouble(String s) {
        if (s.charAt(0) < '0' && s.charAt(0) > '9') {
            if (s.charAt(0) != '-')
                return false;
        }
        int numberOfDots = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                if (s.charAt(i) == '.' && numberOfDots > 1) {
                    return false;
                } else if (s.charAt(i) == '.' && numberOfDots == 0) {
                    numberOfDots++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean containNotDigits(String s) {
        if (s.charAt(0) < '0' && s.charAt(0) > '9') {
            if (s.charAt(0) != '-')
                return true;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return true;
            }
        }
        return false;
    }

    public static String getString(String text) {
        if (!text.equals(""))
            System.out.print(text + ": ");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = "";
        while (s.equals("")) {
            try {
                s = br.readLine();
            } catch (IOException e) {
                System.out.println("Invalid input. Please try again");
            }
        }
        return s;
    }

}