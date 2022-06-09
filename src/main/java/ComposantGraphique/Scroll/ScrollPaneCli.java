package ComposantGraphique.Scroll;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import modele.Scenario;

import java.io.IOException;

public class ScrollPaneCli extends ScrollPane {

    VBox vBox;

    public ScrollPaneCli(){
        vBox = new VBox();
        this.setMinViewportWidth(200);
        this.setMinViewportHeight(100);
        this.setMaxHeight(500);
        this.setContent(vBox);
    }


    public void setScoll(Scenario scenario)  throws IOException {

        delete();
        for (int i=0; i<scenario.getAcheteur().size(); i++){
            Label labelCli = new Label(scenario.getVendeur().get(i) + " --> " + scenario.getAcheteur().get(i));
            if (i%2==0){
                labelCli.setId("textGris");
            }
            vBox.getChildren().add(labelCli);
        }

    }

    public void delete(){
        int TAILLE = vBox.getChildren().size();
        for (int i=0;i<TAILLE;i++){
            vBox.getChildren().remove(0);
        }
    }

}
