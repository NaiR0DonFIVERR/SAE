package Controler;

import ComposantGraphique.Box.BoxAfficheChemin.StackPaneChoixChemins;
import ComposantGraphique.Box.BoxScenario;
import ComposantGraphique.Box.BoxSwitch.StackPaneChoixUtilisateur;
import ComposantGraphique.Scroll.ScrollPaneCli;
import ComposantGraphique.Scroll.ScrollPaneVille;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.StackPane;
import modele.DicVille;
import modele.Scenario;
import vue.VBoxRoot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controler implements EventHandler {

    @Override
    public void handle(Event event) {
        ScrollPaneVille scrollPaneVille = VBoxRoot.getScrollPaneVille();
        ScrollPaneCli scrollPaneCli = VBoxRoot.getSrollPaneCli();
        /*VariableLoc variableLoc = VBoxRoot.getVariableLoc();
        DicVille dicVille = VBoxRoot.getDicVille();
        HBox hBox = VBoxRoot.getBox_boxMenu_stackPane();
        StackPaneAfficheChemin stackPaneAfficheChemin = VBoxRoot.getStackPaneAfficheChemin();
        StackPane stackPane = (StackPane) hBox.getChildren().get(1);*/
        BoxScenario boxScenario = VBoxRoot.getBoxScenario();
        StackPaneChoixUtilisateur stackPaneChoixUtilisateur = VBoxRoot.getStackPaneChoixUtilisateur();
        StackPaneChoixChemins stackPaneChoixChemins = stackPaneChoixUtilisateur.getStackPaneChoixChemin();
        StackPane stackPane1 = (StackPane) stackPaneChoixChemins.getStackPane().getChildren().get(2);
        int TAILLE = stackPaneChoixChemins.getStackPane().getChildren().size()-1;

        if (event.getSource() instanceof Button) {
            if (((Button) event.getSource()).getAccessibleText() == "ChangeScenario") {
                        //variableLoc.setVariable((Scenario) ((Button) event.getSource()).getUserData());
                try {
                    scrollPaneCli.setScoll((Scenario) ((Button) event.getSource()).getUserData());
                    scrollPaneVille.setScollVille((Scenario) ((Button) event.getSource()).getUserData());
                    while (((Button) event.getSource()).getUserData() != stackPaneChoixChemins.getStackPane().getChildren().get(TAILLE).getUserData()){
                        stackPaneChoixChemins.getStackPane().getChildren().get(TAILLE).toBack();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                        /*
                        dicVille.setDicVille(getListVilleVend(), getListVilleAch());
                        dicVille.removelistChein();
                        dicVille.doChemin(dicVille.getDicVille(), new ArrayList<>());
                        System.out.println(dicVille);
                        stackPaneAfficheChemin.setStackPane(dicVille.getListChemin());
                         */


            }
            else if (((Button) event.getSource()).getAccessibleText() == "AjoutScenario") {

                try {
                    List<String> listVend = new ArrayList<>(stackPaneChoixUtilisateur.getgridPaneAjoutScenario().getScrollPaneAjoutEtape().getListVend());
                    List<String> listAch = new ArrayList<>(stackPaneChoixUtilisateur.getgridPaneAjoutScenario().getScrollPaneAjoutEtape().getListAch());
                    Scenario scenario = new Scenario(listVend,listAch);
                    System.out.println(scenario);
                    boxScenario.addScenario(scenario);
                    stackPaneChoixUtilisateur.getgridPaneAjoutScenario().ajoutScenario();
                    scrollPaneCli.setScoll(scenario);
                    scrollPaneVille.setScollVille(scenario);
                    /*DicVille dicVille = new DicVille();
                    dicVille.setDicVille(scenario.getVendeur(),scenario.getAcheteur());
                    System.out.println(dicVille.getDicVille());
                    dicVille.doChemin(dicVille.getDicVille(),new ArrayList<>());
                    System.out.println(dicVille.getListChemin());*/
                    stackPaneChoixChemins.addStack(scenario);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            else if (((Button) event.getSource()).getAccessibleText() == "SupprimerScenario"){

                ComboBox comboBox = stackPaneChoixUtilisateur.getVBoxSupprimerScenario().getComboBox();
                String valeur = (String) comboBox.getValue();
                for (int i=0;i<boxScenario.getBoxScenario().getChildren().size();i++){
                    Button button = (Button) boxScenario.getBoxScenario().getChildren().get(i);
                    if (button.getText().equals(valeur)){
                        boxScenario.getBoxScenario().getChildren().remove(button);
                        comboBox.getItems().remove(valeur);
                        if (comboBox.getItems().size()>0) {
                            comboBox.setValue(comboBox.getItems().get(0));
                        }
                        else {
                            System.out.println("Aucun scenario disponible");
                        }
                        break;
                    }
                }
            }
        }
        if (event.getSource() instanceof RadioButton){
            switch (((RadioButton)
                 event.getSource()).getAccessibleText()) {
                case "ChangeAffichageChemin":
                        //Récupère la stackPane de la box
                    while (Integer.parseInt(stackPane1.getChildren().get(2).getAccessibleText()) != (int) ((RadioButton) event.getSource()).getUserData()){
                        stackPane1.getChildren().get(2).toBack();
                    }
                    /*
                    while (Integer.parseInt(stackPane.getChildren().get(2).getAccessibleText()) != (int) ((RadioButton) event.getSource()).getUserData()){
                        stackPane.getChildren().get(2).toBack();
                    }*/
                    System.out.println(((RadioButton) event.getSource()).getUserData());
            }
        }
        if (event.getSource() instanceof MenuItem){
            int TAILLECHOIXUTILISATEUR = stackPaneChoixUtilisateur.getStackPane().getChildren().size()-1;
            while (((MenuItem) event.getSource()).getUserData() != stackPaneChoixUtilisateur.getStackPane().getChildren().get(TAILLECHOIXUTILISATEUR).getUserData()){
                stackPaneChoixUtilisateur.getStackPane().getChildren().get(TAILLECHOIXUTILISATEUR).toBack();
            }
        }
    }

}

