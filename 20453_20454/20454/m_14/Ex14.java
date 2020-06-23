/**
 * Represents Ex14 class Maman14 question1 and question2
 * The entire code is assembled without any static variables therefore actual numbers are used and not variables or static
 * The code does not oriented to be efficient due the mman instruction and therefore no Memory or Time Complexity were calculated or especially tuned to efficiency
 *
 * @author (Yoni Shperling)
 * @version (28.05.20)
 */

public class Ex14
{
    /**
     * Method count - counts on a given str string against string pattern. 
     * This recursive method returns the number of times that the string pattern appears within the string str as a subset. 
     * The pattern string should not appear continuously in str.
     *
     * @param str A parameter is the the string being tested
     * @param pattern A parameter is the string which used by the test to perform the actual test validation
     * 
     * @return The returns the number of times that pattern string appears within the str string as a subset
     */
    public static int count (String str, String pattern)
    {
        return count(str, pattern, 0, 0);
    }

    /**
     * Method prince
     * 
     * The prince bounces on the roofs of the city. His purpose is save the princess. To do so, the prince first needs to find the evil and fight him.
     * The map of the heights of the city roofs is represented by a square 2-dimensional array containing integers. Assume that if the cell contains a non-negative number, it represents a roof height. 
     * The location of evil is indicated by the number -1. At each step the Prince can advance to a nearby square north, south, east, or west (not diagonally). 
     * If the adjacent square is at the same height - the prince can walk to it. In addition, the prince can climb one roof higher one and descend to a roof upto two levels lower.
     * If it tries to climb more than one levels or drop to more than two levels, it is immediately disqualified. 
     * When the prince is on a roof near the wicked (one of his four neighbors) he can jump to it regardless of the difference in heights.
     * 
     * @param drm two dimensional integer array represented by a map of the heights of the city roofs
     * @param i A parameter index for the "outer" array e.g. column
     * @param j A parameter parameter index for the "inner" array e.g row
     * @return returns the number of elements in shortest path
     */
    public static int prince (int[][] drm, int i, int j)
    {
        return prince(drm, i, j, drm[i][j], 1);
    }

    private static int count (String str, String pattern, int i, int j)
    {
        int resultIncrementer = ( j == pattern.length() -1 ) ? 1 : 0; // used to increment result if last char's and all car's before are good call will return +1 otherwise 0

        if ( i < 0 || i >= str.length() || j < 0 || j >= pattern.length() ) // array validation if char / index is valid (array boundaries) "continue" otherwise "early" return 0
        {
            return 0; // "early" return 0
        }
        if ( str.charAt(i) == pattern.charAt(j) ) // if str and pattern char's are equal
        {
            // first complete all char's from each str and pattern then continue with the next char str char  by calling count recursively
            return resultIncrementer + count (str, pattern, i + 1, j + 1) // call count recursively with next str / pattern char's
            + count (str, pattern, i + 1, j); // call count recursively with next str char. resultIncrementer might be 0 if char pattern did not reach last char or 1 if str / pattern char are equal and if char is the last char in pattern
        }
        else  // else (true if str and pattern char's are not equal )
        {
            return count (str, pattern, i + 1, j); // call count recursively with next str char
        }
    }

    // second option differ from above option code flow is a bit different might be more easy to follow and first complete all char's from each str then continue to next str / pattern char's 
    // private static int count (String str, String pattern, int i, int j)
    // {
        // int resultIncrementer = ( j == pattern.length() -1 ) ? 1 : 0; // used to increment result if last char's and all car's before are good call will return +1 otherwise 0

        // if ( i < 0 || i >= str.length() || j < 0 || j >= pattern.length() ) // array validation if char / index is valid (array boundaries) "continue" otherwise "early" return 0
        // {
            // return 0;
        // }
        // if ( str.charAt(i) != pattern.charAt(j) ) // if char's are not equal
        // {
            // return count (str, pattern, i + 1, j); // look for next char in str - call count recursively with next str char
        // }
        // return resultIncrementer + count (str, pattern, i + 1, j) + count (str, pattern, i + 1, j + 1);  // call count recursively with next str then call count recursively with next str char and next char pattern
    // }
    
    private static int prince(int[][] drm, int i, int j, int elementValue, int numElements)
    {
        if ( i < 0 || i >= drm.length || j < 0 || j >= drm[i].length || drm[i][j] == Integer.MIN_VALUE )  // arrayBoundariesValidation Walk Validation - Read / Write array validation range before accessing to it if array index's will lead to bound out of the array -1 or if path is blocked  (drm[x][y] == negative number->Integer.MIN_VALUE) will be returned otherwise normal flow 
        {
            return -1;
        }
        else if ( drm[i][j] == -1) // Evil person validation - this cell is what we are looking for
        {
            return numElements;
        }
        else if ( (elementValue - drm[i][j]) < -1 || (elementValue - drm[i][j]) > 2 ) // Validation if movement is valid descending can be two or less levels and for going up maximum one level is allowed ( (x2,y2) - (x1,y1) ) >= -1 or < 2 otherwise returns -1
        {
            return -1;
        }

        elementValue = drm[i][j]; // temporary point (copy) to last element value
        drm[i][j] = Integer.MIN_VALUE; // temporary "lock" access by a flag mark this cell as low negative number meaning this path was done 

        // minPath could be replaced with the variable numElements but for code clarity minPath is assigned with the reutn value from minPathElementsHelper
        int minPath = minPathElementsHelper(
                prince(drm, i - 1, j, elementValue, numElements + 1 ), // North walk
                prince(drm, i, j + 1, elementValue, numElements + 1 ), // Right walk
                prince(drm, i + 1, j, elementValue, numElements + 1 ), // South walk
                prince(drm, i, j - 1, elementValue, numElements + 1 )  // Left  walk
            );

        drm[i][j] = elementValue; // "unlock" temporary "lock" was revert back

        return minPath; // returns this minimum path by all four routes on each junction (branch) this could return 
    }

    private static int minPathElementsHelper(int a, int b, int c, int d) 
    {
        int minVal = Integer.MAX_VALUE;

        if (a < minVal && a != -1)
            minVal = a;

        if (b < minVal && b != -1)
            minVal = b;

        if (c < minVal && c != -1)
            minVal = c;

        if (d < minVal && d != -1)
            minVal = d;

        return ( ( minVal == Integer.MAX_VALUE ) ? -1 : minVal);
    }
}
