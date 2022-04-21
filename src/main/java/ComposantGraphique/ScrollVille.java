package ComposantGraphique;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import modele.Scenario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static modele.LectureEcriture.*;
import static modele.Methode.getTrajet;

public class ScrollVille extends ScrollAch_Vend{

    public void setScollVille(Scenario scenario) throws IOException {
        delete();
        for (int i=0; i<scenario.getVendeur().size();i++){
            String espace = "";
            for (int y=0; y< 13-scenario.getVendeur().get(i).length(); y++){
                espace = espace + " ";
            }
            String ville_Vend = recupVille(scenario.getVendeur().get(i));
            String ville_Ach = recupVille(scenario.getAcheteur().get(i));
            List<List<String>> list = new ArrayList<>();
            list.add(new ArrayList<>(Collections.singleton(ville_Vend)));
            list.get(0).add(ville_Ach);
            Label label = new Label(ville_Vend +espace+ " -> "+ ville_Ach + " " +getTrajet(list).get(0)+"km");
            label.setAccessibleText(String.valueOf(i));
            label.setUserData(scenario.getVendAch(i));
            VBox.setMargin(label, new Insets(8));
            box.getChildren().add(label);
            //System.out.println("taille vend "+listVendeur.get(i).length() + " ach : " + listAch.get(i).length() + " villeVen : " + listVilleVend.get(i).length() + " villeAch : " + listVilleAch.get(i).length());
        }
        System.out.println(getLabel());
    }
}
