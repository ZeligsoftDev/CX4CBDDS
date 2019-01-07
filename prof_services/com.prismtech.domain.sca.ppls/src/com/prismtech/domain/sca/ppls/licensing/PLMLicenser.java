/**
 * The Software and documentation are Copyright 2014 PrismTech Canada Inc. All rights reserved.
 */
package com.prismtech.domain.sca.ppls.licensing;
import com.zeligsoft.cx.codegen.editor.UIProviderLicenser;

/**
 * @author mciobanu
 */
public class PLMLicenser extends UIProviderLicenser{

	private static final String featureName = "com.prismtech.domain.sca.plm"; //$NON-NLS-1$
	
	public PLMLicenser(){
		super();
		this.addFeature(featureName, ""); //$NON-NLS-1$
	}
	
	protected String getFeatureName(){
		return featureName;
	}
}
