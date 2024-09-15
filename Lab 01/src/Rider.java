public class Rider {
    private String id;
    private String name;
    private String location;
    private double rating;
    private PaymentMethod preferredPaymentMethod;

    private double availableBalance;

    private NotificationService notificationService;

    public Rider(String id, String name, String location, double rating, PaymentMethod preferredPaymentMethod, double availableBalance, NotificationService notificationService) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.rating = rating;
        this.preferredPaymentMethod = preferredPaymentMethod;
        this.availableBalance = availableBalance;
        this.notificationService = notificationService;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public PaymentMethod getPreferredPaymentMethod() {
        return preferredPaymentMethod;
    }

    public void setPreferredPaymentMethod(PaymentMethod preferredPaymentMethod) {
        this.preferredPaymentMethod = preferredPaymentMethod;
    }

    public NotificationService getPreferredNotificationService() { return notificationService; }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }

    public void requestRide(String pickUpLocation, String dropLocation, VehicleType vehicleType)
    {
        TripHandler tripHandler = new TripHandler();
        tripHandler.requestRide(this, pickUpLocation, dropLocation, vehicleType);
    }

    public void rateDriver(double rating, Driver driver)
    {
        driver.setRating((driver.getRating()+rating)/2);
    }
    public void makePayment(double amount)
    {
        availableBalance -= amount;
    }
}
