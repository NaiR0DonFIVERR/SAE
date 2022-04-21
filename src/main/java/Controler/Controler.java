package Controler;

import ComposantGraphique.BoxPresentation;
import ComposantGraphique.GridPane.GridPaneAffichageChemin;
import ComposantGraphique.GridPane.GridPaneAjoutScenario;
import ComposantGraphique.GridPane.ScrollPaneEtape;
import ComposantGraphique.GridPane.VBoxGridPaneChemin;
import ComposantGraphique.boxScenario.BoutonScenario;
import ComposantGraphique.boxScenario.BoxBoutonScenario;
import ComposantGraphique.ScrollAch_Vend;
import ComposantGraphique.ScrollVille;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import modele.Scenario;

import java.io.IOException;

public class Controler implements EventHandler {

    @Override
    public void handle(Event event) {

        BoxPresentation boxPresentation = HBoxRoot2.getBoxPresentation();

        GridPaneAjoutScenario gridPaneAjoutScenario = HBoxRoot2.getGridPaneAjoutScenario();
        ScrollPaneEtape scrollPaneEtape = gridPaneAjoutScenario.getScrollEtape();

        GridPaneAffichageChemin gridPaneAffichageChemin = HBoxRoot2.getGridPaneAffichageChemin();
        VBoxGridPaneChemin boxGridPaneChemin = gridPaneAffichageChemin.getBoxChemin();

        ScrollAch_Vend scrollAch_vend = HBoxRoot2.getScrollAch_VendHbox();
        ScrollVille scrollVille = HBoxRoot2.getScrollVille();
        BoxBoutonScenario boxBoutonScenario = HBoxRoot2.getBoxButtonHBox();
        //System.out.println("teeees");

// la source de event est un scenario
        if (event.getSource() instanceof Button) {
            switch (((Button)
                    event.getSource()).getAccessibleText()){
                case "changeScenario" :
                    try {
                        scrollAch_vend.setScoll((Scenario) ((Button) event.getSource()).getUserData());     //Premier scrollPane (Vendeur -> Acheteur)
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        scrollVille.setScollVille((Scenario) ((Button) event.getSource()).getUserData());       //Deuxième scrollPane (Ville -> Ville)
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        gridPaneAffichageChemin.MAJ_BoxChemin((Scenario) ((Button) event.getSource()).getUserData());           //GridPaneEtape
                        boxPresentation.MAJ_Box(gridPaneAffichageChemin.getGridPane());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //gridPaneAffichageChemin.getBoxChemin().getBox() = new VBoxGridPaneChemin();

                    break;
                case "test" :
                    boxPresentation.MAJ_Box(gridPaneAjoutScenario.getGridPane());
                    //gridPaneAjoutScenario.rendreVisible();
                    break;
            }
            /*
             (((Button) event.getSource()).getAccessibleText() == "changeEtatGridAjout") {
                System.out.println("teeeeeeeests");
                gridPaneAjoutScenario.rendreVisible();
            }
            */
        }
        if (event.getSource() instanceof ToggleButton){
            Scenario scenario = gridPaneAjoutScenario.ajoutScenario();
            BoutonScenario boutonScenario = new BoutonScenario(scenario, boxBoutonScenario);
            scrollPaneEtape.resetScrollEtape();
        }

    }
}
