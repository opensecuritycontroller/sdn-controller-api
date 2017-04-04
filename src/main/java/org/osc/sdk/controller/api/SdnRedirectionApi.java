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
 * API's required to implement redirection
 */
@ConsumerType
public interface SdnRedirectionApi extends AutoCloseable {

    /**
     * Create NetworkElement with a list of child elements
     * For example, create NetworkElement with ports of protected workloads
     * @param elements
     *          ports of protected workloads or any network element
     * @return the created NetworkElement
     * @throws Exception
     */
    NetworkElement registerNetworkElement(List<NetworkElement> elements) throws Exception;

    /**
     * Update parent element with child_elements.
     * For example update NetworkElement's protected workloads ports. Send the entire child_elements for update
     * @param element
     *          update this networkElement
     * @param child_elements
     *          list of child elements
     * @return the updated or recreated NetworkElement
     * @throws Exception
     */
    NetworkElement updateNetworkElement(NetworkElement element, List<NetworkElement> childElements) throws Exception;

    /**
     * Delete NetworkElement created with registerNetworkElement
     * @param element
     *          Element to be deleted
     * @throws Exception
     */
    void deleteNetworkElement(NetworkElement element) throws Exception;

    /**
     * Get the children elements of the network element
     * For example get the protected workload ports of the Port Group
     * @param element
     * @return
     * @throws Exception
     */
    List<NetworkElement> getNetworkElements(NetworkElement element) throws Exception;

    /**
     * Install network hooks to inspect traffic of given network port by another network port
     * which is part of an inspection network device.
     *
     * @param networkElem
     *            The port on which behalf traffic is being inspected or a networkElement containing protected ports
     * @param inspectionPort
     *            The inspection port belonging to network inspection devices.
     * @param tag
     *            A tag made available to inspection port data path. Usually represent the policy by
     *            which traffic should be inspected.
     * @param encType
     *            Data path Encapsulation Method to use to extract tag and direction from packet
     *
     * @param order
     *            The order in which to insert the inspection hook. If other inspection hooks are already in place, all
     *            existing hooks will be push down from the point of insertion. The order range is zero based where -1
     *            symbolizes to append as last
     */
    String installInspectionHook(NetworkElement networkElem, InspectionPortElement inspectionPort, Long tag,
            TagEncapsulationType encType, Long order, FailurePolicyType failurePolicyType)
                    throws NetworkPortNotFoundException, Exception;

    /**
     * Remove previously installed network hooks placed on behalf of network port.
     *
     * @param networkElem
     *            The port on which behalf traffic is being inspected or a networkElement containing protected ports
     * @param inspectionPort
     *            The inspection port belonging to network inspection device.
     */
    void removeInspectionHook(NetworkElement networkElem, InspectionPortElement inspectionPort) throws Exception;

    /**
     * Remove the previously installed inspection hook given its identifier.
     *
     * @param inspectionHookId
     *            The identifier of the inspection hook to be removed.
     */
    void removeInspectionHook(String inspectionHookId) throws Exception;

    /**
     * Retrieves a previously installed inspection hook given its identifier.
     *
     * @param inspectionHookId
     *            The identifier of the inspection hook to be retrieved.
     */
    InspectionHookElement getInspectionHook(String inspectionHookId) throws Exception;

    /**
     * Remove previously installed network hooks placed on behalf of network port.
     *
     * @param networkElem
     *            The port on which behalf traffic is being inspected or a networkElement containing protected ports
     */
    void removeAllInspectionHooks(NetworkElement networkElem) throws Exception;

    /**
     * Set data path policy tag of a specific inspection hook.
     *
     * @param inspectedPort
     *            The port on which behalf traffic is being inspected.
     * @param inspectionPort
     *            The inspection port belonging to network inspection device.
     * @param tag
     *            The tag value to set
     */
    void setInspectionHookTag(NetworkElement inspectedPort, InspectionPortElement inspectionPort, Long tag)
            throws NetworkPortNotFoundException, Exception;

    /**
     * Return the current tag used for an installed inspection hook.
     *
     * @param inspectedPort
     *            The port on which behalf traffic is being inspected.
     * @param inspectionPort
     *            The inspection port belonging to network inspection device.
     * @return The current inspection tag
     */
    Long getInspectionHookTag(NetworkElement inspectedPort, InspectionPortElement inspectionPort)
            throws NetworkPortNotFoundException, Exception;

    /**
     * Set the failure policy of an inspection hook.
     *
     * @param inspectedPort
     *            The port on which behalf traffic is being inspected.
     * @param inspectionPort
     *            The inspection port belonging to network inspection device.
     * @param failurePolicyType
     *            The failure policy type
     *
     * @throws Exception
     */
    void setInspectionHookFailurePolicy(NetworkElement inspectedPort, InspectionPortElement inspectionPort,
            FailurePolicyType failurePolicyType) throws NetworkPortNotFoundException, Exception;

    /**
     * Return the current failure policy used for an installed inspection hook.
     *
     * @param inspectedPort
     *            The port on which behalf traffic is being inspected.
     * @param inspectionPort
     *            The inspection port belonging to network inspection device.
     * @return The current failure policy
     */
    FailurePolicyType getInspectionHookFailurePolicy(NetworkElement inspectedPort, InspectionPortElement inspectionPort)
            throws NetworkPortNotFoundException, Exception;

    /**
     * Return the inspection ports providing inspection for a given port
     *
     * @param inspectedPort
     *            The inspected port for which the inspection port is queried
     * @return List of inspection ports providing inspection service.
     * @throws Exception
     */
    //    public abstract List<NetworkPortElement> getInspectionPorts(NetworkPortElement inspectedPort) throws Exception;

    /**
     * Return list of inspected port on which behalf inspection hooks are installed.
     *
     * @param inspectionPort
     *            The inspection network device port
     * @return List of ports being inspected by the provided inspection port.
     */
    //    public abstract List<NetworkPortElement> getInspectedPorts(NetworkPortElement inspectionPort) throws Exception;

    InspectionHookElement getInspectionHook(NetworkElement inspectedPort, InspectionPortElement inspectionPort)
            throws NetworkPortNotFoundException, Exception;

    void updateInspectionHook(InspectionHookElement existingInspectionHook)
            throws NetworkPortNotFoundException, Exception;

    /**
     * On board a port as inspection interface. This call is assumed to be idempotent. i.e calls to register the same
     * port multiple times will result in no-op.
     *
     * @param inspectionPort
     *            Inspection port to on board
     * @return return the target element's id of which the inspectionPort is part of. Else if not part of any
     *              target element, returns an empty string
     * @throws NetworkPortNotFoundException
     * @throws Exception
     */
    void registerInspectionPort(InspectionPortElement inspectionPort) throws NetworkPortNotFoundException, Exception;

    /**
     * Remove previously on boarded network ports as inspection interfaces.
     *
     * @param inspectionPort
     *            Inspection port which was on boarded
     */
    void removeInspectionPort(InspectionPortElement inspectionPort) throws NetworkPortNotFoundException, Exception;

    /**
     * Get inspection port information
     *
     * @param inspectionPort
     *            Inspection port
     */
    InspectionPortElement getInspectionPort(InspectionPortElement inspectionPort)
            throws NetworkPortNotFoundException, Exception;

    void setInspectionHookOrder(NetworkElement inspectedPort, InspectionPortElement inspectionPort, Long order)
            throws NetworkPortNotFoundException, Exception;

    Long getInspectionHookOrder(NetworkElement inspectedPort, InspectionPortElement inspectionPort)
            throws NetworkPortNotFoundException, Exception;

}
