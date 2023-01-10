package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        // порт можете выбрать любой в доступном диапазоне 0-65536. Но чтобы не нарваться на уже занятый -
        // рекомендуем использовать около 8080
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Wait connection on " + serverSocket);
        try {
            Socket clientSocket = serverSocket.accept(); // ждем подключения
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("New connection accepted");
            out.println("Write your name");
            String name = in.readLine();
            System.out.println("Client name: " + name);
            out.println(name + " are you child? (yes/no)");
            String adult = in.readLine();
            if (adult.equals("yes")) {
                System.out.println(name + " is kid.");
                out.println("Welcome to the kids area, " + name + "! Let's play!");
            } else if (adult.equals("no")) {
                System.out.println(name + " is adult.");
                out.println("Welcome to the adult zone, " + name + "! Have a good rest, or a good working day!");
            } else {
                out.println("I don't no your kid or adult, good bye!");
            }
            clientSocket.close();
        } finally {
            System.out.println("closing...");
            serverSocket.close();
        }
    }
}