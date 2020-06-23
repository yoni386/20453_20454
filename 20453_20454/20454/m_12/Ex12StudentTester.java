

class Ex12StudentTester {    
    
    public static void main(String[] args) 
    {
        System.out.println("\n------------------------------------\nTesting Question 1\n------------------------------------\n");
        System.out.println("Test for input: {16,23,30,13,14,21,19,15}");
        int[] coins1 = {16,23,30,13,14,21,19,15};
        Ex12.win(coins1);
       
        System.out.println("\n------------------------------------\nTesting Question 2\n------------------------------------\n");
        int[] arr = {-4,1,-8,9,6};
        int result = Ex12.findTriplet (arr);
        System.out.println("\nfindTriplet return value is: " + result);
        System.out.println("(Remark to students - Note that the order of the printed numbers is not important)");
      
      }
  }    // Ex12StudentTester
