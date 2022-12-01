import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

import java.util.Random;


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
        //GameApp.Game game = new GameApp.Game();


        //root.getChildren().add(game);

        Scene scene = new Scene(root, GAME_WIDTH, GAME_HEIGHT, Color.FORESTGREEN);
        stage.setTitle("RainMaker!");
        stage.setScene(scene);

        stage.show();



        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {



                root.update();
                if ((double) now %10000==0)
                    System.out.println(" test Animation " + (double) now);

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
            if (event.getCode() == KeyCode.I) root.setGameStatus(!root.isGameStatus());

            if (event.getCode() == KeyCode.B){

            }
            if (event.getCode() == KeyCode.R){

            }
        }));

        timer.start();


    }



    public static void main(String[] args) {
        launch(args);
    }

    public static class Cloud extends GameObject {

        public Cloud() {
            System.out.println(" test GameApp.Cloud ");
            Ellipse cloud = new Ellipse(50, 50);
            cloud.setFill(Color.WHITE);
            add(cloud);
            translate(50, 50);


        }

        @Override
        public void update() {

        }
    }

    public abstract static class GameObject extends Group implements Updatable {


        protected Translate myTranslation;
        protected Rotate myRotation;
        protected Scale myScale;

        public GameObject() {
            myTranslation = new Translate();
            myRotation = new Rotate();
            myScale = new Scale();
            this.getTransforms().addAll(myTranslation, myRotation, myScale);
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

        public double getMyRotation() {
            return myRotation.getAngle();
        }

        public void update() {
            System.out.println("starting update loop in GameApp.Game Object");
            for (Node n : getChildren()) {
                if (n instanceof Updatable)
                    ((Updatable) n).update();
            }
        }


        void add(Node node) {
            this.getChildren().add(node);
        }

    }

    public static class GameText extends GameObject implements Updatable {

        private Label text;
        Color color;

        public GameText(int amount, Color color) {
            this.text = new Label("Fuel = " + amount);
            this.text.setScaleY(-1);
            this.text.setTextFill(color);
            this.text.setFont(Font.font(20));
            this.getChildren().add(this.text);
        }
        public void setText(int amount){
            text.setText("Fuel = " + amount);
        }

        @Override
        public void update() {

        }
    }

    public static class Helicopter extends GameObject implements Updatable {


        int heliX = 200;
        int heliY = 55;
        Point2D helicopterPoint = new Point2D(heliX, heliY);
        private double velocity;
        int fuelAmount = 25000;
        GameText fuel;



        public Helicopter() {
            System.out.println(" test helicopter ");
            Ellipse body = new Ellipse(15, 15);
            Line nose = new Line(0, 0, 0, 30);
            body.setFill(Color.YELLOW);
            nose.setStroke(Color.YELLOW);
            add(body);
            add(nose);
            //GameApp.GameText fuel;

            fuel = new GameText(fuelAmount, Color.YELLOW);
            fuel.setLayoutX(-50);
            fuel.setLayoutY(-50);


            add(fuel);
            translate(helicopterPoint.getX(), helicopterPoint.getY());


        }

        public double velocity() {
            return velocity;
        }

        public void turnLeft() {
            rotate(15 + getMyRotation());
            System.out.println(getMyRotation());
        }

        public void turnRight() {
            rotate(-15 + getMyRotation());
            System.out.println(getMyRotation());
        }

        public void increaseVelocity() {
            while (velocity < 10) {
                velocity += 0.1;
                System.out.println("velocity increasing");
                break;
            }

        }

        public void decreaseVelocity() {
            while(velocity >-2) {
                velocity -= 0.1;
                System.out.println("velocity decreasing");
                break;
            }
        }

        @Override
        public void update() {
            //setRotate(getMyRotation());
            System.out.println("GameApp.Helicopter Update Method");
            System.out.println("Rotation "+getMyRotation());
            System.out.println("velocity "+velocity());
            helicopterPoint = helicopterPoint.add(velocity * Math.sin(-1 * Math.PI * getMyRotation() / 180), velocity *
                    Math.cos(-1 * Math.PI * getMyRotation() / 180));
            translate(helicopterPoint.getX(), helicopterPoint.getY());
            System.out.println("helicopter X/Y " + helicopterPoint.getX() + " " + helicopterPoint.getY());
            if (fuelAmount > 0) {
                    fuelAmount -= 1;
                    fuel.setText(fuelAmount);
                }

        }

    }

    public static class Helipad extends GameObject {

        public Helipad() {
            System.out.println(" test GameApp.Helipad ");

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

    public static class Pond extends GameObject implements Updatable {
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
            System.out.println(" test GameApp.Pond UPDATE ");

        }
    }

    public static class Game extends Pane implements Updatable {

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

            super.getChildren().setAll(pond,helipad, helicopter, cloud); //This is where to add them, just have to make them first.
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

    public static interface Updatable {

        void update();
    }
} // end of class GameApp


