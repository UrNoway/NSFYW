package net.unelement.nsfyw.service;

public enum Service {
    DNS("dns"), EmptyBox("box"), Hosting("host");

    private final String name;

    Service(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Service fromName(String name) {
        for (Service service : Service.values()) {
            if (service.name.equals(name)) {
                return service;
            }
        }
        return null;
    }
}
