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
    private String sourceIpAddress;

    /**
     * MAC address of the source
     */
    private String sourceMacAddress;

    /**
     * Port information of the source
     */
    private int sourcePort;

    /**
     * IP address of the destination
     */
    private String destinationIpAddress;

    /**
     * MAC address of the source
     */
    private String destinationMacAddress;

    /**
     * Port information of the source
     */
    private int destinationPort;

    /**
     * Protocol identifier
     */
    private int protocolId;

    /**
     * Timestamp of a flow
     */
    private long flowTimestamp;

    FlowInfo() {

    }

    public FlowInfo(String sourceIpAddress, String sourceMacAddress, int sourcePort, String destinationIpAddress,
            String destinationMacAddress, int destinationPort, int protocolId, long flowTimestamp) {
        this.sourceIpAddress = sourceIpAddress;
        this.sourceMacAddress = sourceMacAddress;
        this.sourcePort = sourcePort;
        this.destinationIpAddress = destinationIpAddress;
        this.destinationMacAddress = destinationMacAddress;
        this.destinationPort = destinationPort;
        this.protocolId = protocolId;
        this.flowTimestamp = flowTimestamp;
    }

    public String getSourceIpAddress() {
        return this.sourceIpAddress;
    }

    public String getSourceMacAddress() {
        return this.sourceMacAddress;
    }

    public int getSourcePort() {
        return this.sourcePort;
    }

    public String getDestinationIpAddress() {
        return this.destinationIpAddress;
    }

    public String getDestinationMacAddress() {
        return this.destinationMacAddress;
    }

    public int getDestinationPort() {
        return this.destinationPort;
    }

    public int getProtocolId() {
        return this.protocolId;
    }

    public long getFlowTimestamp() {
        return this.flowTimestamp;
    }

    @Override
    public String toString() {
        return "FlowInfo [sourceIpAddress=" + this.sourceIpAddress + ", sourceMacAddress=" + this.sourceMacAddress
                + ", sourcePort=" + this.sourcePort + ", destinationIpAddress=" + this.destinationIpAddress
                + ", destinationMacAddress=" + this.destinationMacAddress + ", destinationPort=" + this.destinationPort
                + ", protocolId=" + this.protocolId + ", flowTimestamp=" + this.flowTimestamp + "]";
    }
}
