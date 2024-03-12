import java.util.Scanner;

public class UI_Student{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create an object of BookManagement
        do {
            Menu.menuStudentMangament();
            while (!sc.hasNextInt()) {
                System.out.println("The function of application must be from 1 to 6!\n");
                sc.nextLine();
                Menu.menuStudentMangament();
            }
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    StudentManagement.addNewStudent();
                    break;
                case 2:
                    StudentManagement.showAllStudent();
                    break;
                case 3:
                    StudentManagement.deleteStudent();
                    break;
                case 4:
                    StudentManagement.searchStudent();
                    break;
                case 5:
//                    StudentManagement.sortStudent();
                    break;
                case 6:
                    Menu.exit();
                    break;
                default:
                    System.out.println("The function of application must be from 1 to 6!\n" + "Please choose again!");
                    break;
            }
        }
        while (true);
    }
}
