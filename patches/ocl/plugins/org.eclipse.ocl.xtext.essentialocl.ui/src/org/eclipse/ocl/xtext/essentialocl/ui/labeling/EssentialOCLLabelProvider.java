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
package org.eclipse.ocl.xtext.essentialocl.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.xtext.base.ui.labeling.BaseLabelProvider;
import org.eclipse.ocl.xtext.basecs.TemplateParameterCS;
import org.eclipse.ocl.xtext.basecs.TuplePartCS;
import org.eclipse.ocl.xtext.basecs.TupleTypeCS;
import org.eclipse.ocl.xtext.essentialoclcs.BooleanLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionTypeCS;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.InvalidLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS;
import org.eclipse.ocl.xtext.essentialoclcs.NestedExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NullLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NumberLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.OperatorExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.SelfExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.StringLiteralExpCS;

import com.google.inject.Inject;

/**
 * Provides labels for EssentialOCL CS objects.
 * <p>
 * The outline normally displays the result of CST to AST redirection using the
 * labels defined by BaseLabelProvider. However when there are syntax errors there
 * is no AST and so CST labels are used.
 */
public class EssentialOCLLabelProvider extends BaseLabelProvider
{
	@Inject
	public EssentialOCLLabelProvider(@NonNull AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	protected void appendTemplateParameter(@NonNull StringBuilder s, TemplateParameterCS templateParameter) {
		appendName(s, templateParameter);
	}

	@Override
	protected void appendType(@NonNull StringBuilder s, Type type) {
		if (type instanceof CollectionTypeCS) {
			appendName(s, (CollectionTypeCS)type);
			s.append("(");
			appendType(s, ((CollectionTypeCS)type).getOwnedType());
			s.append(")");
		}
		else if (type instanceof TupleTypeCS) {
			appendName(s, (TupleTypeCS)type);
			s.append("Tuple(");
			String prefix = "";
			for (TuplePartCS part : ((TupleTypeCS)type).getOwnedParts()) {
				s.append(prefix);
				appendName(s, part);
				s.append(" : ");
				appendType(s, part.getOwnedType());
				prefix = ", ";
			}
			s.append(")");
		}
		else if (type instanceof NameExpCS) {
//			appendName(s, ((NameExpCS)type).getNamedElement());
		}
		else {
			super.appendType(s, type);
		}
	}

/*	protected String text(InfixExpCS ele) {
		String op = ele.getOp();
		if (!".".equals(op) &&  !"->".equals(op)) {
			return op;
		}
	StringBuilder s = new StringBuilder();
	appendString(s, op);
	ExpCS argument = ele.getArgument();
	if (argument instanceof NamedExpCS) {
		s.append(" ");
		appendName(s, ((NamedExpCS)argument).getName().getNamedElement());
		if (((NamedExpCS) argument).isPre()) {
			s.append(" @pre");
		}
	}
	return s.toString();
	} */

	protected String text(BooleanLiteralExpCS ele) {
		return String.valueOf(ele.getSymbol());
	}

	protected String text(ExpCS ele) {
		return "<<" + ele.eClass().getName() + ">>";
	}

	protected String text(InvalidLiteralExpCS ele) {
		return "invalid";
	}

	protected String text(NameExpCS ele) {
		return String.valueOf(ele.getOwnedPathName().toString());
	}

	protected String text(NavigatingArgCS ele) {
		return "<" + String.valueOf(ele.getRole()).toLowerCase() + ">";
	}

	protected String text(NestedExpCS ele) {
		return "(   )";
	}

	protected String text(NullLiteralExpCS ele) {
		return "null";
	}

	protected String text(NumberLiteralExpCS ele) {
		return String.valueOf(ele.getSymbol());
	}

	protected String image(OperatorExpCS ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/OperationCallExp.gif";
	}

	protected String text(OperatorExpCS ele) {
		return String.valueOf(ele.getName());
	}

	protected String image(SelfExpCS ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/VariableExp.gif";
	}

	protected String text(SelfExpCS ele) {
		return PivotConstants.SELF_NAME;
	}

	protected String text(StringLiteralExpCS ele) {
		return String.valueOf(ele.getSegments());
	}

}
