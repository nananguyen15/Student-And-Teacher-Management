import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create an object of BookManagement
        do {
            Menu.mainMenu();
            while (!sc.hasNextInt()) {
                System.out.println("The function of application must be from 1 to 6!\n");
                sc.nextLine();
                Menu.mainMenu();
            }
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    UI_Student.main(args);
                    break;
                case 2:
                    UI_Teacher.main(args);
                    break;
                case 3:
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