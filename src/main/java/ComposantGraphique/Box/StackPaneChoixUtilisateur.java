package ComposantGraphique.Box;

import ComposantGraphique.Box.BoxAfficheChemin.GridPaneChoixAfficheChemin;
import ComposantGraphique.Box.BoxAfficheChemin.StackPaneChoixChemins;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StackPaneChoixUtilisateur extends StackPane {

    StackPane stackPane;
    HBox boxChemin_GridPaneChemin;      //box qui regroupe le gridPane et le stackpane des chemins
    Node[] components;
    List<Node> list;

    public StackPaneChoixUtilisateur(){

    }
    public void setStackPane() throws IOException {


        GridPaneChoixAfficheChemin gridPaneChoixAfficheChemin = new GridPaneChoixAfficheChemin();
        StackPaneChoixChemins stackPaneChoixChemins = new StackPaneChoixChemins();
        components = new Node[1];
        list = new ArrayList<>();

        list.add(gridPaneChoixAfficheChemin);
        list.add(stackPaneChoixChemins);
        stackPaneChoixChemins.setStackPane();
        boxChemin_GridPaneChemin = new HBox(gridPaneChoixAfficheChemin.getGridPane(),stackPaneChoixChemins.getStackPane());
        components[0] = boxChemin_GridPaneChemin;

        stackPane = new StackPane(components);
        System.out.println("test");
    }

    public StackPane getStackPane(){
        return stackPane;
    }

    public List<Node> getList(){
        return list;
    }
}
