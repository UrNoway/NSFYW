package net.unelement.nsfyw.service.hosting;

import net.unelement.nsfyw.service.dns.ADNS;

import java.util.Arrays;

public class HostingFactory extends AHost {

    private HostingFactory() { }

    public static HostingFactory create(String name, String uniqueFolderName) {
        HostingFactory f = new HostingFactory();

        f.name = name;
        f.uniqueFolderName = uniqueFolderName;

        return f;
    }
}
