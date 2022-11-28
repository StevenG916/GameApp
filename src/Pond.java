import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

import java.util.Random;

public class Pond extends GameObject implements Updatable {
    public Pond() {
        System.out.println(" test pond ");
        double r = Math.random() * 40 + 30;
        Ellipse ellipse = new Ellipse(r, r * 1.5);
        Random rand = new Random();
        ellipse.setFill(Color.BLUE);
        add(ellipse);
        double randX = rand.nextDouble();
        double randY = rand.nextDouble();
        //ellipse.setTranslateX(randX*50);
        //ellipse.setTranslateY(randY*50);
        //ellipse.setTranslateX(100);
        //ellipse.setTranslateY(500);
        translate(200, 400);


    }

    @Override
    public void update() {
        System.out.println(" test Pond UPDATE ");

    }
}
