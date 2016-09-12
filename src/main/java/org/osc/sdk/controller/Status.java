package org.osc.sdk.controller;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "status")
@XmlAccessorType(XmlAccessType.FIELD)
public class Status {

    private String name;
    private String version;
    private boolean controllerReady;

    public String getName() {
        return name;
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
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public boolean isControllerReady() {
        return controllerReady;
    }

    public void setControllerReady(boolean canServe) {
        this.controllerReady = canServe;
    }

    @Override
    public String toString() {
        return "Status [name=" + name + ", version=" + version + ", controllerReady=" + controllerReady + "]";
    }

}
