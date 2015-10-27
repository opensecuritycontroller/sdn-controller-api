package com.intelsecurity.isc.plugin.controller;

public class FlowPortInfo {
    public FlowInfo flow;

    public String sourcePortId;
    public String destinationPortId;

    @Override
    public String toString() {
        return "FlowPortInfo [flow=" + flow + ", sourcePortId=" + sourcePortId + ", destinationPortId="
                + destinationPortId + "]";
    }
}
