package com.intelsecurity.isc.plugin.controller;

import java.util.Date;

public class FlowInfo {

    public String sourceIpAddress;
    public String sourceMacAddress;
    public int sourcePort;
    public String destinationIpAddress;
    public String destinationMacAddress;
    public int destinationPort;
    public int protocolId;
    public Date flowTimestamp;

    @Override
    public String toString() {
        return "FlowInfo [sourceIpAddress=" + sourceIpAddress + ", sourceMacAddress=" + sourceMacAddress
                + ", sourcePort=" + sourcePort + ", destinationIpAddress=" + destinationIpAddress
                + ", destinationMacAddress=" + destinationMacAddress + ", destinationPort=" + destinationPort
                + ", protocolId=" + protocolId + ", flowTimestamp=" + flowTimestamp + "]";
    }
}
