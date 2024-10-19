import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TripHandler {

    private int tripID = 1;
    public List<Trip> activeTrips=new ArrayList<>();

    public List<Trip>completedTrips=new ArrayList<>();

    private List<Driver> drivers = new ArrayList<>();
    private NotificationSender notificationSender = new NotificationSender();
    private PaymentProcessor paymentProcessor = new PaymentProcessor();
    private Random random = new Random(); // As there is no way to calculate the distance form given location, I am using random distance

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    public void requestRide(Rider rider, String pickupLocation, String dropLocation, VehicleType vehicleType) {
        System.out.println("Rider " + rider.getName() + " is requesting a ride from " + pickupLocation + " to " + dropLocation);
        double distance = random.nextInt(20) + 1; // Generate a random distance between 1 and 20 km
        double fare = vehicleType.calculateFare(distance, 1);
        System.out.println("Estimated fare: $" + fare);

        if (rider.getAvailableBalance() < fare) {
            System.out.println("Insufficient balance to book this trip.");
            return;
        }

        Driver assignedDriver = findAvailableDriver(vehicleType);
        if (assignedDriver == null) {
            System.out.println("No available drivers found.");
            return;
        }

        // Create a new trip
        Trip trip = new Trip(tripID, pickupLocation, dropLocation, vehicleType, "Starting", fare, distance, rider);
        tripID++;

        // Assign the driver to the trip
        assignDriverToTrip(trip, assignedDriver);

        // Notify rider and driver
        notificationSender.sendNotification(rider.getPreferredNotificationService(), "Ride request confirmed! Driver is on the way.");
        notificationSender.sendNotification(assignedDriver.getNotificationService(), "New trip assigned. Pickup location: " + pickupLocation);

        // Let the driver accept the ride and start the trip
        assignedDriver.acceptRide();
        startTrip(trip, assignedDriver);
    }




    private Driver findAvailableDriver(VehicleType vehicleType) {
        for (Driver driver : drivers) {
            System.out.println("Checking driver: " + driver.getName() + ", Availability: " + driver.getAvailability() + ", Vehicle: " + driver.getVehicleType());
            if (driver.getAvailability() && driver.getVehicleType().getClass().equals(vehicleType.getClass())) {
                driver.setAvailability(false);
                return driver;
            }
        }
        return null;
    }

    public void startTrip(Trip trip, Driver driver) {
        // Mark the trip as "In Progress"
        trip.setStatus("In Progress");

        // Notify the rider
        trip.getRider().getPreferredNotificationService().sendNotification("Your trip has started!");

        // Move the trip to active trips
        activeTrips.add(trip);

        // Any other logic like tracking the trip
        System.out.println("Trip started by driver: " + driver.getName() + " from " + trip.getPickupLocation());
    }

    public void completeTrip(Trip trip, Driver driver, Rider rider) {
        // Mark the trip as "Completed"
        trip.setStatus("Completed");

        // Make the rider pay the fare
        rider.makePayment(trip.getFare());

        // Notify both rider and driver
        rider.getPreferredNotificationService().sendNotification("Trip completed! Thank you for riding.");
        driver.getNotificationService().sendNotification("Trip completed. Fare: " + trip.getFare());

        // Remove the trip from active trips and add it to completed trips
        activeTrips.remove(trip);
        completedTrips.add(trip);

        System.out.println("Trip completed by driver: " + driver.getName() + " to " + trip.getDropLocation());
        driver.setAvailability(true);
    }

    public void assignDriverToTrip(Trip trip, Driver driver) {
        trip.assignDriver(driver);
        System.out.println("Driver " + driver.getName() + " has been assigned to trip.");
    }

    public void viewTripHistory() {
        for (Trip trip : activeTrips) {
            System.out.println("Trip ID: " + trip.getId() + ", Status: " + trip.getStatus() + ", Fare: $" + trip.getFare());
        }
        for(Trip trip:completedTrips)
        {
            System.out.println("Trip ID: " + trip.getId() + ", Status: " + trip.getStatus() + ", Fare: $" + trip.getFare());
        }
    }

}
