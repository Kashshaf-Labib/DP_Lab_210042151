public class EmailNotification implements INotificationService{
    @Override
    public void sendNotification(String message) {
        System.out.println("Email Notification: "+message);
    }
}
