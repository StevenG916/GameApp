import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

import java.util.Random;

public class Cloud extends GameObject implements Updatable {

    Random rand = new Random();
    int randX = rand.nextInt(100,400);
    int randY = rand.nextInt(100,800);
    int randCloudSize = rand.nextInt(20,50);

    public Cloud() {
        System.out.println(" test GameApp.Cloud ");

        Ellipse cloud = new Ellipse(randCloudSize, randCloudSize*1.25);
        cloud.setFill(Color.GRAY);

        cloud.setTranslateX(randX);
        cloud.setTranslateY(randY);

        add(cloud);
        System.out.println("Cloud Location " + cloud.getLayoutX() + " / " + cloud.getLayoutY());


    }

    @Override
    public void update() {
        myTranslation.setX(myTranslation.getX()+.5);
        System.out.println("Update Cloud Location " + this.getLayoutX() + " / " + this.getLayoutY());


    }
}
