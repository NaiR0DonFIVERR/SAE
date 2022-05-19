package ComposantGraphique.Scroll;

import javafx.scene.control.Label;
import modele.Scenario;

import java.io.IOException;

import static modele.LectureEcriture.recupVille;
import static modele.VariableLoc.getListVilleAch;
import static modele.VariableLoc.getListVilleVend;


public class ScrollPaneVille extends ScrollPaneCli {

    public void setScollVille() {

        delete();
        for (int i=0; i<getListVilleVend().size();i++){

            Label labelVille = new Label(getListVilleVend().get(i) +" --> " + getListVilleAch().get(i));
            vBox.getChildren().add(labelVille);
        }
    }
}
