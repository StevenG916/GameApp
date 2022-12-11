import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

import java.util.Random;

public class Cloud extends GameObject {

    Random rand = new Random();
    int randX = rand.nextInt(350);
    int randY = rand.nextInt(550);
    int randCloudSize = rand.nextInt(5);
    Point2D cloudPoint = new Point2D(randX, randY);

    int percent = 0;
    GameText seed;

    public Cloud() {
        System.out.println(" test GameApp.Cloud ");
        seed = new GameText(percent);

        Ellipse cloud = new Ellipse(randCloudSize*10, randCloudSize*15);
        cloud.setFill(Color.GRAY);

        cloud.setTranslateX(randX);
        cloud.setTranslateY(randY-100);

        add(cloud);
        add(seed);
        seed.translate(cloudPoint.getX()-40, cloudPoint.getY()-150);



    }

    @Override
    public void update() {
        myTranslation.setX(myTranslation.getX()+.5);
        System.out.println("Update Cloud Location " + this.getLayoutX() + " / " + this.getLayoutY());


    }
}
