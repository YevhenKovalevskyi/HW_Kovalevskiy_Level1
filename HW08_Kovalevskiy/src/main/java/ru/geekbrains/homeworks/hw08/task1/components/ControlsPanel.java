package ru.geekbrains.homeworks.hw08.task1.components;

import com.google.common.math.BigIntegerMath;
import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.regex.Pattern;

@EqualsAndHashCode(callSuper = true)
@Value
public class ControlsPanel extends JPanel {
    
    JPanel controlsPanel = new JPanel();
    JTextField inputField;
    
    ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine engine = mgr.getEngineByName("JavaScript");
    
    public ControlsPanel(JTextField inputField) {
        this.inputField = inputField;
        
        controlsPanel.setLayout(new GridLayout(6, 4, 4, 4));
        controlsPanel.setBorder(BorderFactory.createEmptyBorder(4, 8, 8, 8));
    
        JButton[] buttons = {
                getPiButton(), getExpButton(), getClearButton(), getDeleteButton(),
                getOpenBracketButton(), getCloseBracketButton(), getFactorialButton(), getDivisionButton(),
                getDigitButton("7"), getDigitButton("8"), getDigitButton("9"), getMultiplyButton(),
                getDigitButton("4"), getDigitButton("5"), getDigitButton("6"), getSubtractionButton(),
                getDigitButton("1"), getDigitButton("2"), getDigitButton("3"), getAdditionButton(),
                getMinusPlusButton(), getDigitButton("0"), getDotButton(), getResultButton(),
        };
    
        Arrays.stream(buttons).forEach(button -> {
            button.setFont(new Font("SansSerif", Font.PLAIN, 20));
            button.setFocusPainted(false);
            controlsPanel.add(button);
        });
    }
    
    private JButton getDigitButton(String btnText) {
        JButton button = new JButton(btnText);
        
        button.addActionListener(e -> {
            String currText = inputField.getText();
            String btnValue = ((JButton) e.getSource()).getText();
            
            if (currText.equals(InputPanel.INPUT_DEFAULT_VALUE)) {
                inputField.setText(btnValue);
            } else {
                if (btnValue.equals(InputPanel.INPUT_DEFAULT_VALUE)) {
                    String[] operands  = currText.split("\u2215|\u2217|\u2212|\uFF0B");
                    String lastOperand = operands[operands.length - 1];
                    boolean skip = currText.endsWith("\u2215") || (lastOperand.equals(InputPanel.INPUT_DEFAULT_VALUE));
    
                    if (!skip) {
                        inputField.setText(currText + btnValue);
                    }
                } else {
                    inputField.setText(currText + btnValue);
                }
            }
        });
        
        return button;
    }
    
    private JButton getClearButton() {
        JButton button = new JButton("C");
    
        button.addActionListener(e -> {
            String currText = inputField.getText();
            
            if (!currText.equals(InputPanel.INPUT_DEFAULT_VALUE)) {
                inputField.setText(InputPanel.INPUT_DEFAULT_VALUE);
            }
        });
        
        return button;
    }
    
    private JButton getDeleteButton() {
        JButton button = new JButton("\u232B");
    
        button.addActionListener(e -> {
            String currText = inputField.getText();
    
            if (!currText.equals(InputPanel.INPUT_DEFAULT_VALUE)) {
                int length = currText.length();
                String inputText = (length == 1) ? InputPanel.INPUT_DEFAULT_VALUE : currText.substring(0, length - 1);
                
                inputField.setText(inputText);
            }
        });
        
        return button;
    }
    
    private JButton getFactorialButton() {
        JButton button = new JButton("n!");
        
        button.addActionListener(e -> {
            String currText = inputField.getText();
            
            if (Pattern.compile("^\\d+$").matcher(currText).find()) {
                int number = Integer.parseInt(currText);
                
                if (number > 24) {
                    JOptionPane.showMessageDialog(null, "Number is too large to display the result!");
                } else {
                    inputField.setText(BigIntegerMath.factorial(number).toString());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Number has to be integer!");
            }
        });
        
        return button;
    }
    
    private JButton getPiButton() {
        JButton button = new JButton("\u03C0");
        
        button.addActionListener(e -> inputField.setText(String.valueOf(Math.PI)));
        
        return button;
    }
    
    private JButton getExpButton() {
        JButton button = new JButton("e");
        
        button.addActionListener(e -> inputField.setText(String.valueOf(Math.E)));
        
        return button;
    }
    
    private JButton getDivisionButton() {
        JButton button = new JButton("\u2215");
    
        button.addActionListener(event -> {
            handleArithmeticButtonAction(inputField, event);
        });
        
        return button;
    }
    
    private JButton getMultiplyButton() {
        JButton button = new JButton("\u2217");
    
        button.addActionListener(event -> {
            handleArithmeticButtonAction(inputField, event);
        });
        
        return button;
    }
    
    private JButton getSubtractionButton() {
        JButton button = new JButton("\u2212");
    
        button.addActionListener(event -> {
            handleArithmeticButtonAction(inputField, event);
        });
        
        return button;
    }
    
    private JButton getAdditionButton() {
        JButton button = new JButton("\uFF0B");
    
        button.addActionListener(event -> {
            handleArithmeticButtonAction(inputField, event);
        });
        
        return button;
    }
    
    private JButton getDotButton() {
        JButton button = new JButton("\u22C5");
        String dotSign = ".";
        
        button.addActionListener(e -> {
            String currText = inputField.getText();
    
            if (Pattern.compile("\\d$").matcher(currText).find()) {
                inputField.setText(currText + dotSign);
            }
        });
        
        return button;
    }
    
    private JButton getMinusPlusButton() {
        JButton button = new JButton("\u2213");
        
        button.addActionListener(e -> {
            String currText = inputField.getText();
    
            if (!currText.equals(InputPanel.INPUT_DEFAULT_VALUE)) {
                if (Pattern.compile("\\d$").matcher(currText).find()) {
                    String[] operands = currText.split("\u2215|\u2217|\u2212|\uFF0B");
                    int operandsCount = operands.length;
                    int currTextLength = currText.length();
                    
                    if (operandsCount == 2) {
                        String lastOperand = operands[operandsCount - 1];
                        int endIndex = currTextLength - lastOperand.length();
                        
                        inputField.setText(currText.substring(0, endIndex) + "(\u2212" + lastOperand + ")");
                    } else {
                        if (!currText.matches("^\\d+")) {
                            inputField.setText(currText.substring(1));
                        } else {
                            inputField.setText("\u2212" + currText);
                        }
                    }
                }
            }
        });
        
        return button;
    }
    
    private JButton getResultButton() {
        JButton button = new JButton("\uFF1D");
        
        button.addActionListener(e -> {
            String currText = inputField.getText();
            
            if (!currText.equals(InputPanel.INPUT_DEFAULT_VALUE)) {
                inputField.setText(calculate(currText));
            }
        });
        
        return button;
    }
    
    private String calculate(String formula) {
        String replacedFormula = formula.replace("\u2212", "-").replace("\uFF0B", "+").replace("\u2217", "*")
                .replace("\u2215", "/");
        
        try {
            return engine.eval(replacedFormula).toString();
        } catch (ScriptException e) {
            JOptionPane.showMessageDialog(null, "Calculation error detected!");
            e.printStackTrace();
            return InputPanel.INPUT_DEFAULT_VALUE;
        }
    }
    
    private void handleArithmeticButtonAction(JTextField inputField, ActionEvent event) {
        String currText = inputField.getText();
        
        if (Pattern.compile("\\d$").matcher(currText).find()) {
            String btnValue   = ((JButton) event.getSource()).getText();
            int operandsCount = currText.split("\u2215|\u2217|\u2212|\uFF0B").length;
            String newText    = (operandsCount == 2) ? calculate(currText) : currText;
            
            inputField.setText(newText + btnValue);
        }
    }
    
    /* For the future */
    private JButton getOpenBracketButton() {
        JButton button = new JButton("(");
        
        button.addActionListener(e -> {
            String currText = inputField.getText();
            inputField.setText(currText + ((JButton) e.getSource()).getText());
        });
        
        return button;
    }
    
    /* For the future */
    private JButton getCloseBracketButton() {
        JButton button = new JButton(")");
        
        button.addActionListener(e -> {
            String currText = inputField.getText();
            inputField.setText(currText + ((JButton) e.getSource()).getText());
        });
        
        return button;
    }
}
