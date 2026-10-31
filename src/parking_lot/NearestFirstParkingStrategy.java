package parking_lot;

import java.time.LocalTime;
import java.util.List;

public class NearestFirstParkingStrategy implements ParkingStrategy{
    @Override
    public ParkingTicket park(List<ParkingFloor> floors, Vehicle vehicle){
        for(ParkingFloor floor : floors){
            List<ParkingSpot> availableSpots = floor.findAvailableSpots(vehicle);
            if(!availableSpots.isEmpty()){
                availableSpots.get(0).parkVehicle(vehicle);
                return new ParkingTicket(vehicle, LocalTime.now(), availableSpots.get(0));
            }
        }
        return null;
    }
}
