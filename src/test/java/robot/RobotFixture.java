package robot;

import cucumber.api.java.en.*;
import org.junit.Assert;

import java.util.Random;

public class RobotFixture {
    private MyWorld world;

    public RobotFixture(MyWorld world) {
        this.world = world;
    }

    @Given("^Le robot est en vol$")
    public void leRobotEstEnVol() {
        world.setRobot(1, new Battery(), new RoadBookCalculator());
    }

    @When("^le robot atterrit en coordonnée \\((\\d+), (\\d+)\\)$")
    public void leRobotAtterritEnCoordonnée(int x, int y) throws Throwable {
        world.getRobot().land(new Coordinates(x, y), new LandSensor(new Random(1)));
    }

    @And("^le robot avance$")
    public void leRobotAvance() throws Throwable {
        world.getRobot().moveForward();
    }

    @And("^le robot recule$")
    public void leRobotRecule() throws Throwable {
        world.getRobot().moveBackward();
    }

    @And("^le robot tourne à droite$")
    public void leRobotTourneADroite() throws Throwable {
        world.getRobot().turnRight();
    }

    @And("^le robot tourne à gauche$")
    public void leRobotTourneAGauche() throws Throwable {
        world.getRobot().turnLeft();
    }

    @And("^le robot se déplace en coordonnée \\((\\d+), (\\d+)\\)$")
    public void leRobotSeDeplace(int x, int y) throws Throwable {
        world.getRobot().computeRoadTo(new Coordinates(x, y));
        try {
            world.getRobot().letsGo();
        } catch (InsufficientChargeException ice){

        }

    }

    @And("^le robot ne fait rien pendant (\\d+) secondes$")
    public void leRobotNeFaitRien(int duree) throws Throwable {
        world.getBattery().recharger(duree);
    }

    @Then("^les coordonnées du robot sont \\((\\d+), (\\d+)\\)$")
    public void lesCoordonnéesDuRobotSont(int x, int y) throws Throwable {
        Assert.assertEquals(x, world.getRobot().getXposition());
        Assert.assertEquals(y, world.getRobot().getYposition());
    }

    @And("^il est orienté vers (.*)$")
    public void ilEstOrientéVers(String direction) throws Throwable {
        switch (direction) {
            case "le nord":
                Assert.assertEquals(Direction.NORTH, world.getRobot().getDirection());
                break;
            case "le sud":
                Assert.assertEquals(Direction.SOUTH, world.getRobot().getDirection());
                break;
            case "l'ouest":
                Assert.assertEquals(Direction.WEST, world.getRobot().getDirection());
                break;
            case "l'est":
                Assert.assertEquals(Direction.EAST, world.getRobot().getDirection());
                break;
        }
    }

}
