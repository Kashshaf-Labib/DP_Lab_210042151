public class Latte implements ICoffee {

    private String description;

    private double totalCost=25.0;

    public Latte(Condiment condiment)
    {
        this.description = "Latte ";
        description+=condiment.getDescription()+" ";
        totalCost+=condiment.getCost();
    }
    @Override
    public String getDescription() {
        return "Coffee Type: "+description;
    }

    @Override
    public double getCost() {
        return totalCost;
    }
}
