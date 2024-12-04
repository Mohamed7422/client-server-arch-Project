package org.example.simple_client_server.server;
import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args)  {

       try( ServerSocket serverSocket = new ServerSocket(8080);){
             Socket handleTheGuest = serverSocket.accept();
           System.out.println("Client Connected");

           InputStreamReader streamReader = new InputStreamReader(handleTheGuest.getInputStream());
           BufferedReader bufferedInputStream = new BufferedReader(streamReader);
           String requestFromClient = bufferedInputStream.readLine();
           System.out.println("MSG : "+requestFromClient);

           PrintWriter pr = new PrintWriter(handleTheGuest.getOutputStream());
           pr.println("Welcome My Friend");
           pr.flush();

       }catch (IOException e){


       }

    }


}
