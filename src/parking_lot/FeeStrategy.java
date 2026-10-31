package parking_lot;

public interface FeeStrategy {
    double calculateFee(ParkingTicket ticket);
}
