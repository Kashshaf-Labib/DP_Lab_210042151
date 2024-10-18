public class SMSNotification implements INotification{
    @Override
    public void sendNotification(String message) {
        System.out.println("SMS: " + message);
    }
}
