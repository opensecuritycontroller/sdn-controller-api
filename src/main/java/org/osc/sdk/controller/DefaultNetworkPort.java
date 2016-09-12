package org.osc.sdk.controller;

import java.util.ArrayList;
import java.util.List;

import org.osc.sdk.controller.element.NetworkPortElement;

public class DefaultNetworkPort implements NetworkPortElement {

    private String portId;
    private String macAddress;
    private List<String> portIPs = new ArrayList<String>();

    public DefaultNetworkPort() {
    }

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

    @Override
    public String toString() {
        return "DefaultNetworkPort [portId=" + this.portId + ", macAddress=" + this.macAddress + "]";
    }

    @Override
    public List<String> getPortIPs() {
        return this.portIPs;
    }

    public void setPortId(String portId) {
        this.portId = portId;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

}
