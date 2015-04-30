package com.intelsecurity.isc.plugin.controller.element;

public interface VirtualizationConnectorElement {

    /**
     * Return Virtualization Connector name
     * @return
     */
    public String getName();

    public String getControllerIpAddress();

    public String getControllerUsername();

    public String getControllerPassword();

}
