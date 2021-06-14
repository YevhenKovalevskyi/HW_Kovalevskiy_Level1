package ru.geekbrains.homeworks.hw08.task1.components;

import javax.swing.*;
import java.awt.*;

/**
 * CalculatorFrame Class represents the !!!!!!!!
 *
 * @author e.kovalevskiy
 * @version 1.0
 */
public class CalculatorFrame extends JFrame {
    
    static int frameWidth, frameHeight, xCoord, yCoord;
    
    static {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    
        frameWidth = 320;
        frameHeight = 500;
        xCoord = (int)size.getWidth() / 2 - frameWidth / 2;
        yCoord = (int)size.getHeight() / 2 - frameHeight / 2;
    }
    
    public CalculatorFrame() {
        setTitle("Calculator v1.0");
        setBounds(xCoord, yCoord, frameWidth, frameHeight);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());
    
        InputPanel inputPanel = new InputPanel();
        ControlsPanel controlsPanel = new ControlsPanel(inputPanel.getInputField());
        
        add(inputPanel.getInputPanel(), BorderLayout.NORTH);
        add(controlsPanel.getControlsPanel(), BorderLayout.CENTER);
    
        setVisible(true);
    }
}
