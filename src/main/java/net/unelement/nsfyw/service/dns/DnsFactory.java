package net.unelement.nsfyw.service.dns;

public class DnsFactory extends ADNS {

    private DnsFactory() { }

    public static DnsFactory create(String name, String address,
            int port, int limitResources, double speedLimitPerUser) {
        DnsFactory f = new DnsFactory();

        f.name = name;
        f.address = address;
        f.port = port;
        f.limitResources = limitResources;
        f.speedLimitPerUser = speedLimitPerUser;

        return f;
    }
}
