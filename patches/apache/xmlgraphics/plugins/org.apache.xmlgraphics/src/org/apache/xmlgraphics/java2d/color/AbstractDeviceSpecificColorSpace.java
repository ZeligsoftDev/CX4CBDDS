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

/* $Id: AbstractDeviceSpecificColorSpace.java 1051421 2010-12-21 08:54:25Z jeremias $ */

package org.apache.xmlgraphics.java2d.color;

import java.awt.color.ColorSpace;

/**
 * Base class for device-specific (uncalibrated) color spaces.
 */
public abstract class AbstractDeviceSpecificColorSpace extends ColorSpace {

    private static final long serialVersionUID = -4888985582872101875L;

    /**
     * Creates a new instance.
     * @param type the color space type ({@link ColorSpace}.TYPE_*)
     * @param numcomponents the number of color components applicable to the color space
     */
    protected AbstractDeviceSpecificColorSpace(int type, int numcomponents) {
        super(type, numcomponents);
    }

}
