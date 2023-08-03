/***************************************************
 * Copyright (c) 2010 Atos Origin.

 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * Atos Origin - Initial API and implementation
 *
 ****************************************************/
package org.eclipse.papyrus.views.modelexplorer.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.DestroyElementPapyrusCommand;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;

/**
 * The Class EObjectInheritanceCopyCommand. it takes an eobject in parameter and
 * copy all the elements contained in the source to the target and adds the
 * target to the container of the source
 */
public class EObjectInheritanceCopyCommand extends CompositeCommand {

	private final EObject sourceEObject;

	private final EObject targetEObject;

	private final TransactionalEditingDomain editingDomain;

	private Collection<Object> alreadyManaged = new LinkedList<Object>();

	public EObjectInheritanceCopyCommand(EObject source, EClass target, TransactionalEditingDomain adapterFactoryEditingDomain) {
		super("Inheritance copy"); //$NON-NLS-1$
		this.sourceEObject = source;
		this.targetEObject = target.getEPackage().getEFactoryInstance().create(target);
		this.editingDomain = adapterFactoryEditingDomain;
		if (sourceEObject == null || targetEObject == null || editingDomain == null) {
			throw new IllegalArgumentException("Please provide non null arguments"); //$NON-NLS-1$
		}
		init();
		if (sourceEObject.eContainingFeature().isMany()) {
			replace(sourceEObject.eContainer(), sourceEObject, targetEObject, sourceEObject.eContainingFeature());
		} else {
			add(new CustomSetCommand(editingDomain, sourceEObject.eContainer(), sourceEObject.eContainingFeature(), targetEObject, sourceEObject, sourceEObject.eContainingFeature()));
			add(new DestroyElementPapyrusCommand(new DestroyElementRequest(editingDomain, sourceEObject, false)));
		}
	}

	private void init() {
		modelCopy(sourceEObject, targetEObject);
		crossReference(sourceEObject, targetEObject);
	}

	/**
	 * Model copy, copy the eobject source attributes to target's
	 *
	 * @param mixedDomain
	 *            the mixed domain
	 * @param source
	 *            the source
	 * @param target
	 *            the target
	 */
	private void modelCopy(EObject source, EObject target) {
		EClass eclass = source.eClass();
		if (eclass != null) {
			EList<EStructuralFeature> eAllStructuralFeatures = eclass.getEAllStructuralFeatures();
			for (EStructuralFeature e : eAllStructuralFeatures) {
				if (contains(target.eClass(), e) && isCompatible(e.getEType(), target.eClass().getEStructuralFeature(e.getName()).getEType())) {
					manageFeature(source, target, e);
				}
			}
		}
	}

	/**
	 * Contains. check if the target eclass contains a estructuralfeature with
	 * the same name less rigorous can work for many cases
	 *
	 * @param target
	 *            the target
	 * @param e
	 *            the e
	 *
	 * @return true, if successful
	 */
	private boolean contains(EClass target, EStructuralFeature e) {
		EList<EStructuralFeature> features = target.getEAllStructuralFeatures();
		for (EStructuralFeature f : features) {
			if (f.getName().equals(e.getName())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Manage feature for cross.
	 *
	 * @param mixedDomain
	 *            the mixed domain
	 * @param theObjectWithCross
	 *            the the object with cross
	 * @param source
	 *            the source
	 * @param target
	 *            the target
	 * @param structuralFeature
	 *            the structural feature
	 */
	private void manageFeatureForCross(EObject theObjectWithCross, EObject source, EObject target, EStructuralFeature structuralFeature) {
		boolean compatible = isCompatible(structuralFeature.getEType(), target.eClass());

		if (compatible && structuralFeature.isChangeable() && !structuralFeature.isDerived()) {
			if (structuralFeature.isMany()) {
				replace(theObjectWithCross, source, target, structuralFeature);
			} else {
				add(new SetValueCommand(new SetRequest(editingDomain, theObjectWithCross, structuralFeature, target)));
			}
		} else if (!compatible) {
			if (structuralFeature.isMany()) {
				remove(theObjectWithCross, source, structuralFeature);
			} else {
				add(new SetValueCommand(new SetRequest(editingDomain, theObjectWithCross, structuralFeature, null)));
			}
		}

	}

	private void remove(EObject owner, Object source, EStructuralFeature structuralFeature) {
		if (!alreadyManaged.contains(source)) {

			if (owner == null && structuralFeature == null) {
				if (source instanceof EObject) {
					add(new DestroyElementPapyrusCommand(new DestroyElementRequest(editingDomain, (EObject) source, false)));
				}
			} else {
				Object value = owner.eGet(structuralFeature);
				if (value instanceof Collection<?>) {
					List<Object> newList = new ArrayList<Object>((Collection<?>) value);
					newList.remove(source);
					add(new SetValueCommand(new SetRequest(editingDomain, owner, structuralFeature, newList)));
				} else if (source.equals(value)) {
					add(new SetValueCommand(new SetRequest(editingDomain, owner, structuralFeature, null)));
				} else {
					add(new SetValueCommand(new SetRequest(editingDomain, owner, structuralFeature, null)));
				}
			}
			alreadyManaged.add(source);
		}
	}

	private void replace(EObject owner, Object source, Object target, EStructuralFeature structuralFeature) {
		if (!alreadyManaged.contains(source)) {

			if (owner == null && structuralFeature == null) {
				if (source instanceof EObject) {
					add(new DestroyElementPapyrusCommand(new DestroyElementRequest(editingDomain, (EObject) source, false)));
				}
			} else {
				Object value = owner.eGet(structuralFeature);
				if (value instanceof Collection<?>) {
					List<Object> newList = new ArrayList<Object>((Collection<?>) value);
					int index = newList.indexOf(source);
					if (index >= 0) {
						newList.remove(index);
						newList.add(index, target);
						add(new SetValueCommand(new SetRequest(editingDomain, owner, structuralFeature, newList)));
					}
				} else if (source.equals(value)) {
					add(new SetValueCommand(new SetRequest(editingDomain, owner, structuralFeature, target)));
				} else {
					add(new SetValueCommand(new SetRequest(editingDomain, owner, structuralFeature, target)));
				}
			}
			alreadyManaged.add(source);
		}
	}

	@Override
	public IStatus undo(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		return super.undo(progressMonitor, info);
	}

	/**
	 * Cross reference. Manage eobjects referencing the source eobject
	 *
	 * @param mixedDomain
	 *            the mixed domain
	 * @param source
	 *            the source eobject
	 * @param target
	 *            the target eobject
	 */
	private void crossReference(EObject source, EObject target) {
		Collection<EStructuralFeature.Setting> collection = EMFHelper.getUsages(source);
		if (collection != null) {
			for (EStructuralFeature.Setting nonNavigableInverseReference : collection) {
				EStructuralFeature structuralFeature = nonNavigableInverseReference.getEStructuralFeature();
				if (!(nonNavigableInverseReference.getEObject() instanceof View)) {
					manageFeatureForCross(nonNavigableInverseReference.getEObject(), source, target, structuralFeature);
				} else if (nonNavigableInverseReference.getEObject() instanceof Diagram) {
					Diagram di = (Diagram) nonNavigableInverseReference.getEObject();
					remove(null, di, null);
				}
			}
		}
	}

	/**
	 * Checks if a type is compatible to another.
	 *
	 * @param type
	 *            the type
	 * @param target
	 *            the target
	 *
	 * @return true, if is compatible
	 */
	public static boolean isCompatible(EClassifier type, EClassifier target) {
		Collection<EClassifier> types = new LinkedList<EClassifier>();
		if (target instanceof EClass) {
			EClass eclass = (EClass) target;
			types.addAll(eclass.getEAllSuperTypes());
		}
		if (!types.contains(target)) {
			types.add(target);
		}
		return types.contains(type);
	}

	/**
	 * Manage a feature for the attribute's copy.
	 *
	 * @param mixedDomain
	 *            the mixed domain
	 * @param source
	 *            the source
	 * @param target
	 *            the target
	 * @param feature
	 *            the e
	 */
	@SuppressWarnings("unchecked")
	private void manageFeature(EObject source, EObject target, EStructuralFeature feature) {
		EStructuralFeature targetFeature = getFeature(target, feature.getName());

		if (feature.getUpperBound() <= targetFeature.getUpperBound() && feature.getLowerBound() >= targetFeature.getLowerBound()) {
			if (feature.isChangeable() && !feature.isDerived()) {
				Object value = source.eGet(feature);
				if (feature.isMany() && targetFeature.isMany()) {
					Collection<EObject> list = (Collection<EObject>) value;
					if (list != null && !list.isEmpty()) {
						Collection<EObject> newList = new LinkedList<EObject>();
						newList.addAll(list);
						if (feature instanceof EReference && !((EReference) feature).isContainment()) {
							add(new SetValueCommand(new SetRequest(editingDomain, target, targetFeature, newList)));
						} else if (feature instanceof EReference && ((EReference) feature).isContainment()) {
							Collection<Object> toTreat = new LinkedList<Object>();
							for (Object o : newList) {
								if (!alreadyManaged.contains(o)) {
									toTreat.add(o);
									alreadyManaged.add(o);
								}
							}
							add(new CustomAddCommand(editingDomain, target, targetFeature, newList, source, feature));
						}
					}
				} else if (!feature.isMany() && !targetFeature.isMany()) {
					if (value != null) {
						if (!alreadyManaged.contains(value)) {
							alreadyManaged.add(value);
							add(new CustomSetCommand(editingDomain, target, targetFeature, value, source, feature));
						}
					}
				}
			}
		}

	}

	/**
	 * Gets a feature from a name
	 *
	 * @param eobject
	 *            the eobject
	 * @param name
	 *            the name
	 *
	 * @return the feature
	 */
	private EStructuralFeature getFeature(EObject eobject, String name) {
		return eobject.eClass().getEStructuralFeature(name);
	}

	/**
	 * Gets the result eobject.
	 *
	 * @return the result eobject
	 */
	public EObject getResultEobject() {
		return targetEObject;
	}

	/**
	 * The Class CustomSetCommand. permits to change a value from an eobject to
	 * eanother
	 */
	private class CustomSetCommand extends SetValueCommand {

		private EObject oldObject = null;

		private EStructuralFeature oldFeature = null;

		private Object oldValue = null;

		public CustomSetCommand(TransactionalEditingDomain domain, EObject owner, EStructuralFeature feature, Object value, EObject old, EStructuralFeature structuralFeature) {
			super(new SetRequest(domain, owner, feature, value));
			oldObject = old;
			oldFeature = structuralFeature;
			oldValue = value;
		}

		@Override
		protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			IStatus result = super.doUndo(monitor, info);
			oldObject.eSet(oldFeature, oldValue);
			return result;
		}

	}

	/**
	 * The Class CustomSetCommand. permits to change a value from an eobject to
	 * eanother
	 */
	private class CustomAddCommand extends SetValueCommand {

		private EObject oldObject = null;

		private EStructuralFeature oldFeature;

		private EStructuralFeature newFeature;

		public CustomAddCommand(TransactionalEditingDomain editingDomain, EObject target, EStructuralFeature targetFeature, Collection<EObject> newList, EObject source, EStructuralFeature e) {
			super(new SetRequest(editingDomain, target, targetFeature, newList));
			oldObject = source;
			oldFeature = e;
			newFeature = targetFeature;
		}

		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			Object values = getElementToEdit().eGet(newFeature);
			IStatus result = super.doUndo(monitor, info);
			// this test permit to avoid modification from other command
			// if getOwner list is empty it will perform error we avoid it
			if (values instanceof Collection<?> && !((Collection<?>) values).isEmpty()) {
				Collection<?> collection = (Collection<?>) values;
				Collection<Object> collecOldObject = (Collection) oldObject.eGet(oldFeature);
				for (Object o : collection) {
					if (!collecOldObject.contains(o)) {
						collecOldObject.add(o);
					}
				}
			}
			return result;
		}
	}
}
