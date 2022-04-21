package ComposantGraphique.GridPane;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static modele.Methode.getTrajet;

public class ScrollPaneEtape {

    VBox boxAll;
    VBox box ;
    List<List<String>> listEtape;
    ScrollPane scrollPane ;

    public ScrollPaneEtape(){

        scrollPane = new ScrollPane();
        box = new VBox();
        boxAll = new VBox();
        listEtape = new ArrayList<>();

        scrollPane.setContent(box);
        scrollPane.setMinViewportHeight(250);
        scrollPane.setMinViewportWidth(100);
        boxAll.getChildren().add(scrollPane);
    }

    public void ajoutEtapScroll(List<String> cli) throws IOException {
        System.out.println("test");
        Label labelCli = new Label(cli.get(0) + " -> " + cli.get(1));
        System.out.println("appli");
        box.getChildren().add(labelCli);
        listEtape.add(cli);
    }

    public void resetScrollEtape(){

        System.out.println("test");
        boxAll.getChildren().remove(0);
        scrollPane = new ScrollPane();
        box = new VBox();
        scrollPane.setMinViewportHeight(250);
        scrollPane.setMinViewportWidth(100);
        scrollPane.setContent(box);
        boxAll.getChildren().add(scrollPane);
    }

    public List<List<String>> getListEtape(){

        return listEtape;
    }

    public VBox getBoxAll(){

        return boxAll;
    }
}
