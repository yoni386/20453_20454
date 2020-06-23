public class Driver
{

    public static void Main()
    {
        Point p1 = new Point(4, 5);
        Point p2 = new Point(5, 6);

        System.out.println(p2.isAbove(p1));
        System.out.println(p1.isUnder(p2));
        
        
        PointNode pn1 = new PointNode(p1);
        PointNode pn2 = new PointNode(p2);
        
        Polygon poly1 = new Polygon();
        
        poly1.addVertex(p1 ,1);
        poly1.addVertex(p2 ,2);
    }

    
}