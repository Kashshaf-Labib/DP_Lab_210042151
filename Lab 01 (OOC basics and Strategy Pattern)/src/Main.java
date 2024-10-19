import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        TripHandler tripHandler = new TripHandler();

        INotificationService smsNotification = new SMSNotification();
        INotificationService emailNotification = new EmailNotification();
        INotificationService inAppNotification = new InAppNotification();


        IPaymentMethod creditCardPayment = new CreditCardPayment();
        IPaymentMethod digitalWalletPayment = new DigitalWalletPayment();
        IPaymentMethod payPalPayment = new PayPalPayment();

        VehicleType bikeRide = new BikeRide(5.0);
        VehicleType carpool = new Carpool(10.0);
        VehicleType luxuryRide = new LuxuryRide(20.0);

        Driver driver1 = new Driver(1, "John", "Downtown", 4.9, bikeRide, 0.0, smsNotification);
        Driver driver2 = new Driver(2, "Alice", "Uptown", 4.8, carpool, 0.0, emailNotification);
        Driver driver3 = new Driver(3, "Bob", "Suburbs", 4.7, luxuryRide, 0.0, inAppNotification);

        tripHandler.addDriver(driver1);
        tripHandler.addDriver(driver2);
        tripHandler.addDriver(driver3);


        Rider rider1 = new Rider("R1", "Emily", "Midtown", 4.5, creditCardPayment, 20000.0, inAppNotification);
        Rider rider2 = new Rider("R2", "David", "City Center", 4.7, digitalWalletPayment, 400000.0, emailNotification);


        Admin admin = new Admin(1, "Admin1", "System Admin");
//        List<Driver> drivers = new ArrayList<>();
//        drivers.add(driver1);
//        drivers.add(driver2);
//        drivers.add(driver3);

//        admin.manageDriver(drivers, "add", driver2);
//        admin.manageDriver(drivers, "update", new Driver(2, "Alice Updated", "Downtown", 4.9, carpool, 0.0, emailNotification));  // Update driver
//        admin.manageDriver(drivers, "remove", driver1);


        System.out.println("\n--- Rider1 requests a BikeRide ---");
        rider1.requestRide("Midtown", "City Center", bikeRide);  // Rider1 requests a bike ride


        System.out.println("\n--- Rider2 requests a Carpool ---");
        rider2.requestRide("Suburbs", "Airport", carpool);  // Rider2 requests a carpool

        System.out.println("\n--- Viewing trip history (Active trips) ---");
        tripHandler.viewTripHistory();


        System.out.println("\n--- Completing trips ---");
        if (!tripHandler.activeTrips.isEmpty()) {
            for (Trip trip : tripHandler.activeTrips) {
                tripHandler.completeTrip(trip, trip.getDriver(), trip.getRider());
            }
        }

        System.out.println("\n--- Viewing trip history (Completed trips) ---");
        tripHandler.viewTripHistory();
    }
}