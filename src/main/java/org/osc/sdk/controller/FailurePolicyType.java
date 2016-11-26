package org.osc.sdk.controller;

public enum FailurePolicyType {
    FAIL_OPEN("FAIL_OPEN"), FAIL_CLOSE("FAIL_CLOSE"), NA("N/A");

    private final String text;

    private FailurePolicyType(final String text) {
        this.text = text;
    }

    public static FailurePolicyType fromText(String text) {
        if (text == null) {
            return null;
        }

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
