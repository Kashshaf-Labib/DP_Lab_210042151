public class PayPalPayment implements PaymentMethod{
    @Override
    public void processPayment(double amount) {
        System.out.println("PayPal Payment of: "+amount);
    }
}
