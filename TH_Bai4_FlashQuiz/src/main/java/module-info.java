module th.tranminhhieu.th_bai4_flashquiz {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
  requires java.sql;

  opens th.tranminhhieu.th_bai4_flashquiz to javafx.fxml;
    exports th.tranminhhieu.th_bai4_flashquiz;
}