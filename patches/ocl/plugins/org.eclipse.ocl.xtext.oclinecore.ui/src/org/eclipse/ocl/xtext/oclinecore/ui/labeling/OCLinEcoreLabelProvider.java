/*******************************************************************************
 * Copyright (c) 2010, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.oclinecore.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.xtext.basecs.AnnotationCS;
import org.eclipse.ocl.xtext.basecs.AttributeCS;
import org.eclipse.ocl.xtext.basecs.DataTypeCS;
import org.eclipse.ocl.xtext.basecs.DetailCS;
import org.eclipse.ocl.xtext.basecs.EnumerationCS;
import org.eclipse.ocl.xtext.basecs.EnumerationLiteralCS;
import org.eclipse.ocl.xtext.basecs.OperationCS;
import org.eclipse.ocl.xtext.basecs.PackageCS;
import org.eclipse.ocl.xtext.basecs.ParameterCS;
import org.eclipse.ocl.xtext.basecs.ReferenceCS;
import org.eclipse.ocl.xtext.basecs.RootPackageCS;
import org.eclipse.ocl.xtext.basecs.StructuredClassCS;
import org.eclipse.ocl.xtext.basecs.TypeParameterCS;
import org.eclipse.ocl.xtext.basecs.TypeRefCS;
import org.eclipse.ocl.xtext.essentialocl.ui.labeling.EssentialOCLLabelProvider;
import org.eclipse.ocl.xtext.oclinecorecs.OCLinEcoreConstraintCS;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

import com.google.inject.Inject;

/**
 * Provides labels for OCLinEcoreCS objects.
 *
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class OCLinEcoreLabelProvider extends EssentialOCLLabelProvider {

	@Inject
	public OCLinEcoreLabelProvider(@NonNull AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

/*	public String text(AnnotationCS ele) {
		StringBuilder s = new StringBuilder();
//		String idName = ele.getIdSource();
//		if (idName != null) {
//			appendString(s, idName);
//		}
//		else {
			s.append("\"");
			appendString(s, ele.getName());
			s.append("\"");
//		}
		return s.toString();
	} */

	protected String image(AnnotationCS ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EAnnotation.gif";
	}

	protected String image(AttributeCS ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EAttribute.gif";
	}

	protected String image(StructuredClassCS ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EClass.gif";
	}

	protected String image(OCLinEcoreConstraintCS ele) {
		String stereotype = ele.getStereotype();
		if (PivotConstants.BODY_NAME.equals(stereotype)) {
			return "/org.eclipse.ocl.xtext.oclinecore.ui/icons/full/obj16/DefinitionConstraint.gif";
		}
		else if (PivotConstants.DERIVATION_NAME.equals(stereotype)) {
			return "/org.eclipse.ocl.xtext.oclinecore.ui/icons/full/obj16/DerivationConstraint.gif";
		}
		else if (PivotConstants.INITIAL_NAME.equals(stereotype)) {
			return "/org.eclipse.ocl.xtext.oclinecore.ui/icons/full/obj16/InitialConstraint.gif";
		}
		else if (PivotConstants.INVARIANT_NAME.equals(stereotype)) {
			return "/org.eclipse.ocl.xtext.oclinecore.ui/icons/full/obj16/InvariantConstraint.gif";
		}
		else if (PivotConstants.POSTCONDITION_NAME.equals(stereotype)) {
			return "/org.eclipse.ocl.xtext.oclinecore.ui/icons/full/obj16/PostconditionConstraint.gif";
		}
		else if (PivotConstants.PRECONDITION_NAME.equals(stereotype)) {
			return "/org.eclipse.ocl.xtext.oclinecore.ui/icons/full/obj16/PreconditionConstraint.gif";
		}
		return "/org.eclipse.ocl.edit/icons/full/obj16/Constraint.gif";
	}

	public String text(OCLinEcoreConstraintCS ele) {
		StringBuilder s = new StringBuilder();
		s.append("<");
		appendString(s, ele.getStereotype());
		s.append("> ");
		appendOptionalName(s, ele);
		return s.toString();
	}

	protected String image(DataTypeCS ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EDataType.gif";
	}

	protected String image(DetailCS ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EStringToStringMapEntry.gif";
	}

//	public String text(DocumentationCS ele) {
//		return "documentation";
//	}

	protected String image(EnumerationCS ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EEnum.gif";
	}

	protected String image(EnumerationLiteralCS ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EEnumLiteral.gif";
	}

	protected String image(OperationCS ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EOperation.gif";
	}

	protected String image(PackageCS ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EPackage.gif";
	}

	protected String image(ParameterCS ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EParameter.gif";
	}

	protected String image(ReferenceCS ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EReference.gif";
	}

//	protected String image(ReferenceCSRef ele) {
//		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EReference.gif";
//	}

	public String text(RootPackageCS ele) {
		return "OCL in Ecore document";
	}

	protected String image(RootPackageCS ele) {
		return "OCLModelFile.gif";
	}

	protected String image(TypeParameterCS ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/ETypeParameter.gif";
	}

	protected String image(TypeRefCS ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EGenericType.gif";
	}

	public String text(TypeRefCS ele) {
		ICompositeNode node = NodeModelUtils.getNode(ele);
		return NodeModelUtils.getTokenText(node);
	}
}
