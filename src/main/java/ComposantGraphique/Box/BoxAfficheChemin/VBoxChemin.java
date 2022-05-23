package ComposantGraphique.Box.BoxAfficheChemin;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modele.Scenario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static modele.LectureEcriture.getDistance;
import static modele.LectureEcriture.getIndiceDistance;


public class VBoxChemin extends VBox {


    VBox boxAll;
    static List<HBox> hBoxList;

    public VBoxChemin(){
        boxAll = new VBox();
        hBoxList = new ArrayList<>();
        //scrollPane = new ScrollPane();
        //box = new VBox();
        //scrollPane.setContent(box);
        //boxAll.getChildren().add(scrollPane);
        for (int i=0;i<3;i++){
            HBox regroupBoxChemin = new HBox();
            boxAll.getChildren().add(regroupBoxChemin);
            hBoxList.add(regroupBoxChemin);
        }
    }

    public void setAllChemin(List<List<String>> chemin) throws IOException {

        System.out.println(chemin);
        //delete1();
        for (int i=0; i<chemin.size(); i++){
            VBox boxCheminN = new VBox();
            ScrollPane scrollPaneChemin = new ScrollPane();
            int TOTAL_DISTANCE = 0;

            scrollPaneChemin.setMinViewportWidth(100);
            scrollPaneChemin.setMinViewportHeight(150);
            scrollPaneChemin.setMaxHeight(500);
            scrollPaneChemin.setContent(boxCheminN);
            boxCheminN.getChildren().add(new Label("Chemin : " +i));
            for(String ville : chemin.get(i)){
                Label label = new Label(ville);
                label.setAccessibleText(ville);
                boxCheminN.getChildren().add(label);
                //System.out.println( "Taille de la boite "+ boxCheminN.getChildren().size());
                if (boxCheminN.getChildren().size() > 2){       //Pour recupérer la ville précédente : comme un label fait office de titre, on précise qu'il faut plus de deux label dans la boite
                    TOTAL_DISTANCE = TOTAL_DISTANCE + getDistance(boxCheminN.getChildren().get(boxCheminN.getChildren().size()-2).getAccessibleText(), boxCheminN.getChildren().get(boxCheminN.getChildren().size()-1).getAccessibleText());
                    //Avec getChildren().size() qui nous retourne la taille de la box (le nombre total des label), On recupère la dernier valeur ajouter dans la box qui est un label
                    //On fait de même pour récupérer l'avant dernière valeur de la box
                }
            }
            Label labelDistance = new Label("Longeur : " + TOTAL_DISTANCE + "km");
            labelDistance.setId("labelDISTANCE");
            boxCheminN.getChildren().add(labelDistance);
            if (i>chemin.size()*2/3){
                hBoxList.get(2).getChildren().add(scrollPaneChemin);
            }
            else if (i<chemin.size()/3){
                hBoxList.get(0).getChildren().add(scrollPaneChemin);
            }
            else {
                hBoxList.get(1).getChildren().add(scrollPaneChemin);
            }
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

    public void delete1(){

    }

    public static List<HBox> gethBoxList(){return hBoxList;}

    public VBox getBoxAll(){
        return boxAll;
    }
}
