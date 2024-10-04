public class Main {
    public static void main(String[] args) {

        System.out.println("Order 1: ");

        Latte latte=new Latte(new Milk(new WhiteSugar(new PlainCondiment())));

        System.out.println(latte.getDescription());
        System.out.println(latte.getCost());

        System.out.println("Order 2: ");

        Espresso espresso=new Espresso(new WhippedCream(new WhiteSugar(new Milk(new PlainCondiment()))));

        System.out.println(espresso.getDescription());
        System.out.println(espresso.getCost());
    }
}