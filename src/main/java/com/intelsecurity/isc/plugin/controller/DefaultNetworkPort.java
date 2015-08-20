package com.intelsecurity.isc.plugin.controller;

import java.util.ArrayList;
import java.util.List;

import com.intelsecurity.isc.plugin.controller.element.NetworkPortElement;

public class DefaultNetworkPort implements NetworkPortElement {

    private String portId;
    private String macAddress;
    private List<String> portIPs = new ArrayList<String>();

    public DefaultNetworkPort(NetworkPortElement port) {
        this.portId = port.getPortId();
        this.macAddress = port.getMacAddress();
        this.portIPs = port.getPortIPs();
    }

    public DefaultNetworkPort(String portId, String macAddress) {
        this.portId = portId;
        this.macAddress = macAddress;
    }

    @Override
    public String getPortId() {
        return this.portId;
    }

    @Override
    public String getMacAddress() {
        return this.macAddress;
    }

    public void setPortIPs(List<String> portIPs) {
        this.portIPs = portIPs;
    }

    @Override
    public String toString() {
        return "DefaultNetworkPort [portId=" + this.portId + ", macAddress=" + this.macAddress + "]";
    }

    @Override
    public List<String> getPortIPs() {
        return this.portIPs;
    }

}
