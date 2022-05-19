package ComposantGraphique.Box;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import modele.Scenario;


public class VBoxChemin extends VBox {

    VBox box;
    ScrollPane scrollPane;
    VBox boxAll;

    public VBoxChemin(){
        boxAll = new VBox();
        scrollPane = new ScrollPane();
        box = new VBox();
        scrollPane.setContent(box);
        boxAll.getChildren().add(scrollPane);
    }

    public void setChemin(){
    }
}
