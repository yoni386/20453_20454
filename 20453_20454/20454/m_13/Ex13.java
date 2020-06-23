 /**
 * Represents Ex13 class Maman13 question1, question2 and question3.
 * The entire code is assembled without any variables or static therefore actual numbers are used and not variables or static - instructed in the man and forum course. *Note1*
 * The code does not oriented to be efficient due the mman instruction and therefore no Memory or Time Complexity were calculated or especially tuned to efficiency *Note2*
 *
 * @author (Yoni Shperling)
 * @version (17.05.20)
 */

public class Ex13
{
    /**
     * Method binaryNum gets integer number as formal parameter and checks if the number can be qualivied as binary number, meaning all the digits are zero or ones
     * If it is true will be returned otherwise false will be returned
     *
     * The method validites number is a binary number by calling recursively to it self (binaryNum) if number is 100 or higher (n > 99) two recursively calls are done one call handle the last digit and the second call
     * goes one level up Thousands to Hundreds and etc e.g. 1001 to 100 as shift left  1001.0 to 100.0 or 1234.0 to 123.0 and first call will pass 4 (last digit).
     * If number is less than 99 and more than 10 or more and less 100 recursive call with sift left is done
     * If number is 0 or 1 true will be returned. 
     * Static are not used due to mman instruction see *Note1*
     *
     * @param n A parameter int number to check against 
     * @return The return boolean true will be returned if number constructed from 0 or 1 digits
     */
    public static boolean binaryNum (int n)
    {
        if (n > 99) // n >= 100
        {
            return ( binaryNum(n % 10) && binaryNum(n / 10) ); // recursive call( n modulo 10) last digit and recursive call (n / 10) n / 10 is "shift left"
        }
        if (n > 9) // n >= 10
        {
            return binaryNum(n % 10); // recursive call ( n modulo 10)
        } 
        return ( (n == 0) || (n == 1) ); // validate if n is 0 or 1 (n == 0) or (n == 1) return true if n is 0 or 1
    }

    /**
     * Method howManyLetters calculate recursively how many English letters are passed and in formal s String char sequence.
     * English letters are set in ASCII unicode from 65 till 90 (a-z) and 97 till 122 (A-Z). All other (" ", "", "@" and etc) are "ignored" meaning chars will not be added to the sum
     *
     * @param s A parameter String represents the char sequence to check against
     * @return returns the number of valid English letters that passed in the s String formal parameter
     */
    public static int howManyLetters(String s)
    {
        if (s.length() >= 1)
        {
            if ( (s.charAt(0) >= 'a' && s.charAt(0) <= 'z') || (s.charAt(0) >= 'A' && s.charAt(0) <= 'Z') ) // validate if char is the range 'a' - 'z' or 'A' - 'Z' char is  65 or higher and less / equal 90 or 97 or higher and less / equal 122 e.g. ( (s.codePointAt(0) >= 65) && (s.codePointAt(0) <= 90) ) || ( (s.codePointAt(0) >= 97) && (s.codePointAt(0) <= 122) )
            {
                return ( 1 + ( howManyLetters(s.substring(1)) ) ); // if char is valid (english letter as explained above) howManyLetters called recursively with a sub string of s string index 1 till the end and adds one to calculation.
            }
            return howManyLetters(s.substring(1)); // howManyLetters called recursively with a sub string of s string index 1 till the end
        }
        return 0; // if s String formal parameter is less than 1 meaning 0 then 0 will be returned 
    }

    /**
     * Method checkDiv11MathHelper This method calculate recursively the sum of a given number by add or subtract each digit
     *
     * Last digit = n % 10 (n modulo 10) and checkDiv11MathHelper called recursively with parameter (-1*( n / 10)) number "shift left" * -1 to calculate the correct math "formula" add or subtract each digit
     *
     * @param n A parameter integer number as formal parameter is used for mathematical operation by checkDiv11 (add or subtract each digit used later by checkDiv11 to detirmne if number can be divided by 11 or not)
     * @return returns the mathematical operation result
     */
    private static int checkDiv11MathHelper(int n) // this method calculate recursively the sum of a given number by add or subtract each digit 
    {
        if (Math.abs(n) > 9) // if n has a two digit NOT (0 - 9) then mathematical operation is done recursively till number is 9 or less (absolut value)
        {
            return n % 10 + checkDiv11MathHelper(-1*(n / 10));
        }
        return n; //  if n has a single digit 0 - 9 n is returned
    }

    /**
     * Method checkDiv11 check recursively if number (n formal parameter the number) can be divided by 11.
     * According to the mman info one of the methods to answer this is by add and subtract each digit this is done by toggling value of digit between positive and negative. If the result of the mathematical operation is not one one digit 0-9 (absolut value) then another calculation need to be done till you get one digit.
     * If the result of the mathematical operation leads to 0 then number can be divided by 11 -> (n % 11) == 0 otherwise (1-9) number can't divided by 11 e.g. 12 or 9
     * The only way method can return false if and only if number n formal parameter that passed by the method has one digit or if result checkDiv11 (returned one digit)
     * If number is big e.g. 540936*11*11 several "iteration approach" recursive call are done in the background
     *
     * The method is using a private method "checkDiv11MathHelper" to make "hard lifting" math calculation (also recursively) more info is described in the method API
     *
     * @param n A parameter integer number as formal parameter and checks if the number can be divided by 11
     * @return returns true if number can be divided by 11 or not
     */
    public static boolean checkDiv11 (int n)
    {
        if (n == 0) // validate number is not 0 formal parameter is not 0 if it is 0 then "early return" `will be called  false will be returned
        {
            return false;
        }
        if (Math.abs(n) > 9) // validate number has two digits formal parameter is not 0-9 and n > 9 (9 is treated as absolut value)
        {
            if (checkDiv11MathHelper(Math.abs(n)) > 9) // if sum of a given number add or subtract each digit has two digits >= 10 method checkDiv11 is called recursively. Not optimized to efficiency *Note2*
            {
                return checkDiv11(checkDiv11MathHelper(Math.abs(n)));
            }
            if (checkDiv11MathHelper(n) == 0) // if sum of a given number add or subtract each digit is 0 AND formal parameter was not 0 then true is returned
            {
                return true;
            }
        }
        return false; // return false if number n (formal parameter) has only one digit n % 11 != 0 if n <= 10 or n % 11 == 0 if and only if n >= 11
    }
}
