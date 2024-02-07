/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/* $Id: GenericGraphicsDevice.java 1732018 2016-02-24 04:51:06Z gadams $ */

package org.apache.xmlgraphics.java2d;

import java.awt.GraphicsConfigTemplate;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;

/**
 * This implements the {@link GraphicsDevice} interface as appropriate for the various output
 * configurations.
 */
public class GenericGraphicsDevice extends GraphicsDevice {

    /**
     * The Graphics Config that created us...
     */
    private final GraphicsConfiguration gc;

    /**
     * Create a new graphics2D device.
     *
     * @param gc we should reference
     */
    public GenericGraphicsDevice(GraphicsConfiguration gc) {
        this.gc = gc;
    }

    /**
     * Ignore template and return the only config we have
     *
     * @param gct the template configuration
     * @return the best configuration which is the only one
     */
    public GraphicsConfiguration getBestConfiguration(GraphicsConfigTemplate gct) {
        return gc;
    }

    /**
     * Return an array of our one GraphicsConfig
     *
     * @return an array containing the one graphics configuration
     */
    public GraphicsConfiguration[] getConfigurations() {
        return new GraphicsConfiguration[] {gc};
    }

    /**
     * Return out sole GraphicsConfig.
     *
     * @return the graphics configuration that created this object
     */
    public GraphicsConfiguration getDefaultConfiguration() {
        return gc;
    }

    /**
     * Generate an IdString..
     *
     * @return the ID string for this device, uses toString
     */
    public String getIDstring() {
        return toString();
    }

    /**
     * Let the caller know that we are "a printer"
     *
     * @return the type which is always printer
     */
    public int getType() {
        return GraphicsDevice.TYPE_PRINTER;
    }
}
