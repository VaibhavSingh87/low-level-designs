package parking_lot;

public class ParkingSpot {
    private String spotId;
    private VehicleSize spotSize;
    private boolean isOccupied;
    private Vehicle parkedVehicle;

    public ParkingSpot(String spotId, VehicleSize spotSize){
        this.spotId = spotId;
        this.spotSize = spotSize;
        isOccupied = false;
        parkedVehicle = null;
    }

    public String getSpotId(){
        return spotId;
    }

    public VehicleSize getSpotSize(){
        return spotSize;
    }

    public boolean isAvailable(){
        return !this.isOccupied;
    }

    public boolean canFitVehicle(Vehicle vehicle){
        VehicleSize size = vehicle.getVehicleSize();
        return size == spotSize;
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
