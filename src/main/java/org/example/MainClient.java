package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MainClient {
    public static void main(String[] args) throws IOException {
        String host = "netology.homework";
        int port = 8080;
        String name = "Bob";
        String kid = "no";

        try (Socket clientSocket = new Socket(host, port); PrintWriter out = new PrintWriter(clientSocket.
                getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            System.out.println(in.readLine());
            out.println(name);
            System.out.println(name);
            System.out.println(in.readLine());
            out.println(kid);
            System.out.println(kid);
            System.out.println(in.readLine());
            System.out.println("closing...");
        }
    }
}