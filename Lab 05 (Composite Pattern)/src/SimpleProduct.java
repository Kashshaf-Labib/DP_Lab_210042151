public class SimpleProduct implements IProduct{

    private String name;

    private String description;

    private double price;
    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public SimpleProduct(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
