module com.visualsmic.vshuellassocket {
    requires javafx.controls;
    requires javafx.fxml;    
    requires java.base;
    requires java.net.http;
    requires com.google.gson;
    requires org.json;    

    opens com.visualsmic.vshuellassocket to javafx.fxml;
    exports com.visualsmic.vshuellassocket;
}
