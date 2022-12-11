import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

import java.util.Random;

public class Pond extends GameObject implements Updatable {

    Random rand = new Random();
    int randX = rand.nextInt(300);
    int randY = rand.nextInt(500);
    int randPondSize = rand.nextInt(5);


    public Pond() {
        System.out.println(" test pond ");
        Ellipse pond = new Ellipse(randPondSize*10, randPondSize*15);

        pond.setFill(Color.BLUE);

        pond.setTranslateX(randX+50);
        pond.setTranslateY(randY+50);

        add(pond);
        System.out.println("Pond Location " + pond.getTranslateX() + " / " + pond.getTranslateY());

    }

    @Override
    public void update() {
        System.out.println(" test GameApp.Pond UPDATE ");

    }
}
