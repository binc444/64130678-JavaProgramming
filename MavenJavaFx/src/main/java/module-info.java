module com.example.mavenjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
  requires json.simple;

  opens com.example.mavenjavafx to javafx.fxml;
    exports com.example.mavenjavafx;
}