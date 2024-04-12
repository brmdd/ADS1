import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        char letter = sc.nextLine().charAt(0);
        int result = findLetter(text, letter);

        System.out.println("The letter " + letter + "occurs in " + text + result + "times. ");
    }

    private static int findLetter(String text, char letter) {
        if (text == null) {
            return 0;
        }
        return 0;
    }
}
