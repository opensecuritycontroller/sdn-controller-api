package org.osc.sdk.controller.element;

import org.osgi.annotation.versioning.ConsumerType;

/*
 * Contains Inspection port information. If the ingress and egress ports are the same, then the same port will need to
 * be returned for either of the methods.
 */
@ConsumerType
public interface InspectionPortElement {

    NetworkElement getIngressPort();

    NetworkElement getEgressPort();
}
