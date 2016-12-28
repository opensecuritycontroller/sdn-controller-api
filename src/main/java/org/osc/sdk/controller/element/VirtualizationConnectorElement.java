package org.osc.sdk.controller.element;

import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface VirtualizationConnectorElement {

    String getName();

    String getControllerIpAddress();

    String getControllerUsername();

    String getControllerPassword();

    boolean isControllerHttps();

    String getProviderIpAddress();

    String getProviderUsername();

    String getProviderPassword();

    String getProviderAdminTenantName();

    boolean isProviderHttps();

    Map<String, String> getProviderAttributes();
}
