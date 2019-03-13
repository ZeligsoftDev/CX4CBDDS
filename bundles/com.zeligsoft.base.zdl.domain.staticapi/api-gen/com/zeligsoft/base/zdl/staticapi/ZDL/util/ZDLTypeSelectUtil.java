package com.zeligsoft.base.zdl.staticapi.ZDL.util;

import java.util.Collection;
import java.util.List;

import org.eclipse.uml2.uml.PackageableElement;

import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.zeligsoft.base.zdl.staticapi.Constructs.DomainBlock;
import com.zeligsoft.base.zdl.staticapi.Constructs.DomainBlockReference;
import com.zeligsoft.base.zdl.staticapi.Constructs.DomainConcept;
import com.zeligsoft.base.zdl.staticapi.Constructs.DomainDataType;
import com.zeligsoft.base.zdl.staticapi.Constructs.DomainEnum;
import com.zeligsoft.base.zdl.staticapi.Constructs.DomainEnumLiteral;
import com.zeligsoft.base.zdl.staticapi.Constructs.DomainInstantiation;
import com.zeligsoft.base.zdl.staticapi.Constructs.DomainModel;
import com.zeligsoft.base.zdl.staticapi.Constructs.DomainModelLibrary;
import com.zeligsoft.base.zdl.staticapi.Constructs.DomainModelLibraryReference;
import com.zeligsoft.base.zdl.staticapi.Constructs.DomainPackage;
import com.zeligsoft.base.zdl.staticapi.Constructs.DomainReference;
import com.zeligsoft.base.zdl.staticapi.Constructs.DomainSpecialization;
import com.zeligsoft.base.zdl.staticapi.Validation.DomainConstraint;
import com.zeligsoft.base.zdl.staticapi.Validation.DomainCreateLinkConstraint;
import com.zeligsoft.base.zdl.staticapi.Validation.DomainLinkConstraint;
import com.zeligsoft.base.zdl.staticapi.Validation.ExternalDomainConstraint;
import com.zeligsoft.base.zdl.staticapi.functions.CreateZDLWrapper;
import com.zeligsoft.base.zdl.staticapi.predicate.IsZDLConcept;

public class ZDLTypeSelectUtil {
	public List<DomainBlockReference> selectDomainBlockReference(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZDL::Constructs::DomainBlockReference"));
		final Collection<DomainBlockReference> result = Collections2.transform(
				elements, CreateZDLWrapper.create(DomainBlockReference.class));
		return new ImmutableList.Builder<DomainBlockReference>().addAll(result)
				.build();

	}

	public List<DomainInstantiation> selectDomainInstantiation(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZDL::Constructs::DomainInstantiation"));
		final Collection<DomainInstantiation> result = Collections2.transform(
				elements, CreateZDLWrapper.create(DomainInstantiation.class));
		return new ImmutableList.Builder<DomainInstantiation>().addAll(result)
				.build();

	}

	public List<DomainModelLibraryReference> selectDomainModelLibraryReference(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZDL::Constructs::DomainModelLibraryReference"));
		final Collection<DomainModelLibraryReference> result = Collections2
				.transform(elements, CreateZDLWrapper
						.create(DomainModelLibraryReference.class));
		return new ImmutableList.Builder<DomainModelLibraryReference>().addAll(
				result).build();

	}

	public List<DomainBlock> selectDomainBlock(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZDL::Constructs::DomainBlock"));
		final Collection<DomainBlock> result = Collections2.transform(elements,
				CreateZDLWrapper.create(DomainBlock.class));
		return new ImmutableList.Builder<DomainBlock>().addAll(result).build();

	}

	public List<DomainConcept> selectDomainConcept(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZDL::Constructs::DomainConcept"));
		final Collection<DomainConcept> result = Collections2.transform(
				elements, CreateZDLWrapper.create(DomainConcept.class));
		return new ImmutableList.Builder<DomainConcept>().addAll(result)
				.build();

	}

	public List<DomainDataType> selectDomainDataType(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZDL::Constructs::DomainDataType"));
		final Collection<DomainDataType> result = Collections2.transform(
				elements, CreateZDLWrapper.create(DomainDataType.class));
		return new ImmutableList.Builder<DomainDataType>().addAll(result)
				.build();

	}

	public List<DomainEnum> selectDomainEnum(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZDL::Constructs::DomainEnum"));
		final Collection<DomainEnum> result = Collections2.transform(elements,
				CreateZDLWrapper.create(DomainEnum.class));
		return new ImmutableList.Builder<DomainEnum>().addAll(result).build();

	}

	public List<DomainReference> selectDomainReference(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZDL::Constructs::DomainReference"));
		final Collection<DomainReference> result = Collections2.transform(
				elements, CreateZDLWrapper.create(DomainReference.class));
		return new ImmutableList.Builder<DomainReference>().addAll(result)
				.build();

	}

	public List<DomainEnumLiteral> selectDomainEnumLiteral(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZDL::Constructs::DomainEnumLiteral"));
		final Collection<DomainEnumLiteral> result = Collections2.transform(
				elements, CreateZDLWrapper.create(DomainEnumLiteral.class));
		return new ImmutableList.Builder<DomainEnumLiteral>().addAll(result)
				.build();

	}

	public List<DomainPackage> selectDomainPackage(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZDL::Constructs::DomainPackage"));
		final Collection<DomainPackage> result = Collections2.transform(
				elements, CreateZDLWrapper.create(DomainPackage.class));
		return new ImmutableList.Builder<DomainPackage>().addAll(result)
				.build();

	}

	public List<DomainModel> selectDomainModel(org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZDL::Constructs::DomainModel"));
		final Collection<DomainModel> result = Collections2.transform(elements,
				CreateZDLWrapper.create(DomainModel.class));
		return new ImmutableList.Builder<DomainModel>().addAll(result).build();

	}

	public List<DomainModelLibrary> selectDomainModelLibrary(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZDL::Constructs::DomainModelLibrary"));
		final Collection<DomainModelLibrary> result = Collections2.transform(
				elements, CreateZDLWrapper.create(DomainModelLibrary.class));
		return new ImmutableList.Builder<DomainModelLibrary>().addAll(result)
				.build();

	}

	public List<DomainSpecialization> selectDomainSpecialization(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZDL::Constructs::DomainSpecialization"));
		final Collection<DomainSpecialization> result = Collections2.transform(
				elements, CreateZDLWrapper.create(DomainSpecialization.class));
		return new ImmutableList.Builder<DomainSpecialization>().addAll(result)
				.build();

	}

	public List<DomainConstraint> selectDomainConstraint(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZDL::Validation::DomainConstraint"));
		final Collection<DomainConstraint> result = Collections2.transform(
				elements, CreateZDLWrapper.create(DomainConstraint.class));
		return new ImmutableList.Builder<DomainConstraint>().addAll(result)
				.build();

	}

	public List<DomainLinkConstraint> selectDomainLinkConstraint(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZDL::Validation::DomainLinkConstraint"));
		final Collection<DomainLinkConstraint> result = Collections2.transform(
				elements, CreateZDLWrapper.create(DomainLinkConstraint.class));
		return new ImmutableList.Builder<DomainLinkConstraint>().addAll(result)
				.build();

	}

	public List<ExternalDomainConstraint> selectExternalDomainConstraint(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZDL::Validation::ExternalDomainConstraint"));
		final Collection<ExternalDomainConstraint> result = Collections2
				.transform(elements,
						CreateZDLWrapper.create(ExternalDomainConstraint.class));
		return new ImmutableList.Builder<ExternalDomainConstraint>().addAll(
				result).build();

	}

	public List<DomainCreateLinkConstraint> selectDomainCreateLinkConstraint(
			org.eclipse.uml2.uml.Package pkg) {
		final Collection<PackageableElement> elements = Collections2.filter(pkg
				.getPackagedElements(), new IsZDLConcept(
				"ZDL::Validation::DomainCreateLinkConstraint"));
		final Collection<DomainCreateLinkConstraint> result = Collections2
				.transform(elements, CreateZDLWrapper
						.create(DomainCreateLinkConstraint.class));
		return new ImmutableList.Builder<DomainCreateLinkConstraint>().addAll(
				result).build();

	}

}
