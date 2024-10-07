import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class TrafficSignalSimulation extends JFrame implements ItemListener {
    private JPanel signalPanel;
    private JLabel signalLabel;
    private ButtonGroup buttonGroup;

    public TrafficSignalSimulation() {
        // Set up the JFrame
        setTitle("Traffic Signal Simulation");
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the JPanel for the traffic signal
        signalPanel = new JPanel();
        signalLabel = new JLabel("Select a signal:");
        signalPanel.setPreferredSize(new Dimension(200, 200));

        // Create radio buttons for traffic signals
        JRadioButton redButton = new JRadioButton("Red");
        JRadioButton yellowButton = new JRadioButton("Yellow");
        JRadioButton greenButton = new JRadioButton("Green");

        // Group the radio buttons
        buttonGroup = new ButtonGroup();
        buttonGroup.add(redButton);
        buttonGroup.add(yellowButton);
        buttonGroup.add(greenButton);

        // Add item listeners to the radio buttons
        redButton.addItemListener(this);
        yellowButton.addItemListener(this);
        greenButton.addItemListener(this);

        // Create a panel for the radio buttons
        JPanel radioPanel = new JPanel();
        radioPanel.add(redButton);
        radioPanel.add(yellowButton);
        radioPanel.add(greenButton);

        // Add components to the JFrame
        add(signalLabel, BorderLayout.NORTH);
        add(radioPanel, BorderLayout.CENTER);
        add(signalPanel, BorderLayout.SOUTH);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        // Handle radio button selection
        if (e.getStateChange() == ItemEvent.SELECTED) {
            String selectedSignal = ((JRadioButton) e.getSource()).getText();
            updateSignal(selectedSignal);
        }
    }

    private void updateSignal(String signal) {
        // Update the signal display
        signalPanel.removeAll();
        signalPanel.revalidate();
        signalPanel.repaint();

        // Create colored circles to represent traffic signals
        Color color;
        switch (signal) {
            case "Red":
                color = Color.RED;
                break;
            case "Yellow":
                color = Color.YELLOW;
                break;
            case "Green":
                color = Color.GREEN;
                break;
            default:
                color = Color.GRAY; // Default case (shouldn't happen)
                break;
        }

        // Create a colored circle for the selected signal
        JPanel circle = new JPanel();
        circle.setBackground(color);
        circle.setPreferredSize(new Dimension(100, 100));
        circle.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        signalPanel.add(circle);
        
        // Refresh the signal panel to show the new color
        signalPanel.revalidate();
        signalPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TrafficSignalSimulation simulation = new TrafficSignalSimulation();
            simulation.setVisible(true);
        });
    }
}
