import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;


interface Updatable{
    void update();
}
public class GameApp extends Application {
    private static final int GAME_WIDTH = 400;
    private static final int GAME_HEIGHT = 800;

    @Override
    public void start(Stage stage) throws Exception {

        Group root = new Group();
        init(root);
        Scene scene = new Scene(root, GAME_WIDTH, GAME_HEIGHT);
        stage.setTitle("RainMaker!");
        stage.setScene(scene);
        root.setScaleY(-1);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {

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
        stage.show();
        timer.start();

    }

    private void init(Group root) {
        //root.getChildren().add(); This is where to add them, just have to make them first.
    }

    public static void main(String[] args) {
        launch(args);
    }
} // end of class GameApp


class Game extends Pane{


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
class Pond extends GameObject{

    @Override
    public void update() {

    }
}
class Cloud extends GameObject{

    @Override
    public void update() {

    }
}
class Helipad{

}
class Helicopter{

}


class GameText extends GameObject implements Updatable{

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
};}