import java.awt.*;
import javax.swing.*;

public class BouncingBalls {
   
    public static void main(String[] args) {

        // Run UI in the Event Dispatcher Thread (EDT), instead of Main thread
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                
             
                // Create the frame
                JFrame frame = new JFrame("A World of Balls");
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setPreferredSize(new Dimension(600,600));

                // Create a JPanel for the content
                JPanel contentPane = new JPanel();
                // frame.setContentPane(contentPane); not sure why this messes up, I comented this so I could position my buttons properly
                frame.getContentPane().add(contentPane, BorderLayout.SOUTH);

                // Menu Bars
                MenuBar menuBar = new MenuBar();
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
                JButton backgroundColor = new JButton("Background Color");
                buttonPanel.add(start);
                buttonPanel.add(stop);
                buttonPanel.add(backgroundColor);
              
                buttonPanel.setPreferredSize(new Dimension(600,40));
                contentPane.add(buttonPanel, BorderLayout.CENTER);

                // Pack and display the frame
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}




    
