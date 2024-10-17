public class Cappuccino implements ICoffee{

    private String description;

    private double totalCost=35.0;

    public Cappuccino(Condiment condiment)
    {
        this.description = "Cappuccino ";
        description+=condiment.getDescription()+ " ";
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
