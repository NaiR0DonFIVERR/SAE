package ComposantGraphique.Box.BoxSwitch;

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
        GridPaneAjoutScenario gridPaneAjoutScenario = new GridPaneAjoutScenario();
        VBoxSupprimerScenario vBoxSupprimerScenario = new VBoxSupprimerScenario();
        components = new Node[3];
        list = new ArrayList<>();

        stackPaneChoixChemins.setStackPane();
        boxChemin_GridPaneChemin = new HBox(gridPaneChoixAfficheChemin.getGridPane(),stackPaneChoixChemins.getStackPane());
        gridPaneAjoutScenario.setGridPane();


        list.add(gridPaneChoixAfficheChemin);
        list.add(stackPaneChoixChemins);
        list.add(gridPaneAjoutScenario);

        components[0] = boxChemin_GridPaneChemin;
        components[1] = gridPaneAjoutScenario;
        components[2] = vBoxSupprimerScenario;

        for (int i=0;i<components.length;i++){
            components[i].setUserData(i);
        }

        stackPane = new StackPane(components);
        stackPane.getChildren().get(0).toFront();
    }

    public StackPane getStackPane(){
        return stackPane;
    }

    public List<Node> getList(){
        return list;
    }

    public StackPaneChoixChemins getStackPaneChoixChemin(){ return (StackPaneChoixChemins) list.get(1);}

    public GridPaneAjoutScenario getgridPaneAjoutScenario(){ return (GridPaneAjoutScenario) list.get(2);}

    public VBoxSupprimerScenario getVBoxSupprimerScenario(){ return (VBoxSupprimerScenario) components[2];}
}
