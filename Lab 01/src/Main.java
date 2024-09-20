import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Create an instance of TripHandler
        TripHandler tripHandler = new TripHandler();

        // Create Notification services
        INotificationService smsNotification = new SMSNotification();
        INotificationService emailNotification = new EmailNotification();
        INotificationService inAppNotification = new InAppNotification();

        // Create Payment methods
        IPaymentMethod creditCardPayment = new CreditCardPayment();
        IPaymentMethod digitalWalletPayment = new DigitalWalletPayment();
        IPaymentMethod payPalPayment = new PayPalPayment();

        // Create Vehicle types
        VehicleType bikeRide = new BikeRide(5.0);
        VehicleType carpool = new Carpool(10.0);
        VehicleType luxuryRide = new LuxuryRide(20.0);

        // Create Drivers
        Driver driver1 = new Driver(1, "John", "Downtown", 4.9, bikeRide, 0.0, smsNotification);
        Driver driver2 = new Driver(2, "Alice", "Uptown", 4.8, carpool, 0.0, emailNotification);
        Driver driver3 = new Driver(3, "Bob", "Suburbs", 4.7, luxuryRide, 0.0, inAppNotification);

        // Add drivers to trip handler
        tripHandler.addDriver(driver1);
        tripHandler.addDriver(driver2);
        tripHandler.addDriver(driver3);

        // Create Riders
        Rider rider1 = new Rider("R1", "Emily", "Midtown", 4.5, creditCardPayment, 20000.0, inAppNotification);
        Rider rider2 = new Rider("R2", "David", "City Center", 4.7, digitalWalletPayment, 400000.0, emailNotification);

        //Admin manages drivers and riders (testing admin methods)
        Admin admin = new Admin(1, "Admin1", "System Admin");
        List<Driver> drivers = new ArrayList<>();
        drivers.add(driver1);
        admin.manageDriver(drivers, "add", driver2);  // Add a driver
        admin.manageDriver(drivers, "update", new Driver(2, "Alice Updated", "Downtown", 4.9, carpool, 0.0, emailNotification));  // Update driver
        admin.manageDriver(drivers, "remove", driver1);  // Remove driver

        // Request a ride for Rider1
        System.out.println("\n--- Rider1 requests a BikeRide ---");
        rider1.requestRide("Midtown", "City Center", bikeRide);  // Rider1 requests a bike ride

        // Request a ride for Rider2
        System.out.println("\n--- Rider2 requests a Carpool ---");
        rider2.requestRide("Suburbs", "Airport", carpool);  // Rider2 requests a carpool

        // View trip history (active trips)
        System.out.println("\n--- Viewing trip history (Active trips) ---");
        tripHandler.viewTripHistory();

        // Complete the trips
        System.out.println("\n--- Completing trips ---");
        if (!tripHandler.activeTrips.isEmpty()) {
            for (Trip trip : tripHandler.activeTrips) {
                tripHandler.completeTrip(trip, trip.getDriver(), trip.getRider());
            }
        }

        // View trip history again (completed trips)
        System.out.println("\n--- Viewing trip history (Completed trips) ---");
        tripHandler.viewTripHistory();
    }
}