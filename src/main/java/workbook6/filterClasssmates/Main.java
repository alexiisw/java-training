package workbook6.filterClasssmates;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        //Exercise: Filter your classmates given the following list:

        List<String> names = List.of(
                "Fana", "Jack", "Thuan", "Jofre", "Ronell",
                "Sama", "Alexis", "Hassieb", "Leo",
                "Michael", "Andres", "Zurik", "Shawn"
        );
        //Task: Use stream() and filter() to print only the names that contain more than five characters.
        //            Hint: Use name.length() to determine the length of a name.

        names.stream() //starts processing the elements in the list
                .filter(name -> name.length() > 5) //tells Java to check whether each name's length is greater than five
                                    // (name) - current name being checked; (->) introduces the expression;
                .forEach(name -> System.out.println(name)); // prints the results
    }
}