import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

import java.util.Random;

public class Pond extends GameObject implements Updatable {

    Random rand = new Random();
    int randX = rand.nextInt(100,400);
    int randY = rand.nextInt(100,800);
    int randPondSize = rand.nextInt(20,50);


    public Pond() {
        System.out.println(" test pond ");
        Ellipse pond = new Ellipse(randPondSize, randPondSize*1.25);

        pond.setFill(Color.BLUE);


        pond.setTranslateX(randX);
        pond.setTranslateY(randY);
        //ellipse.setTranslateX(100);
        //ellipse.setTranslateY(500);

        //translate(200, 400);
        add(pond);
        System.out.println("Pond Location " + pond.getTranslateX() + " / " + pond.getTranslateY());

    }

    @Override
    public void update() {
        System.out.println(" test GameApp.Pond UPDATE ");

    }
}
