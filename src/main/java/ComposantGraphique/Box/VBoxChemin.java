package ComposantGraphique.Box;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modele.Scenario;

import java.util.ArrayList;
import java.util.List;


public class VBoxChemin extends VBox {


    VBox boxAll;
    List<HBox> hBoxList;

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

    public void setAllChemin(List<List<String>> chemin){

        System.out.println(chemin);
        //delete1();
        for (int i=0; i<chemin.size(); i++){
            VBox boxCheminN = new VBox();
            ScrollPane scrollPaneChemin = new ScrollPane();
            scrollPaneChemin.setMinViewportWidth(100);
            scrollPaneChemin.setMinViewportHeight(150);
            scrollPaneChemin.setMaxHeight(500);
            scrollPaneChemin.setContent(boxCheminN);
            boxCheminN.getChildren().add(new Label("Chemin : " +i));
            for(String ville : chemin.get(i)){
                Label label = new Label(ville);
                boxCheminN.getChildren().add(label);
            }
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

    public VBox getBoxAll(){
        return boxAll;
    }
}
