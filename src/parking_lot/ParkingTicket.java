package parking_lot;

import java.time.LocalTime;
import java.util.Date;

public class ParkingTicket {
    private ParkingSpot spot;
    private String ticketId;
    private LocalTime entryTime;
    private LocalTime exitTime;
    private Vehicle vehicle;

    public ParkingTicket(Vehicle vehicle, LocalTime entryTime, ParkingSpot spot){
        this.spot = spot;
        this.vehicle = vehicle;
        this.entryTime = entryTime;
        this.ticketId = spot.getSpotId();
    }

    public void setExitTime(LocalTime exitTime) {
        this.exitTime = exitTime;
    }

    public String getTicketId() {
        return ticketId;
    }

    public LocalTime getEntryTime() {
        return entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getSpot(){
        return spot;
    }
}
