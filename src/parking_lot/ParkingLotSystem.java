package parking_lot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class ParkingLotSystem {
    private List<ParkingFloor> floors;
    private HashMap<String, ParkingTicket> activeTickets;
    private ParkingStrategy parkingStrategy;
    private FeeStrategy feeStrategy;

    private static ParkingLotSystem parkingLotSystem;

    private ParkingLotSystem(){
        floors = new ArrayList<>();
        activeTickets = new HashMap<>();
        feeStrategy = new VehicleBasedFeeStrategy();
        parkingStrategy = new NearestFirstParkingStrategy();
    }

    public static synchronized ParkingLotSystem getInstance(){
           if(parkingLotSystem == null){
               parkingLotSystem = new ParkingLotSystem();
           }
           return parkingLotSystem;
    }

    public void setParkingStrategy(ParkingStrategy parkingStrategy){
        this.parkingStrategy = parkingStrategy;
    }

    public void setFeeStrategy(FeeStrategy feeStrategy){
        this.feeStrategy = feeStrategy;
    }

    public void addFloor(ParkingFloor parkingFloor){
        floors.add(parkingFloor);
    }

    public ParkingTicket parkVehicle(Vehicle vehicle){
        ParkingTicket ticket = parkingStrategy.park(floors, vehicle);
        activeTickets.put(ticket.getTicketId(),ticket);
        return ticket;
    }

    public double unparkVehicle(String ticketId){
        ParkingTicket ticket = activeTickets.get(ticketId);
        double amount = feeStrategy.calculateFee(ticket);
        activeTickets.remove(ticketId);
        return amount;
    }
}
