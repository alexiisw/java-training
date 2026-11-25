package workbook4.testExample;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class HelperTest {


    @Test
    public void fullName() {

        //arrange
        String firstName = "Thuan";
        String lastName = "Luu";
        String expectedFullName ="Thuan Luu";

        //act
       String result = Helper.fullName(firstName, lastName);

        //assert
        assertEquals(expectedFullName, result);
    }
}

