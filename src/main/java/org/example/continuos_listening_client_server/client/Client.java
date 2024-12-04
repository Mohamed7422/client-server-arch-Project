package org.example.continuos_listening_client_server.client;

import java.io.*;
import java.net.Socket;

public class Client {


    public static void main(String[] args) {
        try(Socket guest = new Socket("localhost",8080);){

            DataInputStream input = new DataInputStream(guest.getInputStream());
            DataOutputStream output = new DataOutputStream(guest.getOutputStream());

            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System
                    .in));

            String message;
            while (true){
                message = consoleReader.readLine();
                output.writeUTF(message);
                if (message.equalsIgnoreCase("exit")) {
                    guest.close();
                    break;
                }

                String response = input.readUTF();
                System.out.println("Server : "+ response);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
