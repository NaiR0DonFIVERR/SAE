package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;


public class HeriteAppli extends Application {
    public void start(Stage stage) throws IOException {
        VBoxRoot root = new VBoxRoot();
        Scene scene = new Scene(root, 1200, 850);
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
