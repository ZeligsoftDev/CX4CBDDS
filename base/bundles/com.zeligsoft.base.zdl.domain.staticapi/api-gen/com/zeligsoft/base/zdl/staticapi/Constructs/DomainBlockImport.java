package com.zeligsoft.base.zdl.staticapi.Constructs;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface DomainBlockImport extends DomainBlockRelation {
	org.eclipse.uml2.uml.PackageImport asPackageImport();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of DomainBlockImport
	 */
	static final TypeSelectPredicate<DomainBlockImport> type = new TypeSelectPredicate<DomainBlockImport>(
			"ZDL::Constructs::DomainBlockImport", //$NON-NLS-1$
			DomainBlockImport.class);
}
