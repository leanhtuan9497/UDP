
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class GuiNhan {
    public String Nhan(int port) throws SocketException{
        DatagramSocket dg = new DatagramSocket(port);
        byte bodem[] = new byte[256];
        DatagramPacket dp = new DatagramPacket(bodem, bodem.length);
        while (true) {
            try {
                dg.receive(dp);
                System.out.println("Dang cho");
                String st = new String(dp.getData()).trim();
//              String st = dp.getData().toString();
                String tn = st + " Nhan tu may:" + dp.getAddress().getHostName();
                dg.close();
                  return tn;
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        
    }
    
    public void Gui(String tn,String IpName, int port){
        try {
            DatagramSocket dg = new DatagramSocket();//Tạo ra 1 DatagramSocket để gửi
            byte bodem[] = new byte[256]; //Tạo ra bộ đệm chứa dữ liệu cần gửi
            String st = tn;//Dữ liệu cần gửi
            bodem = st.getBytes(); //Chuyển chuỗi thành dãy các byte
            InetAddress ip = InetAddress.getByName(IpName);//Lấy thông tin của máy cần gửi
            DatagramPacket dr = new DatagramPacket(bodem, bodem.length, ip, port);
            dg.send(dr);//Gửi dữ liệu đi
            System.out.print("Da gửi");
        } catch (Exception tt) {
            System.out.print(tt);
        }
    }
}
