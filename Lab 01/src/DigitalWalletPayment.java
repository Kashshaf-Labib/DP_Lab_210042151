public class DigitalWalletPayment implements PaymentMethod{
    @Override
    public void processPayment(double amount) {
        System.out.println("Digital Wallet Payment of: "+amount);
    }
}
