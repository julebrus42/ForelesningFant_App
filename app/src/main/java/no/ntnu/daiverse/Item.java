package no.ntnu.daiverse;

public class Item {

    private String item;
    private String description;
    private int price;
    private Long itemid;


    public Item(Long itemid) {
        this.itemid = itemid;

    }

    public Item(String itemName, String descriptionView, int price) {
        this.item = itemName;
        this.description = descriptionView;
        this.price = price;
    }

    public Item(String itemName, String descriptionView, int price, Long itemid) {
        this.item = itemName;
        this.description = descriptionView;
        this.price = price;
        this.itemid = itemid;

    }

    public String getItemName() {
        return item;
    }

    public void setItemName(String headerView) {
        this.item = headerView;
    }

    public String getDescriptionView() {
        return description;
    }

    public void setDescriptionView(String descriptionView) {
        this.description = descriptionView;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Long getItemid() {
        return itemid;
    }


    @Override
    public String toString() {
        return "Item{" +
                ", itemName='" + item + '\'' +
                ", descriptionView='" + description + '\'' +
                ", price=" + price + '\'' +
                ", itemid=" + itemid + '\'' +
                '}';
    }
}
