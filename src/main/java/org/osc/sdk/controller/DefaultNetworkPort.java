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

import java.util.ArrayList;
import java.util.List;

import org.osc.sdk.controller.element.NetworkElement;


/**
 * This class represents a default network port with network element implementation
 */
public class DefaultNetworkPort implements NetworkElement {

    private String portId;
    private List<String> macAddresses = new ArrayList<>();
    private List<String> portIPs = new ArrayList<>();
    private String parentId;

    public DefaultNetworkPort() {
    }

    public DefaultNetworkPort(NetworkElement port) {
        this.portId = port.getElementId();
        this.macAddresses = port.getMacAddresses();
        this.portIPs = port.getPortIPs();
        this.parentId = port.getParentId();
    }

    public DefaultNetworkPort(String portId, String macAddress) {
        this.portId = portId;
        this.macAddresses.add(macAddress);
    }

    @Override
    public String getElementId() {
        return this.portId;
    }

    @Override
    public List<String> getMacAddresses() {
        return this.macAddresses;
    }

    @Override
    public String toString() {
        return "DefaultNetworkPort [portId=" + this.portId + ", macAddresses=" + this.macAddresses + ", parentId="
                + this.parentId  + "]";
    }

    @Override
    public List<String> getPortIPs() {
        return this.portIPs;
    }

    public void setElementId(String portId) {
        this.portId = portId;
    }

    @Override
    public String getParentId() {
        return this.parentId;
    }

    public void setParentId(String parentId){
        this.parentId = parentId;
    }

}
