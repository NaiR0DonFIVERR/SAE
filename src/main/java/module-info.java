module com.example.classemodele {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.classemodele to javafx.fxml;
    exports com.example.classemodele;
    exports vue;

}