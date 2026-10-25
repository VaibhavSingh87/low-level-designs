package parking_lot;

public class ParkingSpot {
    private String spotId;
    private VehicleSize spotSize;
    private boolean isOccupied;
    private Vehicle parkedVehicle;

    public String getSpotId(){
        return spotId;
    }

    public VehicleSize getSpotSize(){
        return spotSize;
    }

    public String isAvailable(){
        return this.isOccupied ? "Spot Available." : "Spot Unavailable";
    }

    public boolean canFitVehicle(Vehicle vehicle){
        return false;
    }

    public void parkVehicle(Vehicle vehicle){
        this.parkedVehicle = vehicle;
        this.isOccupied = true;
    }

    public void unParkVehicle(){
        this.parkedVehicle = null;
        this.isOccupied = false;
    }
}
