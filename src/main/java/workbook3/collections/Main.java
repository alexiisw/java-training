package workbook3.collections;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // the key is the state, the value is its capital
        HashMap<String, String> statesAndCapitals = new HashMap<String, String>();

        statesAndCapitals.put("CT", "Hartford");
        statesAndCapitals.put("CA", "Sacramento");
        statesAndCapitals.put("WA", "Olympia");
        statesAndCapitals.put("TX", "Austin");
        statesAndCapitals.put("FL", "Tallahassee");
        System.out.println(statesAndCapitals);

        // look up a value by its key
        System.out.println("The capital of Texas is: " + statesAndCapitals.get("TX"));

        // a failed lookup returns null, so check before you use it
        String value = statesAndCapitals.get("OK");
        if (value != null) {
            System.out.println(value);
        } else {
            System.out.println("OK is not in the states map");
        }

        // remove an item by its key
        statesAndCapitals.remove("WA");

        // loop over the keys
        for (String key : statesAndCapitals.keySet()) {
            System.out.println(key + ": " + statesAndCapitals.get(key));
        }
    }
}


