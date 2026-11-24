interface ParkingCharge {
    double calculateCharge();

    void displayParkingDetails();
}

class VehicleParking {
    private final String vehicleNumber;
    private final String vehicleType;
    private final int parkingHours;

    protected VehicleParking(String vehicleNumber, String vehicleType, int parkingHours) {
        if (parkingHours < 0) {
            throw new IllegalArgumentException("Parking hours cannot be negative.");
        }
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.parkingHours = parkingHours;
    }

    public int getParkingHours() {
        return parkingHours;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }
}

class TwoWheeler extends VehicleParking implements ParkingCharge {
    public TwoWheeler(String vehicleNumber, int parkingHours) {
        super(vehicleNumber, "Two Wheeler", parkingHours);
    }

    @Override
    public double calculateCharge() {
        int hours = getParkingHours();
        return hours <= 2 ? hours * 20.0 : 2 * 20.0 + (hours - 2) * 10.0;
    }

    @Override
    public void displayParkingDetails() {
        ParkingDisplay.display(this, calculateCharge());
    }
}

class FourWheeler extends VehicleParking implements ParkingCharge {
    public FourWheeler(String vehicleNumber, int parkingHours) {
        super(vehicleNumber, "Four Wheeler", parkingHours);
    }

    @Override
    public double calculateCharge() {
        int hours = getParkingHours();
        return hours <= 2 ? hours * 50.0 : 2 * 50.0 + (hours - 2) * 30.0;
    }

    @Override
    public void displayParkingDetails() {
        ParkingDisplay.display(this, calculateCharge());
    }
}

class ParkingDisplay {
    private ParkingDisplay() {
    }

    public static void display(VehicleParking vehicle, double charge) {
        System.out.printf("Vehicle Number: %s%nVehicle Type: %s%nParking Hours: %d%n"
                        + "Parking Charge: Rs. %.2f%n",
                vehicle.getVehicleNumber(), vehicle.getVehicleType(),
                vehicle.getParkingHours(),
                charge);
    }
}

public class ParkingDemo {
    public static void main(String[] args) {
        ParkingCharge[] vehicles = {
                new TwoWheeler("KA01AB1234", 3),
                new FourWheeler("KA02CD5678", 4)
        };

        for (ParkingCharge vehicle : vehicles) {
            vehicle.displayParkingDetails();
            System.out.println();
        }
    }
}
