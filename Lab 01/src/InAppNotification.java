public class InAppNotification implements INotificationService{
    @Override
    public void sendNotification(String message) {
        System.out.println("InApp Notification: "+message);
    }
}
