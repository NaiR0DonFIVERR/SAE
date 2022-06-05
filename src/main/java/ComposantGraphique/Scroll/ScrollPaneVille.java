package ComposantGraphique.Scroll;

import javafx.scene.control.Label;
import modele.Scenario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static modele.LectureEcriture.getDistance;
import static modele.LectureEcriture.recupVille;
import static modele.VariableLoc.getListVilleAch;
import static modele.VariableLoc.getListVilleVend;


public class ScrollPaneVille extends ScrollPaneCli {

    public void setScollVille(Scenario scenario) throws IOException {

        delete();
        List<String> listVilleVend = new ArrayList<>();
        List<String> listVilleAch = new ArrayList<>();
        for (int i=0;i<scenario.getVendeur().size();i++){
            listVilleVend.add(recupVille(scenario.getVendeur().get(i)));
            listVilleAch.add(recupVille(scenario.getAcheteur().get(i)));
        }
        for (int i=0; i<listVilleVend.size();i++){
            int DISTANCE = getDistance(listVilleVend.get(i), listVilleAch.get(i));
            Label labelVille = new Label(listVilleVend.get(i) +" --> " + listVilleAch.get(i) + " " + DISTANCE+"km");
            if (i%2==0){
                labelVille.setId("textGris");
            }
            vBox.getChildren().add(labelVille);
        }
    }
}
