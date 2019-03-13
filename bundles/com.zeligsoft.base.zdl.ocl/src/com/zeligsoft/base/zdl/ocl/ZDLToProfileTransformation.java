/**
 * Copyright 2018 ADLINK Technology Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.base.zdl.ocl;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.TypeResolver;
import org.eclipse.ocl.expressions.BooleanLiteralExp;
import org.eclipse.ocl.expressions.CollectionItem;
import org.eclipse.ocl.expressions.CollectionLiteralExp;
import org.eclipse.ocl.expressions.EnumLiteralExp;
import org.eclipse.ocl.expressions.IteratorExp;
import org.eclipse.ocl.expressions.NullLiteralExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.expressions.TypeExp;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.VariableExp;
import org.eclipse.ocl.uml.CollectionType;
import org.eclipse.ocl.uml.TupleType;
import org.eclipse.ocl.uml.TypeType;
import org.eclipse.ocl.uml.util.UMLSwitch;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.ocl.utilities.AbstractVisitor;
import org.eclipse.ocl.utilities.ExpressionInOCL;
import org.eclipse.ocl.utilities.OCLFactory;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.ocl.utilities.Visitable;
import org.eclipse.osgi.util.NLS;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.ExtensionEnd;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.SendSignalAction;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;

import com.zeligsoft.base.zdl.ZDLNames;
import com.zeligsoft.base.zdl.ocl.l10n.Messages;
import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * A transformation of OCL constraints from the ZDL metamodel to a particular
 * UML Profile mapping of that ZDL.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ZDLToProfileTransformation {

	private static final String DIAGNOSTIC_SOURCE = "com.zeligsoft.base.zdl.ocl"; //$NON-NLS-1$

	private Profile profile;

	private ZDLEnvironment env;

	private OCLFactory factory;

	private TypeResolver<Classifier, Operation, Property> resolver;

	private final OCLZDLUtil util = new OCLZDLUtil();

	/**
	 * Initializes me for mapping ZDL constraints to the specified UML profile.
	 * 
	 * @param env
	 *            the ZDL OCL parsing environment
	 * @param profile
	 *            the UML Profile to target
	 */
	public ZDLToProfileTransformation(ZDLEnvironment env, Profile profile) {
		this.env = env;
		this.factory = env.getOCLFactory();
		this.resolver = env.getTypeResolver();

		this.profile = profile;
	}

	/**
	 * Transforms a constraint defined in ZDL terms to a constraint defined in
	 * terms of the profile generated from the source ZDL model.
	 * 
	 * @param zdlVariable
	 *            a ZDL variable
	 * @return the equivalent profile constraint, which may or may not be the
	 *         same instance as the argument
	 */
	public Variable<Classifier, Parameter> toProfileVariable(
			Variable<Classifier, Parameter> zdlVariable) {
		
		@SuppressWarnings("unused")
		Diagnostic diagnostic = new ZDLToProfileVisitor(zdlVariable)
			.transform();

		// TODO: Do something with the diagnostic

		return zdlVariable;
	}

	/**
	 * Transforms a constraint defined in ZDL terms to a constraint defined in
	 * terms of the profile generated from the source ZDL model.
	 * 
	 * @param zdlConstraint
	 *            a ZDL constraint
	 * @return the equivalent profile constraint, which may or may not be the
	 *         same instance as the argument
	 */
	public Constraint toProfileConstraint(Constraint zdlConstraint) {
		@SuppressWarnings("unused")
		Diagnostic diagnostic = new ZDLToProfileVisitor(zdlConstraint)
			.transform();

		// TODO: Do something with the diagnostic

		return zdlConstraint;
	}

	/**
	 * An OCL AST visitor that modifies, <em>in situ</em>, an OCL constraint
	 * expression to adapt it to the profile classifiers generated from the ZDL
	 * model on which the OCL constraint is defined.
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	private class ZDLToProfileVisitor
			extends
			AbstractVisitor<BasicDiagnostic, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint> {

		private Constraint constraint;
		private Visitable ast;

		/**
		 * Initializes me with the constraint that I transform from ZDL to UML.
		 * 
		 * @param zdlConstraint
		 *            the ZDL constraint
		 */
		ZDLToProfileVisitor(Constraint zdlConstraint) {
			this.constraint = zdlConstraint;
		}

		/**
		 * Initializes me with the AST node that I transform from ZDL to UML.
		 * 
		 * @param zdlAST
		 *            the ZDL AST node
		 */
		ZDLToProfileVisitor(Visitable zdlAST) {
			this.ast = zdlAST;
		}

		/**
		 * Transforms my AST node <em>in situ</em> into the profile
		 * terminology.
		 * 
		 * @return a report of problems uncovered by the transformation
		 */
		public BasicDiagnostic transform() {
			return (ast == null)
				? visitConstraint(constraint)
				: ast.accept(this);
		}

		private void warning(String message, ASTNode node) {
			problem(Diagnostic.WARNING, message, node);
		}

		private void error(String message, ASTNode node) {
			problem(Diagnostic.ERROR, message, node);
		}

		private void problem(int severity, String message, ASTNode node) {
			BasicDiagnostic diagnostic = new BasicDiagnostic(
				Diagnostic.WARNING, DIAGNOSTIC_SOURCE, 1, message,
				new Object[]{node});

			if (result == null) {
				result = diagnostic;
			} else {
				result.add(diagnostic);
			}
		}

		@Override
		protected ExpressionInOCL<Classifier, Parameter> getSpecification(
				Constraint constraint) {

			return (org.eclipse.ocl.uml.ExpressionInOCL) constraint
				.getSpecification();
		}

		@Override
		protected BasicDiagnostic handleVariable(
				Variable<Classifier, Parameter> variable,
				BasicDiagnostic initResult) {

			Classifier newType = util.toProfileClassifier(variable.getType());

			if (newType != variable.getType()) {
				variable.setType(newType);
			}

			return super.handleVariable(variable, initResult);
		}

		@Override
		public BasicDiagnostic visitVariableExp(
				VariableExp<Classifier, Parameter> v) {

			v.setType(util.toProfileClassifier(v.getType()));

			return super.visitVariableExp(v);
		}

		@Override
		protected BasicDiagnostic handlePropertyCallExp(
				PropertyCallExp<Classifier, Property> callExp,
				BasicDiagnostic sourceResult,
				List<BasicDiagnostic> qualifierResults) {

			Property original = callExp.getReferredProperty();
			Class originalOwner = original.getClass_();
			Classifier originalType = callExp.getType();

			Classifier sourceType = callExp.getSource().getType();
			Classifier targetType = util.toProfileClassifier(originalType);
			String domainAttribute = callExp.getReferredProperty().getName();

			if (sourceType instanceof Stereotype) {
				Stereotype sourceStereotype = (Stereotype) sourceType;

				Property property = util.getAttribute(sourceStereotype,
					domainAttribute);

				if (property != null) {
					// a regular stereotype property
					callExp.setReferredProperty(property);
				} else {
					// mapped to a UML meta-attribute
					String uml = util.getUMLMetaAttribute(sourceStereotype,
						domainAttribute);

					if (uml != null) {
						Class baseMetaclass = util
							.getBaseMetaclass(sourceStereotype);
						property = util.getAttribute(baseMetaclass, uml);

						callExp.setReferredProperty(property);

						// set the type to the appropriate metaclass type or,
						// in the case of multiplicity, a collection type
						targetType = resolver.resolve(env.getUMLReflection()
							.getOCLType(property));

						PropertyCallExp<Classifier, Property> base = env
							.getOCLFactory().createPropertyCallExp();
						base.setType(baseMetaclass);
						base.setReferredProperty(env.getBaseElementProperty());

						// intervene between the callExp and its original source
						base.setSource(callExp.getSource());
						callExp.setSource(base);
					}
				}
			} else if ((sourceType instanceof Class) && (originalOwner != null)
				&& !sourceType.conformsTo(originalOwner)) {
				// need to navigate from the source type to the owner of the
				// property
				Class sourceClass = (Class) sourceType;
				Class profileClass = (Class) util
					.toProfileClassifier(originalOwner);

				if (sourceClass.isMetaclass()
					&& (profileClass instanceof Stereotype)) {

					Stereotype stereotype = (Stereotype) profileClass;

					// find the corresponding stereotype property
					Property property = util.getAttribute(stereotype,
						domainAttribute);

					if (property != null) {
						// insert an oclAsType() cast to navigate to the
						// stereotype
						OperationCallExp<Classifier, Operation> cast = createOclAsType(profileClass);
						cast.setSource(callExp.getSource());
						callExp.setSource(cast);

						// map to the stereotype property
						callExp.setReferredProperty(property);
					} else {
						// must be mapped to a UML meta-attribute
						String uml = util.getUMLMetaAttribute(stereotype,
							domainAttribute);

						if (uml != null) {
							// in this case, don't insert a cast to the
							// stereotype
							property = util.getAttribute(sourceClass, uml);
							
							if (property == null) {
								// it *should* be a property of the stereotype's
								// extended metaclass, then
								Class base = util.getBaseMetaclass(stereotype);
								if (base != null) {
									property = util.getAttribute(base, uml);
								}
							}

							if (property != null) {
								// set the type to the appropriate metaclass type or,
								// in the case of multiplicity, a collection type
								targetType = resolver.resolve(env.getUMLReflection()
									.getOCLType(property));
							}
							
							// but do replace the property reference
							callExp.setReferredProperty(property);
						} else {
							warning(
								NLS
									.bind(
										Messages.ZDLToProfileTransformation_noSuchAttr,
										domainAttribute, sourceClass
											.getQualifiedName()), callExp);
						}
					}
				} else if (sourceClass.conformsTo(profileClass)) {
					// this covers the case of navigating a property of a
					// Class in the profile. In the case of a property of a
					// UML metaclass, the sourceType would already have been
					// found to conform to the original property owner
					Property property = util.getAttribute(profileClass,
						domainAttribute);
					if (property != null) {
						callExp.setReferredProperty(property);
					} else {
						warning(NLS.bind(
							Messages.ZDLToProfileTransformation_noSuchAttr,
							domainAttribute, sourceClass.getQualifiedName()),
							callExp);
					}
				} else {
					// this is some other unsupported combination of
					// incompatible classes, so the original ZDL constraint
					// should never have parsed
					error(NLS.bind(
						Messages.ZDLToProfileTransformation_noConversion,
						sourceClass.getQualifiedName(), profileClass
							.getQualifiedName()), callExp);
				}
			}

			callExp.setType(targetType);

			// handle mismatched upper bound
			Property property = callExp.getReferredProperty();
			if (original.isMultivalued() != property.isMultivalued()) {
				if (original.isMultivalued()) {
					// narrowing a collection to a scalar
					CollectionType ctype = (CollectionType) originalType;
					coerceToCollection(callExp, (CollectionType) resolver
						.resolveCollectionType(ctype.getKind(), targetType));
				} else {
					// widening a scalar to a collection
					CollectionType ctype = (CollectionType) targetType;
					coerceToScalar(callExp, ctype.getElementType());
				}
			}

			return super.handlePropertyCallExp(callExp, sourceResult,
				qualifierResults);
		}

		/**
		 * Creates a new singleton collection literal of the specified type and
		 * containing the given expression as its single element. The new
		 * collection-literal expression takes the place of the scalar
		 * expression in the enclosing expression context.
		 * 
		 * @param expr
		 *            a scalar expression to coerce to a singleton collection of
		 *            the specified collection type
		 * @param newType
		 *            the collection type
		 */
		private void coerceToCollection(OCLExpression<Classifier> expr,
				CollectionType newType) {
			CollectionLiteralExp<Classifier> newExp = factory
				.createCollectionLiteralExp();
			newExp.setType(newType);
			newExp.setKind(newType.getKind());

			CollectionItem<Classifier> item = factory.createCollectionItem();
			item.setItem(expr);
			item.setType(expr.getType());

			EcoreUtil.replace(expr, newExp);
			newExp.getPart().add(item);
		}

		/**
		 * Coerces the specified collection-valued expression to a scalar of the
		 * given type by extract the first available element using the
		 * <tt>any</tt> iterator. The new collection-literal expression takes
		 * the place of the scalar expression in the enclosing expression
		 * context.
		 * 
		 * @param expr
		 *            a scalar expression to coerce to a singleton collection of
		 *            the specified collection type
		 * @param newType
		 *            the collection type
		 */
		private void coerceToScalar(OCLExpression<Classifier> expr,
				Classifier newType) {
			IteratorExp<Classifier, Parameter> newExp = factory
				.createIteratorExp();
			newExp.setName(PredefinedType.ANY_NAME);
			newExp.setType(newType);

			Variable<Classifier, Parameter> iterVar = factory.createVariable();
			iterVar.setType(newType);
			createIteratorVariableName(iterVar);
			newExp.getIterator().add(iterVar);

			BooleanLiteralExp<Classifier> bodyExp = factory
				.createBooleanLiteralExp();
			bodyExp.setType(env.getOCLStandardLibrary().getBoolean());
			bodyExp.setBooleanSymbol(Boolean.TRUE);
			newExp.setBody(bodyExp);

			EcoreUtil.replace(expr, newExp);
			newExp.setSource(expr);
		}

		/**
		 * Creates a name suitable for use as an iterator variable name, that is
		 * certain to be unique (because the name could never have been parsed
		 * according to the OCL grammar).
		 * 
		 * @param var
		 *            the iterator variable whose name is to be set
		 */
		private void createIteratorVariableName(
				Variable<Classifier, Parameter> var) {
			var.setName("*" + Integer.toHexString(var.hashCode())); //$NON-NLS-1$
		}

		@Override
		protected BasicDiagnostic handleIteratorExp(
				IteratorExp<Classifier, Parameter> callExp,
				BasicDiagnostic sourceResult,
				List<BasicDiagnostic> variableResults,
				BasicDiagnostic bodyResult) {

			// source and variables have already been transformed.
			// We know there is at least one iterator variable because the
			// expression couldn't have parsed in the first place without it.
			// Also, we know that the call exp source type is a collection type
			Classifier sourceType = ((CollectionType) callExp.getSource()
				.getType()).getElementType();
			Classifier iterVarType = callExp.getIterator().get(0).getType();

			if ((sourceType instanceof Stereotype)
				&& !(iterVarType instanceof Stereotype)) {
				// insert a collect expression that navigates to the base
				// elements
				OCLExpression<Classifier> collect = createCollectExpression(
					callExp.getSource(), env.getBaseElementProperty());
				callExp.setSource(collect);
			} else if (!(sourceType instanceof Stereotype)
				&& (iterVarType instanceof Stereotype)) {
				// insert a collect expression that navigates to the applied
				// stereotype
				Stereotype stereotype = (Stereotype) iterVarType;
				Property extensionEnd = getExtensionEnd((Class) sourceType,
					stereotype);
				OCLExpression<Classifier> collect = createCollectExpression(
					callExp.getSource(), extensionEnd);

				// append a filter to remove nulls generated by the stereotype
				// navigation
				OperationCallExp<Classifier, Operation> nullFilterExp = createExcludesNull((CollectionType) collect
					.getType());
				nullFilterExp.setSource(collect);
				callExp.setSource(nullFilterExp);
			}

			callExp.setType(getIteratorResultType(callExp));

			return super.handleIteratorExp(callExp, sourceResult,
				variableResults, bodyResult);
		}
		
		/**
		 * Computes the profile-specific result type of an iterator expression
		 * whose source, variables, and body expression have been transformed.
		 * 
		 * @param callExp
		 *            an iterator expression
		 * 
		 * @return its appropriate result type
		 */
		private Classifier getIteratorResultType(
				IteratorExp<Classifier, Parameter> callExp) {
			
			Classifier result;

			CollectionType sourceType = (CollectionType) callExp.getSource()
				.getType();
			int code = OCLStandardLibraryUtil.getOperationCode(callExp
				.getName());

			switch (code) {
				case PredefinedType.FOR_ALL :
				case PredefinedType.EXISTS :
				case PredefinedType.ONE :
				case PredefinedType.IS_UNIQUE :
					// the type is the unique OCL Boolean type
					result = callExp.getType();
					break;
				case PredefinedType.SELECT :
				case PredefinedType.REJECT :
					// the type is based solely on the source collection type,
					// not the body expression
					result = util.toProfileClassifier(sourceType);
					break;
				case PredefinedType.COLLECT : {
					// The result type for collect must be flattened
					Classifier elementType = callExp.getBody().getType();
					while (elementType instanceof CollectionType) {
						CollectionType ct = (CollectionType) elementType;
						elementType = ct.getElementType();
					}

					switch (sourceType.getKind()) {
						case SEQUENCE_LITERAL :
						case ORDERED_SET_LITERAL :
							result = TypeUtil.resolveSequenceType(env,
								elementType);
							break;
						default :
							result = TypeUtil.resolveBagType(env, elementType);
							break;
					}
					break;
				}
				case PredefinedType.COLLECT_NESTED : {
					Classifier elementType = callExp.getBody().getType();
					switch (sourceType.getKind()) {
						case SEQUENCE_LITERAL :
						case ORDERED_SET_LITERAL :
							result = TypeUtil.resolveSequenceType(env,
								elementType);
							break;
						default :
							result = TypeUtil.resolveBagType(env, elementType);
							break;
					}
					break;
				}
				case PredefinedType.ANY :
					result = util.toProfileClassifier(sourceType
						.getElementType());
					break;
				case PredefinedType.SORTED_BY :
					switch (sourceType.getKind()) {
						case SEQUENCE_LITERAL :
						case BAG_LITERAL :
							result = TypeUtil.resolveSequenceType(env,
								sourceType.getElementType());
							break;
						default :
							result = TypeUtil.resolveOrderedSetType(env,
								sourceType.getElementType());
							break;
					}
					break;
				case PredefinedType.CLOSURE : {
					// get the body element type if it is a collection-type
					// expression
					Classifier bodyType = callExp.getBody().getType();
					if (bodyType instanceof CollectionType) {
						CollectionType ct = (CollectionType) bodyType;
						bodyType = ct.getElementType();
					}

					result = TypeUtil.resolveSetType(env, bodyType);
					break;
				}
				default :
					// shouldn't get to this case, as these are all of the
					// known iterators
					result = util.toProfileClassifier(sourceType);
					break;
			}

			return result;
		}

		/**
		 * Obtains the extension end that we need to navigate in order to get
		 * from an instance of the specified metaclass to the application of the
		 * given stereotype.
		 * 
		 * @param metaclass
		 *            a UML metaclass
		 * @param stereotype
		 *            a stereotype that extends it (directly or not)
		 * @return the extension end
		 */
		private ExtensionEnd getExtensionEnd(Class metaclass,
				Stereotype stereotype) {
			ExtensionEnd result = null;

			for (Property next : stereotype.getAllAttributes()) {
				if ((next.getType() != null)
					&& next.getType().conformsTo(metaclass)
					&& (next.getOtherEnd() instanceof ExtensionEnd)) {
					
					result = (ExtensionEnd) next.getOtherEnd();
					break;
				}
			}

			return result;
		}

		/**
		 * Creates a <tt>collect</tt> iterator expression that collects values
		 * of the specified <tt>property</tt> from a given <tt>source</tt>
		 * expression.
		 * 
		 * @param source
		 *            a source expression
		 * @param property
		 *            the property to collect from values of the source
		 * 
		 * @return the collect expression
		 */
		private OCLExpression<Classifier> createCollectExpression(
				OCLExpression<Classifier> source, Property property) {
			// create the iterator expression
			IteratorExp<Classifier, Parameter> result = factory
				.createIteratorExp();
			result.setName(PredefinedType.COLLECT_NAME);
			result.setSource(source);

			// an iterator expression always has a collection type as source
			CollectionType sourceType = (CollectionType) source.getType();
			Classifier resultType = (Classifier) property.getType();

			// create the iterator variable
			Variable<Classifier, Parameter> iterVar = factory.createVariable();
			iterVar.setType(sourceType.getElementType());
			createIteratorVariableName(iterVar);
			result.getIterator().add(iterVar);

			// create the body expression, which is a property call on a
			// variable expression
			VariableExp<Classifier, Parameter> varExp = factory
				.createVariableExp();
			varExp.setReferredVariable(iterVar);
			PropertyCallExp<Classifier, Property> callExp = factory
				.createPropertyCallExp();
			callExp.setSource(varExp);
			callExp.setReferredProperty(property);
			callExp.setType(resultType);
			result.setBody(callExp);

			// the "collect" iterator flattens the result
			if (resultType instanceof CollectionType) {
				resultType = ((CollectionType) resultType).getElementType();
			}

			// set the appropriate iterator expression type according to the
			// source collection kind
			switch (sourceType.getKind()) {
				case SEQUENCE_LITERAL :
				case ORDERED_SET_LITERAL :
					result.setType(TypeUtil
						.resolveSequenceType(env, resultType));
					break;
				default :
					result.setType(TypeUtil.resolveBagType(env, resultType));
					break;
			}

			return result;
		}

		/**
		 * Creates a property-call expression that navigates the specified
		 * <tt>property</tt> from a given <tt>source</tt> expression.
		 * 
		 * @param source
		 *            a source expression
		 * @param property
		 *            the property to navigate from the source
		 * 
		 * @return the property-call expression
		 */
		private OCLExpression<Classifier> createPropertyCallExpression(
				OCLExpression<Classifier> source, Property property) {
			
			Classifier resultType = (Classifier) property.getType();
			
			// create the property-call expression
			PropertyCallExp<Classifier, Property> result = factory
				.createPropertyCallExp();
			result.setSource(source);
			result.setReferredProperty(property);
			result.setType(resultType);
			
			return result;
		}

		/**
		 * Creates an <tt>{@literal ->excludes(null)}</tt> expression to
		 * append to an iterator expression in order to filter out the null
		 * values that result from attempted navigation to stereotype instances.
		 * 
		 * @param sourceType
		 *            the source iterator's result type
		 * @return the new operation call. The source is not set
		 */
		private OperationCallExp<Classifier, Operation> createExcludesNull(
				CollectionType sourceType) {
			OperationCallExp<Classifier, Operation> result = factory
				.createOperationCallExp();
			result.setOperationCode(PredefinedType.EXCLUDING);

			NullLiteralExp<Classifier> nullLiteral = factory
				.createNullLiteralExp();
			nullLiteral.setType(env.getOCLStandardLibrary().getOclVoid());
			result.getArgument().add(nullLiteral);

			Operation excluding = env.lookupOperation(sourceType,
				PredefinedType.EXCLUDING_NAME, Collections
					.singletonList(nullLiteral));
			result.setReferredOperation(excluding);

			// excluding results in a collection of the same type
			result.setType(sourceType);

			return result;
		}

		/**
		 * Creates an <tt>{@literal oclAsType(classifier)}</tt> expression to
		 * cast from a source type (e.g., a UML metaclass) to a target type
		 * (e.g., an applied stereotype). The particular example of casting from
		 * a metaclass to a stereotype is particularly useful, as the ZDL
		 * environment implements this as an extension navigation.
		 * 
		 * @param classifier
		 *            the classifier to cast to
		 * @return the new operation call. The source is not set
		 */
		private OperationCallExp<Classifier, Operation> createOclAsType(
				Classifier classifier) {
			OperationCallExp<Classifier, Operation> result = factory
				.createOperationCallExp();
			result.setOperationCode(PredefinedType.OCL_AS_TYPE);

			TypeExp<Classifier> typeExp = factory.createTypeExp();
			typeExp.setReferredType(classifier);
			typeExp.setType((Classifier) resolver.resolveTypeType(classifier));
			result.getArgument().add(typeExp);

			Operation oclAsType = env.lookupOperation(env
				.getOCLStandardLibrary().getOclAny(),
				PredefinedType.OCL_AS_TYPE_NAME, Collections
					.singletonList(typeExp));
			result.setReferredOperation(oclAsType);

			// oclAsType results in the target classifier
			result.setType(classifier);

			return result;
		}

		@Override
		public BasicDiagnostic visitTypeExp(TypeExp<Classifier> t) {
			t.setReferredType(util.toProfileClassifier(t.getReferredType()));
			t.setType(util.toProfileClassifier(t.getType()));

			return super.visitTypeExp(t);
		}

		@Override
		protected BasicDiagnostic handleOperationCallExp(
				OperationCallExp<Classifier, Operation> callExp,
				BasicDiagnostic sourceResult,
				List<BasicDiagnostic> argumentResults) {

			Classifier sourceType = util.toProfileClassifier(callExp
				.getSource().getType());
			
			// coerce any arguments from stereotype instances to their base UML
			// elements where required.  For any operation whose source
			// expression is of a metaclass type, its arguments must also be
			// metaclasses, because an operation in the UML metamodel (or in
			// OCL) would obviously not know about the ZDL world.
			// On the other hand, if the source expression is of a non-metaclass
			// type, then the operation must be an OCL-defined operation.  There
			// are a number of generic operations in the OCL Standard Library
			// (in particular, in the OclAny type and the collection types) that
			// will accept stereotype or profile-class instances, so we leave
			// those as they are
			if (!callExp.getArgument().isEmpty() && util.isMetaclass(sourceType)) {
				@SuppressWarnings("unchecked")
				OCLExpression<Classifier>[] args = callExp.getArgument()
					.toArray(new OCLExpression[callExp.getArgument().size()]);
				
				// numerous OCL Standard Library operations use type parameters
				Operation oper = TypeUtil.resolveGenericSignature(env, callExp
					.getSource().getType(), callExp.getReferredOperation());
				
				EList<Parameter> parms = oper.getOwnedParameters();
				
				for (int a = 0, p = 0; a < args.length; a++, p++) {
					OCLExpression<Classifier> arg = args[a];
					Parameter parm = parms.get(p);
					while (parm.getDirection() == ParameterDirectionKind.RETURN_LITERAL) {
						parm = parms.get(++p);
					}

					Classifier parmType = env.getUMLReflection().getOCLType(
						parm);
					Classifier argType = arg.getType();
					
					if (util.isStereotype(argType) && !util.isStereotype(parmType)) {
						// need to coerce the argument type. We know that the
						// argument type is a stereotype, and thus to coerce by
						// navigating to the base element, because operations
						// cannot be defined in ZDL, so they are necessarily
						// UML- or OCL-defined operations
						OCLExpression<Classifier> newArg;

						if (argType instanceof CollectionType) {
							newArg = createCollectExpression(arg, env
								.getBaseElementProperty());
						} else {
							newArg = createPropertyCallExpression(arg, env
								.getBaseElementProperty());
						}

						// the old argument was already removed from its
						// container when it was made the source of the
						// replacement call expression
						callExp.getArgument().add(a, newArg);
					}
				}
			}

			if ((sourceType instanceof PredefinedType)
				&& (callExp.getOperationCode() == PredefinedType.ALL_INSTANCES)) {

				// handle allInstances() and collection operations
				callExp.setType(OCLStandardLibraryUtil.getResultTypeOf(callExp,
					env, sourceType, callExp.getOperationCode(), callExp
						.getArgument()));
			} else if (callExp.getOperationCode() == PredefinedType.OCL_AS_TYPE) {
				// handle oclAsType() conversion. We know there was
				// exactly one argument because the original OCL parsed
				TypeType typeType = (TypeType) callExp.getArgument().get(0)
					.getType();
				callExp.setType(typeType.getReferredType());
			} else {
				callExp.setType(util.toProfileClassifier(callExp.getType()));
			}

			return super.handleOperationCallExp(callExp, sourceResult,
				argumentResults);
		}

		@Override
		public BasicDiagnostic visitEnumLiteralExp(
				EnumLiteralExp<Classifier, EnumerationLiteral> literalExp) {

			EnumerationLiteral literal = literalExp.getReferredEnumLiteral();
			Enumeration enumeration = literal.getEnumeration();
			enumeration = (Enumeration) util.toProfileClassifier(enumeration);

			if (enumeration != null) {
				// if it's null, then it is an enumeration from the UML
				// metamodel
				literalExp.setReferredEnumLiteral(enumeration
					.getOwnedLiteral(literal.getName()));
				literalExp.setType(enumeration);
			}

			return super.visitEnumLiteralExp(literalExp);
		}
	}

	/**
	 * A specialization of the {@link ZDLUtil} that provides additional services
	 * for OCL constraint transformation.
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	private class OCLZDLUtil
			extends ZDLUtil {

		/**
		 * An UML switch that resolves ZDL classifiers to their corresponding
		 * profile classifiers.
		 */
		private org.eclipse.uml2.uml.util.UMLSwitch<Classifier> umlTypes = new org.eclipse.uml2.uml.util.UMLSwitch<Classifier>() {

			@Override
			public Classifier caseClass(Class object) {
				Classifier result = object;

				if (ZDLUtil.isZDLConcept(object, ZDLNames.DOMAIN_CONCEPT)) {
					result = ZDLUtil.getProfileClass(profile, object);
				}

				return result;
			}

			// this method covers Enumerations, also
			@Override
			public Classifier caseDataType(DataType object) {
				Classifier result = object;

				if (ZDLUtil.isZDLConcept(object, ZDLNames.DOMAIN_DATA_TYPE)) {
					// these are always generated into the profile
					for (Type next : profile.getOwnedTypes()) {
						if (ZDLUtil.tracesToZDL(next, object)) {
							result = (Classifier) next;
							break;
						}
					}
				}

				return result;
			}
		};

		/**
		 * An OCL-UML switch that resolves ZDL-based OCL types to their
		 * corresponding profile-based types.
		 */
		private UMLSwitch<Classifier> oclTypes = new UMLSwitch<Classifier>() {

			@Override
			public Classifier defaultCase(EObject object) {
				// maybe it's a pure-UML type? Delegate to the umlTypes switch
				return umlTypes.doSwitch(object);
			}

			@Override
			public Classifier caseCollectionType(CollectionType object) {
				return (Classifier) resolver.resolveCollectionType(object
					.getKind(), doSwitch(object.getElementType()));
			}

			@Override
			public Classifier caseTypeType(TypeType object) {
				return (Classifier) resolver.resolveTypeType(doSwitch(object
					.getReferredType()));
			}

			@Override
			public Classifier caseTupleType(TupleType object) {
				List<Property> parts = object.oclProperties();
				EList<Variable<Classifier, Parameter>> defs = new BasicEList<Variable<Classifier, Parameter>>(
					parts.size());

				for (Property next : parts) {
					Variable<Classifier, Parameter> var = factory
						.createVariable();
					var.setName(next.getName());
					var.setType(doSwitch(next.getType()));

					defs.add(var);
				}

				return (Classifier) resolver.resolveTupleType(defs);
			}
		};

		/**
		 * Converts the specified domain-concept-based type to a type based on
		 * the corresponding profile classifier. This accounts for collection
		 * types, tuple types, and other OCL classifiers that reference model
		 * types. The conversion is idempotent on types that are not related to
		 * ZDL concepts.
		 * 
		 * @param concept
		 *            an OCL type possibly based on a ZDL concept
		 * @return the type based on the corresponding profile type
		 */
		Classifier toProfileClassifier(Type concept) {
			return oclTypes.doSwitch(concept);
		}

		/**
		 * Delegates to the superclass implementation; makes the inherited
		 * method accessible in this package.
		 * 
		 * @param stereotype
		 *            a stereotype
		 * @param property
		 *            a property name
		 * 
		 * @return the named attribute of the extended metaclass
		 */
		String getUMLMetaAttribute(Stereotype stereotype, String property) {
			return super.getUMLMetaattribute(stereotype, property);
		}

		/**
		 * Obtains the named attribute (possibly inherited) of the specified
		 * classifier.
		 * 
		 * @param classifier
		 *            a classifier
		 * @param name
		 *            an attribute name
		 * @return the attribute, or <code>null</code> if not found
		 */
		Property getAttribute(Classifier classifier, String name) {
			return ZDLUtil.getAttribute(classifier, name, null);
		}

		/**
		 * Computes a single "base metaclass" for the specified stereotype. This
		 * is the least common supertype of the extended metaclasses, or the
		 * inherited extended metaclasses if this stereotype doesn't have its
		 * own extensions.
		 * 
		 * @param stereotype
		 *            a stereotype
		 * @return an unique base metaclass
		 */
		Class getBaseMetaclass(Stereotype stereotype) {
			Class result = null;

			List<Class> extended = stereotype.getExtendedMetaclasses();

			if (extended.size() == 1) {
				result = extended.get(0);
			} else if (extended.size() > 1) {
				// get the least common ancestor of the extended metaclasses
				result = extended.get(0);
				for (int i = 1; i < extended.size(); i++) {
					result = (Class) env.getUMLReflection().getCommonSuperType(
						result, extended.get(i));
				}
			} else {
				for (Class next : stereotype.getSuperClasses()) {
					Stereotype parent = (Stereotype) next;

					result = getBaseMetaclass(parent);
					if (result != null) {
						break;
					}
				}
			}

			return result;
		}
		
		/**
		 * Queries whether a classifier is a UML stereotype or a collection type
		 * based (recursively) on a UML stereotype.
		 * 
		 * @param classifier
		 *            a classifier
		 * @return whether it is a stereotype or is based on a stereotype
		 */
		boolean isStereotype(Classifier classifier) {
			while (classifier instanceof CollectionType) {
				classifier = ((CollectionType) classifier).getElementType();
			}
			
			return classifier instanceof Stereotype;
		}
		
		/**
		 * Queries whether a classifier is a UML metaclass or a collection type
		 * based (recursively) on a UML metaclass.
		 * 
		 * @param classifier
		 *            a classifier
		 * @return whether it is a metaclass or is based on a metaclass
		 */
		boolean isMetaclass(Classifier classifier) {
			while (classifier instanceof CollectionType) {
				classifier = ((CollectionType) classifier).getElementType();
			}

			return (classifier instanceof Class)
				&& ((Class) classifier).isMetaclass();
		}
	}
}
