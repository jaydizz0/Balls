import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class BallUI {
    private JFrame frame;
    private BallController ballController;
    private ArrayList<BallPanel> ballPanels = new ArrayList<>();

    public BallUI(BallController bc) {
        this.ballController = bc;

    }

    public void createAndShowUI() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Create the frame
                frame = new JFrame("A World of Balls");
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setPreferredSize(new Dimension(800, 600)); // Adjusted frame size
            
                // Menu Bars
                MenuBar menuBar = new MenuBar(ballController);
                JMenu speedMenu = menuBar.getSpeedMenu();
                JMenu motionMenu = menuBar.getMotionMenu();

                // Add the menu bars to GUI
                JMenuBar menuBarGUI = new JMenuBar();
                menuBarGUI.add(speedMenu);
                menuBarGUI.add(motionMenu);
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
                        for (BallPanel ballPanel : ballPanels) {
                            ballPanel.startTimer();
                        }
                        
                    }
                });

                stop.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for (BallPanel ballPanel : ballPanels) {
                            ballPanel.stopTimer();
                        }
                        
                    }
                });

                addBall.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {  
                        addBall(ballController);
                        
                    }
                });

                removeBall.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ballController.removeBall();
                        frame.getContentPane().revalidate();
                        frame.repaint();
                        
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

                buttonPanel.setPreferredSize(new Dimension(800, 40)); 
                frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

                frame.pack();
                frame.setVisible(true);
            }

            private CreateBall addBall(BallController ballController) {
                CreateBall ball = ballController.addBall();
                BallPanel ballPanel = new BallPanel(ballController); 
                ballPanels.add(ballPanel);
                frame.getContentPane().add(ballPanel, BorderLayout.CENTER);
                frame.getContentPane().revalidate();
                return ball;
            }

            
        });
    }
}
