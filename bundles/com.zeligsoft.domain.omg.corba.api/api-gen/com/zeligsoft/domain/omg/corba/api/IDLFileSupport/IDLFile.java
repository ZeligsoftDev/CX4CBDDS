package com.zeligsoft.domain.omg.corba.api.IDLFileSupport;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Core.Namespace;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAModuleContained;

public interface IDLFile extends Namespace {
	String getLocation();

	void setLocation(String val);

	java.util.List<IDLImport> getImportee();

	void addImportee(IDLImport val);

	java.util.List<CORBAModuleContained> getContents();

	void addContents(CORBAModuleContained val);

	String getPrefix();

	void setPrefix(String val);

	org.eclipse.uml2.uml.Package asPackage();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of IDLFile
	 */
	static final TypeSelectPredicate<IDLFile> type = new TypeSelectPredicate<IDLFile>(
			"CORBADomain::IDLFileSupport::IDLFile", //$NON-NLS-1$
			IDLFile.class);
}
