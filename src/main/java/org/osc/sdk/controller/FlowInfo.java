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

public class FlowInfo {

    public String sourceIpAddress;
    public String sourceMacAddress;
    public int sourcePort;
    public String destinationIpAddress;
    public String destinationMacAddress;
    public int destinationPort;
    public int protocolId;
    public long flowTimestamp;

    @Override
    public String toString() {
        return "FlowInfo [sourceIpAddress=" + this.sourceIpAddress + ", sourceMacAddress=" + this.sourceMacAddress
                + ", sourcePort=" + this.sourcePort + ", destinationIpAddress=" + this.destinationIpAddress
                + ", destinationMacAddress=" + this.destinationMacAddress + ", destinationPort=" + this.destinationPort
                + ", protocolId=" + this.protocolId + ", flowTimestamp=" + this.flowTimestamp + "]";
    }
}
