/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.visualsmic.probarsocket;

import Models.User;
import Servicios.VSSocket;


/**
 *
 * @author visua
 */
public class ProbarSocket {

    public static void main(String[] args) {
            VSSocket SVS = new VSSocket();

            SVS.ConnectSocket();

    }
}
