package org.osc.sdk.controller.api;

import java.util.HashMap;
import java.util.List;

import org.osc.sdk.controller.FailurePolicyType;
import org.osc.sdk.controller.FlowInfo;
import org.osc.sdk.controller.FlowPortInfo;
import org.osc.sdk.controller.Status;
import org.osc.sdk.controller.TagEncapsulationType;
import org.osc.sdk.controller.element.InspectionHookElement;
import org.osc.sdk.controller.element.InspectionPortElement;
import org.osc.sdk.controller.element.NetworkElement;
import org.osc.sdk.controller.element.VirtualizationConnectorElement;
import org.osc.sdk.controller.exception.NetworkPortNotFoundException;

/**
 *
 */
public interface SdnControllerApi extends AutoCloseable {

    /**
     * Create NetworkElement with a list of child elements
     * For example, create PortGroup with ports of protected workloads
     * @param elements
     *          ports of protected workloads or any network element
     * @return the created NetworkElement like PortGroup
     * @throws Exception
     */
    NetworkElement registerNetworkElement(List<NetworkElement> elements) throws Exception;

    /**
     * Update parent element with child_elements.
     * For example update PortGroup's protected workloads ports. Send the entire child_elements for update
     * @param element
     *          update this portGroup
     * @param child_elements
     *          list of child elements
     * @throws Exception
     */
    void updateNetworkElement(NetworkElement element, List<NetworkElement> childElements) throws Exception;

    /**
     * Delete NetworkElement created with registerNetworkElement like PortGroup
     * @param element
     *          Element to be deleted
     * @throws Exception
     */
    void deleteNetworkElement(NetworkElement element) throws Exception;

    /**
     * Get the children elements of the network element
     * For example get the protected workload ports of the PortGroup
     * @param element
     * @return
     * @throws Exception
     */
    List<NetworkElement> getNetworkElements(NetworkElement element) throws Exception;

    /**
     * Install network hooks to inspect traffic of given network port by another network port
     * which is part of an inspection network device.
     *
     * @param inspectedPort
     *            The port on which behalf traffic is being inspected.
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
    void installInspectionHook(NetworkElement inspectedPort, InspectionPortElement inspectionPort, Long tag,
            TagEncapsulationType encType, Long order, FailurePolicyType failurePolicyType)
                    throws NetworkPortNotFoundException, Exception;

    /**
     * Remove previously installed network hooks placed on behalf of network port.
     *
     * @param inspectedPort
     *            The port on which behalf traffic is being inspected.
     * @param inspectionPort
     *            The inspection port belonging to network inspection device.
     */
    void removeInspectionHook(NetworkElement inspectedPort, InspectionPortElement inspectionPort) throws Exception;

    /**
     * Remove previously installed network hooks placed on behalf of network port.
     *
     * @param inspectedPort
     *            The port on which behalf traffic is being inspected.
     * @param inspectionPort
     *            The inspection port belonging to network inspection device.
     */
    void removeAllInspectionHooks(NetworkElement inspectedPort) throws Exception;

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
    FailurePolicyType getInspectionHookFailurePolicy(NetworkElement inspectedPort,
            InspectionPortElement inspectionPort) throws NetworkPortNotFoundException, Exception;

    /**
     * Return list of inspected port on which behalf inspection hooks are installed.
     *
     * @param inspectionPort
     *            The inspection network device port
     * @return List of ports being inspected by the provided inspection port.
     */
    //    public abstract List<NetworkPortElement> getInspectedPorts(NetworkPortElement inspectionPort) throws Exception;

    /**
     * Return the inspection ports providing inspection for a given port
     *
     * @param inspectedPort
     *            The inspected port for which the inspection port is queried
     * @return List of inspection ports providing inspection service.
     * @throws Exception
     */
    //    public abstract List<NetworkPortElement> getInspectionPorts(NetworkPortElement inspectedPort) throws Exception;

    InspectionHookElement getInspectionHook(NetworkElement inspectedPort, InspectionPortElement inspectionPort)
            throws NetworkPortNotFoundException, Exception;

    void updateInspectionHook(InspectionHookElement inspectionHook) throws NetworkPortNotFoundException, Exception;

    void updateInspectionHook(NetworkElement inspectedPort, InspectionPortElement inspectionPort, Long tag,
            TagEncapsulationType encType, Long order, FailurePolicyType failurePolicyType)
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
    String registerInspectionPort(InspectionPortElement inspectionPort) throws NetworkPortNotFoundException, Exception;

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

    /**
     * SDN Controller name. This name will show up on ISC controller drop down when adding VC
     *
     * @return SDN Controller name
     */
    String getName();

    /**
     * SDN Controller version informational string
     *
     * @return SDN Controller version
     */
    String getVersion();

    /**
     *
     * Method returns Status object which will provide the following information
     *
     * name: SDNController's Name
     * version: SDNController's version
     * controllerReady: This boolean flag if true represents that SDN controller is ready to serve
     *
     * @return
     */
    Status getStatus() throws Exception;


    /**
     * Set Virtualization Connector context through which authentication information can be obtained
     *
     * @param vc
     *            Virtualization Connector Element
     */
    void setVirtualizationConnector(VirtualizationConnectorElement vc);

    /**
     * Set the region to operate on
     *
     * @param region
     *            region to operate on
     */
    void setRegion(String region);

    /**
     * Check if SDN Controller supports traffic redirection to a VNF running on a remote hypervisor
     *
     * @return true if SDN controller capable of redirection to VNF running on another host
     */
    boolean isOffboxRedirectionSupported();

    /**
     * Check if SDN Controller supports traffic redirection to multiple VNFs (service function chaining)
     *
     * @return true if SDN controller capable of redirection to multiple VNFs set up in a chain
     */
    boolean isServiceFunctionChainingSupported();

    /**
     * Check if SDN Controller supports inspection port failure detection and can bypass traffic inspection
     *
     * @return true if SDN controller capable of supporting failure policy
     */
    boolean isFailurePolicySupported();

    boolean isUsingProviderCreds();

    boolean isSupportQueryPortInfo();


    /**
     * Query port information based on 5 tuple flow info + timestamp.
     * Return the same structure with source port and/or destination neuron port filled in or null if not found.
     *
     * @param portsQuery
     *            Array of flow query info
     * @return Original input array with source and/or destination ports filled if found. Null if not found.
     * @throws Exception
     *             if case of invalid input or service issues (connectivity, etc)
     */
    HashMap<String, FlowPortInfo> queryPortInfo(HashMap<String, FlowInfo> portsQuery) throws Exception;

}
