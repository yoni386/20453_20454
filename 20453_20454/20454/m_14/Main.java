
public class Main 
{

    public static int count (String str, String pattern)
    {
        return count (str, pattern, 0, 0, 0);
    }

    private static int count (String str, String pattern, int i, int j, int total)
    {
        if ( i < 0 || i >= str.length() || j < 0 || j >= pattern.length() )
        {
            return total;
        }

        if ( str.charAt(i) == pattern.charAt(j) )
        {
            if ( pattern.charAt(j) == pattern.charAt(pattern.length() -1) )
            {
                return 1 + count (str, pattern, i + 1, j, total);
            }
            total = count (str, pattern, i + 1, j + 1, total);
            total = count (str, pattern, i + 1, j, total);
        }
        else
        {
            return count (str, pattern, i + 1, j, total);
        }
        
        return total;
    }

    public static void main()
    {
     System.out.println("\n------------------------------------\nTesting Question 1\n------------------------------------\n");
        int result = Ex14.count ("subsequence","sue");
        System.out.println("count(\"subsequence\",\"sue\") return value is: " + result);

        System.out.println("\n------------------------------------\nTesting Question 2\n------------------------------------\n");
        System.out.println("Test for input:");
        System.out.println("\t{{2,0,1,2,3},");
        System.out.println("\t {2,3,5,5,4},");
        System.out.println("\t {8,-1,6,8,7},,");
        System.out.println("\t {3,4,7,2,4},");
        System.out.println("\t {2,4,3,1,2}}");
        
        int[][] drm = { {2,0,1,2,3},
                        {2,3,5,5,4},
                        {8,-1,6,8,7},
                        {3,4,7,2,4},
                        {2,4,3,1,2}};
        result = Ex14.prince (drm,0,0);
        System.out.println("\nprince (drm,0,0) return value is: " + result);
        result = Ex14.prince (drm,4,4);
        System.out.println("\nprince (drm,4,4) return value is: " + result);
    }
}