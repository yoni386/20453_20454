import java.util.Scanner; 

/**
 * class Ball calculates the volume and surface area of a ball.
 *
 * @author Yoni Shperling, 200001956
 * @version 05.10.18
 */

public class Ball
{
    public static void main (String [] args)
    {
        //declarations of constants and variables
        final double FORMULA_FOUR_TIMES_PI = Math.PI * 4; // used for caluclate surface area and volume
        final double FORMULA_RADIUS_DENOMINATOR = 3.0; // used for formula to caluclate sphere volume
        int R = 0; // radius variable. The variable name conflicts with the predefined rules (names with meaning). Reason is instructed and defined already by the question

        Scanner scan = new Scanner (System.in); // call Scanner constractor, make new Scanner instanse for user interaction, assign int radius value. 

        System.out.println("Please enter the Radius of the ball. Value must be a single integer:");
        R = scan.nextInt();

        final double SURFACE_AREA = FORMULA_FOUR_TIMES_PI * (R*R); // this is used to caluclates surface area
        // final double VOLUME = FORMULA_FOUR_TIMES_PI * (R*R*R); // FORMULA_RADOIUS; // this is used to caluclates sphere volume
        final double VOLUME = SURFACE_AREA * R / FORMULA_RADIUS_DENOMINATOR; // this is used to calculate sphere volume. Can be also done as above, this is more efficient. By more efficient, I mean, lead to the same result and uses less instructions.
      
        System.out.println("Ball that has a radius of: " + R + " has a \"surface area\" of: " + SURFACE_AREA + " and \"volume\" of: " + VOLUME);

    } // end of method main
} //end of class Ball