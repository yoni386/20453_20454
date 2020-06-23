
/**
 * Write a description of class StudentCityCenter here.
 *
 * @author (your name)
 * @version (17/09/2019)
 */
public class StudentCityTester
{
   public static void main(String[] args)
   {
       City c1 = new City("Tel Aviv", 5, 8, 3, 4, 1004, 5);
       
       System.out.println("City Name: "+c1.getCityName());
       System.out.println("Center coordinates: "+c1.getCityCenter());
       System.out.println("Central Station coordinates: "+c1.getCentralStation());
       System.out.println("Num of Residents: "+c1.getNumOfResidents());
       System.out.println("Num of Neighbohoods: "+c1.getNoOfNeighborhoods());
       
       System.out.println("City c1:");
       System.out.println(c1);
       
       City c2=new City(c1);
       c2.setCityName("Tel Aviv Second");
       c2.setCityCenter(new Point(1,3));
       c2.setCentralStation(new Point(5,8));
       c2.addResidents(1000);
       c2.setNoOfNeighborhoods(5);
       c2.moveCentralStation(10,1);
       System.out.println("City c2:");
       System.out.println(c2);
       System.out.println("Distance between Center and Station: "+c2.distanceBetweenCenterAndStation());
       
       City c3=c1.newCity("Tel Aviv Third", 3.5, 7.5);
       System.out.println(c3);
                 
    }
    
}
