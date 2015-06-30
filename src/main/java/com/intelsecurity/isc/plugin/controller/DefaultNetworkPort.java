package com.intelsecurity.isc.plugin.controller;

import com.intelsecurity.isc.plugin.controller.element.NetworkPortElement;

public class DefaultNetworkPort implements NetworkPortElement {

    private String portId;
    private String macAddress;

    public DefaultNetworkPort(NetworkPortElement port) {
        this.portId = port.getPortId();
        this.macAddress = port.getMacAddress();
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

}
