package ComposantGraphique.Box;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VBoxTroisChemins {

    VBox boxAll;
    HBox boxTwo;

    public VBoxTroisChemins(){
        VBox box1 = new VBox();
        VBox box2 = new VBox();
        VBox box3 = new VBox();

        box1.getChildren().addAll(new Label("Chemin 1"));
        box2.getChildren().addAll(new Label("Chemin 2"));
        box3.getChildren().addAll(new Label("Chemin 3"));
        boxAll = new VBox();
        boxTwo = new HBox();
        boxTwo.getChildren().addAll(box2, box3);
        boxAll.getChildren().addAll(box1, boxTwo);
    }

    public void setBoxAll(){

    }

    public VBox getBoxAll(){
        return boxAll;
    }
}
