package com.zeligsoft.base.zdl.staticapi.Constructs;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface DomainBlockMerge extends DomainBlockRelation {
	org.eclipse.uml2.uml.PackageMerge asPackageMerge();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of DomainBlockMerge
	 */
	static final TypeSelectPredicate<DomainBlockMerge> type = new TypeSelectPredicate<DomainBlockMerge>(
			"ZDL::Constructs::DomainBlockMerge", //$NON-NLS-1$
			DomainBlockMerge.class);
}
