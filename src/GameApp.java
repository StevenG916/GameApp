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
        Scene scene = new Scene(root, GAME_WIDTH, GAME_HEIGHT, Color.FORESTGREEN);
        stage.setTitle("RainMaker!");
        stage.setScene(scene);

        stage.show();


        AnimationTimer timer = new AnimationTimer() {
            double old = 0;
            double time = 0;
            int frame = 0;


            @Override
            public void handle(long nano) {
                if(frame % 4 == 0) {
                    root.update();

                }
                frame++;

            }
        };


        scene.setOnKeyPressed((event -> {

            if (root.isGameStatus())
                if (event.getCode() == KeyCode.LEFT) {
                    root.rotateHelicopterLeft();

                }
            if (root.isGameStatus())
                if (event.getCode() == KeyCode.RIGHT) {
                    root.rotateHelicopterRight();

                }
            if (root.isGameStatus())
                if (event.getCode() == KeyCode.UP) {
                    root.increaseHelicopterVelocity();

                }
            if (root.isGameStatus())
                if (event.getCode() == KeyCode.DOWN) {
                    root.decreaseHelicopterVelocity();

                }
            if (event.getCode() == KeyCode.I)
                root.setGameStatus(!root.isGameStatus());

            if (event.getCode() == KeyCode.B) {

            }
            if (event.getCode() == KeyCode.R) {

            }
        }));

        timer.start();


    }


    public static void main(String[] args) {
        launch(args);
    }

} // end of class GameApp


