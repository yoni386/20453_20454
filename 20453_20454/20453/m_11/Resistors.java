import java.util.Scanner; 

/**
 * class Resistors calculates the total resistance of three parallel resistors (parallel resistors are resistors that are connected in parallel way).
 *
 * @author Yoni Shperling, 200001956
 * @version 05.10.18
 */

public class Resistors {

    public static void main (String[] args) {

        // declarations of constants and variables
        final double FORMULA_NUMERATOR = 1.0; // used for caluclate the total Resistors Resistance.
        final double FORMULA_DOUBLE_PRECISION = 10000000000.0; // this used to make custom double PRECISION. The mantissa (significant digits) should contain 10 significant digits.
        double totalResistorsResistance = 0.0;

        Scanner scan = new Scanner (System.in); // call Scanner constractor, make new Scanner instanse for user interaction, assign r1, r2 and r2 (resistors values).

        System.out.println ("Please enter 3 integers:"); 
        System.out.println ("Please enter r1:");
        int r1 = scan.nextInt();
        System.out.println ("Please enter r2:"); 
        int r2 = scan.nextInt(); 
        System.out.println ("Please enter r3:"); 
        int r3 = scan.nextInt();

        totalResistorsResistance = FORMULA_NUMERATOR / ( (FORMULA_NUMERATOR / r1) + (FORMULA_NUMERATOR / r2) + (FORMULA_NUMERATOR / r3) ); // this calculate the total resistors resistance. verify > 0 (divide by 0) is not required, according to the question details, all (argumnemts are > 0)

        totalResistorsResistance = Math.round(totalResistorsResistance * FORMULA_DOUBLE_PRECISION) / FORMULA_DOUBLE_PRECISION; // this "converts" (1.090909090909091 to 1.0909090909). As required by the question, the mantissa (significant digits) should have 10 digits instead of 15 digits as regular in double.
        System.out.println("The total resistance of resistors " + r1 + ", " + r2 + ", and " + r3 + " connected in parallel is: " + totalResistorsResistance);

    } // end of method main
} //end of class Resistors