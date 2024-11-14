import java.util.List;

public class TwitterAdapter implements ISocialMediaAdapter{

        private TwitterApi twitterApi;

        public TwitterAdapter() {
            this.twitterApi = new TwitterApi();
        }

        @Override
        public List<Notification> getAllNotifications() {
            return twitterApi.getAllNotifications();
        }

        @Override
        public String getPlatform() {
            return "Twitter";
        }

        @Override
        public void markAsRead(int id) {
            twitterApi.markAsRead(id);
        }

        @Override
        public void markAsUnread(int id) {
            twitterApi.markAsUnread(id);
        }

        @Override
        public void deleteNotification(int id) {
            twitterApi.deleteNotification(id);
        }
}
