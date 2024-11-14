import java.util.List;

public interface ISocialMediaAdapter {

    public List<Notification> getAllNotifications();

    public String getPlatform();

    public void markAsRead(int id);

    public void markAsUnread(int id);

    public void deleteNotification(int id);
}
