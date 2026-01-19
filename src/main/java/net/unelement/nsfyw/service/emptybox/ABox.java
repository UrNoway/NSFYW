package net.unelement.nsfyw.service.emptybox;

import net.unelement.nsfyw.service.hosting.AHost;

public abstract class ABox implements IBox{

    protected String name;
    protected AHost hosting;
    protected String webSiteName;
    protected String webSiteUrl;
    protected String maintainerName;
    protected String maintainerEmail;
    protected String entryPoint;

    public ABox() {
        this.name = "Default";
        this.hosting = null;
        this.webSiteName = null;
        this.webSiteUrl = null;
        this.maintainerName = null;
        this.maintainerEmail = null;
        this.entryPoint = null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public AHost getHosting() {
        return hosting;
    }

    @Override
    public String getWebSiteName() {
        return webSiteName;
    }

    @Override
    public String getWebSiteUrl() {
        return webSiteUrl;
    }

    @Override
    public String getMaintainerName() {
        return maintainerName;
    }

    @Override
    public String getMaintainerEmail() {
        return maintainerEmail;
    }

    @Override
    public String getEntryPoint() {
        return entryPoint;
    }
}
