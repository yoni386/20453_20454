
/**
 * Represents Group class Maman11 question1.
 *
 * @author (Yoni Shperling)
 * @version (15.03.2020)
 */
public class Group
{
    // instance variables
    private Person[] _array;
    private int _noOfPerson;
    
    final int MAX = 10; // according to API should package private and not final
    private static final int ZERO = 0;
  

    /**
     * Constructor for objects of class Group
     */
    public Group()
    {
        // initialise instance variables
        _array = new Person[MAX]; // Person Array is initialise MAX->10
        _noOfPerson = ZERO; // _noOfPerson->0
    }
    
    /**
     * Method addPerson - This method adds new Person object to the _array person array. 
     * New Person object is constractored with the formal parmameter (descired below).
     * Method must validate that array has enough capacity to add the new elment and array does not contain this person already. 
     * Method returns true on success (addional element, Person can be added to array, if array has enough capacity and if person is not included in the array) otherwise false if array is full (_noOfPerson == MAX) or person (p) is already included in the array => "falure". 
     * 
     * @param p The person to check equality with
     * 
     * @return The returns true on success (addional element, Person was added) and false on falure
     */
    public boolean addPerson(Person p)
    {
        if (_noOfPerson == MAX) // validate array capacity will not exceeds internal allocation size. MAX is the maximum array size and _noOfPerson is the current used size. _noOfPerson should be less than MAX. 
        {
            return false; // if (_noOfPerson == MAX) meaning internal used array size is equal maximum array => violation the array allocation earily return (return false) need to be called. 
        }
       
        for (int i = 0; i < _noOfPerson; i++)
        {
            if (_array[i].equals(p))
            {
                return false;
            }
        }
            
        _array[_noOfPerson] = new Person(p);
        _noOfPerson++;  // increment _noOfPerson = (_noOfPerson + 1)
        return true;
    }
 
    /**
     * Method bornInDate The metohd calculate how many persons born on the recevied date (formal parameter d)
     * If array is empty _noOfPerson->0 meaning (for loop iteration index == _noOfPerson) for loop condtion is false therefore totalNumBornInDate->0 and 0 will return  
     * @param d The date to check equality with
     * 
     * @return returns the total number of people who born on the recevied date
     */
    public int bornInDate(Date d)
    {
        int totalNumBornInDate = ZERO;
        
        for (int i = 0; i < _noOfPerson; i++) // if _noOfPerson->0 meaning array is empty and loop will be skipped and 0 will be returned totalNumBornInDate->0 
        {
            if (_array[i].getDateOfBirth().equals(d)) // validate if this person has the same date of birth as recevied date
            {
                totalNumBornInDate++;
            }
        }
        
        return totalNumBornInDate; 
    }
    
     /**
     * Method bornInMonth The method calculate how many persons born on the recevied month (formal parameter m)
     * If month is not valid value e.g. 1-12 and array is empty _noOfPerson->0 meaning (for loop iteration index == _noOfPerson) for loop condtion is false therefore totalNumBornInMonth->0 and 0 will return  
     * @param m The month to check equality with
     * 
     * @return returns the total number of people who born on the recevied month
     */
    public int bornInMonth(int m)
    {
       int totalNumBornInMonth = ZERO;
        
       if (m >= Date.MIN_MONTH && m <= Date.MAX_MONTH && _noOfPerson != ZERO)
       {
            for (int i = 0; i < _noOfPerson; i++)
            {
                if (_array[i].getDateOfBirth().getMonth() == m) // validate if this person born on the the same month as recevied date
                {
                    totalNumBornInMonth++;
                }
            }
        }
        return totalNumBornInMonth; 
    }
    
    
    /**
     * Method oldestPerson returns the oldest person in the array.
     * If array is empty null will be returned. If there is more than one person, one of them arbitrarily returned.
     *
     * @return returns the oldest person. null might be returned if array is empty.  
     */
    public Person oldestPerson()
    {
        Person person = null;
        
        if (_noOfPerson != ZERO) // validate array is not empty 
        {
            person = new Person(_array[ZERO]);
            for (int i = 1; i < _noOfPerson; i++)
            {   
                if (_array[i].older(person))
                {
                    person = new Person(_array[i]);
                }
            }
        } 
        return person;
    }
    
    /**
     * Method firstPerson returns the first name of the person whose last name is first
     * In a dictionary (lexicographically order) of all those in the array. If there are several people with the same last name, it will be returned that their first name is first in the dictionary. If the array is empty null is returned.
     *
     * @return returns the first name of the person whose first name is first or null if array is empty
     */
    public String firstPerson()
    {
        String firstName = null; // initialise firstName string to be null. null will be returned if array is empty
        
        if (_noOfPerson != ZERO) // validate array is not empty 
        {
            Person person = _array[ZERO]; // / alias in this case is ok. person as threated as "immutable". in the end of the method this will be not used anymore.
            for (int i = 1; i < _noOfPerson; i++)
            {
                if (person.getLastName().compareTo(_array[i].getLastName()) == ZERO) // validate If all last names are indetical. According to instractor can be treated as array as only one name if true nested if will compare first names
                {  
                    if (person.getFirstName().compareTo(_array[i].getFirstName()) < ZERO) // validate if this string (first name) is lexicographically less than the string argument
                    {
                        firstName = person.getFirstName();
                    }
                }
                
                else if (person.getLastName().compareTo(_array[i].getLastName()) < ZERO) // validate if this string (last name) is lexicographically less than the string argument
                {
                    firstName = person.getFirstName();
                }
                
                person = new Person(_array[i]);
            }
        }
        
        return firstName; 
    }
    
     /**
     * returns a String that represents the group ("textually represents") of Person textually represents. Each person in new line
     * 
     * @return A String representation of the Group object
     */
    public String toString()
    {
        String stringArray = new String();

        for (int i = 0; i < _noOfPerson; i++)
        {
            stringArray += "\n" + _array[i];
        }
    
        return stringArray;
    }
   
} // end of Group class
