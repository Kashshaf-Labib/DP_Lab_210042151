public class NotificationService {

    INotification notificationService;

    public void setNotificationMethod(INotification notificationService){
        this.notificationService=notificationService;
    }

    public void sendNotification(String message){
        notificationService.sendNotification(message);
    }


}
