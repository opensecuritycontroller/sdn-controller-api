package org.osc.sdk.controller;

public class Status {

    private String name;
    private String version;
    private boolean controllerReady;

    public String getName() {
        return this.name;
    }

    public Status(String name, String version, boolean canServe) {
        super();
        this.name = name;
        this.version = version;
        this.controllerReady = canServe;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public boolean isControllerReady() {
        return this.controllerReady;
    }

    public void setControllerReady(boolean canServe) {
        this.controllerReady = canServe;
    }

    @Override
    public String toString() {
        return "Status [name=" + this.name + ", version=" + this.version + ", controllerReady=" + this.controllerReady + "]";
    }

}
