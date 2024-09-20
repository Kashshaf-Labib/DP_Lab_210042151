public class Driver {
    private int id;
    private String name;
    private String location;
    private double rating;
    private VehicleType VehicleType;

    private boolean availability;

    private double totalBalance;

    private INotificationService notificationService;

    public Driver(int id, String name, String location, double rating, VehicleType vehicleType, double totalBalance, INotificationService notificationService) {
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

    public INotificationService getNotificationService() {
        return notificationService;
    }

    public boolean getAvailability() {
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
        this.availability = false;
        System.out.println("Ride accepted by driver: " + this.name);
    }
    public void rateRider(double rating, Rider rider)
    {
        rider.setRating((rider.getRating()+rating)/2);
    }

    public void updateLocation(String location)
    {
        this.location = location;
    }
    public void startTrip(Trip trip, TripHandler tripHandler) {
        if (!this.availability) {
            this.notificationService.sendNotification("Starting trip from: " + trip.getPickupLocation());
            this.availability = false;

            // Delegate the trip state update to TripHandler
            tripHandler.startTrip(trip, this);  // Pass the driver to TripHandler
        }
    }

    public void completeTrip(Trip trip, TripHandler tripHandler, Rider rider) {
        this.notificationService.sendNotification("Completing trip to: " + trip.getDropLocation());
        this.availability = true;

        // Add the trip fare to driver's balance
        this.totalBalance += trip.getFare();

        // Delegate trip completion logic to TripHandler
        tripHandler.completeTrip(trip, this, rider);  // Pass the driver and rider to TripHandler
    }
}
