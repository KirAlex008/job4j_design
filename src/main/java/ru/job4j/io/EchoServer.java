package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.logging.UsageLog4j;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        boolean workState = true;
        try (ServerSocket server = new ServerSocket(9000)) {
            while (workState) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    while (!(str = in.readLine()).isEmpty()) {
                        if (str.contains("Exit")) {
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            out.write("Server closed".getBytes());
                            System.out.println("Server closed");
                            server.close();
                            workState = false;
                        }
                        if (str.contains("Hello")) {
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            out.write("Hello, dear friend.".getBytes());
                            workState = true;
                        } else {
                            if (str.contains("HTTP") && !(str.contains("Hello") || str.contains("Exit"))) {
                                out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                                out.write(str.substring(10, str.indexOf("HTTP")).getBytes());
                                System.out.println(str);
                                workState = true;
                            }
                        }
                    }
                }
                if (workState == false) {
                    break;
                }
            }
        } catch (Exception e) {
            LOG.error("Exception in log example", e);
        }
    }
}