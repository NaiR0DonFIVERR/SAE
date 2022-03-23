package vue;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import modele.Date;

public class VBoxRoot extends VBox {
    public VBoxRoot(){

        Date DateD = new Date();
        Label labelHello = new Label(DateD.toString());
        this.getChildren().add(labelHello);
    }



}
