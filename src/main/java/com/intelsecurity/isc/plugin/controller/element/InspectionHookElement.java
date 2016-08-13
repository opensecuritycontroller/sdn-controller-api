package com.intelsecurity.isc.plugin.controller.element;

import com.intelsecurity.isc.plugin.controller.FailurePolicyType;
import com.intelsecurity.isc.plugin.controller.TagEncapsulationType;

/**
 * Inspection hook represents a redirection rule placed on the SDN controller to redirect traffic
 * from the Inspected port  -> Inspection port.
 */
public interface InspectionHookElement {
    public String getHookId();

    public Long getTag();

    public Long getOrder();

    public TagEncapsulationType getEncType();

    public FailurePolicyType getFailurePolicyType();

    public NetworkPortElement getInspectedPort();

    public InspectionPortElement getInspectionPort();
}
