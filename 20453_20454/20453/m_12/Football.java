import java.util.Scanner; 

/**
 * class Football calculates the total of three games home vs different away teams (home == university). 
 * The calculation is done for total score and calculate and present the total win score and total tie beteen the teams
 *
 * @author Yoni Shperling, 200001956
 * @version 25.10.18
 */

public class Football
{
    public static void main (String [] args)
    {
        // declarations of constants and variables
        final int FIVE_POINTS = 5;
        final int THREE_POINTS = 3;
        final int TWO_POINTS = 2;
        final int NEGATIVE_FOUR_POINTS = -4;

        int universityFirstScore, universitySecondScore, universityThirdScore, competingFirstScore, competingSecondScore, competingThirdScore; 
        int universityFinalScore = 0;   // used to hold final score value
        int universityTotalWinning = 0; // used to hold total winning value
        int totalTie = 0;               // used to hold total tie value

        Scanner scan = new Scanner(System.in); // call Scanner constractor, make new Scanner instanse for user interaction, assign int to the university / competing (home and away teams scores). 

        System.out.println("Please enter results for 3 games");

        // first game values assignment
        System.out.println("The first game:");
        universityFirstScore = scan.nextInt();
        competingFirstScore = scan.nextInt();

        if (universityFirstScore > competingFirstScore)        // university win
        {
            universityFinalScore += THREE_POINTS;              // score + 3 points
            universityTotalWinning++;                          // increment winning value
        }
        else if (universityFirstScore < competingFirstScore)   // university lose
        {
            universityFinalScore += NEGATIVE_FOUR_POINTS;      // score -4 points
        }
        else                                                   // university tie
        {
            universityFinalScore += TWO_POINTS;                // score + 2 points
            totalTie++;                                        // increment tie value
        }

        // second game values assignment
        System.out.println("The second game:");
        universitySecondScore = scan.nextInt();
        competingSecondScore = scan.nextInt();

        if (universitySecondScore > competingSecondScore)      // university win
        {
            universityFinalScore += THREE_POINTS;              // score + 3 points
            universityTotalWinning++;                          // increment winning value
        }
        else if (universitySecondScore < competingSecondScore) // university lose
        {
            universityFinalScore += NEGATIVE_FOUR_POINTS;      // score -4 points
        }
        else                                                   // university tie
        {
            universityFinalScore += TWO_POINTS;                // score + 2 points
            totalTie++;                                        // increment tie value
        }

        // third game (last most important game) values assignment
        System.out.println("The third game:");
        universityThirdScore = scan.nextInt();
        competingThirdScore = scan.nextInt();

        if (universityThirdScore > competingThirdScore)        // university win
        {
            universityFinalScore += THREE_POINTS;              // score + 3 points
            universityFinalScore += (universityThirdScore * TWO_POINTS); // final game gain two points for each goal (only true for winning game)
            universityTotalWinning++;                          // increment winning value
        }
        else if (universityThirdScore < competingThirdScore)   // university lose
        {
            universityFinalScore += NEGATIVE_FOUR_POINTS;      // score -4 points
        }
        else                                                   // university tie
        {
            universityFinalScore += TWO_POINTS;               // score + 2 points
            totalTie++;                                       // increment tie value
        }

        // Bounus calculation. Maximum of five extra points can be gain. This condition is controled by if else-if

        if ( (universityThirdScore > competingThirdScore) && ( (universityThirdScore - competingThirdScore) > THREE_POINTS ) ) // used to validate difference between university team and away team is more than 3 (four or higher). as instructed to check home team won I checked it (universityThirdScore > competingThirdScore) check can be skipped due to second validation, if false it will < 3 
        {
            universityFinalScore += FIVE_POINTS;              // score +5 points
        }
        else if ( ( (universityFirstScore > competingFirstScore) && (universitySecondScore > competingSecondScore) ) && ( (universityFirstScore - competingFirstScore) > TWO_POINTS) && ( (universitySecondScore - competingSecondScore) > TWO_POINTS) ) // used to validate university won on first two games and first and second game score difference was more than 2 points (three or more points) per a game
        {
            universityFinalScore += FIVE_POINTS;              // score +5 points
        }

        else if ( (universityFirstScore == competingFirstScore) && (universitySecondScore == competingSecondScore) && (universityThirdScore == competingThirdScore) ) // used to validate tie between all games; game1, game2 and game3
        {
            universityFinalScore += FIVE_POINTS;              // score +5 points
        }

        System.out.println("Number of games which the university team won: " + universityTotalWinning); // e.g. Number of games which the university team won: 1
        System.out.println("Number of games with tie result: " + totalTie); // e.g. Number of games with tie result: 1
        System.out.println("Final score of the university team:  " + universityFinalScore); // e.g. Final score of the university team: 16

    } // end of method main
} // end of class Football