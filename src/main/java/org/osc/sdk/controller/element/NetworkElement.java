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
package org.osc.sdk.controller.element;

import java.util.List;

import org.osgi.annotation.versioning.ConsumerType;

/**
 * This interface represents a network element.
 * Network Element is a port on which behalf traffic is being inspected or a element containing protected ports.
 */
@ConsumerType
public interface NetworkElement {
	/**
	 * @return the identifier of network element
	 */
    String getElementId();

	/**
	 * @return the list of MAC addresses
	 */
    List<String> getMacAddresses();

	/**
	 * @return the list of port IPs
	 */
    List<String> getPortIPs();

	/**
	 * @return the identifier of network element's parent
	 */
    String getParentId();

}
