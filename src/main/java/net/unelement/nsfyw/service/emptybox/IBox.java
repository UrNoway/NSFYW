package net.unelement.nsfyw.service.emptybox;

import net.unelement.nsfyw.service.hosting.AHost;

public interface IBox {
    String getName();
    AHost getHosting();
    String getWebSiteName();
    String getWebSiteUrl();
    String getMaintainerName();
    String getMaintainerEmail();
    String getEntryPoint();
}
