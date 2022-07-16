/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import Models.Client;
import Models.User;

import com.visualsmic.probarsocket.ProbarSocket;
import io.socket.client.IO;
import io.socket.client.Socket;
//import io.socket.client.VSSocket;
import io.socket.emitter.Emitter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author visua
 */
public class VSSocket {

    String url = "http://localhost:4000";
    User user;
    private Socket socket;
    private final FileManagement FM = new FileManagement();
    private Emitter.Listener Casa;

    public VSSocket() {
//        FileManagement FM = new FileManagement();
        this.user = FM.ReadFileConfig();
    }

    public void ConnectSocket() {

        System.out.println("Entrando a ConnectSocket " + user);
        JSONObject object = new JSONObject();
        object.put("IdUser", user.getLngNumId());
        try {
            IO.Options options = IO.Options.builder()
                    .setForceNew(false)
                    .build();
            // Number of failed retries
            options.reconnectionAttempts = 10;
            // Time interval for failed reconnection
            options.reconnectionDelay = 1000;
            // Connection timeout (ms)
            options.timeout = 500;
            socket = IO.socket(URI.create(url), options); // the main namespace

            socket.connect();
            sendMsg("LoginJava", object);

            socket.on("Enrollment", new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    ObtenerClaseClient((JSONObject) args[0]);
                }
            });

        } catch (JSONException ex) {
            Logger.getLogger(VSSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void DesconnetSocke() {
    }

    private void ObtenerClaseClient(JSONObject RS) {

        Client client = new Client(RS.getInt("lngNumIdClient"), RS.getString("NitClient"),
                RS.getString("NameClient"), RS.getString("OficinaClientName"), RS.getInt("OficinaClientCode"));
        try {
            FM.GenerarFileClient(client);
            System.out.println("ObtenerClaseClient FM.ReadFileClient() "+FM.ReadFileClient()); //esta no va, va en el frmcliente
        } catch (IOException ex) {
            Logger.getLogger(VSSocket.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Obtener CLse " + client);

    }

    public void sendMsg(String nameEven, JSONObject object) {

        socket.emit(nameEven, object);

        Emitter on = socket.on(nameEven, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                System.out.println("Mensaje Recibido Del Servidor" + args[0]);

                try {
                    AnalisisSendmsgRespond("LoginJava", (JSONObject) args[0]);
                } catch (JSONException ex) {
                    System.err.println("ERROR, Socket VS : " + ex.getMessage());
                    Logger.getLogger(ProbarSocket.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private void AnalisisSendmsgRespond(String FormulMsg, JSONObject RS) {
        System.out.println(".AnalisisSendmsgRespond() " + RS);
        switch (FormulMsg) {
            case "LoginJava" -> {
                user.setSOIJava(RS.getString("idSocket"));
                try {
                    FM.GenerarFileString(user);
                    System.out.println("ReadJSonLogin,GenerarFileString  user " + user);
                } catch (IOException ex) {
                    Logger.getLogger(VSSocket.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(".AnalisisSendmsgRespond() LoginJava" + RS);
            }
            default ->
                throw new AssertionError();
        }
    }

}
