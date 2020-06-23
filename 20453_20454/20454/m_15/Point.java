/**
 * Represents Ex15 class Maman15 question1
 *
 * @author (Yoni Shperling)
 * @version (16.07.20)
 */

public class Point
{
    // instance variables
    private double _x;
    private double _y;

    // declarations of constants and variables
    private final static double ZERO = 0.0; // used to validate value is postive. Acording to HenU, in this case postive n => 0 Point.x or Point.y are not zero mainly p
    private final static double TWO = 2.0;

    /**
     * Point Constructor - Constructor for objects of class Point
     */
    public Point (double x, double y) // Point Constructor - Regular constructor
    {
        _x = x;
        _y = y;
    }

    /**
     * Point Constructor - Copy constructor, construct a point using another point.
     *
     * @param other - The point from which to construct the new object
     */
    public Point(Point other) // Point Constructor - Copy constructor
    {
        this(other._x, other._y);
    }

    // getters and setters

    /**
     * Method getX - This method returns the x coordinate of the point
     *
     * @return - returns the coordinate x of the point
     */
    public double getX()
    {
        return _x;
    }

    /**
     * Method getY - This method returns the y coordinate of the point
     *
     * @return - returns the coordinate y of the point
     */
    public double getY()
    {
        return _y;
    }

    /**
     * Method setX - sets the point coordinate of _x to be the new coordinate
     * @param x - The new x coordinate
     */
    public void setX(double x)
    {
        _x = x;
    }

    /**
     * Method setY - sets the point coordinate of _y to be the new coordinate
     * @param y - The new y coordinate
     */
    public void setY(double y)
    {
        _y = y;
    }

    /**
     * Method toString - Returns a string representation of Point ("textually represents") in the format (x,y)
     *
     * @return A String representation of the Point object
     */
    public String toString()
    {
        return "("+getX()+","+getY()+")"; // "".format("(%f,%f)", _x, _y);
    }

    /**
     * Method equals - Check if the given point is equal to this point
     *          returns true if the other Point has
     *          similar properties as this (instanse) Point otherwise
     *          returns false
     *
     * @param other - The point to check equality with
     *
     * @return returns true if the other Point is equal to this point otherwise returns false
     */
    public boolean equals(Point other)
    {
        return ( (_x == other._x) && (_y == other._y) );
    }

    /**
     * Method isAbove - Check if the this point is above to given point (formal parameter other)
     *          returns true if this point is higher than the other Point meaning
     *          y coordinate propertie higher has higher value otherwise returns false
     *
     * @param other - The point to check equality with
     *
     * @return returns true if this point is higher than the other Point otherwise returns false
     */
    public boolean isAbove(Point other)
    {
        return (_y > other._y);
    }

    /** *API need to be adujsted*
     * Method isUnder - Check if the this point is above to given point (formal parameter other)
     *          returns true if this point is higher than the other Point meaning
     *          y coordinate  propertie higher has higher value otherwise returns false
     *
     * @param other - The point to check equality with
     *
     * @return returns true if this point is higher than the other Point otherwise returns false
     */
    public boolean isUnder(Point other)
    {
        return other.isAbove(this);
    }

    /** *API need to be adujsted*
     * Method isLeft - Check if the this point is above to given point (formal parameter other)
     *          returns true if this point is higher than the other Point meaning
     *          y coordinate  propertie higher has higher value otherwise returns false
     *
     * @param other - The point to check equality with
     *
     * @return returns true if this point is higher than the other Point otherwise returns false
     */
    public boolean isLeft(Point other)
    {
        return _x < other._x;
    }

    /** *API need to be adujsted*
     * Method isRight - Check if the this point is to right to given point (formal parameter other)
     *          returns true if this point is higher than the other Point meaning
     *          y coordinate  propertie higher has higher value otherwise returns false
     *
     * @param other - The point to check equality with
     *
     * @return returns true if this point is higher than the other Point otherwise returns false
     */
    public boolean isRight(Point other)
    {
        return other.isLeft(this);
    }

    /**
     * Method distance - Check the distance between this point and a given point
     *
     * @param other - The point to check the distance from
     * @return The distance
     */
    public double distance(Point other)
    {
        return Math.sqrt( (Math.pow( (_y - other._y), TWO)) + (Math.pow( (_x - other._x), TWO)) ); //
        //        return Math.sqrt( (Math.pow( (other._y  - _y), TWO)) + (Math.pow( (other._x - _x), TWO)) ) ; //
    }

    /**
     * Method move - Moves a point. If either coordinate becomes negative the point remains unchanged
     *
     * @param dx - The difference to add to x
     * @param dy - The difference to add to y
     */
    public void move(double dx, double dy)
    {
        setX(_x + dx); // set x coordinate to new coordinate
        setY(_y + dy); // set y coordinate to new coordinate
    }

}