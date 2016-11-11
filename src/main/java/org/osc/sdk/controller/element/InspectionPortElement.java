package org.osc.sdk.controller.element;

/*
 * Contains Inspection port information. If the ingress and egress ports are the same, then the same port will need to
 * be returned for either of the methods.
 */
public interface InspectionPortElement {

    NetworkElement getIngressPort();

    NetworkElement getEgressPort();
}
