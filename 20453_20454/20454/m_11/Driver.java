/**
 * Represents Driver class Maman11 question2.
 *
 * @author (Yoni Shperling)
 * @version (09.03.20)
 */
public class Driver
{
    public static void main()
    {

        Group peopleGroup = new Group();
        Date someDate = new Date(-1,-1,-2000); // values are not valid object will created with the default 1/1/2000

        Person p0 = new Person("Adam", "FirstPerson", 0, 7, 1, 0); // year is not valid date will set to default 1/1/2000
        Person p1 = new Person("Albert", "Einstein", 314159265, 14, 3, 1879);
        Person p2 = new Person("Isaac", "Newton", 1414213562, 4, 1, 1643);
        Person p3 = new Person("Isaac", "Newton", 1414213562, 4, 1, 1643);
        // demonstrate some of the examples and methods 
      
        p3.setFirstName(p0.getFirstName());
        p3.setLastName(p0.getLastName());
        p3.setId(p0.getId());

        Date dateToCopy = new Date(p0.getDateOfBirth());
        p3.setDateOfBirth(dateToCopy.getDay(), dateToCopy.getMonth(), dateToCopy.getYear());

        peopleGroup.addPerson(p0);
        peopleGroup.addPerson(p1);
        peopleGroup.addPerson(p2);
        peopleGroup.addPerson(p3); // should not add this due the fact that p0 is equal to p3

        System.out.println("People details are: " + peopleGroup);
        System.out.println("The Oldest person name is: " + peopleGroup.oldestPerson());
        System.out.println("The First name of the person that has the first lexicographically last name is: " + peopleGroup.firstPerson());
        System.out.println(peopleGroup.bornInDate(someDate) + " People Born at " + someDate);
        System.out.println("How many people born at specfic month: " + peopleGroup.bornInMonth(1));

        Person p3NewNotReferance = new Person(p3);
        if (p3 == p3NewNotReferance) // should be false
        {
            System.out.println("Caution! alias was not done instead of copy. This shouldn't be printed.");
        }

        if (p1.sameBirthday(p2)) // should be false
        {
            System.out.println("Caution! sameBirthday method has a problem. This shouldn't be printed.");
        }

        if (p1.older(p2)) // should be false
        {
            System.out.println("Caution! older method has a problem. This shouldn't be printed.");
        }
        
        
         Date someDate1 = new Date(-1,-1,-2000); 
         if (someDate.before(someDate1)) // should be false
        {
            System.out.println("Caution! older method has a problem. This shouldn't be printed.");
        }

    } // end of main method
} // end of Driver class
