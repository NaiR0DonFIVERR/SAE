package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;


public class HeriteAppli extends Application {
    public void start(Stage stage) {
        VBoxRoot root = new VBoxRoot();
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
