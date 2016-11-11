package org.osc.sdk.controller;

import org.osc.sdk.controller.element.InspectionPortElement;
import org.osc.sdk.controller.element.NetworkElement;

public class DefaultInspectionPort implements InspectionPortElement {

    private NetworkElement ingressPort;
    private NetworkElement egressPort;

    public DefaultInspectionPort() {
    }

    public DefaultInspectionPort(NetworkElement ingressPort, NetworkElement egressPort) {
        this.ingressPort = ingressPort;
        this.egressPort = egressPort;
    }

    @Override
    public NetworkElement getIngressPort() {
        return this.ingressPort;
    }

    @Override
    public NetworkElement getEgressPort() {
        return this.egressPort;
    }

    @Override
    public String toString() {
        return "DefaultInspectionPort [ingressPort=" + this.ingressPort + ", egressPort=" + this.egressPort + "]";
    }

}
