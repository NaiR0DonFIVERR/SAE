package ComposantGraphique.Box.BoxSwitch;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class ScrollPaneAjoutEtape extends ScrollPane {

    ScrollPane scrollPane;
    VBox box;
    List<String> listVend;
    List<String> listAch;

    public ScrollPaneAjoutEtape(){
        scrollPane = new ScrollPane();
        box = new VBox();
        listVend = new ArrayList<>();
        listAch = new ArrayList<>();
        scrollPane.setContent(box);
    }

    public void ajoutEtape(String acheteur, String vendeur){
        box.getChildren().add(new Label(vendeur + " --> " + acheteur));
        listVend.add(vendeur);
        listAch.add(acheteur);
    }

    public void delete(){
        int TAILLE = box.getChildren().size();
        for (int i=0;i<TAILLE;i++){
            box.getChildren().remove(0);
            listVend.remove(0);
            listAch.remove(0);
        }
    }

    public ScrollPane getScrollPane(){
        return scrollPane;
    }

    public List<String> getListVend(){
        return listVend;
    }

    public List<String> getListAch(){
        return listAch;
    }

}
