/*******************************************************************************
 * Copyright (c) 2005, 2007 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/

package org.eclipse.xtend.expression;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.internal.xtend.expression.ast.AbstractVisitor;
import org.eclipse.internal.xtend.expression.ast.DeclaredParameter;
import org.eclipse.internal.xtend.expression.ast.Identifier;
import org.eclipse.internal.xtend.expression.ast.SyntaxElement;
import org.eclipse.internal.xtend.type.baseimpl.PolymorphicResolver;
import org.eclipse.internal.xtend.type.baseimpl.TypesComparator;
import org.eclipse.internal.xtend.util.Cache;
import org.eclipse.internal.xtend.util.Pair;
import org.eclipse.internal.xtend.util.Triplet;
import org.eclipse.internal.xtend.xtend.XtendFile;
import org.eclipse.internal.xtend.xtend.ast.Around;
import org.eclipse.internal.xtend.xtend.ast.Extension;
import org.eclipse.internal.xtend.xtend.ast.ExtensionFile;
import org.eclipse.internal.xtend.xtend.types.AdviceContext;
import org.eclipse.xtend.typesystem.MetaModel;
import org.eclipse.xtend.typesystem.Operation;
import org.eclipse.xtend.typesystem.Property;
import org.eclipse.xtend.typesystem.Type;

/**
 * @author Sven Efftinge (http://www.efftinge.de)
 * @author Arno Haase
 * @author Peter Friese
 */
public class ExecutionContextImpl implements ExecutionContext {
	private final static Logger log = LogManager.getLogger(ExecutionContextImpl.class);
	private static final List<Type> NO_TYPES = Collections.emptyList();
	private static final Type[] NO_TYPES_ARR = new Type[0];
	private static final String[] NO_STRINGS = new String[0];

	protected ResourceManager resourceManager;

	private final Map<String, Variable> variables = new HashMap<String, Variable>();

	private Map<String, Variable> globalVars;

	private ProgressMonitor monitor;

	/**
	 * this field is conceptually final, i.e. it is set only at object construction time. To simplify implementation, it is however technically not
	 * final. This is done so that the cloneWith/WithoutResource methods can delegate to cloneContext and afterwards modify the instance. That
	 * provides cloneContext as a single method for subclasses to override.
	 */
	private Resource currentResource;

	protected final TypeSystemImpl typeSystem;

	protected ExceptionHandler exceptionHandler;

	protected NullEvaluationHandler nullEvaluationHandler;

	protected VetoableCallback callback;

	@SuppressWarnings("serial")
	protected final static class ExtensionsForNameAndTypeCacheKey extends Triplet<Resource, String, List<Type>> {
		final int hash;

		public ExtensionsForNameAndTypeCacheKey(final Resource first, final String second, final List<Type> third) {
			super(first, second, third);
			hash = super.hashCode();
		}

		@Override
		public int hashCode() {
			return hash;
		}
	}

	class ExtensionsForNameAndTypeCache extends Cache<Triplet<Resource, String, List<Type>>, Extension> {
		@Override
		protected Extension createNew(final Triplet<Resource, String, List<Type>> arg0) {
			return PolymorphicResolver.getExtension(internalAllExtensions(arg0.getFirst()), arg0.getSecond(), arg0.getThird());
		}
	}

	public ExecutionContextImpl() {
		this((Map<String, Variable>) null);
	}

	public ExecutionContextImpl(final TypeSystemImpl ts) {
		this(ts, null);
	}

	public ExecutionContextImpl(final Map<String, Variable> globalVars) {
		this(new ResourceManagerDefaultImpl(), null, new TypeSystemImpl(), new HashMap<String, Variable>(), globalVars, null, null, null, null, null,
				null, null, null);
	}

	public ExecutionContextImpl(final TypeSystemImpl ts, final Map<String, Variable> globalVars) {
		this(new ResourceManagerDefaultImpl(), null, ts, new HashMap<String, Variable>(), globalVars, null, null, null, null, null, null, null, null);
	}

	public ExecutionContextImpl(final ResourceManager resourceManager, final TypeSystemImpl typeSystem, final Map<String, Variable> globalVars) {
		this(resourceManager, null, typeSystem, new HashMap<String, Variable>(), globalVars, null, null, null, null, null, null, null, null);
	}

	public ExecutionContextImpl(final ResourceManager resourceManager, final Resource resource, final TypeSystemImpl typeSystem,
			final Map<String, Variable> variables, final Map<String, Variable> globalVars, final ProgressMonitor monitor,
			final ExceptionHandler exceptionHandler, final List<Around> advices, final NullEvaluationHandler neh2,
			final Map<Resource, Set<Extension>> extensionPerResourceMap, final VetoableCallback callback,
			final Cache<Triplet<Resource, String, List<Type>>, Extension> extensionsForNameAndTypesCache,
			final Map<Pair<String, List<Type>>, Type> extensionsReturnTypeCache) {

		if (extensionPerResourceMap != null) {
			allExtensionsPerResource = extensionPerResourceMap;
		} else {
			allExtensionsPerResource = new HashMap<Resource, Set<Extension>>();
		}
		if (extensionsForNameAndTypesCache != null) {
			this.extensionsForNameAndTypesCache = extensionsForNameAndTypesCache;
		} else {
			this.extensionsForNameAndTypesCache = new ExtensionsForNameAndTypeCache();
		}

		if (extensionsReturnTypeCache != null) {
			this.extensionsReturnTypeCache = extensionsReturnTypeCache;
		}

		this.resourceManager = resourceManager;
		currentResource = resource;
		this.typeSystem = typeSystem;
		if (variables != null) {
			this.variables.putAll(variables);
		}
		if (globalVars == null) {
			this.globalVars = new HashMap<String, Variable>();
		} else {
			this.globalVars = globalVars;
		}
		this.monitor = monitor;
		this.exceptionHandler = exceptionHandler;
		if (advices != null) {
			registeredExtensionAdvices = advices;
		}

		nullEvaluationHandler = neh2;
		this.callback = callback;
	}

	public VetoableCallback getCallback() {
		return callback;
	}

	public void registerMetaModel(final MetaModel mm) {
		typeSystem.registerMetaModel(mm);
	}

	public List<MetaModel> getMetaModels() {
		return typeSystem.getMetaModels();
	}

	public Operation findOperation(final String name, final Object target, final Object[] params) {
		return typeSystem.findOperation(name, target, params);
	}

	public Property findProperty(final String name, final Object target) {
		return typeSystem.findProperty(name, target);
	}

	public Type[] findTypesForPrefix(final String prefix) {
		return typeSystem.findTypesForPrefix(prefix, getImportedNamespaces());
	}

	public Type[] getAllTypes() {
		return typeSystem.getAllTypes();
	}

	public Set<String> getNamespaces() {
		return typeSystem.getNamespaces();
	}

	public Type getBooleanType() {
		return typeSystem.getBooleanType();
	}

	public Type getCollectionType(final Type innerType) {
		return typeSystem.getCollectionType(innerType);
	}

	public Type getFeatureType() {
		return typeSystem.getFeatureType();
	}

	public Type getIntegerType() {
		return typeSystem.getIntegerType();
	}

	public Type getListType(final Type innerType) {
		return typeSystem.getListType(innerType);
	}

	public Type getObjectType() {
		return typeSystem.getObjectType();
	}

	public Type getOperationType() {
		return typeSystem.getOperationType();
	}

	public Type getPropertyType() {
		return typeSystem.getPropertyType();
	}

	public Type getRealType() {
		return typeSystem.getRealType();
	}

	public Type getSetType(final Type innerType) {
		return typeSystem.getSetType(innerType);
	}

	public Type getStaticPropertyType() {
		return typeSystem.getStaticPropertyType();
	}

	public Type getStringType() {
		return typeSystem.getStringType();
	}

	public Type getType(final Object obj) {
		return typeSystem.getType(obj);
	}

	public Type getTypeForName(final String name) {
		return typeSystem.getTypeForName(name, getImportedNamespaces());
	}

	protected String[] getImportedNamespaces() {
		return currentResource != null ? currentResource.getImportedNamespaces() : NO_STRINGS;
	}

	public Type getTypeType() {
		return typeSystem.getTypeType();
	}

	public Type getVoidType() {
		return typeSystem.getVoidType();
	}

	public ExecutionContextImpl cloneContext() {
		return new ExecutionContextImpl(resourceManager, currentResource, typeSystem, variables, globalVars, monitor, exceptionHandler,
				registeredExtensionAdvices, nullEvaluationHandler, allExtensionsPerResource, callback, extensionsForNameAndTypesCache,
				extensionsReturnTypeCache);
	}

	/**
	 * @deprecated Use getResourceManager().setFileEncoding() instead
	 */
	@Deprecated
	public void setFileEncoding(final String encoding) {
		if (resourceManager != null) {
			resourceManager.setFileEncoding(encoding);
		}
	}

	public Variable getVariable(final String name) {
		return variables.get(name);
	}

	public Map<String, Variable> getVisibleVariables() {
		return Collections.unmodifiableMap(variables);
	}

	public Map<String, Variable> getGlobalVariables() {
		return globalVars;
	}

	public ExecutionContext cloneWithVariable(final Variable v) {
		final ExecutionContextImpl result = cloneContext();
		result.variables.put(v.getName(), v);
		return result;
	}

	public ExecutionContext cloneWithoutVariables() {
		final ExecutionContextImpl result = cloneContext();
		result.variables.clear();
		return result;
	}

	public ExecutionContext cloneWithResource(final Resource ns) {
		final ExecutionContextImpl ctx = cloneContext();
		ctx.currentResource = ns;
		return ctx;
	}

	public ExecutionContext cloneWithoutResource() {
		final ExecutionContextImpl ctx = cloneContext();
		ctx.currentResource = null;
		return ctx;
	}

	public ExecutionContext cloneWithoutMonitor() {
		final ExecutionContextImpl ctx = cloneContext();
		ctx.setMonitor(null);
		return ctx;
	}

	public Resource currentResource() {
		return currentResource;
	}

	public Set<? extends Extension> getAllExtensions() {
		return internalAllExtensions(currentResource());
	}

	protected Map<Resource, Set<Extension>> allExtensionsPerResource = null;

	private Set<? extends Extension> internalAllExtensions(final Resource currentResource2) {
		Set<Extension> allExtensions = allExtensionsPerResource.get(currentResource2);
		if (allExtensions == null) {
			ExecutionContext ctx = cloneWithResource(currentResource2);
			allExtensions = new HashSet<Extension>();
			final Resource res = currentResource2;
			if (res != null) {
				if (res instanceof XtendFile) {
					final List<Extension> extensionList = ((XtendFile) res).getExtensions();
					for (Extension element : extensionList) {
						element.init(ctx);
						allExtensions.add(advise(element));
					}
				}
				final String[] extensions = res.getImportedExtensions();
				for (final String extension : extensions) {
					final Object o = resourceManager.loadResource(extension, XtendFile.FILE_EXTENSION);
					final XtendFile extFile = (XtendFile) o;
					if (extFile != null) {
						ctx = cloneWithResource(extFile);
						final List<Extension> extensionList = extFile.getPublicExtensions(resourceManager, ctx);
						for (final Extension element : extensionList) {
							element.init(ctx);
							allExtensions.add(advise(element));
						}
					}
				}
			}
			allExtensionsPerResource.put(currentResource2, allExtensions);
		}
		return allExtensions;
	}

	protected Cache<Triplet<Resource, String, List<Type>>, Extension> extensionsForNameAndTypesCache;

	public Extension getExtensionForTypes(final String functionName, final Type[] parameterTypes) {
		ExtensionsForNameAndTypeCacheKey key = new ExtensionsForNameAndTypeCacheKey(currentResource(), functionName,
				parameterTypes != null ? Arrays.asList(parameterTypes) : NO_TYPES);
		return extensionsForNameAndTypesCache.get(key);
	}

	public Extension getExtension(final String functionName, final Object[] actualParameters) {
		if (actualParameters.length == 0) {
			return getExtensionForTypes(functionName, NO_TYPES_ARR);
		}
		final Type[] types = new Type[actualParameters.length];
		for (int i = 0; i < types.length; i++) {
			types[i] = getType(actualParameters[i]);
		}
		return getExtensionForTypes(functionName, types);
	}

	public void setMonitor(final ProgressMonitor monitor) {
		this.monitor = monitor;
	}

	public ProgressMonitor getMonitor() {
		return monitor;
	}

	public void preTask(final Object element) {
		if (monitor == null) {
			return;
		}
		monitor.preTask(element, this);
	}

	public void postTask(final Object element) {
		if (monitor == null) {
			return;
		}
		monitor.postTask(element, this);
	}

	public void handleRuntimeException(final RuntimeException ex, final SyntaxElement element, final Map<String, Object> additionalContextInfo) {
		if (exceptionHandler == null) {
			throw ex;
		}
		exceptionHandler.handleRuntimeException(ex, element, this, additionalContextInfo);
	}

	public ResourceManager getResourceManager() {
		return resourceManager;
	}

	protected List<Around> registeredExtensionAdvices = new LinkedList<Around>();

	public void registerExtensionAdvices(final String fullyQualifiedName) {
		final XtendFile ext = (XtendFile) resourceManager.loadResource(fullyQualifiedName, XtendFile.FILE_EXTENSION);
		if (ext == null) {
			throw new IllegalArgumentException("Couldn't find extension file '" + fullyQualifiedName + "'");
		}
		final List<Around> as = ext.getArounds();
		for (Around around : as) {
			if (registeredExtensionAdvices.contains(around)) {
				log.warn("advice " + around.toString() + " already registered!");
			} else {
				registeredExtensionAdvices.add(around);
			}
		}
	}

	public List<Around> getExtensionAdvices() {
		return registeredExtensionAdvices;
	}

	private final TypesComparator typesComparator = new TypesComparator();

	private Extension advise(final Extension element) {
		if ((registeredExtensionAdvices == null) || registeredExtensionAdvices.isEmpty()) {
			return element;
		}
		Extension _element = element;
		for (Around a : getExtensionAdvices()) {
			if (a.nameMatches(_element.getQualifiedName())) {
				List<Type> paramTypes = a.getParamTypes(this);
				List<Type> extPTypes = _element.getParameterTypes();
				int diff = extPTypes.size() - paramTypes.size();
				if (diff >= 0) {
					if ((diff > 0) && a.isWildparams()) { // fill wildcard
						// params with
						// Object types
						for (int i = 0; i < diff; i++) {
							paramTypes.add(getObjectType());
						}
					}
					if (typesComparator.compare(paramTypes, extPTypes) >= 0) {
						_element = new ExtensionAdvisor(a, _element);
					}
				}
			}
		}
		return _element;
	}

	class ExtensionAdvisor implements Extension {

		private final Extension delegate;

		private final Around advice;

		public ExtensionAdvisor(final Around advice, final Extension delegate) {
			this.delegate = delegate;
			this.advice = advice;
		}

		public Object evaluate(final Object[] parameters, final ExecutionContext ctx) {
			ExecutionContext _ctx = ctx;
			_ctx = _ctx.cloneWithVariable(new Variable(Around.CONTEXT_PARAM_NAME, new AdviceContext(delegate, _ctx, parameters)));
			for (int i = 0; i < advice.getParams().size(); i++) {
				_ctx = _ctx.cloneWithVariable(new Variable(advice.getParams().get(i).getName().toString(), parameters[i]));
			}
			_ctx = _ctx.cloneWithResource(advice.getParent());
			return advice.getExpression().evaluate(_ctx);
		}

		public void analyze(final ExecutionContext ctx, final Set<AnalysationIssue> issues) {
			delegate.analyze(ctx, issues);
		}

		public int getEnd() {
			return delegate.getEnd();
		}

		public ExtensionFile getExtensionFile() {
			return delegate.getExtensionFile();
		}

		public String getFileName() {
			return delegate.getFileName();
		}

		public List<DeclaredParameter> getFormalParameters() {
			return delegate.getFormalParameters();
		}

		public int getLine() {
			return delegate.getLine();
		}

		public String getName() {
			return delegate.getName();
		}

		public List<String> getParameterNames() {
			return delegate.getParameterNames();
		}

		public List<Type> getParameterTypes() {
			return delegate.getParameterTypes();
		}

		public Type getReturnType(final Type[] parameters, final ExecutionContext ctx, final Set<AnalysationIssue> issues) {
			return ctx.getReturnType(delegate, parameters, issues);
		}

		public Type getReturnType() {
			return delegate.getReturnType();
		}

		public Identifier getReturnTypeIdentifier() {
			return delegate.getReturnTypeIdentifier();
		}

		public int getStart() {
			return delegate.getStart();
		}

		public String getNameString(final ExecutionContext context) {
			return delegate.getNameString(context);
		}

		public void init(final ExecutionContext ctx) {
			delegate.init(ctx);
		}

		public boolean isCached() {
			return delegate.isCached();
		}

		public boolean isPrivate() {
			return delegate.isPrivate();
		}

		public void setExtensionFile(final ExtensionFile file) {
			delegate.setExtensionFile(file);
		}

		public String toOutlineString() {
			return delegate.toOutlineString();
		}

		@Override
		public String toString() {
			return delegate.toString();
		}

		public String getQualifiedName() {
			return delegate.getQualifiedName();
		}

		public final Object accept(final AbstractVisitor visitor) {
			return visitor.visit(this);
		}
	}

	public Object handleNullEvaluation(final SyntaxElement element) {
		if (nullEvaluationHandler != null) {
			return nullEvaluationHandler.handleNullEvaluation(element, this);
		}
		return null;
	}

	public void release() {
		typeSystem.release();
	}

	/**
	 * @deprecated Use {@link #setVetoableCallBack(VetoableCallback)}
	 */
	@Deprecated
	public void setCallBack(final Callback callback) {
		this.callback = new VetoableCallbackAdapter(callback);
	}

	public void setVetoableCallBack(final VetoableCallback callback) {
		this.callback = callback;
	}

	protected Map<Pair<String, List<Type>>, Type> extensionsReturnTypeCache = new HashMap<Pair<String, List<Type>>, Type>();

	public Type getReturnType(final Extension extension, final Type[] paramTypes, final Set<AnalysationIssue> issues) {
		final List<Type> value = paramTypes.length > 0 ? Arrays.asList(paramTypes) : NO_TYPES;
		Pair<String, List<Type>> key = new Pair<String, List<Type>>(extension.getQualifiedName(), value);
		if (extensionsReturnTypeCache.containsKey(key)) {
			return extensionsReturnTypeCache.get(key);
		}

		Type result = extension.getReturnType(paramTypes, this, issues);
		extensionsReturnTypeCache.put(key, result);
		return result;
	}

}
