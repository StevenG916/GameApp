import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class Cloud extends GameObject {

    public Cloud() {
        System.out.println(" test Cloud ");
        Ellipse cloud = new Ellipse(50, 50);
        cloud.setFill(Color.WHITE);
        add(cloud);
        translate(50, 50);


    }

    @Override
    public void update() {

    }
}
