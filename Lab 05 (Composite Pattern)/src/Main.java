public class Main {
    public static void main(String[] args) {


        SimpleProduct laptop=new SimpleProduct("Acer Laptop","Model:Aspire 5", 1199);

        SimpleProduct mouse=new SimpleProduct("Logitech Mouse","Model:MX Master 3", 99);

        SimpleProduct keyboard=new SimpleProduct("Logitech Keyboard","Model:G915", 199);

        System.out.println("Simple Products:");
        System.out.println(laptop.getName()+" "+laptop.getDescription()+" Price:"+laptop.getPrice());
        System.out.println(mouse.getName()+" "+mouse.getDescription()+" Price:"+mouse.getPrice());
        System.out.println(keyboard.getName()+" "+keyboard.getDescription()+" Price:"+keyboard.getPrice());

        System.out.println("\n");


        ProductBundle TechBundle=new ProductBundle("New Year Tech Bundle",true);

        TechBundle.addProduct(laptop);

        TechBundle.addProduct(mouse);

        TechBundle.addProduct(keyboard);

        System.out.println("Bundle:");

        System.out.println(TechBundle.getName()+"\n"+TechBundle.getDescription()+"\nPrice:"+TechBundle.getPrice());

        ProductBundle SpecialBundle=new ProductBundle("Tech Bundle with Headphone",false);

        SimpleProduct headphone=new SimpleProduct("Sony Headphone","Model:WH-1000XM4", 349);

        SpecialBundle.addProduct(TechBundle);

        SpecialBundle.addProduct(headphone);

        System.out.println("\n");

        System.out.println("Special Bundle:");

        System.out.println(SpecialBundle.getName()+"\n"+SpecialBundle.getDescription()+"\n"+SpecialBundle.getPrice());


    }
}