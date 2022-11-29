import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class GameApp extends Application {
    private static final int GAME_WIDTH = 400;
    private static final int GAME_HEIGHT = 800;

    @Override
    public void start(Stage stage) {

        System.out.println(" test 1 ");


        Game root = new Game();
        root.setScaleY(-1);
        //root.init();
        System.out.println(" test scale on y should be inverted here in start ");
        //Game game = new Game();


        //root.getChildren().add(game);

        Scene scene = new Scene(root, GAME_WIDTH, GAME_HEIGHT, Color.FORESTGREEN);
        stage.setTitle("RainMaker!");
        stage.setScene(scene);

        stage.show();



        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {



                root.update();
                if ((double) now %10000==0) {
                    System.out.println(" test Animation " + (double) now);
                } else {
                }

            }
        };



        scene.setOnKeyPressed((event -> {

            if (event.getCode() == KeyCode.LEFT){
                root.rotateHelicopterLeft();

            }
            if (event.getCode() == KeyCode.RIGHT){
                root.rotateHelicopterRight();

            }
            if (event.getCode() == KeyCode.UP){
                root.increaseHelicopterVelocity();

            }
            if (event.getCode() == KeyCode.DOWN){
                root.decreaseHelicopterVelocity();

            }
            if (event.getCode() == KeyCode.I){

            }
        }));

        timer.start();


    }



    public static void main(String[] args) {
        launch(args);
    }
} // end of class GameApp


