
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

    /**
     * Point Constructor - Constructor for objects of class Point
     * 
     * Time Complexity is O(1). Zero iterations are done
     * Memory Complexity is O(1). The memory complexity is static is not dependent with n or other non static. 
     *
     */
    public Point (double x, double y) // Point Constructor - Regular constructor
    {
        _x = x;
        _y = y;
    }

    /**
     * Point Constructor - Copy constructor, construct a point using another point
     * 
     * Time Complexity is O(1). Zero iterations are done
     * Memory Complexity is O(1). The memory complexity is static is not dependent with n or other non static. 
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
     * Time Complexity is O(1). Zero iterations are done
     * Memory Complexity is O(1). The memory complexity is static is not dependent with n or other non static. 
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
     * Time Complexity is O(1). Zero iterations are done
     * Memory Complexity is O(1). The memory complexity is static is not dependent with n or other non static. 
     *
     * @return - returns the coordinate y of the point
     */
    public double getY()
    {
        return _y;
    }

    /**
     * Method setX - sets the point coordinate of _x to be the new coordinate
     * 
     * Time Complexity is O(1). Zero iterations are done
     * Memory Complexity is O(1). The memory complexity is static is not dependent with n or other non static. 
     * 
     * @param x - The new x coordinate
     */
    public void setX(double x)
    {
        _x = x;
    }

    /**
     * Method setY - sets the point coordinate of _y to be the new coordinate
     * 
     * Time Complexity is O(1). Zero iterations are done
     * Memory Complexity is O(1). The memory complexity is static is not dependent with n or other non static. 
     * 
     * @param y - The new y coordinate
     */
    public void setY(double y)
    {
        _y = y;
    }

    /**
     * Method toString - Returns a string representation of Point ("textually represents") in the format (x,y)
     *
     * Time Complexity is O(1). Zero iterations are done
     * Memory Complexity is O(1). The memory complexity is static is not dependent with n or other non static. 
     *
     * @return A String representation of the Point object
     */
    public String toString()
    {
        return "(" + getX() + "," + getY() + ")"; // "".format("(%f,%f)", _x, _y);
    }

    /**
     * Method equals - Check if the given point is equal to this point
     *          returns true if the other Point has
     *          similar properties as this (instanse) Point otherwise returns false
     *          
     * Time Complexity is O(1). Zero iterations are done
     * Memory Complexity is O(1). The memory complexity is static is not dependent with n or other non static.          
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
     * Time Complexity is O(1). Zero iterations are done
     * Memory Complexity is O(1). The memory complexity is static is not dependent with n or other non static. 
     *
     * @param other - The point to check equality with
     *
     * @return returns true if this point is higher than the other Point otherwise returns false
     */
    public boolean isAbove(Point other)
    {
        return (_y > other._y);
    }

    /** 
     * Method isUnder - Check if the this point is under to given point (formal parameter other)
     *          returns true if this point is lower than the other Point meaning
     *          y coordinate  propertie has lower value otherwise returns false
     * Due to mman instruction and the given limitation "isAbove method is only permitted", The other instance is calling isAbove method and passing (this instance) as parameter.
     * If the other Point is above then this instance (point) must be under and vice versa
     *
     * Time Complexity is O(1). Zero iterations are done
     * Memory Complexity is O(1). The memory complexity is static is not dependent with n or other non static. 
     *
     * @param other - The point to check equality with
     *
     * @return returns true if this point is lower than the other Point otherwise returns false
     */
    public boolean isUnder(Point other)
    {
        return other.isAbove(this);
    }

    /**
     * Method isLeft - Check if the this point is left to given point (formal parameter other)
     *          returns true if this point has lower _x value than the other Point meaning
     *          x coordinate propertie has lower value otherwise returns false
     *
     * Time Complexity is O(1). Zero iterations are done
     * Memory Complexity is O(1). The memory complexity is static is not dependent with n or other non static. 
     *
     * @param other - The point to check equality with
     *
     * @return returns true if the position of this point is before (is to left) relative the other Point otherwise returns false
     */
    public boolean isLeft(Point other)
    {
        return _x < other._x;
    }

    /** 
     * Method isRight - Check if the this point is to the right to given point (formal parameter other)
     *          returns true if this point is "after" than the other Point meaning
     *          x coordinate  propertie has higher value otherwise returns false
     * Due to mman instruction and the given limitation "isLeft method is only permitted", The other instance is calling isLeft method and passing (this instance) as parameter.
     * If the other Point is to Left relative to this instance (point) then this must be to Right and vice versa
     *
     * Time Complexity is O(1). Zero iterations are done
     * Memory Complexity is O(1). The memory complexity is static is not dependent with n or other non static. 
     *
     * @param other - The point to check equality with
     *
     * @return returns true if the position of this point is after (is to right) relative the other Point otherwise returns false
     */
    public boolean isRight(Point other)
    {
        return other.isLeft(this);
    }

    /**
     * Method distance - Check the distance between this point and a given point
     *
     * Time Complexity is O(1). Zero iterations are done
     * Memory Complexity is O(1). The memory complexity is static is not dependent with n or other non static. 
     *
     * @param other - The point to check the distance to
     * 
     * @return The actual distance value ( (y2 - y1)^2 + (x2 - x1)^2 )^1/2 ( ^1/2 = Math.sqrt = ^0.5 = Math.pow(x,0.5) )
     */
    public double distance(Point other)
    {
        return Math.sqrt( (Math.pow( (_y - other._y), 2.0)) + (Math.pow( (_x - other._x), 2.0)) ); // ( (y2 - y1)^2 + (x2 - x1)^2 )^0.5
    }

    /**
     * Method move - Moves a point according to dx and dy formal parameters by invoke setters for _x and _y
     *
     * Time Complexity is O(1). Zero iterations are done
     * Memory Complexity is O(1). The memory complexity is static is not dependent with n or other non static. 
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