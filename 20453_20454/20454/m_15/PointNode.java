/**
 * Represents Ex15 class Maman15 question2
 *
 * @author (Yoni Shperling)
 * @version (16.07.20)
 */

public class PointNode
{
    // instance variables
    private Point _point;
    private PointNode _next;

    /**
     * PointNode Constructor - Constructor for objects of class PointNode
     * 
     * Time Complexity is O(1). Zero iterations are done
     * Memory Complexity is O(1). The memory complexity is static is not dependent with n or other non static. 
     *
     * @param p - The Point from which to construct the new object
     */
    public PointNode (Point p)
    {
        _point = new Point(p); // should not be alias
        _next = null;
    }

    /**
     * PointNode Constructor - Constructor for objects of class PointNode
     *
     * Time Complexity is O(1). Zero iterations are done
     * Memory Complexity is O(1). The memory complexity is static is not dependent with n or other non static. 
     *
     * @param p - The Point from which to construct the new object
     * @param n - The PointNode from which to construct the new object
     */
    public PointNode (Point p, PointNode n)
    {
        _point = new Point(p);
        _next = new PointNode(n);
    }

    /**
     * PointNode Constructor - Copy constructor, construct a PointNode using another pointnode.
     *
     * Time Complexity is O(1). Zero iterations are done
     * Memory Complexity is O(1). The memory complexity is static is not dependent with n or other non static. 
     *
     * @param p - The PointNode from which to construct the new object
     */
    public PointNode (PointNode p)
    {
        _point = p.getPoint(); // should not be alias
        _next = p.getNext(); // should be alias // (_next = _next) _next = p.getNext()->_next
    }

    /**
     * Method getPoint returns copy of point (copy Point constructor is called with this._point)
     *
     * Time Complexity is O(1). Zero iterations are done
     * Memory Complexity is O(1). The memory complexity is static is not dependent with n or other non static. 
     *
     * @return The return new copy (instance) of Point (data are from this._point)
     */
    public Point getPoint()
    {
        return new Point(_point);
    }

    /**
     * Method getNext returns pointer (alias) to the next element
     *
     * Time Complexity is O(1). Zero iterations are done
     * Memory Complexity is O(1). The memory complexity is static is not dependent with n or other non static. 
     *
     * @return The return value pointer (alias) to the next element e.g. this._next
     */
    public PointNode getNext()
    {
        return _next; // returns alias. This should return reference and not copy.
    }

    /**
     * Method setPoint gets a point and updates the _point.x,y attribute the new position 
     *
     * Time Complexity is O(1). Zero iterations are done
     * Memory Complexity is O(1). The memory complexity is static is not dependent with n or other non static. 
     *
     * @param p Point instance used to get and assigned this._x,y from p_x,y
     */
    public void setPoint(Point p)
    {
        _point.setX(p.getX()); // sets _x with the value of p.x ("passed point" p.getX()) _x type is a double (primitive) alias is not done and therefore pointing to Point by alias is ok
        _point.setY(p.getY()); // sets _y with the value of p.t ("passed point" p.getY()) _y type is a double (primitive) alias is not done and therefore pointing to Point by alias is ok
    }

    /**
     * Method setNext gets a PointNode and updates the _next attribute the apex
     *
     * Time Complexity is O(1). Zero iterations are done
     * Memory Complexity is O(1). The memory complexity is static is not dependent with n or other non static. 
     *
     * @param p Point instance used to get and assigned this._x/y from p_x/y
     */
    public void setNext(PointNode next)
    {
        _next = next;
    }

}

