package net.unelement.nsfyw.io;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

    private Thread serverThread;
    private ServerSocket serverSocket;
    private Handler handler;

    private Server() {
        serverThread = null;
        serverSocket = null;
        handler = null;
    }

    public static Server start(int port) {
        Server s = new Server();

        try{
            s.serverSocket = new ServerSocket(port);
            s.handler = new Handler(s.serverSocket);
            s.serverThread = new Thread(s.handler);
            s.serverThread.start();
        }catch(IOException e){
            Logger.getGlobal().log(
                    Level.WARNING,
                    "Failed to start server on port " + port,
                    e
            );
        }

        return s;
    }

    public void stop(){
        if(serverThread != null && serverThread.isAlive()){
            serverThread.interrupt();
        }
    }

    /**
     * Return a useful handler.
     * @return handler that contains method for communication.
     */
    public Handler getHandler() {
        return handler;
    }
}
