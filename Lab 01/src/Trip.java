public class Trip {
    private int id;
    private String pickupLocation;
    private String dropLocation;
    private VehicleType vehicleType;
    private String status;
    private double fare;
    private double distance;

    private Driver driver;
    private Rider rider;

    public Trip(int id, String pickupLocation, String dropLocation, VehicleType vehicleType, String status, double fare, double distance, Rider rider) {
        this.id = id;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.vehicleType = vehicleType;
        this.status = status;
        this.fare = fare;
        this.distance = distance;
        this.rider = rider;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Rider getRider() {
        return rider;
    }

    public void assignDriver(Driver driver) {
        this.driver = driver;
        this.status = "Driver Assigned";
        driver.getNotificationService().sendNotification("You have been assigned to a trip from " + this.pickupLocation);
    }

}
