package ComposantGraphique.Box.BoxAfficheChemin;

import javafx.scene.Node;
import javafx.scene.layout.StackPane;

import java.io.IOException;
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

        vBoxPremierChemin.getBox().setAccessibleText("0");
        vBoxTroisChemins.getBoxAll().setAccessibleText("1");
        vBoxChemin.getBoxAll().setAccessibleText("2");

        components [0] = vBoxPremierChemin.getBox();
        components [1] = vBoxTroisChemins.getBoxAll();
        components [2] = vBoxChemin.getBoxAll();

        stackPane = new StackPane(components);

        stackPane.getChildren().get(0).toFront();

    }

    public void setStackPane(TreeMap<Integer, List<String>> chemin) throws IOException {

        vBoxChemin.setAllChemin(chemin);
        //vBoxPremierChemin.setBox();
        //vBoxTroisChemins.setBoxAll();



    }

    public StackPane getStackPane(){
        return stackPane;
    }

}
