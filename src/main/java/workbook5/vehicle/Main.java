package workbook5.vehicle;

public class Main {

    public static void main(String[] args) {
        Car car = new Car("Blue", 5,
                500, 15, 4);

        Moped moped = new Moped( "Red", 1,
                20, 2, true);

        SemiTruck semiTruck = new SemiTruck("White", 2,

        Hovercraft hovercraft = new Hovercraft("Yellow", 20,
                5000, 100,true);

            System.out.println("===== CAR =====");
            System.out.println("Type: " + car.getTransportType());
            System.out.println("Color: " + car.getColor());
            System.out.println("Passengers: " + car.getNumberOfPassengers());
            System.out.println("Cargo Capacity: " + car.getCargoCapacity());
            System.out.println("Fuel Capacity: " + car.getFuelCapacity());
            System.out.println("Doors: " + car.getNumberOfDoors());
            car.honkHorn();

            System.out.println("\n===== MOPED =====");
            System.out.println("Type: " + moped.getTransportType());
            System.out.println("Color: " + moped.getColor());
            System.out.println("Passengers: " + moped.getNumberOfPassengers());
            System.out.println("Cargo Capacity: " + moped.getCargoCapacity());
            System.out.println("Fuel Capacity: " + moped.getFuelCapacity());
            moped.honkHorn();

            System.out.println("\n===== SEMI TRUCK =====");
            System.out.println("Type: " + semiTruck.getTransportType());
            System.out.println("Color: " + semiTruck.getColor());
            System.out.println("Passengers: " + semiTruck.getNumberOfPassengers());
            System.out.println("Cargo Capacity: " + semiTruck.getCargoCapacity());
            System.out.println("Fuel Capacity: " + semiTruck.getFuelCapacity());
            System.out.println("Trailers: " + semiTruck.getTrailerCount());
            semiTruck.honkHorn();

            System.out.println("\n===== HOVERCRAFT =====");
            System.out.println("Type: " + hovercraft.getTransportType());
            System.out.println("Color: " + hovercraft.getColor());
            System.out.println("Passengers: " + hovercraft.getNumberOfPassengers());
            System.out.println("Cargo Capacity: " + hovercraft.getCargoCapacity());
            System.out.println("Fuel Capacity: " + hovercraft.getFuelCapacity());
            System.out.println("Inflated: " + hovercraft.isInflated());
            hovercraft.honkHorn();

    }
}




