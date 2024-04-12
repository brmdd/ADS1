import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        char letter = sc.nextLine().charAt(0);
        int result = findLetter(text, letter);

        System.out.println("The letter " + letter + " occurs in string " + text + " " + result + " times. ");
    }

    private static int findLetter(String text, char letter) {
        if (text.isEmpty()) {
            return 0;
        }

        int count = (text.charAt(0) == letter) ? 1 : 0;

        if (text.length() > 1) {
            return count + findLetter(text.substring(1), letter);
        }
        else return count;
    }
}
