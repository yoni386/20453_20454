

public class StudentPointTester {

    public static void main(String[] args) {
        Point p0 = new Point(1.0,3.5); 
        System.out.println(p0);
        
        Point p1=new Point(p0);
        System.out.println(p1.getX());
        System.out.println(p1.getY());
        if (!p0.equals(p1))
            System.out.println("Points are not equal.");
 
        p0.setX(10.2);
        p0.setY(4.2);
        System.out.println(p0);
        p0.move(2.3, -2.2);
        System.out.println(p0);
 
        System.out.println(p1.distance(p0));
        System.out.println(p1.isLeft(p0));
        System.out.println(p1.isAbove(p0));
        
        System.out.println(p1.isRight(p1));
        System.out.println(p1.isUnder(p1));
        
    }
}
