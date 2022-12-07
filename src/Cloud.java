import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

import java.util.Random;

public class Cloud extends GameObject {

    Random rand = new Random();
    int randX = rand.nextInt(100,400);
    int randY = rand.nextInt(100,800);
    int randCloudSize = rand.nextInt(20,50);

    public Cloud() {
        System.out.println(" test GameApp.Cloud ");
        //Ellipse cloud = new Ellipse(50, 50);


        //translate(50, 50);

        Ellipse cloud = new Ellipse(randCloudSize, randCloudSize*1.25);
        cloud.setFill(Color.GRAY);




        cloud.setTranslateX(randX);
        cloud.setTranslateY(randY);
        //ellipse.setTranslateX(100);
        //ellipse.setTranslateY(500);

        //translate(200, 400);
        add(cloud);
        System.out.println("Cloud Location " + cloud.getTranslateX() + " / " + cloud.getTranslateY());


    }

    @Override
    public void update() {

    }
}
