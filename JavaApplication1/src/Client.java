import java.net.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class Client {

    public static void main(String[] args) {
        try {
            DatagramSocket dg = new DatagramSocket();//Tạo ra 1 DatagramSocket để gửi
            byte bodem[] = new byte[256]; //Tạo ra bộ đệm chứa dữ liệu cần gửi
            String st = "bloa";//Dữ liệu cần gửi
            bodem = st.getBytes(); //Chuyển chuỗi thành dãy các byte
            InetAddress ip = InetAddress.getByName("127.0.0.1");//Lấy thông tin của máy cần gửi
            DatagramPacket dr = new DatagramPacket(bodem, bodem.length, ip, 1260);
            dg.send(dr);//Gửi dữ liệu đi
            System.out.print("Da gửi");
        } catch (Exception tt) {
            System.out.print(tt);
        }
    }
}

