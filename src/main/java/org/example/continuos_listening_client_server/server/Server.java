package org.example.continuos_listening_client_server.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args)  {

        

       try( ServerSocket serverSocket = new ServerSocket(8080);){
             Socket handleTheGuest = serverSocket.accept();
           System.out.println("New client connected");
           

           DataInputStream input = new DataInputStream(handleTheGuest.getInputStream());
           DataOutputStream output = new DataOutputStream(handleTheGuest.getOutputStream());

           BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
           //handle communication
           String messageFromClient,messageResponse;
           while (true){
               messageFromClient = input.readUTF();
               System.out.println("Received from Client : "+messageFromClient);

               if (messageFromClient.equalsIgnoreCase("exit")){
                   serverSocket.close();
                   break;
               }
               messageResponse = consoleReader.readLine();

               output.writeUTF("Server Recieved ur requeset "+messageResponse);


           }





       }catch (IOException e){
           e.printStackTrace();

       }

    }


}
