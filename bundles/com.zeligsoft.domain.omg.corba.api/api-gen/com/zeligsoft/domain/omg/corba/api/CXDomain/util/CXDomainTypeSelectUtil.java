package com.zeligsoft.domain.omg.corba.api.CXDomain.util;

import java.util.Collection;
import java.util.List;

import org.eclipse.uml2.uml.PackageableElement;

import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;

import com.zeligsoft.base.zdl.staticapi.predicate.IsZDLConcept;
import com.zeligsoft.base.zdl.staticapi.functions.CreateZDLWrapper;

import com.zeligsoft.domain.omg.corba.api.IDL.CXWString;
import com.zeligsoft.domain.omg.corba.api.IDL.CXAnonymousArray;
import com.zeligsoft.domain.omg.corba.api.IDL.CXAnonymousSequence;
import com.zeligsoft.domain.omg.corba.api.IDL.CXArray;
import com.zeligsoft.domain.omg.corba.api.IDL.CXBounded;
import com.zeligsoft.domain.omg.corba.api.IDL.CXBoxedValue;
import com.zeligsoft.domain.omg.corba.api.IDL.CXConstants;
import com.zeligsoft.domain.omg.corba.api.IDL.CXConstructed;
import com.zeligsoft.domain.omg.corba.api.IDL.CXEnum;
import com.zeligsoft.domain.omg.corba.api.IDL.CXException;
import com.zeligsoft.domain.omg.corba.api.IDL.CXInterface;
import com.zeligsoft.domain.omg.corba.api.IDL.CXPrimitive;
import com.zeligsoft.domain.omg.corba.api.IDL.CXSequence;
import com.zeligsoft.domain.omg.corba.api.IDL.CXString;
import com.zeligsoft.domain.omg.corba.api.IDL.CXStruct;
import com.zeligsoft.domain.omg.corba.api.IDL.CXTemplate;
import com.zeligsoft.domain.omg.corba.api.IDL.CXTypeDef;
import com.zeligsoft.domain.omg.corba.api.IDL.CXUnion;
import com.zeligsoft.domain.omg.corba.api.IDL.CXValue;
import com.zeligsoft.domain.omg.corba.api.IDL.CXWrapper;
import com.zeligsoft.domain.omg.corba.api.IDL.CXModule;
import com.zeligsoft.domain.omg.corba.api.IDL.Native;
import com.zeligsoft.domain.omg.corba.api.IDLFileSupport.IDLFile;
import com.zeligsoft.domain.omg.corba.api.IDLFileSupport.IDLImport;

public class CXDomainTypeSelectUtil {
	public List<CXWString> selectCXWString(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("CXDomain::IDL::CXWString"));
		final Collection<CXWString> result = Collections2.transform(elements, CreateZDLWrapper.create(CXWString.class));
		return new ImmutableList.Builder<CXWString>().addAll(result).build();

	}

	public List<CXAnonymousArray> selectCXAnonymousArray(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("CXDomain::IDL::CXAnonymousArray"));
		final Collection<CXAnonymousArray> result = Collections2.transform(elements,
				CreateZDLWrapper.create(CXAnonymousArray.class));
		return new ImmutableList.Builder<CXAnonymousArray>().addAll(result).build();

	}

	public List<CXAnonymousSequence> selectCXAnonymousSequence(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("CXDomain::IDL::CXAnonymousSequence"));
		final Collection<CXAnonymousSequence> result = Collections2.transform(elements,
				CreateZDLWrapper.create(CXAnonymousSequence.class));
		return new ImmutableList.Builder<CXAnonymousSequence>().addAll(result).build();

	}

	public List<CXArray> selectCXArray(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("CXDomain::IDL::CXArray"));
		final Collection<CXArray> result = Collections2.transform(elements, CreateZDLWrapper.create(CXArray.class));
		return new ImmutableList.Builder<CXArray>().addAll(result).build();

	}

	public List<CXBounded> selectCXBounded(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("CXDomain::IDL::CXBounded"));
		final Collection<CXBounded> result = Collections2.transform(elements, CreateZDLWrapper.create(CXBounded.class));
		return new ImmutableList.Builder<CXBounded>().addAll(result).build();

	}

	public List<CXBoxedValue> selectCXBoxedValue(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("CXDomain::IDL::CXBoxedValue"));
		final Collection<CXBoxedValue> result = Collections2.transform(elements,
				CreateZDLWrapper.create(CXBoxedValue.class));
		return new ImmutableList.Builder<CXBoxedValue>().addAll(result).build();

	}

	public List<CXConstants> selectCXConstants(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("CXDomain::IDL::CXConstants"));
		final Collection<CXConstants> result = Collections2.transform(elements,
				CreateZDLWrapper.create(CXConstants.class));
		return new ImmutableList.Builder<CXConstants>().addAll(result).build();

	}

	public List<CXConstructed> selectCXConstructed(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("CXDomain::IDL::CXConstructed"));
		final Collection<CXConstructed> result = Collections2.transform(elements,
				CreateZDLWrapper.create(CXConstructed.class));
		return new ImmutableList.Builder<CXConstructed>().addAll(result).build();

	}

	public List<CXEnum> selectCXEnum(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("CXDomain::IDL::CXEnum"));
		final Collection<CXEnum> result = Collections2.transform(elements, CreateZDLWrapper.create(CXEnum.class));
		return new ImmutableList.Builder<CXEnum>().addAll(result).build();

	}

	public List<CXException> selectCXException(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("CXDomain::IDL::CXException"));
		final Collection<CXException> result = Collections2.transform(elements,
				CreateZDLWrapper.create(CXException.class));
		return new ImmutableList.Builder<CXException>().addAll(result).build();

	}

	public List<CXInterface> selectCXInterface(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("CXDomain::IDL::CXInterface"));
		final Collection<CXInterface> result = Collections2.transform(elements,
				CreateZDLWrapper.create(CXInterface.class));
		return new ImmutableList.Builder<CXInterface>().addAll(result).build();

	}

	public List<CXPrimitive> selectCXPrimitive(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("CXDomain::IDL::CXPrimitive"));
		final Collection<CXPrimitive> result = Collections2.transform(elements,
				CreateZDLWrapper.create(CXPrimitive.class));
		return new ImmutableList.Builder<CXPrimitive>().addAll(result).build();

	}

	public List<CXSequence> selectCXSequence(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("CXDomain::IDL::CXSequence"));
		final Collection<CXSequence> result = Collections2.transform(elements,
				CreateZDLWrapper.create(CXSequence.class));
		return new ImmutableList.Builder<CXSequence>().addAll(result).build();

	}

	public List<CXString> selectCXString(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("CXDomain::IDL::CXString"));
		final Collection<CXString> result = Collections2.transform(elements, CreateZDLWrapper.create(CXString.class));
		return new ImmutableList.Builder<CXString>().addAll(result).build();

	}

	public List<CXStruct> selectCXStruct(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("CXDomain::IDL::CXStruct"));
		final Collection<CXStruct> result = Collections2.transform(elements, CreateZDLWrapper.create(CXStruct.class));
		return new ImmutableList.Builder<CXStruct>().addAll(result).build();

	}

	public List<CXTemplate> selectCXTemplate(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("CXDomain::IDL::CXTemplate"));
		final Collection<CXTemplate> result = Collections2.transform(elements,
				CreateZDLWrapper.create(CXTemplate.class));
		return new ImmutableList.Builder<CXTemplate>().addAll(result).build();

	}

	public List<CXTypeDef> selectCXTypeDef(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("CXDomain::IDL::CXTypeDef"));
		final Collection<CXTypeDef> result = Collections2.transform(elements, CreateZDLWrapper.create(CXTypeDef.class));
		return new ImmutableList.Builder<CXTypeDef>().addAll(result).build();

	}

	public List<CXUnion> selectCXUnion(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("CXDomain::IDL::CXUnion"));
		final Collection<CXUnion> result = Collections2.transform(elements, CreateZDLWrapper.create(CXUnion.class));
		return new ImmutableList.Builder<CXUnion>().addAll(result).build();

	}

	public List<CXValue> selectCXValue(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("CXDomain::IDL::CXValue"));
		final Collection<CXValue> result = Collections2.transform(elements, CreateZDLWrapper.create(CXValue.class));
		return new ImmutableList.Builder<CXValue>().addAll(result).build();

	}

	public List<CXWrapper> selectCXWrapper(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("CXDomain::IDL::CXWrapper"));
		final Collection<CXWrapper> result = Collections2.transform(elements, CreateZDLWrapper.create(CXWrapper.class));
		return new ImmutableList.Builder<CXWrapper>().addAll(result).build();

	}

	public List<CXModule> selectCXModule(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("CXDomain::IDL::CXModule"));
		final Collection<CXModule> result = Collections2.transform(elements, CreateZDLWrapper.create(CXModule.class));
		return new ImmutableList.Builder<CXModule>().addAll(result).build();

	}

	public List<Native> selectNative(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("CXDomain::IDL::Native"));
		final Collection<Native> result = Collections2.transform(elements, CreateZDLWrapper.create(Native.class));
		return new ImmutableList.Builder<Native>().addAll(result).build();

	}

	public List<IDLFile> selectIDLFile(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("CXDomain::IDLFileSupport::IDLFile"));
		final Collection<IDLFile> result = Collections2.transform(elements, CreateZDLWrapper.create(IDLFile.class));
		return new ImmutableList.Builder<IDLFile>().addAll(result).build();

	}

	public List<IDLImport> selectIDLImport(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg.getPackagedElements(),
				new IsZDLConcept("CXDomain::IDLFileSupport::IDLImport"));
		final Collection<IDLImport> result = Collections2.transform(elements, CreateZDLWrapper.create(IDLImport.class));
		return new ImmutableList.Builder<IDLImport>().addAll(result).build();

	}

}
