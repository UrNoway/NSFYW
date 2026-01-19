package net.unelement.nsfyw.service.hosting;

import net.unelement.nsfyw.service.dns.ADNS;

import java.util.List;

public interface IHost {
    String getName();
    String getUniqueFolderName();
    List<ADNS> getReplicas();
}
