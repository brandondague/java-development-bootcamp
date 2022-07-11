package models;

import java.util.ArrayList;

public class Cart {

    private ArrayList<Item> items;
    
    public Cart() {
        this.items = new ArrayList<Item>();
    }


   /**
    * Name: add
    * @param item
    * @return boolean
    *
    * Inside the function:
    *   1. Adds an item to the cart if it wasn't already added.
    */
    public boolean add(Item item) {
        if (items.contains(item)) {
            return false;
        }
        items.add(new Item(item));
        return true;
    }

 
 
  
   /**
    * Name: remove
    * @param name
    *
    * Inside the function:
    *   1. Removes the item that matches the name passed in.
    */
    public void remove(String name) {
        if (items.isEmpty()) {
            throw new IllegalStateException("cannot remove items from an empty cart");
        }
        for (Item item : items) {
            if (item.getItem().equalsIgnoreCase(name)) {
                items.remove(item);
                break;
            }
        }
    }

 
 
  
   /**
    *  Name: checkout
    *  @return (String)
    *
    *  Inside the function:
    *   1. Calculates the subtotal (price before tax).
    *   2. Calculates the tax (assume tax is 13%).
    *   3. Calculates total: subtotal + tax
    *   4. Returns a String that resembles a receipt. See below.
    */
    public String checkout() {
        if (items.isEmpty()) {
            throw new IllegalStateException("cannot checkout an empty cart");
        }
        double subtotal = 0;
        double tax = 0;
        double total = 0;
        for (Item item : items) {
            subtotal += item.getPrice();
        }
        tax = subtotal * 0.13;
        total = subtotal + tax;
        return "\tRECEIPT\n\n" +
               "\tSubtotal: $" + subtotal + "\n" +
               "\tTax: $" + tax + "\n" +
               "\tTotal: $" + total + "\n";
    }

    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    public String toString() {
        String temp = "";
        for (Item item : items) {
            temp += item.toString() + "\n";
        }
        return temp;
    }
    
}
