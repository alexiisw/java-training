package workbook2.palindrome;

public class Main {
    public static void main(String[] args) {

        int largestPalindrome = 0;

        for (int i = 100; i <= 999; i++) {
            for (int j = 100; j <= 999; j++) { // for every value of i, j will count from 100-999

                int product = i * j; // example: 100 × 100; 100 × 101; 100 × 102; etc; 100 × 999; 101 × 100; 101 × 101; etc


                String original = String.valueOf(product); // converts number into text

                String reversed = new StringBuilder(original) // creates a reversed version of the string and stores it
                        .reverse() // reverses the characters
                        .toString(); // converts it back to a string

            // TODO: Check whether original and reversed are equal
                if(original.equals(reversed)) { // checks whether the original string and reversed string match
                    System.out.println("Palindrome found: " + product);

                // TODO: If it is a palindrome and larger than the
                // current largestPalindrome, update largestPalindrome
                    if (product > largestPalindrome) { // checks whether this palindrome is bigger than the current one
                        largestPalindrome = product; // updates the largest palindrome
                    }
                }
            }
        }
        System.out.println("Largest palindrome: " + largestPalindrome);
    }
}