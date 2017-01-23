package org.osc.sdk.controller.element;

import org.osgi.annotation.versioning.ProviderType;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import java.util.Map;

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

    /**
     * Provides the SSL context of the client application (OSC) hosting the plugin
     * @return
     *          The SSLContext of the application (OSC) hosting the plugin
     */
    SSLContext getSslContext();

    /**
     * Provides the Truststore manager array of the client application (OSC) hosting the plugin
     * @return
     *          The Truststore manager of the application (OSC) hosting the plugin
     */
    TrustManager[] getTruststoreManager() throws Exception;
}
