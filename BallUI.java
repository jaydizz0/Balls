import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
public class BallUI {
    private static JFrame frame;
    private BallController ballController;
    private BallPanel ballPanel;
    private CreateBall createBall;
    private Random random;

    public BallUI(BallController bc, BallPanel bp) {
        this.ballController = bc;
        this.ballPanel = bp;

    }

    public void createAndShowUI() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                random = new Random();
                // Create the frame
                frame = new JFrame("A World of Balls");
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setPreferredSize(new Dimension(800, 600)); // Adjusted frame size

                // Add BallPanel to the frame's content pane
                frame.getContentPane().add(ballPanel, BorderLayout.CENTER);

                // Menu Bars
                MenuBar menuBar = new MenuBar(ballController, ballPanel);
                JMenu speedMenu = menuBar.getSpeedMenu();
                JMenu motionMenu = menuBar.getMotionMenu();
                JMenu ballColorMenu = menuBar.getBallColorMenu();

                // Add the menu bars to GUI
                JMenuBar menuBarGUI = new JMenuBar();
                menuBarGUI.add(speedMenu);
                menuBarGUI.add(motionMenu);
                menuBarGUI.add(ballColorMenu);
                frame.setJMenuBar(menuBarGUI);

                // Create buttons panel with background color
                JPanel buttonPanel = new JPanel() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        g.setColor(Color.GRAY);
                        g.fillRect(0, 0, getWidth(), getHeight());
                    }
                };

                JButton start = new JButton("START");
                JButton stop = new JButton("STOP");
                JButton addBall = new JButton("Add Ball");
                JButton removeBall = new JButton("Remove Ball");
                JButton backgroundColor = new JButton("Background Color");

                // Add action listeners to buttons
                start.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ballPanel.startTimer();
                    }
                });

                stop.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ballPanel.stopTimer();
                    }
                });

                addBall.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ballController.addBall(); // Call the addBall method in BallController
                        ballPanel.repaint(); // Repaint the panel to show the new ball
                    }
                });

                removeBall.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    ballController.removeBall();
                    }
                });

                backgroundColor.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                    }
                });

                buttonPanel.add(start);
                buttonPanel.add(stop);
                buttonPanel.add(backgroundColor);
                buttonPanel.add(addBall);
                buttonPanel.add(removeBall);

                buttonPanel.setPreferredSize(new Dimension(800, 40)); // Adjusted panel size
                frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH); // Add button panel to SOUTH

                // Pack and display the frame
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
