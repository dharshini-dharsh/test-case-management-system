package com.dharshu.testcasemanagement.util;

import java.util.Scanner;

public class InputValidator {

    public static int readPositiveInt(
            Scanner scanner,
            String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine();

            try {

                int value = Integer.parseInt(input);

                if (value > 0) {
                    return value;
                }

                System.out.println(
                        "Please enter a positive number."
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. Please enter a number."
                );
            }
        }
    }

    public static String readNonEmptyString(
            Scanner scanner,
            String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println(
                    "Input cannot be empty."
            );
        }
    }
}