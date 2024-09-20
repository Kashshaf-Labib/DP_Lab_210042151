public class CreditCardPayment implements IPaymentMethod{
    @Override
    public void processPayment(double amount) {
        System.out.println("Credit Card Payment of: "+amount);
    }
}
