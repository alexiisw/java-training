package workbook4;

public class Person {
    private String name;

    public static String introText = "Person info";

    private Person(String name){
        this.name = name;

    }
    public boolean completeCapstone(){
        return true;
    }
    public static void genericInfoAboutHuman(){
        System.out.println("There are more than 8 billion people on planet Earth");
    }
}
