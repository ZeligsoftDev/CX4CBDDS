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
package com.zeligsoft.domain.omg.corba.ui.providers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProviderChangeListener;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.GetRelTypesOnSourceAndTargetOperation;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.GetRelTypesOnSourceOperation;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.GetRelTypesOnTargetOperation;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.GetTypesForPopupBarOperation;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.GetTypesForSourceOperation;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.GetTypesForTargetOperation;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.IModelingAssistantProvider;
import org.eclipse.uml2.uml.Element;

import com.ibm.xtools.uml.type.UMLElementTypes;
import com.zeligsoft.base.zdl.type.ZDLElementTypeUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;
import com.zeligsoft.domain.omg.corba.util.CORBADomainSwitch;

/**
 * @author ysroh
 * 
 */
@SuppressWarnings("rawtypes")
public class CORBAModelingAssistantProvider implements
		IModelingAssistantProvider {

	private PopupBarSwitch popupbarFactory = new PopupBarSwitch();
	private RelTypesOnSourceFactory sourceRelTypesFactory = new RelTypesOnSourceFactory();
	private TypesForSourceFactory sourceTypesFactory = new TypesForSourceFactory();
	private RelTypesOnTargetFactory targetRelTypesFactory = new RelTypesOnTargetFactory();
	private TypesForTargetFactory targetTypesFactory = new TypesForTargetFactory();
	private RelTypesOnSourceAndTargetOperation connectionTypesFactory = new RelTypesOnSourceAndTargetOperation();

	/**
	 * 
	 */
	public CORBAModelingAssistantProvider() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.
	 * IModelingAssistantProvider
	 * #getRelTypesForSREOnSource(org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	public List getRelTypesForSREOnSource(IAdaptable source) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.
	 * IModelingAssistantProvider
	 * #getRelTypesForSREOnTarget(org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	public List getRelTypesForSREOnTarget(IAdaptable target) {
		return null;
	}

	private boolean hasProfile(Element element) {
		return ZDLUtil.isZDLDomain(element, "CORBADomain"); //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.
	 * IModelingAssistantProvider
	 * #getRelTypesOnSource(org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	public List getRelTypesOnSource(IAdaptable source) {
		EObject eObject = (EObject) source.getAdapter(EObject.class);
		if (eObject != null && hasProfile((Element) eObject)) {
			return sourceRelTypesFactory.doSwitch(eObject);
		}

		return Collections.EMPTY_LIST;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.
	 * IModelingAssistantProvider
	 * #getRelTypesOnSourceAndTarget(org.eclipse.core.runtime.IAdaptable,
	 * org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	public List getRelTypesOnSourceAndTarget(IAdaptable source,
			IAdaptable target) {
		EObject sourceEObj = (EObject) source.getAdapter(EObject.class);
		EObject targetEObj = (EObject) target.getAdapter(EObject.class);
		if (sourceEObj == null || targetEObj == null
				|| !hasProfile((Element) sourceEObj)
				|| !hasProfile((Element) targetEObj)) {
			return Collections.EMPTY_LIST;
		}

		return connectionTypesFactory.doSwitch(sourceEObj, targetEObj);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.
	 * IModelingAssistantProvider
	 * #getRelTypesOnTarget(org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	public List getRelTypesOnTarget(IAdaptable target) {
		EObject eObject = (EObject) target.getAdapter(EObject.class);
		if (eObject != null && hasProfile((Element) eObject)) {
			return targetRelTypesFactory.doSwitch(eObject);
		}

		return Collections.EMPTY_LIST;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.
	 * IModelingAssistantProvider#getTypes(java.lang.String,
	 * org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	public List getTypes(String hint, IAdaptable data) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.
	 * IModelingAssistantProvider
	 * #getTypesForPopupBar(org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	public List getTypesForPopupBar(IAdaptable host) {
		EObject eObject = (EObject) host.getAdapter(EObject.class);
		if (eObject != null && hasProfile((Element) eObject)) {
			return popupbarFactory.doSwitch(eObject);
		}

		return Collections.EMPTY_LIST;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.
	 * IModelingAssistantProvider
	 * #getTypesForSource(org.eclipse.core.runtime.IAdaptable,
	 * org.eclipse.gmf.runtime.emf.type.core.IElementType)
	 */
	@Override
	public List getTypesForSource(IAdaptable target,
			IElementType relationshipType) {
		EObject eObject = (EObject) target.getAdapter(EObject.class);
		if (eObject != null && hasProfile((Element) eObject)) {
			return targetTypesFactory.doSwitch(eObject, relationshipType);
		}

		return Collections.EMPTY_LIST;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.
	 * IModelingAssistantProvider
	 * #getTypesForTarget(org.eclipse.core.runtime.IAdaptable,
	 * org.eclipse.gmf.runtime.emf.type.core.IElementType)
	 */
	@Override
	public List getTypesForTarget(IAdaptable source,
			IElementType relationshipType) {
		EObject eObject = (EObject) source.getAdapter(EObject.class);
		if (eObject != null && hasProfile((Element) eObject)) {
			return sourceTypesFactory.doSwitch(eObject, relationshipType);
		}

		return Collections.EMPTY_LIST;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.
	 * IModelingAssistantProvider
	 * #selectExistingElementForSource(org.eclipse.core.runtime.IAdaptable,
	 * org.eclipse.gmf.runtime.emf.type.core.IElementType)
	 */
	@Override
	public EObject selectExistingElementForSource(IAdaptable target,
			IElementType relationshipType) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.
	 * IModelingAssistantProvider
	 * #selectExistingElementForTarget(org.eclipse.core.runtime.IAdaptable,
	 * org.eclipse.gmf.runtime.emf.type.core.IElementType)
	 */
	@Override
	public EObject selectExistingElementForTarget(IAdaptable source,
			IElementType relationshipType) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.common.core.service.IProvider#
	 * addProviderChangeListener
	 * (org.eclipse.gmf.runtime.common.core.service.IProviderChangeListener)
	 */
	@Override
	public void addProviderChangeListener(IProviderChangeListener listener) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gmf.runtime.common.core.service.IProvider#provides(org.eclipse
	 * .gmf.runtime.common.core.service.IOperation)
	 */
	@Override
	public boolean provides(IOperation operation) {
		if (operation instanceof GetTypesForPopupBarOperation
				|| operation instanceof GetRelTypesOnSourceAndTargetOperation
				|| operation instanceof GetTypesForPopupBarOperation
				|| operation instanceof GetRelTypesOnSourceOperation
				|| operation instanceof GetTypesForTargetOperation
				|| operation instanceof GetRelTypesOnTargetOperation
				|| operation instanceof GetTypesForSourceOperation) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.common.core.service.IProvider#
	 * removeProviderChangeListener
	 * (org.eclipse.gmf.runtime.common.core.service.IProviderChangeListener)
	 */
	@Override
	public void removeProviderChangeListener(IProviderChangeListener listener) {
		// TODO Auto-generated method stub

	}

	protected static class PopupBarSwitch extends
			CORBADomainSwitch<List<IElementType>> {

		public PopupBarSwitch() {
			super();
		}

		@Override
		public List<IElementType> caseCORBAInterface(EObject ccmComponent) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(ZDLElementTypeUtil.getElementType(ccmComponent,
					CORBADomainNames.CORBAOPERATION));
			return types;
		}

		@Override
		protected List<IElementType> caseCORBAEnum(EObject object) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.ENUMERATION_LITERAL);
			return types;
		}

		@Override
		protected List<IElementType> caseCORBAStruct(EObject object) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(ZDLElementTypeUtil.getElementType(object,
					CORBADomainNames.CORBAFIELD));
			return types;
		}

		@Override
		protected List<IElementType> caseCORBAUnion(EObject object) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(ZDLElementTypeUtil.getElementType(object,
					CORBADomainNames.CORBACASE));
			types.add(ZDLElementTypeUtil.getElementType(object,
					CORBADomainNames.CORBADEFAULT));

			return types;
		}

		@Override
		protected List<IElementType> caseCORBAConstants(EObject object) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(ZDLElementTypeUtil.getElementType(object,
					CORBADomainNames.CORBACONSTANT));
			return types;
		}

		@Override
		protected List<IElementType> caseCORBAException(EObject object) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(ZDLElementTypeUtil.getElementType(object,
					CORBADomainNames.CORBAFIELD));
			return types;
		}

		@Override
		public List<IElementType> defaultCase(EObject object) {
			return Collections.emptyList();
		}
	}

	protected static class RelTypesOnSourceFactory extends
			CORBADomainSwitch<List<IElementType>> {

		public RelTypesOnSourceFactory() {
			super();
		}

		@Override
		protected List<IElementType> caseCORBAInterface(EObject object) {
			ArrayList<IElementType> types = new ArrayList<IElementType>();

			types.add(UMLElementTypes.GENERALIZATION);

			return types;
		}

		@Override
		public List<IElementType> defaultCase(EObject object) {
			return Collections.emptyList();
		}
	}

	protected static class RelTypesOnTargetFactory extends
			CORBADomainSwitch<List<IElementType>> {

		public RelTypesOnTargetFactory() {
			super();
		}

		@Override
		protected List<IElementType> caseCORBAType(EObject object) {
			ArrayList<IElementType> types = new ArrayList<IElementType>();

			types.add(UMLElementTypes.GENERALIZATION);
			return types;
		}

		@Override
		public List<IElementType> defaultCase(EObject object) {
			return Collections.emptyList();
		}
	}

	protected static class TypesForSourceFactory {
		public TypesForSourceFactory() {
			super();
		}

		protected IElementType relationshipType;

		private CORBADomainSwitch<List<IElementType>> factory = new CORBADomainSwitch<List<IElementType>>() {

			@Override
			protected List<IElementType> caseCORBAInterface(EObject object) {
				List<IElementType> types = new ArrayList<IElementType>();

				if (relationshipType.equals(UMLElementTypes.GENERALIZATION)) {
					types.add(ZDLElementTypeUtil.getElementType(object,
							CORBADomainNames.CORBAINTERFACE));
				}

				return types;
			}

			@Override
			public List<IElementType> defaultCase(EObject object) {
				return Collections.emptyList();
			}
		};

		public List<IElementType> doSwitch(EObject theEObject,
				IElementType relationshipType) {
			this.relationshipType = relationshipType;
			return factory.doSwitch(theEObject);
		}
	}

	protected static class TypesForTargetFactory {
		public TypesForTargetFactory() {
			super();
		}

		protected IElementType relationshipType;

		private CORBADomainSwitch<List<IElementType>> factory = new CORBADomainSwitch<List<IElementType>>() {
			@Override
			protected List<IElementType> caseCORBAType(EObject object) {
				List<IElementType> types = new ArrayList<IElementType>();

				if (relationshipType.equals(UMLElementTypes.GENERALIZATION)) {
					types.add(ZDLElementTypeUtil.getElementType(object,
							CORBADomainNames.CORBATYPE_DEF));
				}
				return types;
			}

			@Override
			public List<IElementType> defaultCase(EObject object) {
				return Collections.emptyList();
			}
		};

		public List<IElementType> doSwitch(EObject theEObject,
				IElementType relationshipType) {
			this.relationshipType = relationshipType;
			return factory.doSwitch(theEObject);
		}
	}

	/**
	 * Return proper connector on source and target operation
	 * 
	 * @author ysroh
	 * 
	 */
	protected static class RelTypesOnSourceAndTargetOperation {

		public RelTypesOnSourceAndTargetOperation() {
			super();
		}

		protected EObject target;

		private CORBADomainSwitch<List<IElementType>> factory = new CORBADomainSwitch<List<IElementType>>() {

			@Override
			protected List<IElementType> caseCORBAInterface(EObject object) {
				List<IElementType> types = new ArrayList<IElementType>();
				if (ZDLUtil.isZDLConcept(target,
						CORBADomainNames.CORBAINTERFACE)) {
					types.add(UMLElementTypes.GENERALIZATION);
				}
				return types;
			}
			
			@Override
			protected List<IElementType> caseIDLFile(EObject object) {
				List<IElementType> types = new ArrayList<IElementType>();
				if (ZDLUtil.isZDLConcept(target, CORBADomainNames.IDLFILE)) {
					types.add(ZDLElementTypeUtil.getElementType(object,
							CORBADomainNames.IDLIMPORT));
				}
				return types;
			}
			
			@Override
			public List<IElementType> defaultCase(EObject object) {
				return Collections.emptyList();
			}
		};

		public List<IElementType> doSwitch(EObject source, EObject target) {
			this.target = target;
			return factory.doSwitch(source);
		}
	}
}
