public class NotificationSender {
    public void sendNotification(INotificationService notificationService, String message) {
        notificationService.sendNotification(message);
    }
}
