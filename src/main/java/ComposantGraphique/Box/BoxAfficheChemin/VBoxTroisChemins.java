package ComposantGraphique.Box.BoxAfficheChemin;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import vue.VBoxRoot;

import java.util.*;

public class VBoxTroisChemins extends VBox{

    VBox boxAll;
    List<VBox> list;

    public VBoxTroisChemins(){

        boxAll = new VBox();
        list = new ArrayList<>();

        for (int i=0;i<3;i++){
            VBox box = new VBox();
            ScrollPane scrollPane = new ScrollPane();
            list.add(box);
            scrollPane.setContent(box);
            boxAll.getChildren().add(scrollPane);
        }
        boxAll.setId("backGroudWhite");
    }

    public void setBoxAll(TreeMap<Integer, List<String>> chemin){
        delet();
        int i =0;
        Set set = chemin.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext() & i<3){
            Map.Entry mentry = (Map.Entry) iterator.next();
            Label labeltitle = new Label("Chemin : " + i);
            labeltitle.setId("labelCheminEtape");
            list.get(i).getChildren().add(labeltitle);
            for (String ville : chemin.get(mentry.getKey())) {
                list.get(i).getChildren().add(new Label(ville));
            }
            Label lableDistance = new Label(mentry.getKey()+"km");
            lableDistance.setId("labelDISTANCE");
            list.get(i).getChildren().add(lableDistance);
            i++;
        }
    }

    public void delet(){
        for (int i=0;i<list.size();i++){
            final int TAILLE = list.get(i).getChildren().size();
            for (int y=0;y<TAILLE;y++){
                list.get(i).getChildren().remove(y);
            }
        }
    }

    public VBox getBoxAll(){
        return boxAll;
    }
}
