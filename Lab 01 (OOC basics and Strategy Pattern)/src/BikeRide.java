public class BikeRide extends VehicleType{

    private double baseFare;

    public BikeRide(double baseFare) {
        this.baseFare = baseFare;
    }

    @Override
    public double calculateFare(double distance,int passenger) {
        return (this.baseFare + distance * 10.00);
    }
}
