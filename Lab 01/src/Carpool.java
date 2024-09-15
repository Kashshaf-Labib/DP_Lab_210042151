public class Carpool extends VehicleType {

    private double baseFare;

    public Carpool(double baseFare) {
        this.baseFare = baseFare;
    }

    @Override
    public double calculateFare(double distance, int passenger) {
        return (this.baseFare + distance * 20.00)/passenger;
    }

}
