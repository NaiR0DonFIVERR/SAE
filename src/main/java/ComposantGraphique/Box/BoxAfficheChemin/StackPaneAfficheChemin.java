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
    Node [] components;

    public StackPaneAfficheChemin(){

        vBoxChemin = new VBoxChemin();
        vBoxTroisChemins = new VBoxTroisChemins();
        vBoxPremierChemin = new VBoxPremierChemin();
        components = new Node[3];
        components [0] = vBoxChemin.getBoxAll();
        components [1] = vBoxTroisChemins.getBoxAll();
        components [2] = vBoxPremierChemin.getBox();
        stackPane = new StackPane(components);

        stackPane.getChildren().get(1).toFront();

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
