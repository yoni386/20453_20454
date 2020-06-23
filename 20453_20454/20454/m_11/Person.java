/**
 * Represents Person class Maman11 question1.
 *
 * @author (Yoni Shperling)
 * @version (14.03.2020)
 */
public class Person
{
    // declartions
    private String _firstName;
    private String _lastName;
    private long _id;
    private Date _dateOfBirth;
    
    private static final int ZERO = 0;
    private static final int DEFAULT_ID = 123456789;
    
    // constractors
    /**
     * creates a new Person object. 
     * constractor is calling Date constractor (composition has - a) if the date is valid, formal parameters (day, month and year) are used otherwise Date will be created with default date->1/1/2000
     * @param firstName The first name of the person
     * @param lastName The last name of the person
     * @param id The id of the person
     * @param day The day of the date of birth
     * @param month The month of the date of birth
     * @param year The year of the date of birth
     */
    public Person(String firstName, String lastName, long id, int day, int month, int year)
    {
        // initialise instance variables
        _firstName = firstName;
        _lastName = lastName;
        _id = id > ZERO ? id : DEFAULT_ID; // validiated for postive int if true _id->id is assigned otherwise DEFAULT_ID->123456789
        _dateOfBirth = new Date(day, month, year);
    }

    /**
     * copy constructor
     * @param other The person from which to construct the new object
     */
    public Person(Person other)
    {
        this(other._firstName, other._lastName, other._id, other._dateOfBirth.getDay(), other._dateOfBirth.getMonth(), other._dateOfBirth.getYear());
    }

    /**
     * gets the First Name
     * 
     * @return returns the first name of the person
     */
    public String getFirstName()
    {
        return _firstName;
    }

    /**
     * gets the Last Name
     * 
     * @return returns the last name of the person
     */
    public String getLastName()
    {
        return _lastName;
    }

    /**
     * gets the ID
     * 
     * @return returns the id of the person
     */
    public long getId()
    {
        return _id;
    }

    /**
     * gets the date of birth
     * 
     * @return returns the date of birth of the person
     */
    public Date getDateOfBirth()
    {
        return new Date(_dateOfBirth);
    }

    /**
     * sets the date of birth (only if date remains valid)
     * @param d The new day of the date
     * @param m The new month of the date
     * @param y The new year of the date
     */
    public void setDateOfBirth(int d, int m, int y)
    {
        _dateOfBirth.setDay(d);    
        _dateOfBirth.setMonth(m);
        _dateOfBirth.setYear(y);
    }

    /**
     * sets the first name of person
     * @param name The new first name of person
     */
    public void setFirstName(String name)
    {
        _firstName = name;
    }

    /**
     * sets the last name of person
     * @param name The new last name of person
     */
    public void setLastName(String name)
    {
        _lastName = name;
    }

    /**
     * sets the ID of the person
     * @param id The new id of person
     */
    public void setId(long id)
    {
        _id = id;
    }

    /**
     * check if the person is older then other person
     * @param other The person to compare with 
     * 
     * @return returns true if this person is older then other person otherwise returns false
     */
    public boolean older(Person other)
    {
        return _dateOfBirth.before(other._dateOfBirth);
    }

    /**
     * check if both person dates are the same
     * @param other The person to check equality with
     * @return returns true if both dates object are equal otherwise returns false
     */
    public boolean sameBirthday(Person other)
    {
        return _dateOfBirth.equals(other._dateOfBirth);
    }

    /**
     * check if 2 persons are the same
     * Two Person considered to be equal if firstName, lastName, id and dateOfBirth are identical.
     * @param other The person to check equality with
     * 
     * @return returns true if the other person is equal to this person otherwise returns false
     */
    public boolean equals(Person other)
    {
        return ( _firstName.equals(other._firstName) && _lastName.equals(other._lastName) && _id == other._id && _dateOfBirth.equals(other._dateOfBirth) );
    }

    /**
     * returns a String that represents this person ("textually represents") in the format: Last Name: Netanyahu, First Name: Binyamin, ID: 123456789, Date of birth: 14/6/2017
     * 
     * @return A String representation of the Person object
     */
    public String toString()
    {
        return "Last Name: " + _lastName + ", " + "First Name: " + _firstName + ", " + "ID: " + _id + ", " + "Date of birth: " + _dateOfBirth;
    }

} // end of Person class