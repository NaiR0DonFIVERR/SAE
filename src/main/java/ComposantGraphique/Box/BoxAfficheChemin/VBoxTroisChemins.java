package ComposantGraphique.Box.BoxAfficheChemin;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import vue.VBoxRoot;

public class VBoxTroisChemins extends VBox{

    VBox boxAll;
    VBox boxOne ;
    VBox boxTwo ;
    VBox boxTree ;

    ScrollPane scrollPaneOne;
    ScrollPane scrollPaneTwo;
    ScrollPane scrollPaneTree;

    public VBoxTroisChemins(){

        boxAll = new VBox();
        boxOne = new VBox();
        boxTwo = new VBox();
        boxTree = new VBox();
        scrollPaneOne = new ScrollPane();
        scrollPaneTwo = new ScrollPane();
        scrollPaneTree = new ScrollPane();
        scrollPaneOne.setContent(boxOne);
        scrollPaneTwo.setContent(boxTwo);
        scrollPaneTree.setContent(boxTree);
        boxAll.getChildren().addAll(scrollPaneOne, scrollPaneTwo, scrollPaneTree);
    }

    public void setBoxAll(){
        delet();
        for (int i=0;i<VBoxRoot.getDicVille().getPremierList().size();i++){
            if (i>=3){
                break;
            }
            Label labeltitle = new Label("Chemin : " + i);
            labeltitle.setId("labelCheminEtape");
            if (i==0){
                boxOne.getChildren().add(labeltitle);
            }
            else if (i==1){
                boxTwo.getChildren().add(labeltitle);
            }
            else {
                boxTree.getChildren().add(labeltitle);
            }
            for (String ville : VBoxRoot.getDicVille().getPremierList().get(i)){
                if (i==0){
                    boxOne.getChildren().add(new Label(ville));
                }
                else if (i==1){
                    boxTwo.getChildren().add(new Label(ville));
                }
                else {
                    boxTree.getChildren().add(new Label(ville));
                }
            }
        }
        boxOne.getChildren().get(boxOne.getChildren().size()-1).setId("labelDISTANCE");
        if (boxTwo.getChildren().size()>0) {
            boxTwo.getChildren().get(boxTwo.getChildren().size() - 1).setId("labelDISTANCE");
        }
        if (boxTree.getChildren().size()>0) {
            boxTree.getChildren().get(boxTree.getChildren().size() - 1).setId("labelDISTANCE");
        }
    }

    public void delet(){
        int TAILLE1 = boxOne.getChildren().size();
        int TAILLE2 = boxTwo.getChildren().size();
        int TAILLE3 = boxTree.getChildren().size();
        for (int i=0;i<TAILLE1;i++){
            boxOne.getChildren().remove(0);
        }
        for (int i=0;i<TAILLE2;i++){
            boxTwo.getChildren().remove(0);
        }
        for (int i=0;i<TAILLE3;i++){
            boxTree.getChildren().remove(0);
        }
    }



    public VBox getBoxAll(){
        return boxAll;
    }
}
