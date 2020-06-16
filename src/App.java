/*
    * 66661 MOHAMAD HAIDIL BIN IDRIS
    * 66783 MUHAMMAD AIMAN BIN MOHD AZMI
    * 67872 SYAZZWA NATASYA BINTI MOHD ZAIDI
    * 66477 LIM AI XIN
    * 64631 AMNAH NADIAH BINTI SUFIAN
 */

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

        // do the string validation
        do {
            if (!obj1.checkStringValidity(inString)) {

                System.out.println("You've input incorrect string. Please try to input again.\n");

                System.out.print("New input: ");
                inString = scan.nextLine();
                obj1.setInString(inString);
            }
        } while (!obj1.checkStringValidity(inString));

        System.out.println("inString: " + inString);

        int length = obj1.getStringLen(inString);
        System.out.println("Your string length is: " + length);

        System.out.println("Outstring: " + obj1.ShiftChar(inString, length));
        scan.close();
    }
}
