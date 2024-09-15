import java.util.List;
import java.util.Iterator;

public class Admin {
    private int id;
    private String name;
    private String role;

    public Admin(int id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Manage drivers: Add, remove, update driver information
    public void manageDriver(List<Driver> drivers, String action, Driver driver) {
        switch(action.toLowerCase()) {
            case "add":
                drivers.add(driver);
                System.out.println("Driver added: " + driver.getName());
                break;

            case "remove":
                Iterator<Driver> iterator = drivers.iterator();
                while (iterator.hasNext()) {
                    Driver d = iterator.next();
                    if (d.getId() == driver.getId()) {
                        iterator.remove();
                        System.out.println("Driver removed: " + d.getName());
                        return;
                    }
                }
                System.out.println("Driver not found.");
                break;

            case "update":
                for (Driver d : drivers) {
                    if (d.getId() == driver.getId()) {
                        d.setName(driver.getName());
                        d.setLocation(driver.getLocation());
                        d.setRating(driver.getRating());
                        d.setVehicleType(driver.getVehicleType());
                        System.out.println("Driver updated: " + d.getName());
                        return;
                    }
                }
                System.out.println("Driver not found.");
                break;

            default:
                System.out.println("Invalid action. Use 'add', 'remove', or 'update'.");
                break;
        }
    }

    // Manage riders: Add, remove, update rider information
    public void manageRider(List<Rider> riders, String action, Rider rider) {
        switch(action.toLowerCase()) {
            case "add":
                riders.add(rider);
                System.out.println("Rider added: " + rider.getName());
                break;

            case "remove":
                Iterator<Rider> iterator = riders.iterator();
                while (iterator.hasNext()) {
                    Rider r = iterator.next();
                    if (r.getId().equals(rider.getId())) {
                        iterator.remove();
                        System.out.println("Rider removed: " + r.getName());
                        return;
                    }
                }
                System.out.println("Rider not found.");
                break;

            case "update":
                for (Rider r : riders) {
                    if (r.getId().equals(rider.getId())) {
                        r.setName(rider.getName());
                        r.setLocation(rider.getLocation());
                        r.setRating(rider.getRating());
                        r.setPreferredPaymentMethod(rider.getPreferredPaymentMethod());
                        System.out.println("Rider updated: " + r.getName());
                        return;
                    }
                }
                System.out.println("Rider not found.");
                break;

            default:
                System.out.println("Invalid action. Use 'add', 'remove', or 'update'.");
                break;
        }
    }

    // View trip history: Show all completed trips
    public void viewTripHistory(List<Trip> completedTrips) {
        if (completedTrips.isEmpty()) {
            System.out.println("No trips completed yet.");
            return;
        }

        System.out.println("Completed Trip History:");
        for (Trip trip : completedTrips) {
            System.out.println("Trip ID: " + trip.getId() + ", Pickup: " + trip.getPickupLocation() +
                    ", Drop: " + trip.getDropLocation() + ", Fare: $" + trip.getFare() +
                    ", Status: " + trip.getStatus());
        }
    }
}

