package workbook5.vehicle;

public class Moped extends Vehicle {

    private boolean hasBasket;


    public Moped(String color,
               int numberOfPassengers,
               int cargoCapacity,
               int fuelCapacity,
               boolean hasBasket) {

        super("Moped: ", color, numberOfPassengers, cargoCapacity, fuelCapacity);

        this.hasBasket = hasBasket;
    }
    public boolean isHasBasket() {
        return hasBasket;
    }
    public void setHasBasket(boolean hasBasket) {
        this.hasBasket = hasBasket;
    }

    public void honkHorn () {
        System.out.println("Meep Meep!");
    }
}

