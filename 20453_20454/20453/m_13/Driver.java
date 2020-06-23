import java.util.Scanner;
/**
 * class Driver used as Tester for Pen class.
 *
 * @author (Yoni Shperling)
 * @version (08.12.2018)
 */
public class Driver
{
    /**
     * Method main is static method to test Pen class (Tester)
     *
     * @param args is array of strings String[] args
     */
    public static void main(String []args)
    {
        // declarations of constants and variables
        String colorPen;  // used to hold color Pen value assigned by user interaction
        String madePen;   // used to hold made Pen value assigned by user interaction
        int pricePen;     // used to hold price Pen value assigned by user interaction
        double weightPen; // used to hold weight Pen value assigned by user interaction
        Pen penA;         // used for new Pen instanse
        Pen penB;         // used for new Pen instanse

        Scanner scan = new Scanner(System.in); // call Scanner constractor, make new Scanner instanse for user interaction, assign Pen properties; color, made, price and weight. 

        // constractoring penA 
        System.out.println("Please enter the pen's color:");
        colorPen = scan.nextLine();
        System.out.println("Please enter the pen's made:");
        madePen = scan.nextLine();
        System.out.println("Please enter the pen's price:");
        pricePen = scan.nextInt();
        System.out.println("Please enter the pen's weight:");
        weightPen = scan.nextDouble();

        penA = new Pen(colorPen, madePen, pricePen, weightPen); // new Pen instance first pen (penA)

        scan.nextLine(); // this clean input buffer, this handle problems which input '\n' is read after nextInt and therefore colorPen is skipped. nextInt method does not read the newline character in your input created by hitting "Enter," and so the call to Scanner.nextLine returns after reading that newline.

        // constractoring penB
        System.out.println("Please enter the pen's color:");
        colorPen = scan.nextLine();
        System.out.println("Please enter the pen's made:");
        madePen = scan.nextLine();
        System.out.println("Please enter the pen's price:");
        pricePen = scan.nextInt();
        System.out.println("Please enter the pen's weight:");
        weightPen = scan.nextDouble();

        penB = new Pen(colorPen, madePen, pricePen, weightPen); // new Pen instance second pen (penB)

        // this prints two Pen's details using toStgring ("textually represents") of objects
        System.out.println(penA);
        System.out.println(penB);

        // penA task method Tester
        System.out.println(""); // clarity improvement - makes code and output more clear for the inspectors
        System.out.println("penA task Tester:");
        System.out.println(""); // clarity improvement - makes code and output more clear for the inspectors

        // this reperesetns all getter methods - this code can be later reduced by using only "setter section" for the clarity general assignment check this is all getter methods
        System.out.println("color is: " + penA.getColor() + " made is: " + penA.getMade() + " weights is: " + penA.getWeight() + " price is: " + penA.getPrice());

        // this reperesetns all isMethod methods (isSameMade, isSamePrice and isBluePen)
        System.out.println("penA isSameMade as penB: " + penA.isSameMade(penB));
        System.out.println("penA isSamePrice as penB: " + penA.isSamePrice(penB));
        System.out.println("penA isBluePen - Pen has a \"blue\" color: " + penA.isBluePen());

        // this reperesetns all setter methods
        System.out.println(""); // clarity improvement - makes code and output more clear for the inspectors
        System.out.println("Setter demonstration, penA current price (before the setter) is: " + penA.getPrice());
        System.out.println("Please enter the new pen's price:");
        pricePen = scan.nextInt();
        penA.setPrice(pricePen);
        System.out.println("penA Price (new price - after the setter) is: " + penA.getPrice());
        System.out.println(penB); // this prints Pen's details using toStgring ("textually represents") of object, this was recommended todo after each setter

        // this reperesetns toString method. Although used and called already by System.out.println(penA)->line 54 mentioned in task instruction to use all methods, this is also used to show the instanse "final properties".
        System.out.println(""); // clarity improvement - makes code and output more clear for the inspectors
        System.out.println("toString method: " + penA.toString());

        // penB task method Tester
        System.out.println(""); // clarity improvement - makes code and output more clear for the inspectors
        System.out.println("penB task Tester:");
        System.out.println(""); // clarity improvement - makes code and output more clear for the inspectors

        // this reperesetns all getter methods - this code can be later reduced by using only "setter section" for the clarity general assignment check this is all getter methods
        System.out.println("color is: " + penB.getColor() + " made is: " + penB.getMade() + " weights is: " + penB.getWeight() + " price is: " + penB.getPrice());

        // this reperesetns all isMethod methods (isSameMade, isSamePrice and isBluePen)
        System.out.println("penB isSameMade as penA: " + penB.isSameMade(penA));
        System.out.println("penB isSamePrice as penA: " + penB.isSamePrice(penA));
        System.out.println("penB isBluePen - Pen has a \"blue\" color: " + penB.isBluePen());

        // this reperesetns all setter methods
        System.out.println(""); // clarity improvement - makes code and output more clear for the inspectors
        System.out.println("Setter demonstration, penB current price (before the setter) is: " + penB.getPrice());
        System.out.println("Please enter the new pen's price:");
        pricePen = scan.nextInt();
        penB.setPrice(pricePen);
        System.out.println("penB Price (new price - after the setter) is: " + penB.getPrice());
        System.out.println(penB); // this prints Pen's details using toStgring ("textually represents") of object, this was recommended todo after each setter

        // this reperesetns toString method. Although used and called already by System.out.println(penB)->line 55 mentioned in task instruction to use all methods, this is also used to show the instanse "final properties".
        System.out.println(""); // clarity improvement - makes code and output more clear for the inspectors
        System.out.println("toString method: " + penB.toString());

    } // end of method main
} // end of class Driver
