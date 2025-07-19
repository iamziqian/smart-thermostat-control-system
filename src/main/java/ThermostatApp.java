public class ThermostatApp {


  public static void main(String[] args) {
    ThermostatModel model = new ThermostatModel();
    ThermostatView view = new ThermostatView();
    ThermostatController controller = new ThermostatController(model, view);
    controller.run();
  }
}
