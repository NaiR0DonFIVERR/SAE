package ComposantGraphique.Scroll;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import modele.Scenario;

import java.io.IOException;

public class ScrollPaneCli extends ScrollPane {

    VBox vBox;
    ScrollPane scrollPane;
    VBox boxAll;

    public ScrollPaneCli(){
        boxAll = new VBox();
        vBox = new VBox();
        scrollPane = new ScrollPane();
        scrollPane.setMinViewportWidth(200);
        scrollPane.setMinViewportHeight(100);
        scrollPane.setMaxHeight(500);
        scrollPane.setContent(vBox);
        boxAll.getChildren().add(scrollPane);
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

        boxAll.getChildren().remove(0);
        vBox = new VBox();
        scrollPane = new ScrollPane();
        scrollPane.setMinViewportWidth(175);
        scrollPane.setMinViewportHeight(200);
        scrollPane.setMaxHeight(500);
        scrollPane.setContent(vBox);
        boxAll.getChildren().add(scrollPane);
    }

    public ScrollPane getScrollPane(){
        return scrollPane;
    }

    public VBox getBoxAll(){
        return boxAll;
    }

}
