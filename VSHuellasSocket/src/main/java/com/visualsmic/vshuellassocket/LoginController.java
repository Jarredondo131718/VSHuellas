package com.visualsmic.vshuellassocket;

import Services.FileManagement;
import Services.Login;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnLogout;

    @FXML
    private PasswordField txtPassWord;

    @FXML
    private TextField txtUsuario;

    @FXML
    void btnLoginOnAction(ActionEvent event) {
//         Login L = new Login("JA", "C");
        Login L = new Login(txtUsuario.getText(), txtPassWord.getText());
        System.out.println(" DATE INPUT "+txtUsuario.getText() +" pasw "+txtPassWord.getText() );
//        boolean inOk=txtUsuario.toString().length()>0

    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) throws IOException {
        App.setRoot("frmEnrollment");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
