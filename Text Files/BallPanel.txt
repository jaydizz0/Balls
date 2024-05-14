import javax.swing.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BallPanel extends JPanel implements ActionListener {
    

    private int delay = 1000 / 60;
    protected Timer timer;
    private final BallController ballController;   
    
    // Constructor
    public BallPanel(BallController ballController) {
        timer = new Timer(delay, this); 
        this.ballController = ballController;
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
        ballController.moveBalls();
        repaint();
    }
    
    // Itterates through Array list to paint all the balls to the screen
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (CreateBall ball : ballController.getListOfBalls()) {
            g.setColor(ball.getColor());
            double x = ball.getX() - ball.getRadius();
            double y = ball.getY() - ball.getRadius();
            double diameter = ball.getRadius() * 2;
            g.fillOval((int)x, (int)y, (int)diameter, (int)diameter);
        }
    }

    

}
