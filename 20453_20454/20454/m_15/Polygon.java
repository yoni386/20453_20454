/**
 * Represents Ex15 class Maman15 question3
 *
 * @author (Yoni Shperling)
 * @version (16.07.20)
 */

public class Polygon
{
    // instance variables
    private PointNode _head;

    /**
     * Constructor for objects of class Polygon (Default / only constructor)
     */
    public Polygon()
    {
        _head = null;  // initialise instance variable _head->null
    }

    /**
     * Method addVertex adds a vertex to a polygon. 
     * 
     * addVertex that adds a vertex to a polygon. The method haas two formal parmeters the point it-self and the index position that will be used to insert it.
     * The method returns true, if add-operation was successful otherwise false.
     * The conditions for "successful" insert are; Point formal argument (p) should not be a null pointer, formal index argument (pos) should be between 1 or above and less or equal to the actual numbers of elements in list in other words (length() + 1)
     * If the postion has node their due to pervious insert the new node will push the old one new node will node will point to "old / current" node and the node before the old node will point on the new-one.
     *
     * @param p is a point used to make new point (copy data from point and make new instance) 
     * @param pos A parameter to mark the desired position to make the insert
     * 
     * @return returns true, if "add-operation" was successful otherwise false
     */
    public boolean addVertex(Point p, int pos) 
    {
        if (p == null) // Valdities p Point formal argument is not a null pointer
        {
            return false; // if p is null "early return" false
        }
        PointNode node = new PointNode(p);
        int numNodes = length();

        if (pos <= 0 || pos > (numNodes + 1)) // Valdities pos formal argument has legal range between 1 or above and less or equal to the actual numbers of elements in list in other words (length() + 1)
        {
            return false; // pos is <= 0 or pos > (numNodes + 1) do "early return" false
        }
        if (isEmpty()) // Valdities list is not empty. if it reached till here pos has valid a range value meaning pos == 1 
        {
            _head = node; // first node _head->node 
            return true; // "early return" true. This state is good
        }
        else // list is not empty and all of above condtion are false meaning insert can be done to pos >= 2 and pos <= numNodes + 1
        {
            PointNode prev = null; // flag to point on the prev used internally to make "house cleaning" point on new nodes order
            PointNode current = _head; // flag to point on the current used internally to make "house cleaning" point on new nodes order
            int i = 1; // index starts from 1

            //while (current != null && pos > i) // iterates while current is not null and pos has higher value than index i
            while (pos > i) // iterates while pos has higher value than index i (pos > 1) above instruction was simplified by removing the check (current != null) this valdation is already done by isEmpty() scope
            {
                prev = current; // prev points to current prev->current
                current = current.getNext(); // current points to next current current->current.getNext()
                i++; // increments index i  i->(i + 1)
            }
            node.setNext(current); // sets the next for new new code e.g. node->current new node points to the old / orignal node (orignal - node the node that was on the pos)
            if (prev == null) // if prev is null the while-iterate was done but "skipped" without going inside while body, meaning: current was null and pos was less or equal to i. At this point pos must have valid range vale and i has 1
            {
                _head = node; // this instruction will happen if pusing "forward" the elements to existing list e.g. first node _head was assinged by a pervious call and now the new node will point on him (original node before this change and _head will point on the new node)
            }
            else // prev is not null 
            {
                prev.setNext(node);
            }
        }

        return true;
    }

    public boolean addVertex2(Point p, int pos) 
    {
        int numNodes = length();

        if ( p == null )
        {
            return false;
        }

        if (pos <= 0 || pos > (numNodes + 1)) // Valdities pos formal argument has legal range between 1 or above and less or equal to the actual numbers of elements in list in other words (length() + 1)
        {
            return false; // pos is <= 0 or pos > (numNodes + 1) do "early return" false
        }

        PointNode node = new PointNode(p);

        // new - pos is 1 and _head is null
        if ( pos == 1 && _head == null )
        {
            _head = node;
            return true;
        }
        else if ( pos == 1 ) // pos is 1 and _head is not null
        {
            node.setNext(_head);
            _head = node;
            return true;
        }

    }

    public Point highestVertex()
    {
        PointNode current = _head;
        Point point = current.getPoint();

        while (current != null)
        {
            if (current.getPoint().isAbove(point))
            {
                point = current.getPoint();
            }
            current = current.getNext();
        }
        return point; // returns copy not *alias
    }

    public double calcPerimeter()
    {
        int numNodes = length();

        if (numNodes == 0 || numNodes == 1)
        {
            return 0;
        }
        else if (numNodes == 2)
        {
            return _head.getPoint().distance(_head.getNext().getPoint());
        }
        else
        {
            return calcPerimeter(_head);
        }
    }

    public String toString()
    {
        String output = "The polygon has " + length() + " vertices"; // "The polygon has %d vertices";
        if (isEmpty())
        {
            output += ".\n";
            return output;
        }
        output += ":\n(";

        return toString(output, _head);
    }

    public double calcArea() //
    {
        double result = 0.0;
        int numNodes = length();
        int secondPointIndex = 2;

        if (numNodes < 3)
        {
            return 0;
        }
        do
        {
            double res = calcTriangleArea(_head, secondPointIndex);
            result += res;
            secondPointIndex++;
        } while (secondPointIndex  != numNodes);

        return result;
    }

    public boolean isBigger(Polygon other)
    {
        return ( this.calcArea() > other.calcArea() );
    }

    public int findVertex(Point p)
    {
        PointNode node = _head;

        for (int i = 1; node != null; i++, node = node.getNext())
        {
            if (node.getPoint().equals(p))
            {
                return i;
            }
        }

        return -1;
    }

    public Point getNextVertex(Point p)
    {
        PointNode node = _head;

        for (int i = 1; node != null; i++, node = node.getNext())
        {
            if (node.getPoint().equals(p))
            {
                if (node.getNext() == null) // last or first only node esetinally last and first is the the same no _next returns itself the copy _head.point otherwise copy of _next.point
                {
                    return _head.getPoint();
                }
                return node.getNext().getPoint(); // should be copy not alias .getPoint() returns new copy
            }
        }

        return null;
    }

    public Polygon getBoundingBox()
    {
        Polygon poly = null;
        PointNode currentNode = _head;
        Point horizontalMin  = currentNode.getPoint(); // x left edge
        Point horizontalMax  = currentNode.getPoint(); // x right edge
        Point verticalMin = currentNode.getPoint(); // y bottom
        Point verticalMax = currentNode.getPoint();  // y top
        int numNodes = length();
        if (numNodes < 3)
        {
            return poly; // poly->null returns null
        }
        while (currentNode.getNext() != null) // iterates all points and compare low, min horizontal
        {
            currentNode = currentNode.getNext();
            Point currentPoint = currentNode.getPoint();

            horizontalMin  = currentPoint.isLeft (horizontalMin)  ? currentPoint : horizontalMin;
            horizontalMax  = currentPoint.isRight(horizontalMax)  ? currentPoint : horizontalMax;
            verticalMin = currentPoint.isUnder(verticalMin) ? currentPoint : verticalMin;
            verticalMax = currentPoint.isAbove(verticalMax) ? currentPoint : verticalMax;
        }

        Point p1 = new Point(horizontalMin.getX(), verticalMin.getY());
        Point p2 = new Point(horizontalMin.getX(), verticalMax.getY());
        Point p3 = new Point(horizontalMax.getX(), verticalMax.getY());
        Point p4 = new Point(horizontalMax.getX(), verticalMin.getY());

        poly = new Polygon();
        poly.addVertex(p1, 1); // could have been used with this poly.addVertex(p1);
        poly.addVertex(p2, 2); // could have been used with this poly.addVertex(p2);
        poly.addVertex(p3, 3); // could have been used with this poly.addVertex(p3);
        poly.addVertex(p4, 4); // could have been used with this poly.addVertex(p4);

        return poly;
    }

    //    public double calcArea() // method is complicated commented out
    //    {
    //        int numNodes = length();
    //
    //        if (numNodes < 3)
    //        {
    //            return 0;
    //        }
    //
    //        int startI = 1;
    //        int endI = 3;
    //        double result = 0.0;
    //
    //        do
    //        {
    //            Polygon polyTriangle = this.trimVertex(1, startI, endI);
    //            double perimeter = polyTriangle.calcPerimeter();
    //            perimeter /= 2.0;
    //
    //            double res = polyTriangle.calcTriangleArea(polyTriangle._head, perimeter);
    //            res = Math.sqrt( perimeter * res );
    //            result += res;
    //
    //            numNodes -= polyTriangle.length();
    //            startI = endI;
    //            endI++;
    ////        } while (numNodes >= -1);
    //        } while (endI != length() + 1);
    //
    //        return result;
    //    }
    private boolean addVertex(Point p)
    {
        PointNode node = new PointNode(p);
        if (isEmpty())
        {
            _head = node;
            return true;
        }
        PointNode current = _head;
        while (current.getNext() != null)
        {
            current = current.getNext();
        }
        current.setNext(node);
        return true;
    }

    private boolean isEmpty()
    {
        return (_head == null);
    }

    private int length()
    {
        int total = 0;
        PointNode currentNode = _head;
        while (currentNode != null) // problem
        {
            currentNode = currentNode.getNext();
            total++;
        }
        return total;
    }

    private double calcPerimeter(PointNode node)
    {
        if (node.getNext() == null)
        {
            return node.getPoint().distance(_head.getPoint());
        }

        PointNode prev = node;
        node = node.getNext();

        return node.getPoint().distance(prev.getPoint()) + calcPerimeter(node);
    }

    private String toString(String output, PointNode current)
    {
        if (current == null) // isEnd append )
            return output + ")";

        output += "(";
        output += current.getPoint().getX();
        output += ",";
        output += current.getPoint().getY();
        output += ")";

        if (current.getNext() != null)
            output += ",";

        current = current.getNext();
        return toString(output, current);
    }

    private double calcTriangleArea(PointNode node, int secondPoint)
    {
        double result = 0.0;
        PointNode currentNode = node;
        PointNode other = null;
        for (int i = 1; ( (other == null) && (i <= secondPoint) && (currentNode.getNext() != null) ); i++)
        {
            if (i == secondPoint)
            {
                other = currentNode;
            }
            else
            {
                currentNode = currentNode.getNext();
            }
        }
        if (other != null && other.getNext() != null)
        {
            result = calcTriangleArea(node.getPoint(), other.getPoint(), other.getNext().getPoint());
        }

        return result;
    }

    private double calcTriangleArea(Point a, Point b, Point c)
    {
        double ab = a.distance(b);
        double bc = b.distance(c);
        double ac = a.distance(c);
        double s = ( (ab + bc + ac) / 2.0 ); // half Perimeter

        return Math.sqrt( s * ( (s - ab) * (s - bc) * (s - ac) ) );
    }

    private double calcTriangleArea(PointNode node, double s)
    {
        double distance;
        if (node.getNext() == null)
        {
            distance = node.getPoint().distance(_head.getPoint());
            return ( s - distance );
        }

        PointNode prev = node;
        node = node.getNext();

        distance = prev.getPoint().distance(node.getPoint());

        return ( ( s - distance ) * calcTriangleArea(node, s) );
    }

    private Polygon trimVertex(int requiredNode, int startI, int endI)
    {
        Polygon newPoly = new Polygon();
        PointNode node = _head;

        for (int i = 1; node != null; i++)
        {
            if (i == requiredNode)
            {
                newPoly.addVertex(node.getPoint());
            }
            else if (i >= startI && i <= endI)
            {
                newPoly.addVertex(node.getPoint());
            }
            node = node.getNext();
        }

        return newPoly;
    }

}

