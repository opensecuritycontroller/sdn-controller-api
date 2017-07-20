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

import org.osc.sdk.controller.FailurePolicyType;
import org.osc.sdk.controller.TagEncapsulationType;
import org.osgi.annotation.versioning.ConsumerType;

/**
 * This interface represents a redirection rule placed on the SDN controller to redirect traffic
 * from the Inspected port to the Inspection port.
 */
@ConsumerType
public interface InspectionHookElement {
    /**
     * @return the identifier of the inspection hook
     */
    String getHookId();

    /**
     * @return the tag
     */
    Long getTag();

    /**
     * @return the order
     */
    Long getOrder();

    /**
     * @return the tag Encapsulation type
     */
    TagEncapsulationType getEncType();

    /**
     * @return the failure policy type
     */
    FailurePolicyType getFailurePolicyType();

    /**
     * @return the network element
     */
    NetworkElement getInspectedPort();

    /**
     * @return the inspection port element
     */
    InspectionPortElement getInspectionPort();
}
