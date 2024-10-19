public class PaymentProcessor {

    public void processPayment(double amount,IPaymentMethod paymentMethod)
    {
        paymentMethod.processPayment(amount);
    }
}
