package entity;

public class Product {
    private int ID;
    private String name;
    private String description;
    private String color;
    private double size;
    private double price;

    public Product(int ID, String name, String description, String color, double size, double price) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.color = color;
        this.size = size;
        this.price = price;
    }
    
    public Product(int ID, String name, String color, double size, double price) {
        this.ID = ID;
        this.name = name;
        this.color = color;
        this.size = size;
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getColor() {
        return color;
    }

    public double getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" + "ID=" + ID + ", name=" + name + ", description=" + description + ", color=" + color + ", size=" + size + ", price=" + price + '}';
    }   

    public void setName(String name) {
        this.name = name;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

}
