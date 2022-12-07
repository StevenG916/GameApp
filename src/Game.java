import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Game extends Pane implements Updatable {

    Helipad helipad = new Helipad();
    Helicopter helicopter = new Helicopter();
    Pond pond = new Pond();
    Cloud cloud = new Cloud();

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
        super.getChildren().clear();

        super.getChildren().setAll(pond, helipad, helicopter, cloud); //This is where to add them, just have to make them first.
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