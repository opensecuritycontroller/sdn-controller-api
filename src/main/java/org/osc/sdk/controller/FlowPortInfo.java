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
 * This class represents a flow information with source and destination port identifier.
 */
public class FlowPortInfo {

    /**
     * Flow info to be used to query six tuple information
     */
    private FlowInfo flow;

    /**
     * Port identifier of the source
     */
    private String sourcePortId;

    /**
     * Port identifier of the destination
     */
    private String destinationPortId;

    FlowPortInfo() {

    }

    public FlowPortInfo(FlowInfo flow, String sourcePortId, String destinationPortId) {
        super();
        this.flow = flow;
        this.sourcePortId = sourcePortId;
        this.destinationPortId = destinationPortId;
    }

    public FlowInfo getFlow() {
        return this.flow;
    }

    public String getSourcePortId() {
        return this.sourcePortId;
    }

    public String getDestinationPortId() {
        return this.destinationPortId;
    }

    @Override
    public String toString() {
        return "FlowPortInfo [flow=" + this.flow + ", sourcePortId=" + this.sourcePortId + ", destinationPortId="
                + this.destinationPortId + "]";
    }
}
