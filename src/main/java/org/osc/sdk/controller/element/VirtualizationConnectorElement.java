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

    String getProviderAdminDomainId();

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
