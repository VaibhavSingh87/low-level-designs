package parking_lot;

import java.time.Duration;
import java.time.LocalTime;

public class VehicleBasedFeeStrategy implements FeeStrategy{
    @Override
    public double calculateFee(ParkingTicket ticket) {
        LocalTime entryTime = ticket.getEntryTime();

        LocalTime exitTime = LocalTime.now();
        ticket.setExitTime(exitTime);

        VehicleSize size = ticket.getVehicle().getVehicleSize();
        Duration duration = Duration.between(entryTime, exitTime);

        int totalTime = (int) duration.toSeconds();

        ticket.getSpot().unParkVehicle();

        if(size == VehicleSize.SMALL){
            return totalTime * 50.0;
        }else if(size == VehicleSize.MEDIUM){
            return totalTime * 75.5;
        }else {
            return totalTime * 100.0;
        }
    }
}
