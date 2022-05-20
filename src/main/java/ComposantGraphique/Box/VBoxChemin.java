package ComposantGraphique.Box;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import modele.Scenario;

import java.util.List;


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

    public void setAllChemin(List<List<String>> chemin){

        System.out.println(chemin);
        delete();
        for (int i=0; i<chemin.size(); i++){
            for(String ville : chemin.get(i)){
                Label label = new Label(ville);
                box.getChildren().add(label);
            }
        }
    }
    public void delete(){

        boxAll.getChildren().remove(0);
        box = new VBox();
        scrollPane = new ScrollPane();
        scrollPane.setMinViewportWidth(175);
        scrollPane.setMinViewportHeight(200);
        scrollPane.setMaxHeight(500);
        scrollPane.setContent(box);
        boxAll.getChildren().add(scrollPane);
    }

    public VBox getBoxAll(){
        return boxAll;
    }
}
