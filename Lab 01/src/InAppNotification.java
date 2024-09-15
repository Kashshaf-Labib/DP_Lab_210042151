public class InAppNotification implements NotificationService{
    @Override
    public void sendNotification(String message) {
        System.out.println("InApp Notification: "+message);
    }
}
