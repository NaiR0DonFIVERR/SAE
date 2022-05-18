package ComposantGraphique.Scroll;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modele.Scenario;

public class SrollPaneCli {

    VBox vBox;
    ScrollPane scrollPane;

    public SrollPaneCli(Scenario scenario){

        vBox = new VBox();
        scrollPane = new ScrollPane();
        scrollPane.setContent(vBox);

        for (int i=0; i<scenario.getAcheteur().size(); i++){
            Label labelCli = new Label(scenario.getVendeur().get(i) + " --> " + scenario.getAcheteur().get(i));
            vBox.getChildren().add(labelCli);
        }
    }

    public ScrollPane getScrollPane(){
        return scrollPane;
    }

}
