package com.zeligsoft.base.zdl.staticapi.ZDL.util;

import java.util.Map;

import com.google.common.collect.Maps;
import com.zeligsoft.base.zdl.staticapi.util.AbstractBaseZDLFactory;

public class ZDLFactoryImpl extends AbstractBaseZDLFactory {
	protected java.util.Map<String, Class<?>> registry = Maps.newHashMap();

	public ZDLFactoryImpl() {
		registry.put(
				"ZDL::Constructs::DomainBlockReference",
				com.zeligsoft.base.zdl.staticapi.Constructs.impl.DomainBlockReferenceImpl.class);
		registry.put(
				"ZDL::Constructs::DomainBlockImport",
				com.zeligsoft.base.zdl.staticapi.Constructs.impl.DomainBlockImportImpl.class);
		registry.put(
				"ZDL::Constructs::DomainBlockMerge",
				com.zeligsoft.base.zdl.staticapi.Constructs.impl.DomainBlockMergeImpl.class);
		registry.put(
				"ZDL::Constructs::DomainGeneralization",
				com.zeligsoft.base.zdl.staticapi.Constructs.impl.DomainGeneralizationImpl.class);
		registry.put(
				"ZDL::Constructs::DomainInstantiation",
				com.zeligsoft.base.zdl.staticapi.Constructs.impl.DomainInstantiationImpl.class);
		registry.put(
				"ZDL::Constructs::DomainModelLibraryReference",
				com.zeligsoft.base.zdl.staticapi.Constructs.impl.DomainModelLibraryReferenceImpl.class);
		registry.put(
				"ZDL::Constructs::DomainBlock",
				com.zeligsoft.base.zdl.staticapi.Constructs.impl.DomainBlockImpl.class);
		registry.put(
				"ZDL::Constructs::DomainConcept",
				com.zeligsoft.base.zdl.staticapi.Constructs.impl.DomainConceptImpl.class);
		registry.put(
				"ZDL::Constructs::DomainDataType",
				com.zeligsoft.base.zdl.staticapi.Constructs.impl.DomainDataTypeImpl.class);
		registry.put(
				"ZDL::Constructs::DomainEnum",
				com.zeligsoft.base.zdl.staticapi.Constructs.impl.DomainEnumImpl.class);
		registry.put(
				"ZDL::Constructs::DomainAttribute",
				com.zeligsoft.base.zdl.staticapi.Constructs.impl.DomainAttributeImpl.class);
		registry.put(
				"ZDL::Constructs::DomainReference",
				com.zeligsoft.base.zdl.staticapi.Constructs.impl.DomainReferenceImpl.class);
		registry.put(
				"ZDL::Constructs::DomainEnumLiteral",
				com.zeligsoft.base.zdl.staticapi.Constructs.impl.DomainEnumLiteralImpl.class);
		registry.put(
				"ZDL::Constructs::DomainPackage",
				com.zeligsoft.base.zdl.staticapi.Constructs.impl.DomainPackageImpl.class);
		registry.put(
				"ZDL::Constructs::DomainModel",
				com.zeligsoft.base.zdl.staticapi.Constructs.impl.DomainModelImpl.class);
		registry.put(
				"ZDL::Constructs::DomainModelLibrary",
				com.zeligsoft.base.zdl.staticapi.Constructs.impl.DomainModelLibraryImpl.class);
		registry.put(
				"ZDL::Constructs::DomainSpecialization",
				com.zeligsoft.base.zdl.staticapi.Constructs.impl.DomainSpecializationImpl.class);
		registry.put(
				"ZDL::Validation::DomainConstraint",
				com.zeligsoft.base.zdl.staticapi.Validation.impl.DomainConstraintImpl.class);
		registry.put(
				"ZDL::Validation::DomainLinkConstraint",
				com.zeligsoft.base.zdl.staticapi.Validation.impl.DomainLinkConstraintImpl.class);
		registry.put(
				"ZDL::Validation::ExternalDomainConstraint",
				com.zeligsoft.base.zdl.staticapi.Validation.impl.ExternalDomainConstraintImpl.class);
		registry.put(
				"ZDL::Validation::DomainCreateLinkConstraint",
				com.zeligsoft.base.zdl.staticapi.Validation.impl.DomainCreateLinkConstraintImpl.class);
	}

	@Override
	protected Map<String, Class<?>> getRegistry() {
		return registry;
	}
}
