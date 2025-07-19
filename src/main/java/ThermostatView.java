import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class ThermostatView extends JFrame {
  private final JTextField tempInput = new JTextField(5);
  private final JButton setTempButton = new JButton("Set Temperature");
  private final JLabel currentLabel = new JLabel("Current Temp: ");
  private final JLabel targetLabel = new JLabel("Target Temp: ");
  private final JLabel statusLabel = new JLabel("Status: ");
  private final JLabel messageLabel = new JLabel();

  public ThermostatView() {
    setTitle("Thermostat");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new GridLayout(6, 1));
    setSize(300, 200);

    add(currentLabel);
    add(targetLabel);
    add(statusLabel);

    JPanel inputPanel = new JPanel();
    inputPanel.add(new JLabel("Set Temp: "));
    inputPanel.add(tempInput);
    inputPanel.add(setTempButton);
    add(inputPanel);

    add(messageLabel);

    setVisible(true);
  }

  public void addListener(ActionListener a) {
    setTempButton.addActionListener(a);
  }

  public String getTempInput() {
    return tempInput.getText();
  }

  public void clearInput() {
    tempInput.setText("");
  }

  public void showMessage(String msg) {
    messageLabel.setText(msg);
  }

  public void updateDisplay(double current, double target, boolean heating, boolean cooling) {
    currentLabel.setText("Current Temp: " + String.format("%.1f", current));
    targetLabel.setText("Target Temp: " + String.format("%.1f", target));
    statusLabel.setText("Status: " + (heating ? "Heating" : cooling ? "Cooling" : "Idle"));
  }
}
