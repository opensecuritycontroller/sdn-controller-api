package org.osc.sdk.controller;

public class FlowInfo {

    public String sourceIpAddress;
    public String sourceMacAddress;
    public int sourcePort;
    public String destinationIpAddress;
    public String destinationMacAddress;
    public int destinationPort;
    public int protocolId;
    public long flowTimestamp;

    @Override
    public String toString() {
        return "FlowInfo [sourceIpAddress=" + this.sourceIpAddress + ", sourceMacAddress=" + this.sourceMacAddress
                + ", sourcePort=" + this.sourcePort + ", destinationIpAddress=" + this.destinationIpAddress
                + ", destinationMacAddress=" + this.destinationMacAddress + ", destinationPort=" + this.destinationPort
                + ", protocolId=" + this.protocolId + ", flowTimestamp=" + this.flowTimestamp + "]";
    }
}
