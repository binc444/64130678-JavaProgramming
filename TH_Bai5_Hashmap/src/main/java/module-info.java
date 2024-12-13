module th.tranminhhieu.th_bai5_hashmap {
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

  opens th.tranminhhieu.th_bai5_hashmap to javafx.fxml;
  exports th.tranminhhieu.th_bai5_hashmap;
}