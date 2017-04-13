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

import org.osc.sdk.controller.FlowInfo;
import org.osc.sdk.controller.FlowPortInfo;
import org.osc.sdk.controller.Status;
import org.osc.sdk.controller.element.VirtualizationConnectorElement;
import org.osgi.annotation.versioning.ConsumerType;

/**
 *
 */
@ConsumerType
public interface SdnControllerApi extends AutoCloseable {

    /**
     *
     * Method returns Status object which will provide the following information
     *
     * name: SDNController's Name
     * version: SDNController's version
     * controllerReady: This boolean flag if true represents that SDN controller is ready to serve
     *
     * @return
     */
    Status getStatus(VirtualizationConnectorElement vc, String region) throws Exception;

    /**
     * Create redirection api with Virtualization Connector context through which authentication information can be
     * obtained
     * and the region to operate on
     *
     * @param vc
     *            Virtualization Connector Element
     * @param region
     *            region to operate on
     */
    SdnRedirectionApi createRedirectionApi(VirtualizationConnectorElement vc, String region);

    /**
     * Query port information based on 5 tuple flow info + timestamp.
     * Return the same structure with source port and/or destination neuron port filled in or null if not found.
     *
     * @param portsQuery
     *            Array of flow query info
     * @return Original input array with source and/or destination ports filled if found. Null if not found.
     * @throws Exception
     *             if case of invalid input or service issues (connectivity, etc)
     */
    HashMap<String, FlowPortInfo> queryPortInfo(VirtualizationConnectorElement vc, String region,
            HashMap<String, FlowInfo> portsQuery) throws Exception;

}
