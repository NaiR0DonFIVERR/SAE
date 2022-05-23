package ComposantGraphique.Box;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import static ComposantGraphique.Box.VBoxChemin.gethBoxList;

public class VBoxTroisChemins {

    VBox boxAll;
    VBox boxOne;
    HBox boxTwo;

    public VBoxTroisChemins(){
        boxOne = new VBox();
        boxAll = new VBox();
        boxTwo = new HBox();
        boxAll.getChildren().addAll(boxOne, boxTwo);
    }

    public void setBoxAll(){
        boxOne.getChildren().add(gethBoxList().get(0));
        boxTwo.getChildren().addAll(gethBoxList().get(1), gethBoxList().get(2));

    }

    public VBox getBoxAll(){
        return boxAll;
    }
}
