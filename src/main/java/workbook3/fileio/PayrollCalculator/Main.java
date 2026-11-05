package workbook3.fileio.PayrollCalculator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try{
            BufferedReader reader = new BufferedReader(new FileReader("employee.txt"));
                System.out.print("Employee Info:\n");

            String employeeInfo;
            reader.readLine(); // will skip the first line in the note

            while ((employeeInfo = reader.readLine()) != null) { // means while there are lines to read - null = blank
                String[] info = employeeInfo.split("\\|");// going to split the lines by "|"
                int id = Integer.parseInt(info[0]);
                String name = info[1];
                double hoursWorked = Double.parseDouble(info[2]);
                double payRate = Double.parseDouble(info[3]);

                Employee employee = new Employee(id, name, hoursWorked, payRate);


                System.out.printf("%d, %s, %.2f\n", employee.getEmployeeId(),
                         employee.getName(), employee.getGrossPay());
            }
        } catch (IOException e) {
                System.out.println("File not found.");
        }
    }
}
