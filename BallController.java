import java.awt.Color;
import java.util.*;

public class BallController {
    private BallPanel ballPanel;
    private ArrayList<CreateBall> listOfBalls;
    private Random random;

    private Color ballColor = Color.RED; // Default ball color is red

    public BallController() {
        this.listOfBalls = new ArrayList<>(); // Initialize the list here
    }

    public void addBall() {
        int randomX = ballPanel.generateX(); 
        int initialY = ballPanel.getHeight() - 30; // Adjust the initial y-coordinate
        CreateBall newBall = new CreateBall(randomX, initialY, 15, generateRandomColor()); 
        listOfBalls.add(newBall); 
        
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
