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

/* $Id: SimpleRefinedImageFlavor.java 682720 2008-08-05 14:22:29Z jeremias $ */

package org.apache.xmlgraphics.image.loader;

/**
 * Simple refined image flavor implementation that just differs flavors by name but allows to
 * specify a parent flavor.
 */
public class SimpleRefinedImageFlavor extends RefinedImageFlavor {

    /**
     * Main constructor.
     * @param parentFlavor the parent image flavor
     * @param name the name of the image flavor
     */
    public SimpleRefinedImageFlavor(ImageFlavor parentFlavor, String name) {
        super(name, parentFlavor);
    }

}
