public class Driver {
    private int id;
    private String name;
    private String location;
    private double rating;
    private VehicleType VehicleType;

    private boolean availability;

    private double totalBalance;

    private NotificationService notificationService;

    public Driver(int id, String name, String location, double rating, VehicleType vehicleType, double totalBalance, NotificationService notificationService) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.rating = rating;
        VehicleType = vehicleType;
        this.availability = true;
        this.totalBalance = totalBalance;
        this.notificationService = notificationService;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public VehicleType getVehicleType() {
        return VehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        VehicleType = vehicleType;
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public double getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(double totalBalance) {
        this.totalBalance = totalBalance;
    }

    public void acceptRide()
    {

    }
    public void rateDriver()
    {

    }
    public void updateLocation(String location)
    {

    }
    public void startTrip()
    {

    }
}
