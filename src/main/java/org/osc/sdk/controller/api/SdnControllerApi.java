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
package org.osc.sdk.controller.api;

import java.util.HashMap;

import org.osc.sdk.controller.Constants;
import org.osc.sdk.controller.FlowInfo;
import org.osc.sdk.controller.FlowPortInfo;
import org.osc.sdk.controller.Status;
import org.osc.sdk.controller.element.VirtualizationConnectorElement;
import org.osgi.annotation.versioning.ConsumerType;

/**
 * This interface represents the main entry point for all the interactions with the SDN controller.
 * It provides a way for OSC to instantiate the other SDN controller APIs and basic information like
 * the status of the SDN controller and its URL.
 * <p>
 * Classes implementing this interface must be published through the OSGi service registry and must
 * contain the following REQUIRED properties:
 * <ul>
 * <li> {@link Constants#PLUGIN_NAME}
 * <li> {@link Constants#SUPPORT_OFFBOX_REDIRECTION}
 * <li> {@link Constants#SUPPORT_SFC}
 * <li> {@link Constants#SUPPORT_FAILURE_POLICY}
 * <li> {@link Constants#USE_PROVIDER_CREDS}
 * <li> {@link Constants#QUERY_PORT_INFO}
 * <li> {@link Constants#SUPPORT_PORT_GROUP}
 * </ul>
 */
@ConsumerType
public interface SdnControllerApi extends AutoCloseable {

    /**
     * @param vc  provides context information of the virtualization connector
     * @param region  provides information about region to operate on
     * @return the status of SDN controller
     * @throws Exception upon failure
     */
    Status getStatus(VirtualizationConnectorElement vc, String region) throws Exception;

    /**
     * @param vc  provides context information of the virtualization connector
     * @param region  provides information about region to operate on
     * @return the APIs used by OSC to manage traffic redirection
     */
    SdnRedirectionApi createRedirectionApi(VirtualizationConnectorElement vc, String region);

    /**
     * @param vc  provides context information of the virtualization connector
     * @param region  provides region info to operate on
     * @param portsQuery  provides the context information of the flowInfo mapped by the identifier
     * @return an object of FlowPortInfo mapped by the same identifiers provided in the input query
     * @throws Exception upon failure
     */
    HashMap<String, FlowPortInfo> queryPortInfo(VirtualizationConnectorElement vc, String region,
            HashMap<String, FlowInfo> portsQuery) throws Exception;

}
