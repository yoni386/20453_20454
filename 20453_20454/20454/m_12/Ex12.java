/**
 * Represents information about a Complications Maman12 question1 and question2.
 *
 * @author (Yoni Shperling)
 * @version (02.05.20)
 */
public class Ex12
{
    /**
     * Method win
     * This method represents Question1 in mman12
     * This algorithm simulate a basic game between two players (Amir and Tamar) that each player in his turn draw a coin from the edges.
     * The player that has the higher score will win. Obviously both players want to win and therefor will draw the highest coin but only one can win. 
     * As instructed by the mman the algorithm need to prevent second player Tamar to win without calculate all different routes.
     * Summary this algorithm will lead Amir draw or winning the game in the most efficient simple approach. Each turn the highest coin will be drawn. 
     *
     * Time Complexity is O(n) n->arr.length arr is @param arr. One loop with n iterations will be used.
     * Memory Complexity is O(1). The memory complexity is static all declaration and allocation are static and independent meaning the memory is not dependent with n or other non static. 
     *
     *
     * @param arr A parameter points to array of integers
     */
    public static void win(int [] arr)
    {
        int amirSum = 0; // holds the Amir summary score
        int tamarSum = 0;  // holds the Tamar summary score

        int leftIndex = 0; // points to left index
        int rightIndex = (arr.length - 1); // points to right index

        int electedIndex = 0; // points to elected index

        boolean isAmirTurn = true; // this flag is used to indicate who's turn is (first plater or second) by eliminating other player. Turn by turn (one player in a given time is playing) approach is handled

        while (leftIndex <= rightIndex)
        {

            if(arr[leftIndex] >= arr[rightIndex])
            {
                electedIndex = leftIndex; 
                leftIndex++;
            }
            else // if(arr[leftIndex] < arr[rightIndex])
            {
                electedIndex = rightIndex; 
                rightIndex--;
            }

            if (isAmirTurn)
            {
                amirSum += arr[electedIndex];
                System.out.println("Amir took: " + arr[electedIndex]);
            }
            else
            {
                tamarSum += arr[electedIndex];
                System.out.println("Tamar took: " + arr[electedIndex]);
            }

            isAmirTurn = !(isAmirTurn); // flip boolean turn flag isAmirTurn->false if true or isAmirTurn->true if false
        }

        System.out.println("Final Score: "); 
        System.out.println("Amir total " + amirSum); 
        System.out.println("Tamar total " + tamarSum); 
    }

    /**
     * Method findTriplet finds the maximum trio multiplication that was possible with the given array numbers. 
     * The method will determine which numbers will give the maximum multiplication by iterating all elements (only once) from the given array @param arr.
     * Three numbers will be elected out of the five candidates numbers {A, B, C, D, E} = {lowestNumberA, lowestNumberB, ..., highestNumberA, highestNumberB, highestNumberC}
     * If array @param arr has only three elements then all of the above is redundant and those elements will be multiplied
     * The internal implmantaion for maximum trio multiplication is finding the highest three numbers in the array and two for lowest numbers.
     * The way is the numbers are elected are 
     *
     * Method will print elected trio numbers for for the maximum multiplication "cascading approch" Finding the highest number and shift (shift left) related elements and simarly to the lowest only shift right.
     *
     * Time Complexity is O(n) n->arr.length arr is @param arr. One loop with n iterations will be used in a worst case scenario.
     * Memory Complexity is O(1). The memory complexity is static all declaration and allocation are static and independent meaning the memory is not dependent with n or other non static. 
     *
     *
     * @param arr A parameter points to array of integers 
     * @return returns the maximum multiplication
     */
    public static int findTriplet(int[] arr)
    {

        int result = 0; // holds the multiplication final result
        String outputNumbers; // this will contain the message to be printed - elected trio numbers for for the maximum multiplication

        final int ZERO = 0;
        final int MIN_ELEMENTS = 3; // minimum (numbers) elements in the array arr

        // Sets the lowest numbers from high
        // to medium and low on both edges. Used later to determine and compare the elements number.
        if (arr.length > MIN_ELEMENTS) // if array (arr) length is has 4 or more elements otherwise just calculate three elements. According mman instruction array must have at least three elements
        {
            int highestNumberC =  Integer.MIN_VALUE;  // Points to the highest number. Used to determine and compare the elements number.
            int highestNumberB = Integer.MIN_VALUE; // Points to the second highest number. Used to determine and compare the elements number.
            int highestNumberA = Integer.MIN_VALUE; // Points to the third highest number. Used to determine and compare the elements number.

            int lowestNumberB = Integer.MAX_VALUE;  // Points to the second lowest number. Used to determine and compare the elements number.
            int lowestNumberA = Integer.MAX_VALUE; // Points to the lowest number. Used to determine and compare the elements number.

            for (int i = 0; i < arr.length; i++)
            {

                if (arr[i] > highestNumberC) // update new higher numbers. Point to higher numbers shift left if current element has higher value than highestNumberC (highestNumberC)
                {
                    highestNumberA = highestNumberB;
                    highestNumberB = highestNumberC;
                    highestNumberC = arr[i];
                }
                else if (arr[i] > highestNumberB)
                {
                    highestNumberA = highestNumberB;
                    highestNumberB = arr[i];
                }
                else if (arr[i] > highestNumberA)
                {
                    highestNumberA = arr[i];
                } 
                // end if number is highest
                if (arr[i] < lowestNumberA) // update point new lowest number if (current (arr[i] ) < l) element shift right from index 0 to index 1  lowestNumberB->lowestNumberA and lowestNumberA->current->(arr[i])
                {
                    lowestNumberB = lowestNumberA;
                    lowestNumberA = arr[i];
                }
                else if (arr[i] < lowestNumberB) // else if (current (arr[i] ) < lowestNumberB) element index [1] lowestNumberB->current(arr[i])
                {
                    lowestNumberB = arr[i];
                }
                // end if number is lowest

            } // end for. Iterate once all elements and find out if the number who greater or "rank numbers" lowestNumberA, lowestNumberB, highestNumberA, highestNumberB and highestNumberC
            outputNumbers = (highestNumberC + " "); // initialize outputNumbers string
            if ( (highestNumberC * highestNumberA * highestNumberB) > (highestNumberC * lowestNumberA * lowestNumberB) )
            {
                outputNumbers += (highestNumberA + " " + highestNumberB);
                result = highestNumberC * highestNumberA * highestNumberB;
            }
            else
            {
                outputNumbers += (lowestNumberA + " " + lowestNumberB);
                result = highestNumberC * lowestNumberA * lowestNumberB;
            }

        } // end if array (arr.length) has more than three elements

        else // if array has three elements. According to mman array (arr) must have at least three elements - no need to check this
        {
            outputNumbers = (arr[0] + " " + arr[1] + " " + arr[2]);
            result = arr[0] * arr[1] * arr[2];
        }

        System.out.println(outputNumbers);
        return result;
    }

}
