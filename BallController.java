import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class BallController {
    private ArrayList<CreateBall> listOfBalls;
    private Random random = new Random();
    private Motion motion = Motion.LINEAR_MOTION; // Default motion is linear

    // Constants for velocity components
    private static final double DEFAULT_SPEED = 1;
    private static final double SLOW_SPEED = 0.5;
    private static final double MEDIUM_SPEED = 1.5;
    private static final double FAST_SPEED = 2;
    private double angle = 0.0;
    private int frameWidth = 780; // Adjust as needed
    private int frameHeight = 300; // Adjust as needed
   
    private static final int RADIUS = 15;

    // Constructor
    public BallController() {
        this.listOfBalls = new ArrayList<>(); // Initialize the list here
    }

    // Adds Balls to array list 
    public CreateBall addBall() {
        int randomX = generateX();
        int randomY = generateY();
        Color color = generateRandomColor();
        CreateBall newBall = new CreateBall(randomX, randomY, RADIUS, color, motion, DEFAULT_SPEED, DEFAULT_SPEED);
        listOfBalls.add(newBall);
        return newBall;
    }

    // Removes Ball from array list 
    public CreateBall removeBall() {
        if (!listOfBalls.isEmpty()) {
            int lastIndex = listOfBalls.size() - 1;
            CreateBall removedBall = listOfBalls.remove(lastIndex);
            return removedBall;
        }
        return null;
    }

    // Generates a random color
    public Color generateRandomColor() {
        // Generate random values for red, green, and blue components
        int red = random.nextInt(256); // Values range from 0 to 255
        int green = random.nextInt(256);
        int blue = random.nextInt(256);

        // Create and return the Color object
        return new Color(red, green, blue);
    }

    // Array list to store Balls
    public ArrayList<CreateBall> getListOfBalls() {
        return listOfBalls;
    }

    // Method to generate a random x-coordinate
    public int generateX() {
        return random.nextInt(frameWidth - RADIUS * 2) + RADIUS; // Ensure ball doesn't spawn too close to edges
    }

    // Method to generate a random y-coordinate
    public int generateY() {
        return random.nextInt(frameHeight - RADIUS * 2) + RADIUS; // Ensure ball doesn't spawn too close to edges
    }

    // Method to set motion for all balls
    public void setMotion(Motion motion) {
        this.motion = motion;
        for (CreateBall ball : listOfBalls) {
            ball.setMotion(motion);
        }
    }

    // Method to set the speed based on predefined constants
    public void setSpeed(String speed) {
        switch (speed) {
            case "slow":
                updateSpeed(SLOW_SPEED);
                break;
            case "medium":
                updateSpeed(MEDIUM_SPEED);
                break;
            case "fast":
                updateSpeed(FAST_SPEED);
                break;
            default:
                updateSpeed(DEFAULT_SPEED);
                break;
        }
    }

    // Updates speed within the ball object
    private void updateSpeed(double speed) {
        for (CreateBall ball : listOfBalls) {
            ball.setDx(speed);
            ball.setDy(speed);
        }
    }

    // Method to move all balls
    public void moveBalls() {
        for (CreateBall ball : listOfBalls) {
            moveBall(ball);
        }
    }

    // Method to move a single ball
    private void moveBall(CreateBall ball) {
        switch (ball.getMotion()) {
            case LINEAR_MOTION:
                moveLinear(ball);
                handleBoundaries(ball);
                break;
            case PARABOLIC_MOTION:
                moveParabolic(ball);
                handleBoundaries(ball);
                break;
            case CIRCULAR_MOTION:
                moveCircular(ball);
                handleBoundaries(ball);
                break;
            case SINUSOIDAL_MOTION:
                moveSinusoidal(ball);
                handleBoundaries(ball);
                break;
            case ELLIPTICAL_MOTION:
                moveElliptical(ball);
                handleBoundaries(ball);
                break;
            case INFINITY_MOTION:
                moveInfinity(ball);
                handleBoundaries(ball);
                break;
            default:
                moveLinear(ball);
                handleBoundaries(ball);
        }
         
    }

     // Method to move a ball with linear motion
     private void moveLinear(CreateBall ball) {
        double speed = ball.getSpeed();
        ball.setX(ball.getX() + speed);
        ball.setY(ball.getY() + speed);
    }

    // Parabolic movment
    private void moveParabolic(CreateBall ball) {
        double x = ball.getX();
        double speed = ball.getSpeed();
        x += speed;
        int y;
        double dx = ball.getDx();
        int amplitude = 50; // Adjust amplitude as needed
        y = (int)(300 - amplitude * Math.pow((x - 250) / 250.0, 2)); // Adjust the formula as needed
    
        // Update position
        ball.setX(x);
        ball.setY(y);
        ball.setDx(dx);
    }

    // Method to move a ball with circular motion
    private void moveCircular(CreateBall ball) {
        double speed = ball.getSpeed();
        int centerX = 400;
        int centerY = 300;
        int radius = 200;
        ball.setX((int) (centerX + radius * Math.cos(Math.toRadians(angle))));
        ball.setY((int) (centerY + radius * Math.sin(Math.toRadians(angle))));
        angle += speed;
    }

    // Method to move a ball with sinusoidal motion
    private void moveSinusoidal(CreateBall ball) {
        double speed = ball.getSpeed() - 0.5;
        ball.setX(ball.getX() + speed);
        double amplitude = 80; // Adjust this value as needed
        ball.setY((int) (300 + amplitude * Math.sin(Math.toRadians(ball.getX()/2))));
    }

    // Method to move a ball with elliptical motion
    private void moveElliptical(CreateBall ball) {
        double speed = ball.getSpeed() - 0.5;
        int semiMajorAxis = 250; // adjust as needed
        int semiMinorAxis = 75; // adjust as needed
        ball.setX((int) (400 + semiMajorAxis * Math.cos(Math.toRadians(angle))));
        ball.setY((int) (300 + semiMinorAxis * Math.sin(Math.toRadians(angle))));
        angle += speed;
    }

    // Method to move a ball with infinity motion
    private void moveInfinity(CreateBall ball) {
        double speed = ball.getSpeed() - 0.5;
        double scaleFactor = 250; // adjust as needed
        ball.setX((int) (400 + scaleFactor * Math.cos(Math.toRadians(angle)) / (1 + Math.pow(Math.sin(Math.toRadians(angle)), 2))));
        ball.setY((int) (300 + scaleFactor * Math.sin(Math.toRadians(angle)) * Math.cos(Math.toRadians(angle)) / (1 + Math.pow(Math.sin(Math.toRadians(angle)), 2))));
        angle += speed;
    }


    // Method to handle boundaries
    private void handleBoundaries(CreateBall ball) {
        double x = ball.getX();
        double y = ball.getY();
        double radius = ball.getRadius();

        // Check if the ball hits the boundaries
        if (x - radius <= 0) {
            ball.setDx(Math.abs(ball.getDx()));  
        }
        else if(x + radius >= frameWidth && ball.getDx() >= 0){
            ball.setDx(-ball.getDx());
        }
        
        if (y - radius <= 0) {
            ball.setDy(Math.abs(ball.getDy())); 
        }
        else if(y + radius >= frameHeight && ball.getDy() >= 0){
            ball.setDy(-ball.getDy()); 
        }
    }

    
    
}
