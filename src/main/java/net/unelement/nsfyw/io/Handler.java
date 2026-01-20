package net.unelement.nsfyw.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Handler implements Runnable {

    private final ServerSocket serverSocket;
    private Socket socket;

    private InputStream inputStream;
    private OutputStream outputStream;

    public Handler(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
        socket = null;
        inputStream = null;
        outputStream = null;
    }

    @Override
    public void run() {
        try {
            while (!serverSocket.isClosed()) {
                socket = serverSocket.accept();

                inputStream = socket.getInputStream();
                outputStream = socket.getOutputStream();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }
}
