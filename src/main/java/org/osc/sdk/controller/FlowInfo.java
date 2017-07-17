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
 * This class represents a flow info to be used to query six tuple information
 */
public class FlowInfo {

	/**
	 * IP address of the source
	 */
    public String sourceIpAddress;

	/**
	 * MAC address of the source
	 */
    public String sourceMacAddress;

	/**
	 * Port information of the source
	 */
    public int sourcePort;

	/**
	 * IP address of the destination
	 */
    public String destinationIpAddress;

	/**
	 * MAC address of the source
	 */
    public String destinationMacAddress;

	/**
	 * Port information of the source
	 */
    public int destinationPort;

	/**
	 * Protocol identifier
	 */
    public int protocolId;

	/**
	 * Timestamp of a flow
	 */
    public long flowTimestamp;

    @Override
    public String toString() {
        return "FlowInfo [sourceIpAddress=" + this.sourceIpAddress + ", sourceMacAddress=" + this.sourceMacAddress
                + ", sourcePort=" + this.sourcePort + ", destinationIpAddress=" + this.destinationIpAddress
                + ", destinationMacAddress=" + this.destinationMacAddress + ", destinationPort=" + this.destinationPort
                + ", protocolId=" + this.protocolId + ", flowTimestamp=" + this.flowTimestamp + "]";
    }
}
