package ComposantGraphique.GridPane;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modele.Scenario;

import java.io.IOException;
import java.util.*;

import static ComposantGraphique.GridPane.RecupDonnees.doDic;

public class VBoxGridPaneChemin extends VBox {

    VBox box;
    HBox boxchemin1;
    HBox boxchemin2;
    HBox boxchemin3;

    public VBoxGridPaneChemin(){
        box = new VBox();
        boxchemin1 = new HBox();
        boxchemin2 = new HBox();
        boxchemin3 = new HBox();
        ScrollPane scroll1 = new ScrollPane();
        ScrollPane scroll2 = new ScrollPane();
        ScrollPane scroll3 = new ScrollPane();
        scroll1.setContent(boxchemin1);
        scroll2.setContent(boxchemin2);
        scroll3.setContent(boxchemin3);
        box.getChildren().addAll(scroll1, scroll2, scroll3);
    }

    public void setGridPaneChemin(Scenario scenario) throws IOException {

        TreeMap<Integer, List<String>> dicEtape = doDic(scenario);

        delet();
        boxchemin1 = new HBox();
        boxchemin2 = new HBox();
        boxchemin3 = new HBox();
        ScrollPane scroll1 = new ScrollPane();
        ScrollPane scroll2 = new ScrollPane();
        ScrollPane scroll3 = new ScrollPane();
        scroll1.setContent(boxchemin1);
        scroll2.setContent(boxchemin2);
        scroll3.setContent(boxchemin3);

        int tier = dicEtape.size()/3;

        Set set = dicEtape.entrySet();
        Iterator iterator = set.iterator();
        int i=0;
        while (iterator.hasNext()) {
            VBox boxEtape = new VBox();
            Label labelTritre = new Label("Chemin : " + i);
            labelTritre.setId("labelCheminEtape");

            boxEtape.getChildren().add(labelTritre);
            boxEtape.setId("boxEtape");
            Map.Entry mentry = (Map.Entry) iterator.next();
            for(String ville : dicEtape.get(mentry.getKey())){
                Label labelVille = new Label(ville);
                labelVille.setAccessibleText(ville+i);
                VBox.setMargin(labelVille, new Insets(3));
                boxEtape.getChildren().add(labelVille);
            }
            Label labelKilometre = new Label(mentry.getKey()+"km");
            labelKilometre.setId("labelKilo");
            boxEtape.getChildren().add(labelKilometre);
            if (i<=tier){
                boxchemin1.getChildren().add(boxEtape);
            }
            else if (i>tier*2){
                boxchemin2.getChildren().add(boxEtape);
            }
            else {
                boxchemin3.getChildren().add(boxEtape);
            }
            i++;
        }
        box.getChildren().addAll(scroll1, scroll2, scroll3);

    }

    public void delet(){

        box.getChildren().remove(0);
        box.getChildren().remove(0);
        box.getChildren().remove(0);
    }

    public VBox getBox(){

        return box;
    }

}
