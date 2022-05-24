package ComposantGraphique.Box.BoxAfficheChemin;

import javafx.scene.layout.VBox;

import static ComposantGraphique.Box.BoxAfficheChemin.VBoxChemin.gethBoxList;

public class VBoxPremierChemin {

    VBox box;

    public VBoxPremierChemin(){
        box = new VBox();
    }

    public void setBox(){
        box.getChildren().add(gethBoxList().get(0).getChildren().get(0));
    }

    public VBox getBox(){
        return box;
    }
}
