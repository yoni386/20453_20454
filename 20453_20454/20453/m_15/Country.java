/**
 * Represents information about a Country Maman15 question1.
 *
 * @author (Yoni Shperling)
 * @version (30.12.18)
 */
public class Country
{
    // instance variables
    private String _countryName; // name of city
    private City[] _cities; // array of cities 
    private int _noOfCities; // number of cities in the country

    // declarations of constants and variables
    private final int MAX_NUM_CITIES = 1000; // used to initialise City array 1000 is instructed by mman
    private final int MIN_NUM_CITIES = 1; // used to initialise _noOfCities with MIN_NUM_CITIES => 0 and to validate cities is not empty 
    // private final int MIN_NUM_RESIDENTS = 0; // used to initialise _noOfCities  with MIN_NUM_CITIES => 0 and to validate cities is not empty
    private final int ZERO = 0; // used to initialise zero value for primitive types (int anddouble) and as basic array refernace array[ZERO] => array[0]
    private final double MIDDLE_DIVIDER = 2.0; // used to calculates the middle between the city center
    private final int ERR_NO = -1; // used to and indicated an error (i.e., -1 from most calls; -1) to caller

    /**
     * Country Constructor
     *
     * @param countryName The name of the country
     */
    public Country(String countryName)
    {
        // initialise instance variables
        _countryName = countryName; // formal parameter countryName is used
        _cities = new City[MAX_NUM_CITIES]; // City Array is initialise MAX_NUM_CITIES->1000
        _noOfCities = ZERO; // _noOfCities->0
    }

    /**
     * Country Constructor Copy constructor, construct a country using another country.
     *
     * @param otherThe country from which to construct the new object
     */
    public Country(Country other) // City Constructor - Copy constructor
    {
        Country newCountry = new Country(other._countryName); // initialise instance

        // initialise instance attributes
        newCountry._noOfCities = other._noOfCities; // sets _noOfCities to other._noOfCities
        newCountry._cities = new City[newCountry._cities.length]; // make new array _cities as other.length (_noOfCities)

        for (int i = 0; i < other._noOfCities; i++) // _noOfCities copy array by index
        {
            newCountry._cities[i] = new City(other._cities[i]); // call copy constractor of City
        }
    }

    /**
     * Method addCity - This method adds new City object to the _cities array. 
     * New City object is constractored with the formal parmameters (descired below).
     * Method must validate that array has enough capacity to add the new elment. 
     * Method returns true on success (addional element, City can be added) and false on falure.
     *
     * @param cityName The name of the city
     * @param cityCenterX The X coordinate of the center point of the city
     * @param cityCenterY The Y coordinate of the center point of the city
     * @param centralStationX The X coordinate of the central station of the city
     * @param centralStationY The Y coordinate of the central station of the city
     * @param numOfResidents The number of residents in the city
     * @param noOfNeighborhoods The number of neighborhoods in the city
     * 
     * @return The returns true on success (addional element, City can be added) and false on falure
     */
    public boolean addCity(String cityName, double xCenter, double yCenter, double xStation, double yStation, long numOfResidents, int noOfNeighborhoods)
    {
        if (_noOfCities == MAX_NUM_CITIES) // validate array capacity will not exceeds internal allocation size. MAX_NUM_CITIES is the maximum array size and _noOfCities is the current used size. _noOfCities should be less than MAX_NUM_CITIES 
        {
            return false; // if (_noOfCities == MAX_NUM_CITIES) meaning internal used array size is equal אם maximum array => violation the array allocation and runtime excletion will probably happened due to this and mman instruction, earily return (return false) need to be called.  
        }

        City newCity = new City(cityName, xCenter, yCenter, xStation, yStation, numOfResidents, noOfNeighborhoods); 
        _cities[_noOfCities] = newCity;
        _noOfCities++; // increment _noOfCities = (_noOfCities + 1)
        return true;  
    }

    /**
     * Method getNumOfResidents - The method getNumOfResidents that returns the total number of residents in the country
     *
     * @return The method getNumOfResidents that returns the total number of residents in the country
     */
    public long getNumOfResidents()
    {
        long totalNumOfResidents = ZERO;

        for (int i = 0; i < _noOfCities; i++)
        {
            totalNumOfResidents += _cities[i].getNumOfResidents();
        }

        return totalNumOfResidents; 
    }

    /**
     * Method longestDistance The method find the longest distance between all the cities of the country.
     *
     * @return The return longest distance between all the cities of the country.
     * If there are less than two cities then zero will be returned otherwise highest distance bwetten all the cities 
     */
    public double longestDistance()
    {
        double tempLongestDistance = ZERO; // compare internal point x->Z x is outter and Z in inner
        double longestDistance = ZERO; // compare outter point X->z X is outter and z in inner 
        double globalLongestDistance = ZERO; // globalLongestDistance < longestDistance if true longestDistance will be used

        if (_noOfCities <= MIN_NUM_CITIES) // if _cities is smaller than two (_noOfCities < 2) true return ZERO
        {
            return globalLongestDistance;
        }

        for (int outer_index = 0; outer_index < _noOfCities; outer_index++)
        {
            for (int inner_index = outer_index+1; inner_index < _noOfCities; inner_index++)
            {
                tempLongestDistance = _cities[outer_index].getCityCenter().distance(_cities[inner_index].getCityCenter());

                if (longestDistance < tempLongestDistance)
                {
                    longestDistance = tempLongestDistance;
                }
            }

            if (globalLongestDistance < longestDistance)
            {
                globalLongestDistance = longestDistance;
            }
        }

        return globalLongestDistance; 
    }

    /**
     * Method toString - String representation of the object. If there no cities then this string is reutnred "There are no cities in this country.".
     * Returns a string representation of this Country ("textually represents") in the format:
     *Cities of Israel :
     *
     *City Name: TelAviv
     *City Center: (10.0,10.0)
     *Central Station: (8.0,8.0)
     *Number of Residents: 10000
     *Number of Neighborhoods: 5
     *
     *City Name: Jerusalem
     *City Center: (3.0,20.0)
     *Central Station: (4.0,18.0)
     *Number of Residents: 20000
     *Number of Neighborhoods: 8
     *
     * @return String representation of the object. If there no cities then this string is reutnred "There are no cities in this country.".
     */
    public String toString()
    {
        if (_noOfCities < MIN_NUM_CITIES) // validiate _noOfCities is 0 if true earily return with the above string otherwise the rest of flow
        {
            return "There are no cities in this country.";
        }

        String citiesString = "Cities of " + getCountryName() + " :"; // the output or the instruction has mistype LiatN confired this can be done with space or without.

        for (int i = 0; i < _noOfCities; i++)
        {
            citiesString += "\n\n" + _cities[i];
        }

        return citiesString;
    }

    /**
     * Method citiesNorthOf - This method generates all the information of the cities which are above the city. 
     * The city (city name) to compare if they are above is set by the the formal parameter (cityName). 
     *
     * @param cityName The name of the city
     * @return The return value
     */
    public String citiesNorthOf(String cityName)
    {
        String citiesNorthOfString; // This string will hold all cities and general output as instructed. 
        City city; // city instanse will be used to clarify code, mainly as this city.
        Point cityCenter;  // point instanse will be used to clarify code, mainly as this point.
        int numberCitiesNorthOf = ZERO; // counter to track valid contion (other cities is under this city).

        city = getCityByName(cityName); // alias in this case is ok city as threated as "immutable"  in the end of the method this will be not used anymore.

        if (city == null) // validites if city can be found. if false => city is null no city with that name was found
        {
            return "There is no city with the name " + cityName; // returns string to "bad" condtion as instructed.
        }

        citiesNorthOfString = "The cities north of " + city.getCityName() + " are:";

        cityCenter = city.getCityCenter(); 

        for (int i = 0; i < _noOfCities; i++)
        {
            Point otherCityCenter = _cities[i].getCityCenter();

            if (!(cityCenter.equals(otherCityCenter))) // validate pointers are not equal. In-genral this can be skipped but if above instruction is "expensive" then no point to check if isUnder if they known as equal 
            {
                if (cityCenter.isUnder(otherCityCenter)) // validate this pointer formal parameter (cityName) this city isUnder
                {
                    citiesNorthOfString += "\n\n" + _cities[i]; // adds (overwritte string is immutable) _cities[i] (_cities[i]toString()) to the variable. 
                    numberCitiesNorthOf++; // increment counter to track valid contion (numberCitiesNorthOf != 0)
                }
            }
        }

        if (numberCitiesNorthOf == ZERO) // validate counter used to track if this city has no cities above it. 
        {
            citiesNorthOfString = "There are no cities north of " + cityName;  // resets string to "bad" condtion as instructed 
        }

        return citiesNorthOfString; // return string. at this point must be initialized
    }

    /**
     * Method southernmostCity - This method returns the southern (lowest) city most in the country. 
     * If there are less than two cities, null will be returned otherwise returns the southern (lowest) city.
     * 
     * southernmostCity should be southernMostCity but ChenU instructed to keep as is for the sake of compilation correction
     * 
     * @returns the southern (lowest) city If there less than two cities (_noOfCities is less 2 => 1 or less) returns null.
     */
    public City southernmostCity()
    {
        City city = null;

        if (_noOfCities <= MIN_NUM_CITIES)
        {
            return city; // return null (city = null)
        }

        city = _cities[ZERO]; 

        for (int i = 1; i < _noOfCities; i++)
        {
            if (_cities[i].getCityCenter().isUnder(city.getCityCenter()))
            {
                city = _cities[i];
            }
        }

        return city;
    }

    /**
     * Method getCountryName Returns the name of the country.
     *
     * @return The name of the country
     */
    public String getCountryName()
    {
        return _countryName;
    }

    /**
     * Method getNumOfCities Returns the number of the cities in the country.
     *
     * @return the number of the cities in the country
     */
    public int getNumOfCities()
    {
        return _noOfCities;
    }

    /**
     * Method getCities Returns new array with the length of the _cities array. 
     * All the elements must contain copies of cities country (original elements of_cities) _noOfCities.
     *
     * @return Returns new array with the length of the _noOfCities _cities array, all the elements are copies.
     */
    public City[] getCities()
    {
        City[] cities = new City[_noOfCities]; // make new array cities length as _noOfCities this._noOfCities

        for (int i = 0; i < _noOfCities; i++) // iterate all index (valid cities)->_noOfCities and copy the city element by index to the newly created array
        {
            cities[i] = new City(_cities[i]); // call copy constractor of City
        }

        return cities; 
    }

    /**
     * Method unifyCities The method accepts two names of cities and unified it according to the following way:
     * The unification of the name will be a combination of the names of the two names of the cities, and between them the character "-" will be added, for example the name of the united city will be "city1-city2".
     * The number of residents in the shared city is the sum of the population.
     * The number of neighborhoods in a common city is the sum of neighborhoods.
     * The location of the new city center is halfway (in the middle) between the two city centers, and the location of the central bus station is at the western station between the two (left).
     * The method will remove the smaller city from the array (if the number of residents in the two cities are the same, city2 will be removed).
     * The new city (the union of the two cities) will be written in the index location where is the larger city (the number of residents was higher).
     *
     * @param cityName1 the name of the first city to merge with
     * @param cityName2 the name of the second city to merge with
     * 
     * @returns new city merged by the two cities which passed by name (cityName1 and cityName2), the names are the cities passed in the formal parameters. unifyCities merge is done by the above logic.
     */
    public City unifyCities(String cityName1, String cityName2)
    {
        City city1, city2, unifiedCity; // used to hold the current cities and new merged city from city1 qnd city2
        String newCityName; // used to hold the name of city
        double newCentralStationX, newCentralStationY, newCityCenterX, newCityCenterY; // used to hold staion and center coordinates (X,Y) 
        long newNumOfResidents; // used to hold the new number of residents
        int newNoOfNeighborhoods; // used to hold bew number of neighborhoods
        int indexToOverWrite, indexToRemove;  // this will be as refernace index to reassign and remove (pop) the city from the _cities array and to swap (OverWrite)

        // the below (getCityByName method) can return null pointer but acording the mman instruction city name must must be in the array. No error handle was instructed to be done. 
        city1 = getCityByName(cityName1); // alias in this case is ok city as threated as "immutable" in the end of the method this will be not used anymore.
        city2 = getCityByName(cityName2); // alias in this case is ok city as threated as "immutable" in the end of the method this will be not used anymore.

        if (city1 != null || city2 != null) // validite if city is not null if it is do nothing. No error handle was instructed 
        {
            // do nothing should return but 
        }

        newCityName = city1.getCityName() + "-" + city2.getCityName(); // new name city is set String of city1 and city2 will be "city1-city2"

        newNumOfResidents = city1.getNumOfResidents() + city2.getNumOfResidents(); // setting newNumOfResidents 

        newNoOfNeighborhoods = city1.getNoOfNeighborhoods() + city2.getNoOfNeighborhoods(); // setting newNoOfNeighborhoods 

        newCityCenterX = calcMiddle(city1.getCityCenter().getX(), city2.getCityCenter().getX()); // calculates the middle between the city center
        newCityCenterY = calcMiddle(city1.getCityCenter().getY(), city2.getCityCenter().getY()); // calculates the middle between the city center

        if (city1.getCentralStation().isLeft(city2.getCentralStation())) // check which between the central stations is more western (left)
        {
            newCentralStationX = city1.getCentralStation().getX();
            newCentralStationY = city1.getCentralStation().getY();
        }
        else
        {
            newCentralStationX = city2.getCentralStation().getX();
            newCentralStationY = city2.getCentralStation().getY();
        }

        if (city1.getNumOfResidents() >= city2.getNumOfResidents()) // used to find which city to remove and swap with
        {
            indexToOverWrite = getCity(city1); // used to swap with
            indexToRemove = getCity(city2); // used to remove
        }
        else 
        {
            indexToOverWrite = getCity(city2); // used to swap with
            indexToRemove = getCity(city1); // used to remove
        }

        unifiedCity = new City(newCityName, newCityCenterX, newCityCenterY, newCentralStationX, newCentralStationY, newNumOfResidents, newNoOfNeighborhoods); // calling contractor new city (unified) instance is created

        _cities[indexToOverWrite] = unifiedCity; // reassign unifiedCity to index indexCityToPop in array _cities => _cities[indexCityToPop]->unifiedCity

        for (int outer_index = indexToRemove; outer_index < _noOfCities; outer_index++) // shift left, this remove "elected element city". Elected / designated Either is smallest or if they are equal then the second city (city2) will be removed
        {

            for (int inner_index = outer_index; inner_index < _noOfCities-1; inner_index++)
            {
                _cities[inner_index] = _cities[inner_index+1];
            }

            //house cleanup decrement internal "length" _noOfCities->_noOfCities-- and last duplicate due the shiftLeft is cleaned (_cities[_noOfCities] = null)
            _noOfCities--; // decrement internal "length" used to keep internal tracking updates which is the last element (valid cities) due the shiftleft the are two last elements as "duplicates" - later will be handled
            _cities[_noOfCities] = null; // set and assign the last element to null. The last elements hold the same data, this clean last index, (index-1) e.g. 75 and 76 has same data index 76 need to be set to null
        }

        return unifiedCity;
    }

    private double calcMiddle(double x1, double x2) // this is used as helper method, calculates the middle between the city center (x1+x2) / 2.0
    {
        return ( (x1 + x2) / MIDDLE_DIVIDER );
    }

    private City getCityByName(String cityName) // this is used as helper method to find the city and return it from the array. Error handle is poor due missing mman requirements
    {
        City city = null;
        for (int i = 0; i < _noOfCities; i++)
        {
            if (_cities[i].getCityName().equals(cityName))
            {
                city = _cities[i]; // alias is ok in the end of the loop this will be not used anymore.
                return city;
            }
        }

        return city;
    }

    private int getCity(City city) // this is used as helper method to find the city and return it from the array. Error handle is poor due missing mman requirements
    {
        {
            int index = ERR_NO; // ERR_NO = -1
            for (int i = 0; i < _noOfCities; i++)
            {
                //if (_cities[i] == city) // this compares the memory address and not the data it self. This is as threated as "immutable" city is not changed so alias can be done. 
                if (isEquals(_cities[i], city)) // instead of compares the memory compare objects
                {
                    index = i;
                    return index;
                }
            }

            return index;
        }
    }

    private static boolean isEquals(City city1, City city2) // this internal method is used instead to check and compare if objects memory point to the same address as instructed by man
    {
        return 
        (
            (city1.getCityName().equals(city2.getCityName())) &&               // this verifies if both strings are equal
            (city1.getCityCenter().equals(city2.getCityCenter())) &&           // this verifies if both CityCenter points are equal
            (city1.getCentralStation().equals(city2.getCentralStation())) &&  //  this verifies if both CentralStation points are equal
            (city1.getNumOfResidents() == city2.getNumOfResidents()) &&      //   this verifies if both NumOfResidents long are equal
            (city1.getNoOfNeighborhoods() == city2.getNoOfNeighborhoods())  //    this verifies if both NoOfNeighborhoods int are equal
        );
    }

}
