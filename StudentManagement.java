import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StudentManagement {

    // Create the list of student
    private static final List<Student> studentList = new ArrayList<>();

    // Function sortStudent
    public static void sortStudent() {
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            // Display menu
            System.out.println("---- SORT STUDENT ----");
            System.out.println("1. Sort ascending.");
            System.out.println("2. Sort descending.");
            System.out.println("3. Back to main menu.");
            System.out.print("Enter your choice: ");

            // Input choice
            choice = scanner.nextLine().trim();

            // Check condition of choice
            if (choice.isEmpty() || choice.isBlank()) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            if (!Pattern.matches("\\d", choice)) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case "1":
                    // Call sortStudentAscending method
                    sortStudentsAscending();
                    break;
                case "2":
                    // Call sortStudentDescending method
                    sortStudentsDescending();
                    break;
                case "3":
                    // Call mainMenu method
                    System.out.println("Back to main menu.");
                    Menu.mainMenu();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (!choice.equals("1") || !choice.equals("2") || !choice.equals("3")); // Loop until user chooses option 3
                                                                                     // to go back to the main menu
    }

    // Function sort ascending student
    private static void sortStudentsAscending() {
        Scanner scanner = new Scanner(System.in);
        String sortChoice;

        do {
            // Display menu of sort ascending student
            Menu.menuSortAsc_DesStudentMangament();
            // Input choice
            sortChoice = scanner.nextLine().trim();

            // Check condition of choice
            if (sortChoice.isEmpty() || sortChoice.isBlank()) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            if (!Pattern.matches("\\d", sortChoice)) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (sortChoice) {
                case "1":
                    // Sort by ID method
                    studentList.sort((Student b1, Student b2) -> b1.getId().compareTo(b2.getId()));
                    // Display student's list after sort by ID
                    displayStudentList();
                    break;
                case "2":
                    // Sort by name method
                    studentList.sort((Student b1, Student b2) -> b1.getName().compareTo(b2.getName()));
                    // Dislay student's list after sort by name
                    displayStudentList();
                    break;
                case "3":
                    // Sort by age method
                    studentList.sort((s1, s2) -> {
                        int age1 = 2024 - Integer.parseInt(s1.getDateOfBirth().trim().split("/")[2]);
                        int age2 = 2024 - Integer.parseInt(s2.getDateOfBirth().trim().split("/")[2]);
                        return Integer.compare(age1, age2);
                    });
                    // Display student's list after sort by age
                    displayStudentList();
                    break;
                case "4":
                    // Sort by GPA method
                    studentList.sort((Student b1, Student b2) -> b1.getGPA().compareTo(b2.getGPA()));
                    // Display student's list after sort by GPA
                    displayStudentList();
                    break;
                case "5":
                    sortStudent();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (!sortChoice.equals("1") || !sortChoice.equals("2") || !sortChoice.equals("3")
                || !sortChoice.equals("4") || !sortChoice.equals("5")); // Loop until user enter a number different from
                                                                        // 5
    }

    // Function sort descending student
    private static void sortStudentsDescending() {
        Scanner scanner = new Scanner(System.in);
        String sortChoice;

        do {
            // Display menu of sort descending
            Menu.menuSortAsc_DesStudentMangament();

            // Input choice
            sortChoice = scanner.nextLine().trim();

            // Check condition of choice
            if (sortChoice.isEmpty() || sortChoice.isBlank()) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            if (!Pattern.matches("\\d", sortChoice)) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (sortChoice) {
                case "1":
                    // Sort by ID method
                    studentList.sort((Student b1, Student b2) -> b2.getId().compareTo(b1.getId()));
                    // Display student's list after sort by ID
                    displayStudentList();
                    break;
                case "2":
                    // Sort by name method
                    studentList.sort((Student b1, Student b2) -> b2.getName().compareTo(b1.getName()));
                    // Display student's list after sort by name
                    displayStudentList();
                    break;
                case "3":
                    // Sort by age method
                    studentList.sort((s1, s2) -> {
                        int age1 = 2024 - Integer.parseInt(s1.getDateOfBirth().trim().split("/")[2]);
                        int age2 = 2024 - Integer.parseInt(s2.getDateOfBirth().trim().split("/")[2]);
                        return Integer.compare(age2, age1);
                    });
                    // Display student's list after sort by age
                    displayStudentList();
                    break;
                case "4":
                    // Sort by GPA method
                    studentList.sort((Student b1, Student b2) -> b2.getGPA().compareTo(b1.getGPA()));
                    // Display student's list after sort by GPA
                    displayStudentList();
                    break;
                case "5":
                    sortStudent();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (!sortChoice.equals("1") || !sortChoice.equals("2") || !sortChoice.equals("3")
                || !sortChoice.equals("4") || !sortChoice.equals("5")); // Loop until user enter a number different from
                                                                        // 5
        writeStudentsToFile("outputStudent.txt");
    }

    // Function display Student's List
    private static void displayStudentList() {
        System.out.println(
                "----------------------------------------------------------------- SHOW ALL FOUND STUDENTS -------------------------------------------------------------------+");
        System.out.println(
                "| No. |        Full Name         |    ID    |  Date of birth   |             Email             |    Phone    |  MAD  |  OSG  |  NWC  |  PRO  |  SSG  |  GPA  |");
        System.out.println(
                "+-----+--------------------------+----------+------------------+-------------------------------+-------------+-------+-------+-------+-------+-------+-------+");

        // Loop to display student's list
        for (int i = 0; i < studentList.size(); i++) {
            // Get a student from student's list
            Student student = studentList.get(i);
            System.out.printf("| %-4d", i + 1);
            // Display student's information
            student.showAllInfo();
            System.out.println(
                    "+-----+--------------------------+----------+------------------+-------------------------------+-------------+-------+-------+-------+-------+-------+-------+");
        }
    }

    // Function search student
    public static void searchStudent() {
        boolean continueSearch;
        do {
            Scanner sc = new Scanner(System.in);
            int choice;
            do {
                Menu.menuSearchStudentMangament();
                try {
                    choice = Integer.parseInt(sc.nextLine().trim());
                    if (choice < 1 || choice > 6)
                        System.err.println("Invalid choice. Please enter a number between 1 and 6.\n");
                } catch (NumberFormatException e) {
                    System.err.println("Invalid input. Please enter a valid number.\n");
                    choice = -1;
                }
            } while (choice < 1 || choice > 6);

            if (choice == 6) {
                continueSearch = false;
                break; // Break out of the main search loop to return to the main menu
            } else {
                continueSearch = true;
                System.out.println("Enter search value:");
                String searchValue = sc.nextLine().trim();

                List<Student> foundStudents = new ArrayList<>();

                for (Student student : studentList) {
                    switch (choice) {
                        case 1:
                            if (student.getName().equalsIgnoreCase(searchValue)) {
                                foundStudents.add(student);
                            }
                            break;
                        case 2:
                            if (student.getId().equals(searchValue)) {
                                foundStudents.add(student);
                            }
                            break;
                        case 3:
                            // Assuming you have a method to get student age
                            String[] token;
                            String line = student.getDateOfBirth().trim();
                            token = line.split("/");
                            String Year = token[2];

                            int birthYear = Integer.parseInt(Year);
                            int age = 2024 - birthYear;

                            if (age == Integer.parseInt(searchValue))
                                foundStudents.add(student);
                            break;
                        case 4:
                            if (student.getPhoneNumber().equalsIgnoreCase(searchValue))
                                foundStudents.add(student);
                            break;
                        case 5:
                            if (student.getGPA() == Double.parseDouble(searchValue))
                                foundStudents.add(student);
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                }

                if (foundStudents.isEmpty())
                    System.out.println("Student not found.");
                else {
                    System.out.println(
                            "----------------------------------------------------------------- SHOW ALL FOUND STUDENTS -------------------------------------------------------------------+");
                    System.out.println(
                            "| No. |        Full Name         |    ID    |  Date of birth   |             Email             |    Phone    |  MAD  |  OSG  |  NWC  |  PRO  |  SSG  |  GPA  |");
                    System.out.println(
                            "+-----+--------------------------+----------+------------------+-------------------------------+-------------+-------+-------+-------+-------+-------+-------+");
                    for (int i = 0; i < foundStudents.size(); i++) {
                        Student t = foundStudents.get(i);
                        System.out.printf("| %-4d|", i + 1);
                        t.showAllInfo();
                    }
                    System.out.println(
                            "+-----+--------------------------+----------+------------------+-------------------------------+-------------+-------+-------+-------+-------+-------+-------+");

                    do {
                        try {
                            System.out.print("Do you want to continue searching? (true/false): ");
                            continueSearch = sc.nextBoolean();
                            if (!continueSearch)
                                break;
                            sc.nextLine();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter either 'true' or 'false'.\n");
                            sc.nextLine();
                            continueSearch = false;
                        }
                    } while (!continueSearch);
                }
            }
        } while (continueSearch);
    }

    public static void deleteStudent() {
        Scanner scanner = new Scanner(System.in);
        Menu.menuDeleteStudentMangament();

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter the ID of the student you want to delete: ");
                String studentID = scanner.next().toUpperCase();
                boolean found = false;
                for (int i = 0; i < studentList.size(); i++) {
                    Student student = studentList.get(i);
                    if (student.getId().equals(studentID)) {
                        studentList.remove(i);
                        found = true;
                        System.out.println("Student with ID " + student.getId() + " has been deleted.\n");
                        break; // Exit the loop after deleting the student
                    }
                }
                if (!found) {
                    System.out.println("Student with ID " + studentID + " not found.");
                }
                break;
            case 2:
                studentList.clear();
                System.out.println("All students have been deleted.\n");
                break;
            case 3:
                // Return to the main menu
                break;
            default:
                System.out.println("Invalid choice.");
        }
        writeStudentsToFile("outputStudent.txt");
    }

    // Declaring a list as final means that you cannot change the reference to the
    // list, i.e., we cannot make studentList point to a different list.
    // However, we can still modify the contents of the list, such as adding,
    // removing, or sorting the elements.
    public static void showAllStudent() {
        System.out.println(
                "--------------------------------------------------------------------- SHOW ALL STUDENTS ---------------------------------------------------------------------+");
        System.out.println(
                "| No. |        Full Name         |    ID    |  Date of birth   |             Email             |    Phone    |  MAD  |  OSG  |  NWC  |  PRO  |  SSG  |  GPA  |");
        System.out.println(
                "+-----+--------------------------+----------+------------------+-------------------------------+-------------+-------+-------+-------+-------+-------+-------+");

        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            System.out.printf("| %-4d", i + 1);
            student.showAllInfo();
        }
        System.out.println(
                "+-----+--------------------------+----------+------------------+-------------------------------+-------------+-------+-------+-------+-------+-------+-------+");
    }

    // Function to add a new student
    public static void addNewStudent() {
        System.out.println("---- ADD NEW STUDENT ----");
        // Using List to store student
        // Using List in this case because it is straightforward to add, delete, and
        // search student
        // full name: not empty, digits, and special characters
        String fullName = CheckIValidInput.checkValidName("student");

        // ID: not the same ID as the entered ID, not empty, 8 characters: The first two
        // characters are words (CE); the others are digits.
        // if entering an existing ID, print an error message: “This xx already exists
        // !” and require entry again. (xx is the ID you enter)
        String studentID = CheckIValidInput.checkID("student");

        // Date of birth: not empty, format: dd/mm/yyyy
        // Note: check valid date based on month, and year will be <=2017 and >=1825. If
        // the day or month the user enters does not have 0 before a number <10, it will
        // automatically add 0 before it.
        String dateOfBirth = CheckIValidInput.checkDateOfBirth("student");

        // Email: no empty,the email must contain First name + acronym of Middle name
        // and Last name +“ . “ + id + the extension “@gmail.com” or “fpt.edu.vn”
        // * Note 1: check if the id has number <=18, then this email must use the
        // extension “@fpt.edu.vn”
        // else (>18) the email must use the extension “@gmail.com”
        // * Note 2: the string id in the email must be lowercase.
        String email = CheckIValidInput.checkEmail(studentID, "student", fullName);

        // Phone number: not empty, only digits and must have 10 digits, must have 0 at
        // first.
        String phoneNumber = CheckIValidInput.checkPhoneNumber("student");

        // GPA: no empty, >=0 and <=10, only numbers.
        // Enter Score of MAD, OSG, NWC, PRO, SSG
        List<Double> scores = CheckIValidInput.checkValidScore();
        Student newStudent = new Student(fullName, studentID, dateOfBirth, email, phoneNumber, scores, 0.0); // set GPA
                                                                                                             // as 0.0
                                                                                                             // initially
        double gpa = newStudent.calculateGPA(scores); // calculate GPA using the method in Student class
        newStudent.setGPA(gpa); // set the calculated GPA
        studentList.add(newStudent);

        // Write the updated studentList to the file
        writeStudentsToFile("outputStudent.txt");
    }

    // Function to write students to a file
    public static void writeStudentsToFile(String filename) {
        // Using try-with-resources to automatically close the file
        // Using BufferedWriter to write data to the file because it is faster and more
        // efficient than FileWriter
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Student student : studentList) {
                writer.write(student.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file: " + e.getMessage());
        }
    }

    // Function to read students from a file
    public static void readStudentsFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            // Read each line from the file and create a Student object from the data
            while ((line = reader.readLine()) != null) {
                // Assuming each line in the file represents a Student object
                // and the fields are separated by a comma
                String[] fields = line.split(",");
                // Assuming the fields are in the order: name, id, dateOfBirth, email,
                // phoneNumber, GPA, subjectScores
                String name = fields[0];
                String id = fields[1];
                String dateOfBirth = fields[2];
                String email = fields[3];
                String phoneNumber = fields[4];
                // Assuming the subject scores are in the order: MAD, OSG, NWC, PRO, SSG, and
                // the scores are separated by a comma (read inputStudent.txt to see the format)
                // Convert the array of scores to a List of Doubles and add the scores to the
                // subjectScores List
                List<Double> subjectScores = Arrays.stream(Arrays.copyOfRange(fields, 5, fields.length))
                        .map(Double::parseDouble).collect(Collectors.toList());
                Double GPA = Double.parseDouble(fields[6]);
                Student student = new Student(name, id, dateOfBirth, email, phoneNumber, subjectScores, GPA);
                studentList.add(student);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading from file: " + e.getMessage());
        }
    }
}