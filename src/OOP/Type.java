package OOP;

public class Type {
private String code;
private String name;
private double price;
private int discount;
private Category category;

    public Type(String code, String name, double price, int discount) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public Type(String code, String name, double price, int discount, Category category) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.category = category;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getDiscount() {
        return discount;
    }


	
}