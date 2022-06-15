package ComposantGraphique.Box.BoxAfficheChemin;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import vue.VBoxRoot;

import static Constantes.ConstantesMenu.CHOIX_CHEMIN;

public class GridPaneChoixAfficheChemin extends GridPane {

    ToggleGroup toggleGroup;

    public GridPaneChoixAfficheChemin(){
        toggleGroup = new ToggleGroup();

        //this.setGridLinesVisible(true);
        Label labelTilte = new Label("Choix des chemins");
        labelTilte.setId("labelTilte");
        this.setPadding(new Insets(40));
        this.setHgap(20);
        this.setVgap(20);
        this.setMinSize(400,400);
        this.setId("GridPaneChoixAfficheChemin");
        this.add(labelTilte, 1, 0, 2,1);

        for (int i=0;i<CHOIX_CHEMIN.length;i++){
            RadioButton button = new RadioButton(CHOIX_CHEMIN[i]);
            button.setUserData(i);
            button.setToggleGroup(toggleGroup);
            button.setAccessibleText("ChangeAffichageChemin");
            button.setOnAction(VBoxRoot.getControler());
            this.add(button, i,1+i%2,1,1);
        }
        toggleGroup.selectToggle(toggleGroup.getToggles().get(0));

    }

}

