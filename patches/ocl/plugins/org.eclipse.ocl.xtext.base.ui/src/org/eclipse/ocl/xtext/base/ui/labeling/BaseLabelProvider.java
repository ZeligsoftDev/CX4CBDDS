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
package org.eclipse.ocl.xtext.base.ui.labeling;

import java.net.URL;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ocl.pivot.Annotation;
import org.eclipse.ocl.pivot.AnyType;
import org.eclipse.ocl.pivot.AssociationClassCallExp;
import org.eclipse.ocl.pivot.BagType;
import org.eclipse.ocl.pivot.BooleanLiteralExp;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.CollectionItem;
import org.eclipse.ocl.pivot.CollectionLiteralExp;
import org.eclipse.ocl.pivot.CollectionLiteralPart;
import org.eclipse.ocl.pivot.CollectionRange;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Detail;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.EnumLiteralExp;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.IntegerLiteralExp;
import org.eclipse.ocl.pivot.InvalidLiteralExp;
import org.eclipse.ocl.pivot.InvalidType;
import org.eclipse.ocl.pivot.IterateExp;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.IteratorExp;
import org.eclipse.ocl.pivot.LambdaType;
import org.eclipse.ocl.pivot.LetExp;
import org.eclipse.ocl.pivot.LiteralExp;
import org.eclipse.ocl.pivot.LoopExp;
import org.eclipse.ocl.pivot.MessageExp;
import org.eclipse.ocl.pivot.MessageType;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.NullLiteralExp;
import org.eclipse.ocl.pivot.NumericLiteralExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.pivot.OrderedSetType;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Precedence;
import org.eclipse.ocl.pivot.PrimitiveLiteralExp;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.RealLiteralExp;
import org.eclipse.ocl.pivot.SequenceType;
import org.eclipse.ocl.pivot.SetType;
import org.eclipse.ocl.pivot.StateExp;
import org.eclipse.ocl.pivot.StringLiteralExp;
import org.eclipse.ocl.pivot.TemplateBinding;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.TupleLiteralExp;
import org.eclipse.ocl.pivot.TupleLiteralPart;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypeExp;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.VoidType;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.ocl.pivot.internal.utilities.AS2Moniker;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.basecs.NamedElementCS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.PivotableElementCS;
import org.eclipse.ocl.xtext.basecs.TypeRefCS;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;

import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 *
 * see http://www.eclipse.org/Xtext/documentation.html#labelProvider
 */
public class BaseLabelProvider extends org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider
{
	@Inject
	public BaseLabelProvider(@NonNull AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	protected void appendClass(@NonNull StringBuilder s, Object object) {
		s.append("<");
		s.append(object != null ? object.getClass().getSimpleName() : "null");
		s.append(">");
	}

	protected void appendMultiplicity(@NonNull StringBuilder s, @NonNull TypedElement ele) {
		Type type = ele.getType();
		if (type != null) {
			if (!ele.isIsRequired()) {
				s.append("[?]");
			}
			else if (!(type instanceof CollectionType)) {
				s.append("[1]");
			}
		}
	}

	protected void appendName(@NonNull StringBuilder s, NamedElement element) {
		if (element != null) {
			if (element.eIsProxy()) {
				EcoreUtil.resolve(element, element);
			}
			appendString(s, NameUtil.getSafeName(element));
		}
	}

	protected void appendName(@NonNull StringBuilder s, NamedElementCS csElement) {
		if (csElement != null) {
			if (csElement.eIsProxy()) {
				EcoreUtil.resolve(csElement, csElement);
			}
			appendString(s, NameUtil.getSafeName(csElement));
		}
	}

	protected void appendName(@NonNull StringBuilder s, Nameable csElement) {
		appendString(s, csElement.getName());
	}

	protected void appendNavigationOperator(@NonNull StringBuilder s, @NonNull CallExp ele) {
		OCLExpression source = ele.getOwnedSource();
		if (source == null) {
			return;
		}
		Type sourceType = source.getType();
		if (sourceType == null) {
			return;
		}
		s.append(PivotUtil.getNavigationOperator(ele.isIsSafe(), PivotUtil.isAggregate(sourceType)));
		s.append(" ");
	}

	protected void appendOptionalName(@NonNull StringBuilder s, Nameable csElement) {
		if (csElement != null) {
			appendOptionalString(s, csElement.getName());
		}
	}

	protected void appendOptionalString(@NonNull StringBuilder s, String string) {
		if (string != null) {
			s.append(string);
		}
	}

	protected void appendParameters(@NonNull StringBuilder s, List<Parameter> parameters) {
		s.append("(");
		String prefix = "";
		for (Parameter csParameter : parameters) {
			s.append(prefix);
			appendType(s, csParameter.getType());
			appendMultiplicity(s, csParameter);
			prefix = ", ";
		}
		s.append(")");
	}

	protected void appendString(@NonNull StringBuilder s, String string) {
		if (string != null) {
			s.append(string);
		}
		else {
			s.append("<null>");
		}
	}

	protected void appendPathName(StringBuilder s, PathNameCS pathName) {
		s.append(pathName.toString());
	}

	protected void appendString(@NonNull StringBuilder s, String string, int countLimit) {
		if (string == null) {
			s.append("<null>");
		}
		else if (string.length() > countLimit){
			s.append(string.substring(0, countLimit-3));
			s.append("...");
		}
		else {
			s.append(string);
		}
	}

	protected void appendSuperTypes(@NonNull StringBuilder s, List<? extends Type> superTypes) {
		if (!superTypes.isEmpty()) {
			String prefix = " -> ";
			for (Type superType : superTypes) {
				s.append(prefix);
				appendType(s, superType);
				prefix = ", ";
			}
		}
	}

	protected void appendTemplateBindings(@NonNull StringBuilder s, TemplateableElement templateableElement) {
		if (templateableElement != null) {
			for (TemplateBinding templateBinding : templateableElement.getOwnedBindings()) {
				s.append("(");
				String prefix = "";
				for (TemplateParameterSubstitution templateParameterSubstitution : templateBinding.getOwnedSubstitutions()) {
					s.append(prefix);
					Type actual = templateParameterSubstitution.getActual();
					appendType(s, actual);
					prefix = ", ";
				}
				s.append(")");
			}
		}
	}

	protected void appendTemplateSignature(@NonNull StringBuilder s, TemplateableElement templateableElement) {
		if (templateableElement != null) {
			TemplateSignature templateSignature = templateableElement.getOwnedSignature();
			if (templateSignature != null) {
				s.append("(");
				Collection<TemplateParameter> templateParameters = templateSignature.getOwnedParameters();
				if (!templateParameters.isEmpty()) {
					String prefix = "";
					for (TemplateParameter templateParameter : templateParameters) {
						s.append(prefix);
						appendName(s, templateParameter);
						prefix = ", ";
					}
				}
				s.append(")");
			}
		}
	}

	protected void appendType(@NonNull StringBuilder s, Type type) {
		appendName(s, type);
		if (type instanceof TemplateableElement) {
			appendTemplateBindings(s, (TemplateableElement)type);
		}
	}

	protected void appendType(@NonNull StringBuilder s, TypeRefCS type) {
		Element pivot = type.getPivot();
		appendString(s, safeGetMoniker(pivot));
	}

	@Override
	protected Image convertToImage(Object imageDescription) {
		if (imageDescription instanceof String) {
			String imagePath = (String)imageDescription;
			if (imagePath.startsWith("/")) {
				int index = imagePath.indexOf('/', 1);
				if (index > 1) {
					String bundlePath = imagePath.substring(1, index);
					Bundle bundle = Platform.getBundle(bundlePath);
					if (bundle != null) {
						String imageFile = imagePath.substring(index+1);
						Path path = new Path(imageFile);
						URL imgUrl = FileLocator.find(bundle, path, null);
						if (imgUrl != null) {
							return super.convertToImage(ImageDescriptor.createFromURL(imgUrl));
						}
					}
				}
			}
		}
		return super.convertToImage(imageDescription);
	}

	@Override
	protected Object doGetText(Object element) {
		Object object = super.doGetText(element);
		if (object instanceof String) {
			String text = (String)object;
			int index = text.indexOf('\n');
			if (index >= 0) {
				text = text.substring(0, index);
			}
			object = text.trim();
		}
		return object;
	}

	protected String safeGetMoniker(Element element) {
		if (element == null) {
			return "<null-element>";
		}
		else if (element.eIsProxy()) {
			return "<unresolved-proxy>";
		}
		else {
			return AS2Moniker.toString(element);
		}
	}

	protected String text(Element ele) {
		return "<" + ele.getClass().getSimpleName() + ">";
	}

	protected String image(Annotation ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EAnnotation.gif";
	}

	public String text(Annotation ele) {
		StringBuilder s = new StringBuilder();
		s.append("\"");
		appendString(s, ele.getName(), 40);
		s.append("\"");
		return s.toString();
	}

	protected String image(AnyType ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/AnyType.gif";
	}

	protected String image(AssociationClassCallExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/AssociationClassCallExp.gif";
	}

	protected String image(BagType ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/BagType.gif";
	}

	protected String image(BooleanLiteralExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/BooleanLiteralExp.gif";
	}

	protected String image(org.eclipse.ocl.pivot.Class ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/Class.gif";
	}

	protected String text(org.eclipse.ocl.pivot.Class ele) {
		StringBuilder s = new StringBuilder();
		appendName(s, ele);
		appendTemplateSignature(s, ele);
		appendSuperTypes(s, ele.getSuperClasses());
		return s.toString();
	}

	protected String image(CollectionItem ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/CollectionItem.gif";
	}

	protected String image(CollectionLiteralExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/CollectionLiteralExp.gif";
	}

	protected String image(CollectionLiteralPart ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/CollectionLiteralPart.gif";
	}

//	protected String text(CollectionLiteralPart ele) {
//		return null;
//	}

	protected String image(CollectionRange ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/CollectionRange.gif";
	}

	protected String image(CollectionType ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/CollectionType.gif";
	}

	protected String text(CollectionType ele) {
		StringBuilder s = new StringBuilder();
		appendType(s, ele);
		appendTemplateSignature(s, ele);
		appendSuperTypes(s, ele.getSuperClasses());
		return s.toString();
	}

	protected String image(Comment ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/Comment.gif";
	}

	public String text(Comment ele) {
		StringBuilder s = new StringBuilder();
		s.append("\"");
		appendString(s, ele.getBody(), 40);
		s.append("\"");
		return s.toString();
	}

//	protected String image(Constraint ele) {
//		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/Constraint.gif";
//	}
	protected String image(Constraint ele) {
		EStructuralFeature eContainingFeature = ele.eContainingFeature();
		if (eContainingFeature == PivotPackage.Literals.OPERATION__BODY_EXPRESSION) {
			return "/org.eclipse.ocl.xtext.oclinecore.ui/icons/full/obj16/DefinitionConstraint.gif";
		}
		else if (eContainingFeature == PivotPackage.Literals.PROPERTY__OWNED_EXPRESSION) {
			return "/org.eclipse.ocl.xtext.oclinecore.ui/icons/full/obj16/DerivationConstraint.gif";
		}
	//	else if (UMLReflection.INITIAL.equals(stereotype)) {
	//		return "/org.eclipse.ocl.xtext.oclinecore.ui/icons/full/obj16/InitialConstraint.gif";
	//	}
		else if (eContainingFeature == PivotPackage.Literals.CLASS__OWNED_INVARIANTS) {
			return "/org.eclipse.ocl.xtext.oclinecore.ui/icons/full/obj16/InvariantConstraint.gif";
		}
		else if (eContainingFeature == PivotPackage.Literals.OPERATION__OWNED_POSTCONDITIONS) {
			return "/org.eclipse.ocl.xtext.oclinecore.ui/icons/full/obj16/PostconditionConstraint.gif";
		}
		else if (eContainingFeature == PivotPackage.Literals.OPERATION__OWNED_PRECONDITIONS) {
			return "/org.eclipse.ocl.xtext.oclinecore.ui/icons/full/obj16/PreconditionConstraint.gif";
		}
		return "/org.eclipse.ocl.edit/icons/full/obj16/Constraint.gif";
	}

	public String text(Constraint ele) {
		StringBuilder s = new StringBuilder();
		s.append("<");
		appendString(s, ele != null ? PivotUtilInternal.getStereotype(ele) : "null");
		s.append("> ");
		String name = ele != null ? ele.getName() : null;
		if (name != null) {
			s.append(name);
		}
		return s.toString();
	}

	protected String text(DataType ele) {
		StringBuilder s = new StringBuilder();
		appendName(s, ele);
		appendTemplateSignature(s, ele);
		appendSuperTypes(s, ele.getSuperClasses());
		String instance = ele.getInstanceClassName();
		if (instance != null) {
			s.append(" [");
			s.append(instance);
			s.append("]");
		}
		return s.toString();
	}

	protected String image(EnumLiteralExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/EnumLiteralExp.gif";
	}

	protected String text(org.eclipse.ocl.pivot.Enumeration ele) {
		StringBuilder s = new StringBuilder();
		appendName(s, ele);
		appendTemplateSignature(s, ele);
		appendSuperTypes(s, ele.getSuperClasses());
		String instance = ele.getInstanceClassName();
		if (instance != null) {
			s.append(" [");
			s.append(instance);
			s.append("]");
		}
		return s.toString();
	}

	protected String image(Detail ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EStringToStringMapEntry.gif";
	}

	public String text(Detail ele) {
		StringBuilder s = new StringBuilder();
		s.append("\"");
		appendString(s, ele.getName());
		s.append("\" : ");
		appendString(s, ele.getValues().get(0), 40);
		return s.toString();
	}

	protected String image(EnumerationLiteral ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/EnumerationLiteral.gif";
	}

	protected String text(EnumerationLiteral ele) {
		return ele.getName();
	}

	protected String image(ExpressionInOCL ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/ExpressionInOCL.gif";
	}

	protected String text(ExpressionInOCL ele) {
		return "<ExpressionInOCL>";
	}

	protected String image(IfExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/IfExp.gif";
	}

	protected String text(IfExp ele) {
		return "if";
	}

	protected String image(Import ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/PackageImport.gif";
	}

	protected String text(Import ele) {
		StringBuilder s = new StringBuilder();
		if (ele.getName() != null) {
			appendName(s, ele);
			s.append(" : ");
		}
		appendName(s, ele.getImportedNamespace());
		return s.toString();
	}

	protected String image(IntegerLiteralExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/IntegerLiteralExp.gif";
	}

	protected String image(InvalidLiteralExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/InvalidLiteralExp.gif";
	}

	protected String image(InvalidType ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/InvalidType.gif";
	}

	protected String image(IterateExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/IterateExp.gif";
	}

	protected String image(Iteration ele) {
		return "/org.eclipse.ocl.pivot/icons/full/obj16/Iteration.gif";
	}

	protected String text(Iteration ele) {
		StringBuilder s = new StringBuilder();
		appendName(s, ele);
		appendTemplateSignature(s, ele);
		appendParameters(s, ele.getOwnedIterators());
		s.append(" : ");
		appendType(s, ele.getType());
		appendMultiplicity(s, ele);
		return s.toString();
	}

	protected String image(IteratorExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/IteratorExp.gif";
	}

	protected String image(LambdaType ele) {
		return "/org.eclipse.ocl.pivot/icons/full/obj16/LambdaType.gif";
	}

	protected String image(LetExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/LetExp.gif";
	}

	protected String image(LiteralExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/LiteralExp.gif";
	}

	protected String image(LoopExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/LoopExp.gif";
	}

	protected String text(LoopExp ele) {
		assert ele != null;
		StringBuilder s = new StringBuilder();
		appendNavigationOperator(s, ele);
		Iteration referredIteration = ele.getReferredIteration();
		if (referredIteration != null) {
			s.append(text(referredIteration));
		}
		else {
			s.append("<<null>>");
		}
		return s.toString();
	}

	protected String image(MessageExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/MessageExp.gif";
	}

	protected String image(MessageType ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/MessageType.gif";
	}

	protected String image(Model ele) {
		return "/org.eclipse.uml2.uml.editor/icons/full/obj16/UMLModelFile.gif";
	}

	protected String image(NavigationCallExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/NavigationCallExp.gif";
	}

	protected String image(NullLiteralExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/NullLiteralExp.gif";
	}

	protected String image(NumericLiteralExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/NumericLiteralExp.gif";
	}

	protected String text(OCLExpression ele) {
		assert ele != null;
		Namespace namespace = PivotUtil.getNamespace(ele.eContainer());
		if (namespace == null) {
			return "";
		}
		StringBuilder s = new StringBuilder();
		s.append(PrettyPrinter.printName(ele, namespace));
		s.append(" : ");
		Type type = ele.getType();
		if (type != null) {
			s.append(PrettyPrinter.printType(type, namespace));
			appendMultiplicity(s, ele);
		}
		return s.toString();
	}

	protected String image(Operation ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/Operation.gif";
	}

	protected String text(Operation ele) {
		StringBuilder s = new StringBuilder();
		appendName(s, ele);
		appendTemplateSignature(s, ele);
		appendParameters(s, ele.getOwnedParameters());
		s.append(" : ");
		appendType(s, ele.getType());
		appendMultiplicity(s, ele);
		return s.toString();
	}

	protected String image(OperationCallExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/OperationCallExp.gif";
	}

	protected String text(OperationCallExp ele) {
		assert ele != null;
		StringBuilder s = new StringBuilder();
		appendNavigationOperator(s, ele);
		Operation referredOperation = ele.getReferredOperation();
		if (referredOperation != null) {
			s.append(text(referredOperation));
		}
		else {
			s.append("<<null>>");
		}
		return s.toString();
	}

	protected String image(OppositePropertyCallExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/OppositePropertyCallExp.gif";
	}

	protected String text(OppositePropertyCallExp ele) {
		assert ele != null;
		StringBuilder s = new StringBuilder();
		appendNavigationOperator(s, ele);
		Property referredOppositeProperty = ele.getReferredProperty();
		Property referredProperty = referredOppositeProperty != null ? referredOppositeProperty.getOpposite() : null;
		if (referredProperty != null) {
			s.append(text(referredProperty));
		}
		else {
			s.append("<<null>>");
		}
		return s.toString();
	}

	protected String image(OrderedSetType ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/OrderedSetType.gif";
	}

	protected String image(org.eclipse.ocl.pivot.Package ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/Package.gif";
	}

	protected String text(org.eclipse.ocl.pivot.Package ele) {
		String uri = ele.getURI();
		if (uri != null) {
			StringBuilder s = new StringBuilder();
			appendName(s, ele);
			s.append(" : '");
			appendString(s, uri);
			s.append("'");
			return s.toString();
		}
		else {
			return ele.getName();
		}
	}

	protected String image(Parameter ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/Parameter_in.gif";
	}

	protected String text(Parameter ele) {
		StringBuilder s = new StringBuilder();
		appendName(s, ele);
		s.append(" : ");
		appendType(s, ele.getType());
		appendMultiplicity(s, ele);
		return s.toString();
	}

	protected String text(PathNameCS ele) {
		StringBuilder s = new StringBuilder();
		appendPathName(s, ele);
		return s.toString();
	}

	protected Object image(PivotableElementCS ele) {
		return doGetImage(ele.getPivot());
	}

	protected Object text(PivotableElementCS ele) {
		return doGetText(ele.getPivot());
	}

	protected String text(Precedence ele) {
		assert ele != null;
		return PrettyPrinter.print(ele);
	}

	protected String image(PrimitiveLiteralExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/PrimitiveLiteralExp.gif";
	}

	protected String image(PrimitiveType ele) {
//		return "/org.eclipse.ocl.edit/icons/full/obj16/PrimitiveType.gif";
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/PrimitiveType.gif";
	}

	protected String image(Property ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/Property.gif";
	}

	protected String text(Property ele) {
		StringBuilder s = new StringBuilder();
		appendName(s, ele);
		s.append(" : ");
		appendType(s, ele.getType());
		appendMultiplicity(s, ele);
		return s.toString();
	}

	protected String image(PropertyCallExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/PropertyCallExp.gif";
	}

	protected String text(PropertyCallExp ele) {
		assert ele != null;
		StringBuilder s = new StringBuilder();
		appendNavigationOperator(s, ele);
		Property referredProperty = ele.getReferredProperty();
		if (referredProperty != null) {
			s.append(text(referredProperty));
		}
		else {
			s.append("<<null>>");
		}
		return s.toString();
	}

	protected String image(RealLiteralExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/RealLiteralExp.gif";
	}

	protected String text(Model ele) {
		StringBuilder s = new StringBuilder();
		appendString(s, ele.getExternalURI());
		return s.toString();
	}

	protected String image(SequenceType ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/SequenceType.gif";
	}

	protected String image(SetType ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/SetType.gif";
	}

	protected String image(StateExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/StateExp.gif";
	}

	protected String image(StringLiteralExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/StringLiteralExp.gif";
	}

	protected String image(TemplateParameter ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/TemplateParameter.gif";
	}

	protected String text(TemplateParameter ele) {
		return ele.getName();
	}

	protected String image(TupleLiteralExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/TupleLiteralExp.gif";
	}

	protected String image(TupleLiteralPart ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/TupleLiteralPart.gif";
	}

	protected String text(TupleLiteralPart ele) {
		StringBuilder s = new StringBuilder();
		appendName(s, ele);
		return s.toString();
	}

/*	protected String image(TuplePart ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/Property.gif";
	}

	protected String text(TuplePart ele) {
		StringBuilder s = new StringBuilder();
		appendName(s, ele);
		s.append(" : ");
		appendType(s, ele.getType());
//		appendMultiplicity(s, ele);
		return s.toString();
	} */

	protected String image(TupleType ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/TupleType.gif";
	}

	protected String text(TupleType ele) {
		StringBuilder s = new StringBuilder();
		appendType(s, ele);
		appendSuperTypes(s, ele.getSuperClasses());
		return s.toString();
	}

	protected String text(Type ele) {
		StringBuilder s = new StringBuilder();
		appendType(s, ele);
		return s.toString();
	}

	protected String image(TypeExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/TypeExp.gif";
	}

//	protected String text(TypeRefCS ele) {
//		StringBuilder s = new StringBuilder();
//		appendType(s, ele);
//		return s.toString();
//	}

	protected String image(UnlimitedNaturalLiteralExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/UnlimitedNaturalLiteralExp.gif";
	}

	protected String image(Variable ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/Variable.gif";
	}

	protected String text(Variable ele) {
		assert ele != null;
		return PrettyPrinter.print(ele);
	}

	protected String image(VariableExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/VariableExp.gif";
	}

	protected String image(VoidType ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/VoidType.gif";
	}
}
