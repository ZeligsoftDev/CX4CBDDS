/**
 * The Software and documentation are Copyright 2012 PrismTech Canada Inc. All rights reserved.
 */

package com.prismtech.domain.sca.ppls.utils;

/**
 * Constants for the PLM profile VariationPointProfile
 * 
 * @author mciobanu
 *
 */

public final class PLMNames {
	private PLMNames() {
		super();
	}
	
	/**
	 * Fully qualified name for the PLM DomainProfile: VariationPointProfile.
	 */
	public static final String VARIATION_POINT_PROFILE = "VariationPointProfile";//$NON-NLS-1$	

	
	/**
	 * Fully qualified name for the PLM DomainAttribute: vp_id.
	 * Multiplicity: 1 
	 */
	public static final String VP_ID = VARIATION_POINT_PROFILE + "::VariationPoint::vp_id";//$NON-NLS-1$

	/**
	 * Fully qualified name for the PLM DomainConcept: VariationPoint. 
	 */
	public static final String VARIATION_POINT = VARIATION_POINT_PROFILE + "::VariationPoint";//$NON-NLS-1$
	
	/**
	 * Fully qualified name for the PLM DomainConcept: VariationPointWithSettings. 
	 */
	public static final String VARIATION_POINT_WITH_SETTINGS = VARIATION_POINT_PROFILE + "::VariationPointWithSettings";//$NON-NLS-1$
	
	/**
	 * Fully qualified name for the PLM DomainConcept: VariationPointWithValue. 
	 */
	
	public static final String VARIATION_POINT_WITH_VALUE = VARIATION_POINT_PROFILE + "::VariationPointWithValue";//$NON-NLS-1$
	
	/**
	 * PLM DomainAttribute: VariationPoint::vp_id. 
	 * Lower: 1 Upper: 1 
	 */
	public static final String VARIATION_POINT__VP_ID = "vp_id";//$NON-NLS-1$  
	
	public static final String MODEL_ANNOTATION = "plm.model"; //$NON-NLS-1$
	
	public static final String MODEL_ANNOTATION__TYPE = "type"; //$NON-NLS-1$
	
	public static final String MODEL_ANNOTATION__GENERATED = "generated"; //$NON-NLS-1$
	
}
