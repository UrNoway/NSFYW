package net.unelement.nsfyw.io;

public enum Message {
    Sending("sending", 1000),
    Getting("getting", 2000),
    OK("ok", 222);

    private final String name;
    private final int protocolValue;

    Message(String name, int protocolValue) {
        this.name = name;
        this.protocolValue = protocolValue;
    }

    public String getName() {
        return name;
    }
    public int getProtocolValue() {
        return protocolValue;
    }

    @Override
    public String toString() {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    public static Message valueOf(int protocolValue) {
        for (Message message : Message.values()) {
            if (message.protocolValue == protocolValue) {
                return message;
            }
        }
        return null;
    }
}
