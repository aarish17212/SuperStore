package Classes;

public class OrderedItem {
    private String ItemName;
    private int QuantityOrdered;

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public int getQuantityOrdered() {
        return QuantityOrdered;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        QuantityOrdered = quantityOrdered;
    }

    public OrderedItem(String ItemName, int QuantityOrdered){
        this.ItemName = ItemName;
        this.QuantityOrdered = QuantityOrdered;
    }

    public String toString(){
        return (ItemName + " (" + Integer.toString(QuantityOrdered) + ")");
    }
}
