package workbook3.fileio.PayrollCalculator;


public class Employee {

    private int id;
    private String name;
    private double hoursWorked;
    private double payRate;

        // Constructor - stores values
    public Employee (int id,
                     String name,
                     double hoursWorked,
                     double payRate){
        this.id = id;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }
        //Methods - returns stored values
    //Getters
    public int getEmployeeId() { // displays employee info
        return id;
    }public String getName() { // displays employee info
        return name;
    } public double getHoursWorked() { // displays employee info
        return hoursWorked;
    } public double getPayRate() { // displays employee info
        return payRate;
    }public double getGrossPay() { // calculates the gross pay
        return hoursWorked * payRate;
    }
}
