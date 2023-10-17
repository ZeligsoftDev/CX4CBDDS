/*******************************************************************************
 * Copyright (c) 2010, 2019 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D. Willink - Robustness enhancements (null-proofing)
 *   Adolfo Sanchez- Barbudo Herrera - 228841 Fix NPE in VariableExp
 *******************************************************************************/

package org.eclipse.ocl.pivot.utilities;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Annotation;
import org.eclipse.ocl.pivot.AnyType;
import org.eclipse.ocl.pivot.AssociationClassCallExp;
import org.eclipse.ocl.pivot.BooleanLiteralExp;
import org.eclipse.ocl.pivot.CollectionItem;
import org.eclipse.ocl.pivot.CollectionLiteralExp;
import org.eclipse.ocl.pivot.CollectionLiteralPart;
import org.eclipse.ocl.pivot.CollectionRange;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Detail;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.EnumLiteralExp;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.FeatureCallExp;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.IntegerLiteralExp;
import org.eclipse.ocl.pivot.InvalidLiteralExp;
import org.eclipse.ocl.pivot.InvalidType;
import org.eclipse.ocl.pivot.IterateExp;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.IteratorExp;
import org.eclipse.ocl.pivot.IteratorVariable;
import org.eclipse.ocl.pivot.LambdaType;
import org.eclipse.ocl.pivot.LetExp;
import org.eclipse.ocl.pivot.MapLiteralExp;
import org.eclipse.ocl.pivot.MapLiteralPart;
import org.eclipse.ocl.pivot.MapType;
import org.eclipse.ocl.pivot.MessageExp;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.NullLiteralExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Precedence;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.ProfileApplication;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.RealLiteralExp;
import org.eclipse.ocl.pivot.ShadowExp;
import org.eclipse.ocl.pivot.ShadowPart;
import org.eclipse.ocl.pivot.StateExp;
import org.eclipse.ocl.pivot.StereotypeExtender;
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
import org.eclipse.ocl.pivot.UnspecifiedValueExp;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.VoidType;
import org.eclipse.ocl.pivot.WildcardType;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.values.Unlimited;

/**
 * Converts an OCL expression to a string for debugging. This is not intended to
 * be used by client applications as an AST-to-text transformation.
 *
 * @author Edith Schonberg (edith)
 * @author Christian W. Damus (cdamus)
 * @author Edward Willink (ewillink)
 */
public class ToStringVisitor extends AbstractExtendingVisitor<@Nullable String, @NonNull StringBuilder>
{
	/**
	 * Set this value true to avoid default multiplicities bing hidden.
	 * @since 1.3
	 */
	public static boolean SHOW_ALL_MULTIPLICITIES = false;

	private static final Logger logger = LogManager.getLogger(ToStringVisitor.class);

	public static interface Factory {
		@NonNull ToStringVisitor createToStringVisitor(@NonNull StringBuilder s);
		@NonNull EPackage getEPackage();
	}

	private static @NonNull Map<@NonNull EPackage, @NonNull Factory> factoryMap = new HashMap<>();

	public static synchronized void addFactory(@NonNull Factory factory) {
		factoryMap.put(factory.getEPackage(), factory);
	}

	/**
	 * @since 1.4
	 */
	public static synchronized void addFactory(/*@NonNull*/ EPackage ePackage, @NonNull Factory factory) {
		assert ePackage != null;
		factoryMap.put(ePackage, factory);
	}

	public static @Nullable Factory getFactory(@NonNull EObject eObject) {
		EPackage ePackage = eObject.eClass().getEPackage();
		Factory factory = factoryMap.get(ePackage);
		if (factory == null) {
			logger.error("No ToStringVisitor Factory registered for " + ePackage.getName());
		}
		return factory;
	}

	public static String toString(@NonNull Element asElement) {
		Resource resource = asElement.eResource();
		if (resource instanceof ASResource) {
			StringBuilder s = new StringBuilder();
			ToStringVisitor v = ((ASResource)resource).getASResourceFactory().createToStringVisitor(s);
			asElement.accept(v);
			return s.toString();
		}
		Factory factory = getFactory(asElement);
		if (factory == null) {
			return NULL_PLACEHOLDER;
		}
		StringBuilder s = new StringBuilder();
		ToStringVisitor v = factory.createToStringVisitor(s);
		asElement.accept(v);
		return s.toString();
	}

	protected static class AS2StringFactory implements ToStringVisitor.Factory
	{
		protected AS2StringFactory() {
			ToStringVisitor.addFactory(this);
			//			FACTORY.getClass();				// This is redundant for this class but needed by derived classes
		}

		@Override
		public @NonNull ToStringVisitor createToStringVisitor(@NonNull StringBuilder s) {
			return new ToStringVisitor(s);
		}

		@Override
		public @NonNull EPackage getEPackage() {
			PivotPackage eInstance = PivotPackage.eINSTANCE;
			assert eInstance != null;
			return eInstance;
		}
	}

	public static ToStringVisitor.@NonNull Factory FACTORY = new AS2StringFactory();

	/**
	 * Indicates where a required element in the AST was <code>null</code>, so
	 * that it is evident in the debugger that something was missing. We don't
	 * want just <code>"null"</code> because that would look like the OclVoid
	 * literal.
	 */
	protected static @NonNull String NULL_PLACEHOLDER = "«null»"; //$NON-NLS-1$

	/**
	 * Initializes me.
	 */
	public ToStringVisitor(@NonNull StringBuilder s) {
		super(s);
	}

	/*
	 * protected List<? extends EObject> getConstrainedElements(Constraint
	 * constraint) { if (uml == null) { return Collections.emptyList(); } else {
	 * return uml.getConstrainedElements(constraint); } }
	 *
	 * protected String getStereotype(Constraint constraint) { return (uml ==
	 * null)? null : uml.getStereotype(constraint); }
	 *
	 * @Override protected ExpressionInOCL getSpecification(Constraint
	 * constraint) { return (uml == null)? null :
	 * uml.getSpecification(constraint); }
	 */

	protected void append(Number number) {
		if (number != null) {
			context.append(number.toString());
		}
		else {
			context.append(NULL_PLACEHOLDER);
		}
	}

	protected void append(String string) {
		if (string != null) {
			context.append(string);
		}
		else {
			context.append(NULL_PLACEHOLDER);
		}
	}

	protected void appendAtPre(FeatureCallExp mpc) {
		if (mpc.isIsPre()) {
			append("@pre"); //$NON-NLS-1$
		}
	}

	protected void appendElementType(@Nullable TypedElement typedElement) {
		if (typedElement == null) {
			append(NULL_PLACEHOLDER);
		}
		else {
			Type type = typedElement.getType();
			safeVisit(type);
			if (!typedElement.isIsRequired()) {
				append("[?]");
			}
			else if (!(type instanceof CollectionType)) {
				append("[1]");
			}
		}
	}

	protected void appendName(Nameable object) {
		if (object == null) {
			context.append(NULL_PLACEHOLDER);
		}
		else {
			context.append(object.getName());
		}
	}

	protected void appendOperationSignature(Operation operation) {
		appendName(operation);
		append("(");
		boolean comma = false;
		for (java.util.Iterator<Parameter> iter = operation
				.getOwnedParameters().iterator(); iter.hasNext();) {
			Parameter parm = iter.next();

			if (comma) {
				append(", "); //$NON-NLS-1$
			} else {
				comma = true;
			}

			appendName(parm);
			append(" : "); //$NON-NLS-1$
			if (parm.getType() != null) {
				boolean isTypeof = parm.isIsTypeof();
				if (isTypeof) {
					append("typeof(");
				}
				appendElementType(parm);
				if (isTypeof) {
					append(")");
				}
			} else {
				append(TypeId.OCL_VOID_NAME);
			}
		}

		append(") :"); //$NON-NLS-1$
		if (operation.getType() != null) {
			append(" ");
			boolean isTypeof = operation.isIsTypeof();
			if (isTypeof) {
				append("typeof(");
			}
			appendElementType(operation);
			if (isTypeof) {
				append(")");
			}
		}
	}

	protected void appendPropertyCallExp(@NonNull NavigationCallExp pc, Property property) {
		// source is null when the property call expression is an
		//    association class navigation qualifier
		OCLExpression source = pc.getOwnedSource();
		safeVisit(source);
		Type sourceType = source != null ? source.getType() : null;
		append(PivotUtil.getNavigationOperator(pc.isIsSafe(), PivotUtil.isAggregate(sourceType)));
		appendName(property);
		appendAtPre(pc);
		List<OCLExpression> qualifiers = pc.getQualifiers();
		if (!qualifiers.isEmpty()) {
			append("["); //$NON-NLS-1$
			String prefix = ""; //$NON-NLS-1$
			for (OCLExpression qualifier : qualifiers) {
				append(prefix);
				safeVisit(qualifier);
				prefix = ", "; //$NON-NLS-1$
			}
			append("]");
		}
	}

	protected void appendPropertySignature(Property property) {
		appendName(property);
		if (property.getType() != null) {
			append(" : ");
			appendElementType(property);
		}
	}

	protected void appendQualifiedName(NamedElement parent, String separator, NamedElement child) {
		if (parent != null) {
			appendQualifiedName(parent);
			append(separator);
		}
		appendName(child);
	}

	protected void appendQualifiedName(@Nullable NamedElement object) {
		if (object == null) {
			context.append(NULL_PLACEHOLDER);
		}
		else {
			EObject container = object.eContainer();
			if ((container != null) && (!(container instanceof Model) && (container instanceof NamedElement) &&
					(!(container.eContainer() instanceof Model) || !PivotConstants.OCL_NAME.equals(((NamedElement)container).getName())))) {
				appendQualifiedName((NamedElement) container);
				append("::"); //$NON-NLS-1$
			}
			appendName(object);
			if (object instanceof TemplateableElement) {
				TemplateableElement templateableElement = (TemplateableElement) object;
				appendTemplateBindings(templateableElement.getOwnedBindings(), null);
				appendTemplateSignature(templateableElement.getOwnedSignature());
			}
		}
	}

	protected void appendTemplateBindings(List<TemplateBinding> templateBindings, @Nullable CollectionType collectionType) {
		if (templateBindings.size() > 0) {
			append("(");
			String prefix = ""; //$NON-NLS-1$
			for (TemplateBinding templateBinding : templateBindings) {
				for (TemplateParameterSubstitution templateParameterSubstitution : templateBinding.getOwnedSubstitutions()) {
					append(prefix);
					safeVisit(templateParameterSubstitution.getActual());
					prefix = ",";
				}
			}
			if (collectionType != null) {
				Number lower = collectionType.getLower();
				Number upper = collectionType.getUpper();
				long lowerValue = lower != null ? lower.longValue() : 0l;		// FIXME Handle BigInteger
				long upperValue = (upper != null) && !(upper instanceof Unlimited) ? upper.longValue() : -1l;
				if (SHOW_ALL_MULTIPLICITIES || (lowerValue != 0) || (upperValue != -1) || !collectionType.isIsNullFree()) {
					StringUtil.appendMultiplicity(context, lowerValue, upperValue, collectionType.isIsNullFree());
				}
			}
			append(")");
		}
	}

	protected void appendTemplateSignature(TemplateSignature templateSignature) {
		if (templateSignature != null) {
			List<TemplateParameter> templateParameters = templateSignature.getOwnedParameters();
			if (!templateParameters.isEmpty()) {
				append("(");
				String prefix = ""; //$NON-NLS-1$
				for (TemplateParameter templateParameter : templateParameters) {
					append(prefix);
					appendName(templateParameter);
					prefix = ",";
				}
				append(")");
			}
		}
	}

	protected void appendType(Type type) {
		if ((type != null)
				&& (type.eClass() == PivotPackage.Literals.CLASS)	// i.e. by pass AnyType, PrimitiveType, ...
				&& (type.eContainer() instanceof NamedElement)) {
			appendQualifiedName((NamedElement) type.eContainer());
			append("::");
		}
		appendName(type);
	}

	/**
	 * A null-safe visitation of the specified visitable, appending any generated text to the toStringVisitor context.
	 *
	 * @param v a visitable, or <code>null</code>
	 * @return <code>null</code>
	 */
	@Override
	public @Nullable String safeVisit(org.eclipse.ocl.pivot.util.@Nullable Visitable v) {
		if (v == null) {
			append(NULL_PLACEHOLDER);
		}
		else {
			try {
				v.accept(this);
			}
			catch (ClassCastException e) {
				if (v instanceof EObject) {
					Factory factory = getFactory((EObject)v);
					if (factory != null) {
						ToStringVisitor stringVisitor2 = factory.createToStringVisitor(this.context);
						Class<?> thatClass = stringVisitor2.getClass();
						Class<?> thisClass = getClass();
						if ((thatClass != thisClass) && thisClass.isAssignableFrom(thatClass)) {
							return stringVisitor2.safeVisit(v);
						}
					}
				}
				append("«");
				append(e.getMessage());
				append("»");
			}
			catch (Throwable e) {
				append("«");
				append(e.getMessage());
				append("»");
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return context.toString();
	}

	@Override
	public @Nullable String visitAnnotation(@NonNull Annotation object) {
		appendName(object);
		return null;
	}

	@Override
	public String visitAnyType(@NonNull AnyType object) {
		appendName(object);
		return null;
	}

	/**
	 * Callback for an AssociationClassCallExp visit.
	 *
	 * @param ac
	 *            the association class expression
	 * @return string source.ref
	 */
	@Override
	public String visitAssociationClassCallExp(@NonNull AssociationClassCallExp ac) {
		safeVisit(ac.getOwnedSource());
		append("."); //$NON-NLS-1$
		appendName(ac.getReferredAssociationClass());
		appendAtPre(ac);
		List<OCLExpression> qualifiers = ac.getQualifiers();
		if (!qualifiers.isEmpty()) {
			append("[");
			safeVisit(qualifiers.get(0));
			append("]");
		}
		return null;
	}

	/**
	 * Callback for a BooleanLiteralExp visit.
	 *
	 * @param bl
	 *            -- boolean literal expression
	 * @return the value of the boolean literal as a java.lang.Boolean.
	 */
	@Override
	public String visitBooleanLiteralExp(@NonNull BooleanLiteralExp bl) {
		append(Boolean.toString(bl.isBooleanSymbol()));
		return null;
	}

	@Override
	public String visitClass(org.eclipse.ocl.pivot.@NonNull Class cls) {
		org.eclipse.ocl.pivot.Package pkg = cls.getOwningPackage();
		if (pkg == null) {
			append("null::");
			appendName(cls);
		}
		else if (!(pkg.eContainer() instanceof Model) || !IdManager.METAMODEL.equals(pkg.getPackageId())) {
			appendQualifiedName(pkg, "::", cls);
		}
		else {
			appendName(cls);
		}
		appendTemplateBindings(cls.getOwnedBindings(), null);
		appendTemplateSignature(cls.getOwnedSignature());
		return null;
	}

	/**
	 * Visits the item's item expression.
	 */
	@Override
	public String visitCollectionItem(@NonNull CollectionItem item) {
		safeVisit(item.getOwnedItem());
		return null;
	}

	/**
	 * Visits the collection literal's parts.
	 */
	@Override
	public String visitCollectionLiteralExp(@NonNull CollectionLiteralExp cl) {
		// construct the appropriate collection from the parts
		// based on the collection kind.
		switch (cl.getKind()) {
			case SET :
				append("Set{");//$NON-NLS-1$
				break;
			case ORDERED_SET :
				append("OrderedSet{");//$NON-NLS-1$
				break;
			case BAG :
				append("Bag{");//$NON-NLS-1$
				break;
			case SEQUENCE :
				append("Sequence{");//$NON-NLS-1$
				break;
			default :
				append("Collection{");//$NON-NLS-1$
				break;
		}
		boolean isFirst = true;
		for (CollectionLiteralPart part : cl.getOwnedParts()) {
			if (!isFirst) {
				append(", ");
			}
			safeVisit(part);
			isFirst = false;
		}
		append("}");
		return null;
	}

	/**
	 * Visits the range's first and last expressions.
	 */
	@Override
	public String visitCollectionRange(@NonNull CollectionRange range) {
		safeVisit(range.getOwnedFirst());
		append(" .. ");
		safeVisit(range.getOwnedLast());
		return null;
	}

	@Override
	public String visitCollectionType(@NonNull CollectionType object) {
		appendName(object);
		appendTemplateBindings(object.getOwnedBindings(), object);
		appendTemplateSignature(object.getOwnedSignature());
		//		Number lower = object.getLower();
		//		Number upper = object.getUpper();
		//		long lowerValue = lower != null ? lower.longValue() : 0l;		// FIXME Handle BigInteger
		//		long upperValue = (upper != null) && !(upper instanceof Unlimited) ? upper.longValue() : -1l;
		//		if ((lowerValue != 0) || (upperValue != -1)) {
		//			StringUtil.appendMultiplicity(context, lowerValue, upperValue, object.isIsNullFree());
		//		}
		return null;
	}

	@Override
	public String visitComment(@NonNull Comment comment) {
		append("/* ");
		append(comment.getBody());
		append(" */");
		return null;
	}

	@Override
	public @Nullable String visitCompleteClass(@NonNull CompleteClass object) {
		List<org.eclipse.ocl.pivot.@NonNull Class> partialClasses = ClassUtil.nullFree(object.getPartialClasses());
		int size = partialClasses.size();
		if (size > 0) {
			append(ToStringVisitor.toString(partialClasses.get(0)));
		}
		else {
			appendName(object);
		}
		append("*");
		append(size);
		return null;
	}

	@Override
	public @Nullable String visitCompletePackage(@NonNull CompletePackage object) {
		appendName(object);
		append("*");
		append(object.getPartialPackages().size());
		append(" : ");
		append(object.getURI());
		return null;
	}

	/**
	 * Renders a constraint with its context and expression.
	 */
	@Override
	public String visitConstraint(@NonNull Constraint constraint) {
		List<? extends EObject> constrained = constraint.getConstrainedElements();
		if (!constrained.isEmpty()) {
			EObject elem = constrained.get(0);
			append("context "); //$NON-NLS-1$
			if (elem instanceof Type) {
				appendName((NamedElement) elem);
			} else if (elem instanceof Operation) {
				Operation oper = (Operation) elem;
				appendOperationSignature(oper);
			} else if (elem instanceof Property) {
				Property prop = (Property) elem;
				appendPropertySignature(prop);
			}
			append(" ");
		}

		String stereo = PivotUtilInternal.getStereotype(constraint);
		append(stereo);
		String name = constraint.getName();
		if (name != null) {
			append(" "); //$NON-NLS-1$
			append(name);
		}
		append(": "); //$NON-NLS-1$
		/* FIXME def context
		EObject elem = constrained.get(1);
		if (elem instanceof Operation) {
			appendOperationSignature((Operation) elem);
		} else if (elem instanceof Property) {
			appendPropertySignature((Property) elem);
		}
		append(" = "); //$NON-NLS-1$
		 */
		safeVisit(constraint.getOwnedSpecification());
		return null;
	}

	@Override
	public @Nullable String visitDetail(@NonNull Detail object) {
		appendName(object);
		append(" = ");
		boolean first = true;
		for (String value : object.getValues()) {
			if (!first) {
				append(", ");
			}
			append(value);
			first = false;
		}
		return null;
	}

	@Override
	public String visitElementExtension(@NonNull ElementExtension as) {
		appendName(as);
		return null;
	}

	/**
	 * Callback for an EnumLiteralExp visit.
	 *
	 * @param el
	 *            the enumeration literal expresion
	 * @return the enumeration literal toString()
	 */
	@Override
	public String visitEnumLiteralExp(@NonNull EnumLiteralExp el) {
		appendQualifiedName(el.getReferredLiteral());
		return null;
	}

	@Override
	public String visitEnumerationLiteral(@NonNull EnumerationLiteral el) {
		appendQualifiedName(el.getOwningEnumeration(), "::", el);
		return null;
	}

	/**
	 * Renders an ExpressionInOCL with its context variables and body.
	 */
	@Override
	public String visitExpressionInOCL(@NonNull ExpressionInOCL expression) {
		OCLExpression bodyExpression = expression.getOwnedBody();
		if (bodyExpression != null) {
			return safeVisit(bodyExpression);
		}
		else {
			append(expression.getBody());
			return null;
		}
	}

	/**
	 * Callback for an IfExp visit.
	 *
	 * @param ifExp
	 *            an IfExp
	 * @return the string representation
	 */
	@Override
	public String visitIfExp(@NonNull IfExp ifExp) {
		boolean isElseIf = ifExp.isIsElseIf();
		append(isElseIf ? "/*else*/if ": "if ");  //$NON-NLS-1$
		safeVisit(ifExp.getOwnedCondition());
		append(" then "); //$NON-NLS-1$
		safeVisit(ifExp.getOwnedThen());
		append(" else "); //$NON-NLS-1$
		safeVisit(ifExp.getOwnedElse());
		append(isElseIf ? " /*else*/endif": " endif"); //$NON-NLS-1$
		return null;
	}

	@Override public @Nullable String visitImport(@NonNull Import object) {
		appendName(object);
		append(" : ");
		appendQualifiedName(object.getImportedNamespace());
		return null;
	}

	/**
	 * Callback for an IntegerLiteralExp visit.
	 *
	 * @param il
	 *            -- integer literal expression
	 * @return String
	 */
	@Override
	public String visitIntegerLiteralExp(@NonNull IntegerLiteralExp il) {
		append(il.getIntegerSymbol());
		return null;
	}

	@Override
	public String visitInvalidLiteralExp(@NonNull InvalidLiteralExp il) {
		append("invalid");
		return null;
	}

	@Override
	public String visitInvalidType(@NonNull InvalidType object) {
		appendName(object);
		return null;
	}

	/**
	 * Callback for an IterateExp visit.
	 *
	 * @param callExp
	 *            an iterate expression
	 * @return the string representation
	 */
	@Override
	public String visitIterateExp(@NonNull IterateExp callExp) {
		safeVisit(callExp.getOwnedSource());
		append(PivotUtil.getNavigationOperator(callExp.isIsSafe(), true));
		appendName(callExp.getReferredIteration());
		append("("); //$NON-NLS-1$
		boolean isFirst = true;
		List<Variable> iterators = callExp.getOwnedIterators();
		int iteratorsSize = iterators.size();
		List<IteratorVariable> coIterators = callExp.getOwnedCoIterators();
		int coIteratorsSize = coIterators.size();
		for (int i = 0; i < iteratorsSize; i++) {
			Variable iterator = iterators.get(i);
			IteratorVariable coIterator = i < coIteratorsSize ? coIterators.get(i) : null;
			if (!isFirst) {
				append(", ");
			}
			safeVisit(iterator);
			if (coIterator != null) {
				append(" with ");
				safeVisit(coIterator);
			}
			isFirst = false;
		}
		append("; ");
		safeVisit(callExp.getOwnedResult());
		append(" | ");
		safeVisit(callExp.getOwnedBody());
		append(")");//$NON-NLS-1$
		return null;
	}

	@Override
	public String visitIteration(@NonNull Iteration iteration) {
		appendQualifiedName(iteration.getOwningClass(), ".", iteration);
		appendTemplateBindings(iteration.getOwnedBindings(), null);
		appendTemplateSignature(iteration.getOwnedSignature());
		append("(");
		boolean isFirst = true;
		for (Parameter parameter : iteration.getOwnedIterators()) {
			if (!isFirst) {
				append(", ");
			}
			appendElementType(parameter);
			isFirst = false;
		}
		isFirst = true;
		for (Parameter accumulator : iteration.getOwnedAccumulators()) {
			if (!isFirst) {
				append(", ");
			}
			else {
				append("; ");
			}
			appendElementType(accumulator);
			isFirst = false;
		}
		isFirst = true;
		for (Parameter parameter : iteration.getOwnedParameters()) {
			if (!isFirst) {
				append(", ");
			}
			else {
				append(" | ");
			}
			appendElementType(parameter);
			isFirst = false;
		}
		append(") : ");
		appendElementType(iteration);
		return null;
	}

	/**
	 * Callback for an IteratorExp visit.
	 *
	 * @param callExp
	 *            an iterator expression
	 * @return the string representation
	 */
	@Override
	public String visitIteratorExp(@NonNull IteratorExp callExp) {
		safeVisit(callExp.getOwnedSource());
		append(PivotUtil.getNavigationOperator(callExp.isIsSafe(), true));
		appendName(callExp.getReferredIteration());
		append("("); //$NON-NLS-1$
		boolean isFirst = true;
		List<Variable> iterators = callExp.getOwnedIterators();
		int iteratorsSize = iterators.size();
		List<IteratorVariable> coIterators = callExp.getOwnedCoIterators();
		int coIteratorsSize = coIterators.size();
		for (int i = 0; i < iteratorsSize; i++) {
			Variable iterator = iterators.get(i);
			Variable coIterator = i < coIteratorsSize ? coIterators.get(i) : null;
			if (!isFirst) {
				append(", ");
			}
			safeVisit(iterator);
			if (coIterator != null) {
				append(" with ");
				safeVisit(coIterator);
			}
			isFirst = false;
		}
		append(" | ");
		safeVisit(callExp.getOwnedBody());
		append(")");//$NON-NLS-1$
		return null;
	}

	@Override
	public String visitLambdaType(@NonNull LambdaType lambda) {
		appendName(lambda);
		Type contextType = lambda.getContextType();
		if (contextType != null) {
			append(" ");
			appendType(contextType);
			appendTemplateSignature(lambda.getOwnedSignature());
			append("(");
			boolean isFirst = true;
			for (Type parameterType : lambda.getParameterType()) {
				if (!isFirst) {
					append(",");
				}
				appendType(parameterType);
				isFirst = false;
			}
			append(") : ");
			appendType(lambda.getResultType());
		}
		return null;
	}

	/**
	 * Callback for LetExp visit.
	 *
	 * @param letExp
	 *            a let expression
	 * @return the string representation
	 */
	@Override
	public String visitLetExp(@NonNull LetExp letExp) {
		append("let "); //$NON-NLS-1$
		safeVisit(letExp.getOwnedVariable());
		append(" in "); //$NON-NLS-1$
		safeVisit(letExp.getOwnedIn());
		return null;
	}

	/**
	 * Visits the map literal's parts.
	 */
	@Override
	public String visitMapLiteralExp(@NonNull MapLiteralExp mapLiteralExp) {
		append("Map{");//$NON-NLS-1$
		boolean isFirst = true;
		for (MapLiteralPart part : mapLiteralExp.getOwnedParts()) {
			if (!isFirst) {
				append(", ");
			}
			safeVisit(part);
			isFirst = false;
		}
		append("}");
		return null;
	}

	/**
	 * Visits the range's first and last expressions.
	 */
	@Override
	public String visitMapLiteralPart(@NonNull MapLiteralPart mapLiteralPart) {
		safeVisit(mapLiteralPart.getOwnedKey());
		append(" with ");
		safeVisit(mapLiteralPart.getOwnedValue());
		return null;
	}

	@Override
	public String visitMapType(@NonNull MapType object) {
		appendName(object);
		List<TemplateBinding> templateBindings = object.getOwnedBindings();
		//	appendTemplateBindings(ownedBindings, null);		// FIXME show Map key/value-multiplicities
		if (templateBindings.size() > 0) {
			append("(");
			String prefix = ""; //$NON-NLS-1$
			int index = 0;
			for (TemplateBinding templateBinding : templateBindings) {
				for (TemplateParameterSubstitution templateParameterSubstitution : templateBinding.getOwnedSubstitutions()) {
					append(prefix);
					safeVisit(templateParameterSubstitution.getActual());
					if (((index == 0) && !object.isKeysAreNullFree()) || ((index == 1) && !object.isValuesAreNullFree())) {
						append("[?]");
					}
					else if (SHOW_ALL_MULTIPLICITIES) {
						append("[1]");
					}
					prefix = ",";
					index++;
				}
			}
			append(")");
		}
		appendTemplateSignature(object.getOwnedSignature());
		return null;
	}

	/**
	 * Visits the message expression's target and then its arguments.
	 */
	@Override
	public String visitMessageExp(@NonNull MessageExp messageExp) {
		safeVisit(messageExp.getOwnedTarget());
		append((messageExp.getType() instanceof CollectionType) ? "^^" : "^"); //$NON-NLS-1$//$NON-NLS-2$
		if (messageExp.getOwnedCalledOperation() != null) {
			appendName(messageExp.getOwnedCalledOperation().getOperation());
		} else if (messageExp.getOwnedSentSignal() != null) {
			appendName(messageExp.getOwnedSentSignal().getSignal());
		}
		append("(");
		String prefix = "";
		for (OCLExpression argument : messageExp.getOwnedArguments()) {
			append(prefix);
			safeVisit(argument);
			prefix = ", "; //$NON-NLS-1$
		}
		append(")");
		return null;
	}

	@Override
	public String visitModel(@NonNull Model root) {
		append(root.getExternalURI());
		return null;
	}

	@Override
	public String visitNullLiteralExp(@NonNull NullLiteralExp il) {
		append("null");
		return null;
	}

	@Override
	public String visitOperation(@NonNull Operation operation) {
		appendQualifiedName(operation.getOwningClass(), "::", operation);
		appendTemplateBindings(operation.getOwnedBindings(), null);
		appendTemplateSignature(operation.getOwnedSignature());
		append("(");
		boolean isFirst = true;
		for (Parameter parameter : operation.getOwnedParameters()) {
			if (!isFirst) {
				append(",");
			}
			appendElementType(parameter);
			isFirst = false;
		}
		append(") : ");
		appendElementType(operation);
		return null;
	}

	/**
	 * Callback for an OperationCallExp visit.
	 *
	 * Look at the source to determine operator ( -&gt; or . )
	 *
	 * @param oc
	 *            the operation call expression
	 * @return string
	 */
	@Override
	public String visitOperationCallExp(@NonNull OperationCallExp oc) {
		OCLExpression source = oc.getOwnedSource();
		safeVisit(source);
		Operation oper = oc.getReferredOperation();
		if (oper != null) {
			Type sourceType = source != null ? source.getType() : null;
			append(PivotUtil.getNavigationOperator(oc.isIsSafe(), PivotUtil.isAggregate(sourceType)));
			appendName(oper);
		} else {
			append(PivotUtil.getNavigationOperator(false, false));
			appendName(oc);
		}
		append("(");
		String prefix = "";//$NON-NLS-1$
		for (OCLExpression argument : oc.getOwnedArguments()) {
			append(prefix);
			safeVisit(argument);
			prefix = ", ";//$NON-NLS-1$
		}
		append(")");
		appendAtPre(oc);
		return null;
	}

	/**
	 * Callback for an OppositePropertyCallExp visit.
	 *
	 * @param pc
	 *            the property call expression
	 * @return string source.ref
	 */
	@Override
	public String visitOppositePropertyCallExp(@NonNull OppositePropertyCallExp pc) {
		Property referredOppositeProperty = pc.getReferredProperty();
		Property referredProperty = referredOppositeProperty != null ? referredOppositeProperty.getOpposite() : null;
		appendPropertyCallExp(pc, referredProperty);
		return null;
	}

	@Override
	public String visitPackage(org.eclipse.ocl.pivot.@NonNull Package pkg) {
		appendQualifiedName(pkg.getOwningPackage(), "::", pkg);
		return null;
	}

	@Override
	public String visitParameter(@NonNull Parameter parameter) {
		appendQualifiedName((NamedElement) parameter.eContainer(), ".", parameter);
		return null;
	}

	@Override
	public String visitPrecedence(@NonNull Precedence precedence) {
		appendName(precedence);
		Resource asResource = precedence.eResource();
		if (asResource != null) {
			PivotMetamodelManager metamodelManager = PivotUtilInternal.findMetamodelManager(asResource);
			if (metamodelManager != null) {
				append("(" + metamodelManager.getPrecedenceManager().getOrder(precedence) + ")");
			}
		}
		return null;
	}

	@Override
	public String visitPrimitiveType(@NonNull PrimitiveType object) {
		appendName(object);
		return null;
	}

	@Override
	public String visitProfileApplication(@NonNull ProfileApplication object) {
		appendQualifiedName(object.getAppliedProfile());
		append(" applied-to ");
		appendQualifiedName(object.getOwningPackage());
		return null;
	}

	@Override
	public String visitProperty(@NonNull Property property) {
		appendQualifiedName(property.getOwningClass(), "::", property);
		return null;
	}

	/**
	 * Callback for an PropertyCallExp visit.
	 *
	 * @param pc
	 *            the property call expression
	 * @return string source.ref
	 */
	@Override
	public String visitPropertyCallExp(@NonNull PropertyCallExp pc) {
		Property property = pc.getReferredProperty();
		appendPropertyCallExp(pc, property);
		return null;
	}

	/**
	 * Callback for a RealLiteralExp visit.
	 *
	 * @param rl
	 *            -- real literal expression
	 * @return the value of the real literal as a java.lang.Double.
	 */
	@Override
	public String visitRealLiteralExp(@NonNull RealLiteralExp rl) {
		append(rl.getRealSymbol());
		return null;
	}

	/**
	 * Callback for a ShadowExp visit.
	 *
	 * @param shadowExp
	 *            shadow expression
	 * @return the string representation
	 */
	@Override
	public String visitShadowExp(@NonNull ShadowExp shadowExp) {
		appendQualifiedName(shadowExp.getType());
		append("{");//$NON-NLS-1$
		String prefix = "";
		for (ShadowPart part : shadowExp.getOwnedParts()) {
			append(prefix);
			safeVisit(part);
			prefix = ", ";//$NON-NLS-1$
		}
		append("}");
		return null;
	}

	/**
	 * Visits the tuple shadow part's value, if any.
	 */
	@Override
	public String visitShadowPart(@NonNull ShadowPart part) {
		appendName(part.getReferredProperty());
		OCLExpression initExpression = part.getOwnedInit();
		if (initExpression != null) {
			append(" = ");
			safeVisit(initExpression);
		}
		return null;
	}

	@Override
	public String visitStateExp(@NonNull StateExp s) {
		appendName(s);
		return null;
	}

	@Override
	public String visitStereotypeExtender(@NonNull StereotypeExtender object) {
		appendQualifiedName(object.getClass_());
		append(" extended-by ");
		appendQualifiedName(object.getOwningStereotype());
		return null;
	}

	/**
	 * Callback for a StringLiteralExp visit.
	 *
	 * @param sl
	 *            -- string literal expression
	 * @return the value of the string literal as a java.lang.String.
	 */
	@Override
	public String visitStringLiteralExp(@NonNull StringLiteralExp sl) {
		append("'");
		append(sl.getStringSymbol());
		append("'");
		return null;
	}

	@Override
	public String visitTemplateBinding(@NonNull TemplateBinding object) {
		// s.append(getQualifiedName(object.getFormal(), "/", (NamedElement)
		// object.getActual()));
		appendTemplateBindings(Collections.singletonList(object), null);
		return null;
	}

	@Override
	public String visitTemplateParameter(@NonNull TemplateParameter object) {
		TemplateSignature signature = object.getOwningSignature();
		appendName(signature != null ? (NamedElement) signature.getOwningElement() : null);
		append(".");
		appendName(object);
		return null;
	}

	@Override
	public String visitTemplateParameterSubstitution(@NonNull TemplateParameterSubstitution object) {
		TemplateParameter formal = object.getFormal();
		appendName(formal != null ? formal : null);
		append("/");
		safeVisit(object.getActual());
		return null;
	}

	@Override
	public String visitTemplateSignature(@NonNull TemplateSignature object) {
		// s.append(getQualifiedName(object.getFormal(), "/", (NamedElement)
		// object.getActual()));
		appendTemplateSignature(object);
		return null;
	}

	/**
	 * Callback for a TupleLiteralExp visit.
	 *
	 * @param literalExp
	 *            tuple literal expression
	 * @return the string representation
	 */
	@Override
	public String visitTupleLiteralExp(@NonNull TupleLiteralExp literalExp) {
		append("Tuple{");//$NON-NLS-1$
		String prefix = "";
		for (TupleLiteralPart part : literalExp.getOwnedParts()) {
			append(prefix);
			safeVisit(part);
			prefix = ", ";//$NON-NLS-1$
		}
		append("}");
		return null;
	}

	/**
	 * Visits the tuple literal part's value, if any.
	 */
	@Override
	public String visitTupleLiteralPart(@NonNull TupleLiteralPart part) {
		appendName(part);
		Type type = part.getType();
		if (type != null) {
			append(" : ");
			appendElementType(part);
		}
		OCLExpression initExpression = part.getOwnedInit();
		if (initExpression != null) {
			append(" = ");
			safeVisit(initExpression);
		}
		return null;
	}

	@Override
	public String visitTupleType(@NonNull TupleType object) {
		appendName(object);
		append("(");
		String prefix = "";
		for (TypedElement part : object.getOwnedProperties()) {
			append(prefix);
			appendName(part);
			append(":");
			appendElementType(part);
			prefix = ",";
		}
		append(")");
		return null;
	}

	@Override
	public String visitTypeExp(@NonNull TypeExp t) {
		safeVisit(t.getReferredType());
		return null;
	}

	/**
	 * Callback for an UnlimitedNaturalLiteralExp visit.
	 *
	 * @param unl
	 *            -- unlimited natural literal expression
	 * @return String
	 */
	@Override
	public String visitUnlimitedNaturalLiteralExp(@NonNull UnlimitedNaturalLiteralExp unl) {
		append(unl.getUnlimitedNaturalSymbol());
		return null;
	}

	@Override
	public String visitWildcardType(@NonNull WildcardType object) {
		appendName(object);
		return null;
	}

	/**
	 * Callback for an UnspecifiedValueExp visit.
	 *
	 * @param uv
	 *            - UnspecifiedValueExp
	 * @return the string representation
	 */
	@Override
	public String visitUnspecifiedValueExp(@NonNull UnspecifiedValueExp uv) {
		append("?"); //$NON-NLS-1$
		if (uv.getType() != null && !(uv.getType() instanceof VoidType)) {
			append(" : "); //$NON-NLS-1$
			appendName(uv.getType());
		}
		return null;
	}

	/**
	 * Visits the variable's initialization expression (if any).
	 */
	@Override
	public String visitVariable(@NonNull Variable variable) {
		appendName(variable);
		Type type = variable.getType();
		if (type != null) {
			append(" : ");
			appendElementType(variable);
		}
		OCLExpression initExpression = variable.getOwnedInit();
		if (initExpression != null) {
			append(" = ");
			safeVisit(initExpression);
		}
		return null;
	}

	/**
	 * Callback for a VariableExp visit.
	 *
	 * @param v
	 *            the variable expression
	 * @return the variable name
	 */
	@Override
	public String visitVariableExp(@NonNull VariableExp v) {
		appendName(v.getReferredVariable());
		return null;
	}

	@Override
	public String visitVoidType(@NonNull VoidType object) {
		appendName(object);
		return null;
	}

	@Override
	public String visiting(@NonNull Visitable visitable) {
		append(visitable.getClass().getName());
		return null;
	}
} // ToStringVisitorImpl
