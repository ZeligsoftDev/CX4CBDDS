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
package com.zeligsoft.domain.ngc.ccm.ui;

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
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.GetTypesForPopupBarOperation;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.GetTypesForTargetOperation;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.IModelingAssistantProvider;
import org.eclipse.uml2.uml.Element;

import com.ibm.xtools.uml.type.UMLElementTypes;
import com.zeligsoft.base.zdl.type.ZDLElementTypeUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.CORBADomainNames;
import com.zeligsoft.domain.omg.ccm.util.CCMDomainSwitch;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * @author Toby McClean (tmcclean)
 *
 */
public class CCMModelingAssistantProvider implements IModelingAssistantProvider {
	
	private PopupBarSwitch popupbarFactory = 
		new PopupBarSwitch();
	private RelTypesOnSourceFactory sourceRelTypesFactory =
		new RelTypesOnSourceFactory();
	private TypesForSourceFactory sourceTypesFactory =
		new TypesForSourceFactory();
	
	/**
	 * 
	 */
	public CCMModelingAssistantProvider() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.IModelingAssistantProvider#getRelTypesForSREOnSource(org.eclipse.core.runtime.IAdaptable)
	 */
	public List getRelTypesForSREOnSource(IAdaptable source) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.IModelingAssistantProvider#getRelTypesForSREOnTarget(org.eclipse.core.runtime.IAdaptable)
	 */
	public List getRelTypesForSREOnTarget(IAdaptable target) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.IModelingAssistantProvider#getRelTypesOnSource(org.eclipse.core.runtime.IAdaptable)
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		EObject eObject = (EObject)source.getAdapter(EObject.class);
        if (eObject != null && ZDLUtil.isZDLProfile((Element) eObject, "CCM")) {
            return sourceRelTypesFactory.doSwitch(eObject);
        }
        
        return Collections.EMPTY_LIST;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.IModelingAssistantProvider#getRelTypesOnSourceAndTarget(org.eclipse.core.runtime.IAdaptable, org.eclipse.core.runtime.IAdaptable)
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source,
			IAdaptable target) {
		EObject sourceEObj = (EObject)source.getAdapter(EObject.class);
		EObject targetEObj = (EObject)target.getAdapter(EObject.class);
		List<IElementType> types = new ArrayList<IElementType>();
		if (sourceEObj != null && 
				ZDLUtil.isZDLProfile((Element) sourceEObj, "CCM") &&
				targetEObj != null &&
				ZDLUtil.isZDLProfile((Element) targetEObj, "CCM")) {
            if(ZDLUtil.isZDLConcept(sourceEObj, ZMLMMNames.MESSAGE_PORT) &&
            		ZDLUtil.isZDLConcept(targetEObj, ZMLMMNames.MESSAGE_PORT)) {
        		types.add(
        				ZDLElementTypeUtil.getElementType(sourceEObj, CCMNames.CCMCONNECTOR));
            } else if(ZDLUtil.isZDLConcept(sourceEObj, CCMNames.EVENT_PORT) &&
            		ZDLUtil.isZDLConcept(targetEObj, CCMNames.EVENT_PORT)) {
        		types.add(
        				ZDLElementTypeUtil.getElementType(sourceEObj, CCMNames.CCMCONNECTOR));
            } 
        }
		return types;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.IModelingAssistantProvider#getRelTypesOnTarget(org.eclipse.core.runtime.IAdaptable)
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.IModelingAssistantProvider#getTypes(java.lang.String, org.eclipse.core.runtime.IAdaptable)
	 */
	public List getTypes(String hint, IAdaptable data) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.IModelingAssistantProvider#getTypesForPopupBar(org.eclipse.core.runtime.IAdaptable)
	 */
	public List getTypesForPopupBar(IAdaptable host) {
        EObject eObject = (EObject)host.getAdapter(EObject.class);
        if (eObject != null && ZDLUtil.isZDLProfile((Element) eObject, "CCM")) {
            return popupbarFactory.doSwitch(eObject);
        }
        
        return Collections.EMPTY_LIST;

	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.IModelingAssistantProvider#getTypesForSource(org.eclipse.core.runtime.IAdaptable, org.eclipse.gmf.runtime.emf.type.core.IElementType)
	 */
	public List getTypesForSource(IAdaptable target,
			IElementType relationshipType) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.IModelingAssistantProvider#getTypesForTarget(org.eclipse.core.runtime.IAdaptable, org.eclipse.gmf.runtime.emf.type.core.IElementType)
	 */
	public List getTypesForTarget(IAdaptable source,
			IElementType relationshipType) {
		EObject eObject = (EObject)source.getAdapter(EObject.class);
        if (eObject != null && ZDLUtil.isZDLProfile((Element) eObject, "CCM")) {
            return sourceTypesFactory.doSwitch(eObject, relationshipType);
        }
        
        return Collections.EMPTY_LIST;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.IModelingAssistantProvider#selectExistingElementForSource(org.eclipse.core.runtime.IAdaptable, org.eclipse.gmf.runtime.emf.type.core.IElementType)
	 */
	public EObject selectExistingElementForSource(IAdaptable target,
			IElementType relationshipType) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.IModelingAssistantProvider#selectExistingElementForTarget(org.eclipse.core.runtime.IAdaptable, org.eclipse.gmf.runtime.emf.type.core.IElementType)
	 */
	public EObject selectExistingElementForTarget(IAdaptable source,
			IElementType relationshipType) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.common.core.service.IProvider#addProviderChangeListener(org.eclipse.gmf.runtime.common.core.service.IProviderChangeListener)
	 */
	public void addProviderChangeListener(IProviderChangeListener listener) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.common.core.service.IProvider#provides(org.eclipse.gmf.runtime.common.core.service.IOperation)
	 */
	public boolean provides(IOperation operation) {
		if(operation instanceof GetTypesForPopupBarOperation ||
				operation instanceof GetRelTypesOnSourceAndTargetOperation || 
				operation instanceof GetTypesForPopupBarOperation ||
				operation instanceof GetRelTypesOnSourceOperation ||
				operation instanceof GetTypesForTargetOperation) {
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.common.core.service.IProvider#removeProviderChangeListener(org.eclipse.gmf.runtime.common.core.service.IProviderChangeListener)
	 */
	public void removeProviderChangeListener(IProviderChangeListener listener) {
		// TODO Auto-generated method stub

	}
	
	protected static class PopupBarSwitch extends CCMDomainSwitch<List<IElementType>> {
		
		public PopupBarSwitch() {
			super();
		}
		
		/* (non-Javadoc)
		 * @see com.zeligsoft.domain.omg.ccm.util.CCMDomainSwitch#caseCCMComponent(org.eclipse.emf.ecore.EObject)
		 */
		@Override
		public List<IElementType> caseCCMComponent(EObject ccmComponent) {
			List<IElementType> types = new ArrayList<IElementType>();
    		types.add(
    				ZDLElementTypeUtil.getElementType(ccmComponent, ZMLMMNames.MESSAGE_PORT));
    		types.add(
    				ZDLElementTypeUtil.getElementType(ccmComponent, CCMNames.EVENT_PORT));
    		types.add(ZDLElementTypeUtil.getElementType(ccmComponent, CORBADomainNames.CORBAATTRIBUTE));
    		return types;
		}
		
		/* (non-Javadoc)
		 * @see com.zeligsoft.domain.omg.ccm.util.CCMDomainSwitch#caseEvent(org.eclipse.emf.ecore.EObject)
		 */
		@Override
		protected List<IElementType> caseEvent(EObject event) {
			List<IElementType> types = new ArrayList<IElementType>();
    		types.add(
    				ZDLElementTypeUtil.getElementType(event, CORBADomainNames.CORBAATTRIBUTE));
    		return types;
		}
		
		/* (non-Javadoc)
		 * @see com.zeligsoft.domain.omg.ccm.util.CCMDomainSwitch#caseCORBAEnum(org.eclipse.emf.ecore.EObject)
		 */
		@Override
		protected List<IElementType> caseCORBAEnum(EObject object) {
			List<IElementType> types = new ArrayList<IElementType>();
    		types.add(UMLElementTypes.ENUMERATION_LITERAL);
    		return types;
		}
		
		/* (non-Javadoc)
		 * @see com.zeligsoft.domain.omg.ccm.util.CCMDomainSwitch#caseCORBAStruct(org.eclipse.emf.ecore.EObject)
		 */
		@Override
		protected List<IElementType> caseCORBAStruct(EObject object) {
			List<IElementType> types = new ArrayList<IElementType>();
    		types.add(
    				ZDLElementTypeUtil.getElementType(object, CORBADomainNames.CORBAFIELD));
    		return types;
		}
		
		/* (non-Javadoc)
		 * @see com.zeligsoft.domain.omg.ccm.util.CCMDomainSwitch#caseCORBAUnion(org.eclipse.emf.ecore.EObject)
		 */
		@Override
		protected List<IElementType> caseCORBAUnion(EObject object) {
			List<IElementType> types = new ArrayList<IElementType>();
    		types.add(
    				ZDLElementTypeUtil.getElementType(object, CORBADomainNames.CORBACASE));
    		types.add(
    				ZDLElementTypeUtil.getElementType(object, CORBADomainNames.CORBADEFAULT));
    		
    		return types;
		}
		
		/* (non-Javadoc)
		 * @see com.zeligsoft.domain.omg.ccm.util.CCMDomainSwitch#caseCORBAConstants(org.eclipse.emf.ecore.EObject)
		 */
		@Override
		protected List<IElementType> caseCORBAConstants(EObject object) {
			List<IElementType> types = new ArrayList<IElementType>();
    		types.add(
    				ZDLElementTypeUtil.getElementType(object, CORBADomainNames.CORBACONSTANT));
    		return types;
		}
		
		/* (non-Javadoc)
		 * @see com.zeligsoft.domain.omg.ccm.util.CCMDomainSwitch#caseCORBAException(org.eclipse.emf.ecore.EObject)
		 */
		@Override
		protected List<IElementType> caseCORBAException(EObject object) {
			List<IElementType> types = new ArrayList<IElementType>();
    		types.add(
    				ZDLElementTypeUtil.getElementType(object, CORBADomainNames.CORBAFIELD));
    		return types;
		}
		
		/* (non-Javadoc)
		 * @see com.zeligsoft.domain.omg.ccm.util.CCMDomainSwitch#defaultCase(org.eclipse.emf.ecore.EObject)
		 */
		@Override
		public List<IElementType> defaultCase(EObject object) {
			return Collections.emptyList();
		}
	}


	protected static class RelTypesOnSourceFactory extends CCMDomainSwitch<List<IElementType>> {
		
		public RelTypesOnSourceFactory() {
			super();
		}
		
		/* (non-Javadoc)
		 * @see com.zeligsoft.domain.omg.ccm.util.CCMDomainSwitch#caseCCMComponent(org.eclipse.emf.ecore.EObject)
		 */
		@Override
		protected List<IElementType> caseCCMComponent(EObject ccmComponent) {
			ArrayList<IElementType> types = new ArrayList<IElementType>();
			
			types.add(UMLElementTypes.GENERALIZATION);
			types.add(UMLElementTypes.INTERFACE_REALIZATION);
			
			return types;
		}
		
		/* (non-Javadoc)
		 * @see com.zeligsoft.domain.omg.ccm.util.CCMDomainSwitch#caseCORBAInterface(org.eclipse.emf.ecore.EObject)
		 */
		@Override
		protected List<IElementType> caseCORBAInterface(EObject object) {
			ArrayList<IElementType> types = new ArrayList<IElementType>();
			
			types.add(UMLElementTypes.GENERALIZATION);
			
			return types;	
		}
	}
	
	protected static class TypesForSourceFactory {
		public TypesForSourceFactory() {
			super();
		}
		
		protected IElementType relationshipType;
		
		private CCMDomainSwitch<List<IElementType>> factory 
			= new CCMDomainSwitch<List<IElementType>>() {
				@Override
				protected List<IElementType> caseCCMComponent(EObject ccmComponent) {
					List<IElementType> types = new ArrayList<IElementType>();
					
					if(relationshipType.equals(UMLElementTypes.GENERALIZATION)) {
						types.add(
			    				ZDLElementTypeUtil.getElementType(ccmComponent, CCMNames.CCMCOMPONENT));
					} else if(relationshipType.equals(UMLElementTypes.INTERFACE_REALIZATION)) {
						types.add(
			    				ZDLElementTypeUtil.getElementType(ccmComponent, CORBADomainNames.CORBAINTERFACE));
					} 
					
					return types;
				};
				
				/* (non-Javadoc)
				 * @see com.zeligsoft.domain.omg.ccm.util.CCMDomainSwitch#caseCORBAInterface(org.eclipse.emf.ecore.EObject)
				 */
				@Override
				protected List<IElementType> caseCORBAInterface(EObject object) {
					List<IElementType> types = new ArrayList<IElementType>();
					
					if(relationshipType.equals(UMLElementTypes.GENERALIZATION)) {
						types.add(
			    				ZDLElementTypeUtil.getElementType(object, CORBADomainNames.CORBAINTERFACE));
					}
					
					return types;
				}
			};
		
		public List<IElementType> doSwitch(EObject theEObject, IElementType relationshipType) {
			this.relationshipType = relationshipType;
			return factory.doSwitch(theEObject);
		}
		
		
	}
}
