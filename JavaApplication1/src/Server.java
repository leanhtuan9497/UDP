
import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class Server {

    public static void main(String[] args) throws SocketException {
        DatagramSocket dg = new DatagramSocket(1260);
        byte bodem[] = new byte[256];
        DatagramPacket dp = new DatagramPacket(bodem, bodem.length);
        try {
            dg.receive(dp);
            System.out.println("Dang cho");
            String st = new String(dp.getData()).trim();
//              String st = dp.getData().toString();
            System.out.println(st + " Nhan tu may:" + dp.getAddress().getHostName());

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
