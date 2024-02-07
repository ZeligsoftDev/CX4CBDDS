/*******************************************************************************
 * Copyright (c) 2010, 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.cs2as;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentsEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.internal.messages.PivotMessagesInternal;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeFilter;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.ocl.pivot.internal.utilities.AbstractConversion;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.ParserContext;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotHelper;
import org.eclipse.ocl.pivot.utilities.StringUtil;
import org.eclipse.ocl.pivot.utilities.ThreadLocalExecutor;
import org.eclipse.ocl.xtext.base.scoping.AbstractJavaClassScope;
import org.eclipse.ocl.xtext.base.scoping.BaseScopeView;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.base.utilities.CSI;
import org.eclipse.ocl.xtext.base.utilities.CSI2ASMapping;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.ElementRefCS;
import org.eclipse.ocl.xtext.basecs.ModelElementCS;
import org.eclipse.ocl.xtext.basecs.MultiplicityCS;
import org.eclipse.ocl.xtext.basecs.PathElementCS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.PivotableElementCS;
import org.eclipse.ocl.xtext.basecs.RootCS;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;
import org.eclipse.ocl.xtext.basecs.TypedTypeRefCS;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.osgi.util.NLS;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;

/**
 * CS2AS manages the equivalence between a Concrete Syntax Resources
 * and their corresponding Pivot Resources creating a CS2ASConversion
 * to update.
 */
public abstract class CS2AS extends AbstractConversion	// FIXME migrate functionality to PivotHelper
{
	public static interface UnresolvedProxyMessageProvider
	{
		@NonNull EReference getEReference();
		@Nullable String getMessage(@NonNull EObject context, @NonNull String linkText);
	}

	public static abstract class AbstractUnresolvedProxyMessageProvider implements UnresolvedProxyMessageProvider
	{
		protected final @NonNull EReference eReference;

		public AbstractUnresolvedProxyMessageProvider(/*@NonNull*/ EReference eReference) {
			assert eReference != null;
			this.eReference = eReference;
		}
		@Override
		public @NonNull EReference getEReference() {
			return eReference;
		}

		@Override
		public abstract @Nullable String getMessage(@NonNull EObject context, @NonNull String linkText);
	}

	/**
	 * Return the containment features ordered so that library and import features are processed before anything else.
	 */
	public static EList<EObject> computeRootContainmentFeatures(RootCS csRoot) {
		BasicEList<EReference> containmentsList = new BasicEList<EReference>();
		for (EStructuralFeature eStructuralFeature : csRoot.eClass().getEAllStructuralFeatures()) {
			if (eStructuralFeature instanceof EReference) {
				EReference eReference = (EReference) eStructuralFeature;
				if (eReference.isContainment()) {
					containmentsList.add(eReference);
				}
			}
		}
		int index = containmentsList.indexOf(BaseCSPackage.Literals.ROOT_CS__OWNED_IMPORTS);
		if (index > 0) {
			containmentsList.move(0, index);		// Process imports second
		}
		return new EContentsEList<EObject>(csRoot, containmentsList);
	}

	private static Map<EReference, UnresolvedProxyMessageProvider> unresolvedProxyMessageProviderMap = new HashMap<EReference, UnresolvedProxyMessageProvider>();

	/**
	 * Whether to show file and line number context at the start of messages.
	 */
	public static boolean showContext = false;

	/**
	 * Interface for an optional message binder that may be used to affix additional context
	 * for standalone and command line applications.
	 */
	public static interface MessageBinder
	{
		@NonNull String bind(@NonNull EObject csContext, @NonNull String messageTemplate, Object... bindings);
	}

	/**
	 * Default message binder that just invokes {@link NLS#bind(String, Object[])}.
	 */
	public static class DefaultMessageBinder implements CS2AS.MessageBinder
	{
		public static final @NonNull MessageBinder INSTANCE = new DefaultMessageBinder();

		@Override
		public @NonNull String bind(@NonNull EObject csContext, @NonNull String messageTemplate, Object... bindings) {
			return StringUtil.bind(messageTemplate, bindings);
		}
	}

	/**
	 * Message binder that prefixes the uri and line number to the return from {@link NLS#bind(String, Object[])}.
	 */
	public static class MessageBinderWithLineContext implements CS2AS.MessageBinder
	{
		public static final MessageBinder INSTANCE = new MessageBinderWithLineContext();

		@Override
		public @NonNull String bind(@NonNull EObject csContext, @NonNull String messageTemplate, Object... bindings) {
			String message = StringUtil.bind(messageTemplate, bindings);
			ICompositeNode node = NodeModelUtils.getNode(csContext);
			if (node != null) {
				int startLine = node.getStartLine();
				String uri = csContext.eResource().getURI().toString();
				return uri + ":" + startLine + " " + message;
			}
			return message;
		}
	}

	private static MessageBinder messageBinder = DefaultMessageBinder.INSTANCE;

	public static void addUnresolvedProxyMessageProvider(UnresolvedProxyMessageProvider unresolvedProxyMessageProvider) {
		unresolvedProxyMessageProviderMap.put(unresolvedProxyMessageProvider.getEReference(), unresolvedProxyMessageProvider);
	}

	public static Element basicGetType(TypedTypeRefCS csTypedRef) {
		List<PathElementCS> path = csTypedRef.getOwnedPathName().getOwnedPathElements();
		int iLast = path.size()-1;
		for (int i = 0; i < iLast; i++) {
			Element element = path.get(i).basicGetReferredElement();
			if (element == null) {
				return null;
			}
		}
		Element element = path.get(iLast).basicGetReferredElement();
		if (element == null) {
			return null;
		}
		return element;
	}

	public static @Nullable DiagnosticMessage getUnresolvedProxyMessage(@NonNull EReference eReference, @NonNull EObject csContext, @NonNull String linkText) {
		String message = getUnresolvedProxyText(eReference, csContext, linkText);
		return message != null ? new DiagnosticMessage(message, Severity.ERROR, Diagnostic.LINKING_DIAGNOSTIC) : null;
	}

	public static @Nullable String getUnresolvedProxyText(@NonNull EReference eReference, @NonNull EObject csContext, @NonNull String linkText) {
		ExceptionAdapter exceptionAdapter = ClassUtil.getAdapter(ExceptionAdapter.class, csContext);
		if (exceptionAdapter != null) {
			return exceptionAdapter.getErrorMessage();
		}
		UnresolvedProxyMessageProvider unresolvedProxyMessageProvider = unresolvedProxyMessageProviderMap.get(eReference);
		if (unresolvedProxyMessageProvider != null) {
			return unresolvedProxyMessageProvider.getMessage(csContext, linkText);
		}
		@SuppressWarnings("null") @NonNull String messageTemplate = PivotMessagesInternal.Unresolved_ERROR_;
		String errorContext = "Unknown";
		EClass referenceType = eReference.getEReferenceType();
		if (referenceType != null) {
			errorContext = referenceType.getName();
		}
		return messageBinder.bind(csContext, messageTemplate, errorContext, linkText);
	}

	public static List<ILeafNode> getDocumentationNodes(@NonNull ICompositeNode node) {
		List<ILeafNode> documentationNodes = null;
		for (ILeafNode leafNode : node.getLeafNodes()) {
			EObject grammarElement = leafNode.getGrammarElement();
			if (!(grammarElement instanceof TerminalRule)) {
				break;
			}
			TerminalRule terminalRule = (TerminalRule) grammarElement;
			String name = terminalRule.getName();
			if ("WS".equals(name)) {
			}
			else if ("SL_COMMENT".equals(name)) {
			}
			else if ("ML_COMMENT".equals(name)) {
				if (documentationNodes == null) {
					documentationNodes = new ArrayList<ILeafNode>();
				}
				documentationNodes.add(leafNode);
			}
			else {
				break;
			}
		}
		return documentationNodes;
	}

	private static final class TypeValueFilter implements ScopeFilter
	{
		public static TypeValueFilter INSTANCE = new TypeValueFilter();

		@Override
		public boolean matches(@NonNull EnvironmentView environmentView, @NonNull Object object) {
			if (object instanceof Type) {
				return true;
			}
			if (object instanceof TypedElement) {
				return false; //((TypedElement)object).getType() instanceof Metaclass<?>;
			}
			return false;
		}
	}

	private static final class UndecoratedNameFilter implements ScopeFilter
	{
		public static UndecoratedNameFilter INSTANCE = new UndecoratedNameFilter();

		@Override
		public boolean matches(@NonNull EnvironmentView environmentView, @NonNull Object object) {
			return !(object instanceof Operation) && !(object instanceof org.eclipse.ocl.pivot.Package);
		}
	}

	public static @Nullable EClassifier getElementType(@NonNull PathNameCS pathNameCS) {
		List<PathElementCS> path = pathNameCS.getOwnedPathElements();
		int iSize = path.size();
		return iSize > 0 ? path.get(iSize-1).getElementType() : null;
	}

	public static MessageBinder getMessageBinder() {
		return messageBinder;
	}

	private static long startTime = System.currentTimeMillis();
	private static @NonNull Map<Thread,Long> threadRunTimes = new HashMap<Thread,Long>();
	private static long[] indentRunTimes = new long[100];
	private static @NonNull Integer indentation = 0;
	private static @NonNull String indents= ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>";

	public static void printDiagnostic(@NonNull String message, boolean dispose, int indent) {
		synchronized (indentation) {
			if (indent < 0) {
				indentation--;
			}
			long currentTimeMillis = System.currentTimeMillis();
			Thread currentThread = Thread.currentThread();
			Long threadStartTime = threadRunTimes.get(currentThread);
			if (threadStartTime == null) {
				threadStartTime = currentTimeMillis;
				threadRunTimes.put(currentThread, threadStartTime);
			}
			if (indent > 0) {
				System.out.printf("%s %8.3f %s -- %6.3f %s\n", indents.substring(0, Math.min(indentation, indents.length()-1)), (currentTimeMillis - startTime) * 0.001, currentThread.getName(),
					(currentTimeMillis - threadStartTime) * 0.001, message);
			}
			else {
				System.out.printf("%s %8.3f %s -- %6.3f %6.3f %s\n", indents.substring(0, Math.min(indentation, indents.length()-1)), (currentTimeMillis - startTime) * 0.001, currentThread.getName(),
					(currentTimeMillis - threadStartTime) * 0.001, (currentTimeMillis - indentRunTimes[indentation]) * 0.001, message);
			}
			if (dispose) {
				threadRunTimes.remove(currentThread);
			}
			if (indent > 0) {
				indentRunTimes[indentation] = currentTimeMillis;
				indentation++;
			}
		}
	}

	public static void refreshContext(@NonNull PathNameCS pathNameCS, ElementCS csContext) {
		if (pathNameCS.getContext() != csContext) {
			pathNameCS.setContext(csContext);
		}
	}

	public static void refreshElementType(PathElementCS pathElementCS, EClassifier elementType) {
		if ((pathElementCS != null)  && (pathElementCS.getElementType() != elementType)) {
			pathElementCS.setElementType(elementType);
		}
	}

	public static void refreshScopeFilter(@NonNull PathNameCS pathNameCS, ScopeFilter scopeFilter) {
		if (pathNameCS.getScopeFilter() != scopeFilter) {
			pathNameCS.setScopeFilter(scopeFilter);
		}
	}

	public static void setElementType(@NonNull PathNameCS pathNameCS, /*@NonNull*/ EClass elementType, @NonNull ElementCS csContext, @Nullable ScopeFilter scopeFilter) {
		assert elementType != null;
		refreshContext(pathNameCS, csContext);
		refreshScopeFilter(pathNameCS, scopeFilter);
		List<PathElementCS> path = pathNameCS.getOwnedPathElements();
		int iMax = path.size()-1;
		refreshElementType(path.get(iMax), elementType);
		if (PivotPackage.Literals.FEATURE.isSuperTypeOf(elementType) && (iMax > 0)) {
			refreshElementType(path.get(--iMax), PivotPackage.Literals.TYPE);
		}
		for (int i = 0; i < iMax; i++) {
			refreshElementType(path.get(i), PivotPackage.Literals.NAMESPACE);
		}
	}

	/**
	 * Define an alternative message binder. THe default null messageBinder uses
	 * {@link NLS#bind(String, Object[])}
	 */
	public static MessageBinder setMessageBinder(MessageBinder messageBinder) {
		MessageBinder savedMessageBinder = CS2AS.messageBinder;
		CS2AS.messageBinder = messageBinder;
		return savedMessageBinder;
	}

	/**
	 * Define the resolution of a PathNameCS explicitly avoiding the need for the normal Xtext proxy resolution.
	 * This is used after a non-trivial selection occurs such as the selection of the best operation overload.
	 * If element is null the Xtext error message corresponding to an unresolved proxy is generated.
	 * @param ambiguities
	 */
	public static void setPathElement(@NonNull PathNameCS csPathName, @Nullable Element element, @Nullable List<@NonNull ? extends EObject> ambiguities) {
		List<@NonNull PathElementCS> csPath = ClassUtil.nullFree(csPathName.getOwnedPathElements());
		PathElementCS csLastElement = csPath.get(csPath.size()-1);
		AmbiguitiesAdapter.setAmbiguities(csLastElement, ambiguities);
		if ((element == null) || (ambiguities != null)) {
			EObject eObject = csLastElement;
			INode iNode = NodeModelUtils.getNode(csLastElement);
			Triple<EObject, EReference, INode> triple = Tuples.create(eObject, BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, iNode);
			Resource eResource = csLastElement.eResource();
			if (eResource instanceof BaseCSResource) {
				((BaseCSResource)eResource).createAndAddDiagnostic(triple);
			}
			csLastElement.setReferredElement(null);
		}
		else {
			csLastElement.setReferredElement(element);
		}
	}

	/**
	 * The CS resource mapped by this CS2AS.
	 */
	protected final @NonNull BaseCSResource csResource;

	/**
	 * The AS resource mapped by this CS2AS.
	 */
	protected final @NonNull ASResource asResource;

	/**
	 * CS to Pivot mapping controller for aliases and CSIs.
	 */
	protected final @NonNull CSI2ASMapping csi2asMapping;

	/**
	 * Construction helper, lazily created by the overrideable getHelper/createHelper.
	 */
	private @Nullable PivotHelper helper = null;

	private final @Nullable ParserContext parserContext;		// FIXME only non-null for API compatibility

	public CS2AS(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull BaseCSResource csResource, @NonNull ASResource asResource) {
		super(environmentFactory);
		this.csi2asMapping = CSI2ASMapping.getCSI2ASMapping(environmentFactory);
		this.csResource = csResource;
		this.asResource = asResource;
		csi2asMapping.add(csResource, this);
		this.parserContext = csResource.getParserContext();
		ParserContext parserContext2 = parserContext;
		assert parserContext2 != null;
		if (parserContext2.getEnvironmentFactory() != environmentFactory) {
			System.out.println("[" + Thread.currentThread().getName() + "] Parser " + NameUtil.debugSimpleName(parserContext2.getEnvironmentFactory()));
			System.out.println("[" + Thread.currentThread().getName() + "] CS2AS " + NameUtil.debugSimpleName(environmentFactory));
			System.out.println("[" + Thread.currentThread().getName() + "] Thread " + NameUtil.debugSimpleName(ThreadLocalExecutor.basicGetEnvironmentFactory()));
		}
		assert parserContext2.getEnvironmentFactory() == environmentFactory;
	}

	protected CS2AS(@NonNull CS2AS aConverter) {
		super(aConverter.getEnvironmentFactory());
		this.csResource = aConverter.csResource;
		this.asResource = aConverter.asResource;
		this.csi2asMapping = CSI2ASMapping.getCSI2ASMapping(environmentFactory);
		//		csi2asMapping.add(this);
		this.parserContext = aConverter.parserContext;
		assert parserContext != null;
		assert parserContext.getEnvironmentFactory() == environmentFactory;
	}

	public @NonNull String bind(@NonNull EObject csContext, /*@NonNull*/ String messageTemplate, Object... bindings) {
		assert messageTemplate != null;
		return messageBinder.bind(csContext, messageTemplate, bindings);
	}

	protected abstract @NonNull BaseCSVisitor<Continuation<?>> createContainmentVisitor(@NonNull CS2ASConversion cs2asConversion);

	protected@NonNull  CS2ASConversion createConversion(@NonNull IDiagnosticConsumer diagnosticsConsumer, @NonNull BaseCSResource csResource) {
		return new CS2ASConversion(this, diagnosticsConsumer);
	}

	protected @NonNull PivotHelper createHelper() {
		return new PivotHelper(environmentFactory);
	}

	protected abstract @NonNull BaseCSVisitor<Element> createLeft2RightVisitor(@NonNull CS2ASConversion cs2asConversion);
	protected abstract @NonNull BaseCSVisitor<Continuation<?>> createPostOrderVisitor(@NonNull CS2ASConversion converter) ;
	protected abstract @NonNull BaseCSVisitor<Continuation<?>> createPreOrderVisitor(@NonNull CS2ASConversion converter);

	public void dispose() {
		csi2asMapping.removeCSResource(csResource);
	}

	public @NonNull ASResource getASResource() {
		return asResource;
	}

	public @Nullable ModelElementCS getCSElement(@NonNull Element pivotElement) {
		return csi2asMapping.getCSElement(pivotElement);
	}

	public @NonNull BaseCSResource getCSResource() {
		return csResource;
	}

	public @NonNull PivotHelper getHelper() {
		PivotHelper helper2 = helper;
		if (helper2 == null) {
			helper = helper2 = createHelper();
		}
		return helper2;
	}

	public @Nullable Element getPivotElement(@NonNull ModelElementCS csElement) {
		return csi2asMapping.get(csElement);
	}

	public @Nullable <T extends Element> T getPivotElement(@NonNull Class<T> pivotClass, @NonNull ModelElementCS csElement) {
		Element pivotElement = csi2asMapping.get(csElement);
		if (pivotElement == null) {
			return null;
		}
		if (!pivotClass.isAssignableFrom(pivotElement.getClass())) {
			throw new ClassCastException(pivotElement.getClass().getName() + " is not assignable to " + pivotClass.getName());
		}
		@SuppressWarnings("unchecked")
		T castElement = (T) pivotElement;
		return castElement;
	}

	/**
	 * Install the mapping from a CS element that defines a pivot element to the defined pivot element. The definition
	 * is 'owned' by the CS element, so if the CS element vanishes, so does the pivot element.
	 */
	public void installPivotDefinition(@NonNull ModelElementCS csElement, @NonNull Element newPivotElement) {
		//	logger.trace("Installing " + csElement.getDescription()); //$NON-NLS-1$ //$NON-NLS-2$
		EObject oldPivotElement = csElement.getPivot();
		if (oldPivotElement != newPivotElement) {
			assert !newPivotElement.eIsProxy();
			csElement.setPivot(newPivotElement);
			if (oldPivotElement != null) {
				// WIP Queue dead element
			}
		}
		csi2asMapping.put(csElement, newPivotElement);
	}

	/**
	 * Install the mapping from a CS element to a completely independent pivot element. If the pivot element vanishes, the
	 * reference is stale, if the CS element the pivot element is less referenced.
	 */
	public void installPivotReference(@NonNull ElementRefCS csElement, @NonNull Element newPivotElement, @NonNull EReference eReference) {
		assert eReference.getEContainingClass().isSuperTypeOf(csElement.eClass());
		//	logger.trace("Installing " + csElement.getDescription()); //$NON-NLS-1$ //$NON-NLS-2$
		EObject oldPivotElement = csElement.getPivot();
		if (oldPivotElement != newPivotElement) {
			assert !newPivotElement.eIsProxy();
			csElement.setPivot(newPivotElement);
		}
	}

	/**
	 * Install the mapping from a CS element to a related pivot element. This normally arises when more than one CS element
	 * are associated with a single pivot element. In this case one of the CS elements is the defining CS element and the
	 * others are users.
	 */
	public void installPivotUsage(@NonNull PivotableElementCS csElement, @NonNull Element newPivotElement) {
		//	logger.trace("Installing " + csElement.getDescription()); //$NON-NLS-1$ //$NON-NLS-2$
		EObject oldPivotElement = csElement.getPivot();
		if (oldPivotElement != newPivotElement) {
			assert !newPivotElement.eIsProxy();
			csElement.setPivot(newPivotElement);
		}
	}

	@Deprecated  /* @deprecated FIXME Bug 548500 workaround */
	public void installRootContents(@NonNull BaseCSResource csResource2) {}

	/**
	 * Return true if csTYpeRef referes to a type that cannot be null, e.g. T[1],
	 * or false if it refers to a type that may be null, e.g. T[?],
	 * or null if the nulloty is unspecifued.
	 *
	 * Note that a lazy UML Set such as T[*] is always required; UML collections cannot be null.
	 */
	public @Nullable Boolean isRequired(@NonNull TypedRefCS csTypeRef) {
		MultiplicityCS csMultiplicity = csTypeRef.getOwnedMultiplicity();
		if (csMultiplicity != null) {
			int upper = csMultiplicity.getUpper();
			if (upper != 1) {		// Lazy UML-style Set
				assert !csTypeRef.eContainer().eClass().getName().equals("CollectionTypeCS");
				return true;
			}
			int lower = csMultiplicity.getLower();
			return lower > 0;
		}
		return null;
	}

	public @Nullable Iteration lookupIteration(@NonNull ElementCS csElement, @NonNull PathNameCS csPathName, @Nullable ScopeFilter scopeFilter) {
		setElementType(csPathName, PivotPackage.Literals.ITERATION, csElement, scopeFilter);
		Element namedElement = csPathName.getReferredElement();
		if ((namedElement instanceof Iteration) && !namedElement.eIsProxy()) {
			return (Iteration) namedElement;
		}
		else {
			return null;
		}
	}

	public @Nullable Operation lookupOperation(@NonNull ElementCS csElement, @NonNull PathNameCS csPathName, @Nullable ScopeFilter scopeFilter) {
		setElementType(csPathName, PivotPackage.Literals.OPERATION, csElement, scopeFilter);
		Element namedElement = csPathName.getReferredElement();
		if ((namedElement instanceof Operation) && !namedElement.eIsProxy()) {
			return (Operation) namedElement;
		}
		else {
			return null;
		}
	}

	public @Nullable Property lookupProperty(@NonNull ElementCS csElement, @NonNull PathNameCS csPathName, @Nullable ScopeFilter scopeFilter) {
		setElementType(csPathName, PivotPackage.Literals.PROPERTY, csElement, scopeFilter);
		Element namedElement = csPathName.getReferredElement();
		if ((namedElement instanceof Property) && !namedElement.eIsProxy()) {
			return (Property) namedElement;
		}
		else {
			return null;
		}
	}

	public @Nullable VariableDeclaration lookupSelf(@NonNull ElementCS csElement) {
		@SuppressWarnings("null") @NonNull EReference eReference = PivotPackage.Literals.EXPRESSION_IN_OCL__OWNED_CONTEXT;
		@SuppressWarnings("deprecation")
		EnvironmentView environmentView = parserContext != null ? new EnvironmentView(parserContext, eReference, PivotConstants.SELF_NAME) : new EnvironmentView(environmentFactory, eReference, PivotConstants.SELF_NAME);
		ScopeView baseScopeView = BaseScopeView.getScopeView(environmentFactory, csElement, eReference);
		environmentView.computeLookups(baseScopeView);
		VariableDeclaration variableDeclaration = (VariableDeclaration) environmentView.getContent();
		return variableDeclaration;
	}

	public @Nullable Type lookupType(@NonNull ElementCS csElement, @NonNull PathNameCS csPathName) {
		setElementType(csPathName, PivotPackage.Literals.TYPE, csElement, null);
		Element namedElement = csPathName.getReferredElement();
		if ((namedElement instanceof Type) && !namedElement.eIsProxy()) {
			return (Type) namedElement;
		}
		else {
			return null;
		}
	}

	public @Nullable Type lookupTypeQualifier(@NonNull PathNameCS csPathName) {
		List<PathElementCS> path = csPathName.getOwnedPathElements();
		int iMax = path.size();
		if (iMax <= 1) {
			return null;
		}
		PathElementCS pathElementCS = path.get(iMax-2);
		refreshElementType(pathElementCS, PivotPackage.Literals.TYPE);
		for (int i = 0; i < iMax-2; i++) {
			refreshElementType(path.get(i), PivotPackage.Literals.NAMESPACE);
		}
		Element namedElement = pathElementCS.getReferredElement();
		if ((namedElement instanceof Type) &&  !namedElement.eIsProxy()) {
			return (Type) namedElement;
		}
		else {
			return null;
		}
	}

	public @Nullable Type lookupTypeValue(@NonNull ElementCS csElement, @NonNull PathNameCS csPathName) {
		setElementType(csPathName, PivotPackage.Literals.NAMED_ELEMENT, csElement, TypeValueFilter.INSTANCE);	// Type or Variable
		Element namedElement = csPathName.getReferredElement();
		if ((namedElement instanceof Type) && !namedElement.eIsProxy()) {
			return (Type) namedElement;
		}
		else {
			return null;
		}
	}

	public @Nullable Element lookupUndecoratedName(@NonNull ElementCS csElement, @NonNull PathNameCS csPathName) {
		setElementType(csPathName, PivotPackage.Literals.ELEMENT, csElement, UndecoratedNameFilter.INSTANCE);
		Element namedElement = csPathName.getReferredElement();
		return namedElement;
	}

	public @NonNull <T extends Element> T refreshModelElement(@NonNull Class<T> pivotClass, @NonNull EClass pivotEClass, @Nullable ModelElementCS csElement) {
		Element pivotElement = csElement != null ? getPivotElement(csElement) : null;
		@NonNull Element pivotElement2;
		if ((pivotElement != null)
				&& pivotClass.isAssignableFrom(pivotElement.getClass())					// Avoid resetting container of incidental reference
				&& ((csElement == null) || (csElement.eContainer() != null))) {			// Avoid resetting container of potentially re-used root
			PivotUtilInternal.resetContainer(pivotElement);		// Bypass child-stealing detector
		}
		if ((pivotElement == null) || (pivotEClass != pivotElement.eClass())) {
			EFactory eFactoryInstance = pivotEClass.getEPackage().getEFactoryInstance();
			@NonNull Element pivotElement3 = (Element) eFactoryInstance.create(pivotEClass);
			pivotElement2 = pivotElement3;
		}
		else {
			pivotElement2 = pivotElement;
		}
		if (csElement != null) {
			installPivotDefinition(csElement, pivotElement2);
		}
		@SuppressWarnings("unchecked")
		@NonNull T castElement = (T) pivotElement2;
		return castElement;
	}

	public synchronized void update(@NonNull IDiagnosticConsumer diagnosticsConsumer) {
		//		printDiagnostic("CS2AS.update start", false, 0);
		@SuppressWarnings("unused") Map<CSI, Element> oldCSI2AS = csi2asMapping.getMapping();
		@SuppressWarnings("unused") Set<CSI> newCSIs = csi2asMapping.computeCSIs(csResource);
		//		System.out.println("==========================================================================");
		//		for (Resource csResource : csResources) {
		//			System.out.println("CS " + csResource.getClass().getName() + "@" + csResource.hashCode() + " " + csResource.getURI());
		//		}
		CS2ASConversion conversion = createConversion(diagnosticsConsumer, csResource);
		boolean wasUpdating = false;
		ASResource asResource = csi2asMapping.getASResource(csResource);
		if (asResource != null) {
			asResource.setUpdating(true);
		}
		conversion.update(csResource);
		//		System.out.println("---------------------------------------------------------------------------");
		//		Collection<? extends Resource> pivotResources = cs2asResourceMap.values();
		//		for (Entry<? extends Resource, ? extends Resource> entry : cs2asResourceMap.entrySet()) {
		//			Resource csResource = entry.getKey();
		//			Resource asResource = entry.getValue();
		//			System.out.println("CS " + csResource.getClass().getName() + "@" + csResource.hashCode() + " => " + asResource.getClass().getName() + "@" + asResource.hashCode());
		//		}
		/*		Set<String> deadCSIs = new HashSet<String>(oldCSI2AS.keySet());
		deadCSIs.removeAll(newCSIs);
		for (String deadCSI : deadCSIs) {
			Element deadPivot = oldCSI2AS.get(deadCSI);	// WIP
//			metamodelManager.kill(deadPivot);
		} */
		Map<BaseCSResource, ASResource> cs2asResourceMap = new HashMap<BaseCSResource, ASResource>();
		asResource = csi2asMapping.getASResource(csResource);
		assert asResource != null;
		cs2asResourceMap.put(csResource, asResource);
		AbstractJavaClassScope javaClassScope = AbstractJavaClassScope.findAdapter(csResource);
		if (javaClassScope != null) {
			javaClassScope.installContents(csResource);
		}
		conversion.garbageCollect(cs2asResourceMap);
		csi2asMapping.update();
		//		printDiagnostic("CS2AS.update end", false, 0);
		assert asResource.basicGetLUSSIDs() == null;			// Confirming Bug 579025
	}
}
