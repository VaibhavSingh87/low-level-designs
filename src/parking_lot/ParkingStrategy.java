package parking_lot;

import java.util.List;

public interface ParkingStrategy {
    ParkingTicket park(List<ParkingFloor> floors, Vehicle vehicle);
}
