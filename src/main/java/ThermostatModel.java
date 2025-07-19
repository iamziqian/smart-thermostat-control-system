public class ThermostatModel {
  private double currentTemp = 22.0;
  private double targetTemp = 22.0;
  private boolean heatingOn = false;
  private boolean coolingOn = false;

  public void setTargetTemp(double temp) {
    targetTemp = temp;
  }

  public void updateSystem() {
    if (currentTemp <= targetTemp - 0.09) {
      heatingOn = true;
      coolingOn = false;
      currentTemp += 0.1;
    } else if (currentTemp >= targetTemp + 0.09) {
      coolingOn = true;
      heatingOn = false;
      currentTemp -= 0.1;
    } else {
      coolingOn = false;
      heatingOn = false;
    }
  }

  public double getCurrentTemp() {
    return currentTemp;
  }

  public double getTargetTemp() {
    return targetTemp;
  }

  public boolean isHeatingOn() {
    return heatingOn;
  }

  public boolean isCoolingOn() {
    return coolingOn;
  }
}
