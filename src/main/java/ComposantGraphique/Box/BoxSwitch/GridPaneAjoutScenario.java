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

    ComboBox comboBoxVendeur;
    ComboBox comboBoxAcheteur;
    ScrollPaneAjoutEtape scrollPaneAjoutEtape;
    Button buttonAjoutEtape;
    Button buttonAjoutScenario;

    public GridPaneAjoutScenario(){
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

        this.setPadding(new Insets(40));
        this.setHgap(20);
        this.setVgap(20);
        Label labelTitle = new Label("Ajout d'un scenario");
        labelTitle.setId("labelTilte");

        for (String cli : getMembres()){    //la methode retourne une liste de tout les clients;
            comboBoxAcheteur.getItems().add(cli);
            comboBoxVendeur.getItems().add(cli);
        }

        this.add(labelTitle, 0,0,5,1);
        GridPane.setHalignment(labelTitle, HPos.CENTER);
        this.setId("backGroudWhite");

        //Ajout des acheteurs et vendeurs
        this.add(new Label("Vendeur"), 0,1,1,1);
        this.add(new Label("Acheteur"), 2,1,1,1);
        this.add(comboBoxVendeur, 0,2,2,1);
        this.add(comboBoxAcheteur, 2,2,2,1);
        this.add(buttonAjoutEtape,0,4,1,1);
        this.add(buttonAjoutScenario,2,4,1,1);
        this.add(scrollPaneAjoutEtape,2,5,1,1);
    }


    public ScrollPaneAjoutEtape getScrollPaneAjoutEtape(){ return scrollPaneAjoutEtape; }

    public void ajoutEtape(){
        scrollPaneAjoutEtape.ajoutEtape((String) comboBoxVendeur.getValue(), (String) comboBoxAcheteur.getValue());
    }

    public void ajoutScenario(){
        scrollPaneAjoutEtape.delete();
    }

}
