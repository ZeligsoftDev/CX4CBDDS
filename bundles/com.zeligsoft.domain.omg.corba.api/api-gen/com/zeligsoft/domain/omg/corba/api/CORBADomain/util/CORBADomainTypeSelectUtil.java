package com.zeligsoft.domain.omg.corba.api.CORBADomain.util;

import java.util.Collection;
import java.util.List;

import org.eclipse.uml2.uml.PackageableElement;

import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;

import com.zeligsoft.base.zdl.staticapi.predicate.IsZDLConcept;
import com.zeligsoft.base.zdl.staticapi.functions.CreateZDLWrapper;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBAWString;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAAnonymousArray;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAAnonymousSequence;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAArray;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBABounded;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBABoxedValue;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAConstants;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAConstructed;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAEnum;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAException;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAInterface;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAPrimitive;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBASequence;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAString;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAStruct;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBATemplate;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBATypeDef;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAUnion;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAValue;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAWrapper;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAModule;
import com.zeligsoft.domain.omg.corba.api.IDL.Native;
import com.zeligsoft.domain.omg.corba.api.IDLFileSupport.IDLFile;
import com.zeligsoft.domain.omg.corba.api.IDLFileSupport.IDLImport;

public class CORBADomainTypeSelectUtil {
	public List<CORBAWString> selectCORBAWString(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CORBADomain::IDL::CORBAWString"));
		final Collection<CORBAWString> result = Collections2.transform(
				elements, CreateZDLWrapper.create(CORBAWString.class));
		return new ImmutableList.Builder<CORBAWString>().addAll(result).build();

	}

	public List<CORBAAnonymousArray> selectCORBAAnonymousArray(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CORBADomain::IDL::CORBAAnonymousArray"));
		final Collection<CORBAAnonymousArray> result = Collections2.transform(
				elements, CreateZDLWrapper.create(CORBAAnonymousArray.class));
		return new ImmutableList.Builder<CORBAAnonymousArray>().addAll(result)
				.build();

	}

	public List<CORBAAnonymousSequence> selectCORBAAnonymousSequence(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CORBADomain::IDL::CORBAAnonymousSequence"));
		final Collection<CORBAAnonymousSequence> result = Collections2
				.transform(elements,
						CreateZDLWrapper.create(CORBAAnonymousSequence.class));
		return new ImmutableList.Builder<CORBAAnonymousSequence>().addAll(
				result).build();

	}

	public List<CORBAArray> selectCORBAArray(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CORBADomain::IDL::CORBAArray"));
		final Collection<CORBAArray> result = Collections2.transform(elements,
				CreateZDLWrapper.create(CORBAArray.class));
		return new ImmutableList.Builder<CORBAArray>().addAll(result).build();

	}

	public List<CORBABounded> selectCORBABounded(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CORBADomain::IDL::CORBABounded"));
		final Collection<CORBABounded> result = Collections2.transform(
				elements, CreateZDLWrapper.create(CORBABounded.class));
		return new ImmutableList.Builder<CORBABounded>().addAll(result).build();

	}

	public List<CORBABoxedValue> selectCORBABoxedValue(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CORBADomain::IDL::CORBABoxedValue"));
		final Collection<CORBABoxedValue> result = Collections2.transform(
				elements, CreateZDLWrapper.create(CORBABoxedValue.class));
		return new ImmutableList.Builder<CORBABoxedValue>().addAll(result)
				.build();

	}

	public List<CORBAConstants> selectCORBAConstants(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CORBADomain::IDL::CORBAConstants"));
		final Collection<CORBAConstants> result = Collections2.transform(
				elements, CreateZDLWrapper.create(CORBAConstants.class));
		return new ImmutableList.Builder<CORBAConstants>().addAll(result)
				.build();

	}

	public List<CORBAConstructed> selectCORBAConstructed(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CORBADomain::IDL::CORBAConstructed"));
		final Collection<CORBAConstructed> result = Collections2.transform(
				elements, CreateZDLWrapper.create(CORBAConstructed.class));
		return new ImmutableList.Builder<CORBAConstructed>().addAll(result)
				.build();

	}

	public List<CORBAEnum> selectCORBAEnum(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CORBADomain::IDL::CORBAEnum"));
		final Collection<CORBAEnum> result = Collections2.transform(elements,
				CreateZDLWrapper.create(CORBAEnum.class));
		return new ImmutableList.Builder<CORBAEnum>().addAll(result).build();

	}

	public List<CORBAException> selectCORBAException(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CORBADomain::IDL::CORBAException"));
		final Collection<CORBAException> result = Collections2.transform(
				elements, CreateZDLWrapper.create(CORBAException.class));
		return new ImmutableList.Builder<CORBAException>().addAll(result)
				.build();

	}

	public List<CORBAInterface> selectCORBAInterface(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CORBADomain::IDL::CORBAInterface"));
		final Collection<CORBAInterface> result = Collections2.transform(
				elements, CreateZDLWrapper.create(CORBAInterface.class));
		return new ImmutableList.Builder<CORBAInterface>().addAll(result)
				.build();

	}

	public List<CORBAPrimitive> selectCORBAPrimitive(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CORBADomain::IDL::CORBAPrimitive"));
		final Collection<CORBAPrimitive> result = Collections2.transform(
				elements, CreateZDLWrapper.create(CORBAPrimitive.class));
		return new ImmutableList.Builder<CORBAPrimitive>().addAll(result)
				.build();

	}

	public List<CORBASequence> selectCORBASequence(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CORBADomain::IDL::CORBASequence"));
		final Collection<CORBASequence> result = Collections2.transform(
				elements, CreateZDLWrapper.create(CORBASequence.class));
		return new ImmutableList.Builder<CORBASequence>().addAll(result)
				.build();

	}

	public List<CORBAString> selectCORBAString(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CORBADomain::IDL::CORBAString"));
		final Collection<CORBAString> result = Collections2.transform(elements,
				CreateZDLWrapper.create(CORBAString.class));
		return new ImmutableList.Builder<CORBAString>().addAll(result).build();

	}

	public List<CORBAStruct> selectCORBAStruct(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CORBADomain::IDL::CORBAStruct"));
		final Collection<CORBAStruct> result = Collections2.transform(elements,
				CreateZDLWrapper.create(CORBAStruct.class));
		return new ImmutableList.Builder<CORBAStruct>().addAll(result).build();

	}

	public List<CORBATemplate> selectCORBATemplate(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CORBADomain::IDL::CORBATemplate"));
		final Collection<CORBATemplate> result = Collections2.transform(
				elements, CreateZDLWrapper.create(CORBATemplate.class));
		return new ImmutableList.Builder<CORBATemplate>().addAll(result)
				.build();

	}

	public List<CORBATypeDef> selectCORBATypeDef(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CORBADomain::IDL::CORBATypeDef"));
		final Collection<CORBATypeDef> result = Collections2.transform(
				elements, CreateZDLWrapper.create(CORBATypeDef.class));
		return new ImmutableList.Builder<CORBATypeDef>().addAll(result).build();

	}

	public List<CORBAUnion> selectCORBAUnion(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CORBADomain::IDL::CORBAUnion"));
		final Collection<CORBAUnion> result = Collections2.transform(elements,
				CreateZDLWrapper.create(CORBAUnion.class));
		return new ImmutableList.Builder<CORBAUnion>().addAll(result).build();

	}

	public List<CORBAValue> selectCORBAValue(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CORBADomain::IDL::CORBAValue"));
		final Collection<CORBAValue> result = Collections2.transform(elements,
				CreateZDLWrapper.create(CORBAValue.class));
		return new ImmutableList.Builder<CORBAValue>().addAll(result).build();

	}

	public List<CORBAWrapper> selectCORBAWrapper(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CORBADomain::IDL::CORBAWrapper"));
		final Collection<CORBAWrapper> result = Collections2.transform(
				elements, CreateZDLWrapper.create(CORBAWrapper.class));
		return new ImmutableList.Builder<CORBAWrapper>().addAll(result).build();

	}

	public List<CORBAModule> selectCORBAModule(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CORBADomain::IDL::CORBAModule"));
		final Collection<CORBAModule> result = Collections2.transform(elements,
				CreateZDLWrapper.create(CORBAModule.class));
		return new ImmutableList.Builder<CORBAModule>().addAll(result).build();

	}

	public List<Native> selectNative(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CORBADomain::IDL::Native"));
		final Collection<Native> result = Collections2.transform(elements,
				CreateZDLWrapper.create(Native.class));
		return new ImmutableList.Builder<Native>().addAll(result).build();

	}

	public List<IDLFile> selectIDLFile(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CORBADomain::IDLFileSupport::IDLFile"));
		final Collection<IDLFile> result = Collections2.transform(elements,
				CreateZDLWrapper.create(IDLFile.class));
		return new ImmutableList.Builder<IDLFile>().addAll(result).build();

	}

	public List<IDLImport> selectIDLImport(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"CORBADomain::IDLFileSupport::IDLImport"));
		final Collection<IDLImport> result = Collections2.transform(elements,
				CreateZDLWrapper.create(IDLImport.class));
		return new ImmutableList.Builder<IDLImport>().addAll(result).build();

	}

}
