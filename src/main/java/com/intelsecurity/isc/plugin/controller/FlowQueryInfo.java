package com.intelsecurity.isc.plugin.controller;

import java.util.Date;

public class FlowQueryInfo {
    public String sourceIpAddress;
    public String destinationIpAddress;
    public int sourcePort;
    public int destinationPort;
    public int protocolId;
    public Date flowTimestamp;
    public String sourceMacAddress;
    public String destinationMacAddress;

    public String sourcePortId;
    public String destinationPortId;
}
