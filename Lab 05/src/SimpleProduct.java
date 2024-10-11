public abstract class SimpleProduct implements IProduct{

    double price;

    String name;

    String description;
    @Override
    public abstract double getPrice();

    @Override
    public abstract String getDescription();
}
