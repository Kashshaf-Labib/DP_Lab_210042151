public class PaymentProcessor {

    public void processPayment(double amount,PaymentMethod paymentMethod)
    {
        paymentMethod.processPayment(amount);
    }
}
