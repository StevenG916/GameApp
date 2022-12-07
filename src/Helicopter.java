import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;

public class Helicopter extends GameObject implements Updatable {


    int heliX = 200;
    int heliY = 55;
    Point2D helicopterPoint = new Point2D(heliX, heliY);
    private double velocity;
    int fuelAmount = 25000;
    GameText fuel;


    public Helicopter() {
        System.out.println(" test helicopter ");
        Ellipse body = new Ellipse(15, 15);
        Line nose = new Line(0, 0, 0, 30);
        body.setFill(Color.YELLOW);
        nose.setStroke(Color.YELLOW);
        add(body);
        add(nose);
        //GameApp.GameText fuel;

        fuel = new GameText(fuelAmount, Color.YELLOW);
        fuel.setLayoutX(-50);
        fuel.setLayoutY(-50);


        add(fuel);
        translate(helicopterPoint.getX(), helicopterPoint.getY());


    }

    public double velocity() {
        return velocity;
    }

    public void turnLeft() {
        rotate(15 + getMyRotation());
        System.out.println(getMyRotation());
    }

    public void turnRight() {
        rotate(-15 + getMyRotation());
        System.out.println(getMyRotation());
    }

    public void increaseVelocity() {
        while (velocity < 10) {
            velocity += 0.1;
            System.out.println("velocity increasing");
            break;
        }

    }

    public void decreaseVelocity() {
        while (velocity > -2) {
            velocity -= 0.1;
            System.out.println("velocity decreasing");
            break;
        }
    }

    @Override
    public void update() {
        //setRotate(getMyRotation());
        System.out.println("GameApp.Helicopter Update Method");
        System.out.println("Rotation " + getMyRotation());
        System.out.println("velocity " + velocity());
        helicopterPoint = helicopterPoint.add(velocity * Math.sin(-1 * Math.PI * getMyRotation() / 180), velocity *
                Math.cos(-1 * Math.PI * getMyRotation() / 180));
        translate(helicopterPoint.getX(), helicopterPoint.getY());
        System.out.println("helicopter X/Y " + helicopterPoint.getX() + " " + helicopterPoint.getY());
        if (fuelAmount > 0) {
            fuelAmount -= 1;
            fuel.setText(fuelAmount);
        }

    }

}
