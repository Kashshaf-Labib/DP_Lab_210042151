import java.util.ArrayList;
import java.util.List;

public class FacebookApi {

    public List<Notification> getAllNotifications() {

        List<Notification> notifications= new ArrayList<Notification>();
        notifications.add(new Notification(1, false, "You have a new friend suggestion", "Facebook"));
        notifications.add(new Notification(2, false, "Pajeet baba posted a new picture", "Facebook"));

        return notifications;
    }

    public void markAsRead(int id) {
        System.out.println("Marking notification with id " + id + " as read");
    }

    public void markAsUnread(int id) {
        System.out.println("Marking notification with id " + id + " as unread");
    }

    public void deleteNotification(int id) {
        System.out.println("Deleting notification with id " + id);
    }
}
