package ComposantGraphique.Box;

import javafx.scene.Node;
import javafx.scene.layout.HBox;

public class BoxRegroup extends HBox {

    HBox box;

    public BoxRegroup(){
        box = new HBox();
        box.setId("boxRegroup");
        box.setMaxWidth(700);
    }

    public void add(Object objet){
        box.getChildren().add((Node) objet);
    }

    public HBox getBox(){
        return box;
    }
}
