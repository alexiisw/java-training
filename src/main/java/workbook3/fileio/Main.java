package workbook3.fileio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

        try {
            // create a FileReader object connected to the file
            FileReader fileReader = new FileReader("poem.txt");

            // create a BufferedReader to manage the input stream
            BufferedReader bufReader = new BufferedReader(fileReader);

            String input;

            // read until there is no more data
            while ((input = bufReader.readLine()) != null) {
                System.out.println(input);
            }

            // close the stream and release the resources
            bufReader.close();
        }
        catch (IOException e) {
            // display stack trace if there was an error
         //   e.printStackTrace(); // this finds displays exactly what the exception is
        }
        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a"); // the letter 'a' implements am/pm
        String formattedDate = currentDate.format((fmt));
        System.out.println("Today is: " + formattedDate);

        try {
            // open the file (use new FileWriter("skills.txt", true) to append)
            FileWriter writer = new FileWriter("myReasons_" + currentDate.getDayOfWeek() + "-"
                       + currentDate.getDayOfMonth() + "-" + currentDate.getMonth() + "-"
                       + currentDate.getYear() + ".txt");
            // write to the file
            writer.write("My 3 reasons for becoming a developer:\n");
            writer.write("1. creating applications and systems that make people's lives easier\n");
            writer.write("2. to be financially stable enough to support me and retire my mom to take her to travel\n");
            writer.write("3. I enjoy solving puzzles and fixing broken things\n");

            // close the file when you are finished using it
            writer.close();
        }
        catch (IOException e) {
            System.out.println("ERROR: An unexpected error occurred");
          //  e.printStackTrace(); // finds the exact exception needed
        }
    }
}
