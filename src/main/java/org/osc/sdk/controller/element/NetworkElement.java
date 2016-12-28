package org.osc.sdk.controller.element;

import java.util.List;

import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface NetworkElement {
    public String getElementId();

    public List<String> getMacAddresses();

    public List<String> getPortIPs();

}
