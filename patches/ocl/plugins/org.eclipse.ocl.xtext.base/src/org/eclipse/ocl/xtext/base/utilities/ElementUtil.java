/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 * 	 E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.utilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.TemplateBinding;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.resource.ICSI2ASMapping;
import org.eclipse.ocl.pivot.internal.scoping.Attribution;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal.EnvironmentFactoryInternalExtension;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.CSResource;
import org.eclipse.ocl.pivot.utilities.ParserContext;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.attributes.RootCSAttribution;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.base.cs2as.ImportDiagnostic;
import org.eclipse.ocl.xtext.base.cs2as.LibraryDiagnostic;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.ModelElementCS;
import org.eclipse.ocl.xtext.basecs.MultiplicityCS;
import org.eclipse.ocl.xtext.basecs.NamedElementCS;
import org.eclipse.ocl.xtext.basecs.OperationCS;
import org.eclipse.ocl.xtext.basecs.PathElementCS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.StructuredClassCS;
import org.eclipse.ocl.xtext.basecs.TemplateBindingCS;
import org.eclipse.ocl.xtext.basecs.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.xtext.basecs.TypeRefCS;
import org.eclipse.ocl.xtext.basecs.TypedElementCS;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;
import org.eclipse.ocl.xtext.basecs.TypedTypeRefCS;
import org.eclipse.ocl.xtext.basecs.WildcardTypeRefCS;
import org.eclipse.xtext.nodemodel.BidiIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.AbstractNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextSyntaxDiagnostic;
import org.eclipse.xtext.util.ITextRegion;

public class ElementUtil
{
	private static final String delegateExtensionPoints[] = {
		//		EcorePlugin.CONVERSION_DELEGATE_PPID, -- not available in EMF 2.7
		EcorePlugin.INVOCATION_DELEGATE_PPID,
		EcorePlugin.QUERY_DELEGATE_PPID,
		EcorePlugin.SETTING_DELEGATE_PPID,
		EcorePlugin.VALIDATION_DELEGATE_PPID
	};

	private static String[][] delegationModes = null;

	public static void appendTextRegion(@NonNull StringBuilder s, @Nullable ITextRegion textRegion, boolean isSignificant) {
		s.append(isSignificant ? "[" : "(");
		if (textRegion != null) {
			s.append(textRegion.getOffset() + "," + textRegion.getLength());
		}
		else {
			s.append("null");
		}
		s.append(isSignificant ? "]" : ")");
	}

	public static @Nullable ParserContext basicGetParserContext(@NonNull EObject csElement) {
		Resource eResource = csElement.eResource();
		ParserContext parserContext = eResource instanceof CSResource ? ((CSResource)eResource).getParserContext() : null;
		// assert parserContext != null;		// FIXME only non-null for API compatibility
		return parserContext;
	}

	public static @Nullable String getCollectionTypeName(@NonNull TypedElementCS csTypedElement) {
		TypedRefCS csTypeRef = csTypedElement.getOwnedType();
		if (csTypeRef == null) {
			return null;
		}
		//		if (csTypeRef instanceof CollectionTypeRefCS) {
		//			Type csType = ((CollectionTypeRefCS)csTypeRef).getType();
		//			if (csType instanceof CollectionType) {
		//				return ((CollectionType)csType).getName();
		//			}
		//		}
		//FIXME Obsolete compatibility
		MultiplicityCS csMultiplicity = csTypeRef.getOwnedMultiplicity();
		if (csMultiplicity == null) {
			return null;
		}
		int upper = csMultiplicity.getUpper();
		if (upper == 1) {
			return null;
		}
		List<String> qualifiers = csTypedElement.getQualifiers();
		boolean isOrdered = true;
		boolean isUnique = true;
		if (qualifiers.contains("!ordered")) { //$NON-NLS-1$
			isOrdered = false;
		}
		else if (qualifiers.contains("ordered")) { //$NON-NLS-1$
			isOrdered = true;
		}
		if (qualifiers.contains("!unique")) { //$NON-NLS-1$
			isUnique = false;
		}
		else if (qualifiers.contains("unique")) { //$NON-NLS-1$
			isUnique = true;
		}
		return getCollectionName(isOrdered, isUnique);
	}

	public static @NonNull String getCollectionName(boolean ordered, boolean unique) {
		if (ordered) {
			return unique ? TypeId.ORDERED_SET_NAME : TypeId.SEQUENCE_NAME;
		}
		else {
			return unique ? TypeId.SET_NAME : TypeId.BAG_NAME;
		}
	}

	public static @Nullable ModelElementCS getCsElement(@NonNull Element asElement) {
		EnvironmentFactoryInternal environmentFactory = PivotUtilInternal.getEnvironmentFactory(asElement);
		ICSI2ASMapping csi2asMapping = environmentFactory.getCSI2ASMapping();
		if (csi2asMapping == null) {
			return null;
		}
		return ((CSI2ASMapping)csi2asMapping).getCSElement(asElement);
	}

	// FIXME share with common.ui once promoted from examples
	public static String[][] getDelegateURIs() {
		if (delegationModes == null) {
			Set<String> uris = new HashSet<String>();
			IExtensionRegistry pluginRegistry = Platform.getExtensionRegistry();
			String pluginID = EcorePlugin.getPlugin().getBundle().getSymbolicName();
			for (String extensionPointID : delegateExtensionPoints) {
				IExtensionPoint point = pluginRegistry.getExtensionPoint(pluginID, extensionPointID);
				if (point != null) {
					IConfigurationElement[] elements = point.getConfigurationElements();
					for (int i = 0; i < elements.length; i++) {
						String uri = elements[i].getAttribute("uri"); //$NON-NLS-1$
						if (uri != null) {
							uris.add(uri);
						}
					}
				}
			}
			List<String> uriList = new ArrayList<String>(uris);
			Collections.sort(uriList);
			delegationModes = new String[uriList.size()][2];
			for (int i = 0; i < uris.size(); i++) {
				delegationModes[i][0] = uriList.get(i);
				delegationModes[i][1] = uriList.get(i);
			}
		}
		return delegationModes;
	}

	public static @Nullable RootCSAttribution getDocumentAttribution(@NonNull ElementCS context) {
		ParserContext parserContext = basicGetParserContext(context);
		for (ElementCS target = context, parent; (parent = target.getParent()) != null; target = parent) {
			@SuppressWarnings("deprecation")
			Attribution attribution = parserContext != null ? parserContext.getAttribution(parent) : PivotUtilInternal.getAttribution(parent);
			if (attribution instanceof RootCSAttribution) {
				return (RootCSAttribution) attribution;
			}
		}
		return null;
	}

	/**
	 * Return the user text for csElement preserving all surrounding whitespace.
	 * <br>
	 * Except that Carriage Returns are removed.
	 * <br>
	 * Except that a first space is removed since it originates from the auto-formatter.
	 * <br>
	 * The leading whitespace of the next element is included since the folloowing token
	 * is expected to be a semicolon.
	 */
	public static @NonNull String getExpressionText(@NonNull ElementCS csElement) {
		ICompositeNode parserNode = NodeModelUtils.getNode(csElement);
		if (parserNode != null) {
			String text = parserNode.getText().replace("\r", "");
			if ((text.length() > 0) && text.charAt(0) == ' ') {
				text = text.substring(1);		// Step over the leading separator.
			}
			INode nextNode = parserNode.getNextSibling();
			for (INode parent = parserNode.getParent(); parent != null; parent = parent.getParent()) {
				nextNode = parent.getNextSibling();
				if (nextNode != null) {
					String nextText = nextNode.getText().replace("\r", "");
					int i = 0;
					int iMax = nextText.length();
					for ( ; i < iMax; i++) {	// Step up to the leading separator.
						if (!Character.isWhitespace(nextText.charAt(i))) {
							break;
						}
					}
					return text + nextText.substring(0, i);
				}
			}
			assert text != null;
			return text;
		}
		return "null";
	}

	/**
	 * Extract the first embedded ExpressionInOCL.
	 * @throws ParserException
	 */
	public static @Nullable ExpressionInOCL getFirstQuery(@NonNull PivotMetamodelManager metamodelManager, BaseCSResource csResource) throws ParserException {
		CS2AS cs2as = csResource.findCS2AS();
		if (cs2as != null) {
			ASResource asResource = cs2as.getASResource();
			for (EObject eRoot: asResource.getContents()) {
				if (eRoot instanceof Model) {
					for (org.eclipse.ocl.pivot.Package asPackage: ((Model)eRoot).getOwnedPackages()) {
						for (org.eclipse.ocl.pivot.Class asType: asPackage.getOwnedClasses()) {
							for (Constraint asConstraint : asType.getOwnedInvariants()) {
								LanguageExpression specification = asConstraint.getOwnedSpecification();
								if (specification != null) {
									return ((EnvironmentFactoryInternalExtension)metamodelManager.getEnvironmentFactory()).parseSpecification(specification);
								}
							}
							for (Operation asOperation : asType.getOwnedOperations()) {
								LanguageExpression specification = asOperation.getBodyExpression();
								if (specification != null) {
									return ((EnvironmentFactoryInternalExtension)metamodelManager.getEnvironmentFactory()).parseSpecification(specification);
								}
							}
						}
					}
				}
			}
		}
		return null;
	}

	public static @Nullable TemplateParameter getFormalTemplateParameter(@NonNull TemplateParameterSubstitutionCS csTemplateParameterSubstitution) {
		TemplateBindingCS csTemplateBinding = csTemplateParameterSubstitution.getOwningBinding();
		int index = csTemplateBinding.getOwnedSubstitutions().indexOf(csTemplateParameterSubstitution);
		if (index < 0) {
			return null;
		}
		TemplateBinding templateBinding = (TemplateBinding) csTemplateBinding.getPivot();
		TemplateSignature templateSignature = templateBinding.getTemplateSignature();
		List<TemplateParameter> templateParameters = templateSignature.getOwnedParameters();
		if (templateParameters.size() <= index) {
			return null;
		}
		return templateParameters.get(index);
	}

	public static @Nullable ILeafNode getLeafNode(@NonNull INode node) {
		ILeafNode leafNode = null;
		if (node instanceof ILeafNode) {
			return (ILeafNode) node;
		}
		else {
			for (ILeafNode lNode : node.getLeafNodes()) {
				if (!lNode.isHidden()) {
					leafNode = lNode;
					return leafNode;
				}
			}
		}
		return null;
	}

	public static int getLower(@NonNull TypedElementCS csTypedElement) {
		TypedRefCS csTypeRef = csTypedElement.getOwnedType();
		if (csTypeRef == null) {
			return 0;		// e.g. missing Operation return type
		}
		MultiplicityCS csMultiplicity = csTypeRef.getOwnedMultiplicity();
		if (csMultiplicity == null) {
			Type type = PivotUtil.getPivot(Type.class, csTypeRef);
			if (type instanceof CollectionType) {
				return 1;
			}
			if (type != null) {
				EObject esObject = type.getESObject();
				if ((esObject instanceof EDataType) && isPrimitiveInstanceClass((EDataType) esObject)) {
					return 1;
				}
			}
			return 0;			// OCL legacy allows null even though UML lowerBound() default is 1.
		}
		return csMultiplicity.getLower();
	}

	public static @Nullable <@NonNull T extends NamedElementCS> T getNamedElementCS(@NonNull Collection<T> namedElements, @NonNull String name) {
		for (T namedElement : namedElements) {
			if (name.equals(namedElement.getName())) {
				return namedElement;
			}
		}
		return null;
	}

	/** This makes INode.getEndOffset from Xtext 2.5 available on 2.3 */
	public static int getEndOffset(@NonNull INode iNode) {
		if (!(iNode instanceof AbstractNode)) {
			return -1;
		}
		AbstractNode node = (AbstractNode) iNode;
		BidiIterator<AbstractNode> iter = node .basicIterator();
		while(iter.hasPrevious()) {
			INode prev = iter.previous();
			if (prev instanceof ILeafNode && !((ILeafNode) prev).isHidden()) {
				return prev.getTotalEndOffset();
			}
		}
		return node.getTotalEndOffset();
	}

	public static boolean getQualifier(@NonNull List<String> qualifiers, @NonNull String trueString, @NonNull String falseString, boolean defaultValue) {
		if (qualifiers.contains(trueString)) {
			return true;
		}
		else if (qualifiers.contains(falseString)) {
			return false;
		}
		else {
			return defaultValue;
		}
	}

	/**
	 * Return the raw text associated with a csElement. This preserves leading/internal/trailing whitespace, which is necessary when propagating
	 * the original user formatting through an Ecore EAnnotation. Returns an empty string rather than null.
	 */
	public static @NonNull String getRawText(@Nullable ElementCS csElement) {
		ICompositeNode node = csElement  != null ? NodeModelUtils.getNode(csElement) : null;
		String rawText = node != null ? node.getText() : null;
		return rawText != null ? rawText : "";
	}

	/**
	 * Return the raw text associated with a csElement. This preserves leading/trailing whitespace, which is necessary when propagating
	 * the original user formatting through an Ecore EAnnotation.
	 */
	@Deprecated	/* @deprecated use the clearer getRawText() unless getTrimmedText() was actually the intent. */
	public static @Nullable String getText(@NonNull ElementCS csElement) {
		ICompositeNode node = NodeModelUtils.getNode(csElement);
		return node != null ? NodeModelUtils.getTokenText(node) : null;
	}

	// FIXME is this fallback iregularity just for ShadowPartCSImpl ever really used / necessary ?
	public static @Nullable String getText(@NonNull ElementCS csElement, /*@NonNull*/ EReference feature) {
		@SuppressWarnings("null")@NonNull List<INode> nodes = NodeModelUtils.findNodesForFeature(csElement, feature);
		//		assert (nodes.size() == 1;
		if (nodes.isEmpty()) {
			return null;
		}
		else if (nodes.size() == 1) {
			return NodeModelUtils.getTokenText(nodes.get(0));
		}
		else {
			StringBuilder s = new StringBuilder();
			for (INode node : nodes) {
				s.append(NodeModelUtils.getTokenText(node));
			}
			return s.toString();
		}
	}

	/**
	 * Return the logical text associated with a csElement. (Escaped identifers are unescaped.)
	 */
	public static @Nullable String getTextName(@NonNull ElementCS csElement) {
		String text = getText(csElement);
		if (text == null) {
			return null;
		}
		int length = text.length();
		if ((length >= 3) && text.startsWith("_'") && text.endsWith("'")) {
			return text.substring(2, length-1);
		}
		else {
			return text;
		}
	}

	/**
	 * Return the  text associated with a csElement excluding any leading or trailing whitespace.
	 * Returns an empty string rather than null.
	 */
	public static @NonNull String getTrimmedText(@Nullable ElementCS csElement) {
		return getRawText(csElement).trim();
	}

	public static int getUpper(@NonNull TypedElementCS csTypedElement) {
		TypedRefCS csTypeRef = csTypedElement.getOwnedType();
		if (csTypeRef == null) {
			return 1;
		}
		MultiplicityCS csMultiplicity = csTypeRef.getOwnedMultiplicity();
		if (csMultiplicity == null) {
			return 1;
		}
		return csMultiplicity.getUpper();
	}

	public static boolean hasSyntaxError(@NonNull List<Diagnostic> diagnostics) {
		for (Diagnostic diagnostic : diagnostics) {
			if (diagnostic instanceof LibraryDiagnostic) {
				return true;
			}
			else if (diagnostic instanceof XtextSyntaxDiagnostic) {
				return true;
			}
			else if (diagnostic instanceof ImportDiagnostic) {
				return true;
			}
			else if (diagnostic.getClass().getName().equals("org.eclipse.ocl.xtext.essentialocl.utilities.EssentialOCLCSResource$RenamedDiagnostic")) {		// FIXME Intyroduce an interface
				return true;
			}
		}
		return false;
	}

	public static boolean isInOperation(@NonNull ElementCS csElement) {
		for (EObject eObject = csElement; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof OperationCS) {
				return true;
			}
			else if (eObject instanceof StructuredClassCS) {
				return false;
			}
		}
		return false;
	}

	public static boolean isOrdered(@NonNull TypedElementCS csTypedElement) {
		List<String> qualifiers = csTypedElement.getQualifiers();
		assert qualifiers != null;
		return getQualifier(qualifiers, "ordered", "!ordered", false);
	}

	public static boolean isPrimitiveInstanceClass(@NonNull EDataType esObject) {
		Class<?> instanceClass = esObject.getInstanceClass();
		return (instanceClass == boolean.class) || (instanceClass == byte.class) || (instanceClass == char.class) || (instanceClass == double.class)
				|| (instanceClass == float.class) || (instanceClass == int.class) || (instanceClass == long.class) || (instanceClass == short.class);
	}

	/**
	 * @deprecated  Use CS2AS.isRequired to handle [?]/[1]/blank
	 */
	@Deprecated
	public static boolean isRequired(@Nullable TypedRefCS csTypeRef) {
		if (csTypeRef != null) {
			MultiplicityCS csMultiplicity = csTypeRef.getOwnedMultiplicity();
			if (csMultiplicity != null) {
				int lower = csMultiplicity.getLower();
				if (lower > 0) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean isSpecialization(@NonNull TemplateBindingCS csTemplateBinding) {
		TypedTypeRefCS csTypedTypeRef = csTemplateBinding.getOwningElement();
		Element type = csTypedTypeRef.getPivot();
		for (TemplateParameterSubstitutionCS csTemplateParameterSubstitution : csTemplateBinding.getOwnedSubstitutions()) {
			TypeRefCS ownedActualParameter = csTemplateParameterSubstitution.getOwnedActualParameter();
			if (ownedActualParameter instanceof WildcardTypeRefCS) {
				return true;
			}
			Type actualParameterClass = (Type) ownedActualParameter.getPivot();
			TemplateParameter templateParameter = actualParameterClass.isTemplateParameter();
			if (templateParameter == null) {
				return true;
			}
			TemplateSignature signature = templateParameter.getOwningSignature();
			TemplateableElement template = signature.getOwningElement();
			if (template != type) {
				return true;
			}
		}
		return false;
	}

	public static boolean isUnique(@NonNull TypedElementCS csTypedElement) {
		List<String> qualifiers = csTypedElement.getQualifiers();
		assert qualifiers != null;
		return getQualifier(qualifiers, "unique", "!unique", true);
	}

	public static void setLastPathElement(@NonNull PathNameCS ownedPathName, @NonNull Element asElement) {
		List<PathElementCS> ownedPathElements = ownedPathName.getOwnedPathElements();
		int size = ownedPathElements.size();
		if (size > 0) {
			PathElementCS pathElementCS = ownedPathElements.get(size-1);
			pathElementCS.setReferredElement(asElement);
		}
	}
}
