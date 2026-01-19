package net.unelement.nsfyw.service.emptybox;

import net.unelement.nsfyw.service.hosting.AHost;

public class BoxFactory extends ABox{

    private BoxFactory() { }

    public static BoxFactory create(
            String name, AHost hosting, String webSiteName,
            String webSiteUrl, String maintainerName,
            String maintainerEmail, String entryPoint
    ){
        BoxFactory f = new BoxFactory();

        f.name = name;
        f.hosting = hosting;
        f.webSiteName = webSiteName;
        f.webSiteUrl = webSiteUrl;
        f.maintainerName = maintainerName;
        f.maintainerEmail = maintainerEmail;
        f.entryPoint = entryPoint;

        return f;
    }
}
