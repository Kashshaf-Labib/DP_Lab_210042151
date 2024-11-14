import java.util.ArrayList;
import java.util.List;

public class FacadeAggregator {

    private List<ISocialMediaAdapter> socialMediaAdapters;

    public FacadeAggregator() {
        socialMediaAdapters = List.of(new FacebookAdapter(), new TwitterAdapter());
    }

    public List<Notification> getAllNotifications()
    {
        List<Notification> notifications = new ArrayList<Notification>();
        for (ISocialMediaAdapter adapter : socialMediaAdapters) {
            notifications.addAll(adapter.getAllNotifications());
        }
        return notifications;
    }

    public void markAsRead(String platform, int id)
    {
        for (ISocialMediaAdapter adapter : socialMediaAdapters) {
            if (adapter.getPlatform().equals(platform)) {
                adapter.markAsRead(id);
                break;
            }
        }
    }

    public void markAsUnread(String platform, int id)
    {
        for (ISocialMediaAdapter adapter : socialMediaAdapters) {
            if (adapter.getPlatform().equals(platform)) {
                adapter.markAsUnread(id);
                break;
            }
        }
    }

    public void deleteNotification(String platform, int id)
    {
        for (ISocialMediaAdapter adapter : socialMediaAdapters) {
            if (adapter.getPlatform().equals(platform)) {
                adapter.deleteNotification(id);
                break;
            }
        }
    }
}
