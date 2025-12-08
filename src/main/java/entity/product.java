package entity;

public class Product {
    private int ID;
    private String name;
    private String description;
    private String color;
    private decimal size;
    private decimal price;
}

public class Product {
    private int ID;
    private String name;
    private String color;
    private decimal size;
    private decimal price;
}

public class Product {

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

public decimal getSize() {
    return size;
}

public decimal getPrice() {
    return price;
}

@Override
public String toString() {
    return "Product{" + "ID=" + ID + ", name=" + name + ", description=" + description + ', color=' + color + ', size=' + size + ', price=' + price + '}';
}

public void setName(String name) {
    this.name = name;
}

public void setDescription(String description) {
    this.description = description;
}
  

  
