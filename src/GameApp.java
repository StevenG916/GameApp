import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

import java.util.Random;


interface Updatable{
    void update();
}

public class GameApp extends Application {
    private static final int GAME_WIDTH = 400;
    private static final int GAME_HEIGHT = 800;


    @Override
    public void start(Stage stage) throws Exception {

        System.out.println(" test 1 ");


        Pane root = new Pane();
        root.setScaleY(-1);
        System.out.println(" test scale on y should be inverted here in start ");
        Game game = new Game();


        root.getChildren().add(game);
        init(root);
        Scene scene = new Scene(root, GAME_WIDTH, GAME_HEIGHT);
        stage.setTitle("RainMaker!");
        stage.setScene(scene);

        stage.show();


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {

                double iterations = now;
                if (iterations%10000==0) {
                    System.out.println(" test Animation " + iterations);
                } else {
                    return;
                }

            }
        };



        scene.setOnKeyPressed((new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.LEFT){

                }
                if (event.getCode() == KeyCode.RIGHT){

                }
                if (event.getCode() == KeyCode.UP){

                }
                if (event.getCode() == KeyCode.DOWN){

                }
                if (event.getCode() == KeyCode.I){

                }
            }

        }));

        timer.start();

    }

    private void init(Pane root) {
        //root.getChildren().add(root); //This is where to add them, just have to make them first.
        System.out.println(" test init ");
    }

    public static void main(String[] args) {
        launch(args);
    }
} // end of class GameApp


class Game extends Pane {

    public Game() {
        System.out.println(" test Game ");
        Helipad helipad = new Helipad();
        Helicopter helicopter = new Helicopter();
        Pond pond = new Pond();
        //Cloud cloud = new Cloud();

        getChildren().addAll(pond,helipad, helicopter);


    }


}
abstract class GameObject extends Group implements Updatable {
    protected Translate myTranslation;
    protected Rotate myRotation;
    protected Scale myScale;

    public GameObject(){
        myTranslation = new Translate();
        myRotation = new Rotate();
        myScale = new Scale();
        this.getTransforms().addAll(myTranslation,myRotation,myScale);
    }

    public void rotate(double degrees) {
        myRotation.setAngle(degrees);
        myRotation.setPivotX(0);
        myRotation.setPivotY(0);
    }

    public void scale(double sx, double sy) {
        myScale.setX(sx);
        myScale.setY(sy);
    }

    public void translate(double tx, double ty) {
        myTranslation.setX(tx);
        myTranslation.setY(ty);
    }

    public double getMyRotation(){
        return myRotation.getAngle();
    }

    public void update(){
        for(Node n : getChildren()){
            if(n instanceof Updatable)
                ((Updatable)n).update();
        }
    }


    void add (Node node) {
        this.getChildren().add(node);
    }

}
class Pond extends GameObject implements Updatable{
    public Pond() {
        System.out.println(" test pond ");
        double r = Math.random() * 40 + 30;
        Ellipse ellipse = new Ellipse(r, r*1.5);
        Random rand = new Random();
        ellipse.setFill(Color.BLUE);
        add(ellipse);
        double randX = rand.nextDouble();
        double randY = rand.nextDouble();
        //ellipse.setTranslateX(randX*50);
        //ellipse.setTranslateY(randY*50);
        //ellipse.setTranslateX(100);
        //ellipse.setTranslateY(500);
        translate(200,400  );



    }

    @Override
    public void update() {
        System.out.println(" test Pond UPDATE ");

    }
}
class Cloud extends GameObject{

    @Override
    public void update() {

    }
}
class Helipad extends GameObject{

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
class Helicopter extends GameObject implements Updatable {

    Color helicopter = Color.YELLOW;
    int heliX = 200;
    int heliY = 55;
    Point2D helicopterStartingPoint = new Point2D(heliX, heliY);

    public Helicopter() {
        Ellipse body = new Ellipse(15,15);
        Line nose = new Line(0,0,0,30);
        body.setFill(helicopter);
        nose.setStroke(helicopter);
        add(body);
        add(nose);
        translate(helicopterStartingPoint.getX(), helicopterStartingPoint.getY());


    }
}

class GameText extends GameObject implements Updatable {

    private Text text;
    public GameText(String text, Color color) {
        this.text = new Text(text);
        this.text.setScaleY(-1);
        this.text.setFill(color);
        this.text.setFont(Font.font(20));
        this.getChildren().add(this.text);
    }

    @Override
    public void update() {

    }
}