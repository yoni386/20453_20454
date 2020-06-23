/**
 * Represents Date class Maman11 question1.
 *
 * @author (Yoni Shperling)
 * @version (09.03.20)
 */
public class Date
{
    // instance variables
    private int _day;   // valid value is between 1-31
    private int _month; // valid value is between 1-12
    private int _year;  // valid value is 1000 or higher four digits 

    private static final int MIN_DAY = 1;
    private static final int MAX_DAY = 31;
    private static final int MIN_YEAR = 999;
    private static final int DEFAULT_YEAR = 2000;

    public static final int MIN_MONTH = 1; // minimum value for month. According to Hen, public access is preferred avoid duplicates
    public static final int MAX_MONTH = 12; // maximum value for month.  According to Hen, public access is preferred avoid duplicates

    //constructors
    /**
     * creates a new Date object if the date is valid, otherwise creates the date 1/1/2000
     * @param day The day of the date
     * @param month The month of the date
     * @param year The year of the date
     */
    public Date(int day, int month, int year) 
    {
        if (!dateIsValid(day, month, year))
        {
            day = MIN_DAY;
            month = MIN_MONTH;
            year = DEFAULT_YEAR; 
        }
        // initialise instance variables
        _day = day;
        _month = month;
        _year = year;
    }

    /**
     * copy constructor
     * @param other The date from which to construct the new object
     */
    public Date(Date other)
    {
        this(other._day, other._month, other._year);
    }

    /**
     * gets the Day
     * 
     * @return returns the day the date
     */
    public int getDay()
    {
        return _day;
    }

    /**
     * gets the month
     * 
     * @return returns the month the date
     */
    public int getMonth()
    {
        return _month;
    }

    /**
     * gets the year
     * 
     * @return returns the year the date
     */
    public int getYear()
    {
        return _year;
    }

    /**
     * sets the day (only if day remains valid otherwise does nothing)
     * @param dayToSet The new day of the date
     */
    public void setDay(int dayToSet)
    {
        if (validateDay(dayToSet))
        {
            _day = dayToSet;
        }
    }

    /**
     * set the month (only if month remains valid otherwise does nothing)
     * @param monthToSet The new month of the date
     */
    public void setMonth(int monthToSet)
    {
        if (validateMonth(monthToSet))
        {
            _month = monthToSet;
        }

    }

    /**
     * sets the year (only if year remains valid otherwise does nothing)
     * @param yearToSet The new year of the date
     */
    public void setYear(int yearToSet)
    {
        if (validateYear(yearToSet))
        {
            _year = yearToSet;
        }
    }

    /**
     * check if 2 dates are the same
     * @param other The date to check equality with
     * @return returns true if the other Date is equal to this date otherwise returns false
     */
    public boolean equals(Date other)
    {
        return ( (_day == other._day) && (_month == other._month) && (_year == other._year) );
    }

    /**
     * check if this date is before other date
     * @param other The date to check if this date is before
     * @return a boolean - True if this date is before the other point
     */
    public boolean before(Date other)
    {
        boolean isBefore = false; // boolean flag to mark if this instance Date is before other (formal parameter) instance Date

        if (_year < other._year) // if this._year < other._year  isBefore->true
        {
            isBefore = true;
        }

        else if (_year == other._year && _month < other._month) // if years are identical and this._month < other._month isBefore->true 
        {
            isBefore = true;
        }

        else if (_year == other._year && _month == other._month && _day < other._day) // isBefore->true if years, months are identical and this._day < other._day
        {
            isBefore = true;
        }
        return isBefore; 
    }

    /**
     * check if this date is after other date
     * @param other The date to check if this date is after
     * @return a boolean - True if this date is after the other point
     */
    public boolean after(Date other)
    {   
        return !before(other); 
    }

    /**
     * returns a String that represents this date
     *
     * @return A String representation of the Date object
     */
    public String toString()
    {
        return _day + "/" + _month + "/" + _year; // e.g. 14/6/2017

    }

    private static boolean dateIsValid(int day, int month, int year)
    {   
        return ( (validateDay(day)) && (validateMonth(month)) && (validateYear(year)) );
    }

    private static boolean validateDay(int day)
    {   
        return ( (day >= MIN_DAY) && (day <= MAX_DAY) );
    }

    private static boolean validateMonth(int month) 
    {   
        return ( (month >= MIN_MONTH) && (month <= MAX_MONTH ));
    }

    private static boolean validateYear(int year)
    {   
        return (year > MIN_YEAR);
    }
} // end of Date class
