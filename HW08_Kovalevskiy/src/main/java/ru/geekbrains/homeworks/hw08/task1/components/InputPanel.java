package ru.geekbrains.homeworks.hw08.task1.components;

import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.swing.*;
import java.awt.*;

@EqualsAndHashCode(callSuper = true)
@Value
public class InputPanel extends JPanel  {

    public static final String INPUT_DEFAULT_VALUE = "0";
    
    JPanel inputPanel = new JPanel();
    JTextField inputField = new JTextField();
    
    public InputPanel() {
        inputPanel.setLayout(new BorderLayout());
        inputPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 4, 8));
        inputPanel.add(fillInputField(inputPanel), BorderLayout.CENTER);
    }
    
    private JTextField fillInputField(JPanel inputPanel) {
        inputField.setEditable(false);
        inputField.setPreferredSize(new Dimension(inputPanel.getWidth(), 45));
        inputField.setBackground(Color.WHITE);
        inputField.setFont(new Font("SansSerif", Font.PLAIN, 20));
        inputField.setHorizontalAlignment(JTextField.RIGHT);
        inputField.setMargin(new Insets(0, 5, 0, 5));
        inputField.setText(INPUT_DEFAULT_VALUE);
        
        return inputField;
    }
}
