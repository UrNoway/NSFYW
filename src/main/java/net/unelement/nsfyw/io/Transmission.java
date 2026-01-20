package net.unelement.nsfyw.io;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class Transmission {

    private Transmission() { }

    public static void send(byte[] data, Handler handler) throws IOException {
        // For response
        int code;

        ObjectOutputStream out = new ObjectOutputStream(handler.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(handler.getInputStream());

        // Inform distant that we are about to send something
        out.writeInt(Message.Sending.getProtocolValue());

        // We're waiting for a getting response from the distant
        code = in.readInt();

        // We're quiting if code is incorrect
        if(code != Message.Getting.getProtocolValue()) {
            return;
        }

        // Let's write an object.
        out.writeBytes(new String(data, StandardCharsets.UTF_8));

        // We're waiting for a ok response from the distant
        code = in.readInt();

        // We're quiting with error if code is incorrect
        if(code != Message.OK.getProtocolValue()) {
            throw new RuntimeException("failed to send transmission");
        }
    }

    public static byte[] receive(Handler handler) throws IOException {
        // For response
        int code;

        ObjectOutputStream out = new ObjectOutputStream(handler.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(handler.getInputStream());

        // We're waiting for a sending code from distant (client)
        code = in.readInt();

        if(code != Message.Sending.getProtocolValue()) {
            throw new RuntimeException("failed to get transmission");
        }

        // Send the getting code
        out.writeInt(Message.Getting.getProtocolValue());

        // Let's read the distant (client) object
        try{
            byte[] data = in.readUTF().getBytes(StandardCharsets.UTF_8);

            // If Ok send ok to the distant (client)
            out.writeInt(Message.OK.getProtocolValue());

            return data;
        }catch(IOException _){
            // Else send a wrong code to the distant (client)
            out.writeInt(0);

            return null;
        }
    }
}
