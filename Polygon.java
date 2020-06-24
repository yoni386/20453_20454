
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
     * 
     * Time Complexity is O(1). Zero iterations are done
     * Memory Complexity is O(1). The memory complexity is static is not dependent with n or other non static. 
     * 
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
     * Time Complexity is O(n). One loop (maximum) with n if n = length() iterations are done.
     * Memory Complexity is O(1). The memory complexity is static is not dependent with n or other non static. 
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
            while (pos > i) // iterates while pos has higher value than index i (pos > 1) above instruction was simplified by removing the check (current != null) this valdation is already done by isEmpty() scope. false is pos and i are euqal meaning reached to right position
            {
                prev = current; // prev points to current prev->current
                current = current.getNext(); // current points to next current current->current.getNext()
                i++; // increments index i  i->(i + 1)
            }
            node.setNext(current); // sets the next for new new code e.g. node->current new node points to the old / orignal node (orignal - node the node that was on the pos)
            if (prev == null) // if prev is null the while-iterate was done but "skipped" without going inside while body, meaning: current was null and pos was less or equal to i. At this point pos must have valid range vale and i has 1
            {
                _head = node; // (prev == null) while-iterate was done but "skipped" without going inside while body, meaning: pos = i = 1 new node.next points to current and _head to new (swap) this instruction will happen if pusing "forward" the elements to existing list e.g. first node _head was assinged by a pervious call and now the new node will point on him (original node before this change and _head will point on the new node)
            }
            else // prev is not null pos was greater than i (pos > i) and last node points to new
            {
                prev.setNext(node);
            }
        }

        return true; // returns true 
    }

    /**
     * Method highestVertex
     * The highestVertex method returns a copy of the vertex that is highest in the polygon 
     * If There are more than one it returns the first one. If there are no vertices in the polygon (i.e. the list is empty) the method will return null.
     *
     * Time Complexity is O(n). One loop (max) with length() iterations are done.
     * Memory Complexity is O(1). Each iteration point is being assinged consider to be static O(1). The memory complexity is static is not dependent with n or other non static. 
     *
     * @return returns a copy of the vertex (point) that is highest in the polygon
     */
    public Point highestVertex()
    {
        if (isEmpty())
        {
            return null;
        }

        PointNode current = _head;
        Point point = current.getPoint();
        // Point point = isEmpty() ? null : current.getPoint(); // this can replace the above instruction + return null if isEmpty() is true
        while (current != null) // iterates all points and looks for thee highest point (vertical values)
        {
            if (current.getPoint().isAbove(point)) // current.getPoint().getY() > point ("next point" > " cuurent point")
            {
                point = current.getPoint(); // points to the higher vertex (highest point) if the point is higher assinged point with current point 
            }
            current = current.getNext(); 
        }

        return point; // returns copy not *alias if list is empty returns null
    }

    /**
     * returns a String that represents the Polygon ("textually represents") of Polygon textually represents. Each PointNode Vertex in the fomrat bellow
     * 
     * The polygon has 5 vertices:
     * ((2.0,1.0),(5.0,0.0),(7.0,5.0),(4.0,6.0),(1.0,4.0))
     * 
     * If list is empty meaning _head is null returns the String with the format below  
     * The polygon has 0 vertices.
     * 
     * Time Complexity is O(n). One loop (max) with length() iterations are done. Due to call private recursive call
     * Memory Complexity is O(n). Each iteration point are assinged to String. The memory complexity is dependent with n points and chars of the actual representation of x,y coordinates. 
     *
     * 
     * @return A String representation of the Polygon object
     */
    public String toString()
    {
        String output = "The polygon has " + length() + " vertices"; // "The polygon has %d vertices";
        if (isEmpty())
        {
            output += ".\n"; // if empty add ".\n" . and new line
            return output;
        }
        output += ":\n("; // else (if not empty) : add (append) new line ":\n("

        return toString(output, _head);
    }

    /**
     * Method calcPerimeter returns an actual number (double) representing the perimeter of the polygon
     * If the number of vertices is 2, the segment length is returned (not back and forth)
     * If the number of vertices is 1 or 0 then 0 will be returned
     *
     * Time Complexity is O(n). One loop (max) with length() iterations are done. Due to call private recursive call
     * Memory Complexity is O(1). The memory complexity is not dependent on some factor.
     *
     * @return The returns an actual number (double) representing the perimeter of the polygon
     */
    public double calcPerimeter()
    {
        int numNodes = length();

        if (numNodes == 0 || numNodes == 1) // If the number of vertices is 1 or 0 then 0 will be returned
        {
            return 0;
        }
        else if (numNodes == 2) // If the number of vertices is 2, the segment length is returned (not back and forth)
        {
            return _head.getPoint().distance(_head.getNext().getPoint());
        }
        else // higher than 2 (three or higher)
        {
            return calcPerimeter(_head); // recursive call to the first node until the end of node (node.getNext() == null)
        }
    }

    /** I reworte this to have better efficency and eaiser code 
     * Method calcArea returns an actual number (double) representing the polygon area
     * To calculate the polygon area, the areas of the triangles covering the polygon area must be first calculate and summed
     * If the number of vertices (points) is less than three method will return 0 otherwise all Triangles area will summired until secondPointIndex == numNodes (until reaching to the end of list)
     *
     * Time Complexity is O(n). One loop (max) with length() iterations are done. Due to call private recursive call
     * Memory Complexity is O(1). The memory complexity is not dependent on some factor. Each iteration double res delcared and assinged consider but still consider to be static O(1).
     *
     * @return returns the value of the polygon area or 0 if list has less than three vertices (less than three points)
     */
    // public double calcArea()
    // {
    // double result = 0.0;
    // int numNodes = length();
    // int secondPointIndex = 2; // used to mark the second start index from second node. First is _head

    // if (numNodes < 3) // If the number of vertices is less than three method will return 0
    // {
    // return 0;
    // }
    // do
    // {
    // double res = calcTriangleArea(_head, secondPointIndex); // res is a local (temporary result)
    // result += res; // res will be added to global result 
    // secondPointIndex++; // increments index secondPointIndex secondPointIndex->(secondPointIndex + 1) moving to next PointNode this will be used to mark the second and third triangle side
    // } while (secondPointIndex != numNodes); // loop (iterate) until second Point Index (next node) is reaching to the end of list (the last point node)

    // return result;
    // }

    /*
     * Method calcArea returns an actual number (double) representing the polygon area
     * To calculate the polygon area, the areas of the triangles covering the polygon area must be first calculate and summed
     * If the number of vertices (points) is less than three method will return 0 otherwise all Triangles area will summired until secondPointIndex == numNodes (until reaching to the end of list)
     *
     * Time Complexity is O(n). One loop (maximum) with n = length() iterations are done.
     * Memory Complexity is O(1). The memory complexity is not dependent on some factor. Each iteration result (double) is modified.
     *
     * @return returns the value of the polygon area or 0 if list has less than three vertices (less than three points)
     */
    public double calcArea()
    {
        double result = 0.0; // holds the final result (global result)
        int numNodes = length();

        if (numNodes < 3) // If the number of vertices is less than three method will return 0
        {
            return 0;
        }

        PointNode node = _head.getNext(); // safe numNodes is 3 or higher. Two nodes must be in the list
        while (node.getNext() != null) // loop (iterate) until node.getNext() != null (next node) is reaching to the end of list (the last point node)
        {
            result += calcTriangleArea(_head, node); // value will be added to global result 
            node = node.getNext();
        }

        return result;
    }

    /**
     * Method isBigger return true if polygon (this polygon) has bigger area than the other polygon that was passed as formal parameter (other argument) otherwise returns false
     *
     * @param other Polygon instance to compare against this Polygon instance
     * 
     * Time Complexity is O(1). iterations are not done.
     * Memory Complexity is O(1). The memory complexity is not dependent on some factor.
     * 
     * @return returns true if this polygon has bigger area otherwise false
     */
    public boolean isBigger(Polygon other)
    {
        return ( this.calcArea() > other.calcArea() ); // calling calcArea (this.calcArea() with other.calcArea()) if equal or less then can't be qualified as bigger
    }

    /**
     * Method findVertex accepts a point as a parameter and returns its location in the list. 
     * If the node can't be found -1 will be returned otherwise the actual index is returned. Index starts from 1. The order index is acording to the actual NodePoints orde.
     * 
     * Time Complexity is O(n). One loop (max) with length() iterations are done.
     * Memory Complexity is O(1). The memory complexity is not dependent on some factor. Each iteration int i reassinged still consider to be static O(1).
     * 
     * @param p point used by the methood for the lookup. Method looks for the p (point) and returns its location in the list. Used to compare against the points in list if it finds one it returns the index the first if not -1 will be returned
     * @return returns the index of the first match or -1 if no method didn't match any Points to be equal to the point passed as formal parameter
     */
    public int findVertex(Point p)
    {
        PointNode node = _head;

        if (p == null) // Valdities p Point formal argument is not a null pointer
        {
            return -1; // if p is null "early return" -1
        }

        for (int i = 1; node != null; i++, node = node.getNext()) // iterate all points 
        {
            if (node.getPoint().equals(p)) // valditate if this point node.getPoint() equal to the point P (passed as formal parameter) by invoking the Point.equals() method
            {
                return i; // if true return the index as "early return" if the above is true this point is equal to the point we are looking for return the index (i) 
            }
        }

        return -1; // if reaching here no "early return" happen (loop was done without breaking the loop and without finding a match) therefor -1 need to be returned
    }

    /**
     * Method getNextVertex returns a copy of the point Representing the following vertex in the polygon
     * If the resulting point is not a vertex in the polygon, The method will return null
     * If the point is the last element in the list, method returns a copy of the first point
     * If the point is the only point in the list, a copy of the point itself will be returned
     *
     * Time Complexity is O(n). One loop (max) with length() iterations are done.
     * Memory Complexity is O(1). The memory complexity is not dependent on some factor.
     *
     *
     * @param p a point used to compare all points. looks for the p (point) and returns copy of the point. Used to compare against the points in list
     * @return returns a copy of the point vertex in the polygon or if the method didn't found or their special condtions as list has only one node or only node then the instuctions as descried above will be returned 
     */
    public Point getNextVertex(Point p)
    {
        PointNode node = _head;

        if (p == null) // Valdities p Point formal argument is not a null pointer
        {
            return null; // if p is null "early return" with null
        }

        for (int i = 1; node != null; i++, node = node.getNext()) // iterate all points 
        {
            if (node.getPoint().equals(p)) // valditate if this point node.getPoint() equal to the point P (passed as formal parameter) by invoking the method Point.equals() 
            {
                if (node.getNext() == null) // last or first only (if and only list has one elment first and only only) node esetinally last and first are the the same there _next is null returns itself the copy _head.point otherwise copy of _next.point
                {
                    return _head.getPoint(); // returns the copy of the point if first and only first or if the node is last (no more nodes after this one)
                }
                return node.getNext().getPoint(); // if the above is false there is node after node (current node) and the method should return copy not alias .getPoint() returns new copy 
            }
        }

        return null; // null is returned. Iterate is done. Method did not found any match, meaning the list has no point which match the criteria (_x,_y == p._x,_y) therefore null is returned 
    }

    /**
     * Method getBoundingBox returns the rectangle that blocks this polygon (corresponding to the blocks)
     * If the number of vertices less than 3 is returned null
     * The Points will be selected by making the "minimum" rectangle that can block this (instance) polygon. 
     * This is done iterating all the points and comparing each with current min, max (horizontal and vertical) and setting / update the "edges" horizontalMin, horizontalMax, verticalMin and verticalMax  
     * Post the iteration Four points with the minimum / maximum for vertical and horizontal are set and ready (pointing / holding the currect data) and now they can be used to "puplate" the new list
     * 
     * Time Complexity is O(n). One loop (max) with length() iterations are done.
     * Memory Complexity is O(1). The memory complexity is not dependent on some factor. Each iteration four variables assinged this consider to be static O(1). 
     * Post iteration four points declared and assigned + one Polygon with those points added by calling addVertex (addVertex allocate new PointNode and assing the current node.next to newest node). 
     *
     * @return returns new Polygon with the corsponding Points or if this Polygon has less than 3 vertices (points) then null is returned
     */
    public Polygon getBoundingBox()
    {
        Polygon poly = null;

        if (length() > 3)
        {
            PointNode currentNode = _head;

            Point horizontalMin   = currentNode.getPoint();    // x horizon left edge - sets default with first point 
            Point horizontalMax   = currentNode.getPoint();    // x horizon right edge - sets default with first point 
            Point verticalMin     = currentNode.getPoint();    // y vertical bottom min bottom -  sets default with first point 
            Point verticalMax     = currentNode.getPoint();    // y vertical top max top-  sets default with first point 

            while (currentNode.getNext() != null) // iterates all points and compare min and high horizontal and vertical
            {
                currentNode = currentNode.getNext(); // holds the next node 
                Point currentPoint = currentNode.getPoint(); // holds the point (point belongs to next node above instruction)

                horizontalMin = currentPoint.isLeft (horizontalMin) ? currentPoint : horizontalMin;  //  if the current is left relative to horizontalMin update horizontalMin=currentPoint if not horizontalMin=horizontalMin
                horizontalMax = currentPoint.isRight(horizontalMax) ? currentPoint : horizontalMax;  //  if the current is right relative to horizontalMax update horizontalMax=currentPoint if not horizontalMax=horizontalMax
                verticalMin = currentPoint.isUnder(verticalMin) ? currentPoint : verticalMin;        //  if the current is under relative to verticalMin update verticalMin=currentPoint if not verticalMin=verticalMin
                verticalMax = currentPoint.isAbove(verticalMax) ? currentPoint : verticalMax;        //  if the current is above relative to verticalMax update verticalMax=currentPoint if not verticalMax=verticalMax

                // or this block if instead of ternary  
                /*
                // if (currentPoint.isLeft(horizontalMin)) horizontalMin = currentPoint;
                // if (currentPoint.isRight(horizontalMax)) horizontalMax = currentPoint;
                // if (currentPoint.isUnder(verticalMin)) verticalMin = currentPoint;
                // if (currentPoint.isAbove(verticalMax)) verticalMax = currentPoint;
                 */

            }
            Point p1 = new Point(horizontalMin.getX(), verticalMin.getY()); // side1
            Point p2 = new Point(horizontalMin.getX(), verticalMax.getY()); // side2
            Point p3 = new Point(horizontalMax.getX(), verticalMax.getY()); // side3
            Point p4 = new Point(horizontalMax.getX(), verticalMin.getY()); // side4

            poly = new Polygon(); // initialize the new polygon and add the below points by order 1-4 (including first and last)
            poly.addVertex(p1, 1);  // add side1 could have been used with this poly.addVertex(p1) but might conflict mman instruction and might be less known and more complicated 
            poly.addVertex(p2, 2);  // add side2
            poly.addVertex(p3, 3);  // add side3
            poly.addVertex(p4, 4);  // add side4
        }

        return poly; // returns null if Polygon has less than 3 vertices (points) ("bad flow") or ("good flow") with new Polygon instance with the relevant points corresponding by the nodes 
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

    // * Time Complexity is O(n). One loop (max) with length() iterations are done.
    // * Memory Complexity is O(1). The memory complexity is static is not dependent with n or other non static. 
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

    // * Time Complexity is O(1). Iterations are not done.
    // * Memory Complexity is O(1). The memory complexity is static is not dependent with n or other non static.
    private boolean isEmpty()
    {
        return (_head == null);
    }

    // * Time Complexity is O(n). One loop (max) with length() iterations are done.
    // * Memory Complexity is O(1). The memory complexity is static is not dependent with n or other non static. Each iteration total increments still consider to be static 
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

    // * The method is linear recursive. Each recursive call decremnts n by 1 (n-1) and therefore the recuersive depth is O(n) n = length() number of nodes.
    // * Time Complexity is O(n). Each recusive call has static instruction which as a fixed (static) number of instruction, and a total of n recursive readings are made, so running time is O(n)
    // * Memory Complexity is O(n). Each recusive call require static fixed memory that which is not dependent on n. The maxmimum recuersive calls (total concurrent) is n. Therefore the O(n)  
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

    // * The method is linear recursive. Each recursive call decremnts n by 1 (n-1) and therefore the recuersive depth is O(n) n = length() number of nodes.
    // * Time Complexity is O(n). Each recusive call has static instruction which as a fixed (static) number of instruction, and a total of n recursive readings are made, so running time is O(n)
    // * Memory Complexity is O(n). Each recusive call require static fixed memory that which is not dependent on n. The maxmimum recuersive calls (total concurrent) is n. Therefore the O(n). The String itself is dependent in how many chars will be there.
    private String toString(String output, PointNode current)
    {
        if (current == null) // isEnd append ")" if last PointNode
            return output + ")";

        output += current.getPoint(); // append all Points

        if (current.getNext() != null) // if their more points add ","
            output += ",";

        current = current.getNext();
        return toString(output, current); // recursive call with the next PointNode
    }

    // * The method has linear recursive and loop. Each recursive call decremnts n by 1 (n-1) and therefore the recuersive depth is O(n) n = length() number of nodes.
    // * Time Complexity is O(2n). Each recusive call has static instruction which as a fixed (static) number of instruction, and a total of n recursive readings are made, so running time is O(2n)
    // * Memory Complexity is O(n). Each recusive call require static fixed memory that which is not dependent on n. The maxmimum recuersive calls (total concurrent) is n. Therefore the O(n).
    // private double calcTriangleArea(PointNode node, int secondPoint)
    // {
    // double result = 0.0;
    // PointNode currentNode = node;
    // PointNode other = null;
    // for (int i = 1; ( (other == null) && (i <= secondPoint) && (currentNode.getNext() != null) ); i++)
    // {
    // if (i == secondPoint)
    // {
    // other = currentNode;
    // }
    // else
    // {
    // currentNode = currentNode.getNext();
    // }
    // }
    // if (other != null && other.getNext() != null)
    // {
    // result = calcTriangleArea(node.getPoint(), other.getPoint(), other.getNext().getPoint());
    // }

    // return result;
    // }

    private double calcTriangleArea(PointNode node, PointNode other)
    {
        double result = 0.0;
        if (other != null && other.getNext() != null) // probably can be skipped but due to time restriction (time to post mman)
        {
            result = calcTriangleArea(node.getPoint(), other.getPoint(), other.getNext().getPoint());
        }

        return result;
    }

    // * Time Complexity is O(1). Iterations are not done.
    // * Memory Complexity is O(1). The memory complexity is static is not dependent with n or other non static.
    private double calcTriangleArea(Point a, Point b, Point c)
    {
        double ab = a.distance(b);
        double bc = b.distance(c);
        double ac = a.distance(c);
        double s = ( (ab + bc + ac) / 2.0 ); // half Perimeter

        return Math.sqrt( s * ( (s - ab) * (s - bc) * (s - ac) ) );
    }

    // * The method is linear recursive. Each recursive call decremnts n by 1 (n-1) and therefore the recuersive depth is O(n) n = length() number of nodes.
    // * Time Complexity is O(n). Each recusive call has static instruction which as a fixed (static) number of instruction, and a total of n recursive readings are made, so running time is O(n)
    // * Memory Complexity is O(n). Each recusive call require static fixed memory that which is not dependent on n. The maxmimum recuersive calls (total concurrent) is n. Therefore the O(n).
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

    // * Time Complexity is O(n). One loop (max) with length() iterations are done.
    // * Memory Complexity is O(1). The memory complexity is static is not dependent with n or other non static. Each iteration total increments still consider to be static
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

