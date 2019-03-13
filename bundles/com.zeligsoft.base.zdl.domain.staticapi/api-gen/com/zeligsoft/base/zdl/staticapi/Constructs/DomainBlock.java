package com.zeligsoft.base.zdl.staticapi.Constructs;

import com.zeligsoft.base.zdl.staticapi.Validation.ExternalDomainConstraint;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface DomainBlock extends DomainNamedElement {
	java.util.List<DomainClassifier> getClassifier();

	void addClassifier(DomainClassifier val);

	<T extends DomainClassifier> T addClassifier(Class<T> typeToCreate,
			String concept);

	java.util.List<ExternalDomainConstraint> getConstraint();

	void addConstraint(ExternalDomainConstraint val);

	<T extends ExternalDomainConstraint> T addConstraint(Class<T> typeToCreate,
			String concept);

	ExternalDomainConstraint addConstraint();

	org.eclipse.uml2.uml.Package asPackage();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of DomainBlock
	 */
	static final TypeSelectPredicate<DomainBlock> type = new TypeSelectPredicate<DomainBlock>(
			"ZDL::Constructs::DomainBlock", //$NON-NLS-1$
			DomainBlock.class);
}
