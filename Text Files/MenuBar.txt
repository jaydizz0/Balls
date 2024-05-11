import javax.swing.*;
import java.awt.*;
import java.io.*;

public class MenuBar {
    private JMenu speedMenu;
    private JMenu motionMenu;
    private JMenu ballColorMenu;

    public MenuBar() {
        // Speed Menu
        speedMenu = new JMenu("Speed");
        speedMenu.addSeparator();
        ImageIcon lowIcon = new ImageIcon(resizeImage("images/turtle.png", 10, 10));
        ImageIcon mediumIcon = new ImageIcon(resizeImage("images/hare.png", 10, 10));
        ImageIcon highIcon = new ImageIcon(resizeImage("images/cheetah.png", 10, 10));

        JRadioButtonMenuItem low = new JRadioButtonMenuItem("Low Speed");
        low.setIcon(lowIcon);
        JRadioButtonMenuItem medium = new JRadioButtonMenuItem("Medium Speed");
        medium.setIcon(mediumIcon);
        JRadioButtonMenuItem high = new JRadioButtonMenuItem("High Speed");
        high.setIcon(highIcon);

        speedMenu.add(low);
        speedMenu.add(medium);
        speedMenu.add(high);

        // Motion Menu
        motionMenu = new JMenu("Motion");
        motionMenu.addSeparator();

        ImageIcon linearIcon = new ImageIcon(resizeImage("images/linear.jpeg", 10, 10));
        ImageIcon parabolicIcon = new ImageIcon(resizeImage("images/parabola.png", 10, 10));
        ImageIcon circularIcon = new ImageIcon(resizeImage("images/circular.jpeg", 10, 10));
        ImageIcon sinusodialIcon = new ImageIcon(resizeImage("images/sinusodial.png", 10, 10));
        ImageIcon infinityIcon = new ImageIcon(resizeImage("images/infinity.jpg", 10, 10));
        ImageIcon eclipseIcon = new ImageIcon(resizeImage("images/eclispe.png", 10, 10));

        JRadioButtonMenuItem linear = new JRadioButtonMenuItem("Linear");
        linear.setIcon(linearIcon);
        JRadioButtonMenuItem parabolic = new JRadioButtonMenuItem("Parabolic");
        parabolic.setIcon(parabolicIcon);
        JRadioButtonMenuItem circular = new JRadioButtonMenuItem("Circular");
        circular.setIcon(circularIcon);
        JRadioButtonMenuItem sinusodial = new JRadioButtonMenuItem("Sinusoidal");
        sinusodial.setIcon(sinusodialIcon);
        JRadioButtonMenuItem infinity = new JRadioButtonMenuItem("Infinity");
        infinity.setIcon(infinityIcon);
        JRadioButtonMenuItem eclipse = new JRadioButtonMenuItem("Eclipse");
        eclipse.setIcon(eclipseIcon);

        motionMenu.add(linear);
        motionMenu.add(parabolic);
        motionMenu.add(circular);
        motionMenu.add(sinusodial);
        motionMenu.add(infinity);
        motionMenu.add(eclipse);

        // Ball Color Menu
        ballColorMenu = new JMenu("Ball Color");
        ballColorMenu.addSeparator();

        ImageIcon rainbowIcon = new ImageIcon(resizeImage("images/rainbow.jpeg", 10, 10));
        ImageIcon redIcon = new ImageIcon(resizeImage("images/red.png", 10, 10));
        ImageIcon greenIcon = new ImageIcon(resizeImage("images/greeen.png", 10, 10));
        ImageIcon blueIcon = new ImageIcon(resizeImage("images/blue.png", 10, 10));

        JRadioButtonMenuItem rainbowBalls = new JRadioButtonMenuItem("Rainbow");
        rainbowBalls.setIcon(rainbowIcon);
        JRadioButtonMenuItem redBalls = new JRadioButtonMenuItem("Red");
        redBalls.setIcon(redIcon);
        JRadioButtonMenuItem greenBalls = new JRadioButtonMenuItem("Green");
        greenBalls.setIcon(greenIcon);
        JRadioButtonMenuItem blueBalls = new JRadioButtonMenuItem("Blue");
        blueBalls.setIcon(blueIcon);

        ballColorMenu.add(rainbowBalls);
        ballColorMenu.add(redBalls);
        ballColorMenu.add(greenBalls);
        ballColorMenu.add(blueBalls);
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

    private Image resizeImage(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(path);
        return icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }
}
