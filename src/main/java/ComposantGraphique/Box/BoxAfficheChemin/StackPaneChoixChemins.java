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
        //System.out.println(VBoxRoot.getBoxScenario().getScenarioList().size());
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
            //System.out.println(dicVille.getListChemin());
            stackPaneAfficheChemin.setStackPane(dicVille.getListChemin());
            stackPaneAfficheChemin.getStackPane().setUserData(scenario);

            components [i] = stackPaneAfficheChemin.getStackPane();

        }

        stackPane = new StackPane(components);
    }

    public void addStack(Scenario scenario) throws IOException {
        List<String> listVend = new ArrayList<>();
        List<String> listAch = new ArrayList<>();
        for (int i=0;i<scenario.getAcheteur().size();i++){
            listVend.add(recupVille(scenario.getAcheteur().get(i)));
            listAch.add(recupVille(scenario.getVendeur().get(i)));
        }
        DicVille dicVille = new DicVille();
        dicVille.setDicVille(listVend,listAch);
        dicVille.doChemin(dicVille.getDicVille(),new ArrayList<>());
        StackPaneAfficheChemin stackPaneAfficheChemin = new StackPaneAfficheChemin();
        stackPaneAfficheChemin.setStackPane(dicVille.getListChemin());
        stackPaneAfficheChemin.getStackPane().setUserData(scenario);
        /*
        Node [] compo = new Node[components.length+1];
        for (int i=0;i<components.length;i++){
            compo[i] = components[i];
        }
        compo[compo.length-1] = stackPaneAfficheChemin.getStackPane();
        components = compo;
        */
        stackPane.getChildren().add(stackPaneAfficheChemin.getStackPane());
        System.out.println(stackPane.getChildren());
    }

    public StackPane getStackPane(){
        return stackPane;
    }

}
