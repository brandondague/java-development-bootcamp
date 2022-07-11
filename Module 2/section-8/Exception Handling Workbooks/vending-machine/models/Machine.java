package models;
public class Machine {
    private Item[][] items;

    public Machine(Item[][] items) {
        this.items = new Item[items.length][items[0].length];
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items[i].length; j++) {
                this.items[i][j] = new Item(items[i][j]);
            }
        }
    }
    
    public Item getItem(int row, int spot) {
        return new Item(this.items[row][spot]);
    }
    
    public void setItem(Item item, int row, int spot) {
        this.items[row][spot] = new Item(item);
    }

    public void dispense(int row, int spot) {
        if (isEmpty(row, spot)) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        items[row][spot].setQuantity(items[row][spot].getQuantity() - 1);
    }

    public boolean isEmpty(int row, int spot) {
        Item item = getItem(row, spot);
        if (item.getQuantity() <= 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < items.length; i++) {
            temp += "\t";
            for (int j = 0; j < items[i].length; j++) {
                temp += items[i][j].toString() + " ";
            }
            temp += "\n\n";
        }
        temp += "\t************************************************";
        return temp;
    }

}
