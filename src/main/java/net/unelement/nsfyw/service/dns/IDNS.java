package net.unelement.nsfyw.service.dns;

public interface IDNS {
    String getName();
    String getAddress();
    int getPort();
    int getLimitResources();
    double getSpeedLimitPerUser();
}
