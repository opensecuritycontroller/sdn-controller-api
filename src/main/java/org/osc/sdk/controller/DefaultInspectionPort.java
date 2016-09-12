package org.osc.sdk.controller;

import org.osc.sdk.controller.element.InspectionPortElement;
import org.osc.sdk.controller.element.NetworkPortElement;

public class DefaultInspectionPort implements InspectionPortElement {

    private NetworkPortElement ingressPort;
    private NetworkPortElement egressPort;

    public DefaultInspectionPort() {
    }

    public DefaultInspectionPort(NetworkPortElement ingressPort, NetworkPortElement egressPort) {
        this.ingressPort = ingressPort;
        this.egressPort = egressPort;
    }

    @Override
    public NetworkPortElement getIngressPort() {
        return this.ingressPort;
    }

    @Override
    public NetworkPortElement getEgressPort() {
        return this.egressPort;
    }

    @Override
    public String toString() {
        return "DefaultInspectionPort [ingressPort=" + this.ingressPort + ", egressPort=" + this.egressPort + "]";
    }

}
