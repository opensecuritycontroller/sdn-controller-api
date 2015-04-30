package com.intelsecurity.isc.plugin.controller;

public enum TagEncapsulationType {
    VLAN("VLAN"),
    MPLS("MPLS"),
    GRE("GRE"),
    QINQ("QINQ"),
    VXLAN("VXLAN"),
    NSH("NSH");

    private final String text;

    private TagEncapsulationType(final String text) {
        this.text = text;
    }

    public static TagEncapsulationType fromText(String text) {
        for (TagEncapsulationType type : TagEncapsulationType.values()) {
            if (type.getText().equals(text)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant " + TagEncapsulationType.class.getCanonicalName()
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
