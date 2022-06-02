package ComposantGraphique.Box.BoxAfficheChemin;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import vue.VBoxRoot;

import java.util.*;

import static ComposantGraphique.Box.BoxAfficheChemin.VBoxChemin.gethBoxList;

public class VBoxPremierChemin {

    VBox boxAll;
    VBox box;
    ScrollPane scrollPane;

    public VBoxPremierChemin(){
        boxAll = new VBox();
        box = new VBox();
        scrollPane = new ScrollPane();
        scrollPane.setContent(box);
        boxAll.getChildren().add(scrollPane);
        boxAll.setId("backGroudWhite");
    }

    public void setBox(TreeMap<Integer, List<String>> chemin){
        //delet();
        Label labelTitle = new Label("Chemin 0");
        labelTitle.setId("labelCheminEtape");
        box.getChildren().add(labelTitle);
        Set set = chemin.entrySet();
        Iterator iterator = set.iterator();
        Map.Entry mentry = (Map.Entry) iterator.next();

        for (String ville : chemin.get(mentry.getKey())){
            box.getChildren().add(new Label(ville));
        }
        Label labelDistance = new Label(mentry.getKey()+"km");
        labelDistance.setId("labelDISTANCE");
        box.getChildren().add(labelDistance);
        //box.getChildren().add(gethBoxList().get(0).getChildren().get(0));
        //System.out.println("taille" + gethBoxList().get(0).getChildren().size());
    }
    public void delet(){
        VBox box = (VBox)scrollPane.getContent();
        int TAILLE = box.getChildren().size();
        for (int i=0;i<TAILLE;i++){
            box.getChildren().remove(0);
        }
    }

    public VBox getBox(){
        return boxAll;
    }
}
