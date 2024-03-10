import java.util.ArrayList;
import java.util.List;

public class TeacherManagement{

    public static void sortTeacher() {
        System.out.println("---- SORT TEACHER ----");
        System.out.println("1. Sort ascending.");
        System.out.println("2. Sort descending.");
        System.out.println("3. Back to main menu.");
        System.out.print("Enter your choice: ");

        //Continue coding here:
    }

    public static void searchTeacher() {
        System.out.println("---- SEARCH TEACHER ----");
        System.out.println("1. Search by name.");
        System.out.println("2. Search by ID.");
        System.out.println("3. Search by age.");
        System.out.println("4. Search by phone number.");
        System.out.println("5. Search by salary.");
        System.out.println("6. Search by subject.");
        System.out.println("7. Back to main menu.");
        System.out.print("Enter your choice: ");

        //Continue coding here:

    }

    public static void deleteTeacher() {
        System.out.println("---- DELETE TEACHER ----");
        System.out.println("1. Delete a teacher.");
        System.out.println("2. Delete all teachers.");
        System.out.println("3. Back to main menu.");
        System.out.print("Enter your choice: ");

        //Continue coding here:
    }

    public static void showAllTeachers() {
        System.out.println("---- SHOW ALL TEACHERS ----");
        //Continue coding here:
        //The table must contain
    }

    public static void addNewTeacher() {
        System.out.println("---- ADD NEW TEACHER ----");
        List<Teacher> teacherList = new ArrayList<>();
        //full name
        String name = CheckIValidInput.checkValidName("teacher");
        //ID
        String teacherID = CheckIValidInput.checkID("teacher");
        //Date of birth
        CheckIValidInput.checkDateOfBirth("teacher");
        //Email
        CheckIValidInput.checkEmail(teacherID, "teacher", name);
        //Phone number
        CheckIValidInput.checkPhoneNumber("teacher");
        //Salary
        CheckIValidInput.checkValidSalary();
        //Subject
        CheckIValidInput.checkSubject();
    }
}

