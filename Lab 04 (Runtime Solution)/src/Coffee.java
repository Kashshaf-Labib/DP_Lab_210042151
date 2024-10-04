public class Coffee implements IBeverage{
    @Override
    public String getDesciption() {
        return "Beverage: Coffee\n";
    }

    @Override
    public double getCost() {
        return 12;
    }
}
