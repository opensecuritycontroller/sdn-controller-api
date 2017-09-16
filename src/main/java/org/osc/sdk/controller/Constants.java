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
package org.osc.sdk.controller;

/**
 * This class lists the constants referenced in the APIs and configurations defined in this SDK.
 */
public class Constants {
    /**
     * The name of the OSGi property containing the name of the plugin.
     * <p>
     * The value for this property must match the value in the Deployment-Name attribute of the plugin .bar file.
     */
    public static final String PLUGIN_NAME = "osc.plugin.name";

    /**
     * The name of the OSGi property that indicates whether the SDN Controller supports traffic redirection to a VNF running on a remote hypervisor.
     */
    public static final String SUPPORT_OFFBOX_REDIRECTION = "osc.plugin.sdn.support_offbox_redirection";

    /**
     * The name of the OSGi property that indicates whether the SDN Controller supports traffic redirection to multiple VNFs (service function chaining).
     */
    public static final String SUPPORT_SFC = "osc.plugin.sdn.support_service_function_chaining";

    /**
     * The name of the OSGi property that indicates whether the SDN Controller supports Openstack Neutron service function chaining.
     */
    public static final String SUPPORT_NEUTRON_SFC = "osc.plugin.sdn.support_neutron_sfc";

    /**
     * The name of the OSGi property that indicates whether the SDN Controller supports inspection port failure detection and can bypass traffic inspection.
     */
    public static final String SUPPORT_FAILURE_POLICY = "osc.plugin.sdn.support_failure_policy";

    /**
     * The name of the OSGi property that indicates whether the SDN Controller uses the virtualization provider credentials.
     */
    public static final String USE_PROVIDER_CREDS = "osc.plugin.sdn.use_provider_creds";

    /**
     * The name of the OSGi property that indicates whether the SDN Controller supports providing port information given the traffic information.
     */
    public static final String QUERY_PORT_INFO = "osc.plugin.sdn.query_port_info";

    /**
     * The name of the OSGi property that indicates whether the SDN Controller supports grouping of virtual ports for traffic redirection.
     */
    public static final String SUPPORT_PORT_GROUP = "osc.plugin.sdn.support_port_group";
}
