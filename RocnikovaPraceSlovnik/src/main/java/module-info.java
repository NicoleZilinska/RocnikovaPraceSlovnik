module com.example.rocnikovapracezkouska {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.rocnikovapracezkouska to javafx.fxml;
    exports com.example.rocnikovapracezkouska;
}