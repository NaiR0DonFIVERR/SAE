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

        vBoxPremierChemin.setAccessibleText("0");
        vBoxTroisChemins.setAccessibleText("1");
        vBoxChemin.setAccessibleText("2");

        components [0] = vBoxPremierChemin;
        components [1] = vBoxTroisChemins;
        components [2] = vBoxChemin;

        stackPane = new StackPane(components);

        stackPane.getChildren().get(0).toFront();
    }

    public void setStackPane(TreeMap<Integer, List<String>> chemin) throws IOException {

        //System.out.println("Chemin maj :" + chemin);
        vBoxChemin.setAllChemin(chemin);
        vBoxPremierChemin.setBox(chemin);
        vBoxTroisChemins.setBoxAll(chemin);
    }

    public StackPane getStackPane(){
        return stackPane;
    }

}
