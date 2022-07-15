package src.main.models;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Cart {
    ArrayList<Item> items;

    public Cart() {
        this.items = new ArrayList<Item>();
    }

    public Item getItem(int index) {
        return new Item(this.items.get(index));
    }

    public void setItem(int index, Item item) {
        this.items.set(index, new Item(item));
    }

    public boolean addItem(Item item) {
        if (this.items.contains(item)) {
            return false;
        }
        this.items.add(new Item(item));
        return true;
    }

    public void removeItem(String name) {
        if (items.isEmpty()) {
            throw new IllegalStateException("cannot remove items from an empty cart");
        }
        items.removeIf((item) -> item.getName().equalsIgnoreCase(name));
    }

    public void clearCart() {
        this.items.clear();
    }

    public double getSubtotal() {
        return doubleFormatter(this.items.stream().mapToDouble((item) -> item.getPrice()).sum());
    }

    public double getTax() {
        return doubleFormatter(getSubtotal() * 0.15);
    }

    public double getTotal() {
        return doubleFormatter(getSubtotal() + getTax());
    }

    public double doubleFormatter(double number) {
        DecimalFormat formatter = new DecimalFormat("#.##");
        return Double.parseDouble(formatter.format(number));
    }

    public String checkout() {
        if (this.items.isEmpty()) {
            throw new IllegalStateException("cannot checkout with an empty cart");
        }
        return "Subtotal: $" + getSubtotal() +
               "Tax: $" + getTax() +
               "Total: $" + getTotal();
    }

    public boolean contains(Item item) {
        return this.items.contains(item);
    }
    
    public String toString() {
        String temp = "";
        for (int i = 0; i < this.items.size(); i++) {
            temp += this.items.get(i).toString();
            temp += "\n";
        }
        return temp;
    }

}
