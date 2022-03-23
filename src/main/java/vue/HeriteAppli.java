package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HeriteAppli extends Application {
    public void start(Stage stage) {
        VBoxRoot root = new VBoxRoot();

        //setPrefColumns(2);

        Scene scene = new Scene(root, 300, 80);
        stage.setScene(scene);
        stage.setTitle("Hello JavaFX");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);

    }
}
