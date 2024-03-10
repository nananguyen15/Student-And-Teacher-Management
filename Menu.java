public class Menu{
    public static void mainMenu(){
        System.out.println("\t*---------------- MANAGEMENT SYSTEM ----------------*");
        System.out.println("\t| 1. Student Management\t\t\t\t\t\t\t\t|");
        System.out.println("\t| 2. Teacher Management\t\t\t\t\t\t\t\t|");
        System.out.println("\t| 3. Exit\t\t\t\t\t\t\t\t\t\t\t|");
        System.out.println("\t*---------------------------------------------------*");
        System.out.print("Enter your choice: ");
    }

    public static void menuStudentMangament(){
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

    public static void menuTeacherMangament(){
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

    public static void exit() {
        System.out.println("THANK YOU FOR USING OUR APPLICATION.\n" +
                "SEE YOU AGAIN!");
        System.exit(0);
    }

}
