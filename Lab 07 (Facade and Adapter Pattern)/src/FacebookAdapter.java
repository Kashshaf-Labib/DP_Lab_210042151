import java.util.List;

public class FacebookAdapter implements ISocialMediaAdapter{

    private FacebookApi facebookApi;

    public FacebookAdapter() {
        this.facebookApi = new FacebookApi();
    }

    @Override
    public List<Notification> getAllNotifications() {
        return facebookApi.getAllNotifications();
    }

    @Override
    public String getPlatform() {
        return "Facebook";
    }

    @Override
    public void markAsRead(int id) {
        facebookApi.markAsRead(id);
    }

    @Override
    public void markAsUnread(int id) {
        facebookApi.markAsUnread(id);
    }

    @Override
    public void deleteNotification(int id) {
        facebookApi.deleteNotification(id);
    }


}
