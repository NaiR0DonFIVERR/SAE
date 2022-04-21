package ComposantGraphique.boxScenario;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class BoxBoutonScenario extends VBox {

    List<Button> listBouton ;

    BoxScenarioAjout_Supp box;

    VBox boxBouton ;

    public BoxBoutonScenario(){

        listBouton = new ArrayList<>();
        boxBouton = new VBox();
        //box = new BoxScenarioAjout_Supp();

        boxBouton.setId("BoxScenario");
        boxBouton.getChildren().add(new Label("Liste des scenario"));
        //boxBouton.getChildren().add(box.getBox());
    }

    public void ajoutBouton(Button boutonScenario){
        listBouton.add(boutonScenario);
        boxBouton.getChildren().add(boutonScenario);
    }

    public void delete(int indice){
        boxBouton.getChildren().remove(listBouton.get(indice));
        listBouton.remove(0);
    }

    public List<Button> getListBouton(){

        return listBouton;
    }

    public VBox getBoxBouton(){

        return boxBouton;
    }

    public BoxScenarioAjout_Supp getBoxAjout(){

        return box;
    }


}
