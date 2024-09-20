public class DigitalWalletPayment implements IPaymentMethod{
    @Override
    public void processPayment(double amount) {
        System.out.println("Digital Wallet Payment of: "+amount);
    }
}
