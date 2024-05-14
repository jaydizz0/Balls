import java.awt.Color;

public class CreateBall {
    private int x;
    private int y;
    private int radius;
    private Color color;
    private int dx; // Velocity in x direction
    private int dy; // Velocity in y direction
    private Motion motion; // Motion type
    private int initialX;

    public CreateBall(int x, int y, int radius, Color color, Motion motion, int dx, int dy) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
        this.dx = dx;
        this.dy = dy;
        this.motion = motion;
    }

    // Getters and setters for the properties
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public Motion getMotion() {
        return motion;
    }

    public void setMotion(Motion motion) {
        this.motion = motion;
    }

    public int getSpeed(){
        return dx;
    }

    public void setInitialX(int initialX){
        this.initialX = initialX; 
    }

    public int getInitialX(){
        return initialX;
    }
}
