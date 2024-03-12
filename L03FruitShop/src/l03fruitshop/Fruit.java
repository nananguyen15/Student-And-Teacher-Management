package l03fruitshop;

/**
 * L03 - Create a Java console program to manage a Fruit Shop (Product and
 * Shopping).
 *
 * @author CE181383 Bach Cong Chinh
 */
public class Fruit {

    private String id;
    private String name;
    private int price;
    private int quantity;
    private String origin;

    /**
     * Create Fruit constructor
     *
     * @param id the fruit's id
     * @param name the fruit's name
     * @param price the fruit's price
     * @param quantity the fruit's quantity
     * @param origin the fruit's origin
     */
    public Fruit(String id, String name, int price, int quantity, String origin) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    /**
     * Returns the ID of the fruit.
     *
     * @return a String representing the fruit's ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the name of the fruit.
     *
     * @return a String representing the fruit's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the price of the fruit.
     *
     * @return an integer representing the fruit's price.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Returns the quantity of the fruit.
     *
     * @return an integer representing the fruit's quantity.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Returns the origin of the fruit.
     *
     * @return a String representing the fruit's origin.
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Sets the ID of the fruit.
     *
     * @param id a String containing the fruit's ID.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Sets the name of the fruit.
     *
     * @param name a String containing the fruit's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the price of the fruit.
     *
     * @param price an integer containing the fruit's price.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Sets the quantity of the fruit.
     *
     * @param quantity an integer containing the fruit's quantity.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Sets the origin of the fruit.
     *
     * @param origin a String containing the fruit's origin.
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * Display the information of fruit
     *
     * @return a string information of object fruit
     */
    @Override
    public String toString() {
        return "Fruit{"
                + "id=" + id + "\\" + ", name=" + name + "\\" + ", price=" + price + ", quantity=" + quantity + ", origin='" + origin + "\\" + "}";
    }
}
