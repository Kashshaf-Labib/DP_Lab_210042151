public class Espresso implements ICoffee {

    private String description;

    private double totalCost=30.0;
    public Espresso(Condiment condiment)
    {
       this.description = "Espresso ";
       description+=condiment.getDescription()+" ";
       totalCost+=condiment.getCost();
    }

    @Override
    public String getDescription() {
        return "Coffee Type: " + description;
    }

    @Override
    public double getCost() {
        return totalCost;
    }

}
