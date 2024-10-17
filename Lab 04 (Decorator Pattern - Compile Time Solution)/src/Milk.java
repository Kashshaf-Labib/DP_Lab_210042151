public class Milk extends Condiment{

    private Condiment condiment;

    public Milk(Condiment condiment)
    {
        this.condiment = condiment;
        this.description = "Milk "+condiment.getDescription();
        this.cost = 5.0+condiment.getCost();
    }
}
