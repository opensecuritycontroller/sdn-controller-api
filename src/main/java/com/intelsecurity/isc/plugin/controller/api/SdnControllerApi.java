package com.intelsecurity.isc.plugin.controller.api;

import com.intelsecurity.isc.plugin.controller.FailurePolicyType;
import com.intelsecurity.isc.plugin.controller.Status;
import com.intelsecurity.isc.plugin.controller.TagEncapsulationType;
import com.intelsecurity.isc.plugin.controller.element.InspectionHookElement;
import com.intelsecurity.isc.plugin.controller.element.InspectionPortElement;
import com.intelsecurity.isc.plugin.controller.element.NetworkPortElement;
import com.intelsecurity.isc.plugin.controller.element.VirtualizationConnectorElement;
import com.intelsecurity.isc.plugin.controller.exception.NetworkPortNotFoundException;

/**
 *
 */
public interface SdnControllerApi extends AutoCloseable {

    /**
     * Install network hooks to inspect traffic of given network port by another network port
     * which is part of an inspection network device.
     *
     * @param inspectedPort
     *            The port on which behalf traffic is being inspected.
     * @param inspectionPort
     *            The inspection port belonging to network inspection device.
     * @param tag
     *            A tag made available to inspection port datapath. Usually represent the policy by
     *            which traffic should be inspected.
     * @param encType
     *            Data path Encapsulation Method to use to extract tag and direction from packet
     *
     * @param order
     *            The order in which to insert the inspection hook. If other inspection hooks are already in place, all
     *            existing hooks will be push down from the point of insertion. The order range is zero based where -1
     *            symbolizes to append as last
     */
    void installInspectionHook(NetworkPortElement inspectedPort, NetworkPortElement inspectionPort, Long tag,
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
    void removeInspectionHook(NetworkPortElement inspectedPort, NetworkPortElement inspectionPort) throws Exception;

    /**
     * Remove previously installed network hooks placed on behalf of network port.
     *
     * @param inspectedPort
     *            The port on which behalf traffic is being inspected.
     * @param inspectionPort
     *            The inspection port belonging to network inspection device.
     */
    void removeAllInspectionHooks(NetworkPortElement inspectedPort) throws Exception;

    /**
     * Set datapath policy tag of a specific inspection hook.
     *
     * @param inspectedPort
     *            The port on which behalf traffic is being inspected.
     * @param inspectionPort
     *            The inspection port belonging to network inspection device.
     * @param tag
     *            The tag value to set
     */
    void setInspectionHookTag(NetworkPortElement inspectedPort, NetworkPortElement inspectionPort, Long tag)
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
    Long getInspectionHookTag(NetworkPortElement inspectedPort, NetworkPortElement inspectionPort)
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
    void setInspectionHookFailurePolicy(NetworkPortElement inspectedPort, NetworkPortElement inspectionPort,
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
    FailurePolicyType getInspectionHookFailurePolicy(NetworkPortElement inspectedPort,
            NetworkPortElement inspectionPort) throws NetworkPortNotFoundException, Exception;

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

    InspectionHookElement getInspectionHook(NetworkPortElement inspectedPort, NetworkPortElement inspectionPort)
            throws NetworkPortNotFoundException, Exception;

    void updateInspectionHook(InspectionHookElement inspectionHook) throws NetworkPortNotFoundException, Exception;

    void updateInspectionHook(NetworkPortElement inspectedPort, NetworkPortElement inspectionPort, Long tag,
            TagEncapsulationType encType, Long order, FailurePolicyType failurePolicyType)
                    throws NetworkPortNotFoundException, Exception;

    /**
     * On board a port as inspection interface
     *
     * @param inspectionPort
     *            Inspection port to on board
     */
    void registerInspectionPort(NetworkPortElement inspectionPort) throws NetworkPortNotFoundException, Exception;

    /**
     * Get inspection port information
     *
     * @param inspectionPort
     *            Inspection port
     */
    InspectionPortElement getInspectionPort(NetworkPortElement inspectionPort)
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

    boolean isUsingProviderCreds();

    void setInspectionHookOrder(NetworkPortElement inspectedPort, NetworkPortElement inspectionPort, Long order)
            throws NetworkPortNotFoundException, Exception;

    Long getInspectionHookOrder(NetworkPortElement inspectedPort, NetworkPortElement inspectionPort)
            throws NetworkPortNotFoundException, Exception;
}
