public class Phone extends SimpleProduct{
    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public Phone(double price,String name,String description)
    {
        this.price=price;
        this.name=name;
        this.description=description;
    }
}
