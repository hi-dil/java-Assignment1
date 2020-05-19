import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("\n==============================================================================");
        System.out.println("This program will be used to convert the following string into its secret code");
        System.out.println("==============================================================================\n");

        System.out.print("Please enter your string here: ");
        String inString = scan.nextLine();

        SecretCode obj1 = new SecretCode(inString);
        int length = obj1.getStringLen(inString);
        System.out.println("Your string length is: " + length);

        // do the string validation
        do {
            if (!obj1.checkStringValidity(inString)) {

                System.out.println("You've input incorrect string. Please try to input again.\n");

                System.out.print("New input: ");
                inString = scan.nextLine();

                System.out.println("Your new string is: " + inString);
                obj1.setInString(inString);

                System.out.println("Your string length is: " + obj1.getStringLen(inString));
            }
        } while (!obj1.checkStringValidity(inString));

        System.out.println("Outstring: " + obj1.ShiftChar(inString, length));
    }
}
