public class CreditCardPayment implements PaymentMethod{
    @Override
    public void processPayment(double amount) {
        System.out.println("Credit Card Payment of: "+amount);
    }
}
