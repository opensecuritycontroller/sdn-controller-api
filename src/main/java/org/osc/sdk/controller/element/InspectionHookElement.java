package org.osc.sdk.controller.element;

import org.osc.sdk.controller.FailurePolicyType;
import org.osc.sdk.controller.TagEncapsulationType;
import org.osgi.annotation.versioning.ConsumerType;

/**
 * Inspection hook represents a redirection rule placed on the SDN controller to redirect traffic
 * from the Inspected port to the Inspection port.
 */
@ConsumerType
public interface InspectionHookElement {
    String getHookId();

    Long getTag();

    Long getOrder();

    TagEncapsulationType getEncType();

    FailurePolicyType getFailurePolicyType();

    NetworkElement getInspectedPort();

    InspectionPortElement getInspectionPort();
}
