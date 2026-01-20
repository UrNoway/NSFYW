package net.unelement.nsfyw.service.dns;

import net.unelement.nsfyw.io.Handler;
import net.unelement.nsfyw.io.Server;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DnsDialogue implements Runnable{

    private volatile Thread thread;

    private final ADNS dns;
    private final Server server;

    private Handler handler;

    public DnsDialogue(ADNS dns) {
        this.dns = dns;
        thread = new Thread(this);
        thread.start();
        server = Server.start(dns.getPort());
        handler = null;
    }

    public ADNS getDns() {
        return dns;
    }

    public Server getServer() {
        return server;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public void close(){
        if(handler != null && thread != null && thread.isAlive()){
            thread.interrupt();
        }
    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){

            }
        }catch(Exception e){
            Logger.getGlobal().log(Level.WARNING, "DnsDialogue.run()", e);
        }
    }
}
