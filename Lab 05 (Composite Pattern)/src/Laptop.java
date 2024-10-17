public class Laptop extends SimpleProduct{
    public Laptop(double price,String name,String description)
    {
        this.price=price;
        this.name=name;
        this.description=description;
    }
    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return description;
    }

}
