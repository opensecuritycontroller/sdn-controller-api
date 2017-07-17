/*******************************************************************************
 * Copyright (c) Intel Corporation
 * Copyright (c) 2017
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.osc.sdk.controller.element;

import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This interface represents a virtualization connector element.
 */
@ProviderType
public interface VirtualizationConnectorElement {

    /**
     * @return the name of virtualization connector
     */
    String getName();

    /**
     * @return the IP address of controller
     */
    String getControllerIpAddress();

    /**
     * @return the user name of controller
     */
    String getControllerUsername();

    /**
     * @return the password of controller
     */
    String getControllerPassword();

    /**
     * @return true if controller is HTTPS, false otherwise
     */
    boolean isControllerHttps();

    /**
     * @return the IP address pf provider
     */
    String getProviderIpAddress();

    /**
     * @return the user name of provider
     */
    String getProviderUsername();

    /**
     * @return the password of provider
     */
    String getProviderPassword();

    /**
     * @return the name of provider admin tenant
     */
    String getProviderAdminTenantName();

    /**
     * @return the identifier of provider admin domain
     */
    String getProviderAdminDomainId();

    /**
     * @return true if provider is HTTPS, false otherwise
     */
    boolean isProviderHttps();

    /**
     * @return the map of provider additional attributes
     */
    Map<String, String> getProviderAttributes();

    /**
     * @return the SSLContext of the application (OSC) hosting the plugin
     */
    SSLContext getSslContext();

    /**
     * @return the Truststore manager of the application (OSC) hosting the plugin
     * @throws Exception upon failure
     */
    TrustManager[] getTruststoreManager() throws Exception;
}
