import javax.swing.*;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class BallPanel extends JPanel implements ActionListener {
    // Velocity constants for different speed levels
    private static final int SLOW_SPEED = 1;
    private static final int MEDIUM_SPEED = 2;
    private static final int FAST_SPEED = 3;

    private int delay = 1000 / 60;
    protected Timer timer;
    private Random random = new Random();
    private BallController ballController;


    private int x = 0;         // x position
    private int y = 0;         // y position
    private int radius = 15;   // ball radius

    private int dx = 1;        // increment amount (x coord)
    private int dy = 1;        // increment amount (y coord)

    public BallPanel(BallController ballController) {
        this.ballController = ballController;
        timer = new Timer(delay, this); 
    }


    // Method to start the timer
    public void startTimer() {
        timer.start();
    }

    // Method to stop the timer
    public void stopTimer() {
        timer.stop();
    }

    // ActionListener implementation
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }

    protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (CreateBall ball : ballController.getListOfBalls()) {
        ball.draw(g);
    }
}

    // Method to perform linear motion
    public void performLinearMotion() {
        dx = 2; 
        dy = 2; 
    }

    // Method to perform parabolic motion
    public void performParabolicMotion() {
        dx = 2; 
        dy = 1; 
    }

    // Method to perform circular motion
    public void performCircularMotion() {
        double angle = Math.toRadians(2); 
        dx = (int) (radius * Math.cos(angle)); 
        dy = (int) (radius * Math.sin(angle)); 
    }

    // Method to perform sinusoidal motion
    public void performSinusoidalMotion() {
        dx = 2; 
        dy = (int) (10 * Math.sin(x * Math.PI / 180)); 
    }

    // Method to perform elliptical motion
    public void performEllipticalMotion() {
        dx = 2; 
        dy = (int) (2 * Math.sqrt(1 - ((x * x) / (radius * radius)))); 
    }

    // Method to perform infinity symbol motion
    public void performInfinityMotion() {
        dx = (int) (2 * (radius * Math.cos(x))); 
        dy = (int) (2 * (radius * Math.sin(x) * Math.cos(x))); 
    }


    // Move the ball
    private void move() {
        if (x <= 600) {
            x += dx;
        } else {
            x = -15;
        }

        if (y <= 600) {
            y += dy;
        } else {
            y = -15;
        }
    }

    // Method to set velocity based on speed level
    public void setVelocity(int speedLevel) {
        switch (speedLevel) {
            case SLOW_SPEED:
                dx = 1;
                dy = 1;
                break;
            case MEDIUM_SPEED:
                dx = 2;
                dy = 2;
                break;
            case FAST_SPEED:
                dx = 3;
                dy = 3;
                break;
            default:
                // Default to medium speed
                dx = 2;
                dy = 2;
                break;
        }
    }

    // Method to generate a random x-coordinate
    public int generateX() {
        return random.nextInt(601);
    }

    // Method to generate a random y-coordinate
    public int generateY() {
        return random.nextInt(601);
    }

}
