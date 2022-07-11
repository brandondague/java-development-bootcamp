package models;

public class Item {

    private String item;
    private double price;

    public Item(String item, double price) {
        if (item == null || item.isBlank()) {
            throw new IllegalArgumentException("item cannot be null/empty");
        }
        if (price < 0) {
            throw new IllegalArgumentException("price cannot be less than 0");
        }
        this.item = item;
        this.price = price;
    }

    public Item(Item source) {
        this.item = source.item;
        this.price = source.price;
    }

    public String getItem() {
        return item;
    }

    public double getPrice() {
        return price;
    }

    public void setItem(String item) {
        if (item == null || item.isBlank()) {
            throw new IllegalArgumentException("item cannot be null/empty");
        }
        this.item = item;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("price cannot be less than 0");
        }
        this.price = price;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Item)) {
            return false;
        }
        Item item = (Item)obj;
        return this.item.equals(item.item) && this.price == item.price;
    }

    public String toString() {
        return this.item + ": $" + this.price;
    }

  
}
