public class PayPalPayment implements IPaymentMethod{
    @Override
    public void processPayment(double amount) {
        System.out.println("PayPal Payment of: "+amount);
    }
}
