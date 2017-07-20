/*******************************************************************************
 * Copyright (c) Intel Corporation
 * Copyright (c) 2017
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.osc.sdk.controller;

/**
 * This enum represents the encapsulation type security service supports.
 */
public enum TagEncapsulationType {
	/**
	 * VLAN encapsulation type.
	 */
    VLAN("VLAN"),

    /**
     * MPLS encapsulation type.
     */
    MPLS("MPLS"),

    /**
     * GRE encapsulation type.
     */
    GRE("GRE"),

    /**
     * QINQ encapsulation type.
     */
    QINQ("QINQ"),

    /**
     * VXLAN encapsulation type.
     */
    VXLAN("VXLAN"),

    /**
     * NSH encapsulation type.
     */
    NSH("NSH");

    private final String text;

    TagEncapsulationType(final String text) {
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
