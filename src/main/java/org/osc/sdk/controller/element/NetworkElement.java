package org.osc.sdk.controller.element;

import java.util.List;

public interface NetworkElement {
    public String getElementId();

    public List<String> getMacAddresses();

    public List<String> getPortIPs();

}
