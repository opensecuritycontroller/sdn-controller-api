package com.intelsecurity.isc.plugin.controller.exception;

@SuppressWarnings("serial")
public class NetworkPortNotFoundException extends Exception {

    private String portId;

    public NetworkPortNotFoundException(String portId, String message) {
        super(message);
        this.portId = portId;
    }

    public String getPortId() {
        return this.portId;
    }
}
