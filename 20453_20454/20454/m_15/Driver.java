public class Driver
{

    public static void Main()
    {
        // Point p1 = new Point(4, 5);
        // Point p2 = new Point(5, 6);

        // System.out.println(p2.isAbove(p1));
        // System.out.println(p1.isUnder(p2));

        // PointNode pn1 = new PointNode(p1);
        // PointNode pn2 = new PointNode(p2);

        Polygon poly1 = new Polygon();

        // poly1.addVertex(p1 ,1);
        // poly1.addVertex(p2 ,2);

        Point a = new Point(2, 1);
        Point b = new Point(5, 0);
        Point c = new Point(7, 5);
        Point d = new Point(4, 6);
        Point e = new Point(1, 4);

        System.out.println(poly1.addVertex(a ,1)); // #1 2,1
        System.out.println(poly1.addVertex(b ,2)); // #2 5,0
        System.out.println(poly1.addVertex(c ,3)); // #2 5,0
        System.out.println(poly1.addVertex(d ,4)); // #2 5,0
        System.out.println(poly1.addVertex(e ,5)); // #2 5,0

        System.out.println(poly1.calcArea()); // #2 2,2
    }

}