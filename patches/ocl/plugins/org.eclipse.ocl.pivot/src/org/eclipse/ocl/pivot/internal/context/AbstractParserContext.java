/*******************************************************************************
 * Copyright (c) 2012, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.context;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.messages.PivotMessagesInternal;
import org.eclipse.ocl.pivot.internal.resource.EnvironmentFactoryAdapter;
import org.eclipse.ocl.pivot.internal.scoping.Attribution;
import org.eclipse.ocl.pivot.internal.scoping.NullAttribution;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotConstantsInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.resource.CSResource;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.ParserContext;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.Pivotable;
import org.eclipse.ocl.pivot.utilities.StringUtil;

/**
 * AbstractParserContext provides the default implementation of the ParserContext API that all clients
 * should extend.
 */
public abstract class AbstractParserContext /*extends AdapterImpl*/ implements ParserContext
{
	private static final Logger logger = LogManager.getLogger(AbstractParserContext.class);

	protected final @NonNull EnvironmentFactoryInternal environmentFactory;
	protected final @NonNull URI uri;
	protected @Nullable Element rootElement = null;
	private @NonNull Map<@NonNull EClassifier, @NonNull Attribution> attributionRegistry = Attribution.REGISTRY;

	protected AbstractParserContext(@NonNull EnvironmentFactory environmentFactory, @Nullable URI uri) {
		this.environmentFactory = (EnvironmentFactoryInternal) environmentFactory;
		if (uri != null) {
			this.uri = uri;
		}
		else {
			this.uri = ClassUtil.nonNullEMF(URI.createURI(EcoreUtil.generateUUID() + ".essentialocl"));
		}
		this.attributionRegistry = Attribution.REGISTRY;
	}

	/**
	 * @since 1.3
	 */
	protected void addAttribution(/*@NonNull*/ EClass eClass, @NonNull Attribution attribution) {
		if (this.attributionRegistry == Attribution.REGISTRY) {
			this.attributionRegistry = new HashMap<>(Attribution.REGISTRY);
		}
		assert eClass != null;
		this.attributionRegistry.put(eClass, attribution);
	}

	@Override
	public @NonNull CSResource createBaseResource(@Nullable String expression) throws IOException, ParserException {
		InputStream inputStream = expression != null ? new URIConverter.ReadableInputStream(expression, "UTF-8") : null;
		try {
			ResourceSet resourceSet = environmentFactory.getResourceSet();
			Resource resource = resourceSet.createResource(uri);
			if (resource == null) {
				throw new ParserException("Failed to load '" + uri + "'" + getDoSetupMessage());
			}
			if (!(resource instanceof CSResource)) {
				throw new ParserException("Failed to create Xtext resource for '" + uri + "'" + getDoSetupMessage());
			}
			CSResource baseResource = (CSResource)resource;
			getEnvironmentFactory().adapt(resource);
			baseResource.setParserContext(this);
			if (inputStream != null) {
				baseResource.load(inputStream, null);
			}
			else {
				baseResource.load(null);
			}
			return baseResource;
		}
		finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}

	/**
	 * @since 1.3
	 */
	@Override
	public @NonNull Attribution getAttribution(@NonNull EObject eObject) {
		if (eObject.eIsProxy()) {			// Shouldn't happen, but certainly does during development
			logger.warn("getAttribution for proxy " + eObject);
			return NullAttribution.INSTANCE;
		}
		else {
			EClass eClass = eObject.eClass();
			assert eClass != null;
			Attribution attribution = attributionRegistry.get(eClass);
			if (attribution == null) {
				for (EClass superClass = eClass; superClass.getESuperTypes().size() > 0;) {
					superClass = superClass.getESuperTypes().get(0);
					attribution = attributionRegistry.get(superClass);
					if (attribution != null) {
						break;
					}
				}
				if (attribution == null) {
					attribution = NullAttribution.INSTANCE;
				}
				attributionRegistry.put(eClass, attribution);
			}
			return attribution;
		}
	}

	@Override
	public @Nullable Type getClassContext() {
		return null;
	}

	@Override
	public @Nullable Element getElementContext() {
		return getClassContext();
	}

	protected @NonNull String getDoSetupMessage() {
		if (EcorePlugin.IS_ECLIPSE_RUNNING) {
			return "";
		}
		String doSetup = environmentFactory.getDoSetupName(uri);
		if (doSetup == null) {
			return "";
		}
		return "\n\tMake sure " + doSetup + " has been called.";
	}

	@Override
	public @NonNull EnvironmentFactoryInternal getEnvironmentFactory() {
		return environmentFactory;
	}

	@Override
	public @NonNull ExpressionInOCL getExpression(@NonNull CSResource resource) throws ParserException {
		List<EObject> contents = resource.getContents();
		int size = contents.size();
		if (size < 1) {
			throw new ParserException("Missing parse returns");
		}
		if (size > 1) {
			throw new ParserException("Extra parse returns");
		}
		EObject csObject = contents.get(0);
		if (csObject instanceof Pivotable) {
			Element pivotElement = ((Pivotable)csObject).getPivot();
			if (pivotElement instanceof ExpressionInOCL) {
				return (ExpressionInOCL) pivotElement;
			}
		}
		throw new ParserException("Non-expression ignored");
	}

	public @Nullable Type getInstanceContext() {
		return null;
	}

	@Override
	public @NonNull PivotMetamodelManager getMetamodelManager() {
		return environmentFactory.getMetamodelManager();
	}

	/**
	 * @since 1.4
	 */
	protected @NonNull String getRole() {
		if (rootElement instanceof LanguageExpression) {
			return PivotUtilInternal.getSpecificationRole((LanguageExpression) rootElement);
		}
		else {
			return PivotConstantsInternal.UNKNOWN_ROLE;
		}
	}

	@Override
	public @Nullable Element getRootElement() {
		return rootElement;
	}

	@Override
	public void initialize(@NonNull Base2ASConversion conversion, @NonNull ExpressionInOCL expression) {
		//		List<String> language = expression.getLanguage();
		//		language.clear();
		//		language.add(PivotConstants.OCL_LANGUAGE);
	}

	@Override
	public @NonNull ExpressionInOCL parse(@Nullable EObject owner, @NonNull String expression) throws ParserException {
		CSResource resource = null;
		try {
			resource = createBaseResource(expression);
			String role = getRole();
			String contextName = NameUtil.qualifiedNameFor(getMessageContext());
			String invalidMessage = StringUtil.bind(PivotMessagesInternal.ValidationConstraintIsInvalid_ERROR_, role, contextName, expression.trim());
			PivotUtil.checkResourceErrors(invalidMessage, resource);
			ExpressionInOCL expressionInOCL = getExpression(resource);
			expressionInOCL.setBody(expression);
			return expressionInOCL;
		} catch (IOException e) {
			//				throw new ParserException("Failed to load expression", e);
			@NonNull ExpressionInOCL specification = PivotFactory.eINSTANCE.createExpressionInOCL();
			OCLExpression invalidValueBody = getMetamodelManager().createInvalidExpression();
			PivotUtil.setBody(specification, invalidValueBody, null);
			return specification;
		} finally {
			if (resource != null) {
				resource.unload();
				ResourceSet resourceSet = resource.getResourceSet();
				if (resourceSet != null) {
					resourceSet.getResources().remove(resource);
				}
				EnvironmentFactoryAdapter.disposeAll(resource);
			}
		}
	}

	/**
	 * @since 1.4
	 */
	protected Element getMessageContext() {
		return rootElement != null ? (Element) rootElement.eContainer() : getClassContext();
	}

	@Override
	public void setRootElement(@Nullable Element rootElement) {
		this.rootElement = rootElement;
	}
}
