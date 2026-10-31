package parking_lot;

import javax.xml.transform.Source;
import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ParkingLotSystem parkingLotSystem = ParkingLotSystem.getInstance();

        parkingLotSystem.setParkingStrategy(new NearestFirstParkingStrategy());
        parkingLotSystem.setFeeStrategy(new VehicleBasedFeeStrategy());

        ParkingFloor floor = new ParkingFloor();
        for(int i=0;i<5;i++){
            floor.addSpot(new ParkingSpot(String.valueOf(i), VehicleSize.SMALL));
        }

        parkingLotSystem.addFloor(floor);

        System.out.println("Current Availability: ");
        floor.displayAvailability();

        ParkingTicket ticket = parkingLotSystem.parkVehicle(new Bike());

        System.out.println("Availability after Parking Vehicle: ");
        floor.displayAvailability();

        Thread.sleep(5000);

        System.out.println("Cost of parking = " + parkingLotSystem.unparkVehicle(ticket.getTicketId()));

        System.out.println("Availability after unparking Vehicle: ");
        floor.displayAvailability();
    }
}
class Bike extends Vehicle {
    private final VehicleSize VEHICLE_SIZE = VehicleSize.SMALL;
    private final String numberPlate = "JH-05-2213";
    @Override
    public VehicleSize getVehicleSize() {
        return VEHICLE_SIZE;
    }
}

