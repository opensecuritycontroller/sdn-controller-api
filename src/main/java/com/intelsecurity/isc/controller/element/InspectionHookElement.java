package com.intelsecurity.isc.controller.element;

import com.intelsecurity.isc.controller.FailurePolicyType;

public interface InspectionHookElement {
    public String getHookId();

    public Long getTag();

    public Long getOrder();

    public TagEncapsulationType getEncType();

    public FailurePolicyType getFailurePolicyType();

    public NetworkPortElement getInspectedPort();

    public NetworkPortElement getInspectionPort();
}
