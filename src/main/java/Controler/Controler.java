package Controler;

import ComposantGraphique.Scroll.ScrollPaneCli;
import ComposantGraphique.Scroll.ScrollPaneVille;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import modele.Scenario;
import vue.HBoxRoot;

public class Controler implements EventHandler {

    @Override
    public void handle(Event event) {
        ScrollPaneVille scrollPaneVille = HBoxRoot.getScrollPaneVille();
        ScrollPaneCli scrollPaneCli = HBoxRoot.getSrollPaneCli();

        if (event.getSource() instanceof Button) {
            switch (((Button)
                    event.getSource()).getAccessibleText()) {
                case "ChangeScenario":
                    try {
                        scrollPaneCli.setScoll((Scenario) ((Button) event.getSource()).getUserData());
                        scrollPaneVille.setScollVille((Scenario) ((Button) event.getSource()).getUserData());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
        }
    }

}

