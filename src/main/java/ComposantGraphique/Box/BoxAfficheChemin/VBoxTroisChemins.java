package ComposantGraphique.Box.BoxAfficheChemin;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import static ComposantGraphique.Box.BoxAfficheChemin.VBoxChemin.gethBoxList;

public class VBoxTroisChemins extends VBox{

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
        boxOne.getChildren().add(gethBoxList().get(0).getChildren().get(0));


    }

    public VBox getBoxAll(){
        return boxAll;
    }
}
