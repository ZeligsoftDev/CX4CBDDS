/*******************************************************************************
 * Copyright (c) 2010, 2022 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Feature;
import org.eclipse.ocl.pivot.InvalidType;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.internal.resource.PivotSaveImpl.PivotXMIHelperImpl;
import org.eclipse.ocl.pivot.internal.utilities.PivotObjectImpl;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.util.PivotPlugin;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.TracingAdapter;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.ocl.pivot.utilities.XMIUtil;

/**
 * ASResourceImpl is the mandatory implementation of the ASResource interface that refines an
 * a standard EMF XMIResource to be used as a Pivot AS Resource.
 * @author ed
 *
 */
public class ASResourceImpl extends XMIResourceImpl implements ASResource
{
	/**
	 * If CHECK_IMMUTABILITY is set active, an ImmutabilityCheckingAdapter instance is installed for all
	 * contents of any ASREsource that is set not-saveable. Any mutation then causes an IllegalStateException.
	 *
	 * @since 1.5
	 */
	public static final TracingOption CHECK_IMMUTABILITY = new TracingOption(PivotPlugin.PLUGIN_ID, "resource/checkImmutability"); //$NON-NLS-1$

	/**
	 * QVTd JUnit tests may set this false to load the saved XMI as text for validation that it is free of
	 * references to undeclared xmi:ids. The OCL JUnit tests do not have sufficient referential complexity to have problems.
	 * See Bug 578030.
	 *
	 * @since 1.18
	 */
	public static boolean SKIP_CHECK_BAD_REFERENCES = false;

	/**
	 * An adapter implementation for tracking resource modification. This is only in use if the
	 * "resource/checkImmutability" .option is set as is the case for JUnit tests.
	 *
	 * @since 1.18
	 */
	protected class ImmutabilityCheckingAdapter extends AdapterImpl
	{
		private @NonNull String formatMutationMessage(@NonNull Notification notification) {
			StringBuilder s = new StringBuilder();
			s.append("'");
			s.append(ASResourceImpl.this.getURI());
			s.append("' modified at a '");
			s.append(TracingAdapter.getFeatureType(notification));
			s.append("'");
			return s.toString();
		}

		@Override
		public void notifyChanged(Notification notification) {			// FIXME All irregularities should be transient
			if (!notification.isTouch() && !ASResourceImpl.this.isUpdating && !ASResourceImpl.this.isUnloading) {
				Object notifier = notification.getNotifier();
				Object feature = notification.getFeature();
				int eventType = notification.getEventType();
				if (eventType == Notification.ADD) {
					if (notifier instanceof Resource) {
						int featureID = notification.getFeatureID(Resource.class);		// Occurs after unloading has finished
						if (featureID == RESOURCE__ERRORS) {
							return;
						}
						if (featureID == RESOURCE__WARNINGS) {
							return;
						}
					}
					else if (notifier instanceof Element) {
						if (feature == PivotPackage.Literals.ELEMENT__OWNED_EXTENSIONS) {
							return;
						}
						else if (notifier instanceof ExpressionInOCL) {						// A known safe laziness See Bug 535888#c6 and Bug 551822#c2
							if (feature == PivotPackage.Literals.EXPRESSION_IN_OCL__OWNED_PARAMETERS) {
								return;
							}
						}
						else if (notifier instanceof org.eclipse.ocl.pivot.Class) {
							if (feature == PivotPackage.Literals.CLASS__OWNED_PROPERTIES) {
								Object newValue = notification.getNewValue();
								if ((newValue instanceof Property) && ((Property)newValue).isIsImplicit()) {	// Late QVTr trace properties
									return;
								}
								return;
							}
							else if (notifier instanceof InvalidType) {						// A known safe laziness See Bug 579037#c2
								//		return;
							}
						}
					}
				}
				else if (eventType == Notification.REMOVE) {
					if (notifier instanceof org.eclipse.ocl.pivot.Class) {
						if (feature == PivotPackage.Literals.CLASS__OWNED_PROPERTIES) {
							Object oldValue = notification.getOldValue();
							if ((oldValue instanceof Property) && ((Property)oldValue).isIsImplicit()) {	// Late QVTr trace properties
								return;
							}
							return;
						}
					}
				}
				else if (eventType == Notification.SET) {
					if (notifier instanceof Resource) {
						int featureID = notification.getFeatureID(Resource.class);		// Occurs after unloading has finished
						if (featureID == RESOURCE__IS_LOADED) {
							return;
						}
					//	if (featureID == RESOURCE__URI) {
					//		return;
					//	}
						if (featureID == RESOURCE__TIME_STAMP) {
							return;
						}
					//	Resource resource = (Resource)notifier;
					//	if (!resource.isLoaded()) {
					//		return;
					//	}
					}
					else if (notifier instanceof Feature) {
						if (feature == PivotPackage.Literals.FEATURE__IMPLEMENTATION) {	// A known safe transient See Bug 535888#c6 and Bug 551822#c2
							Object oldValue = notification.getOldValue();
							if (oldValue == null) {
								return;
							}
						}
						if ((notifier instanceof Property) && ((Property)notifier).isIsImplicit()) {	// Occurs when unloading QVTr trace properties
				//			return;
						}
					}
					else if (notifier instanceof Constraint) {
						if (feature == PivotPackage.Literals.CONSTRAINT__OWNED_SPECIFICATION) {
							return;
						}
					}
					else if (notifier instanceof ExpressionInOCL) {					// A known safe laziness See Bug 535888#c6
						if (feature == PivotPackage.Literals.EXPRESSION_IN_OCL__OWNED_BODY) {
							return;
						}
						if (feature == PivotPackage.Literals.EXPRESSION_IN_OCL__OWNED_CONTEXT) {
							return;
						}
						if (feature == PivotPackage.Literals.EXPRESSION_IN_OCL__OWNED_RESULT) {
							return;
						}
						if (feature == PivotPackage.Literals.LANGUAGE_EXPRESSION__BODY) {
							return;
						}
						if (feature == PivotPackage.Literals.LANGUAGE_EXPRESSION__OWNING_CONSTRAINT) {
							return;
						}
						if (feature == PivotPackage.Literals.TYPED_ELEMENT__IS_REQUIRED) {
							return;
						}
						if (feature == PivotPackage.Literals.TYPED_ELEMENT__TYPE) {
							return;
						}
					}
				}
				// Drop through for nearly everything including REMOVE - see Bug 541380#c6
				throw new IllegalStateException(formatMutationMessage(notification));
			}
		}

		@Override
		public void setTarget(Notifier newTarget) {}

		@Override
		public void unsetTarget(Notifier oldTarget) {}
	}

	/**
	 * ImmutableResource provides additional API for derived ReadOnly/Immutable implementations.
	 *
	 * @since 1.5
	 */
	public static interface ImmutableResource
	{
		/**
		 * Return true if this Immutable/ReadOnly Resource is compatible with the given metamodelURI.
		 * This is typically used to allow a metamodelURI implementation to be re-used rather than cloned.
		 */
		boolean isCompatibleWith(@NonNull String metamodelURI);
	}

	/**
	 * @since 1.5
	 */
	private @Nullable ImmutabilityCheckingAdapter immutabilityCheckingAdapter = null;

	protected final @NonNull ASResourceFactory asResourceFactory;
	private @Nullable LUSSIDs lussids = null;
	private @Nullable Map<@NonNull String, @NonNull EObject> legacyXMIId2eObject = null;

	/**
	 * An attempt to save an unsaveable ASResource is ignored, probably because it is immutable..
	 */
	private boolean isSaveable = true;

	/**
	 * Set true during doUnload()
	 */
	private boolean isUnloading = false;

	/**
	 * Set true/false by setUpdating(). (See Bug 579109, we can aspire to eliminating many usages of this.)
	 */
	private boolean isUpdating = false;

	/**
	 * Creates an instance of the resource.
	 */
	public ASResourceImpl(@NonNull URI uri, @NonNull ASResourceFactory asResourceFactory) {
		super(uri);
		this.asResourceFactory = asResourceFactory;
		//	assert PivotUtilInternal.isASURI(uri);
		//	PivotUtilInternal.debugPrintln("Create " + NameUtil.debugSimpleName(this) + " : " + uri);
	}

	/**
	 * @since 1.4
	 */
	@Override
	public @Nullable EObject basicGetEObjectByID(@Nullable String id) {
		return idToEObjectMap != null ? idToEObjectMap.get(id) : null;
	}

	/**
	 * @since 1.4
	 */
	@Override
	public @Nullable LUSSIDs basicGetLUSSIDs() {
		return lussids;
	}

	/**
	 * Overridden to ensure that the ResourceFactoryRegistry ExtensionToFactoryMap entries for AS file extensions
	 * have ASResourceFactory instnaces that are able to fall back from AS extension to CS extension using the
	 * resourceSet as the AS ResourceSet for OCL parsing.
	 */
	@Override
	public NotificationChain basicSetResourceSet(ResourceSet resourceSet, NotificationChain notifications) {
		NotificationChain notificationChain = super.basicSetResourceSet(resourceSet, notifications);
		if (resourceSet != null) {
			String fileExtension = getURI().fileExtension();
			if (fileExtension != null) {
				Object resourceFactory = resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().get(fileExtension);
				if (resourceFactory == null) {
					ASResourceFactoryRegistry.INSTANCE.configureResourceFactoryRegistry(resourceSet);
				}
			}
		}
		return notificationChain;
	}

	/**
	 * @since 1.18
	 */
	protected @NonNull ImmutabilityCheckingAdapter createImmutabilityCheckingAdapter() {
		return new ImmutabilityCheckingAdapter();
	}

	/**
	 * @since 1.18
	 */
	protected @NonNull AbstractASSaver createASSaver() {
		return new ASSaverNew(this);
	}

	/**
	 * @since 1.18
	 */
	@Override
	protected @NonNull PivotXMIHelperImpl createXMLHelper() {
		return new PivotXMIHelperImpl(this);
	}

	/**
	 * @since 1.18
	 */
	@Override
	protected @NonNull PivotSaveImpl createXMLSave() {
		return new PivotSaveImpl(createXMLHelper());
	}

	@Override
	protected void doUnload() {
		isUnloading = true;
		try {
			super.doUnload();
			if (lussids != null) {
				resetLUSSIDs();
			}
		}
		finally {
			isUnloading = false;
		}
	}

	@Override
	public @NonNull ASResourceFactory getASResourceFactory() {
		return asResourceFactory;
	}

	@Override
	public @NonNull Map<Object, Object> getDefaultSaveOptions() {
		Map<Object, Object> defaultSaveOptions2 = defaultSaveOptions;
		if (defaultSaveOptions2 == null) {
			defaultSaveOptions = defaultSaveOptions2 = XMIUtil.createPivotSaveOptions();
		}
		return defaultSaveOptions2;
	}

	@SuppressWarnings("deprecation")
	@Override
	protected EObject getEObjectByID(String id) {
		if ((unloadingContents == null) && (idToEObjectMap == null)) { // Lazy xmi:id creation needed by generated ASResources
			AS2ID.assignIds(this, null);
		}
		if (idToEObjectMap == null) {
			return null;
		}
		EObject eObject = idToEObjectMap.get(id);
		if (eObject != null) {
			return eObject;
		}
		if (isLoading()) {
			return null;
		}
		// FIXME Use getXmiidVersion() to select appropriate algorithm
		Map<@NonNull String, @NonNull EObject> legacyXMIId2eObject2 = legacyXMIId2eObject;
		if (legacyXMIId2eObject2 == null) {
			org.eclipse.ocl.pivot.internal.utilities.AS2XMIid as2id = new org.eclipse.ocl.pivot.internal.utilities.AS2XMIid();
			legacyXMIId2eObject = legacyXMIId2eObject2 = new HashMap<>();
			for (EObject eObject2 : new TreeIterable(this)) {
				if (eObject2 instanceof Element) {
					Element element = (Element)eObject2;
					org.eclipse.ocl.pivot.utilities.AS2XMIidVisitor idVisitor = asResourceFactory.createAS2XMIidVisitor(as2id);
					Boolean status = element.accept(idVisitor);
					if (status == Boolean.TRUE) {
						String legacyId = idVisitor.toString();
						if (legacyId != null) {
							legacyXMIId2eObject2.put(legacyId,  eObject2);;
						}
					}
				}
			}
		}
		EObject eObject2 = legacyXMIId2eObject2.get(id);
		return eObject2;
	}

	/**
	 * @since 1.4
	 */
	@Override
	public @NonNull LUSSIDs getLUSSIDs(@NonNull Map<@NonNull Object, @Nullable Object> options) {
		LUSSIDs lussids2 = lussids;
		if (lussids2 == null) {
			lussids = lussids2 = ((ASResourceFactory.ASResourceFactoryExtension)asResourceFactory).createLUSSIDs(this, options);
		}
		return lussids2;
	}

	@Override
	public @NonNull Model getModel() {
		EList<EObject> contents = getContents();
		if (contents.size() <= 0) {
			throw new IllegalStateException("No Model at root of empty '" + getURI() + "'");
		}
		EObject eObject = contents.get(0);
		if (!(eObject instanceof Model)) {
			throw new IllegalStateException("Non-Model at root of '" + getURI() + "'");
		}
		return (Model)eObject;
	}

//	Deleted by Bug 579025; LUSSIDs are not to be created prior to save
//	public String getURIFragment(EObject eObject) {
//		if ((unloadingContents == null) && (idToEObjectMap == null)) {
//			AS2ID.assignIds(this, null);
//		}
//		return super.getURIFragment(eObject);
//	}

	/**
	 * @since 1.4
	 */
	@Override
	public int getXmiidVersion() {
		for (EObject eRoot : getContents()) {
			if (eRoot instanceof Model) {
				Number xmiidVersion = ((Model)eRoot).getXmiidVersion();
				if (xmiidVersion != null) {
					return xmiidVersion.intValue();
				}
			}
		}
		return 0;
	}

	/**
	 * Read the serialized representation to confirm that all external references
	 * use an xmi:id to enhance persistence in the case of model evolution.
	 */
	private boolean isFreeOfBadReferences() throws IOException {
		InputStream inputStream = getResourceSet().getURIConverter().createInputStream(uri);
		Reader reader = new InputStreamReader(inputStream);
		StringBuilder s = new StringBuilder();
		char[] buf = new char[4096];
		for (int len; (len = reader.read(buf)) > 0; ) {
			s.append(buf, 0, len);
		}
		reader.close();
		String string = s.toString();
		int index = string.indexOf("#//@");
		if (index < 0) {
			return true;
		}
		int preIndex = string.lastIndexOf("\n", index);
		int postIndex = string.indexOf("\n", index);
		String refText = string.substring(preIndex, postIndex).trim();
		System.err.println("Missing xmi:id for reference in \'" + uri + "'\n\t" + refText);
		// PivotLUSSIDs.isExternallyReferenceable determines what gets xmi:ids
		return false;
	}

	@Override
	public boolean isOrphanage() {
		return false;
	}

	@Override
	public boolean isSaveable() {
		return isSaveable;
	}

	/**
	 * @since 1.4
	 */
	@Override
	public void resetLUSSIDs() {
		LUSSIDs lussids2 = lussids;
		if (lussids2 != null) {
			lussids = null;
			//	System.out.println("resetLUSSIDs for "  + getURI());
			lussids2.dispose();
		}
	}

	/**
	 * Overridden to suppress saving unsaveable content to a probably read-only destination.
	 */
	@Override
	public void save(Map<?, ?> options) throws IOException {
		if (isSaveable) {
			setXmiidVersion(PivotConstants.XMIIDS_CURRENT);
			if (options == null) {
				options = getDefaultSaveOptions();
			}
			XMIUtil.IdResourceEntityHandler.reset(options);
			super.save(options);
			assert SKIP_CHECK_BAD_REFERENCES || isFreeOfBadReferences();
		}
	}

	/**
	 * @since 1.5
	 */
	@Override
	public boolean setSaveable(boolean isSaveable) {
		boolean wasSaveable = this.isSaveable;
		this.isSaveable = isSaveable;
		if (isSaveable) {
			if (immutabilityCheckingAdapter != null) {
				this.eAdapters().remove(immutabilityCheckingAdapter);
				for (TreeIterator<EObject> i = getAllProperContents(getContents()); i.hasNext(); ) {
					EObject eObject = i.next();
					eObject.eAdapters().remove(immutabilityCheckingAdapter);
				}
				immutabilityCheckingAdapter = null;
			}
		}
		else if (wasSaveable && CHECK_IMMUTABILITY.isActive()) {
			if (immutabilityCheckingAdapter == null) {
				immutabilityCheckingAdapter = createImmutabilityCheckingAdapter();
			}
			for (TreeIterator<EObject> i = getAllProperContents(getContents()); i.hasNext(); ) {
				EObject eObject = i.next();
				eObject.eAdapters().add(immutabilityCheckingAdapter);
			}
			this.eAdapters().add(immutabilityCheckingAdapter);
		}
		return wasSaveable;
	}

	@Override
	public boolean setUpdating(boolean isUpdating) {
		boolean wasUpdating = this.isUpdating;
		this.isUpdating = isUpdating;
		return wasUpdating;
	}

	/**
	 * @since 1.4
	 */
	@Override
	public void setXmiidVersion(int xmiidVersion) {
		for (EObject eRoot : getContents()) {
			if (eRoot instanceof Model) {
				((Model)eRoot).setXmiidVersion(xmiidVersion);
			}
		}
	}

	/**
	 * @since 1.18
	 */
	protected String superGetURIFragment(EObject eObject) {
		return super.getURIFragment(eObject);		// Bypass assignIds for use by OrphanResource
	}

	@Override
	protected void unloaded(InternalEObject internalEObject) {
		if (internalEObject instanceof PivotObjectImpl) {
			((PivotObjectImpl)internalEObject).unloaded(this);
		}
		super.unloaded(internalEObject);
	}

	@Override
	protected boolean useIDAttributes() {
		return false;
	}

	@Override
	protected boolean useIDs() {
		return true;
	}
}
