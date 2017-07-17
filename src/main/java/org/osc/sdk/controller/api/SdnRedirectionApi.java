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
package org.osc.sdk.controller.api;

import java.util.List;

import org.osc.sdk.controller.FailurePolicyType;
import org.osc.sdk.controller.TagEncapsulationType;
import org.osc.sdk.controller.element.InspectionHookElement;
import org.osc.sdk.controller.element.InspectionPortElement;
import org.osc.sdk.controller.element.NetworkElement;
import org.osc.sdk.controller.exception.NetworkPortNotFoundException;
import org.osgi.annotation.versioning.ConsumerType;

/**
 * This interface represents API's required to implement traffic redirection
 */
@ConsumerType
public interface SdnRedirectionApi extends AutoCloseable {

    /**
     * Creates a network element with a list of child elements on SDN controller
     *
     * @param elements  provides the list of network element
     * @return the NetworkElement
     * @throws Exception upon failure
     */
    NetworkElement registerNetworkElement(List<NetworkElement> elements) throws Exception;

    /**
     * Updates parent element with a list of child elements on SDN controller
     *
     * @param element  provides the network element to be updated
     * @param childElements provides list of childElements
     * @return the NetworkElement
     * @throws Exception upon failure
     */
    NetworkElement updateNetworkElement(NetworkElement element, List<NetworkElement> childElements) throws Exception;

    /**
     * <p>
     * Deletes a network element previously created on SDN controller.
     * No-op if no network element is found on SDN controller to be deleted.
     * </p>
     *
     * @param element  provides the network element to be deleted
     * @throws Exception upon failure
     */
    void deleteNetworkElement(NetworkElement element) throws Exception;

    /**
     * Retrieve the list of the child elements corresponding to the parent element from SDN controller
     *
     * @param element  provides the network element
     * @return the list of NetworkElement, null if not found
     * @throws Exception upon failure
     */
    List<NetworkElement> getNetworkElements(NetworkElement element) throws Exception;

    /**
     * Creates an inspection hook on SDN controller, see {@link InspectionHookElement}
     *
     * @param networkElem  provides network element containing protected ports
     * @param inspectionPort  provides inspection port belonging to network inspection devices
     * @param tag  provides a tag made available to inspection port data path
     * @param encType  provides the tag encapsulation type
     * @param order  provides an order in which to insert the inspection hook
     * @param failurePolicyType  provides the failure policy type
     * @return the identifier of the inspection hook
     * @throws NetworkPortNotFoundException when port is not found
     * @throws Exception upon failure
     */
    String installInspectionHook(NetworkElement networkElem, InspectionPortElement inspectionPort, Long tag,
            TagEncapsulationType encType, Long order, FailurePolicyType failurePolicyType)
                    throws NetworkPortNotFoundException, Exception;

    /**
     * <p>
     * Removes previously created inspection hook from SDN controller, see {@link InspectionHookElement}.
     * No-op if no inspection hook is found on SDN controller to be deleted.
     * </p>
     *
     * @param networkElem  provides the network element containing protected ports
     * @param inspectionPort  provides inspection port to be deleted
     * @throws Exception upon failure
     */
    void removeInspectionHook(NetworkElement networkElem, InspectionPortElement inspectionPort) throws Exception;

    /**
     * <p>
     * Removes previously created inspection hook specific to the inspection hook identifier from SDN controller, see {@link InspectionHookElement}.
     * No-op if no inspection hook is found on SDN controller to be deleted.
     * </p>
     *
     * @param inspectionHookId  the identifier of the inspection hook to be deleted
     * @throws Exception upon failure
     */
    void removeInspectionHook(String inspectionHookId) throws Exception;

    /**
     * Retrieves an inspection hook element from SDN controller, see {@link InspectionHookElement}
     *
     * @param inspectionHookId  the identifier of the inspection hook
     * @return the inspection hook element, null if not found
     * @throws Exception upon failure
     */
    InspectionHookElement getInspectionHook(String inspectionHookId) throws Exception;

    /**
     * <p>
     * Removes all previously created inspection hooks related to the provided network element from SDN controller, see {@link InspectionHookElement}.
     * No-op if no inspection hooks are found on SDN controller to be deleted.
     * </p>
     *
     * @param networkElem  provides network element containing protected ports
     * @throws Exception upon failure
     */
    void removeAllInspectionHooks(NetworkElement networkElem) throws Exception;

    /**
     * Sets policy tag for a specific inspection hook on SDN controller
     *
     * @param inspectedPort  provides port on which behalf traffic is being inspected
     * @param inspectionPort  provides inspection port belonging to network inspection device
     * @param tag  provides a tag
     * @throws NetworkPortNotFoundException when port is not found
     * @throws Exception upon failure
     */
    void setInspectionHookTag(NetworkElement inspectedPort, InspectionPortElement inspectionPort, Long tag)
            throws NetworkPortNotFoundException, Exception;

    /**
     * Retrieves the policy tag of an installed inspection hook from SDN controller
     *
     * @param inspectedPort  provides port on which behalf traffic is being inspected
     * @param inspectionPort  provides inspection port belonging to network inspection device
     * @return the inspection hook tag, null if not found
     * @throws NetworkPortNotFoundException when port is not found
     * @throws Exception upon failure
     */
    Long getInspectionHookTag(NetworkElement inspectedPort, InspectionPortElement inspectionPort)
            throws NetworkPortNotFoundException, Exception;

    /**
     * Sets the failure policy of an inspection hook on SDN controller
     *
     * @param inspectedPort  provides port on which behalf traffic is being inspected
     * @param inspectionPort  provides inspection port belonging to network inspection device
     * @param failurePolicyType provides the failure policy type
     * @throws NetworkPortNotFoundException when port is not found
     * @throws Exception upon failure
     */
    void setInspectionHookFailurePolicy(NetworkElement inspectedPort, InspectionPortElement inspectionPort,
            FailurePolicyType failurePolicyType) throws NetworkPortNotFoundException, Exception;

    /**
     * Retrieves the failure policy type of an installed inspection hook from SDN controller
     *
     * @param inspectedPort  provides port on which behalf traffic is being inspected
     * @param inspectionPort  provides inspection port belonging to network inspection device
     * @return the failure policy type, null if not found
     * @throws NetworkPortNotFoundException when port is not found
     * @throws Exception upon failure
     */
    FailurePolicyType getInspectionHookFailurePolicy(NetworkElement inspectedPort, InspectionPortElement inspectionPort)
            throws NetworkPortNotFoundException, Exception;

    /**
     * Retrieves the list of inspection ports previously created from SDN controller
     *
     * @param inspectedPort  provides port on which behalf traffic is being inspected
     * @return the list of network port element, null if not found
     * @throws Exception upon failure
     */
    //    public abstract List<NetworkPortElement> getInspectionPorts(NetworkPortElement inspectedPort) throws Exception;

    /**
     * Retrieves the list of inspected ports previously protected from SDN controller
     *
     * @param inspectionPort  provides inspection port belonging to network inspection device
     * @return the list of network port element, null if not found
     * @throws Exception upon failure
     */
    //    public abstract List<NetworkPortElement> getInspectedPorts(NetworkPortElement inspectionPort) throws Exception;

    /**
     * Retrieves an inspection hook element previously created from SDN controller
     *
     * @param inspectedPort  provides port on which behalf traffic is being inspected
     * @param inspectionPort  provides inspection port belonging to network inspection device
     * @return the inspection hook element, null if not found
     * @throws NetworkPortNotFoundException when port is not found
     * @throws Exception upon failure
     */
    InspectionHookElement getInspectionHook(NetworkElement inspectedPort, InspectionPortElement inspectionPort)
            throws NetworkPortNotFoundException, Exception;

    /**
     * Updates an inspection hook on SDN controller
     *
     * @param existingInspectionHook  provides inspection hook to be updated
     * @throws NetworkPortNotFoundException when port is not found
     * @throws Exception upon failure
     */
    void updateInspectionHook(InspectionHookElement existingInspectionHook)
            throws NetworkPortNotFoundException, Exception;

    /**
     * <p>
     * Creates an inspection port on SDN controller.
     * The call to register the same port multiple times will result in no-op.
     * </p>
     *
     * @param inspectionPort  provides the inspection port to be created
     * @throws NetworkPortNotFoundException when port is not found
     * @throws Exception upon failure
     */
    void registerInspectionPort(InspectionPortElement inspectionPort) throws NetworkPortNotFoundException, Exception;

    /**
     * <p>
     * Deletes an inspection port previously created on SDN controller.
     * No-op if no inspection port is found on SDN controller to be deleted.
     * </p>
     *
     * @param inspectionPort  provides the inspection port to be deleted
     * @throws NetworkPortNotFoundException when port is not found
     * @throws Exception upon failure
     */
    void removeInspectionPort(InspectionPortElement inspectionPort) throws NetworkPortNotFoundException, Exception;

    /**
     * Retrieves an inspection port element previously created from SDN controller
     *
     * @param inspectionPort  provides the inspection port element to be retrieved
     * @return the inspection port element, null if not found
     * @throws NetworkPortNotFoundException when port is not found
     * @throws Exception upon failure
     */
    InspectionPortElement getInspectionPort(InspectionPortElement inspectionPort)
            throws NetworkPortNotFoundException, Exception;

    /**
     * Sets an inspection hook order on SDN controller
     *
     * @param inspectedPort  provides port on which behalf traffic is being inspected
     * @param inspectionPort  provides inspection port belonging to network inspection device
     * @param order provides the order in which to insert the inspection hook
     * @throws NetworkPortNotFoundException when port is not found
     * @throws Exception upon failure
     */
    void setInspectionHookOrder(NetworkElement inspectedPort, InspectionPortElement inspectionPort, Long order)
            throws NetworkPortNotFoundException, Exception;

    /**
     * Retrieves an inspection hook order from SDN controller
     *
     * @param inspectedPort  provides port on which behalf traffic is being inspected
     * @param inspectionPort  provides inspection port belonging to network inspection device
     * @return the inspection hook order in which to insert the inspection hook, null if not found
     * @throws NetworkPortNotFoundException when port is not found
     * @throws Exception upon failure
     */
    Long getInspectionHookOrder(NetworkElement inspectedPort, InspectionPortElement inspectionPort)
            throws NetworkPortNotFoundException, Exception;

}
