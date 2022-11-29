import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GameText extends GameObject implements Updatable {

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
