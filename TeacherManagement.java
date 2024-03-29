import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TeacherManagement {

    // Create the list of teacher
    private static final List<Teacher> teacherList = new ArrayList<>();

    // Function sortTeacher
    public static void sortTeacher() {
        Scanner scanner = new Scanner(System.in);
        // Create menu method
        Menu menu = new Menu();
        String choice;

        do {
            // Display menu
            System.out.println("---- SORT TEACHER ----");
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
                    // Call sortTeachesrAscending method
                    sortTeachersAscending();
                    break;
                case "2":
                    // Call sortTeachersDescending method
                    sortTeachersDescending();
                    break;
                case "3":
                    // Call mainMenu method
                    System.out.println("Back to main menu.");
                    menu.mainMenu();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (!choice.equals("1") || !choice.equals("2") || !choice.equals("3")); // Loop until user enter a number
                                                                                     // different from 3
    }

    // Function sortTeachersAscending
    private static void sortTeachersAscending() {
        Scanner scanner = new Scanner(System.in);
        String sortChoice;

        do {
            // Display menu
            Menu.menuSortAsc_DesTeacherMangament();

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
                    teacherList.sort(Comparator.comparing(Person::getId));
                    // Display teacher's list after sort by ID
                    displayTeacherList();
                    break;
                case "2":
                    // Sort by name method
                    teacherList.sort(Comparator.comparing(Person::getName));
                    // Display teacher's list after sort by name
                    displayTeacherList();
                    break;
                case "3":
                    // Sort by age method
                    teacherList.sort((s1, s2) -> {
                        int age1 = 2024 - Integer.parseInt(s1.getDateOfBirth().trim().split("/")[2]);
                        int age2 = 2024 - Integer.parseInt(s2.getDateOfBirth().trim().split("/")[2]);
                        return Integer.compare(age1, age2);
                    });
                    // Display teacher's list after sort by age
                    displayTeacherList();
                    break;
                case "4":
                    // Sort by salary method
                    teacherList.sort((Teacher b1, Teacher b2) -> b1.getSalary().compareTo(b2.getSalary()));
                    // Display teacher's list after sort by salary
                    displayTeacherList();
                    break;
                case "5":
                    // Back to the menu sort teacher
                    sortTeacher();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (!sortChoice.equals("1") || !sortChoice.equals("2") || !sortChoice.equals("3")
                || !sortChoice.equals("4") || !sortChoice.equals("5")); // Loop until user enter a number different from
                                                                        // 5
        writeTeachersToFile("outputTeacher.txt");
    }

    // Function sortTeachersDescending
    private static void sortTeachersDescending() {
        Scanner scanner = new Scanner(System.in);
        String sortChoice;

        do {
            // Display menu
            Menu.menuSortAsc_DesTeacherMangament();

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
                    teacherList.sort((Teacher b1, Teacher b2) -> b2.getId().compareTo(b1.getId()));
                    // Display teacher's list after sort by ID
                    displayTeacherList();
                    break;
                case "2":
                    // Sort by name method
                    teacherList.sort((Teacher b1, Teacher b2) -> b2.getName().compareTo(b1.getName()));
                    // Display teacher's list after sort by name
                    displayTeacherList();
                    break;
                case "3":
                    // Sort by age method
                    teacherList.sort((s1, s2) -> {
                        int age1 = 2024 - Integer.parseInt(s1.getDateOfBirth().trim().split("/")[2]);
                        int age2 = 2024 - Integer.parseInt(s2.getDateOfBirth().trim().split("/")[2]);
                        return Integer.compare(age2, age1);
                    });
                    // Display teacher's list after sort by age
                    displayTeacherList();
                    break;
                case "4":
                    // Sort by Salary method
                    teacherList.sort((Teacher b1, Teacher b2) -> b2.getSalary().compareTo(b1.getSalary()));
                    // Display teacher's list after sort by salary
                    displayTeacherList();
                    break;
                case "5":
                    // Back to the menu sort teacher
                    sortTeacher();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (!sortChoice.equals("1") || !sortChoice.equals("2") || !sortChoice.equals("3")
                || !sortChoice.equals("4") || !sortChoice.equals("5")); // Loop until user enter a number different from
                                                                        // 5
        writeTeachersToFile("outputTeacher.txt");
    }

    // Function displayTeacherList
    private static void displayTeacherList() {
        System.out.println(
                "------------------------------------------------------ SHOW ALL Found teachers -----------------------------------------------------+");
        System.out.println(
                "| No. |        Full Name         |    ID    |  Date of birth   |             Email             |    Phone    |  Salary    | Subject |");
        System.out.println(
                "+-----+--------------------------+----------+------------------+-------------------------------+-------------+------------+---------+");
        // Loop to display teacher's list
        for (int i = 0; i < teacherList.size(); i++) {
            Teacher teacher = teacherList.get(i);
            System.out.printf("| %-4d", i + 1);
            teacher.showAllInfo();
            System.out.println(
                    "+-----+--------------------------+----------+------------------+-------------------------------+-------------+------------+---------+\n");
        }
    }

    // Function search Teacher
    public static void searchTeacher() {
        boolean continueSearch;
        do {
            Scanner sc = new Scanner(System.in);
            int choice;
            do {
                // Display menu search teacher
                Menu.menuSearchTeacherMangament();
                try {
                    choice = Integer.parseInt(sc.nextLine().trim());
                    if (choice < 1 || choice > 8) {
                        System.err.println("The function of application must be from 1 to 7!\n");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Invalid input. Please enter a valid number.\n");
                    choice = -1;
                }
            } while (choice < 1 || choice > 8);

            if (choice == 8) {
                continueSearch = false;
                break; // Break out of the main search loop to return to the main menu
            } else {
                continueSearch = true;

                System.out.println("Enter search value:");
                String searchValue = sc.nextLine().trim();

                // Create a list to store found teachers
                List<Teacher> foundTeachers = new ArrayList<>();
                // Loop through the teacher list to find the teacher
                for (Teacher teacher : teacherList) {
                    switch (choice) {
                        case 1: // Search by name
                            if (teacher.getName().equalsIgnoreCase(searchValue))
                                foundTeachers.add(teacher);
                            break;
                        case 2: // Search by ID
                            if (teacher.getId().equals(searchValue))
                                foundTeachers.add(teacher);
                            break;
                        case 3: // Search by age
                            // if (teacher.getDateOfBirth().equals(searchValue)) {
                            // foundTeachers.add(teacher);}
                            String[] token;
                            String line = teacher.getDateOfBirth().trim();

                            token = line.split("/");
                            String Year = token[2];

                            int birthYear = Integer.parseInt(Year);
                            int age = 2024 - birthYear;

                            if (age == Integer.parseInt(searchValue))
                                foundTeachers.add(teacher);
                            break;
                        case 4: // Search by phone number
                            if (teacher.getPhoneNumber().equalsIgnoreCase(searchValue))
                                foundTeachers.add(teacher);
                            break;
                        case 5: // Search by email
                            if (teacher.getEmail().equalsIgnoreCase(searchValue))
                                foundTeachers.add(teacher);
                            break;
                        case 6: // Search by salary
                            if (teacher.getSalary() == Long.parseLong(searchValue))
                                foundTeachers.add(teacher);
                            break;
                        case 7: // Search by subject
                            if (teacher.getSubject().equalsIgnoreCase(searchValue))
                                foundTeachers.add(teacher);
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                }
                if (foundTeachers.isEmpty()) {
                    System.out.println("Teacher not found.");
                } else {
                    System.out.println(
                            "-------------------------------------------------------------- SHOW ALL Found teachers --------------------------------------------------------+");
                    System.out.println(
                            "| No. |        Full Name         |    ID    |  Date of birth   |           Email            |    Phone    |  Salary    | Subject    |");
                    System.out.println(
                            "+-----+--------------------------+----------+------------------+----------------------------+-------------+------------+------------+");
                    for (int i = 0; i < foundTeachers.size(); i++) {
                        Teacher t = foundTeachers.get(i);
                        System.out.printf("| %-4d|", i + 1);
                        t.showAllInfo();
                    }
                    System.out.println(
                            "+-----+--------------------------+----------+------------------+----------------------------+-------------+------------+------------+");
                
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
                } while (!continueSearch);
            }}
        } while (continueSearch);
    }

    // Function delete Teacher
    public static void deleteTeacher() {
        Scanner scanner = new Scanner(System.in);
        // menu delete teacher
        Menu.menuDeleteTeacherMangament();
        int choice = scanner.nextInt();

        switch (choice) {
            case 1: // Option that deletes a teacher
                System.out.print("Enter the ID of the student you want to delete: ");
                String studentID = scanner.next().toUpperCase();
                boolean found = false;
                for (int i = 0; i < teacherList.size(); i++) {
                    Teacher teacher = teacherList.get(i);
                    if (teacher.getId().equals(studentID)) {
                        teacherList.remove(i);
                        found = true;
                        System.out.println("Student with ID " + teacher.getId() + " has been deleted.");
                        break; // Exit the loop after deleting the student
                    } else {
                        System.out.println("ID does not exist");
                    }
                }
                break;
            case 2: // Option that deletes all teachers
                teacherList.clear();
                System.out.println("All students have been deleted.");
                break;
            case 3:
                // Return to the main menu
                break;
            default:
                System.out.println("Invalid choice.");
        }
        writeTeachersToFile("outputTeacher.txt");
    }

    // Function showAllTeachers
    public static void showAllTeachers() {
        System.out.println(
                "--------------------------------------------------------- SHOW ALL STUDENTS --------------------------------------------------------+");
        System.out.println(
                "| No. |        Full Name         |    ID    |  Date of birth   |           Email            |    Phone    |  Salary    | Subject    |");
        System.out.println(
                "+-----+--------------------------+----------+------------------+----------------------------+-------------+------------+------------+");
        for (int i = 0; i < teacherList.size(); i++) {
            Teacher teacher = teacherList.get(i);
            System.out.printf("| %-4d|", i + 1);
            teacher.showAllInfo();
        }
        System.out.println(
                "+-----+--------------------------+----------+------------------+----------------------------+-------------+------------+------------+");
    }

    // Function add New Teacher
    public static void addNewTeacher() {
        System.out.println("---- ADD NEW TEACHER ----");
        // Using List to store teacher
        // List<Teacher> teacherList = new ArrayList<>();
        // full name: not empty, digits, and special characters
        String fullName = CheckIValidInput.checkValidName("teacher"); // đặt tên biến

        // ID: not the same ID as the entered ID, not empty, 8 characters: The first two
        // characters are words (FS); the others are digits.
        // if entering an existing ID, print an error message: “This xx already exists
        // !” and require entry again. (xx is the ID you enter)
        String teacherID = CheckIValidInput.checkID("teacher");

        // Date of birth: not empty, format: dd/mm/yyyy
        // Note: check valid month, date (based on month), and year will be <=2017 and
        // >= 1825.
        String dateOfBirth = CheckIValidInput.checkDateOfBirth("teacher");

        // Email: no empty,the email must contain First name + acronym of Middle name
        // and Last name +“ . “ + id + the extension “fpt.edu.vn”
        String email = CheckIValidInput.checkEmail(teacherID, "teacher", fullName);

        // Phone number: not empty, only digits and must have 10 digits, must have 0 at
        // first.
        String phoneNumber = CheckIValidInput.checkPhoneNumber("teacher");

        // Salary: not empty, only digits, and must be >= 20_000_000.
        double salary = CheckIValidInput.checkValidSalary();

        // Subject: not empty, not digits, and special characters;
        // The subject must be in the list of subjects: MAD, PRO, NWC, SSG, OSG.
        String subject = CheckIValidInput.checkSubject();

        Teacher newTeacher = new Teacher(fullName, teacherID, dateOfBirth, email, phoneNumber, salary, subject);
        teacherList.add(newTeacher);
        writeTeachersToFile("outputTeacher.txt");
    }

    // Function write Teachers To File
    public static void writeTeachersToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Teacher teacher : teacherList) {
                writer.write(teacher.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file: " + e.getMessage());
        }
    }

    // Function read Teachers From File
    public static void readTeachersFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Assuming each line in the file represents a Teacher object
                // and the fields are separated by a comma
                String[] fields = line.split(",");
                // Assuming the fields are in the order: name, id, dateOfBirth, email,
                // phoneNumber, salary, subject
                String name = fields[0];
                String id = fields[1];
                String dateOfBirth = fields[2];
                String email = fields[3];
                String phoneNumber = fields[4];
                Double salary = Double.parseDouble(fields[5]);
                String subject = fields[6];
                Teacher teacher = new Teacher(name, id, dateOfBirth, email, phoneNumber, salary, subject);
                teacherList.add(teacher);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading from file: " + e.getMessage());
        }
    }
}
