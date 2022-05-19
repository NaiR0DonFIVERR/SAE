package Controler;

import ComposantGraphique.Scroll.ScrollPaneCli;
import ComposantGraphique.Scroll.ScrollPaneVille;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import modele.Scenario;
import modele.VariableLoc;
import vue.VBoxRoot;

public class Controler implements EventHandler {

    @Override
    public void handle(Event event) {
        ScrollPaneVille scrollPaneVille = VBoxRoot.getScrollPaneVille();
        ScrollPaneCli scrollPaneCli = VBoxRoot.getSrollPaneCli();
        VariableLoc variableLoc = VBoxRoot.getVariableLoc();

        if (event.getSource() instanceof Button) {
            switch (((Button)
                    event.getSource()).getAccessibleText()) {
                case "ChangeScenario":
                    try {
                        scrollPaneCli.setScoll((Scenario) ((Button) event.getSource()).getUserData());
                        scrollPaneVille.setScollVille((Scenario) ((Button) event.getSource()).getUserData());
                        variableLoc.setVariable((Scenario) ((Button) event.getSource()).getUserData());
                        System.out.println(variableLoc);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
        }
    }

}

