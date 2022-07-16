package com.visualsmic.vshuellassocket;

import Models.User;
import Services.FileManagement;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class EnrollmentController implements Initializable {

    @FXML
    private Button btnLogin;

    @FXML
    private void btnLoginOnAction() throws IOException {
        App.setRoot("frmLogin");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FileManagement FM = new FileManagement();
        User user = FM.ReadFileConfig();
        
//        VSSocket SVS = new VSSocket();
//        SVS.ConnectSocket();
        
        System.out.println("com.visualsmic.vshuellassocket.EnrollmentController.initialize()" + user);

    }
}
