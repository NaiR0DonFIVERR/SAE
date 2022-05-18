package ComposantGraphique.Scroll;

import javafx.scene.control.Label;
import modele.Scenario;

import java.io.IOException;

import static modele.LectureEcriture.recupVille;


public class ScrollPaneVille extends ScrollPaneCli {

    public void setScollVille(Scenario scenario) throws IOException {

        delete();
        for (int i=0; i<scenario.getAcheteur().size();i++){

            Label labelVille = new Label(recupVille(scenario.getVendeur().get(i)) +" --> " + recupVille(scenario.getAcheteur().get(i)));
            vBox.getChildren().add(labelVille);
        }
    }
}
