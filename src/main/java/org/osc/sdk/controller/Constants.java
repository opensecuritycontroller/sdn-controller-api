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

public class Constants {
    /**
     * Indicates whether the SDN Controller supports traffic redirection to a VNF running on a remote hypervisor.
     */
    public static final String SUPPORT_OFFBOX_REDIRECTION = "osc.plugin.sdn.support_offbox_redirection";

    /**
     * Indicates whether the SDN Controller supports traffic redirection to multiple VNFs (service function chaining).
     */
    public static final String SUPPORT_SFC = "osc.plugin.sdn.support_service_function_chaining";

    /**
     * Indicates whether the SDN Controller supports inspection port failure detection and can bypass traffic inspection.
     */
    public static final String SUPPORT_FAILURE_POLICY = "osc.plugin.sdn.support_failure_policy";

    /**
     * Indicates whether the SDN Controller uses the virtualization provider credentials.
     */
    public static final String USE_PROVIDER_CREDS = "osc.plugin.sdn.use_provider_creds";

    /**
     * Indicates whether the SDN Controller supports providing port information given the traffic information.
     */
    public static final String QUERY_PORT_INFO = "osc.plugin.sdn.query_port_info";

    /**
     * Indicates whether the SDN Controller supports grouping of virtual ports for traffic redirection.
     */
    public static final String SUPPORT_PORT_GROUP = "osc.plugin.sdn.support_port_group";

    /**
     * The name of the plugin.
     */
    public static final String PLUGIN_NAME = "osc.plugin.name";
}
