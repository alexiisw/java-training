package workbook4.testExample;

public class Helper {
    static String fullName(String firstName, String lastName){
        return firstName + "" + lastName;
    }

    static String cleanFullName(String firstName, String lastName){
        return firstName.toUpperCase() + " " + lastName.toUpperCase();
    }
}
