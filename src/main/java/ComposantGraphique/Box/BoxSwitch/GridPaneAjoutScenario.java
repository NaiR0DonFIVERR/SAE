package ComposantGraphique.Box.BoxSwitch;

import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.io.IOException;

import static modele.LectureEcriture.getMembres;

public class GridPaneAjoutScenario extends GridPane {

    GridPane gridPane;
    ComboBox comboBoxVendeur;
    ComboBox comboBoxAcheteur;

    public GridPaneAjoutScenario(){
        gridPane = new GridPane();
    }

    public void setGridPane() throws IOException {

        gridPane = new GridPane();
        gridPane.setPadding(new Insets(40));
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setGridLinesVisible(true);
        Label labelTitle = new Label("Ajout d'un scenario");
        for (String cli : getMembres()){    //la methode retourne une liste de tout les clients;
            comboBoxAcheteur.getItems().add(cli);
            comboBoxVendeur.getItems().add(cli);
        }
    }

    public GridPane getGridPane(){
        return gridPane;
    }

}
