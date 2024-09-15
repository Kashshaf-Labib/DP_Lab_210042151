import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TripHandler {

    private int tripID = 1;
    public List<Trip> trips = new ArrayList<>();
    private List<Driver> drivers = new ArrayList<>();
    private NotificationSender notificationSender = new NotificationSender();
    private PaymentProcessor paymentProcessor = new PaymentProcessor();
    private Random random = new Random();

    // Add available drivers to the system
    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    // Rider requests a ride
    public void requestRide(Rider rider, String pickupLocation, String dropLocation, VehicleType vehicleType) {
        double distance = random.nextInt(20) + 1; // Generate a random distance between 1 and 20 km
        double fare = vehicleType.calculateFare(distance, 1);

        // Check if rider has enough balance
        if (rider.getAvailableBalance() < fare) {
            System.out.println("Insufficient balance to book this trip.");
            return;
        }

        // Find an available driver
        Driver assignedDriver = findAvailableDriver(vehicleType);
        if (assignedDriver == null) {
            System.out.println("No available drivers found.");
            return;
        }

        // Create a new trip and notify both rider and driver
        Trip trip = new Trip(tripID, pickupLocation, dropLocation, vehicleType, "Pending", fare, distance);
        trips.add(trip);
        tripID++;

        // Notify rider and driver
        notificationSender.sendNotification(rider.getPreferredNotificationService(), "Ride request confirmed! Driver is on the way.");
        notificationSender.sendNotification(assignedDriver.getNotificationService(), "New trip assigned. Pickup location: " + pickupLocation);

        // Start the trip after assigning driver
        startTrip(trip, rider, assignedDriver);
    }

    private Driver findAvailableDriver(VehicleType vehicleType) {
        for (Driver driver : drivers) {
            if (driver.isAvailable() && driver.getVehicleType().getClass().equals(vehicleType.getClass())) {
                driver.setAvailable(false); // Mark driver as unavailable
                return driver;
            }
        }
        return null;
    }

    private void startTrip(Trip trip, Rider rider, Driver driver) {
        trip.setStatus("Ongoing");
        notificationSender.sendNotification(rider.getPreferredNotificationService(), "Driver has arrived! Starting the trip.");
        notificationSender.sendNotification(driver.getNotificationService(), "Trip started. Heading to " + trip.getDropLocation());

        completeTrip(trip, rider, driver);
    }

    private void completeTrip(Trip trip, Rider rider, Driver driver) {
        trip.setStatus("Completed");

        // Process payment
        paymentProcessor.processPayment(trip.getFare(), rider.getPreferredPaymentMethod());

        // Update driver's balance
        driver.setTotalBalance(driver.getTotalBalance() + trip.getFare());

        // Notify rider and driver
        notificationSender.sendNotification(rider.getPreferredNotificationService(), "Trip completed. Payment processed.");
        notificationSender.sendNotification(driver.getNotificationService(), "Trip completed. You've earned $" + trip.getFare());

        // Set driver as available again
        driver.setAvailable(true);
    }

    // Optional: Admin can view trip history
    public void viewTripHistory() {
        for (Trip trip : trips) {
            System.out.println("Trip ID: " + trip.getId() + ", Status: " + trip.getStatus() + ", Fare: $" + trip.getFare());
        }
    }




}
