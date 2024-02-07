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
package org.eclipse.ocl.xtext.completeocl.ui.labeling;

import java.util.List;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.basecs.ParameterCS;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;
import org.eclipse.ocl.xtext.completeoclcs.ClassifierContextDeclCS;
import org.eclipse.ocl.xtext.completeoclcs.CompleteOCLDocumentCS;
import org.eclipse.ocl.xtext.completeoclcs.DefCS;
import org.eclipse.ocl.xtext.completeoclcs.DefOperationCS;
import org.eclipse.ocl.xtext.completeoclcs.DefPropertyCS;
import org.eclipse.ocl.xtext.completeoclcs.OperationContextDeclCS;
import org.eclipse.ocl.xtext.completeoclcs.PackageDeclarationCS;
import org.eclipse.ocl.xtext.completeoclcs.PropertyContextDeclCS;
import org.eclipse.ocl.xtext.essentialocl.ui.labeling.EssentialOCLLabelProvider;

import com.google.inject.Inject;

/**
 * Provides labels for CompleteOCLCS objects.
 *
 * see
 * http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class CompleteOCLLabelProvider extends EssentialOCLLabelProvider
{
	@Inject
	public CompleteOCLLabelProvider(@NonNull AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

//	protected String image(BodyCS ele) {
//		return "/org.eclipse.ocl.xtext.oclinecore.ui/icons/full/obj16/DefinitionConstraint.gif";
//	}

//	protected String text(BodyCS ele) {
//		String name = ele.getName();
//		return name != null ? "body " + name : "body";
//	}

	protected String image(ClassifierContextDeclCS ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/Class.gif";
	}

	protected String text(ClassifierContextDeclCS ele) {
		org.eclipse.ocl.pivot.Class classifier = ele.getReferredClass();
		if (classifier == null) {
			return "<<null>>";
		}
		if (classifier.eIsProxy()) {
			return "<<unresolved-proxy>>";
		}
		return classifier.getName();
	}

	protected String image(CompleteOCLDocumentCS ele) {
		return "/org.eclipse.ocl.xtext.completeocl.ui/icons/OCLModelFile.gif";
	}

	protected String text(CompleteOCLDocumentCS ele) {
		Model root = PivotUtil.getPivot(Model.class, ele);
		return root != null ? String.valueOf(root.getName()) : "null";
	}

	protected String image(DefCS ele) {
		return "/org.eclipse.ocl.xtext.oclinecore.ui/icons/full/obj16/DefinitionConstraint.gif";
	}

	protected String text(DefCS ele) {
		StringBuilder s = new StringBuilder();
		s.append("def ");
		appendOptionalString(s, ele.getName());
		s.append(": ");
/*		appendString(s, ele.getConstrainedName());
		List<ParameterCS> parameters = ele.getParameters();
		if (!parameters.isEmpty()) {
			s.append("(");
			String prefix = "";
			for (ParameterCS csParameter : parameters) {
				s.append(prefix);
//				appendName(s, csVariable);
//				s.append(" : ");
				appendType(s, csParameter.getOwnedType());
				prefix = ", ";
			}
			s.append(")");
		}
		s.append(" : ");
		appendType(s, ele.getOwnedType()); */
		return s.toString();
	}

	protected String text(DefOperationCS ele) {
		StringBuilder s = new StringBuilder();
		appendString(s, ele.getName());
		List<ParameterCS> parameters = ele.getOwnedParameters();
		if (!parameters.isEmpty()) {
			s.append("(");
			String prefix = "";
			for (ParameterCS csParameter : parameters) {
				s.append(prefix);
//				appendName(s, csVariable);
//				s.append(" : ");
				appendType(s, csParameter.getOwnedType());
				prefix = ", ";
			}
			s.append(")");
		}
		s.append(" : ");
		TypedRefCS ownedType = ele.getOwnedType();
		if (ownedType != null) {
			appendType(s, ownedType);
		}
		return s.toString();
	}

	protected String text(DefPropertyCS ele) {
		StringBuilder s = new StringBuilder();
		appendString(s, ele.getName());
		s.append(" : ");
		appendType(s, ele.getOwnedType());
		return s.toString();
	}

//	protected String image(DerCS ele) {
//		return "/org.eclipse.ocl.xtext.oclinecore.ui/icons/full/obj16/DerivationConstraint.gif";
//	}

//	protected String text(DerCS ele) {
//		return "derive";
//	}

//	protected String image(InitCS ele) {
//		return "/org.eclipse.ocl.xtext.oclinecore.ui/icons/full/obj16/InitialConstraint.gif";
//	}

//	protected String text(InitCS ele) {
//		return "init";
//	}

//	protected String image(InvCS ele) {
//		return "/org.eclipse.ocl.xtext.oclinecore.ui/icons/full/obj16/InvariantConstraint.gif";
//	}

//	protected String text(InvCS ele) {
//		String name = ele.getName();
//		return name != null ? "inv " + name : "inv";
//	}

	protected String image(OperationContextDeclCS ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/Operation.gif";
	}

	protected String text(OperationContextDeclCS ele) {
		StringBuilder s = new StringBuilder();
		Operation operation = ele.getReferredOperation();
		if (operation == null) {
			return "<<null>>";
		}
		if (operation.eIsProxy()) {
			return "<<unresolved-proxy>>";
		}
		appendName(s, operation.getOwningClass());
		s.append("::");
		appendName(s, operation);
		s.append("(");
		String prefix = "";
		for (Parameter parameter : operation.getOwnedParameters()) {
			s.append(prefix);
//			appendName(s, csParameter);
//			s.append(" : ");
			appendType(s, parameter.getType());
			prefix = ", ";
		}
		s.append(")");
		s.append(" : ");
		appendType(s, operation.getType());
		return s.toString();
	}

	protected String image(PackageDeclarationCS ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/Package.gif";
	}

	protected String text(PackageDeclarationCS csElement) {
		assert csElement != null;
		Element asElement = csElement.getReferredPackage();
		if (asElement == null) {
			asElement = PivotUtil.getPivot(Element.class, csElement);
		}
		if (asElement != null) {
			return String.valueOf(doGetText(asElement));
		}
		else {
			return "<<null>>";
		}
	}

//	protected String image(PostCS ele) {
//		return "/org.eclipse.ocl.xtext.oclinecore.ui/icons/full/obj16/PostconditionConstraint.gif";
//	}

//	protected String text(PostCS ele) {
//		String name = ele.getName();
//		return name != null ? "post " + name : "post";
//	}

//	protected String image(PreCS ele) {
//		return "/org.eclipse.ocl.xtext.oclinecore.ui/icons/full/obj16/PreconditionConstraint.gif";
//	}

//	protected String text(PreCS ele) {
//		String name = ele.getName();
//		return name != null ? "pre " + name : "pre";
//	}

	protected String image(PropertyContextDeclCS ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/Property.gif";
	}

	protected String text(PropertyContextDeclCS ele) {
		StringBuilder s = new StringBuilder();
		Property feature = ele.getReferredProperty();
		if (feature == null) {
			return "<<null>>";
		}
		if (feature.eIsProxy()) {
			return "<<unresolved-proxy>>";
		}
		appendName(s, feature.getOwningClass());
		s.append("::");
		appendName(s, feature);
		s.append(" : ");
		appendType(s, feature.getType());
		return s.toString();
	}
}
