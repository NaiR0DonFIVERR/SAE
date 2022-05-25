package ComposantGraphique.Box.BoxAfficheChemin;

import javafx.scene.Node;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;

public class StackPaneAfficheChemin extends StackPane {

    StackPane stackPane;
    VBoxChemin vBoxChemin;
    VBoxTroisChemins vBoxTroisChemins;
    VBoxPremierChemin vBoxPremierChemin;
    List<Node> list;

    public StackPaneAfficheChemin(){

        stackPane = new StackPane();
        vBoxChemin = new VBoxChemin();
        vBoxTroisChemins = new VBoxTroisChemins();
        vBoxPremierChemin = new VBoxPremierChemin();

        stackPane.getChildren().add(vBoxChemin.getBoxAll());
        stackPane.getChildren().add(vBoxTroisChemins.getBoxAll());
        stackPane.getChildren().add(vBoxPremierChemin.getBox());
        list = new ArrayList<>(stackPane.getChildren());
        list.get(1).toFront();
    }

    public void setStackPane(TreeMap<Integer, List<String>> chemin) throws IOException {

        vBoxChemin.setAllChemin(chemin);
        vBoxTroisChemins.setBoxAll();
        vBoxPremierChemin.setBox();


    }

    public StackPane getStackPane(){
        return stackPane;
    }

}
