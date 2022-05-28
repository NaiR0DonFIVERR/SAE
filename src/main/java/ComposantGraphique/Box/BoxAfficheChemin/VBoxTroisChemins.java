package ComposantGraphique.Box.BoxAfficheChemin;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import vue.VBoxRoot;


import java.util.*;

import static ComposantGraphique.Box.BoxAfficheChemin.VBoxChemin.gethBoxList;

public class VBoxTroisChemins extends VBox{

    VBox boxAll;
    VBox boxOne;
    VBox boxTree;
    HBox boxTwo;
    ScrollPane scrollPaneOne;
    ScrollPane scrollPaneTwo;
    ScrollPane scrollPaneTree;

    public VBoxTroisChemins(){
        boxOne = new VBox();
        boxAll = new VBox();
        boxTwo = new HBox();
        boxTree = new VBox();
        scrollPaneOne = new ScrollPane();
        scrollPaneTwo = new ScrollPane();
        scrollPaneTree = new ScrollPane();
        VBox box1 = new VBox();
        VBox box2 = new VBox();
        VBox box3 = new VBox();
        scrollPaneOne.setContent(box1);
        scrollPaneTwo.setContent(box2);
        scrollPaneTree.setContent(box3);
        boxOne.getChildren().add(scrollPaneOne);
        boxTwo.getChildren().add(scrollPaneTwo);
        boxTree.getChildren().add(scrollPaneTree);
        boxAll.getChildren().addAll(boxOne, boxTwo, boxTree);
    }

    public void setBoxAll(){
        delet();
        scrollPaneOne = new ScrollPane();
        scrollPaneTwo = new ScrollPane();
        scrollPaneTree = new ScrollPane();
        VBox box1 = new VBox();
        VBox box2 = new VBox();
        VBox box3 = new VBox();
        scrollPaneOne.setContent(box1);
        scrollPaneTwo.setContent(box2);
        scrollPaneTree.setContent(box3);
        for (int i=0;i<3;i++){
            Label labeltitle = new Label("Chemin : " + i);
            labeltitle.setId("labelCheminEtape");
            if (i==0){
                box1.getChildren().add(labeltitle);
            }
            else if (i==1){
                box2.getChildren().add(labeltitle);
            }
            else {
                box3.getChildren().add(labeltitle);
            }
            for (String ville : VBoxRoot.getDicVille().getPremierList().get(i)){
                if (i==0){
                    box1.getChildren().add(new Label(ville));
                }
                else if (i==1){
                    box2.getChildren().add(new Label(ville));
                }
                else {
                    box3.getChildren().add(new Label(ville));
                }
            }
        }
        box1.getChildren().get(box1.getChildren().size()-1).setId("labelDISTANCE");
        box2.getChildren().get(box2.getChildren().size()-1).setId("labelDISTANCE");
        box3.getChildren().get(box3.getChildren().size()-1).setId("labelDISTANCE");
        boxAll.getChildren().add(scrollPaneOne);
        boxAll.getChildren().add(scrollPaneTwo);
        boxAll.getChildren().add(scrollPaneTree);
    }

    public void delet(){
        boxOne.getChildren().remove(0);
        boxTwo.getChildren().remove(0);
        boxTree.getChildren().remove(0);
    }



    public VBox getBoxAll(){
        return boxAll;
    }
}
