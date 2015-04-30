package com.intelsecurity.isc.plugin.controller;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "failurePolicyType")
@XmlAccessorType(XmlAccessType.FIELD)
public enum FailurePolicyType {
    FAIL_OPEN("FAIL_OPEN"), FAIL_CLOSE("FAIL_CLOSE");

    private final String text;

    private FailurePolicyType(final String text) {
        this.text = text;
    }

    public static FailurePolicyType fromText(String text) {
        for (FailurePolicyType type : FailurePolicyType.values()) {
            if (type.getText().equals(text)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant " + FailurePolicyType.class.getCanonicalName()
                + " Found for " + text);
    }

    private String getText() {
        return this.text;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
