package org.example.simple_client_server.client;
import java.io.*;
import java.net.*;

public class Client {


    public static void main(String[] args) {
        try(Socket guest = new Socket("localhost",8080);){

        PrintWriter pr = new PrintWriter(guest.getOutputStream());
        pr.println("Hiiii From ClientSide");
        pr.flush();

        InputStreamReader streamReader = new InputStreamReader(guest.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(streamReader);
            String responseFromServer = bufferedReader.readLine();
            System.out.println("Resp "+ responseFromServer);
        }catch (IOException e){

        }
    }

}
