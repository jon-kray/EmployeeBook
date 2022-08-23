package figure;

public class GeometricFigure {

    private double width;
    private double length;
    private double depth;
    private double radius;


    public GeometricFigure(double width, double length, double depth, double radius) {
        this.width = width;
        this.length = length;
        this.depth = depth;
        this.radius = radius;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
