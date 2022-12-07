import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;

public abstract class GameObject extends Group implements Updatable {


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
