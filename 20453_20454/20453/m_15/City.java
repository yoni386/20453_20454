/**
 * Represents information about a city Maman14 question2.
 *
 * @author (Yoni Shperling)
 * @version (21.12.18)
 */
public class City
{
    // instance variables
    private String _cityName; // name of city
    private Point _cityCenter; // Point object center of this City
    private Point _centralStation; // Point object of central Station of this City
    private long _numOfResidents; // number of residents - must be >= 0
    private int _noOfNeighborhoods; // number of neighborhoods - must be >= 1

    // declarations of constants and variables
    public final int MIN_NEIGBORHOODS = 1;
    public final long MIN_RESIDENTS = 0;

    /**
     * Construct a new city with the specified info. If numOfResidents is smaller than MIN_RESIDENTS, MIN_RESIDENTS is used. 
     * If noOfNeighborhoods is smaller than MIN_NEIGBORHOODS, MIN_NEIGBORHOODS is used. If any coordinate is negative - 0 is used instead. Validate coordinate are done by Point.
     *
     * @param cityName The name of the city
     * @param cityCenterX The X coordinate of the center point of the city
     * @param cityCenterY The Y coordinate of the center point of the city
     * @param centralStationX The X coordinate of the central station of the city
     * @param centralStationY The Y coordinate of the central station of the city
     * @param numOfResidents The number of residents in the city
     * @param noOfNeighborhoods The number of neighborhoods in the city
     */
    public City(String cityName, double cityCenterX, double cityCenterY, double centralStationX, double centralStationY, long numOfResidents, int noOfNeighborhoods) // City Constructor - Regular constructor
    {
        if (numOfResidents < MIN_RESIDENTS) // validate numOfResidents is negative (numOfResidents < 0.0) if true, numOfResidents is initialise with default value of 0 = MIN_RESIDENTS otherwise formal parameter (numOfResidents) is used 
        {
            numOfResidents = MIN_RESIDENTS;
        }

        if (noOfNeighborhoods < MIN_NEIGBORHOODS) // validate noOfNeighborhoods is negative (noOfNeighborhoods <= 0.0) if true, noOfNeighborhoods is initialise with default value of 1 = MIN_NEIGBORHOODS otherwise formal parameter (noOfNeighborhoods) is used
        {
            noOfNeighborhoods = MIN_NEIGBORHOODS;
        }

        // initialise instance variables
        _cityName = cityName;
        _cityCenter = new Point(cityCenterX, cityCenterY);
        _centralStation = new Point(centralStationX, centralStationY);
        _numOfResidents = numOfResidents;
        _noOfNeighborhoods = noOfNeighborhoods;
    }

    /**
     * City Constructor Copy constructor, construct a city using another city.
     *
     * @param otherThe city from which to construct the new object
     */
    public City(City other) // City Constructor - Copy constructor
    {
        this(other.getCityName(), other.getCityCenter().getX(), other.getCityCenter().getY(), other.getCityCenter().getX(), other.getCityCenter().getY(), other.getNumOfResidents(), other.getNoOfNeighborhoods()); // String is immutable, safe to copy
    }

    /**
     * Method getCityName Returns the name of the city.
     *
     * @return The name of the city
     */
    public String getCityName()
    {
        return _cityName;
    }

    /**
     * Method getCityCenter Returns the center of the city as a Point object.
     *
     * @return The center point of the city
     */
    public Point getCityCenter()
    {
        return new Point(_cityCenter);
    }

    /**
     * Method getCentralStation Returns the centeral station of the city as a Point object.
     *
     * @return The central station of the city
     */
    public Point getCentralStation()
    {
        return new Point(_centralStation);
    }

    /**
     * Method getNumOfResidents Returns the number of residents of the city.
     *
     * @return The number of residents of the city
     */
    public long getNumOfResidents()
    {
        return _numOfResidents;
    }

    /**
     * Method getNoOfNeighborhoods Returns the number of neighborhoods of the city.
     *
     * @return The number of neighborhoods of the city
     */
    public int getNoOfNeighborhoods()
    {
        return _noOfNeighborhoods;
    }

    /**
     * Method setCityName Sets the name of the city.
     *
     * @param cityName The new name of the city
     */
    public void setCityName(String cityName)
    {
        _cityName = cityName;
    }

    /**
     * Method setCityCenter Sets the center point of the city.
     *
     * @param cityCenter The new center point of the city
     */
    public void setCityCenter(Point cityCenter)
    {
        _cityCenter = new Point(cityCenter);
    }

    /**
     * Method setCentralStation Sets the central station point of the city.
     *
     * @param centralStation The new central station point of the city
     */
    public void setCentralStation(Point centralStation)
    {
        _centralStation = new Point(centralStation);
    }

    /**
     * Method setNumOfResidents Sets the number of residents of the city, but only if it is bigger or equal to MIN_RESIDENTS.
     *
     * @param numOfResidents The new number of residents in the city
     */
    public void setNumOfResidents(long numOfResidents)
    {
        if (numOfResidents >= MIN_RESIDENTS)
        {
            _numOfResidents = numOfResidents;
        }
    }

    /**
     * Method setNoOfNeighborhoods Sets the number of neighborhoods of the city, but only if it is bigger or equal to MIN_NEIGBORHOODS.
     *
     * @param noOfNeighborhoods The new number of neighborhoods in the city
     */
    public void setNoOfNeighborhoods(int noOfNeighborhoods)
    {
        if (noOfNeighborhoods >= MIN_NEIGBORHOODS)
        {
            _noOfNeighborhoods = noOfNeighborhoods;
        }
    }

    /**
     * Method toString Returns a string representation of this City ("textually represents") in the format
     * 
     * City Name: Tel Sharon
     * City Center: (100.0,150.0)
     * Central Station: (45.0,36.0)
     * Number of Residents: 450
     * Number of Neighborhoods: 10
     *
     * @return a String representation of the object.
     */
    public String toString()
    {
        return "City Name: " + getCityName() + "\nCity Center: " + getCityCenter() + "\nCentral Station: " + getCentralStation() + "\nNumber of Residents: " + getNumOfResidents() + "\nNumber of Neighborhoods: " + getNoOfNeighborhoods();
    }

    /**
     * Method addResidents Adds the given number of residents - either positive or negative number - to the city. 
     * If the resulted number of residents is smaller than MIN_RESIDENTS, MIN_RESIDENTS is set to be the new number of residents of the city, and false is returned. 
     * Otherwise (i.e. the resulted number is bigger or equal to MIN_RESIDENTS), true is returned.
     * 
     * @param residentsUpdate parameter long updates the _numOfResidents
     * 
     * @return a boolean false if resulted number of residents is smaller than MIN_RESIDENTS, true otherwise
     */ 
    public boolean addResidents(long residentsUpdate)
    {
        long newNumOfResidents = getNumOfResidents() + residentsUpdate; // / current numOfResidents + residentsUpdate == new numOfResidents

        if (newNumOfResidents < MIN_RESIDENTS) // validate new numOfResidents (newNumOfResidents) is valid (newNumOfResidents < 0) if true _numOfResidents=MIN_RESIDENTS=>0 and returns false otherwise return true and set _numOfResidents to be formal parameter newNumOfResidents
        {
            setNumOfResidents(MIN_RESIDENTS);
            return false;
        }
        else // at this point no need for the else. The code flow can run the same without else (due the "early return" in if). For code clarity and if later logic will be changed return will be changed or removed else is added.
        {
            setNumOfResidents(newNumOfResidents);
            return true;
        }
    }

    /**
     * Method moveCentralStation Move the location of the central station of the city with the given deltas. 
     * If the new location has a negative coordinate - the central station keeps its original location.
     * 
     * @param deltaX How much the x coordinate of the central station of the city is to be moved
     * @param deltaY How much the y coordinate of the central station of the city is to be moved
     */
    public void moveCentralStation(double deltaX, double deltaY)
    {
        getCentralStation().move(deltaX, deltaY);
    }

    /**
     * Method distanceBetweenCenterAndStation - Calculates the distance between the center of this city and its central station.
     *
     * @return The distance between the center of this city and its central station
     */
    public double distanceBetweenCenterAndStation()
    {
        return getCityCenter().distance(getCentralStation());
    }

    /**
     * Method newCity Creates a new city with a new name, and where its center and central station are moved by the given deltas from this city. If either new point has negative coordinates - it gets the center or central station of this city. 
     * Its number of residents is set to MIN_RESIDENTS and its number of neightborhoods is set to MIN_NEIGBORHOODS.

     * @param newCityName The name of the new city
     * @param dx How much the x coordinates of the city's center and central station are to be moved for the new city
     * @param dy How much the y coordinates of the city's center and central station are to be moved for the new city
     * 
     * @return TA new city with the given values
     */
    public City newCity(String newCityName, double dX, double dY)
    {
        City newCity = new City(newCityName, getCityCenter().getX(), getCityCenter().getY(), getCentralStation().getX(), getCentralStation().getY(), MIN_RESIDENTS, MIN_NEIGBORHOODS); // Instead of this, copy constructor could be used but this is shorter 

        newCity.getCityCenter().move(dX, dY); // move CityCenter point to new (dX, dY) coordinates City->Point->CityCenter. If new coordinates delta are invalid, move will not be done
        newCity.getCentralStation().move(dX, dY); // move CentralStation point to new (dX, dY) coordinates City->Point->CentralStation. If new coordinates delta are invalid, move will not be done

        return newCity;
    }
}
