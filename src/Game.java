import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Game extends Pane implements Updatable {

    Helipad helipad = new Helipad();
    Pond pond = new Pond();
    Cloud cloud = new Cloud();
    Helicopter helicopter = new Helicopter();


    public boolean isGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(boolean gameStatus) {
        this.gameStatus = gameStatus;
    }

    boolean gameStatus = false;


    public Game() {
        System.out.println(" test GameApp.Game ");
        this.setBackground(Background.fill(Color.FORESTGREEN));


        init();


        //getChildren().addAll(pond, helipad, helicopter, cloud);


    }

    public void rotateHelicopterLeft() {
        helicopter.turnLeft();
    }

    public void rotateHelicopterRight() {
        helicopter.turnRight();
    }

    public void increaseHelicopterVelocity() {
        helicopter.increaseVelocity();
    }

    public void decreaseHelicopterVelocity() {
        helicopter.decreaseVelocity();
    }

    public void init() {
        this.getChildren().clear();

        this.getChildren().setAll(pond, helipad, cloud, helicopter); //This is where to add them, just have to make them first.
        System.out.println(" test init ");
    }

    @Override
    public void update() {
        for (Node n : getChildren()) {
            if (n instanceof Updatable) {
                ((Updatable) n).update();
            }
        }
    }


}
