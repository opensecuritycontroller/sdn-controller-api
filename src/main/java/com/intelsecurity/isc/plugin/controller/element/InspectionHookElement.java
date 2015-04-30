package com.intelsecurity.isc.plugin.controller.element;

import com.intelsecurity.isc.plugin.controller.FailurePolicyType;
import com.intelsecurity.isc.plugin.controller.TagEncapsulationType;

public interface InspectionHookElement {
    public String getHookId();

    public Long getTag();

    public Long getOrder();

    public TagEncapsulationType getEncType();

    public FailurePolicyType getFailurePolicyType();

    public NetworkPortElement getInspectedPort();

    public NetworkPortElement getInspectionPort();
}
