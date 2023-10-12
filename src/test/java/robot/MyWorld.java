package robot;

import java.awt.*;

public class MyWorld {
    private Robot robot;
    private Battery batterie;

    public MyWorld() {}

    public void setRobot(double energyConsuption, Battery cells, RoadBookCalculator calculator) {
        robot = new Robot(energyConsuption, cells, calculator);
        batterie = cells;
    }

    public Robot getRobot() {
        return robot;
    }

    public Battery getBattery() { return batterie; }
}
