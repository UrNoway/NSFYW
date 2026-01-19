package net.unelement.nsfyw.service.dns;

public abstract class ADNS implements IDNS{

    protected String name;
    protected String address;
    protected int port;
    protected int limitResources;
    protected double speedLimitPerUser;

    public ADNS() {
        this.name = "No name declared";
        this.address = "0.0.0.0";
        this.port = 9020;
        this.limitResources = -1;
        this.speedLimitPerUser = -1d;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public int getPort() {
        return port;
    }

    @Override
    public int getLimitResources() {
        return limitResources;
    }

    @Override
    public double getSpeedLimitPerUser() {
        return speedLimitPerUser;
    }
}
