/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import Models.Client;
import Models.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;


/**
 *
 * @author visua Clase para la Administracion de Archivos textos
 */
public class FileManagement {

    private final String NameFile = "src/main/resources/ConfigUser.Txt";
    private final String NameFileClient = "src/main/resources/Client.Txt";
    private final String ENCODING = "UTF-8";

    public FileManagement() {

    }

    public void GenerarFileString(User user) throws IOException {
        File File = new File(NameFile);
        File.createNewFile();
        System.out.println("Services.FileManagement.probar() probar " + user);
        try ( PrintWriter writer = new PrintWriter(File, ENCODING)) {
            writer.println(user.getLngNumId() + "," + user.getIntPrioridad() + "," + user.getStrNit()
                    + "," + user.getNombreUsuario() + "," + user.getNombreOficina() + ","
                    + user.getSOINode() + "," + user.getSOIJava());
        }
        //System.out.println("Services.FileManagement.FileManagement() Se Creó 2 " + RS.getJSONArray());      
    }

    public void FileManagement(User user) {
        try {
            GenerarFileString(user);
        } catch (IOException ex) {
//            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        //TODO Cuando se resuleva problema de jSon from, se eliminan los metodos GenerarFileString
        boolean borrar = true;
        if (borrar) {
            return;
        }
        System.out.println("Services.FileManagement.FileManagement() user " + user);
        System.out.println("Services.FileManagement.FileManagement() NameFile " + NameFile);
        try {
            File File = new File(NameFile);
            File.createNewFile();
            System.out.println("Services.FileManagement.FileManagement() Se Creó 1 ");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            int x = 0;
            if (x == 0) {
                return;
            }
            String GSS = gson.toJson(user);
            System.out.println("Services.FileManagement.FileManagement() Se Creó 3 " + GSS);

            try ( PrintWriter writer = new PrintWriter(File, ENCODING)) {
                writer.println(GSS);
            }
        } catch (IOException | JsonIOException e) {
            System.err.println("Error al Crear  Archivo " + e.getMessage());
        }

        System.out.println("Services.FileManagement.FileManagement() Secreo " + NameFile);
    }

    public User ReadFileConfig() {
        String Linea = "";

        try {
            //Intializing  Buffer Reader By Providing File path
            try ( BufferedReader Reader = new BufferedReader(new FileReader(NameFile))) {
                //Intializing  Buffer Reader By Providing File path
                String Data;

                while ((Data = Reader.readLine()) != null) {
                    Linea += Data + " ";
                }
            }
        } catch (IOException e) {
            System.err.println("Error al Leer Archivo " + e.getMessage());
        }

        //TODO Cuando se resuleva problema de jSon from, se eliminan los metodos GenerarFileString
        boolean Borrar = true;
        if (Borrar) {
            return ReadFileStrin(Linea);
        }

        System.out.println("Salir  Linea " + Linea + " su len " + Linea.trim().length());
        Gson gson = new Gson();
        User user = new User();

        if (Linea.trim().length() > 0) {
            try {
                user = gson.fromJson(Linea, User.class);
            } catch (JsonSyntaxException e) {
                System.out.println("Eroro Filemanage Json " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Error al Leer Archivo Json Exception " + e.getMessage());
            }

        }

        System.out.println("ReadFileConfig Salir  Nuevo user retor" + user);
        return user;
    }

    private User ReadFileStrin(String Linea) {
        String ar[] = Linea.split("\\,");

        System.out.println("Services.FileManagement.ReadFileStrin() Arrays " + Arrays.toString(ar));

        User user = new User(Integer.parseInt(ar[0]), Integer.parseInt(ar[1]), ar[2], ar[3], ar[4], ar[5], ar[6]);

        System.out.println("Services.FileManagement.ReadFileStrin() Linea " + user);

        return user;
    }

    public void GenerarFileClient(Client client) throws IOException {
        File File = new File(NameFileClient);
        File.createNewFile();    
        try ( PrintWriter writer = new PrintWriter(File, ENCODING)) {
            writer.println(client.getLngNumIdClient() + "," + client.getNitClient() + ","
                    + client.getNameClient() + "," + client.getNombreOficina() + "," + client.getCodigoOficina());
        }
    }

    public Client ReadFileClient() {
        String Linea = "";

        try {
            //Intializing  Buffer Reader By Providing File path
            try ( BufferedReader Reader = new BufferedReader(new FileReader(NameFileClient))) {
                //Intializing  Buffer Reader By Providing File path
                String Data;

                while ((Data = Reader.readLine()) != null) {
                    Linea += Data + " ";
                }
            }
        } catch (IOException e) {
            System.err.println("Error al Leer Archivo " + e.getMessage());
        }

        //TODO Cuando se resuleva problema de jSon from, se eliminan los metodos GenerarFileString
        boolean Borrar = true;
        if (Borrar) {
            return ReadFileClientString(Linea);
        }

        System.out.println("Salir  Linea " + Linea + " su len " + Linea.trim().length());
        Gson gson = new Gson();
        Client client = new Client(0, Linea, Linea, Linea, 0);

        if (Linea.trim().length() > 0) {
            try {
                client = gson.fromJson(Linea, Client.class);
            } catch (JsonSyntaxException e) {
                System.out.println("Eroro Filemanage Json " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Error al Leer Archivo Json Exception " + e.getMessage());
            }

        }

        System.out.println("ReadFileConfig Salir  Nuevo user retor" + client);
        return client;
    }

    private Client ReadFileClientString(String Linea) {
        String ar[] = Linea.split("\\,");
        Client client = new Client(Integer.parseInt(ar[0]),ar[1], ar[2], ar[3], Integer.parseInt(ar[4].replaceAll("\\s+","")));
        return client;
    }

}
