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

    // declarations of constants and variables

    /**
     * PointNode Constructor - Constructor for objects of class PointNode
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
     * @param p - The PointNode from which to construct the new object
     */
    public PointNode (PointNode p)
    {
        //        this(p._point, p._next);
        _point = p.getPoint(); // should not be alias
        _next = p.getNext(); // should be alias // (_next = _next) _next = p.getNext()->_next
    }

    /**
     * Method getPoint returns copy of point (copy Point constructor is called with this._point)
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
     * @return The return value pointer (alias) to the next element e.g. this._next
     */
    public PointNode getNext()
    {
        return _next;
    }

    /**
     * Method setPoint gets a point and updates the point attribute the apex
     *
     * @param p Point instance used to get and assigned this._x/y from p_x/y
     */
    public void setPoint(Point p)
    {
        _point.setX(p.getX());
        _point.setY(p.getY());
    }

    public void setNext(PointNode next)
    {
        _next = next;
    }

}

