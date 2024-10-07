import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class ScientificCalculator extends JFrame implements ActionListener {
    private JTextField display;
    private String operator;
    private double num1, num2;

    public ScientificCalculator() {
        // Create the JFrame
        setTitle("Scientific Calculator");
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the display field
        display = new JTextField();
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        // Create the panel for buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 4));

        // Add buttons for digits and operations
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "sin", "cos", "tan", "sqrt",
            "C", "(", ")", "^"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.charAt(0) >= '0' && command.charAt(0) <= '9' || command.equals(".")) {
            // Handle number and decimal point
            display.setText(display.getText() + command);
        } else if (command.equals("C")) {
            // Clear the display
            display.setText("");
        } else if (command.equals("=")) {
            // Perform calculation
            num2 = Double.parseDouble(display.getText());
            switch (operator) {
                case "+":
                    display.setText(String.valueOf(num1 + num2));
                    break;
                case "-":
                    display.setText(String.valueOf(num1 - num2));
                    break;
                case "*":
                    display.setText(String.valueOf(num1 * num2));
                    break;
                case "/":
                    display.setText(String.valueOf(num1 / num2));
                    break;
                case "sin":
                    display.setText(String.valueOf(Math.sin(Math.toRadians(num2))));
                    break;
                case "cos":
                    display.setText(String.valueOf(Math.cos(Math.toRadians(num2))));
                    break;
                case "tan":
                    display.setText(String.valueOf(Math.tan(Math.toRadians(num2))));
                    break;
                case "sqrt":
                    display.setText(String.valueOf(Math.sqrt(num2)));
                    break;
                case "^":
                    display.setText(String.valueOf(Math.pow(num1, num2)));
                    break;
            }
        } else {
            // Save the operator and the first number
            if (!display.getText().isEmpty()) {
                num1 = Double.parseDouble(display.getText());
            }
            operator = command;
            display.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ScientificCalculator calculator = new ScientificCalculator();
            calculator.setVisible(true);
        });
    }
}
