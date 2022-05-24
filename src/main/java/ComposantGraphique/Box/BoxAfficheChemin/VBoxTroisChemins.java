package ComposantGraphique.Box.BoxAfficheChemin;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import static ComposantGraphique.Box.BoxAfficheChemin.VBoxChemin.gethBoxList;

public class VBoxTroisChemins extends VBox{

    VBox boxAll;
    VBox boxOne;
    VBox boxTree;
    HBox boxTwo;

    public VBoxTroisChemins(){
        boxOne = new VBox();
        boxAll = new VBox();
        boxTwo = new HBox();
        boxTree = new VBox();
        boxAll.getChildren().addAll(boxOne, boxTwo, boxTree);
    }

    public void setBoxAll(){
        boxOne.getChildren().add(gethBoxList().get(0).getChildren().get(0));
        boxTwo.getChildren().add(gethBoxList().get(0).getChildren().get(1));
        boxTree.getChildren().add(gethBoxList().get(0).getChildren().get(2));


    }

    public VBox getBoxAll(){
        return boxAll;
    }
}
