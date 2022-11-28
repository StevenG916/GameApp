import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Helipad extends GameObject {

    public Helipad() {
        System.out.println(" test Helipad ");

        Circle circle = new Circle(47.5);
        Rectangle rectangle = new Rectangle(100, 100);
        rectangle.setFill(Color.GREY);
        circle.setFill(Color.GRAY);
        rectangle.setStroke(Color.BLACK);
        circle.setStroke(Color.BLACK);
        add(rectangle);
        add(circle);
        circle.setTranslateX(50);
        circle.setTranslateY(50);
        translate(150, 10);
    }

}
