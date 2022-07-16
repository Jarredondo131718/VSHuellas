/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author visua
 */
public class Client {
    private int lngNumIdClient;
    private String NitClient;

    public Client(int lngNumIdClient,String NitClient,String NameClient,String NombreOficina,int CodigoOficina){
//,  , , ) {
        this.lngNumIdClient = lngNumIdClient;
        this.NitClient = NitClient;
        this.NameClient = NameClient;
        this.NombreOficina = NombreOficina;
        this.CodigoOficina = CodigoOficina;
    }

    public Client() {
    }

    public String getNitClient() {
        return NitClient;
    }

    public void setNitClient(String NitClient) {
        this.NitClient = NitClient;
    }
    private String NameClient;
    private String NombreOficina;  
    private int CodigoOficina;      

    public int getLngNumIdClient() {
        return lngNumIdClient;
    }

    public void setLngNumIdClient(int lngNumIdClient) {
        this.lngNumIdClient = lngNumIdClient;
    }

    
    public String getNameClient() {
        return NameClient;
    }

    public void setNameClient(String NameClient) {
        this.NameClient = NameClient;
    }

    public String getNombreOficina() {
        return NombreOficina;
    }

    public void setNombreOficina(String NombreOficina) {
        this.NombreOficina = NombreOficina;
    }

    public int getCodigoOficina() {
        return CodigoOficina;
    }

    public void setCodigoOficina(int CodigoOficina) {
        this.CodigoOficina = CodigoOficina;
    }

    @Override
    public String toString() {
        return "Client{" + "lngNumIdClient=" + lngNumIdClient + ", NitClient=" + NitClient + ", NameClient=" + NameClient + ", NombreOficina=" + NombreOficina + ", CodigoOficina=" + CodigoOficina + '}';
    }

   
    
}
