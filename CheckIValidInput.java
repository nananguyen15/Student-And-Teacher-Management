import java.util.*;
import java.util.regex.Pattern;

public class CheckIValidInput{
    private static int cnt = 0;

    //Function to check valid name
    public static String checkValidName(String personType) {
        Scanner sc = new Scanner(System.in);
        String str = "";
        do {
            try {
                System.out.print("Enter " + personType + "'s full name: ");
                str = sc.nextLine();

                String[] name = str.split(" ");
                //name[i].substring(0, 1).toUpperCase() converts the first character of each word to uppercase
                //name[i].substring(1).toLowerCase() converts the rest of the word to lowercase
                for (int i = 0; i< name.length; i++){
                    name[i] = name[i].substring(0,1).toUpperCase() + name[i].substring(1).toLowerCase();
                }
                //C2:
                //for (int i = 0; i < name.length; i++){
                //                char firstChar = name[i].charAt(0);
                //                firstChar = Character.toUpperCase(firstChar);
                //                name[i] = firstChar + name[i].substring(1).toLowerCase();
                //            }
                str = String.join(" ", name);
                //If the name contains any special characters or numbers or be empty, it will throw an exception
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

    // Set to store the existing IDs to check for uniqueness ID
    // Set has function .contains to check if the ID is already in the set
    public static final Set<String> existingIDs = new HashSet<>();

    //Function to check valid ID
    public static String checkID(String personType) {
        Scanner sc = new Scanner(System.in);
        String id = "";
        do {
            try {
                System.out.print("Enter " + personType + "'s ID: ");
                id = sc.nextLine().toUpperCase();

                //If the ID is already in the set, it will throw an exception
                if (existingIDs.contains(id))
                    throw new IllegalArgumentException("This " + id + " already exists!");
                //If the ID does not match the format, it will throw an exception
                //Detail: If the person is a student, the ID must have CE at first and 6 numbers
                if (personType.equals("student") && !(Pattern.matches("^[CE]{2}\\d{6}$", id)))
                    throw new IllegalArgumentException("Invalid input. The ID must have CE at first and 6 numbers.\nPlease enter again!");
                //Detail: If the person is a teacher, the ID must have FS at first and 6 numbers
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

    //Function to check valid email
    public static void checkEmail(String id, String personType, String name) {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print("Enter " + personType + "'s the email: ");
                //Using slpit to split the name into an array of words
                String[] nameEmail = name.split(" ");

                //Using toLowerCase to convert the ID to lowercase
                String ID = id.toLowerCase();

                String expectedEmail1 = "";
                String expectedEmail2 = "";
                //If the name contains only 1 word, the email will be in the format:
                if (nameEmail.length == 1) {
                    expectedEmail1 = nameEmail[0].toLowerCase() + "." + ID + "@fpt.edu.vn";
                    expectedEmail2 = nameEmail[0].toLowerCase() + "." + ID + "@gmail.com";

                    //If the name contains more than 1 word
                } else {
                    //using StringBuilder instead of String because it's an easy modifier and faster.
                    StringBuilder acronym = new StringBuilder();
                    //The loop to get the first letter of each word in the name
                    for (int i = 0; i < nameEmail.length - 1; i++) {
                        acronym.append(nameEmail[i].charAt(0));
                    }
                    //C2:
                    //    String acronym = "";
                    //    for (int i = 0; i < nameEmail.length - 1; i++) {
                    //        acronym += nameEmail[i].charAt(0);
                    //    }
                    String lowercaseAcronym = acronym.toString().toLowerCase();
                    expectedEmail1 = nameEmail[nameEmail.length - 1].toLowerCase() + lowercaseAcronym + "." + ID + "@fpt.edu.vn";
                    expectedEmail2 = nameEmail[nameEmail.length - 1].toLowerCase() + lowercaseAcronym + "." + ID + "@gmail.com";
                }
                String email = sc.nextLine().trim();

                //Using regex to get the numeric part of the ID
                //The regex [^0-9] means any character that is not a number will be replaced by an empty string
                String numericPartOfId = ID.replaceAll("[^0-9]", "");

                //Case 1: If the person is a student:
                if (personType.equals("student")) {
                    //If the first 2 numbers of the ID are less than or equal to 18, the email will be extended with @fpt.edu.vn
                    if (Integer.parseInt(numericPartOfId.substring(0, 2)) <= 18) {
                        if (!email.equalsIgnoreCase(expectedEmail1))
                            throw new IllegalArgumentException("Invalid Email. The email must be in the format: 'nameacronym.id@fpt.edu.vn'.\nPlease enter again!");
                        //If the first 2 numbers of the ID are greater than 18, the email will be extended with @gmail.com
                    } else {
                        if (!email.equalsIgnoreCase(expectedEmail2))
                            throw new IllegalArgumentException("Invalid Email. The email must be in the format: 'nameacronym.id@gmail.com'.\n");
                    }
                    //Case 2: If the person is a teacher:
                } else {
                    if (!email.equalsIgnoreCase(expectedEmail1))
                        throw new IllegalArgumentException("Invalid Email. The email must be in the format: nameacronym.id@fpt.edu.vn'.\nPlease enter again!");
                }
                break;
            } catch (IllegalArgumentException e) {
                cnt++;
                System.out.println(e.getMessage());
                if (cnt >= 3) {
                    System.out.println("You have entered wrong email " + cnt + " times.\nDo you want see the guide to enter email again? (Y/N)");
                    String choice = sc.nextLine().toUpperCase();
                    if (personType.equals("student") && choice.equals("Y")) {
                        System.out.println("""
                                The mail format is: 'nameacronym.id@fpt.edu.vn' or 'nameacronym.id@gmail.com'.
                                *** Note about name and acronym:
                                - If your full name is Nguyen Van A -> acronym is NV
                                                                    -> name is A
                                                                    => 'ANV' is 'nameacronym' in the email.
                                - If your full name is Nguyen Kieu Thy -> acronym is NK
                                                                       -> name is Thy
                                                                       => 'THYNK' is 'nameacronym' in the email.
                                                                       
                                *** Note about the extension of email:
                                - If the ID contains 2 first number <=18 in your ID, the extension of email must be: @fpt.edu.vn
                                - If the ID contains 2 first number >18 in your ID, the extension of email must be: @gmail.com
                                - Example: 
                                    + Your ID is CE180000 -> @fpt.edu.vn (because 18 <= 18)
                                    + Your ID is CE190000 -> @gmail.com (because 19 > 18)
                                    
                                *** Note about case-sensitive: 
                                - It does not matter you enter uppercase or lowercase your ID or your name, because the program automatically convert your ID and your full name to lowercase when you enter email.
                                - Example: 
                                    + Your ID is CE180000 -> ce180000 (The program will convert to lowercase, so you can enter CE180000 or ce180000)
                                    + Your full name is Nguyen Van A -> nguyen van a (Similarly, you can enter Nguyen Van A or nguyen van a)
                                """);
                    } else if (personType.equals("teacher") && choice.equals("Y")) {
                        System.out.println("""
                                The mail format is: 'nameacronym.id@fpt.edu.vn'
                                *** Note about name and acronym:
                                - If your full name is Nguyen Van A -> acronym is NV
                                                                    -> name is A
                                                                    => 'ANV' is 'nameacronym' in the email.
                                - If your full name is Nguyen Kieu Thy -> acronym is NK
                                                                       -> name is Thy
                                                                       => 'THYNK' is 'nameacronym' in the email.
                                                                       
                                *** Note about case-sensitive: 
                                - It does not matter you enter uppercase or lowercase your ID or your name, because the program automatically convert your ID and your full name to lowercase when you enter email.
                                - Example: 
                                    + Your ID is FS180000 -> fs180000 (The program will convert to lowercase, so you can enter FS180000 or fs180000)
                                    + Your full name is Nguyen Van A -> nguyen van a (Similarly, you can enter Nguyen Van A or nguyen van a)
                                """);
                    } else {
                        System.out.println("Ok. Please enter the email again!");
                    }
                }
            }
        }
        while (true);
    }

    //Function to check valid phone number
    public static void checkPhoneNumber(String personType) {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print("Enter " + personType + "'s phone number: ");
                //Using parseInt to convert the string to an integer
                String phoneNumber = sc.nextLine().trim();
                //Using regex to check if the phone number has 10 numbers and starts with 0
                if (!(Pattern.matches("^0\\d{9}", phoneNumber)))
                    throw new IllegalArgumentException("Invalid input. The phone number must have 10 numbers and start with 0.\nPlease enter again!");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true);
    }

    //Function to check valid date of birth
    public static void checkDateOfBirth(String personType) {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print("Enter date of birth of " + personType + ": ");
                String dateOfBirth = sc.nextLine();

                //Using regex to check if the date of birth has the format: dd/mm/yyyy
                if (!(Pattern.matches("\\d{2}/\\d{2}/\\d{4}", dateOfBirth)))
                    throw new IllegalArgumentException("Invalid input. The date of birth must have the format: dd/mm/yyyy.\n" + "Please enter again!");

                //Using parseInt to convert the string to an integer
                //Using substring to get the day, month, year from the date of birth
                int day = Integer.parseInt(dateOfBirth.substring(0, 2));
                int year = Integer.parseInt(dateOfBirth.substring(6));
                int month = Integer.parseInt(dateOfBirth.substring(3, 5));

                //If the year of birth is greater than 2017 or less than 1825, it will throw an exception
                if (year > 2017 || year < 1825)
                    throw new IllegalArgumentException("Invalid input. The year of birth must be >=1825 and <= 2017.\nPlease enter again!");
                //If the month of birth is greater than 12 or less than 1, it will throw an exception
                if (month > 12 || month < 1) {
                    throw new IllegalArgumentException("Invalid input. The month of birth must be >=1 and <= 12.\nPlease enter again!");
                }
                //If the month is february, it will check if the year is a leap year or not
                else if (month == 2) {
                    //If the year is a leap year, the day of birth must be <=29
                    if (year % 4 == 0 || year % 100 != 0 && year % 400 == 0) {
                        if (day > 29) {
                            throw new IllegalArgumentException("Invalid input. The day of birth must be >=1 and <= 29.\nPlease enter again!");
                        }
                    }
                    //If the year is not a leap year, the day of birth must be <=28
                    else if (day > 28) {
                        throw new IllegalArgumentException("Invalid input. The day of birth must be >=1 and <= 28.\nPlease enter again!");
                    }
                }
                //If the month is january, march, may, july, august, october, december, the day of birth must be <=31
                else if (month == 1 || month == 3 || month == 4 || month == 7 || month == 8 || month == 10 || month == 12) {
                    if (day > 31) {
                        throw new IllegalArgumentException("Invalid input. The day of birth must be >=1 and <= 31.\nPlease enter again!");
                    }
                }
                //If the month is april, june, september, november, the day of birth must be <=30
                else {
                    if (day > 30) {
                        throw new IllegalArgumentException("Invalid input. The day of birth must be >=1 and <= 30.\nPlease enter again!");
                    }
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true);
    }

    //Function to check valid salary
    public static void checkValidSalary() {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print("Enter salary of teacher: ");
                int salary = Integer.parseInt(sc.nextLine());
                //                if (!sc.hasNextInt())
                //                    throw new IllegalArgumentException("Invalid input. The salary must be a number.\nPlease enter again!");
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

    //Function to check valid score
    public static void checkValidScore() {
        Scanner sc = new Scanner(System.in);

        //Using a map to store the scores of the student
        //Reason to use map: The scores of the student are associated with the subjects
        //If use list or Set it will be difficult to know which score is associated with which subject
        Map<String, Double> scores = new HashMap<>();

        //The array of subjects
        String[] subjects = {"MAD", "OSG", "NWC", "PRO", "SSG"};
        do {
            try {
                System.out.println("Enter score of student: ");

                //Using for each loop to loop through the array of subjects
                for (String subject : subjects) {
                    System.out.print("- " + subject + ": ");
                    double score = Double.parseDouble(sc.nextLine());
                    //If the score is less than 0 or greater than 10, it will throw an exception
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

    //Function to check valid subject
    public static void checkSubject() {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print("Enter subject teaching for teacher: ");
                String subject = sc.nextLine().trim().toUpperCase();
                //If the subject contains any special characters or numbers or be empty, it will throw an exception
                if (!Pattern.matches("[a-zA-Z]+", subject))
                    throw new IllegalArgumentException("Invalid input. The subject must have only words.\nPlease enter again!");
                //If the subject is not MAD, OSG, NWC, PRO, SSG, it will throw an exception
                if (!subject.equals("MAD") && !subject.equals("OSG") && !subject.equals("NWC") && !subject.equals("PRO") && subject.equals("SSG")) {
                    throw new IllegalArgumentException("Invalid input. The subject must be MAD/ OSG/ NWC/ PRO/ SSG.\nPlease enter again!");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true);
    }
}