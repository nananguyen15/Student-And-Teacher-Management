package l03fruitshop;

import java.util.Scanner;

/**
 * L03 - Create a Java console program to manage a Fruit Shop (Product and
 * Shopping).
 *
 * @author CE181383 Bach Cong Chinh
 */
public class MyLib {

    /**
     * A method that takes a message as a parameter and allows the user to
     * choose an integer between 1 and 4, inclusive.
     *
     * @param message A string that is printed to prompt the user to make a
     * choice.
     * @return The integer that the user chose.
     */
    public static int inputChoose(String message) {
        Scanner sc = new Scanner(System.in);
        Boolean check = false;
        int choice = 0;
        do {
            System.out.print(message);
            try {
                choice = sc.nextInt();
                if (choice >= 1 && choice <= 4) {
                    check = true;
                } else {
                    System.out.println("Invalid choose! Please choose again from range 1 to 4!");
                }
            } catch (Exception e) {
                System.out.println("Invalid choose! Please choose again from range 1 to 4!");
                sc.next();
            }
        } while (!check);
        return choice;
    }

    /**
     * This method prompts the user to input a unique ID. The ID should only
     * contain alphabets and digits, no special characters allowed. If the input
     * is invalid, the user will be prompted again until a valid input is
     * entered.
     *
     * @param message The prompt message to be displayed to the user.
     * @return A string that is the valid ID entered by the user.
     */
    public static String getInputID(String message) {
        Scanner sc = new Scanner(System.in);
        String s = "";
        boolean valid = false;
        do {
            System.out.print(message);
            s = sc.nextLine();
            if (s.matches("^[a-zA-Z0-9]+$")) {
                valid = true;
            } else {
                if (s.isEmpty()) {
                    System.out.println("Input is empty! Please enter a valid ID! Only alphabets and digits are accepted! No special characters or whitespaces allowed!");
                } else {
                    System.out.println("Invalid ID! Only alphabets and digits are accepted! No special characters or whitespaces allowed!");
                }
            }
        } while (!valid);
        return s;
    }

    /**
     * A method that takes a message as a parameter and prompts the user to
     * answer with 'Y' or 'N'.
     *
     * @param message A string that is printed to prompt the user to answer the
     * question.
     * @return The string that the user entered.
     */
    protected static String question(String message) {
        Scanner sc = new Scanner(System.in);
        String question;
        do {
            System.out.print(message);
            question = sc.next();
            if (!question.equalsIgnoreCase("Y") && !question.equalsIgnoreCase("N")) {
                System.out.println("Invalid input! Please enter 'Y' or 'N'!");
            }
        } while (!question.equalsIgnoreCase("Y") && !question.equalsIgnoreCase("N"));
        return question;
    }

    /**
     * A method that takes a message as a parameter and prompts the user to
     * input an integer. That also help to the user must enter the valid
     * positive number
     *
     * @param message A string that is printed to prompt the user to enter an
     * integer.
     * @return The integer that the user entered.
     */
    protected static int getIntegerInput(String message) {
        Scanner sc = new Scanner(System.in);
        int number = 0;
        while (true) {
            System.out.print(message);
            try {
                String userInput = sc.nextLine();
                if (userInput.trim().isEmpty()) {
                    System.out.println("Invalid input! You've entered a whitespace. Please enter a positive integer!");
                    continue;
                } else {
                    number = Integer.parseInt(userInput);
                    if (number <= 0) {
                        System.out.println("Invalid input! Please enter a positive integer!");
                        continue;
                    }
                }

                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a positive integer!");
            }
        }
        return number;
    }

    /**
     * A method that takes a message as a parameter and prompts the user to
     * input a string. The input string must not be whitespace only or contain
     * spaces between words.
     *
     * @param message A string that is printed to prompt the user to enter a
     * string.
     * @return The string that the user entered.
     */
    protected static String getStringInput(String message) {
        Scanner sc = new Scanner(System.in);
        String input = "";
        boolean check = false;
        while (!check) {
            System.out.print(message);
            try {
                input = sc.nextLine();
                if (input.trim().isEmpty()) {
                    System.out.println("Invalid Input! Input cannot be whitespace only or exist the special character!");
                    System.out.println("Please enter a valid string! (a-z or A-Z) ");
                } else {
                    for (int i = 0; i < input.length(); i++) {
                        if (!Character.isAlphabetic(input.charAt(i)) && !Character.isWhitespace(input.charAt(i))) {
                            System.out.println("Invalid input! Input cannot be whitespace only or exist the special character!");
                            System.out.println("Please enter a valid string! (a-z or A-Z) ");
                            check = false;
                            break;
                        } else {
                            check = true;
                        }
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return input;
    }

    /**
     * This method is used to get a substring of a given string up to a
     * specified length. If the string is shorter than the specified length, it
     * returns the original string.
     *
     * @param input The original string from which a substring is to be
     * extracted.
     * @param length The maximum length of the substring.
     * @return A string that represents the substring of the given string.
     */
    public static String getSubstring(String input, int length) {
        if (input.length() > length) {
            return input.substring(0, length);
        } else {
            return input;
        }
    }

    /**
     * This method is used to reformat the name of the same customer by
     * appending a number at the end. If a customer name already exists in the
     * orders, a number is added to the name to make it unique. The result will
     * show only the customer's name, not the appended number.
     *
     * @param name A customer name need to be reformat.
     * @return The reformatted unique customer name.
     */
    public static String reName(String name) {
        name = name.trim();
        name = name.replaceAll("\\s+", " ");
        return name.replaceAll("[^a-zA-Z ]", "");
    }

    /**
     * This method prompts the user to input a customer name. The name should
     * only contain alphabets and spaces. If the input is invalid, the user will
     * be prompted again until a valid input is entered.
     *
     * @param message The prompt message to be displayed to the user.
     * @return A string that is the valid customer name entered by the user.
     */
    protected static String getCustomerName(String message) {
        Scanner sc = new Scanner(System.in);
        String name = "";
        boolean check = false;
        while (!check) {
            System.out.print(message);
            try {
                name = sc.nextLine();
                if (name.trim().isEmpty() || !name.matches("[a-zA-Z\\s]+")) {
                    System.out.println("Invalid input! Please enter a valid name (letters and spaces only).");
                } else {
                    check = true;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return name;
    }
}
