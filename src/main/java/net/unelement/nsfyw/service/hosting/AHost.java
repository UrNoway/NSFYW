package net.unelement.nsfyw.service.hosting;

import net.unelement.nsfyw.service.dns.ADNS;

import java.util.ArrayList;
import java.util.List;

public abstract class AHost implements IHost{

    protected String name;
    protected String uniqueFolderName;
    protected final List<ADNS> replicas;

    public AHost() {
        name = "No name known";
        uniqueFolderName = "No unique folder name";
        replicas = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getUniqueFolderName() {
        return uniqueFolderName;
    }

    @Override
    public List<ADNS> getReplicas() {
        return replicas;
    }
}
