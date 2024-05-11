import java.awt.Color;
import java.util.*;

public class BallController {
    private BallPanel ballPanel;
    private ArrayList<CreateBall> listOfBalls;
    private Random random;

    private Color ballColor = Color.RED; // Default ball color is red

    public BallController(BallPanel ballPanel) {
        this.ballPanel = ballPanel;
        this.listOfBalls = new ArrayList<>(); // Initialize the list here
    }

    public void setLinearMotion() {
        ballPanel.performLinearMotion();
    }

    public void setParabolicMotion() {
        ballPanel.performParabolicMotion();
    }

    public void setCircularMotion() {
        ballPanel.performCircularMotion();
    }

    public void setSinusoidalMotion() {
        ballPanel.performSinusoidalMotion();
    }

    public void setEllipticalMotion() {
        ballPanel.performEllipticalMotion();
    }

    public void setInfinityMotion() {
        ballPanel.performInfinityMotion();
    }

    public void addBall() {
        int randomX = ballPanel.generateX(); // Generate a random x-coordinate
        CreateBall newBall = new CreateBall(randomX, 0, 15, generateRandomColor()); // Create a new ball
        listOfBalls.add(newBall); // Add the new ball to the list of balls
    }

    public void removeBall() {
        if (!listOfBalls.isEmpty()) {
            int lastIndex = listOfBalls.size() - 1;
            listOfBalls.remove(lastIndex);
        }
    }

    public void setBallColor(Color color) {
        this.ballColor = color;
    }

    public Color getBallColor() {
        return ballColor;
    }

    public Color generateRandomColor() {
        random = new Random();
        // Generate random values for red, green, and blue components
        int red = random.nextInt(256); // Values range from 0 to 255
        int green = random.nextInt(256);
        int blue = random.nextInt(256);

        // Create and return the Color object
        return new Color(red, green, blue);
    }

    public ArrayList<CreateBall> getListOfBalls(){
        return listOfBalls;
    }
    
}
