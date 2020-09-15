package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CXClassifier extends CXModuleContained {
	java.util.List<CXOperation> getOwnedOperation();

	void addOwnedOperation(CXOperation val);

	<T extends CXOperation> T addOwnedOperation(Class<T> typeToCreate, String concept);

	CXOperation addOwnedOperation();

	java.util.List<CXAttribute> getOwnedAttribute();

	void addOwnedAttribute(CXAttribute val);

	<T extends CXAttribute> T addOwnedAttribute(Class<T> typeToCreate, String concept);

	CXAttribute addOwnedAttribute();

	java.util.List<CXConstant> getOwnedConstants();

	void addOwnedConstants(CXConstant val);

	<T extends CXConstant> T addOwnedConstants(Class<T> typeToCreate, String concept);

	CXConstant addOwnedConstants();

	java.util.List<CXClassifierContained> getContents();

	void addContents(CXClassifierContained val);

	<T extends CXClassifierContained> T addContents(Class<T> typeToCreate, String concept);

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CXClassifier
	 */
	static final TypeSelectPredicate<CXClassifier> type = new TypeSelectPredicate<CXClassifier>(
			"CXDomain::IDL::CXClassifier", //$NON-NLS-1$
			CXClassifier.class);
}
