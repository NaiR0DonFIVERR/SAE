package ComposantGraphique.GridPane;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import modele.Scenario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static modele.LectureEcriture.getMembres;

public class GridPaneAjoutScenario extends GridPane {

    GridPane gridPane;
    ComboBox boxAcheteur = new ComboBox<>();
    ComboBox boxVendeur = new ComboBox();

    Button buttonAjoutCli = new Button("Ajouter etape");
    ToggleButton buttonScenario = new ToggleButton("Ajout scenario");

    ScrollPaneEtape scrollPaneEtape = new ScrollPaneEtape();

    public GridPaneAjoutScenario() throws IOException {



        gridPane = new GridPane();

        //gridPane.setVisible(false);



        Label labelTitle = new Label("Ajout d'un scenario");
        for (String cli : getMembres()){    //la methode retourne une liste de tout les clients;
            boxAcheteur.getItems().add(cli);
            boxVendeur.getItems().add(cli);
        }
        buttonAjoutCli.setOnAction(evt -> {
            try {
                ajoutEtapeButton();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        buttonScenario.setOnAction(HBoxRoot2.getControler());


        gridPane.setPadding(new Insets(40));
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setGridLinesVisible(true);
        gridPane.add(labelTitle, 0,0,5,1);
        GridPane.setHalignment(labelTitle, HPos.CENTER);
        //Ajout des acheteurs et vendeurs
        gridPane.add(new Label("Vendeur"), 0,1,1,1);
        gridPane.add(new Label("Acheteur"), 2,1,1,1);
        gridPane.add(boxVendeur, 0,2,2,1);
        gridPane.add(boxAcheteur, 2,2,2,1);

        gridPane.add(buttonAjoutCli, 1,3,1,1);
        gridPane.add(buttonScenario, 2,3,1,1);


        gridPane.add(new Label("Etape"), 4,0,1,1);
        gridPane.add(scrollPaneEtape.getBoxAll(), 4,1,2,15);

    }

    public GridPane getGridPane(){

        return gridPane;
    }

    public List<String> ajoutEtapeButton() throws IOException {

        if (boxVendeur.getValue() == null || boxAcheteur.getValue()==null || boxAcheteur.getValue() == boxVendeur.getValue()){
            System.out.println("erreur");
        }

        List<String> listOrde = new ArrayList<>();
        listOrde.add((String) boxVendeur.getValue());
        listOrde.add((String) boxAcheteur.getValue());
        scrollPaneEtape.ajoutEtapScroll(listOrde);
        return listOrde;
    }

    public Scenario ajoutScenario(){

        Scenario nvScenario = new Scenario();
        List<List<String>> listEtape = scrollPaneEtape.getListEtape();

        System.out.println(listEtape);
        for (int i=0; i<listEtape.size(); i++){

            nvScenario.ajoutVendeurAcheteur(listEtape.get(i).get(0), listEtape.get(i).get(1));

        }

        return nvScenario;

    }

    public ScrollPaneEtape getScrollEtape(){

        return scrollPaneEtape;
    }

    public void rendreVisible(){
        System.out.println(gridPane.isVisible());
        if (gridPane.isVisible() == true){
            gridPane.setVisible(false);
        }
        else {
            gridPane.setVisible(true);
        }
    }


}
