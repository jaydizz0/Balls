import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar {
    private JMenu speedMenu;
    private JMenu motionMenu;
    private JMenu colorMenu;
    private BallController ballController;
    public MenuBar(BallController ballController) {
        this.ballController = ballController;


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
                    for(CreateBall ball : ballController.getListOfBalls()){
                        ball.setDx(1);
                        ball.setDy(1);
                    }
                    mediumSpeed.setSelected(false);
                    highSpeed.setSelected(false);
                }
            }
        });

        mediumSpeed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mediumSpeed.isSelected()) {
                    for(CreateBall ball : ballController.getListOfBalls()){
                        ball.setDx(2);
                        ball.setDy(2);
                    }
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
                    for(CreateBall ball : ballController.getListOfBalls()){
                        ball.setDx(3);
                        ball.setDy(3);
                    }
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

        // Initialize color menu
        colorMenu = new JMenu("Change Color");
        colorMenu.addSeparator();

        // Create a ButtonGroup for color menu
        ButtonGroup colorGroup = new ButtonGroup();

        // Add radio buttons for each color option
        JRadioButtonMenuItem rainbowColor = new JRadioButtonMenuItem("Rainbow");
        JRadioButtonMenuItem redColor = new JRadioButtonMenuItem("Red");
        JRadioButtonMenuItem blueColor = new JRadioButtonMenuItem("Blue");
        JRadioButtonMenuItem greenColor = new JRadioButtonMenuItem("Green");

        // Add radio buttons to the ButtonGroup
        colorGroup.add(rainbowColor);
        colorGroup.add(redColor);
        colorGroup.add(blueColor);
        colorGroup.add(greenColor);

        // Add radio buttons to the color menu
        colorMenu.add(rainbowColor);
        colorMenu.add(redColor);
        colorMenu.add(blueColor);
        colorMenu.add(greenColor);

        // Add action listeners to handle selection/deselection for color
        rainbowColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rainbowColor.isSelected()) {
                    for(CreateBall ball : ballController.getListOfBalls()){
                        ball.setColor(ballController.generateRandomColor());
                    }
                    // Deselect other speed options if needed
                    redColor.setSelected(false);
                    blueColor.setSelected(false);
                    greenColor.setSelected(false);

                }
            }
        });

        blueColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (blueColor.isSelected()) {
                    for(CreateBall ball : ballController.getListOfBalls()){
                        ball.setColor(Color.BLUE);
                    }
                    // Deselect other speed options if needed
                    redColor.setSelected(false);
                    blueColor.setSelected(false);
                    rainbowColor.setSelected(false);

                }
            }
        });
        greenColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (greenColor.isSelected()) {
                    for(CreateBall ball : ballController.getListOfBalls()){
                        ball.setColor(Color.GREEN);
                    }
                    // Deselect other speed options if needed
                    redColor.setSelected(false);
                    blueColor.setSelected(false);
                    rainbowColor.setSelected(false);

                }
            }
        });
        redColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (redColor.isSelected()) {
                    for(CreateBall ball : ballController.getListOfBalls()){
                        ball.setColor(Color.RED);
                    }
                    // Deselect other speed options if needed
                    rainbowColor.setSelected(false);
                    blueColor.setSelected(false);
                    greenColor.setSelected(false);

                }
            }
        });
    
        // Add action listeners to handle selection/deselection
        linearMotion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (linearMotion.isSelected()) {
                    for(CreateBall ball: ballController.getListOfBalls()){
                        ball.setMotion(Motion.LINEAR_MOTION);
                        ballController.moveBalls();
                    }
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
                    for(CreateBall ball : ballController.getListOfBalls()){
                        ball.setMotion(Motion.PARABOLIC_MOTION);
                    }
                    
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
                    for(CreateBall ball : ballController.getListOfBalls()){
                        ball.setMotion(Motion.CIRCULAR_MOTION);
                    }
                   
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
                    for(CreateBall ball : ballController.getListOfBalls()){
                        ball.setMotion(Motion.SINUSOIDAL_MOTION);
                    }
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
                    for(CreateBall ball : ballController.getListOfBalls()){
                        ball.setMotion(Motion.ELLIPTICAL_MOTION);
                    }
              
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
                    for(CreateBall ball : ballController.getListOfBalls()){
                        ball.setMotion(Motion.INFINITY_MOTION);
                    }
                    linearMotion.setSelected(false);
                    circularMotion.setSelected(false);
                    sinusoidalMotion.setSelected(false);
                    ellipticalMotion.setSelected(false);
                    parabolicMotion.setSelected(false);
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

    public JMenu getColorMenu(){
        return colorMenu;
    }

}
