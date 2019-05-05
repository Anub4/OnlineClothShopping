package models;

public class Item {
    private String name;
    private int price;
    private String desc;
    private String imgName;

    public Item(String name, int price, String desc, String imgName) {
        this.name = name;
        this.price = price;
        this.desc = desc;
        this.imgName = imgName;
    }

    public Item() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }
}
