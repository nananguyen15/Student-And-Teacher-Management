import java.util.Scanner;

public class UI_Teacher{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create an object of BookManagement
        do {
            Menu.menuTeacherMangament();
            while (!sc.hasNextInt()) {
                System.out.println("The function of application must be from 1 to 6!\n");
                sc.nextLine();
                Menu.menuTeacherMangament();
            }
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    TeacherManagement.addNewTeacher();
                    break;
                case 2:
                    TeacherManagement.showAllTeachers();
                    break;
                case 3:
                    TeacherManagement.deleteTeacher();
                    break;
                case 4:
                    TeacherManagement.searchTeacher();
                    break;
                case 5:
                    TeacherManagement.sortTeacher();
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
