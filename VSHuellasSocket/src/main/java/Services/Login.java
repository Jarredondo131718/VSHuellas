/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Models.User;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author visua
 */
public class Login {

    public Login(String UserName, String Password) {
  
        String Caracter = "\"";
        String inputJson = "{ \"strUsuario\":";
        inputJson += Caracter + UserName + Caracter + ",";
        inputJson += Caracter + "strClave" + Caracter + ":" + Caracter + Password + Caracter + ",";

        inputJson += Caracter + "ExecuteQuery" + Caracter + ":" + Caracter + "QRY" + Caracter + ",";
        inputJson += "\"Formula\":" + Caracter + "LoadUserJava" + Caracter + " }";

        VSConsumeRest HR = new VSConsumeRest();
        JSONObject RS = HR.ReturnServices(inputJson);

        try {
            User user = new User(RS.getInt("lngNumId"), RS.getInt("intPrioridad"),
                    RS.getString("strNit"), RS.getString("NombreUsuario"),
                    RS.getString("NombreOficina"), RS.getString("SOINode"),
                    RS.getString("SOIJava"));
            FileManagement FM = new FileManagement();
            FM.FileManagement(user);
            System.out.println(" La Clase " + user);
        } catch (JSONException e) {
            System.err.println("Error en Login " + e.getMessage());
        }

        System.out.println("******************************");
    }
}
