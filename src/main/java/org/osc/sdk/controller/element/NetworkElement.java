package org.osc.sdk.controller.element;

import java.util.List;

import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface NetworkElement {
    String getElementId();

    List<String> getMacAddresses();

    List<String> getPortIPs();
    
    String getParentId();

}
