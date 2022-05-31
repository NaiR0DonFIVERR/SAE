package Controler;

import ComposantGraphique.Box.BoxAfficheChemin.GridPaneChoixAfficheChemin;
import ComposantGraphique.Box.BoxAfficheChemin.StackPaneAfficheChemin;
import ComposantGraphique.Box.BoxAfficheChemin.StackPaneChoixChemins;
import ComposantGraphique.Scroll.ScrollPaneCli;
import ComposantGraphique.Scroll.ScrollPaneVille;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import modele.DicVille;
import modele.Scenario;
import modele.VariableLoc;
import vue.VBoxRoot;

import java.util.ArrayList;
import java.util.Random;

import static Calcule.Calcul.doChemin;
import static modele.VariableLoc.getListVilleAch;
import static modele.VariableLoc.getListVilleVend;

public class Controler implements EventHandler {

    @Override
    public void handle(Event event) {
        ScrollPaneVille scrollPaneVille = VBoxRoot.getScrollPaneVille();
        ScrollPaneCli scrollPaneCli = VBoxRoot.getSrollPaneCli();
        VariableLoc variableLoc = VBoxRoot.getVariableLoc();
        DicVille dicVille = VBoxRoot.getDicVille();
        HBox hBox = VBoxRoot.getBox_boxMenu_stackPane();
        StackPaneAfficheChemin stackPaneAfficheChemin = VBoxRoot.getStackPaneAfficheChemin();
        StackPane stackPane = (StackPane) hBox.getChildren().get(1);
        StackPaneChoixChemins stackPaneChoixChemins = VBoxRoot.getStackPaneChoixChemins();
        StackPane stackPane1 = (StackPane) stackPaneChoixChemins.getStackPane().getChildren().get(2);
        int TAILLE = stackPaneChoixChemins.getStackPane().getChildren().size()-1;

        if (event.getSource() instanceof Button) {
            switch (((Button)
                    event.getSource()).getAccessibleText()) {
                case "ChangeScenario":
                    try {
                        //variableLoc.setVariable((Scenario) ((Button) event.getSource()).getUserData());
                        scrollPaneCli.setScoll((Scenario) ((Button) event.getSource()).getUserData());
                        scrollPaneVille.setScollVille((Scenario) ((Button) event.getSource()).getUserData());
                        /*
                        dicVille.setDicVille(getListVilleVend(), getListVilleAch());
                        dicVille.removelistChein();
                        dicVille.doChemin(dicVille.getDicVille(), new ArrayList<>());
                        System.out.println(dicVille);
                        stackPaneAfficheChemin.setStackPane(dicVille.getListChemin());
                         */
                        while (((Button) event.getSource()).getUserData() != stackPaneChoixChemins.getStackPane().getChildren().get(TAILLE).getUserData()){
                            stackPaneChoixChemins.getStackPane().getChildren().get(TAILLE).toBack();
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
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
    }

}

