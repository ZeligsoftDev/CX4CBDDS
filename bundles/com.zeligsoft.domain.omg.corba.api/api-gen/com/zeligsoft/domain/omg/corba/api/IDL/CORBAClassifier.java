package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CORBAClassifier extends CORBAModuleContained {
	java.util.List<CORBAOperation> getOwnedOperation();

	void addOwnedOperation(CORBAOperation val);

	<T extends CORBAOperation> T addOwnedOperation(Class<T> typeToCreate,
			String concept);

	CORBAOperation addOwnedOperation();

	java.util.List<CORBAAttribute> getOwnedAttribute();

	void addOwnedAttribute(CORBAAttribute val);

	<T extends CORBAAttribute> T addOwnedAttribute(Class<T> typeToCreate,
			String concept);

	CORBAAttribute addOwnedAttribute();

	java.util.List<CORBAConstant> getOwnedConstants();

	void addOwnedConstants(CORBAConstant val);

	<T extends CORBAConstant> T addOwnedConstants(Class<T> typeToCreate,
			String concept);

	CORBAConstant addOwnedConstants();

	java.util.List<CORBAClassifierContained> getContents();

	void addContents(CORBAClassifierContained val);

	<T extends CORBAClassifierContained> T addContents(Class<T> typeToCreate,
			String concept);

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CORBAClassifier
	 */
	static final TypeSelectPredicate<CORBAClassifier> type = new TypeSelectPredicate<CORBAClassifier>(
			"CORBADomain::IDL::CORBAClassifier", //$NON-NLS-1$
			CORBAClassifier.class);
}
