package com.zeligsoft.base.zdl.staticapi.Constructs;

import com.zeligsoft.base.zdl.staticapi.Validation.DomainConstraint;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface DomainConcept extends DomainClassifier {
	java.util.List<DomainConstraint> getConstraint();

	void addConstraint(DomainConstraint val);

	<T extends DomainConstraint> T addConstraint(Class<T> typeToCreate,
			String concept);

	DomainConstraint addConstraint();

	String getIconURI();

	void setIconURI(String val);

	org.eclipse.uml2.uml.Class asClass();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of DomainConcept
	 */
	static final TypeSelectPredicate<DomainConcept> type = new TypeSelectPredicate<DomainConcept>(
			"ZDL::Constructs::DomainConcept", //$NON-NLS-1$
			DomainConcept.class);
}
