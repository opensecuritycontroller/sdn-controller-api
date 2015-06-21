package com.intelsecurity.isc.plugin.controller.api;

import com.intelsecurity.isc.plugin.controller.FailurePolicyType;
import com.intelsecurity.isc.plugin.controller.TagEncapsulationType;
import com.intelsecurity.isc.plugin.controller.element.InspectionHookElement;
import com.intelsecurity.isc.plugin.controller.element.NetworkPortElement;
import com.intelsecurity.isc.plugin.controller.element.VirtualizationConnectorElement;

public interface SdnControllerApi {

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
    public abstract void installInspectionHook(NetworkPortElement inspectedPort, NetworkPortElement inspectionPort,
            Long tag, TagEncapsulationType encType, Long order, FailurePolicyType failurePolicyType) throws Exception;

    /**
     * Remove previously installed network hooks placed on behalf of network port.
     *
     * @param inspectedPort
     *            The port on which behalf traffic is being inspected.
     * @param inspectionPort
     *            The inspection port belonging to network inspection device.
     */
    public abstract void removeInspectionHook(NetworkPortElement inspectedPort, NetworkPortElement inspectionPort)
            throws Exception;

    /**
     * Remove previously installed network hooks placed on behalf of network port.
     *
     * @param inspectedPort
     *            The port on which behalf traffic is being inspected.
     * @param inspectionPort
     *            The inspection port belonging to network inspection device.
     */
    public abstract void removeAllInspectionHooks(NetworkPortElement inspectedPort) throws Exception;

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
    public abstract void setInspectionHookTag(NetworkPortElement inspectedPort, NetworkPortElement inspectionPort,
            Long tag) throws Exception;

    /**
     * Return the current tag used for an installed inspection hook.
     *
     * @param inspectedPort
     *            The port on which behalf traffic is being inspected.
     * @param inspectionPort
     *            The inspection port belonging to network inspection device.
     * @return The current inspection tag
     */
    public abstract Long getInspectionHookTag(NetworkPortElement inspectedPort, NetworkPortElement inspectionPort)
            throws Exception;

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
    public abstract void setInspectionHookFailurePolicy(NetworkPortElement inspectedPort,
            NetworkPortElement inspectionPort, FailurePolicyType failurePolicyType) throws Exception;

    /**
     * Return the current failure policy used for an installed inspection hook.
     *
     * @param inspectedPort
     *            The port on which behalf traffic is being inspected.
     * @param inspectionPort
     *            The inspection port belonging to network inspection device.
     * @return The current failure policy
     */
    public abstract FailurePolicyType getInspectionHookFailurePolicy(NetworkPortElement inspectedPort,
            NetworkPortElement inspectionPort) throws Exception;

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

    public InspectionHookElement getInspectionHook(NetworkPortElement inspectedPort, NetworkPortElement inspectionPort)
            throws Exception;

    public void updateInspectionHook(InspectionHookElement inspectionHook) throws Exception;

    /**
     * On board a port as inspection interface
     *
     * @param inspectionPort
     *            Inspection port to on board
     */
    public abstract void registerInspectionPort(NetworkPortElement inspectionPort) throws Exception;

    /**
     * SDN Controller name. This name will show up on ISC controller drop down when adding VC
     * @return SDN Controller name
     */
    public abstract String getName();

    /**
     * SDN Controller version informational string
     * @return SDN Controller version
     */
    public abstract String getVersion();

    /**
     * Set Virtualization Connector context through which authentication information can be obtained
     * @param vc Virtualization Connector Element
     */
    public abstract void setVirtualizationConnector(VirtualizationConnectorElement vc);

    /**
     * Check if SDN Controller supports traffic redirection to a VNF running on a remote hypervisor
     * @return true if SDN controller capable of redirection to VNF running on another host
     */
    public abstract boolean isOffboxRedirectionSupported();

}
