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

public class Status {

    private String name;
    private String version;
    private boolean controllerReady;

    public String getName() {
        return this.name;
    }

    public Status(String name, String version, boolean canServe) {
        super();
        this.name = name;
        this.version = version;
        this.controllerReady = canServe;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public boolean isControllerReady() {
        return this.controllerReady;
    }

    public void setControllerReady(boolean canServe) {
        this.controllerReady = canServe;
    }

    @Override
    public String toString() {
        return "Status [name=" + this.name + ", version=" + this.version + ", controllerReady=" + this.controllerReady + "]";
    }

}
