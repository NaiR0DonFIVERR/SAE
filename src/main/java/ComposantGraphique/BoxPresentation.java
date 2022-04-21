package ComposantGraphique;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class BoxPresentation extends HBox {

    HBox box;

    public BoxPresentation(){
        box = new HBox();
    }

    public void MAJ_Box(Object boite){
        box.getChildren().remove(3);
        box.getChildren().add((Node) boite);
    }


    public HBox getBox(){

        return box;
    }

}
