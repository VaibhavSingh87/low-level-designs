package parking_lot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingFloor {
    private int floor;
    private final HashMap<String, ParkingSpot> spots = new HashMap<>();

    public List<ParkingSpot> findAvailableSpots(Vehicle vehicle){
        VehicleSize size = vehicle.getVehicleSize();
        List<ParkingSpot> availableSpots = new ArrayList<>();
        for(ParkingSpot parkingSpot : spots.values()){
            if(parkingSpot.canFitVehicle(vehicle) && parkingSpot.isAvailable()){
                availableSpots.add(parkingSpot);
            }
        }
        return availableSpots;
    }

    public void addSpot(ParkingSpot parkingSpot){
        spots.put(parkingSpot.getSpotId(), parkingSpot);
    }

    public void displayAvailability(){
        for(ParkingSpot parkingSpot : spots.values()){
            System.out.println(parkingSpot.getSpotId() + " " + (parkingSpot.isAvailable() ? "Available" : "Unavailable"));
        }
    }
}
