module com.example.classemodele {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;

    opens com.example.classemodele to javafx.fxml;
    exports com.example.classemodele;
    exports vue;
    //exports Controler;

}