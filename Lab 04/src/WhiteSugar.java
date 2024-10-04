public class WhiteSugar extends Condiment{

   private Condiment condiment;

    public WhiteSugar(Condiment condiment)
    {
         this.condiment = condiment;
         this.description = "White Sugar "+condiment.getDescription();
         this.cost = 2.0+condiment.getCost();
    }
}
