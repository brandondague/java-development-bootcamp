public class Item {

    private String item;
    private double price;
    private int quantity;

    public Item(String item, double price, int quantity) {
        this.item = item;
        this.price = price;
        this.quantity = quantity;
    }

    public Item(Item source) {
        this.item = source.item;
        this.price = source.price;
        this.quantity = source.quantity;
    }

    public String getItem() {
        return this.item;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        return this.item + ": " + this.price + " (" + this.quantity + ") ";
    }
}
