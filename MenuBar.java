import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar {
    private JMenu speedMenu;
    private JMenu motionMenu;
    private JMenu ballColorMenu;
   

    public MenuBar(BallController ballController, BallPanel ballPanel) {
   

        // Initialize speed menu
        speedMenu = new JMenu("Speed");
        speedMenu.addSeparator();

        // Create a ButtonGroup for speed menu
        ButtonGroup speedGroup = new ButtonGroup();

        // Add radio buttons for each speed level
        JRadioButtonMenuItem lowSpeed = new JRadioButtonMenuItem("Low Speed");
        JRadioButtonMenuItem mediumSpeed = new JRadioButtonMenuItem("Medium Speed");
        JRadioButtonMenuItem highSpeed = new JRadioButtonMenuItem("High Speed");

        // Add radio buttons to the ButtonGroup
        speedGroup.add(lowSpeed);
        speedGroup.add(mediumSpeed);
        speedGroup.add(highSpeed);

        // Add radio buttons to the speed menu
        speedMenu.add(lowSpeed);
        speedMenu.add(mediumSpeed);
        speedMenu.add(highSpeed);

        // Add action listeners to handle selection/deselection
        lowSpeed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lowSpeed.isSelected()) {
                    // Set low speed
                    ballPanel.setVelocity(1);
                    // Deselect other speed options if needed
                    mediumSpeed.setSelected(false);
                    highSpeed.setSelected(false);
                }
            }
        });

        mediumSpeed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mediumSpeed.isSelected()) {
                    // Set medium speed
                    ballPanel.setVelocity(2);
                    // Deselect other speed options if needed
                    lowSpeed.setSelected(false);
                    highSpeed.setSelected(false);
                }
            }
        });

        highSpeed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (highSpeed.isSelected()) {
                    // Set high speed
                    ballPanel.setVelocity(3);
                    // Deselect other speed options if needed
                    lowSpeed.setSelected(false);
                    mediumSpeed.setSelected(false);
                }
            }
        });


        // Initialize motion menu
        motionMenu = new JMenu("Motion");
        motionMenu.addSeparator();

        // Create a ButtonGroup for motion menu
        ButtonGroup motionGroup = new ButtonGroup();

        // Add radio buttons for each motion type
        JRadioButtonMenuItem linearMotion = new JRadioButtonMenuItem("Linear");
        JRadioButtonMenuItem parabolicMotion = new JRadioButtonMenuItem("Parabolic");
        JRadioButtonMenuItem circularMotion = new JRadioButtonMenuItem("Circular");
        JRadioButtonMenuItem sinusoidalMotion = new JRadioButtonMenuItem("Sinusoidal");
        JRadioButtonMenuItem ellipticalMotion = new JRadioButtonMenuItem("Ellipse");
        JRadioButtonMenuItem infinityMotion = new JRadioButtonMenuItem("Infinity");

        // Add radio buttons to the ButtonGroup
        motionGroup.add(linearMotion);
        motionGroup.add(parabolicMotion);
        motionGroup.add(circularMotion);
        motionGroup.add(sinusoidalMotion);
        motionGroup.add(ellipticalMotion);
        motionGroup.add(infinityMotion);

        // Add radio buttons to the motion menu
        motionMenu.add(linearMotion);
        motionMenu.add(parabolicMotion);
        motionMenu.add(circularMotion);
        motionMenu.add(sinusoidalMotion);
        motionMenu.add(ellipticalMotion);
        motionMenu.add(infinityMotion);

        // Add action listeners to handle selection/deselection
        linearMotion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (linearMotion.isSelected()) {
                    ballPanel.performLinearMotion();
                    // Deselect other motion options if needed
                    parabolicMotion.setSelected(false);
                    circularMotion.setSelected(false);
                    sinusoidalMotion.setSelected(false);
                    ellipticalMotion.setSelected(false);
                    infinityMotion.setSelected(false);
                }
            }
        });

        parabolicMotion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (parabolicMotion.isSelected()) {
                    ballPanel.performParabolicMotion();
                    // Deselect other motion options if needed
                    linearMotion.setSelected(false);
                    circularMotion.setSelected(false);
                    sinusoidalMotion.setSelected(false);
                    ellipticalMotion.setSelected(false);
                    infinityMotion.setSelected(false);
                }
            }
        });

        circularMotion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (circularMotion.isSelected()) {
                    ballPanel.performCircularMotion();
                    linearMotion.setSelected(false);
                    parabolicMotion.setSelected(false);
                    sinusoidalMotion.setSelected(false);
                    ellipticalMotion.setSelected(false);
                    infinityMotion.setSelected(false);
                }
            }
        });

        sinusoidalMotion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sinusoidalMotion.isSelected()) {
                    ballPanel.performSinusoidalMotion();
                    // Deselect other motion options if needed
                    linearMotion.setSelected(false);
                    circularMotion.setSelected(false);
                    parabolicMotion.setSelected(false);
                    ellipticalMotion.setSelected(false);
                    infinityMotion.setSelected(false);
                }
            }
        });
        ellipticalMotion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ellipticalMotion.isSelected()) {
                    ballPanel.performEllipticalMotion();
                    // Deselect other motion options if needed
                    linearMotion.setSelected(false);
                    circularMotion.setSelected(false);
                    sinusoidalMotion.setSelected(false);
                    parabolicMotion.setSelected(false);
                    infinityMotion.setSelected(false);
                }
            }
        });
        infinityMotion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (infinityMotion.isSelected()) {
                    ballPanel.performInfinityMotion();
                    // Deselect other motion options if needed
                    linearMotion.setSelected(false);
                    circularMotion.setSelected(false);
                    sinusoidalMotion.setSelected(false);
                    ellipticalMotion.setSelected(false);
                    parabolicMotion.setSelected(false);
                }
            }
        });


            // Initialize ball color menu
        ballColorMenu = new JMenu("Ball Color");
        ballColorMenu.addSeparator();

        // Create a ButtonGroup for ball color menu
        ButtonGroup colorGroup = new ButtonGroup();

        // Add radio buttons for each color option
        JRadioButtonMenuItem redColor = new JRadioButtonMenuItem("Red");
        JRadioButtonMenuItem greenColor = new JRadioButtonMenuItem("Green");
        JRadioButtonMenuItem blueColor = new JRadioButtonMenuItem("Blue");

        // Add radio buttons to the ButtonGroup
        colorGroup.add(redColor);
        colorGroup.add(greenColor);
        colorGroup.add(blueColor);

        // Add radio buttons to the color menu
        ballColorMenu.add(redColor);
        ballColorMenu.add(greenColor);
        ballColorMenu.add(blueColor);

        // Add action listeners to handle selection/deselection

        redColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (redColor.isSelected()) {
                    // Set red color
                    ballController.setBallColor(Color.RED);
                    for (CreateBall ball : ballController.getListOfBalls()) {
                        ball.setColor(Color.RED);
                    }
                    greenColor.setSelected(false);
                    blueColor.setSelected(false);
                }
            }
        });

        greenColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (greenColor.isSelected()) {
                    // Set green color
                    for (CreateBall ball : ballController.getListOfBalls()) {
                        ball.setColor(Color.GREEN);
                    }
                    // Deselect other color options if needed
                    redColor.setSelected(false);
                    blueColor.setSelected(false);
                }
            }
        });

        blueColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (blueColor.isSelected()) {
                    // Set blue color
                    for (CreateBall ball : ballController.getListOfBalls()) {
                        ball.setColor(Color.BLUE);
                    }
                    redColor.setSelected(false);
                    greenColor.setSelected(false);
                }
            }
        });
    }

    public JMenu getSpeedMenu() {
        return speedMenu;
    }

    public JMenu getMotionMenu() {
        return motionMenu;
    }

    public JMenu getBallColorMenu() {
        return ballColorMenu;
    }

}



