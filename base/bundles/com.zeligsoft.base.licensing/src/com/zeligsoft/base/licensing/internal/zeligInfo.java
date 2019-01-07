/**
 * Copyright 2018 ADLINK Technology Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.base.licensing.internal;
//zeligInfo.java
//This file is auto-generated, do not edit by hand

import com.macrovision.flexlm.FlexlmConstants;
import com.macrovision.flexlm.FlexlmException;
import com.macrovision.flexlm.VendorInfo;
import com.macrovision.flexlm.misc.FlexlmPublicKey;

import java.security.PublicKey;

class zeligInfo extends VendorInfo implements FlexlmConstants {

	public zeligInfo() throws FlexlmException {
		super();
	}

	@Override
	public String getVendorName() {
		return "zelig"; //$NON-NLS-1$
	}

	@Override
	public PublicKey getPublicKey(int strength) {
		switch (strength) {
		case LM_STRENGTH_113BIT:
		return new FlexlmPublicKey(getVendorName(),"7C9B519EA6B85C182880B6A8A1AE5B95"); //$NON-NLS-1$

		case LM_STRENGTH_163BIT:
		return new FlexlmPublicKey(getVendorName(),"7CA2941A75322366533C82ECB8CD9CFD08D5BF66B1DD"); //$NON-NLS-1$

		case LM_STRENGTH_239BIT:
		return new FlexlmPublicKey(getVendorName(),"7CFB3D4E86C0A2855C5E277638B9701E4D10C4B1F34702F9E46DE497A21CEF"); //$NON-NLS-1$

		default:
			return null;
		}
	}

	@Override
	public int[] getEncryptionSeeds() {
		return new int[] {0x1af22415,0xdcae51b };
	}

	@Override
	public int[] getVendorKeys() {
		return new int[] {0xca0b8740,0xd0f9a355,0xd692fcb6,0x9e9a837c };
	}

	@Override
	public int[] getCroKeys() {
		return new int[] {0x310a184a,0xf7eaa686 };
	}

	@Override
	public int getDefaultStrength() {
		return LM_STRENGTH_113BIT;
	}

}

//end
