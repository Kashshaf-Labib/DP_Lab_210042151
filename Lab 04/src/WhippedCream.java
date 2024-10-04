public class WhippedCream extends Condiment{

        private Condiment condiment;

        public WhippedCream(Condiment condiment)
        {
            this.condiment = condiment;
            this.description = "Whipped Cream "+condiment.getDescription();
            this.cost = 3.0+condiment.getCost();
        }
}
