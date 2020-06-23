
/**
 * class Pen describes a Pen.
 *
 * @author (Yoni Shperling)
 * @version (7.12.18)
 */
public class Pen
{
    // instance variables
    private String _color;
    private String _made;
    private int _price;
    private double _weight;

    // declarations of constants and variables
    final String COLOR_BLUE = "blue";
    final double WEIGHT_DEFAULT_VALUE = 10.0; // used to initialize weight if (weight is <= 0.0) if not then constants is not used
    final double ZERO = 0.0; // used to validate weight is (weight <= 0.0) if true weight = WEIGHT_DEFAULT_VALUE (weight=10.0)
    final int PRICE_DEFAULT_VALUE = 10; // used to initialize price=10 if (price is < 1) if not then constants is not used
    final int ONE = 1; // used to validate price, mainly price is not zero

    /**
     * Pen Constructor - constructor for objects of Pen
     *
     * @param color String parameter
     * @param made String parameter
     * @param price int parameter
     * @param weight double parameter
     */
    public Pen(String color, String made, int price, double weight)
    {
        if (weight <= ZERO) // validate weight is zero or negative (weight <= 0.0) if true, weight assigned with default value of 10.0 = WEIGHT_DEFAULT_VALUE (weight=10.0) otherwise formal parameter (weight) is used 
        {
            weight = WEIGHT_DEFAULT_VALUE; // weight=10.0
        }

        if (price < ONE) // validate price is zero or negative (price is < 1) if true, price assigned with a default value of 10 price = PRICE_DEFAULT_VALUE (price=10) otherwise formal parameter (price) is used 
        {
            price = PRICE_DEFAULT_VALUE; // price=10
        }

        _color = color;   // initialize _color (this._color) to formal color parameter 
        _made = made;     // initialize _made (this._made) to formal made parameter 
        _price = price;   // initialize _price (this._price) to formal price parameter 
        _weight = weight; // initialize _weight (this._weight) to formal weight parameter 
    }

    /**
     * Method getColor  - returns the pen color
     *
     * @return a String - returns the color of the pen
     */
    public String getColor()
    {
        return _color;
    }

    /**
     * Method getMade    - returns the pen made
     *
     * @return a String  - returns the made value of the pen
     */
    public String getMade()
    {
        return _made;
    }

    /**
     * Method getPrice - returns the pen price
     *
     * @return a int   - returns the price of the pen
     */
    public int getPrice()
    {
        return _price;
    }

    /**
     * Method getWeight - returns the pen weight
     *
     * @return a double - returns the weight of the pen
     */
    public double getWeight()
    {
        return _weight;
    }

    /**
     * Method isBluePen  - returns true if Pen color propertie has a blue color otherwise return false
     * 
     * @return a boolean - returns true if Pen color propertie has a blue color otherwise return false
     */
    public boolean isBluePen()
    {
        return getColor().equals(COLOR_BLUE);
    }

    /**
     * Method isSameMade - returns true if the other Pen has the same made propertie as this (instanse) Pen otherwise return false

     *
     * @param other A parameter Pen object
     * @return a boolean - returns true if the other Pen has the same made propertie as this Pen (instanse) otherwise return false
     */
    public boolean isSameMade(Pen other)
    {
        return getMade().equals(other.getMade());
    }

    /**
     * Method isSamePrice - returns true if the other Pen has the same price propertie as this (instanse) Pen otherwise return false

     *
     * @param other A parameter Pen object
     * @return a boolean - returns true if the other Pen has the same price propertie as this (instanse) Pen otherwise return false
     */
    public boolean isSamePrice(Pen other)
    {
        return _price == other.getPrice();
    }

    /**
     * Method setPrice - updates the pen price of x to be the new price. if x is positive (price >= 1) set _price to formal parameter x _price=x otherwise do nothing
     *
     * @param x the new price of the pen
     */
    public void setPrice(int x)
    {
        if (x >= ONE)
        {
            _price = x;
        }
    }

    /**
     * Method toString - returns a string that represents the Pen object ("textually represents")
     *
     * @return a String representation of the object.
     */
    public String toString()
    {
        // string output example "red pen, made by Pilot, weights 10.0 grams, price: 5 Shekels"
        return getColor() + " pen, made by " + getMade() + ", weights " + getWeight() + " grams, price: " + getPrice() + " Shekels";
    }

} // end of class Pen

