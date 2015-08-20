package com.intelsecurity.isc.plugin.controller.element;

import java.util.List;

public interface NetworkPortElement {
    public String getPortId();

    public String getMacAddress();

    public List<String> getPortIPs();

}
