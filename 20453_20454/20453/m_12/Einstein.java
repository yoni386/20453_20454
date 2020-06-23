import java.util.Scanner; 

/**
 * class Einstein "Albert Einstein riddle" is a kind of a game (riddle). It was said on the famous mathematician and physicist Albert Einstein enjoyed confusing his friends with this riddle.
 *
 * @author Yoni Shperling, 200001956
 * @version 06.10.18
 */

public class Einstein
{
    public static void main (String [] args)
    {
        // declarations of constants and variables
        final int EXPECTED_VALUE = 1089; // used to validate the end result is equal to the expected value (1089)
        final int VALID_MAX_RANGE = 999; // used to validate user number is the valid range (userNumber < maximum). Maximum threshold is 999, valid range is (> 99 && < 1000)
        final int VALID_MIN_RANGE = 99; // used to validate  user number is the valid range (userNumber > minimum). Minimum threshold is 100, valid range is (> 99 && < 1000)

        final int HUNDRED = 100; // used by the formula to get ones, tens and hundreds
        final int TEN = 10; // used by the formula to get ones, tens and hundreds

        int userNumber = 0; // user interaction variable  // e.g. userNumber 773
        int userNumberHundreds = 0; // used to hold hundreds value. // e.g. userNumber 773 hundreds is 7*100
        int userNumberTens = 0; // used to hold tens value. // e.g. userNumber 773 is 7*10
        int userNumberOnes = 0; // used to hold ones value. // e.g. userNumber 773 3*1

        int userNumberReverted = 0; // used to hold reverted value. e.g. userNumber 773 reverted to 377
        int difference = 0; // used to hold difference userNumberReverted - userNumber. abs(orginal - reverted) value. e.g. 773 is reverted to 377 Math.abs(userNumberReverted - userNumber) if -(int) abs return postive int 1-2==abs->1

        int userNumberRevertedHundreds = 0; // used to hold reverted hundreds value. e.g. userNumber 773 revert is 337 hundreds is 3*100
        int userNumberRevertedTens = 0; // used to hold reverted tens value. e.g. userNumber 773 revert is 337 hundreds is 3*10
        int userNumberRevertedOnes = 0; // used to hold reverted ones value. e.g. userNumber 773 revert is 337 hundreds is 7*1
        int userNumberDifferenceReverted = 0; // used to hold reverted difference is (userNumberReverted - userNumber). abs(orginal - reverted) value. e.g. 773 is reverted to 377 Math.abs(userNumberReverted - userNumber) if -(int) abs return postive int 1-2==abs->1

        Scanner scan = new Scanner(System.in); // call Scanner constractor, make new Scanner instanse for user interaction, assign int to the user number (userNumber). 

        System.out.println("Welcome to the Einstein magic game.");
        System.out.println("Please enter a 3 digit positive number whose first and last digits are different:");

        userNumber = scan.nextInt();

        if (userNumber > VALID_MIN_RANGE && userNumber < VALID_MAX_RANGE) // used to validate userNumber > 0 && < 1000 and no leading zero's e.g. 099, 009 are not valid goto else
        {
            System.out.println("User number is: " + userNumber);

            userNumberHundreds = userNumber / HUNDRED; // calculates the hundreds digit
            userNumberTens = userNumber / TEN % TEN; // calculates the tens digit userNumber / TEN % TEN (divide and modulo)
            userNumberOnes = userNumber % TEN; // calculates the ones digit userNumber % TEN (modulo) 

            if (userNumberHundreds != userNumberOnes) // check hundreds and ones are not equal if it dose "earlier return" else and stdout "error msg"
            {

                userNumberReverted = ( ( (userNumberOnes * HUNDRED) + (userNumberTens * TEN) ) + userNumberHundreds ); // used to hold reverted value. e.g. 773 is reverted to 377

                difference = Math.abs(userNumberReverted - userNumber); // used to hold difference (userNumberReverted - userNumber). abs(orginal - reverted) e.g. 396 difference. abs is used instead of decrease large number with small

                System.out.println("Difference: " + difference);

                userNumberRevertedHundreds = difference / HUNDRED; // calculates the hundreds digit
                userNumberRevertedOnes = difference % TEN;         // calculates the ones digit % TEN (modulo) 
                userNumberRevertedTens = difference / TEN % TEN;   // calculates the tens digit difference / TEN % TEN (divide and modulo)

                userNumberDifferenceReverted = ( ( (userNumberRevertedOnes * HUNDRED) + (userNumberRevertedTens * TEN) ) +  userNumberRevertedHundreds ); // e.g. revert 396 to 693 (6*100)+(9*10)+(3*1)=693

                System.out.println ("Reversed difference: " + userNumberDifferenceReverted);

                if ((userNumberDifferenceReverted + difference) == EXPECTED_VALUE) // used to validate userNumberDifferenceReverted + difference are equal to EXPECTED_VALUE 396+693==1089 
                {
                    System.out.println("SUCCEEDED");
                } else {
                    System.out.println("FAILED");
                }

            }
            else
            {
                System.out.println("The number you entered is not valid. First and last digits are not different (Hundreds and ones must be diffrent e.g. 773)");
            }

        }
        else
        {
            System.out.println ("The number you entered is not a 3 digit positive number");
        }

    } // end of method main
} // end of class Einstein