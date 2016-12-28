package org.osc.sdk.controller.element;

import org.osc.sdk.controller.FailurePolicyType;
import org.osc.sdk.controller.TagEncapsulationType;
import org.osgi.annotation.versioning.ConsumerType;

/**
 * Inspection hook represents a redirection rule placed on the SDN controller to redirect traffic
 * from the Inspected port  -> Inspection port.
 */
@ConsumerType
public interface InspectionHookElement {
    public String getHookId();

    public Long getTag();

    public Long getOrder();

    public TagEncapsulationType getEncType();

    public FailurePolicyType getFailurePolicyType();

    public NetworkElement getInspectedPort();

    public InspectionPortElement getInspectionPort();
}
