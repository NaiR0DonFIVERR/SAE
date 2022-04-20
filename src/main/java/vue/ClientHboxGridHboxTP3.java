package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

public class ClientHboxGridHboxTP3 extends Application{
    public void start(Stage stage) {
        HBoxRoot root = new HBoxRoot();

        Scene scene = new Scene(root, 500, 500);
        File[] fichierCss = new File("src/main/java/CSS").listFiles();

        for (File fichier : fichierCss){
            scene.getStylesheets().add(fichier.toURI().toString());
        }

        //setPrefColumns(2);


        stage.setScene(scene);
        stage.setTitle("Hello JavaFX");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);

    }
}
