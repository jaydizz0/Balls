import java.awt.Color;

public class CreateBall {
    private double x;
    private double y;
    private double radius;
    private Color color;
    private double dx; 
    private double dy; 
    private Motion motion; 
    private double initialX;
    private double initialY;

    // Constructor
    public CreateBall(double x, double y, double radius, Color color, Motion motion, double dx, double dy) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
        this.dx = dx;
        this.dy = dy;
        this.motion = motion;
    }

    // Getters and setters for the properties
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public Motion getMotion() {
        return motion;
    }

    public void setMotion(Motion motion) {
        this.motion = motion;
    }

    public double getSpeed(){
        return dx;
    }

    public void setInitialX(int initialX){
        this.initialX = initialX; 
    }

    public double getInitialX(){
        return initialX;
    }

    public void setInitialY(int initialY){
        this.initialY = initialY; 
    }

    public double getInitialY(){
        return initialY;
    }
}
