import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThermostatController implements ActionListener{
  private final ThermostatModel model;
  private final ThermostatView view;

  public ThermostatController(ThermostatModel model, ThermostatView view) {
    this.model = model;
    this.view = view;
  }

  public void run() {

    view.addListener(this);

    Timer timer = new Timer(1000, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        model.updateSystem();
        view.updateDisplay(
            model.getCurrentTemp(),
            model.getTargetTemp(),
            model.isHeatingOn(),
            model.isCoolingOn()
        );
      }
    });
    timer.start();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    try {
      double input = Double.parseDouble(view.getTempInput());
      model.setTargetTemp(input);
      view.showMessage("Target set to " + input + "°C");
      view.clearInput();
    } catch (NumberFormatException ex) {
      view.showMessage("Invalid input!");
    }

  }
}
