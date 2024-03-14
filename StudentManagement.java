import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StudentManagement{
    //Create the list of student
    private static final List<Student> studentList = new ArrayList<>();

    //Function sortStudent
    public static void sortStudent() {
        Scanner scanner = new Scanner(System.in);
        //Create menu method
        Menu menu = new Menu();
        int choice;

        do {
            //Display menu
            System.out.println("---- SORT STUDENT ----");
            System.out.println("1. Sort ascending.");
            System.out.println("2. Sort descending.");
            System.out.println("3. Back to main menu.");
            System.out.print("Enter your choice: ");

            //Input choice
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                //Call sortStudentAscending method
                    sortStudentsAscending();
                    break;
                case 2:
                //Call sortStudentDescending method
                    sortStudentsDescending();
                    break;
                case 3:
                //Call mainMenu method
                    System.out.println("Back to main menu.");
                    menu.mainMenu();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 3); //Loop until user enter a number different from 3
    }


    //Function sortStudentAscending
    private static void sortStudentsAscending() {
        Scanner scanner = new Scanner(System.in);
        int sortChoice;

        do {
            //Display menu
            System.out.println("Sort by:");
            System.out.println("1. ID");
            System.out.println("2. Name");
            System.out.println("3. Age");
            System.out.println("4. GPA");
            System.out.print("Enter your choice: ");

            //Input choice
            sortChoice = scanner.nextInt();

            switch (sortChoice) {
                case 1:
                //Sort by ID method
                    studentList.sort((Student b1, Student b2) -> b1.getId().compareTo(b2.getId()));
                    //Display student's list after sort by ID
                    displayStudentList();
                    break;
                case 2:
                //Sort by name method
                    studentList.sort((Student b1, Student b2) -> b1.getName().compareTo(b2.getName()));
                    //Dislay student's list after sort by name
                    displayStudentList();
                    break;
                case 3:
                //Sort by age method
                    studentList.sort((s1, s2) -> {
                        int age1 = 2024 - Integer.parseInt(s1.getDateOfBirth().trim().split("/")[2]);
                        int age2 = 2024 - Integer.parseInt(s2.getDateOfBirth().trim().split("/")[2]);
                        return Integer.compare(age1, age2);
                    });
                    //Display student's list after sort by age
                    displayStudentList();
                    break;
                case 4:
                //Sort by GPA method
                    studentList.sort((Student b1, Student b2) -> b1.getGPA().compareTo(b2.getGPA()));
                    //Display student's list after sort by GPA
                    displayStudentList();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (sortChoice != 4); //Loop until user enter a number different from 4
    }

    //Function sortStudentDescending
    private static void sortStudentsDescending() {
        Scanner scanner = new Scanner(System.in);
        int sortChoice;

        do {
            //Display menu
            System.out.println("Sort by:");
            System.out.println("1. ID");
            System.out.println("2. Name");
            System.out.println("3. Age");
            System.out.println("4. GPA");
            System.out.print("Enter your choice: ");

            //Input choice
            sortChoice = scanner.nextInt();

            switch (sortChoice) {
                case 1:
                //Sort by ID method
                    studentList.sort((Student b1, Student b2) -> b2.getId().compareTo(b1.getId()));
                    //Display student's list after sort by ID
                    displayStudentList();
                    break;
                case 2:
                //Sort by name method
                    studentList.sort((Student b1, Student b2) -> b2.getName().compareTo(b1.getName()));
                    //Display student's list after sort by name
                    displayStudentList();
                    break;
                case 3:
                //Sort by age method
                    studentList.sort((s1, s2) -> {
                        int age1 = 2024 - Integer.parseInt(s1.getDateOfBirth().trim().split("/")[2]);
                        int age2 = 2024 - Integer.parseInt(s2.getDateOfBirth().trim().split("/")[2]);
                        return Integer.compare(age2, age1);
                    });
                    //Display student's list after sort by age
                    displayStudentList();
                    break;
                case 4:
                //Sort by GPA method
                    studentList.sort((Student b1, Student b2) -> b2.getGPA().compareTo(b1.getGPA()));
                    //Display student's list after sort by GPA
                    displayStudentList();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (sortChoice != 4); //Loop until user enter a number different from 4
    }

    //FUunction displayStudentList
    private static void displayStudentList() {
        System.out.println(
                "------------------------------------------------------------------- STUDENT LIST -------------------------------------------------------------------");
        System.out.println(
                "| No. |        Full Name         |    ID    |  Date of birth   |           Email           |    Phone    |  MAD  |  OSG  |  NWC  |  PRO  |  SSG  |  GPA  |");
        System.out.println(
                "+-----+--------------------------+----------+------------------+---------------------------+-------------+-------+-------+-------+-------+-------+-------+");

        //Loop to display student's list
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            System.out.printf("| %-4d", i + 1);
            student.showAllInfo();
            System.out.println(
                    "+-----+--------------------------+----------+------------------+---------------------------+-------------+------------+------------+\"");
        }
    }

    public static void searchStudent() {
        boolean continueSearch;
        do {
            Scanner sc = new Scanner(System.in);

            int choice;
            do {
                System.out.println("---- SEARCH STUDENT ----");
                System.out.println("1. Search by name.");
                System.out.println("2. Search by ID.");
                System.out.println("3. Search by age.");
                System.out.println("4. Search by phone number.");
                System.out.println("5. Search by GPA.");
                System.out.println("6. Back to main menu.");
                System.out.print("Enter your choice: ");

                try {
                    choice = Integer.parseInt(sc.nextLine().trim());
                    if (choice < 1 || choice > 6) {
                        System.err.println("Invalid choice. Please enter a number between 1 and 6.\n");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Invalid input. Please enter a valid number.\n");
                    choice = -1;
                }
            }
            while (choice < 1 || choice > 6);

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
                            if (age == Integer.parseInt(searchValue)) {
                                foundStudents.add(student);
                            }

                            break;
                        case 4:
                            if (student.getPhoneNumber().equalsIgnoreCase(searchValue)) {
                                foundStudents.add(student);
                            }
                            break;
                        case 5:
                            if (student.getGPA() == Double.parseDouble(searchValue)) {
                                foundStudents.add(student);
                            }
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                }

                if (foundStudents.isEmpty()) {
                    System.out.println("Student not found.");
                } else {

                    System.out.println("-------------------------------------------------------- SHOW ALL Found teachers --------------------------------------------------------+");
                    System.out.println("| No. |        Full Name         |    ID    |  Date of birth   |           Email           |    Phone    |  Salary    | Subject    |");
                    System.out.println("+-----+--------------------------+----------+------------------+---------------------------+-------------+------------+------------+");
                    for (int i = 0; i < foundStudents.size(); i++) {
                        Student t = foundStudents.get(i);
                        System.out.printf("| %-4d|", i + 1);
                        t.showAllInfo();
                    }
                    System.out.println("+-----+--------------------------+----------+------------------+---------------------------+-------------+------------+------------+\"");

                    do {
                        try {
                            System.out.print("Do you want to continue searching? (true/false): ");
                            continueSearch = sc.nextBoolean();
                            if (!continueSearch) {
                                break;
                            }
                            sc.nextLine();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter either 'true' or 'false'.\n");

                            sc.nextLine();
                            continueSearch = false;
                        }
                    }
                    while (!continueSearch);

                }
            }
        }
        while (continueSearch);

    }

    public static void deleteStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---- DELETE STUDENT ----");
        System.out.println("1. Delete a student.");
        System.out.println("2. Delete all students.");
        System.out.println("3. Back to main menu.");
        System.out.print("Enter your choice: ");

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
                        System.out.println("Student with ID " + student.getId() + " has been deleted.");
                        break; // Exit the loop after deleting the student
                    } else {
                        System.out.println("ID does not exist");
                    }
                }
                break;
            case 2:
                studentList.clear();
                System.out.println("All students have been deleted.");
                break;
            case 3:
                // Return to the main menu
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    // Declaring a list as final means that you cannot change the reference to the
    // list, i.e., we cannot make studentList point to a different list.
    // However, we can still modify the contents of the list, such as adding,
    // removing, or sorting the elements.

    public static void showAllStudent() {
        System.out.println("------------------------------------------------------------------- SHOW ALL STUDENTS -------------------------------------------------------------------+");
        System.out.println("| No. |        Full Name         |    ID    |  Date of birth   |           Email           |    Phone    |  MAD  |  OSG  |  NWC  |  PRO  |  SSG  |  GPA  |");
        System.out.println("+-----+--------------------------+----------+------------------+---------------------------+-------------+-------+-------+-------+-------+-------+-------+");

        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            System.out.printf("| %-4d", i + 1);
            student.showAllInfo();
        }

        System.out.println("+-----+--------------------------+----------+------------------+---------------------------+-------------+------+------+------+------+------+------+");
    }

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
        Student newStudent = new Student(fullName, studentID, dateOfBirth, email, phoneNumber, 0.0, scores); // set GPA
        // as 0.0
        // initially
        double gpa = newStudent.calculateGPA(scores); // calculate GPA using the method in Student class
        newStudent.setGPA(gpa); // set the calculated GPA
        studentList.add(newStudent);
    }
}