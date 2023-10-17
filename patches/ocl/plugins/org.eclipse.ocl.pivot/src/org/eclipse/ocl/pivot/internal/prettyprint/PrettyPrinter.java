/*******************************************************************************
 * Copyright (c) 2011, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.prettyprint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Precedence;
import org.eclipse.ocl.pivot.TemplateBinding;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.manager.PrecedenceManager;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrintOptions.Global;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactory;
import org.eclipse.ocl.pivot.internal.utilities.PathElement;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.util.AbstractVisitor;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.StringUtil;
import org.eclipse.ocl.pivot.utilities.URIUtil;
import org.eclipse.ocl.pivot.values.Unlimited;

/**
 * The PrettyPrinter supports pretty printing.
 * PrettyPrintOptions may be used to configure the printing.
 */
public class PrettyPrinter
{
	public static final @NonNull String NULL_PLACEHOLDER = "<null>";
	@SuppressWarnings("null")
	public static @NonNull List<@NonNull String> reservedNameList = Arrays.asList("and", "else", "endif", "false", "if", "implies", "in", "invalid", "let", "not", "null", "or", PivotConstants.SELF_NAME, "then", "true", "xor");
	@SuppressWarnings("null")
	public static @NonNull List<@NonNull String> restrictedNameList = Arrays.asList(TypeId.BAG_NAME, TypeId.BOOLEAN_NAME, "Collection", TypeId.INTEGER_NAME, TypeId.OCL_ANY_NAME, TypeId.OCL_INVALID_NAME, TypeId.OCL_VOID_NAME, TypeId.ORDERED_SET_NAME, TypeId.REAL_NAME, TypeId.SEQUENCE_NAME, TypeId.SET_NAME, TypeId.STRING_NAME, TypeId.TUPLE_NAME, TypeId.UNLIMITED_NATURAL_NAME);

	private static class Fragment
	{
		private final int depth;
		private final @Nullable String prefix;		// null for manditory continuation  of previous fragment
		private final @NonNull String text;
		private final @Nullable String suffix;
		private @Nullable Fragment parent = null;
		private List<@NonNull Fragment> children = null;
		private boolean lineWrap = true;
		private boolean exdented = false;

		public Fragment(@Nullable Fragment parent, int depth, @Nullable String prefix, @NonNull String text, @Nullable String suffix) {
			this.parent = parent;
			this.depth = depth;
			this.prefix = prefix;
			this.text = text;
			this.suffix = suffix;
		}

		public @NonNull Fragment addChild(@Nullable String prefix, @NonNull String text, @Nullable String suffix) {
			//			assert (prefix.length() + text.length() + suffix.length()) > 0;
			if (children == null) {
				children = new ArrayList<>();
			}
			Fragment child = new Fragment(this, depth+1, prefix, text, suffix);
			children.add(child);
			return child;
		}

		public void configureLineWrapping(int spacesPerIndent, int lineLength) {
			int firstColumn = depth * spacesPerIndent;
			int lastColumn = firstColumn + text.length();
			if (prefix != null) {
				lastColumn += prefix.length();
			}
			if (suffix != null) {
				lastColumn += suffix.length();
			}
			if (children != null) {
				for (Fragment child : children) {
					child.lineWrap = true;
					child.configureLineWrapping(spacesPerIndent, lineLength);
				}
				int allChildrenLength = getChildrenLength(true);
				if (lastColumn + allChildrenLength <= lineLength) {
					//					System.out.println(depth + " '" + prefix + "'+'" + text + "'+'" + suffix + "' "
					//							+ lastColumn + "+" + allChildrenLength + "<=" + lineLength);
					for (Fragment child : children) {
						child.lineWrap = false;
					}
				}
				else {
					//					System.out.println(depth + " '" + prefix + "'+'" + text + "'+'" + suffix + "' "
					//							+ lastColumn + "+" + allChildrenLength + ">" + lineLength);
					//					int firstChildLength = getChildLength(0);
					//					if (lastColumn + allChildrenLength <= lineLength) {
					for (Fragment child : children) {
						child.lineWrap = child.exdented;
					}
					//					}
				}
				//				while (lastColumn < lineLength) {
				//					lastColumn = getChildrenLength(spacesPerIndent, lineLength, lastColumn);
				//				}
			}
			else {
				//				System.out.println(depth + " '" + prefix + "'+'" + text + "'+'" + suffix + "' "
				//						+ lastColumn);
			}
			if (parent == null) {
				lineWrap = false;
			}
		}

		public int getChildrenLength(Boolean concatenate) {
			int childrenLength = 0;
			for (int iChild = 0; iChild < children.size(); iChild++) {
				int childLength = getChildLength(iChild);
				if (concatenate == Boolean.TRUE) {
					childrenLength += childLength;
				}
				else if (childLength > childrenLength) {
					childrenLength = childLength;
				}
			}
			return childrenLength;
		}

		public int getChildLength(int iChild) {
			Fragment child = children.get(iChild);
			int childLength = child.length();
			for (int jChild = iChild+1; jChild < children.size(); jChild++) {
				Fragment nextChild = children.get(jChild);
				if ((nextChild.prefix != null) && nextChild.lineWrap) {
					break;
				}
				childLength += child.length();
			}
			return childLength;
		}

		public int length() {
			int length = text.length();
			if (prefix != null) {
				length += prefix.length();
			}
			if (suffix != null) {
				length += suffix.length();
			}
			if (children != null) {
				length += getChildrenLength(null);
			}
			return length;
		}

		public @Nullable Fragment getParent() {
			return parent;
		}

		@Override
		public String toString() {
			StringBuilder s = new StringBuilder();
			toString(s, null, "  ");
			return s.toString();
		}

		public String toString(@NonNull StringBuilder s, String newLine, String indent) {
			if ((lineWrap || (newLine != null)) && (prefix != null)) {
				if (lineWrap) {
					newLine = "\n";
				}
				s.append(newLine);
				if (text.length() > 0) {
					if ((newLine != null) && newLine.equals("\n")) {
						for (int i = 1; i < depth; i++) {
							s.append(indent);
						}
					}
					else {
						s.append(prefix);
					}
				}
				else if ((prefix != null) && (prefix.length() > 0)) {
					s.append(prefix);
				}
			}
			s.append(text);
			//			newLine = suffix != null ? lineWrap ? "\n" : suffix : null;
			newLine = suffix;
			if (children != null) {
				for (Fragment child : children) {
					newLine = child.toString(s, newLine, indent);
				}
			}
			return newLine;
		}
	}

	public static @NonNull PrettyPrinter createNamePrinter(@NonNull Element element, @NonNull PrettyPrintOptions options) {
		return new PrettyPrinter(options, Mode.NAME, element);
	}

	public static @NonNull PrettyPrinter createPrinter(@NonNull Element element, @NonNull PrettyPrintOptions options) {
		return new PrettyPrinter(options, Mode.FULL, element);
	}

	public static @NonNull Global createOptions(@Nullable Namespace scope) {
		PrettyPrintOptions.Global options = new PrettyPrintOptions.Global(scope);
		options.addReservedNames(PrettyPrinter.reservedNameList);
		options.addRestrictedNames(PrettyPrinter.reservedNameList);
		//		options.setUseParentheses(true);
		return options;
	}

	public static @NonNull String print(@NonNull Element element) {
		return print(element, createOptions(null));
	}
	public static @NonNull String print(@NonNull Element element, @NonNull Namespace namespace) {
		return print(element, createOptions(namespace));
	}
	public static @NonNull String print(@NonNull Element element, @NonNull PrettyPrintOptions options) {
		PrettyPrinter printer = new PrettyPrinter(options, Mode.FULL, element);
		try {
			printer.appendElement(element);
			String string = printer.toString();
			assert string != null;
			return string;
		}
		catch (Exception e) {
			e.printStackTrace();
			return printer.toString() + " ... " + e.getClass().getName() + " - " + e.getLocalizedMessage();
		}
	}

	public static @NonNull String printName(@NonNull Element element) {
		return printName(element, createOptions(null));
	}
	public static @NonNull String printName(@NonNull Element element, @NonNull Namespace namespace) {
		return printName(element, createOptions(namespace));
	}
	public static @NonNull String printName(@NonNull Element element, @NonNull PrettyPrintOptions options) {
		PrettyPrinter printer = createNamePrinter(element, options);
		try {
			printer.appendElement(element);
			String string = printer.toString();
			assert string != null;
			return string;
		}
		catch (Exception e) {
			e.printStackTrace();
			return printer.toString() + " ... " + e.getClass().getName() + " - " + e.getLocalizedMessage();
		}
	}

	public static @NonNull String printType(@NonNull Element element) {
		return printType(element, createOptions(null));
	}
	public static @NonNull String printType(@NonNull Element element, @NonNull Namespace namespace) {
		return printType(element, createOptions(namespace));
	}
	public static @NonNull String printType(@NonNull Element element, @NonNull PrettyPrintOptions options) {
		PrettyPrinter printer = new PrettyPrinter(options, Mode.TYPE, element);
		try {
			printer.appendElement(element);
			String string = printer.toString();
			assert string != null;
			return string;
		}
		catch (Exception e) {
			e.printStackTrace();
			return printer.toString() + " ... " + e.getClass().getName() + " - " + e.getLocalizedMessage();
		}
	}

	private enum Mode { TYPE, NAME, FULL };

	private final @NonNull PrettyPrintOptions options;
	private String pendingPrefix = "";
	private final @NonNull StringBuilder pendingText;
	protected Fragment fragment;
	private @NonNull Mode mode;
	private final AbstractVisitor<Object, PrettyPrinter> visitor;
	private @Nullable Namespace scope;
	private @Nullable Precedence currentPrecedence = null;
	private @Nullable PrecedenceManager precedenceManager;

	/**
	 * Initializes me.
	 * @param element
	 */
	private PrettyPrinter(@NonNull PrettyPrintOptions options, @NonNull Mode mode, @NonNull Element element) {
		this.options = options;
		this.mode = mode;
		this.scope = options.getScope();
		pendingText = new StringBuilder();
		fragment = new Fragment(null, 0, "", "", "");
		Resource eResource = element.eResource();
		ASResourceFactory asResourceFactory = eResource instanceof ASResource ? ((ASResource) eResource).getASResourceFactory() : null;
		this.visitor = asResourceFactory != null ? asResourceFactory.createPrettyPrintVisitor(this) : new PrettyPrintVisitor(this);
		PrecedenceManager precedenceManager = null;
		Resource asResource = element.eResource();
		if (asResource != null) {
			PivotMetamodelManager metamodelManager = PivotUtilInternal.findMetamodelManager(asResource);
			if (metamodelManager != null) {
				precedenceManager = metamodelManager.getPrecedenceManager();
			}
		}
		this.precedenceManager = precedenceManager;
	}

	public void append(Number number) {
		if (number != null) {
			append(number.toString());
		}
		else {
			append(NULL_PLACEHOLDER);
		}
	}

	public void append(String string) {
		if (string != null) {
			pendingText.append(string);
		}
		else {
			pendingText.append(NULL_PLACEHOLDER);
		}
	}

	public void appendElement(@Nullable Element element) {
		visitor.safeVisit(element);
	}

	public void appendMultiplicity(@Nullable Number lower, @Nullable Number upper, boolean isNullFree) {
		StringUtil.appendMultiplicity(pendingText, lower != null ? lower.longValue() : 0,
			(upper == null) || (upper instanceof Unlimited) ? -1 : upper.longValue(), isNullFree);
	}

	public void appendName(NamedElement object) {
		appendName(object, options.getRestrictedNames());
	}

	public void appendName(NamedElement object, Set<String> keywords) {
		append(getName(object, keywords));
	}

	public void appendParameters(@NonNull Operation operation, boolean withNames) {
		append("(");
		String prefix = ""; //$NON-NLS-1$
		if (operation instanceof Iteration) {
			Iteration iteration = (Iteration)operation;
			for (Parameter parameter : PivotUtil.getOwnedIterators(iteration)) {
				append(prefix);
				if (withNames) {
					appendName(parameter);
					append(" : ");
				}
				appendTypedMultiplicity(parameter);
				prefix = ", ";
			}
			if (iteration.getOwnedAccumulators().size() > 0) {
				prefix = "; ";
				for (Parameter parameter : PivotUtil.getOwnedAccumulators(iteration)) {
					if (withNames) {
						appendName(parameter);
						append(" : ");
					}
					append(prefix);
					appendTypedMultiplicity(parameter);
					prefix = ", ";
				}
			}
			prefix = " | ";
		}
		for (Parameter parameter : PivotUtil.getOwnedParameters(operation)) {
			append(prefix);
			if (withNames) {
				appendName(parameter);
				append(" : ");
			}
			appendTypedMultiplicity(parameter);
			prefix = ", ";
		}
		append(")");
	}

	public void appendParent(EObject scope, Element element, String parentSeparator) { // FIXME Use appendQualifiedName instead
		if (element instanceof org.eclipse.ocl.pivot.Package) {
			String alias = options.getAlias((org.eclipse.ocl.pivot.Package)element);
			if (alias != null) {
				append(alias);
				append(parentSeparator);
				return;
			}
		}
		Mode savedMode = pushMode(Mode.TYPE);
		try {
			for (EObject eObject = scope; eObject != null; eObject = eObject.eContainer()) {
				if (element == eObject) {
					return;
				}
			}
			//		if (toString().length() >= MONIKER_OVERFLOW_LIMIT) {
			//			append(OVERFLOW_MARKER);
			//		}
			if (element == null) {
				append(NULL_PLACEHOLDER);
			}
			else {
				//			EObject parent = element.eContainer();
				EObject unspecializedElement = element instanceof TemplateableElement ? ((TemplateableElement)element).getUnspecializedElement() : element;
				EObject parent = unspecializedElement != null ? unspecializedElement : element;
				if (parent.eContainer() != null) {
					parent = parent.eContainer();
				}
				for (EObject eContainer = parent.eContainer(); eContainer != null; parent = eContainer, eContainer = eContainer.eContainer()) {
					if (parent instanceof Type) {
						break;
					}
					if (parent instanceof org.eclipse.ocl.pivot.Package) {
						break;
					}
				}
				if (parent instanceof org.eclipse.ocl.pivot.Package) {
					String alias = options.getAlias((org.eclipse.ocl.pivot.Package)parent);
					if (alias != null) {
						append(alias);
						append(parentSeparator);
						return;
					}
					String name = ((org.eclipse.ocl.pivot.Package)parent).getName();
					if (PivotConstants.ORPHANAGE_NAME.equals(name)) {
						return;
					}
					if (PivotPackage.eNAME.equals(name)) {
						return;
					}
					if ("ocl".equals(name)) {            // FIXME constant needed
						return;
					}
				}
				if ((element instanceof Operation) &&
						(parent instanceof Type) &&
						PivotConstants.ORPHANAGE_NAME.equals(((Type)parent).getName())) {
					Operation operation = (Operation)element;
					append(operation.getOwningClass().getName());
					appendTemplateBindings(operation);
					append(parentSeparator);
					return;
				}
				EnvironmentFactory environmentFactory = options.getGlobalOptions().getEnvironmentFactory();
				MetamodelManager metamodelManager = environmentFactory != null ? environmentFactory.getMetamodelManager() : null;
				if ((metamodelManager != null) && (parent instanceof Type)) {
					parent = ((PivotMetamodelManager)metamodelManager).getPrimaryType((Type) parent);
				}
				if (parent == scope) {
					return;
				}
				if (parent instanceof Visitable) {
					List<PathElement> parentPath = PathElement.getPath(parent, metamodelManager);
					int iMax = parentPath.size();
					int i = 0;
					if (scope != null) {
						List<PathElement> scopePath = PathElement.getPath(scope, metamodelManager);
						i = PathElement.getCommonLength(parentPath, scopePath);
					}
					if (i < iMax) {
						//                    append(parentPath.get(i++).getName());
						appendElement(parentPath.get(i++).getElement());
						while (i < iMax) {
							append("::");
							//                        append(parentPath.get(i++).getName());
							appendElement(parentPath.get(i++).getElement());
						}
					}
					//                safeVisit((Visitable) parent);
				}
				else  {
					assert element instanceof org.eclipse.ocl.pivot.Package || element instanceof ExpressionInOCL : element.eClass().getName();
				}
			}
			append(parentSeparator);
		}
		finally {
			popMode(savedMode);
		}
	}

	public void appendQualifiedType(@NonNull Element element) {
		Mode savedMode = pushMode(Mode.TYPE);
		try {
			EnvironmentFactory environmentFactory = options.getGlobalOptions().getEnvironmentFactory();
			MetamodelManager metamodelManager = environmentFactory != null ? environmentFactory.getMetamodelManager() : null;
			Namespace parent = PivotUtil.getNamespace(element.eContainer());
			List<PathElement> parentPath = PathElement.getPath(parent, metamodelManager);
			int iMax = parentPath.size();
			int i = 0;
			Namespace scope = options.getScope();
			if (scope != null) {
				List<PathElement> scopePath = PathElement.getPath(scope, metamodelManager);
				i = PathElement.getCommonLength(parentPath, scopePath);
			}
			if ((i == 0) && (i < iMax)) {
				for (int j = iMax - 1; j >= 0; j--) {
					PathElement rootPathElement = parentPath.get(j);
					Element rootElement = rootPathElement.getElement();
					if (rootElement instanceof Namespace) {
						String alias = options.getAlias((Namespace)rootElement);
						if (alias != null) {
							append(getName(alias, options.getReservedNames()));
							append("::");
							i = j + 1;
							break;
						}
					}
				}
				if (i == 0) {
					PathElement rootPathElement = parentPath.get(0);
					String name = rootPathElement.getName();
					Element rootElement = rootPathElement.getElement();
					if (rootElement != null) {
						if (PivotConstants.ORPHANAGE_NAME.equals(name)) {
							i++;
						}
						//			            else if (PivotPackage.eNAME.equals(name)) {
						//			                i++;
						//			            }
						else if (PivotConstants.OCL_NAME.equals(name)) {
							i++;
						}
						else if (rootElement.eContainer() instanceof Model) {
							;
						}
						else {
							URI uri;
							if (rootElement.getESObject() != null) {
								EObject eTarget = rootElement.getESObject();
								uri = EcoreUtil.getURI(eTarget);
							}
							else {
								uri = rootElement.eResource().getURI();
								if (uri != null) {
									if (PivotUtilInternal.isASURI(uri)) {
										uri = PivotUtilInternal.getNonASURI(uri);
									}
								}
							}
							if (uri != null) {
								URI baseURI = options.getBaseURI();
								if (baseURI != null) {
									uri = URIUtil.deresolve(uri, baseURI);
								}
								append("_'" + uri.toString() + "'");
							}
							append("::");
							i++;
						}
					}
				}
			}
			while (i < iMax) {
				appendElement(parentPath.get(i++).getElement());
				append("::");
			}
			appendElement(element);
		}
		finally {
			popMode(savedMode);
		}
	}

	public void appendTemplateBindings(@NonNull TemplateableElement typeRef) {
		Mode savedMode = pushMode(Mode.NAME);
		try {
			List<TemplateBinding> templateBindings = typeRef.getOwnedBindings();
			if (!templateBindings.isEmpty()) {
				append("(");
				String prefix = ""; //$NON-NLS-1$
				for (TemplateBinding templateBinding : templateBindings) {
					for (TemplateParameterSubstitution templateParameterSubstitution : templateBinding.getOwnedSubstitutions()) {
						append(prefix);
						Namespace savedScope = pushScope((Namespace) typeRef);
						try {
							appendElement(templateParameterSubstitution.getActual());
						}
						finally {
							popScope(savedScope);
						}
						prefix = ", ";
					}
				}
				if (typeRef instanceof CollectionType) {
					CollectionType collectionType = (CollectionType)typeRef;
					Number lower = collectionType.getLower();
					Number upper = collectionType.getUpper();
					boolean isNullFree = collectionType.isIsNullFree();
					if (options.isShowDefaultMultiplicities() || !isNullFree || ((lower != null) && (upper != null) && ((lower.longValue() != 0) || !(upper instanceof  Unlimited)))) {
						appendMultiplicity(lower, upper, isNullFree);
					}
				}
				append(")");
			}
		}
		finally {
			popMode(savedMode);
		}
	}

	public void appendTemplateParameters(TemplateableElement templateableElement) {
		TemplateSignature templateSignature = templateableElement.getOwnedSignature();
		if (templateSignature != null) {
			List<TemplateParameter> templateParameters = templateSignature.getOwnedParameters();
			if (!templateParameters.isEmpty()) {
				append("(");
				String prefix = ""; //$NON-NLS-1$
				for (TemplateParameter templateParameter : templateParameters) {
					append(prefix);
					//					emittedTemplateParameter(templateParameter);
					//					appendName((NamedElement) templateParameter.getParameteredElement(), restrictedNames);
					Namespace savedScope = pushScope((Namespace) templateableElement);
					try {
						appendElement(templateParameter);
					}
					finally {
						popScope(savedScope);
					}
					prefix = ", ";
				}
				append(")");
			}
		}
	}

	/**
	 * @since 1.3
	 */
	public void appendTypeMultiplicity(@NonNull TypedElement object) {
		Type type = object.getType();
		if (!object.isIsRequired()) {
			append("[?]");
		}
		else if (options.isShowDefaultMultiplicities() || !(type instanceof CollectionType)) {
			append("[1]");
		}
	}

	public void appendTypedMultiplicity(@NonNull TypedElement object) {
		Type type = object.getType();
		appendElement(type);
		appendTypeMultiplicity(object);
	}

	public @Nullable Precedence getCurrentPrecedence() {
		return currentPrecedence;
	}

	public Set<String> getReservedNames() {
		return options.getReservedNames();
	}

	public Set<String> getRestrictedNames() {
		return options.getRestrictedNames();
	}

	public Namespace getScope() {
		return scope;
	}

	/**
	 * Emit text to the current indented region.
	 * Start a new indented region.
	 *
	 * If it is not necessary to start a new-line after text, emit suffix instead of the new-line.
	 */
	public void push(@NonNull String text, String suffix) {
		append(text);
		//		if ((pendingPrefix.length() > 0) || (pendingText.length() > 0)) {
		String string = pendingText.toString();
		assert string != null;
		fragment = fragment.addChild(pendingPrefix, string, suffix);
		fragment.exdented = true;
		pendingPrefix = "";
		pendingText.setLength(0);
		//		}
	}

	/**
	 * Flush the current indented region.
	 * Emit text exdented with respect to the current indented region.
	 * Start a new indented region.
	 *
	 * If it is not necessary to start a new-line before text, emit prefix instead of the new-line.
	 *
	 * If it is not necessary to start a new-line after text, emit suffix instead of the new-line.
	 */
	public void exdent(@NonNull String prefix, @NonNull String text, @NonNull String suffix) {
		Fragment fragmentParent = fragment.getParent();
		assert (fragment != null) && (fragmentParent != null);
		if (((pendingPrefix != null) && (pendingPrefix.length() > 0)) || (pendingText.length() > 0)) {
			String string = pendingText.toString();
			assert string != null;
			fragment.addChild(pendingPrefix, string, "");
			pendingPrefix = "";
			pendingText.setLength(0);
		}
		if ((prefix.length() > 0) || (text.length() > 0)) {
			String string = text.toString();
			assert string != null;
			fragment = fragmentParent.addChild(prefix, string, suffix);
			fragment.exdented = true;
		}
	}

	public String getName(@Nullable NamedElement object, @Nullable Set<String> keywords) {
		if (object == null) {
			return NULL_PLACEHOLDER;
		}
		return getName(object.getName(), keywords);
	}

	public String getName(@Nullable String name, @Nullable Set<String> keywords) {
		if ((keywords == null) || (!keywords.contains(name)) && PivotUtilInternal.isValidIdentifier(name)) {
			return name;
		}
		StringBuilder s = new StringBuilder();
		s.append("_'");
		s.append(StringUtil.convertToOCLString(name));
		s.append("'");
		return s.toString();
	}

	/**
	 * @since 1.5
	 */
	public @Nullable PrecedenceManager getPrecedenceManager() {
		return precedenceManager;
	}

	/**
	 * Flush the current indented region.
	 * Emit text indented with respect to the current indented region.
	 * Start a new indented region.
	 *
	 * If it is not necessary to start a new-line before text, emit prefix instead of the new-line.
	 *
	 * If it is not necessary to start a new-line after text, emit suffix instead of the new-line.
	 */
	public void next(@Nullable String prefix, @NonNull String text, @NonNull String suffix) {
		assert fragment != null;
		if (((pendingPrefix != null) && (pendingPrefix.length() > 0)) || (pendingText.length() > 0)) {
			String string = pendingText.toString();
			assert string != null;
			fragment.addChild(pendingPrefix, string, "");
			pendingPrefix = "";
			pendingText.setLength(0);
		}
		//		if ((prefix.length() > 0) || (text.length() > 0)) {
		fragment.addChild(prefix, text, suffix);
		//		}
	}

	/**
	 * Flush the current indented region.
	 * Resume output with one less indentation depth.
	 */
	public void pop() {
		assert fragment != null;
		if (((pendingPrefix != null) && (pendingPrefix.length() > 0)) || (pendingText.length() > 0)) {
			String string = pendingText.toString();
			assert string != null;
			fragment.addChild(pendingPrefix, string, "");
		}
		pendingPrefix = "";
		pendingText.setLength(0);
		assert fragment.getParent() != null;
		fragment = fragment.getParent();
	}

	public void popMode(@NonNull Mode oldMode) {
		mode = oldMode;
	}

	public void popScope(@Nullable Namespace oldScope) {
		scope = oldScope;
	}

	public void precedenceVisit(@Nullable OCLExpression expression, @Nullable Precedence newPrecedence) {
		Precedence savedPrecedcence = currentPrecedence;
		try {
			currentPrecedence = newPrecedence;
			appendElement(expression);
		}
		finally {
			currentPrecedence = savedPrecedcence;
		}
	}

	public @NonNull Mode pushMode(@NonNull Mode newMode) {
		Mode oldMode = mode;
		mode = newMode;
		return oldMode;
	}

	public @Nullable Namespace pushScope(@Nullable Namespace newScope) {
		Namespace oldscope = scope;
		scope = newScope;
		return oldscope;
	}

	public boolean showNames() {
		return (mode == Mode.NAME) || (mode == Mode.FULL);
	}

	@Override
	public @NonNull String toString() {
		if (fragment == null) {
			return pendingPrefix + pendingText.toString();
		}
		fragment.configureLineWrapping(options.getIndentStep().length(), options.getLinelength());
		StringBuilder s = new StringBuilder();
		String newLine = fragment.toString(s, null, "  ");
		return s.toString() + newLine + pendingPrefix + pendingText.toString();
	}

	public @NonNull String toString(@NonNull String indent, int lineLength) {
		if (fragment == null) {
			return pendingPrefix + pendingText.toString();
		}
		fragment.configureLineWrapping(indent.length(), lineLength);
		StringBuilder s = new StringBuilder();
		fragment.toString(s, null, indent);
		//		System.out.println(s.toString() + "--" + pendingPrefix + "--" + pendingText.toString());
		return s.toString() + pendingPrefix + pendingText.toString();
	}
}
