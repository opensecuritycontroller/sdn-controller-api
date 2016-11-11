package org.osc.sdk.controller;

import java.util.ArrayList;
import java.util.List;

import org.osc.sdk.controller.element.NetworkElement;

public class DefaultNetworkPort implements NetworkElement {

    private String portId;
    private List<String> macAddresses = new ArrayList<String>();
    private List<String> portIPs = new ArrayList<String>();

    public DefaultNetworkPort() {
    }

    public DefaultNetworkPort(NetworkElement port) {
        this.portId = port.getElementId();
        this.macAddresses = port.getMacAddresses();
        this.portIPs = port.getPortIPs();
    }

    public DefaultNetworkPort(String portId, String macAddress) {
        this.portId = portId;
        this.macAddresses.add(macAddress);
    }

    @Override
    public String getElementId() {
        return this.portId;
    }

    @Override
    public List<String> getMacAddresses() {
        return this.macAddresses;
    }

    @Override
    public String toString() {
        return "DefaultNetworkPort [portId=" + this.portId + ", macAddresses=" + this.macAddresses  + "]";
    }

    @Override
    public List<String> getPortIPs() {
        return this.portIPs;
    }

    public void setElementId(String portId) {
        this.portId = portId;
    }

}
