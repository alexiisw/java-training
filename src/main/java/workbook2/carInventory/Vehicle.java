package workbook2.carInventory;

public class Vehicle {
    private long id;
    private String makeModel;
    private String color;
    private int odometerReading;
    private double price;

    public Vehicle(long id, String makeModel, String color, int odometerReading, double price) {
        this.id = id;
        this.makeModel = makeModel;
        this.color = color;
        this.odometerReading = odometerReading;
        this.price = price;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getMakeModel() {
        return makeModel;
    }
    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getOdometerReading() {
        return odometerReading;
    }
    public void setOdometerReading(int odometerReading) {
        this.odometerReading = odometerReading;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() { // default structure; can adjust return line to String.format() as well ; printf() for reference
        return "Vehicle{" +
                "id=" + id +
                ", makeModel='" + makeModel + '\'' +
                ", color='" + color + '\'' +
                ", odometerReading=" + odometerReading +
                ", price=" + price +
                '}';
    }
}
