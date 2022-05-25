package ComposantGraphique.Box.BoxAfficheChemin;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modele.Scenario;

import java.io.IOException;
import java.util.*;

import static modele.LectureEcriture.getDistance;
import static modele.LectureEcriture.getIndiceDistance;


public class VBoxChemin extends VBox {


    VBox boxAll;
    static List<HBox> hBoxList;

    public VBoxChemin(){
        boxAll = new VBox();
        hBoxList = new ArrayList<>();
        for (int i=0;i<3;i++){
            HBox regroupBoxChemin = new HBox();
            boxAll.getChildren().add(regroupBoxChemin);
            hBoxList.add(regroupBoxChemin);
        }
    }

    public void setAllChemin(TreeMap<Integer, List<String>> chemin) throws IOException {

        System.out.println(chemin);
        delete();
        Set set = chemin.entrySet();
        Iterator iterator = set.iterator();
        int NBCHEMIN = 0;
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            VBox boxCheminN = new VBox();
            ScrollPane scrollPaneChemin = new ScrollPane();
            scrollPaneChemin.setMinViewportWidth(100);
            scrollPaneChemin.setMinViewportHeight(150);
            scrollPaneChemin.setMaxHeight(500);
            scrollPaneChemin.setContent(boxCheminN);
            boxCheminN.getChildren().add(new Label("Chemin : " + NBCHEMIN));
            for (String ville : chemin.get(mentry.getKey())){
                Label label = new Label(ville);
                label.setAccessibleText(ville);
                boxCheminN.getChildren().add(label);
            }
            Label labelDistance = new Label("Longeur : " + mentry.getKey() + "km");
            labelDistance.setId("labelDISTANCE");
            boxCheminN.getChildren().add(labelDistance);
            if (NBCHEMIN>chemin.size()*2/3){
                hBoxList.get(2).getChildren().add(scrollPaneChemin);
            }
            else if (NBCHEMIN<chemin.size()/3){
                hBoxList.get(0).getChildren().add(scrollPaneChemin);
            }
            else {
                hBoxList.get(1).getChildren().add(scrollPaneChemin);
            }

            NBCHEMIN++;
        }

    }
    /*public void delete(){

        boxAll.getChildren().remove(0);
        box = new VBox();
        scrollPane = new ScrollPane();
        scrollPane.setMinViewportWidth(175);
        scrollPane.setMinViewportHeight(200);
        scrollPane.setMaxHeight(500);
        scrollPane.setContent(box);
        boxAll.getChildren().add(scrollPane);
    }*/

    public void delete(){

        hBoxList.get(0).getChildren().removeAll();
        hBoxList.get(1).getChildren().removeAll();
        hBoxList.get(2).getChildren().removeAll();

    }

    public static List<HBox> gethBoxList(){return hBoxList;}

    public VBox getBoxAll(){
        return boxAll;
    }
}
