/**
  * class Point describes a Point. 
  * Represents 2 dimensional points. Maman14 question1
  *
  * @author (Yoni Shperling)
  * @version (21.12.18)
  */
 public class Point
 {
     // instance variables
     private double _radius;
     private double _alpha;

     // declarations of constants and variables
     private final static double ZERO = 0.0; // used to validate value is postive. Acording to HenU, in this case postive n => 0 Point.x or Point.y are not zero mainly p
     private final static double TWO = 2.0;
     private final static int TEN_K = 10000;
     private final static double PI_RADIANS = 180.0; // Pi radians is equal to 180 degrees:

     /**
      * Point Constructors - Constructor for objects of class Point
      */
     public Point(double x, double y) // Point Constructor - Regular constructor
     {
         x = validateZero(x); // validate x is negative (x < 0.0) if true, x is initialise with default value of 0.0 = ZERO (x=0.0) otherwise formal parameter (x) is used 
         y = validateZero(y); // validate x is negative (y < 0.0) if true, y is initialise with default value of 0.0 = ZERO (y=0.0) otherwise formal parameter (y) is used 

         // initialise instance variables
         _radius = calculateRadius(x, y);
         _alpha = calculateAlpha(x, y);
     }

     /**
      * Point Constructors - Copy constructor, construct a point using another point.
      *
      * @param other - The point from which to construct the new object
      */
     public Point(Point other) // Point Constructor - Copy constructor
     {
         this(other.getX(), other.getY());
     }

     /**
      * Method getX - This method returns the x coordinate of the point
      *
      * @return - returns the coordinate x of the point
      */
     public double getX()
     {
         return customRoundHelper( _radius * Math.cos(internalToRadians()) ); // customRoundHelper() is a helper method to round the value
     }

     /**
      * Method getY This method returns the y coordinate of the point.
      *
      * @return - returns the coordinate y of the point
      */
     public double getY()
     {
         return customRoundHelper( _radius * Math.sin(internalToRadians()) ); // customRoundHelper() is a helper method to round the value
     }

     /** 
      * Method setX - sets the point coordinate of _x to be the new coordinate. if num is positive (num > 0.0) set _x to formal parameter num to _x=num otherwise do nothing
      *
      * @param x - The new x coordinate
      */
     public void setX(double num)
     {
         if (num >= ZERO)
         {
             calculateRadiusAlpha(num, getY());
         }
     }

     /**
      * Method setY - sets the point coordinate of _y to be the new coordinate. if num is positive (num > 0.0) set _y to formal parameter num to _y=num otherwise do nothing
      *
      * @param ny - The new y coordinate
      */
     public void setY(double num)
     {
         if (num >= ZERO)
         {
             calculateRadiusAlpha(getX(), num);
         }
     }

     /**
      * Method toString - Returns a string representation of Point ("textually represents") in the format (x,y)
      *
      * @return A String representation of the Point object
      */
     public String toString()
     {
         return "("+getX()+","+getY()+")";
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
         return ( (getX() == other.getX()) && (getY() == other.getY()) );
     }

     /**
      * Method isAbove - Check if this point is above a received point
      *
      * @param other - The point to check if this point is above
      * @return a boolean - True if this point is above the other point
      */
     public boolean isAbove(Point other)
     {
         return (getY() > other.getY()); // validiates (_y > other._y) returns true if the this Point._y (_y) is above (_y > other._y) the other other._y instanse otherwise return false
     }

     /**
      * Method isUnder - Check if this point is below a received point
      *
      * @param other - The point to check if this point is below
      * @return True if this point is below the other point
      */
     public boolean isUnder(Point other)
     {
         return other.isAbove(this); // validiates this._y (_y) is below other_.y or => (other._y > _y) (_y < other._y) by calling isAbove() on the other instanse 
     }

     /**     
      * Method isLeft - Check if this point is left of a received point
      *
      * @param other - The point to check if this point is left of
      * @return a boolean - True if this point is left of the other point
      */
     public boolean isLeft(Point other)
     {
         return (getX() < other.getX()); // returns true if the Point._x (_x) is left (_x < other._x) to the other Point._x instanse otherwise return false
     }

     /**
      * Method isRight - Check if this point is right of a received point
      *
      * @param other - The point to check if this point is right of
      * @return True if this point is right of the other point
      */
     public boolean isRight(Point other)
     {
         return other.isLeft(this); // returns true if the Point._x (_x) is right (_x > other._x) == calling !isLeft(other); the other Point._x instanse otherwise return false
     }

     /**
      * Method distance - Check the distance between this point and a given point
      *
      * @param other - The point to check the distance from
      * @return The distance
      */
     public double distance(Point other)
     {
         return customRoundHelper(Math.sqrt( (Math.pow( (getY() - other.getY()), TWO)) + (Math.pow( (getX() - other.getX()), TWO)) ) ); // customRoundHelper() is a helper method to round the value
     }

     /**
      * Method move - Moves a point. If either coordinate becomes negative the point remains unchanged
      *
      * @param dx - The difference to add to x
      * @param dy - The difference to add to y
      */
     public void move(double dx, double dy)
     {
         double newXCoordinate = getX() + dx; // current x coordinate + dx == new x coordinate
         double newYCoordinate = getY() + dy; // current y coordinate + dy == new y coordinate

         if ( (newXCoordinate >= ZERO) && (newYCoordinate >= ZERO) ) // validate new coordinates are valid >=0. Move will be done only if newXCoordinate && newYCoordinate ( (x, y coordinates) >= ZERO(0) ) 
         {
             setX(newXCoordinate); // set x coordinate to new coordinate newXCoordinate
             setY(newYCoordinate); // set y coordinate to new coordinate newYCoordinate
         }
     }

     // private static methods - "helper utils"

     private static double validateZero(double num)
     {
         return (num < ZERO) ? ZERO : num;  // validate num is negative (num < 0.0) if true, num assigned with default value of 0.0 = ZERO (x=0.0) otherwise formal parameter (num) is used 
     }

     private double internalToRadians()
     {
         return (_alpha * Math.PI / PI_RADIANS);
     }

     private static double calculateRadius(double x, double y)
     {
         return ( Math.sqrt( Math.pow(x, TWO) + Math.pow(y, TWO) ) );
     }

     private static double calculateAlpha(double x, double y)
     {
         return ( ( Math.atan( y / x ) ) * PI_RADIANS / Math.PI );
     }

     private void calculateRadiusAlpha(double x, double y)
     {
         _radius = calculateRadius(x, y);
         _alpha = calculateAlpha(x, y);
     }

     private double customRoundHelper(double num)
     {
         return ( Math.round(num * TEN_K ) / (double)TEN_K ); // Math.round(d*10000)/(double)10000 (d=num)
     }
 }
