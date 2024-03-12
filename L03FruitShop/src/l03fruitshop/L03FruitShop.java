 package l03fruitshop;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

/**
 * L03 - Create a Java console program to manage a Fruit Shop (Product and
 * Shopping).
 *
 * @author CE181383 Bach Cong Chinh
 */
public class L03FruitShop {

    ArrayList<Fruit> fruitList = new ArrayList<>();
    Hashtable<String, ArrayList<Fruit>> orders = new Hashtable<>();
    Scanner sc = new Scanner(System.in);

    /**
     * This method displays the list of fruits in the inventory.
     */
    public void showList() {
        System.out.println("+------+-----------------+----------------------------------+--------------+------------+------------+");
        System.out.println("| No.  | ID              | Fruit Name                       | Origin       | Quantity   | Price      |");
        System.out.println("+------+-----------------+----------------------------------+--------------+------------+------------+");
        int no = 1;
        for (Fruit listFruit : fruitList) {
            System.out.printf("| %4d | %-15s | %-32s | %-12s | %10d | %10s |\n", no,
                    MyLib.getSubstring(listFruit.getId(), 15),
                    MyLib.getSubstring(listFruit.getName(), 32),
                    MyLib.getSubstring(listFruit.getOrigin(), 12),
                    listFruit.getQuantity(),
                    "$" + listFruit.getPrice());
            no++;
        }
        System.out.println("+------+-----------------+----------------------------------+--------------+------------+------------+");

    }

    /**
     * This method creates a new fruit or restock an existing fruit in the
     * inventory.
     */
    public void createFruit() {
        if (!fruitList.isEmpty()) {
            showList();
        }
        String id = MyLib.getInputID("Enter fruit ID: ");

        // Check if the fruit ID already exists
        for (Fruit existingFruit : fruitList) {
            if (existingFruit.getId().equalsIgnoreCase(id)) {
                String restock = MyLib.question("The fruit with ID " + id + " already exists. Do you want to import more " + existingFruit.getName() + " (Y/N)? ");
                if (restock.equalsIgnoreCase("Y")) {
                    int quantity = MyLib.getIntegerInput("Enter quantity to import: ");
                    existingFruit.setQuantity(existingFruit.getQuantity() + quantity);
                    System.out.println("Imported successfully.");
                    showList();
                    return;
                } else {
                    createFruit();
                    return;
                }
            }
        }

        String name;
        int price;
        int quantity;
        String origin;
        boolean isFruitExist;

        do {
            isFruitExist = false;
            name = MyLib.getStringInput("Enter fruit name: ");
            origin = MyLib.getStringInput("Enter fruit origin: ");

            // Check if the fruit with the same name and origin already exists
            for (Fruit existFruit : fruitList) {
                if (existFruit.getName().equalsIgnoreCase(name) && existFruit.getOrigin().equalsIgnoreCase(origin)) {
                    System.out.println("Fruit with the same name and origin already exists. Try again!");
                    isFruitExist = true;
                    break;
                }
            }

        } while (isFruitExist);

        price = MyLib.getIntegerInput("Enter fruit price: ");
        quantity = MyLib.getIntegerInput("Enter fruit quantity: ");
        Fruit fruit = new Fruit(id, MyLib.reName(name), price, quantity, MyLib.reName(origin));
        fruitList.add(fruit);

        String createAgain = MyLib.question("Do you want to create another fruit? (Y/N) ");
        if (createAgain.equalsIgnoreCase("Y")) {
            createFruit();
        } else {
            showList();
        }
    }

    /**
     * This method displays the list of orders placed by customers.
     */
    public void viewOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders to display now!");
        } else {
            for (Map.Entry<String, ArrayList<Fruit>> entry : orders.entrySet()) {
                System.out.println("Customer: " + MyLib.reName(entry.getKey()));
                System.out.println("+-----+-----------------+----------------------------------+--------------+------------+------------+------------+");
                System.out.println("| No. | ID              | Fruit Name                       | Origin       | Quantity   | Price      | Amount     |");
                System.out.println("+-----+-----------------+----------------------------------+--------------+------------+------------+------------+");
                int no = 1;
                int total = 0;
                ArrayList<Fruit> fruits = entry.getValue();
                for (Fruit fruit : fruits) {
                    total += fruit.getPrice() * fruit.getQuantity();
                    System.out.printf("| %3d | %-15s | %-32s | %-12s | %10d | %10s | %10s |\n", no,
                            MyLib.getSubstring(fruit.getId(), 15),
                            MyLib.getSubstring(fruit.getName(), 32),
                            MyLib.getSubstring(fruit.getOrigin(), 12),
                            fruit.getQuantity(),
                            "$" + fruit.getPrice(),
                            "$" + fruit.getPrice() * fruit.getQuantity());
                    no++;
                }
                System.out.println("+-----+-----------------+----------------------------------+--------------+------------+------------+------------+");
                System.out.printf("|                                                                                          TOTAL    | %10s |\n", "$" + total);
                System.out.println("+-----+-----------------+----------------------------------+--------------+------------+------------+------------+");
                System.out.println();
            }
        }
    }

    /**
     * This method allows a customer to place an order.
     */
    public void shopping() {
        ArrayList<Fruit> currentOrder = new ArrayList<>();
        String name = "";

        //Check if all fruits are out of stock
        boolean allOutOfStock = true;
        for (Fruit fruit : fruitList) {
            if (fruit.getQuantity() > 0) {
                allOutOfStock = false;
                break;
            }
        }

        if (allOutOfStock) {
            System.out.println("All fruits are out of stock, please wait for restock!");
            return;
        }
        while (true) {

            System.out.println("List of Fruit:");
            System.out.println("+-----+-----------------+----------------------------------+--------------+------------+------------+");
            System.out.println("| No. | ID              | Fruit Name                       | Origin       | Quantity   | Price      |");
            System.out.println("+-----+-----------------+----------------------------------+--------------+------------+------------+");
            int no = 1;
            ArrayList<Fruit> availableFruits = new ArrayList<>();
            for (Fruit fruit : fruitList) {
                if (fruit.getQuantity() != 0) {
                    availableFruits.add(fruit);
                    System.out.printf("| %3d | %-15s | %-32s | %-12s | %10d | %10s |\n", no,
                            MyLib.getSubstring(fruit.getId(), 15),
                            MyLib.getSubstring(fruit.getName(), 32),
                            MyLib.getSubstring(fruit.getOrigin(), 12),
                            fruit.getQuantity(),
                            "$" + fruit.getPrice());
                    no++;
                }
            }
            System.out.println("+-----+-----------------+----------------------------------+--------------+------------+------------+");

            //Check if the item is still onstock or invalid choose
            int item = 0;
            boolean onStock = false;
            do {
                item = MyLib.getIntegerInput("Please select an item: ");
                if (item == 0 || item > availableFruits.size()) {
                    System.out.println("Invalid choose! Please choose again from the item's number in list above!");
                    if (availableFruits.size() != 1) {
                        System.out.println("From 1 to " + availableFruits.size() + " !");
                    }
                } else {
                    if (availableFruits.get(item - 1).getQuantity() > 0) {
                        onStock = true;
                    } else {
                        System.out.println("The fruit is out of stock, please order another.");
                    }
                }
            } while (!onStock);

            //Check the quantity is enough for customer
            Fruit selectedFruit = availableFruits.get(item - 1);
            System.out.println("You selected: " + selectedFruit.getName());
            int quantity;
            do {
                quantity = MyLib.getIntegerInput("Please input quantity: ");
                if (quantity > selectedFruit.getQuantity()) {
                    System.out.println("The quantity remaining of " + selectedFruit.getName() + " : " + selectedFruit.getQuantity() + ". Not enough for your buying! Please buy again!");
                }
            } while (quantity > selectedFruit.getQuantity());

            //Check if order exist fruit already order then it will accumulate
            boolean isExistingFruit = false;
            for (Fruit orderedFruit : currentOrder) {
                if (orderedFruit.getId().equalsIgnoreCase(selectedFruit.getId())) {
                    orderedFruit.setQuantity(orderedFruit.getQuantity() + quantity);
                    isExistingFruit = true;
                    break;
                }
            }
            if (!isExistingFruit) {
                currentOrder.add(new Fruit(selectedFruit.getId(), selectedFruit.getName(), selectedFruit.getPrice(), quantity, selectedFruit.getOrigin()));
            }
            selectedFruit.setQuantity(selectedFruit.getQuantity() - quantity);

            //check is all fruit is out of stock when buying
            allOutOfStock = true;
            for (Fruit fruit : fruitList) {
                if (fruit.getQuantity() > 0) {
                    allOutOfStock = false;
                    break;
                }
            }

            if (allOutOfStock) {
                System.out.println("All fruits are out of stock, please wait for restock!");
                System.out.println("+-----+-----------------+----------------------------------+--------------+------------+------------+------------+");
                System.out.println("| No. | ID              | Fruit Name                       | Origin       | Quantity   | Price      | Amount     |");
                System.out.println("+-----+-----------------+----------------------------------+--------------+------------+------------+------------+");
                int noView = 1;
                for (Fruit listFruit : currentOrder) {
                    System.out.printf("| %3d | %-15s | %-32s | %-12s | %10d | %10s | %10s |\n",
                            noView,
                            MyLib.getSubstring(listFruit.getId(), 15),
                            MyLib.getSubstring(listFruit.getName(), 32),
                            MyLib.getSubstring(listFruit.getOrigin(), 12),
                            listFruit.getQuantity(),
                            "$" + listFruit.getPrice(),
                            "$" + (listFruit.getQuantity() * listFruit.getPrice()));
                    noView++;
                }
                System.out.println("+-----+-----------------+----------------------------------+--------------+------------+------------+------------+");
                name = MyLib.getCustomerName("Input your name: ");
                String baseName = name;
                int count = 1;
                while (orders.containsKey(name)) {
                    name = baseName + "_" + count;
                    count++;
                }
                orders.put(name, currentOrder);
                return;
            } else {
                String orderMore = MyLib.question("Do you want to order now (Y/N)? ");
                if (orderMore.equalsIgnoreCase("Y")) {
                    System.out.println("+-----+-----------------+----------------------------------+--------------+------------+------------+------------+");
                    System.out.println("| No. | ID              | Fruit Name                       | Origin       | Quantity   | Price      | Amount     |");
                    System.out.println("+-----+-----------------+----------------------------------+--------------+------------+------------+------------+");
                    int noView = 1;
                    for (Fruit listFruit : currentOrder) {
                        System.out.printf("| %3d | %-15s | %-32s | %-12s | %10d | %10s | %10s |\n",
                                noView,
                                MyLib.getSubstring(listFruit.getId(), 15),
                                MyLib.getSubstring(listFruit.getName(), 32),
                                MyLib.getSubstring(listFruit.getOrigin(), 12),
                                listFruit.getQuantity(),
                                "$" + listFruit.getPrice(),
                                "$" + (listFruit.getQuantity() * listFruit.getPrice()));
                        noView++;
                    }
                    System.out.println("+-----+-----------------+----------------------------------+--------------+------------+------------+------------+");

                    name = MyLib.getCustomerName("Input your name: ");
                    String baseName = name;
                    int count = 1;
                    while (orders.containsKey(name)) {
                        name = baseName + "_" + count;
                        count++;
                    }
                    orders.put(name, currentOrder);
                    break;
                }
            }
        }
    }

    /**
     * The main method.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        L03FruitShop app = new L03FruitShop();
        while (true) {
            System.out.println("FRUIT SHOP SYSTEM");
            System.out.println("1. Create Fruit");
            System.out.println("2. View orders");
            System.out.println("3. Shopping (for buyer)");
            System.out.println("4. Exit");

            int choice = MyLib.inputChoose("Please choose: ");

            switch (choice) {
                case 1:
                    app.createFruit();
                    break;
                case 2:
                    app.viewOrders();
                    break;
                case 3:
                    app.shopping();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again between 1 to 4.");
            }
        }
    }

}
