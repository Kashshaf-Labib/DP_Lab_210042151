public class LuxuryRide extends VehicleType{
    private double baseFare;

    public LuxuryRide(double baseFare) {
        this.baseFare = baseFare;
    }

    @Override
    public double calculateFare(double distance,int passenger) {
        return (this.baseFare + distance * 50.00)*passenger;
    }
}
