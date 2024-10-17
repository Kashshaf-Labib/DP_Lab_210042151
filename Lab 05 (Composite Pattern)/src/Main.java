public class Main {
    public static void main(String[] args) {

        Laptop laptop = new Laptop(1000, "Acer", "Aspire 5");
        Phone phone = new Phone(500, "Iphone", "SE 2020");

        System.out.println(laptop.getDescription());
        System.out.println(laptop.getPrice());
        System.out.println(phone.getDescription());
        System.out.println(phone.getPrice());

        ProductBundle bundle = new ProductBundle();

        bundle.addProduct(laptop);
        bundle.addProduct(phone);
        bundle.setAddDiscount(true);

        System.out.println(bundle.getDescription());
        System.out.println(bundle.getPrice());







    }
}