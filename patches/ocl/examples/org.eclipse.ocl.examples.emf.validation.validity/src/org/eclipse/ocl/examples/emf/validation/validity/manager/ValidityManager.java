/*******************************************************************************
 * Copyright (c) 2013, 2019 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	E.D.Willink (CEA LIST) - initial API and implementation
 *  Obeo - Optimize View Input Refresh
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.emf.validation.validity.AbstractNode;
import org.eclipse.ocl.examples.emf.validation.validity.ConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.Result;
import org.eclipse.ocl.examples.emf.validation.validity.ResultConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.ResultSet;
import org.eclipse.ocl.examples.emf.validation.validity.ResultValidatableNode;
import org.eclipse.ocl.examples.emf.validation.validity.RootNode;
import org.eclipse.ocl.examples.emf.validation.validity.Severity;
import org.eclipse.ocl.examples.emf.validation.validity.ValidatableNode;
import org.eclipse.ocl.examples.emf.validation.validity.locator.ConstraintLocator;
import org.eclipse.ocl.examples.emf.validation.validity.plugin.ValidityPlugin;
import org.eclipse.ocl.examples.emf.validation.validity.utilities.IVisibilityFilter;
import org.eclipse.ocl.pivot.labels.ILabelGenerator;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.LabelUtil;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.ocl.pivot.utilities.URIUtil;

public class ValidityManager
{
	private static final @NonNull Map<@Nullable String, @NonNull List<ConstraintLocator.@NonNull Descriptor>> constraintLocatorDescriptors = new HashMap<@Nullable String, @NonNull List<ConstraintLocator.@NonNull Descriptor>>();
	private static final @NonNull Map<@NonNull String, @NonNull List<@NonNull ConstraintLocator>> constraintLocators = new HashMap<@NonNull String, @NonNull List<@NonNull ConstraintLocator>>();

	public static final @NonNull TracingOption ANALYZE_RESOURCE = new TracingOption(ValidityPlugin.PLUGIN_ID, "analyze/resource");
	public static final @NonNull TracingOption BUILD_TYPE = new TracingOption(ValidityPlugin.PLUGIN_ID, "build/type");
	public static final @NonNull TracingOption CREATE_CONSTRAINING = new TracingOption(ValidityPlugin.PLUGIN_ID, "create/constraining");
	public static final @NonNull TracingOption CREATE_RESULT = new TracingOption(ValidityPlugin.PLUGIN_ID, "create/result");
	public static final @NonNull TracingOption CREATE_VALIDATABLE = new TracingOption(ValidityPlugin.PLUGIN_ID, "create/validatable");
	public static final @NonNull TracingOption LOCATE_RESOURCE = new TracingOption(ValidityPlugin.PLUGIN_ID, "locate/resource");

	public static final @NonNull Map<ILabelGenerator.@NonNull Option<?>, @Nullable Object> LABEL_OPTIONS = new HashMap<ILabelGenerator.@NonNull Option<?>, @Nullable Object>();
	static {
		LABEL_OPTIONS.put(ILabelGenerator.Builder.SHOW_QUALIFIER, null);
	}

	private final @NonNull LinkedHashSet<@NonNull Resource> newResources = new LinkedHashSet<@NonNull Resource>();

	private final @NonNull Set<@NonNull Resource> oldResources = new HashSet<@NonNull Resource>();

	/**
	 * This add the corresponding constraint locator if it exists in the list of
	 * defined descriptors.
	 *
	 * @param nsURI
	 *            the nsURI of the validated resource
	 * @param constraintLocator
	 *            the corresponding constraint locator
	 */
	public static synchronized void addConstraintLocator(/*@NonNull*/ String nsURI, ConstraintLocator.@NonNull Descriptor constraintLocator) {
		List<ConstraintLocator.@NonNull Descriptor> list = constraintLocatorDescriptors.get(nsURI);
		if (list == null) {
			list = new ArrayList<ConstraintLocator.@NonNull Descriptor>();
			constraintLocatorDescriptors.put(nsURI, list);
		}
		if (!list.contains(constraintLocator)) {
			list.add(constraintLocator);
			constraintLocators.remove(nsURI);
		}
	}

	public static synchronized @Nullable ConstraintLocator getConstraintLocator(@NonNull EObject validatableObject) {
		return getConstraintLocator(validatableObject.eResource());
	}

	public static synchronized @Nullable ConstraintLocator getConstraintLocator(@Nullable Resource validatableResource) {
		if (validatableResource != null) {
			for (@NonNull EObject validatableObject : ClassUtil.nullFree(validatableResource.getContents())) {
				EClass eClass = validatableObject.eClass();
				if (eClass != null) {
					EPackage ePackage = eClass.getEPackage();
					if (ePackage != null) {
						String nsURI = ePackage.getNsURI();
						if (nsURI != null) {
							List<@NonNull ConstraintLocator> list = getConstraintLocators(nsURI);
							if ((list != null) && (list.size() > 0)) {
								return list.get(0);
							}
						}
					}
				}
			}
		}
		return null;
	}

	public static synchronized @NonNull List<@NonNull ConstraintLocator> getConstraintLocators(@NonNull String nsURI) {
		List<@NonNull ConstraintLocator> list = constraintLocators.get(nsURI);
		if (list == null) {
			list = new ArrayList<@NonNull ConstraintLocator>();
			constraintLocators.put(nsURI, list);
			List<ConstraintLocator.@NonNull Descriptor> descriptors = constraintLocatorDescriptors.get(nsURI);
			if (descriptors == null) {
				descriptors = constraintLocatorDescriptors.get(null);
			}
			if (descriptors != null) {
				for (ConstraintLocator.@NonNull Descriptor descriptor : descriptors) {
					ConstraintLocator constraintLocator = descriptor.getConstraintLocator();
					ConstraintLocator constraintLocatorInstance = constraintLocator.getInstance();
					if (!list.contains(constraintLocatorInstance)) {
						list.add(constraintLocatorInstance);
					}
				}
			}
		}
		return list;
	}

	protected final @NonNull ComposedAdapterFactory adapterFactory;
	protected final @NonNull Map<@NonNull ResultValidatableNode, @NonNull Result> resultsMap = new HashMap<@NonNull ResultValidatableNode, @NonNull Result>();
	protected final @SuppressWarnings("null")@NonNull Map<Object, Object> context = Diagnostician.INSTANCE.createDefaultContext();
	private @Nullable ValidityModel model = null;
	protected @Nullable ResultSet lastResultSet = null;
	private boolean forceRefresh = false;
	private @Nullable Object lastInput = null;

	public ValidityManager() {
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new EcoreItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
	}

	public void addConstrainingFilter(@NonNull IVisibilityFilter filter) {
		ValidityModel model2 = model;
		if (model2 != null) {
			model2.addConstrainingFilter(filter);
		}
	}

	public void addFilteredSeverity(@NonNull Severity severity) {
		ValidityModel model2 = model;
		if (model2 != null) {
			model2.addFilteredSeverity(severity);
		}
	}

	public void addValidatableFilter(@NonNull IVisibilityFilter filter) {
		ValidityModel model2 = model;
		if (model2 != null) {
			model2.addValidatableFilter(filter);
		}
	}

	protected void appendResourceURI(StringBuilder s, EObject eObject) {
		EObject eContainer = eObject.eContainer();
		if (eContainer == null) {
			Resource eResource = eObject.eResource();
			if (eResource != null) {
				URI uri = eResource.getURI();
				if (uri != null) {
					ResourceSet resourceSet = eResource.getResourceSet();
					if (resourceSet == null) {				// Probably a generated package
						s.append(" in " + uri);
					}
					else {
						Resource firstResource = resourceSet.getResources().get(0);
						URI firstURI = firstResource.getURI();
						URI resolvedURI = URIUtil.deresolve(uri, firstURI);
						if (resolvedURI.segmentCount() <= 0) {
							s.append(" in " + uri.lastSegment());
						}
						else if (!resolvedURI.toString().equals(s.toString())) {		// Skip redundant repetition of name for e.g. CompleteOCLDocumentCS
							s.append(" in " + resolvedURI);
						}
					}
				}
			}
		}
	}

	public @NonNull Map<Object, Object> createDefaultContext() {
		return context;
	}

	@SuppressWarnings("null")
	public @NonNull BasicDiagnostic createDefaultDiagnostic(@NonNull EObject eObject) {
		return Diagnostician.INSTANCE.createDefaultDiagnostic(eObject);
	}

	protected @NonNull ValidityModel createModel(@NonNull Collection<@NonNull Resource> newResources) {
		return new ValidityModel(this, newResources);
	}

	public /*synchronized*/ @Nullable ResultSet createResultSet(@Nullable IProgressMonitor monitor) {
		ValidityModel model2 = model;
		return model2 != null ? model2.createResultSet(monitor) : null;
	}

	public void dispose() {
		model = null;
		lastResultSet = null;
		resultsMap.clear();
	}

	protected @Nullable Set<@NonNull ConstraintLocator> gatherConstraintLocators(@Nullable Set<@NonNull ConstraintLocator> set, @NonNull List<@NonNull ConstraintLocator> list) {
		if (set == null) {
			set = new HashSet<@NonNull ConstraintLocator>();
		}
		set.addAll(list);
		return set;
	}

	public @NonNull Iterable<@NonNull ConstraintLocator> getActiveConstraintLocators(@NonNull String nsURI) {
		return getConstraintLocators(nsURI);
	}

	public @NonNull AdapterFactory getAdapterFactory() {
		return adapterFactory;
	}

	/**
	 * Return the ConstrainingNode node for EObject creating any ConstrainingNodes that
	 * are required to ensure that the returned ConstrainingNode is installed in the root.
	 */
	public @NonNull ConstrainingNode getConstrainingNode(@NonNull EObject eObject) {
		ValidityModel model2 = model;
		if (model2 == null) {
			throw new IllegalStateException();
		}
		return model2.getConstrainingNode(eObject);
	}

	public @NonNull List<@NonNull Result> getConstrainingNodeResults(@NonNull ConstrainingNode element) {
		List<@NonNull Result> results = new ArrayList<@NonNull Result>();
		if (element.getLabel().startsWith("EOperation")) {
			getAllConstrainingNodeResults(results, element);
		}
		else {
			getAllConstrainingNodeResults(results, element);
		}
		return results;
	}

	/**
	 * Returns the eObject uri
	 *
	 * @param eObject
	 * @return the eObject uri
	 */
	public @NonNull ConstrainingURI getConstrainingURI(@NonNull EObject eObject) {
		ConstraintLocator constraintLocator = ValidityManager.getConstraintLocator(eObject);
		if (constraintLocator != null) {
			ConstrainingURI uri = constraintLocator.getConstrainingURI(eObject);
			if (uri != null) {
				return uri;
			}
		}
		@NonNull URI uri = EcoreUtil.getURI(eObject);
		return new ConstrainingURI(uri);
	}

	private void getAllConstrainingNodeResults(@NonNull List<@NonNull Result> results, @NonNull ConstrainingNode element) {
		if (element instanceof ResultConstrainingNode) {
			ResultValidatableNode resultValidatableNode = ((ResultConstrainingNode)element).getResultValidatableNode();
			Result result = resultsMap.get(resultValidatableNode);
			if (result != null) {
				results.add(result);
			}
		}
		else {
			for (@NonNull ConstrainingNode child : ClassUtil.nullFree(element.getChildren())) {
				getAllConstrainingNodeResults(results, child);
			}
		}
	}

	private void getAllValidatableNodeResults(@NonNull List<@NonNull Result> results, @NonNull ValidatableNode element) {
		if (element instanceof ResultValidatableNode) {
			ResultValidatableNode resultValidatableNode = (ResultValidatableNode)element;
			Result result = resultsMap.get(resultValidatableNode);
			if (result != null) {
				results.add(result);
			}
		}
		else {
			for (@NonNull ValidatableNode child : ClassUtil.nullFree(element.getChildren())) {
				getAllValidatableNodeResults(results, child);
			}
		}
	}

	public @NonNull String getConstrainingLabel(@NonNull EObject eObject) {
		StringBuilder s = new StringBuilder();
		s.append(ILabelGenerator.Registry.INSTANCE.labelFor(eObject, LABEL_OPTIONS));
		appendResourceURI(s, eObject);
		return s.toString();
	}

	public @Nullable ValidityModel getModel() {
		return model;
	}

	public @Nullable RootNode getRootNode() {
		ValidityModel model2 = model;
		return model2 != null ? model2.getRootNode() : null;
	}

	/**
	 * Returns the eObject uri
	 */
	public @NonNull TypeURI getTypeURI(@NonNull EObject constrainingObject) {
		for (EObject eContainer = constrainingObject; eContainer != null; eContainer = eContainer.eContainer()) {
			if (eContainer instanceof EPackage) {
				EPackage constrainingEPackage = (EPackage) eContainer;
				String nsURI = constrainingEPackage.getNsURI();
				if ((nsURI != null) && !"".equals(nsURI)) {
					Resource eResource = constrainingEPackage.eResource();
					if (eResource != null) {
						String fragment = eResource.getURIFragment(constrainingObject);
						URI uri = URI.createURI(nsURI).appendFragment(fragment);
						return new TypeURI(uri);
					}
				}
			}
		}
		EClass eClass = constrainingObject.eClass();
		if (eClass != null) {
			EPackage ePackage = eClass.getEPackage();
			if (ePackage != null) {
				String nsURI = ePackage.getNsURI();
				if (nsURI != null) {
					List<@NonNull ConstraintLocator> constraintLocators = getConstraintLocators(nsURI);
					if (constraintLocators != null) {
						for (@NonNull ConstraintLocator constraintLocator : constraintLocators) {
							TypeURI uri = constraintLocator.getTypeURI(constrainingObject);
							if (uri != null) {
								return uri;
							}
						}
					}
				}
			}
		}
		@NonNull URI uri = EcoreUtil.getURI(constrainingObject);
		return new TypeURI(uri);
	}

	public @NonNull String getValidatableLabel(@NonNull EObject eObject, boolean withContext) {
		StringBuilder s = new StringBuilder();
		s.append(LabelUtil.SIMPLE_NAME_REGISTRY.labelFor(eObject, LABEL_OPTIONS));
		/*		if (eObject instanceof ENamedElement) {
			s.append(((ENamedElement)eObject).getName());
		}
		else {
			IItemLabelProvider itemLabelProvider = (IItemLabelProvider)adapterFactory.adapt(eObject, IItemLabelProvider.class);
			String label = itemLabelProvider != null ? itemLabelProvider.getText(eObject) : eObject.toString();
			s.append(label != null ? label : "");
		}
		if (eObject instanceof ETypedElement) {
			EClassifier eType = ((ETypedElement)eObject).getEType();
			s.append(" : " + eType.getName());
		}
		else {
			EClass eClass = eObject.eClass();
			if (eClass != null) {
				s.append(" | " + eClass.getName());
			}
		} */
		if (withContext) {
			appendResourceURI(s, eObject);
		}
		return s.toString();
	}

	public @NonNull List<@NonNull Result> getValidatableNodeResults(@NonNull ValidatableNode element) {
		List<@NonNull Result> results = new ArrayList<@NonNull Result>();
		getAllValidatableNodeResults(results, element);
		return results;
	}

	/**
	 * Returns the eObject uri
	 *
	 * @param eObject
	 * @return the eObject uri
	 */
	public @NonNull ValidatableURI getValidatableURI(@NonNull EObject eObject) {
		@NonNull URI uri = EcoreUtil.getURI(eObject);
		return new ValidatableURI(uri);
	}

	public void forceRefresh() {
		this.forceRefresh = true;
		setInput(lastInput, new BasicMonitor());
		this.forceRefresh = false;
	}

	/*	public void refreshModel(List<AbstractNode> grayedValidatableNodes,
			List<AbstractNode> grayedConstrainingNodes) {
		model.refreshModel(grayedValidatableNodes, grayedConstrainingNodes);
		RootNode rootNode = validityModel.getRootNode();
		if (rootNode != null) {
//			System.out.format(Thread.currentThread().getName() + " %3.3f Redraw compute grays\n", (System.currentTimeMillis() - start) * 0.001);
			for (AbstractNode abstractNode : rootNode.getConstrainingNodes()) {
				abstractNode.getGrayedElements(grayedConstrainingNodes);
			}
			for (AbstractNode abstractNode : rootNode.getValidatableNodes()) {
				abstractNode.getGrayedElements(grayedValidatableNodes);
			}
		}
//		System.out.format(Thread.currentThread().getName() + " %3.3f Redraw schedule main\n", (System.currentTimeMillis() - start) * 0.001);


	} */

	protected @Nullable List<@NonNull Result> installResultSet(@NonNull ResultSet resultSet, @NonNull IProgressMonitor monitor) {
		lastResultSet = resultSet;
		resultsMap.clear();
		RootNode rootNode = getRootNode();
		if (rootNode == null) {
			return null;
		}
		resetResults(ClassUtil.nullFree(rootNode.getValidatableNodes()));
		resetResults(ClassUtil.nullFree(rootNode.getConstrainingNodes()));
		List<@NonNull Result> results = ClassUtil.nullFree(resultSet.getResults());
		for (@NonNull Result result : results) {
			ResultValidatableNode resultValidatableNode = result.getResultValidatableNode();
			assert resultValidatableNode != null;
			resultsMap.put(resultValidatableNode, result);
			if (monitor.isCanceled()) {
				return null;
			}
		}
		return results;
	}

	public void removeConstrainingFilter(@NonNull IVisibilityFilter filter) {
		ValidityModel model2 = model;
		if (model2 != null) {
			model2.removeConstrainingFilter(filter);
		}
	}

	public void removeFilteredSeverity(@NonNull Severity severity) {
		ValidityModel model2 = model;
		if (model2 != null) {
			model2.removeFilteredSeverity(severity);
		}
	}

	public void removeValidatableFilter(@NonNull IVisibilityFilter filter) {
		ValidityModel model2 = model;
		if (model2 != null) {
			model2.removeValidatableFilter(filter);
		}
	}

	private void resetResults(@NonNull List<@NonNull ? extends AbstractNode> nodes) {
		for (@NonNull AbstractNode node : new ArrayList<>(nodes)) {
			resetResults(ClassUtil.nullFree(node.getChildren()));
			node.setWorstResult(null);
		}
	}

	public void setInput(Object newInput) {
		setInput(newInput, new BasicMonitor());
	}

	public void setInput(Object newInput, @NonNull Monitor monitor) {
		monitor.beginTask("Selective Validation", ValidityModel.WORK_FOR_ALL_SET_INPUT);
		monitor.setTaskName("Clean Up");
		ResourceSet selectedResourceSet = null;
		Resource selectedResource = null;
		EObject selectedObject = null;
		newResources.clear();
		lastInput = newInput;

		if (newInput == null) {
			oldResources.clear();
			model = null;
			return;
		}

		if (newInput instanceof ResourceSet) {
			selectedResourceSet = (ResourceSet) newInput;
		} else if (newInput instanceof Resource) {
			selectedResource = (Resource) newInput;
			selectedResourceSet = selectedResource.getResourceSet();
			if (selectedResourceSet == null) {
				List<@NonNull EObject> eContents = ClassUtil.nullFree(selectedResource.getContents());
				for (int j = 0; j < eContents.size(); j++) {		// Tolerate domain growth without a CME
					EObject eObject = ClassUtil.nonNull(eContents.get(j));
					EcoreUtil.resolveAll(eObject);
				}
				newResources.add(selectedResource);
			}
		} else if (newInput instanceof EObject) {
			selectedObject = (EObject) newInput;
			selectedResource = selectedObject.eResource();
			if (selectedResource != null) {
				selectedResourceSet = selectedResource.getResourceSet();
			}
		}

		if (selectedResourceSet != null) {
			synchronized (selectedResourceSet) {
				List<@NonNull Resource> selectedResources = ClassUtil.nullFree(selectedResourceSet.getResources());
				for (int i = 0; i < selectedResources.size(); i++) {	// Tolerate domain growth without a CME
					Resource eResource = ClassUtil.nonNull(selectedResources.get(i));
					List<EObject> eContents = eResource.getContents();
					for (int j = 0; j < eContents.size(); j++) {		// Tolerate domain growth without a CME
						EObject eObject = eContents.get(j);
						EcoreUtil.resolveAll(eObject);
					}
				}
				newResources.addAll(ClassUtil.nullFree(selectedResourceSet.getResources()));
			}
		}

		if (newResources.isEmpty()) {
			return;
		}

		if (!forceRefresh && !oldResources.isEmpty() && oldResources.equals(newResources)) {
			return;
		}

		monitor.worked(ValidityModel.WORK_FOR_CLEAN_UP);
		monitor.setTaskName("Creating model");
		ValidityModel model2 = model = createModel(newResources);
		monitor.worked(ValidityModel.WORK_FOR_CREATE_MODEL);
		model2.init(monitor);

		oldResources.clear();
		if (!monitor.isCanceled()) {
			oldResources.addAll(newResources);
		}
	}
}
