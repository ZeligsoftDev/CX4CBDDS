/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
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
 *******************************************************************************/
package com.zeligsoft.ddk.zdlgen2umlprofile.merge;

import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import com.zeligsoft.base.util.ModelMerger.AbstractHierarchicalKey;
import com.zeligsoft.ddk.zdlgen2umlprofile.l10n.ZDLGen2UMLProfileMessages;

/**
 * @author Toby McClean (tmcclean)
 *
 */
public class ProfileKey extends AbstractHierarchicalKey<ProfileKey> {
	private String nsURI;
	/**
	 * @param element
	 */
	public ProfileKey(Profile element) {
		super(element);
		Stereotype epkg = element.getAppliedStereotype("Ecore::EPackage"); //$NON-NLS-1$
		if(epkg != null) {
			Object nsURIObj = element.getValue(epkg, "nsURI"); //$NON-NLS-1$
			if(nsURIObj != null) {
				nsURI = (String) nsURIObj;
				nsURI = nsURI.substring(0, nsURI.lastIndexOf('/'));
			}
		} else {
			nsURI = element.getURI();
			nsURI = nsURI.substring(0, nsURI.lastIndexOf('/'));
			//throw new IllegalArgumentException(ZDLGen2UMLProfileMessages.ProfileKey_NeedEPackageStereotypeApplied);
		}
		
	}

	/* (non-Javadoc)
	 * @see com.zeligsoft.base.util.ModelMerger.AbstractHierarchicalKey#keyEquals(com.zeligsoft.base.util.ModelMerger.AbstractHierarchicalKey)
	 */
	@Override
	protected boolean keyEquals(ProfileKey other) {
		return UML2Util.safeEquals(nsURI, other.nsURI);
	}

	/* (non-Javadoc)
	 * @see com.zeligsoft.base.util.ModelMerger.AbstractHierarchicalKey#keyHash()
	 */
	@Override
	protected int keyHash() {
		if(nsURI != null) {
			return nsURI.hashCode() * 19;
		}
		
		return 0;
	}

}
