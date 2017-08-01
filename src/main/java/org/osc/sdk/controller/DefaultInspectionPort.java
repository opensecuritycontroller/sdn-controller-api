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

import org.osc.sdk.controller.element.Element;
import org.osc.sdk.controller.element.InspectionPortElement;
import org.osc.sdk.controller.element.NetworkElement;

/**
 * This class represents a default inspection port with inspection port element implementation
 */
public class DefaultInspectionPort implements InspectionPortElement {

    private NetworkElement ingressPort;
    private NetworkElement egressPort;
	private Element element;

    public DefaultInspectionPort() {
    }

    public DefaultInspectionPort(NetworkElement ingressPort, NetworkElement egressPort, Element element) {
        this.ingressPort = ingressPort;
        this.egressPort = egressPort;
        this.element = element;
    }

    @Override
    public NetworkElement getIngressPort() {
        return this.ingressPort;
    }

    @Override
    public NetworkElement getEgressPort() {
        return this.egressPort;
    }

	@Override
	public String getElementId() {
		return this.element.getElementId();
	}

	@Override
	public String getParentId() {
		return this.element.getParentId();
	}

    @Override
    public String toString() {
        return "DefaultInspectionPort [ingressPort=" + this.ingressPort + ", egressPort=" + this.egressPort + "]";
    }

}
