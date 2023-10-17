/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.as2cs;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.TemplateBinding;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.WildcardType;
import org.eclipse.ocl.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.basecs.BaseCSFactory;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.PathElementCS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.PrimitiveTypeRefCS;
import org.eclipse.ocl.xtext.basecs.TemplateBindingCS;
import org.eclipse.ocl.xtext.basecs.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.xtext.basecs.TypeRefCS;
import org.eclipse.ocl.xtext.basecs.TypedTypeRefCS;
import org.eclipse.ocl.xtext.basecs.WildcardTypeRefCS;

public class BaseReferenceVisitor extends AbstractExtendingVisitor<ElementCS, AS2CSConversion>
{
	public static final Logger logger = LogManager.getLogger(BaseReferenceVisitor.class);

	public BaseReferenceVisitor(@NonNull AS2CSConversion context) {
		super(context);		// NB this class is stateless since separate instances exist per CS package
	}

	@Override
	public ElementCS visitClass(org.eclipse.ocl.pivot.@NonNull Class object) {
		org.eclipse.ocl.pivot.Class scopeClass = context.getScope();
		org.eclipse.ocl.pivot.Package scopePackage = scopeClass != null ? PivotUtil.getPackage(scopeClass) : null;
		TypedTypeRefCS csRef = BaseCSFactory.eINSTANCE.createTypedTypeRefCS();
		Type type = PivotUtil.getUnspecializedTemplateableElement(object);
		PathNameCS csPathName = csRef.getOwnedPathName();
		if (csPathName == null) {
			PathNameCS csPathName2 = BaseCSFactory.eINSTANCE.createPathNameCS();
			csPathName = csPathName2;
			csRef.setOwnedPathName(csPathName);
		}
		context.refreshPathName(csPathName, type, context.getScope());
		csRef.setPivot(type);		// FIXME object ??
		if (!(type instanceof PrimitiveType)) {
			org.eclipse.ocl.pivot.Package objectPackage = PivotUtil.getPackage(type);
			if ((objectPackage != null) && (scopePackage != null) && objectPackage.eResource() != scopePackage.eResource()) {
				context.importNamespace(objectPackage, null);
			}
		}
		List<TemplateBinding> templateBindings = object.getOwnedBindings();
		if (templateBindings.isEmpty()) {
		}
		else {
			TemplateBindingCS csTemplateBinding = csRef.getOwnedBinding();
			if (csTemplateBinding == null) {
				csTemplateBinding = BaseCSFactory.eINSTANCE.createTemplateBindingCS();
				csRef.setOwnedBinding(csTemplateBinding);
			}
			List<TemplateParameterSubstitutionCS> csParameterSubstitutions = new ArrayList<TemplateParameterSubstitutionCS>();
			for (TemplateBinding templateBinding : templateBindings) {
				for (TemplateParameterSubstitution templateParameterSubstitution : templateBinding.getOwnedSubstitutions()) {
					Type actual = templateParameterSubstitution.getActual();
					if (actual != null) {
						TemplateParameterSubstitutionCS csTemplateParameterSubstitution = BaseCSFactory.eINSTANCE.createTemplateParameterSubstitutionCS();
						TypeRefCS csParameterable = context.visitReference(TypeRefCS.class, actual, null);
						csTemplateParameterSubstitution.setOwnedActualParameter(csParameterable);
						csParameterSubstitutions.add(csTemplateParameterSubstitution);
						csTemplateParameterSubstitution.setPivot(templateParameterSubstitution);
					}
				}
			}
			context.refreshList(csTemplateBinding.getOwnedSubstitutions(), csParameterSubstitutions);
		}
//		if (scopePackage == objectPackage) {
			return csRef;
//		}
		// FIXME cascade paths wrt import aliases
/*		QualifiedTypeRefCS qRef = BaseCSFactory.eINSTANCE.createQualifiedTypeRefCS();
		qRef.setNamespace(objectPackage);
		qRef.setElement(csRef);
		qRef.setPivot(object);
		return qRef;
*/	}

	@Override
	public ElementCS visitPrimitiveType(@NonNull PrimitiveType object) {
		PrimitiveTypeRefCS csRef = BaseCSFactory.eINSTANCE.createPrimitiveTypeRefCS();
//		Type type = PivotUtil.getUnspecializedTemplateableElement(object);
//		csRef.setType(type);
		csRef.setPivot(object);		// FIXME object ??
		csRef.setName(object.getName());		// FIXME object ??
		return csRef;
	}

	@Override
	public @Nullable ElementCS visitTemplateParameter(@NonNull TemplateParameter object) {
		TypedTypeRefCS csRef = BaseCSFactory.eINSTANCE.createTypedTypeRefCS();
		PathNameCS csPathName = csRef.getOwnedPathName();
		if (csPathName == null) {
			PathNameCS csPathName2 = BaseCSFactory.eINSTANCE.createPathNameCS();
			csPathName = csPathName2;
			csRef.setOwnedPathName(csPathName);
		}
		List<PathElementCS> csPath = csPathName.getOwnedPathElements();
		csPath.clear();		// FIXME re-use
		PathElementCS csSimpleRef = BaseCSFactory.eINSTANCE.createPathElementCS();
		csPath.add(0, csSimpleRef);
		csSimpleRef.setReferredElement(object);
		csRef.setPivot(object);
		return csRef;
	}

	@Override
	public @Nullable ElementCS visitWildcardType(@NonNull WildcardType object) {
		WildcardTypeRefCS csRef = BaseCSFactory.eINSTANCE.createWildcardTypeRefCS();
		csRef.setPivot(object);
		// setSuper/setExtends
		return csRef;
	}

	@Override
	public ElementCS visiting(@NonNull Visitable visitable) {
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for AS2CS Reference pass");
	}
}