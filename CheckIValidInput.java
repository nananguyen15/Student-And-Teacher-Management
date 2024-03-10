import java.util.*;
import java.util.regex.Pattern;

public class CheckIValidInput{
    private static int cnt = 0;

    public static void onlyIntNumber() {
        Scanner sc = new Scanner(System.in);
        try {
            int number = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, please enter a number");
        }
    }

    public static void onlyDoubleNumber() {
        Scanner sc = new Scanner(System.in);
        try {
            double number = Double.parseDouble(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, please enter a double number");
        }
    }

    public static String checkValidName(String personType) {
        Scanner sc = new Scanner(System.in);
        String str = "";
        do {
            try {
                System.out.print("Enter " + personType + "'s full name: ");
                str = sc.nextLine();
                if (!Pattern.matches("^[a-zA-Z]+(\\s[a-zA-Z]+)*$", str))
                    throw new IllegalArgumentException("Invalid input. The input must have only words.\nPlease enter again!");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true);
        return str;
    }

    // Set to store the existing IDs to check for uniqueness
    public static final Set<String> existingIDs = new HashSet<>();

    public static String checkID(String personType) {
        Scanner sc = new Scanner(System.in);
        String id = "";
        do {
            try {
                System.out.print("Enter " + personType + "'s ID: ");
                id = sc.nextLine().toUpperCase();
                if (existingIDs.contains(id))
                    throw new IllegalArgumentException("This " + id + " already exists!");
                if (personType.equals("student") && !(Pattern.matches("^[CE]{2}\\d{6}$", id)))
                    throw new IllegalArgumentException("Invalid input. The ID must have CE at first and 6 numbers.\nPlease enter again!");
                if (personType.equals("teacher") && !(Pattern.matches("^[FS]{2}\\d{6}$", id)))
                    throw new IllegalArgumentException("Invalid input. The ID must have FS at first and 6 numbers.\nPlease enter again!");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true);
        return id;
    }


    public static void checkEmail(String id, String personType, String name) {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print("Enter " + personType + "'s the email: ");
                String[] nameEmail = name.split(" ");
                String ID = id.toLowerCase();
                String expectedEmail1 = "";
                String expectedEmail2 = "";
                if (nameEmail.length == 1) {
                    expectedEmail1 = nameEmail[0] + "." + ID + "@fpt.edu.vn";
                    expectedEmail2 = nameEmail[0] + "." + ID + "@gmail.com";
                } else {
                    StringBuilder acronym = new StringBuilder();
                    for (int i = 0; i < nameEmail.length - 1; i++) {
                        acronym.append(nameEmail[i].charAt(0));
                    }
                    //C2:
                    //    String acronym = "";
                    //    for (int i = 0; i < nameEmail.length - 1; i++) {
                    //        acronym += nameEmail[i].charAt(0);
                    //    }
                    expectedEmail1 = nameEmail[nameEmail.length - 1] + acronym + "." + ID + "@fpt.edu.vn";
                    expectedEmail2 = nameEmail[nameEmail.length - 1] + acronym + "." + ID + "@gmail.com";
                }
                String email = sc.nextLine().trim();
                String numericPartOfId = ID.replaceAll("[^0-9]", "");

                if (personType.equals("student")) {
                    if (Integer.parseInt(numericPartOfId.substring(0, 2)) <= 18) {
                        if (!email.equalsIgnoreCase(expectedEmail1))
                            throw new IllegalArgumentException("Invalid Email. The email must be in the format: 'name.acronym.id@fpt.edu.vn'.\nPlease enter again!");
                    } else {
                        if (!email.equalsIgnoreCase(expectedEmail2))
                            throw new IllegalArgumentException("Invalid Email. The email must be in the format: 'name.acronym.id@gmail.com'.\n");
                    }
                } else {
                    if (!email.equalsIgnoreCase(expectedEmail1))
                        throw new IllegalArgumentException("Invalid Email. The email must be in the format: name.acronym.id@fpt.edu.vn'.\nPlease enter again!");
                }
                break;
            } catch (IllegalArgumentException e) {
                cnt++;
                System.out.println(e.getMessage());
                if (cnt >= 3) {
                    System.out.println("You have entered wrong email " + cnt + " times.\nDo you want see the guide to enter email again? (Y/N)");
                    String choice = sc.nextLine().toUpperCase();
                    if (choice.equals("Y")) {
                        System.out.println("""
                                The mail format is: 'name.acronym.id@fpt.edu.vn' or 'name.acronym.id@gmail.com'.
                                *** Note about name and acronym:
                                - If your full name is Nguyen Van A -> acronym is NV
                                                                    -> name is A
                                *** Note about the extension of email:
                                - If the ID contains 2 first number <=18, the extension of email must be: @fpt.edu.vn
                                - If the ID contains 2 first number >18, the extension of email must be: @gmail.com""");
                    } else {
                        System.out.println("Ok. Please enter the email again!");
                    }
                }
            }
        }
        while (true);
    }

    public static void checkPhoneNumber(String personType) {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print("Enter " + personType + "'s phone number: ");
                int phoneNumber = Integer.parseInt(sc.nextLine());
                if (!(Pattern.matches("0\\d{9}", String.valueOf(phoneNumber))))
                    throw new IllegalArgumentException("Invalid input. The phone number must have 10 numbers and start with 0.\nPlease enter again!");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true);
    }

    public static void checkDateOfBirth(String personType) {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print("Enter date of birth of " + personType + ": ");
                String dateOfBirth = sc.nextLine();
                if (!(Pattern.matches("\\d{2}/\\d{2}/\\d{4}", dateOfBirth)))
                    throw new IllegalArgumentException("Invalid input. The date of birth must have the format: dd/mm/yyyy.\n" + "Please enter again!");
                int day = Integer.parseInt(dateOfBirth.substring(0, 2));
                int year = Integer.parseInt(dateOfBirth.substring(6));
                int month = Integer.parseInt(dateOfBirth.substring(3, 5));
                if (year > 2017 || year < 1825)
                    throw new IllegalArgumentException("Invalid input. The year of birth must be >=1825 and <= 2017.\nPlease enter again!");
                if (month > 12 || month < 1) {
                    throw new IllegalArgumentException("Invalid input. The month of birth must be >=1 and <= 12.\nPlease enter again!");
                } else if (month == 2) {
                    if (year % 4 == 0 || year % 100 != 0 && year % 400 == 0) {
                        if (day > 29) {
                            throw new IllegalArgumentException("Invalid input. The day of birth must be >=1 and <= 29.\nPlease enter again!");
                        }
                    } else if (day > 28) {
                        throw new IllegalArgumentException("Invalid input. The day of birth must be >=1 and <= 28.\nPlease enter again!");
                    }
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true);
    }

    public static void checkValidSalary() {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print("Enter salary of teacher: ");
                int salary = Integer.parseInt(sc.nextLine());
                if (!sc.hasNextInt())
                    throw new IllegalArgumentException("Invalid input. The salary must be a number.\nPlease enter again!");
                if (salary < 20_000_000) {
                    throw new IllegalArgumentException("Invalid input. The salary must be >= 20,000,000.\nPlease enter again!");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true);
    }

    public static void checkValidScore() {
        Scanner sc = new Scanner(System.in);
        Map<String, Double> scores = new HashMap<>();
        String[] subjects = {"MAD", "OSG", "NWC", "PRO", "SSG"};
        do {
            try {
                System.out.print("Enter score of student: ");
                for (String subject : subjects) {
                    System.out.println("- " + subject + ": ");
                    double score = Double.parseDouble(sc.nextLine());
                    if (score < 0 || score > 10)
                        throw new IllegalArgumentException("Invalid input. The score must be >=0 and <=10.\nPlease enter again!");
                    scores.put(subject, score);
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. The score must be a double number.\nPlease enter again!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true);
    }
}