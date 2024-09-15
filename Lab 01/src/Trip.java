public class Trip {
    private int id;
    private String pickupLocation;
    private String dropLocation;
    private VehicleType vehicleType;
    private String status;
    private double fare;
    private double distance;

    public Trip(int id, String pickupLocation, String dropLocation, VehicleType vehicleType, String status, double fare, double distance) {
        this.id = id;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.vehicleType = vehicleType;
        this.status = status;
        this.fare = fare;
        this.distance = distance;
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



    public void calculateFare()
    {
        //calculate fare based on distance and vehicle type
    }

    public void assignDriver()
    {
        //assign driver to the trip
    }

    public void startTrip()
    {
        //start the trip and use notification service
    }


}
