package ComposantGraphique.Box.BoxAfficheChemin;

import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import modele.DicVille;
import modele.Scenario;
import vue.VBoxRoot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static modele.LectureEcriture.recupVille;

public class StackPaneChoixChemins extends StackPane {

    StackPane stackPane;
    Node [] components;
    public StackPaneChoixChemins(){

    }
    public void setStackPane() throws IOException {
        components = new Node[VBoxRoot.getBoxScenario().getScenarioList().size()];
        System.out.println(VBoxRoot.getBoxScenario().getScenarioList().size());
        for (int i=0;i< VBoxRoot.getBoxScenario().getScenarioList().size();i++){

            Scenario scenario = VBoxRoot.getBoxScenario().getScenarioList().get(i);
            List<String> listVilleAch = new ArrayList<>();
            List<String> listVilleVend = new ArrayList<>();

            for (int y = 0; y<scenario.getAcheteur().size(); y++) {
                listVilleAch.add(recupVille(scenario.getAcheteur().get(y)));
                listVilleVend.add(recupVille(scenario.getVendeur().get(y)));
            }

            DicVille dicVille = new DicVille();
            dicVille.setDicVille(listVilleVend,listVilleAch);
            dicVille.doChemin(dicVille.getDicVille(),new ArrayList<>());

            StackPaneAfficheChemin stackPaneAfficheChemin = new StackPaneAfficheChemin();
            System.out.println(dicVille.getListChemin());
            stackPaneAfficheChemin.setStackPane(dicVille.getListChemin());

            components [i] = stackPaneAfficheChemin.getStackPane();

        }

        stackPane = new StackPane(components);
        System.out.println("test");
    }

    public StackPane getStackPane(){
        return stackPane;
    }

}
