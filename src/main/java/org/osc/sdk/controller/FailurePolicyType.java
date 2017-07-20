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
 * This enum represents the traffic flow action in case of device failure.
 */
public enum FailurePolicyType {
	/**
	 * Traffic is allowed to pass without inspection in case of device failure.
	 */
	FAIL_OPEN("FAIL_OPEN"),

	/**
	 * Traffic is not allowed to pass in case of device failure.
	 */
    FAIL_CLOSE("FAIL_CLOSE"),

    /**
     * N/A in case SDN controller does not support failure policy.
     */
    NA("N/A");

    private final String text;

    FailurePolicyType(final String text) {
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
