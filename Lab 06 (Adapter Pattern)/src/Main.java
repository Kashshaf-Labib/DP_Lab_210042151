public class Main {
    public static void main(String[] args) {

        NotificationService notificationService = new NotificationService();

        SMSNotification smsNotification = new SMSNotification();
        notificationService.setNotificationMethod(smsNotification);
        notificationService.sendNotification("Hello from SMS");

        EPostalMailNotification ePostalMailNotification = new EPostalMailNotification();
        EPostalMailAdapter adapter=new EPostalMailAdapter(ePostalMailNotification,"1234 Boardbazar, Gazipur");
        notificationService.setNotificationMethod(adapter);
        notificationService.sendNotification("Hello from EPostalMail");

    }
}