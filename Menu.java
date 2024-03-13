public class Menu{
    public static void mainMenu() {
        System.out.println("\t*---------------- MANAGEMENT SYSTEM ----------------*");
        System.out.println("\t| 1. Student Management\t\t\t\t\t\t\t\t|");
        System.out.println("\t| 2. Teacher Management\t\t\t\t\t\t\t\t|");
        System.out.println("\t| 3. Exit\t\t\t\t\t\t\t\t\t\t\t|");
        System.out.println("\t*---------------------------------------------------*");
        System.out.print("Enter your choice: ");
    }

    public static void menuStudentMangament() {
        System.out.println("\t*---------------- STUDENT MANAGEMENT SYSTEM ----------------*");
        System.out.println("\t| 1. Add new student\t\t\t\t\t\t\t\t\t\t|");
        System.out.println("\t| 2. Show all students\t\t\t\t\t\t\t\t\t\t|");
        System.out.println("\t| 3. Delete a/all student(s)\t\t\t\t\t\t\t\t|");
        System.out.println("\t| 4. Search student by name/ID/Age/Email/Phone number/GPA\t|");
        System.out.println("\t| 5. Sort ascending/ descending\t\t\t\t\t\t\t\t|");
        System.out.println("\t| 6. Exit\t\t\t\t\t\t\t\t\t\t\t\t\t|");
        System.out.println("\t*-----------------------------------------------------------*");
        System.out.print("Enter your choice: ");
    }

    public static void menuTeacherMangament() {
        System.out.println("\t*---------------- TEACHER MANAGEMENT SYSTEM ----------------*");
        System.out.println("\t| 1. Add new teacher\t\t\t\t\t\t\t\t\t\t|");
        System.out.println("\t| 2. Show all teachers\t\t\t\t\t\t\t\t\t\t|");
        System.out.println("\t| 3. Delete a/all teacher(s)\t\t\t\t\t\t\t\t|");
        System.out.println("\t| 4. Search teacher by Name/ID/Age/Email/Salary/Subject\t\t|");
        System.out.println("\t| 5. Sort ascending/ descending\t\t\t\t\t\t\t\t|");
        System.out.println("\t| 6. Exit\t\t\t\t\t\t\t\t\t\t\t\t\t|");
        System.out.println("\t*-----------------------------------------------------------*");
        System.out.print("Enter your choice: ");
    }
    public static void menuSearchTeacherMangament() {
        System.out.println("---- SEARCH STUDENT ----");
        System.out.println("1. Search by name.");
        System.out.println("2. Search by ID.");
        System.out.println("3. Search by Age.");
        System.out.println("4. Search by phone number.");
        System.out.println("5. Search by Email.");
        System.out.println("6. Search by main menu Salary.");
        System.out.println("7. Search by main menu Subject.");
        System.out.println("8. Back to main menu");
        System.out.print("Enter your choice: ");
    }
    public static void menuSearchStudentMangament() {
        System.out.println("---- SEARCH STUDENT ----");
        System.out.println("1. Search by name.");
        System.out.println("2. Search by ID.");
        System.out.println("3. Search by Age.");
        System.out.println("4. Search by phone number.");
        System.out.println("5. Search by GPA.");
        System.out.println("6. Back to main menu");
        System.out.print("Enter your choice: ");
    }



    public static void exit() {
        System.out.println("THANK YOU FOR USING OUR APPLICATION.\n" + "SEE YOU AGAIN!");
        System.exit(0);
    }

}
