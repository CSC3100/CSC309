import java.awt.*;
import java.util.Objects;

/**
 * CSC 308 Assignment IV
 * Class for defining connections
 * @author Thien An Tran
 */
public class Connections {
    private Point type;
    private Box class1;
    private Box class2;

    /**
     * Connections
     * Default Constructor for Connections
     */
    public Connections()
    {
        type = null;
        class1 = null;
        class2 = null;
    }

    /**
     * Connections
     * Constructor for making a new Connections
     * @param c1 : ClassInformation
     * @param c2 : ClassInformation
     * @param type : Point
     */
    public Connections(Box c1, Box c2, Point type){
        this.type = type;
        class1 = c1;
        class2 = c2;
    }

    /**
     * getType
     * @return Point
     * Gets the type of connection
     */
    public Point getType() {
        return type;
    }

    /**
     * getClass1
     * @return ClassInformation
     * Gets the first class of the connection
     */
    public Box getClass1() {
        return class1;
    }

    /**
     * getClass2
     * @return ClassInformation
     * Gets the second class of the connection
     */
    public Box getClass2() {
        return class2;
    }

    /**
     * toString
     * @return String
     * Turns connection into a string
     */
    @Override
    public String toString() {
        return (int)type.getX()+ ";" + (int)type.getY() + ";" + class1.getName() + ";" + class2.getName();
    }

    /**
     * equals
     * @param o : Object
     * @return boolean
     * Determines if objects are equal to each other
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Connections that = (Connections) o;
        return Objects.equals(type, that.type) && Objects.equals(class1, that.class1) && Objects.equals(class2, that.class2);
    }

    /**
     * hashCode
     * @return int
     * Returns the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(type, class1, class2);
    }
    
    /**
     * drawConnections
     * @param g : Graphics
     * @param c : ClassInformation
     * Takes in a class and draws it's connections
     */
    public void drawConnections(Graphics g, Box c){
        for (Connections connection : c.getConnections()) {
            int x1 = (int) connection.getClass1().getPoint().getX();
            int y1 = (int) connection.getClass1().getPoint().getY();
            int x2 = (int) connection.getClass2().getPoint().getX();
            int y2 = (int) connection.getClass2().getPoint().getY();
            if (connection.getType().getX() == 0) {
                g.drawLine(x1, y1, x2, y2);
                drawArrowHead(g, x1, y1, x2, y2, 20, connection.getType().getY());
            }
        }
    }
    
    /**
     * drawArrowhead
     * @param g : Graphics
     * @param x1 : int
     * @param y1 : int
     * @param x2 : int
     * @param y2 : int
     * @param size : int
     * @param type : double
     * Draws the arrowhead according to the type of connections
     */
    public static void drawArrowHead(Graphics g, int x1, int y1, int x2, int y2, int size, double type) {
        double dir = Math.atan2(x1 - x2, y1 - y2);
        Polygon p = new Polygon();
        
        if (type == 0) {
            g.drawLine(x2, y2, x2 + x(size, dir + .5), y2 + y(size, dir + .5));
            g.drawLine(x2, y2, x2 + x(size, dir - .5), y2 + y(size, dir - .5));
        } else if (type == 1) {
            p.addPoint(x2, y2);
            p.addPoint(x2 + x(size, dir + .5), y2 + y(size, dir + .5));
            p.addPoint(x2 + x(size, dir - .5), y2 + y(size, dir - .5));
            p.addPoint(x2, y2);
            g.drawPolygon(p);
        } else if (type == 2) {
            p.addPoint(x2, y2);
            p.addPoint(x2 + x(size, dir + .5), y2 + y(size, dir + .5));
            p.addPoint(x2 + (int) (1.8 * x(size, dir)), y2 + (int) (1.8 * y(size, dir)));
            p.addPoint(x2 + x(size, dir - .5), y2 + y(size, dir - .5));
            p.addPoint(x2, y2);
            g.fillPolygon(p);
        }
    }
    
    /**
     * CALCULATE what needs to be added to the x coordinate to draw the arrowhead
     *
     * @param len ?WHAT IS
     * @param dir ?WHAT IS
     * @return ?
     
     */
    public  static int x(int len, double dir) {
        return (int) (len * Math.sin(dir));
    }
    
    /**
     * y
     * @param len : int
     * @param dir : double
     * @return int
     * Returns what needs to be added to the y coordinate to draw the arrowhead
     */
    public static int y(int len, double dir) {
        return (int) (len * Math.cos(dir));
    }
    
}