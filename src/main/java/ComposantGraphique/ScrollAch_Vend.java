package ComposantGraphique;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import modele.Scenario;

import java.io.IOException;
import java.util.ArrayList;

public class   ScrollAch_Vend extends ScrollPane {

    protected ScrollPane scrollAch_Vend ;
    protected VBox box;
    protected VBox boxAll;

    public ScrollAch_Vend(){
        boxAll = new VBox();
        box = new VBox();
        scrollAch_Vend = new ScrollPane();
        scrollAch_Vend.setMinViewportWidth(200);
        scrollAch_Vend.setMinViewportHeight(100);
        scrollAch_Vend.setMaxHeight(500);
        scrollAch_Vend.setContent(box);
        boxAll.getChildren().add(scrollAch_Vend);
    }

    public void setScoll(Scenario scenario) throws IOException {
        delete();
        for (int i=0; i<scenario.getVendeur().size();i++){
            String espace = "";
            for (int y=0; y< 13-scenario.getVendeur().get(i).length(); y++){
                espace = espace + " ";
            }
            Label label = new Label(scenario.getVendeur().get(i) +espace+ " -> "+ scenario.getAcheteur().get(i));
            label.setAccessibleText(String.valueOf(i));
            label.setUserData(scenario.getVendAch(i));
            VBox.setMargin(label, new Insets(8));
            box.getChildren().add(label);
            //System.out.println("taille vend "+listVendeur.get(i).length() + " ach : " + listAch.get(i).length() + " villeVen : " + listVilleVend.get(i).length() + " villeAch : " + listVilleAch.get(i).length());
        }
        System.out.println(getLabel());
    }
    public void delete(){
        boxAll.getChildren().remove(0);
        box = new VBox();
        scrollAch_Vend = new ScrollPane();
        scrollAch_Vend.setMinViewportWidth(175);
        scrollAch_Vend.setMinViewportHeight(200);
        scrollAch_Vend.setMaxHeight(500);
        scrollAch_Vend.setContent(box);
        boxAll.getChildren().add(scrollAch_Vend);
    }

    public ObservableList<Node> getLabel(){

        return box.getChildren();
    }

    public VBox getBox(){

        return box;
    }

    public ScrollPane getScrollAch_Vend(){

        return scrollAch_Vend;
    }
    public VBox getBoxAll(){

        return boxAll;
    }

}
