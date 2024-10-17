public class Espresso implements IBeverage{
    @Override
    public String getDesciption() {
        return "Beverage: Espresso\n";
    }

    @Override
    public double getCost() {
        return 10;
    }
}
