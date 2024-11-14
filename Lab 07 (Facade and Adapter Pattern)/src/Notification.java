public class Notification {

    public int Id;
    public boolean isRead;

    public String message;

    public String platform;

    public Notification(int id, boolean isRead, String message, String platform) {
        Id = id;
        this.isRead = isRead;
        this.message = message;
        this.platform = platform;
    }
}
