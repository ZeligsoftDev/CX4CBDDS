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

/* $Id: ASCII85Constants.java 1732018 2016-02-24 04:51:06Z gadams $ */

package org.apache.xmlgraphics.util.io;

/**
 * This interface defines constants used by the ASCII85 filters.
 *
 * @version $Id: ASCII85Constants.java 1732018 2016-02-24 04:51:06Z gadams $
 */
public interface ASCII85Constants {

    /** Special character "z" stands for four NULL bytes (short-cut for !!!!!) */
    int ZERO          = 0x7A; //"z"
    /** ZERO as a byte array */
    byte[] ZERO_ARRAY = {(byte)ZERO};
    /** The start index for ASCII85 characters (!) */
    int START         = 0x21; //"!"
    /** The end index for ASCII85 characters (u) */
    int END           = 0x75; //"u"
    /** The EOL indicator (LF) */
    int EOL           = 0x0A; //"\n"
    /** The EOD (end of data) indicator */
    byte[] EOD        = {0x7E, 0x3E}; //"~>"

    /** Array of powers of 85 (4, 3, 2, 1, 0) */
    long[] POW85 = new long[] {85 * 85 * 85 * 85,
                                                    85 * 85 * 85,
                                                    85 * 85,
                                                    85,
                                                    1};

    /*
    long BASE85_4 = 85;
    long BASE85_3 = BASE85_4 * BASE85_4;
    long BASE85_2 = BASE85_3 * BASE85_4;
    long BASE85_1 = BASE85_2 * BASE85_4;
    */

}


