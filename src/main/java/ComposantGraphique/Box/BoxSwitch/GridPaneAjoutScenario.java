package ComposantGraphique.Box.BoxSwitch;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import vue.VBoxRoot;

import java.io.IOException;

import static modele.LectureEcriture.getMembres;

public class GridPaneAjoutScenario extends GridPane {

    GridPane gridPane;
    ComboBox comboBoxVendeur;
    ComboBox comboBoxAcheteur;
    ScrollPaneAjoutEtape scrollPaneAjoutEtape;
    Button buttonAjoutEtape;
    Button buttonAjoutScenario;

    public GridPaneAjoutScenario(){
        gridPane = new GridPane();
        comboBoxVendeur = new ComboBox<>();
        comboBoxAcheteur = new ComboBox<>();
        scrollPaneAjoutEtape = new ScrollPaneAjoutEtape();
        buttonAjoutEtape = new Button("Ajout etape");
        buttonAjoutScenario = new Button("Ajout scenario");
        buttonAjoutScenario.setAccessibleText("AjoutScenario");
        buttonAjoutEtape.setId("boutonAjoutEtape");
        buttonAjoutEtape.setOnAction(evt ->{ajoutEtape();});
        buttonAjoutScenario.setOnAction(VBoxRoot.getControler());
    }

    public void setGridPane() throws IOException {

        gridPane.setPadding(new Insets(40));
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        Label labelTitle = new Label("Ajout d'un scenario");
        labelTitle.setId("labelTilte");

        for (String cli : getMembres()){    //la methode retourne une liste de tout les clients;
            comboBoxAcheteur.getItems().add(cli);
            comboBoxVendeur.getItems().add(cli);
        }

        gridPane.add(labelTitle, 0,0,5,1);
        GridPane.setHalignment(labelTitle, HPos.CENTER);
        gridPane.setId("backGroudWhite");

        //Ajout des acheteurs et vendeurs
        gridPane.add(new Label("Vendeur"), 0,1,1,1);
        gridPane.add(new Label("Acheteur"), 2,1,1,1);
        gridPane.add(comboBoxVendeur, 0,2,2,1);
        gridPane.add(comboBoxAcheteur, 2,2,2,1);
        gridPane.add(buttonAjoutEtape,0,4,1,1);
        gridPane.add(buttonAjoutScenario,2,4,1,1);
        gridPane.add(scrollPaneAjoutEtape,2,5,1,1);
    }

    public GridPane getGridPane(){
        return gridPane;
    }

    public ScrollPaneAjoutEtape getScrollPaneAjoutEtape(){ return scrollPaneAjoutEtape; }

    public void ajoutEtape(){
        scrollPaneAjoutEtape.ajoutEtape((String) comboBoxVendeur.getValue(), (String) comboBoxAcheteur.getValue());
    }

    public void ajoutScenario(){
        scrollPaneAjoutEtape.delete();
    }

}
