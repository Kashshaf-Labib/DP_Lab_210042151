import java.util.Dictionary;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Dictionary<Integer,IBeverage> beverages = BeverageAdder.prepareBeverage();
        Dictionary<Integer,ICondiment> condiments = CondimentAdder.addCondiment();

        String details="";
        double totalCost=0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Select a beverage:");
        System.out.println("1. Coffee");
        System.out.println("2. Espresso");
        System.out.println("3. Latte");


        int beverageChoice = scanner.nextInt();

        switch (beverageChoice) {
            case 1:
                details+=beverages.get(1).getDesciption();
                totalCost+=beverages.get(1).getCost();
                break;
            case 2:
                details+=beverages.get(2).getDesciption();
                totalCost+=beverages.get(2).getCost();
                break;
            case 3:
                details+=beverages.get(3).getDesciption();
                totalCost+=beverages.get(3).getCost();
                break;
            default:
                System.out.println("Invalid choice");
        }

        while(true)
        {
            System.out.println("Do you want to add condiments?");
            System.out.println("1. White Sugar");
            System.out.println("2. Milk");
            System.out.println("3. Whipped Cream");
            System.out.println("4. No");
            int condimentChoice = scanner.nextInt();
            if(condimentChoice==4)
            {
                break;
            }
            else
            {
                details+=condiments.get(condimentChoice).addCondiment();
                totalCost+=condiments.get(condimentChoice).getCost();
                System.out.println("Total cost: "+totalCost);
                System.out.println(details);
            }
        }
    }
}