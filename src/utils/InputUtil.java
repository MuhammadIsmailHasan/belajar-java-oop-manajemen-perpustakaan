package utils;

import java.util.Scanner;

public class InputUtil {

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputUser (String input) {
        System.out.print("Write her for " + input + ": ");

        String result = scanner.nextLine();

        return result;
    }


}
