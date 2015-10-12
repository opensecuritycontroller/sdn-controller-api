package com.intelsecurity.isc.plugin.controller.element;

public interface VirtualizationConnectorElement {

    /**
     * Return Virtualization Connector name
     * @return
     */
    String getName();

    String getControllerIpAddress();

    String getControllerUsername();

    String getControllerPassword();

    String getAdminTenantName();

    boolean isHttps();

}
