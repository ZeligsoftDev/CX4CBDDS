/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 * 	 E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
 *******************************************************************************/
package org.eclipse.ocl.xtext.oclinecore.as2cs;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Annotation;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.internal.utilities.AbstractConversion.Predicate;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.xtext.base.as2cs.AS2CSConversion;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.basecs.DetailCS;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.ImportCS;
import org.eclipse.ocl.xtext.basecs.PackageCS;
import org.eclipse.ocl.xtext.essentialocl.as2cs.EssentialOCLDeclarationVisitor;
import org.eclipse.ocl.xtext.oclinecorecs.OCLinEcoreCSPackage;
import org.eclipse.ocl.xtext.oclinecorecs.OCLinEcoreConstraintCS;
import org.eclipse.ocl.xtext.oclinecorecs.SysMLCS;
import org.eclipse.ocl.xtext.oclinecorecs.TopLevelCS;

public class OCLinEcoreDeclarationVisitor extends EssentialOCLDeclarationVisitor
{
	private static final @NonNull Predicate<org.eclipse.ocl.pivot.Package> nonImplicitPackageFilter =
			new Predicate<org.eclipse.ocl.pivot.Package>()
	{
		@Override
		public boolean filter(org.eclipse.ocl.pivot.@NonNull Package asPackage) {
			return !PivotUtilInternal.isImplicitPackage(asPackage);
		}
	};

	public OCLinEcoreDeclarationVisitor(@NonNull AS2CSConversion context) {
		super(context);
	}

	@Override
	public void postProcess(@NonNull BaseCSResource csResource, @NonNull Map<@NonNull Namespace, @NonNull List<@NonNull String>> importedNamespaces) {
		EObject eObject = csResource.getContents().get(0);
		if (eObject instanceof TopLevelCS) {
			context.createImports((TopLevelCS) eObject, importedNamespaces);
		}
	}

	@Override
	public ElementCS visitAnnotation(@NonNull Annotation object) {
		if (PivotConstants.SYSML_ANNOTATION_SOURCE.equals(object.getName())) {
			SysMLCS csElement = context.refreshElement(SysMLCS.class, OCLinEcoreCSPackage.Literals.SYS_MLCS, object);
			//			context.refreshList(csElement.getOwnedAnnotation(), context.visitDeclarations(AnnotationCS.class, object.getOwnedAnnotation(), null));
			context.refreshList(csElement.getOwnedDetails(), context.visitDeclarations(DetailCS.class, object.getOwnedDetails(), null));
			return csElement;
		}
		else {
			return super.visitAnnotation(object);
		}
	}

	@Override
	public ElementCS visitConstraint(@NonNull Constraint object) {
		OCLinEcoreConstraintCS csElement;
		if (!"".equals(object.getName())) {
			csElement = context.refreshNamedElement(OCLinEcoreConstraintCS.class, OCLinEcoreCSPackage.Literals.OC_LIN_ECORE_CONSTRAINT_CS, object);
		}
		else {
			csElement = context.refreshElement(OCLinEcoreConstraintCS.class, OCLinEcoreCSPackage.Literals.OC_LIN_ECORE_CONSTRAINT_CS, object);
			csElement.setName(null);
		}
		csElement.setIsCallable(object.isIsCallable());
		refreshConstraint(csElement, object);
		return csElement;
	}

	@Override
	public ElementCS visitModel(@NonNull Model object) {
		TopLevelCS csElement = context.refreshElement(TopLevelCS.class, OCLinEcoreCSPackage.Literals.TOP_LEVEL_CS, object);
		context.refreshList(csElement.getOwnedPackages(), context.visitDeclarations(PackageCS.class, object.getOwnedPackages(), nonImplicitPackageFilter ));
		context.visitDeclarations(ImportCS.class, object.getOwnedImports(), null);
		return csElement;
	}
}