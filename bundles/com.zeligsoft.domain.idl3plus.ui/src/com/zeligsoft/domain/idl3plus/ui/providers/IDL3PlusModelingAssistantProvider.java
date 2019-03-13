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
package com.zeligsoft.domain.idl3plus.ui.providers;

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
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.idl3plus.utils.IDL3PlusSwitch;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;

/**
 * @author Toby McClean (tmcclean)
 *
 */
@SuppressWarnings("rawtypes")
public class IDL3PlusModelingAssistantProvider implements IModelingAssistantProvider {
	
	private PopupBarSwitch popupbarFactory = 
		new PopupBarSwitch();
	private RelTypesOnSourceFactory sourceRelTypesFactory =
		new RelTypesOnSourceFactory();
	private TypesForSourceFactory sourceTypesFactory =
		new TypesForSourceFactory();
	private RelTypesOnTargetFactory targetRelTypesFactory = 
		new RelTypesOnTargetFactory();
	private TypesForTargetFactory targetTypesFactory =
		new TypesForTargetFactory();
	private RelTypesOnSourceAndTargetOperation connectionTypesFactory = 
		new RelTypesOnSourceAndTargetOperation();
	
	/**
	 * 
	 */
	public IDL3PlusModelingAssistantProvider() {
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

	private boolean hasProfile(Element element) {
		return ZDLUtil.isZDLDomain(element, "IDL3Plus"); //$NON-NLS-1$
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.IModelingAssistantProvider#getRelTypesOnSource(org.eclipse.core.runtime.IAdaptable)
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		EObject eObject = (EObject)source.getAdapter(EObject.class);
        if (eObject != null && hasProfile((Element) eObject)) {
            return sourceRelTypesFactory.doSwitch(eObject);
        }
        
        return Collections.EMPTY_LIST;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.IModelingAssistantProvider#getRelTypesOnSourceAndTarget(org.eclipse.core.runtime.IAdaptable, org.eclipse.core.runtime.IAdaptable)
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		EObject sourceEObj = (EObject)source.getAdapter(EObject.class);
		EObject targetEObj = (EObject)target.getAdapter(EObject.class);
		if (sourceEObj == null || targetEObj == null || !hasProfile((Element) sourceEObj)
				|| !hasProfile((Element) targetEObj)) {
			return Collections.EMPTY_LIST;
            } 

		return connectionTypesFactory.doSwitch(sourceEObj, targetEObj);
        }

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.IModelingAssistantProvider#getRelTypesOnTarget(org.eclipse.core.runtime.IAdaptable)
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		EObject eObject = (EObject)target.getAdapter(EObject.class);
        if (eObject != null && hasProfile((Element) eObject)) {
            return targetRelTypesFactory.doSwitch(eObject);
        }
        
        return Collections.EMPTY_LIST;
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
        if (eObject != null && hasProfile((Element) eObject)) {
            return popupbarFactory.doSwitch(eObject);
        }
        
        return Collections.EMPTY_LIST;

	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.IModelingAssistantProvider#getTypesForSource(org.eclipse.core.runtime.IAdaptable, org.eclipse.gmf.runtime.emf.type.core.IElementType)
	 */
	public List getTypesForSource(IAdaptable target,
			IElementType relationshipType) {
		EObject eObject = (EObject)target.getAdapter(EObject.class);
        if (eObject != null && hasProfile((Element) eObject)) {
            return targetTypesFactory.doSwitch(eObject, relationshipType);
        }
        
        return Collections.EMPTY_LIST;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.IModelingAssistantProvider#getTypesForTarget(org.eclipse.core.runtime.IAdaptable, org.eclipse.gmf.runtime.emf.type.core.IElementType)
	 */
	public List getTypesForTarget(IAdaptable source,
			IElementType relationshipType) {
		EObject eObject = (EObject)source.getAdapter(EObject.class);
        if (eObject != null && hasProfile((Element) eObject)) {
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
				operation instanceof GetTypesForTargetOperation ||
				operation instanceof GetRelTypesOnTargetOperation || 
				operation instanceof GetTypesForSourceOperation) {
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
	
	protected static class PopupBarSwitch extends IDL3PlusSwitch<List<IElementType>> {
		
		public PopupBarSwitch() {
			super();
		}
	
		@Override
		protected List<IElementType> caseConnectorDef(EObject modelElement) {
			List<IElementType> types = new ArrayList<IElementType>();
    		types.add(
    				ZDLElementTypeUtil.getElementType(modelElement, CCMNames.INTERFACE_PORT));
//			event port commented out bug#16316			
//    		types.add(
//    				ZDLElementTypeUtil.getElementType(modelElement, CCMNames.EVENT_PORT));
    		types.add(
    				ZDLElementTypeUtil.getElementType(modelElement, CORBADomainNames.CORBAATTRIBUTE));

    		return types;
		}
		
		@Override
		protected List<IElementType> caseConnectorFragment(EObject modelElement) {
			List<IElementType> types = new ArrayList<IElementType>();
    		types.add(
    				ZDLElementTypeUtil.getElementType(modelElement, CCMNames.INTERFACE_PORT));
//			event port commented out bug#16316			
//    		types.add(
//    				ZDLElementTypeUtil.getElementType(modelElement, CCMNames.EVENT_PORT));

    		return types;
		}
		
		
		@Override
		public List<IElementType> defaultCase(EObject object) {
			return Collections.emptyList();
		}
	}


	protected static class RelTypesOnSourceFactory extends IDL3PlusSwitch<List<IElementType>> {
		
		public RelTypesOnSourceFactory() {
			super();
		}
		
		@Override
		protected List<IElementType> caseConnectorDef(EObject modelElement) {
			ArrayList<IElementType> types = new ArrayList<IElementType>();

			types.add(UMLElementTypes.GENERALIZATION);
			return types;	
		}
		@Override
		protected List<IElementType> caseConnectorFragment(EObject modelElement) {
			ArrayList<IElementType> types = new ArrayList<IElementType>();

			types.add(UMLElementTypes.GENERALIZATION);
			return types;	
		}
		@Override
		protected List<IElementType> caseConnectorAssembly(EObject modelElement) {
			ArrayList<IElementType> types = new ArrayList<IElementType>();

			types.add(UMLElementTypes.GENERALIZATION);
			return types;	
		}
		@Override
		protected List<IElementType> caseConnectorImplementation(EObject modelElement) {
			ArrayList<IElementType> types = new ArrayList<IElementType>();

			types.add(UMLElementTypes.GENERALIZATION);
			return types;
		}
		@Override
		protected List<IElementType> caseFragmentAssembly(EObject modelElement) {
			ArrayList<IElementType> types = new ArrayList<IElementType>();

			types.add(UMLElementTypes.GENERALIZATION);
			return types;
		}
		@Override
		protected List<IElementType> caseFragmentImplementation(EObject modelElement) {
			ArrayList<IElementType> types = new ArrayList<IElementType>();

			types.add(UMLElementTypes.GENERALIZATION);
			return types;
		}

		@Override
		public List<IElementType> defaultCase(EObject object) {
			return Collections.emptyList();
		}
	}
	
	protected static class RelTypesOnTargetFactory extends IDL3PlusSwitch<List<IElementType>> {
		
		public RelTypesOnTargetFactory() {
			super();
		}
		
		@Override
		protected List<IElementType> caseConnectorDef(EObject modelElement) {
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
		
		private IDL3PlusSwitch<List<IElementType>> factory 
			= new IDL3PlusSwitch<List<IElementType>>() {

			@Override
				protected List<IElementType> caseConnectorDef(EObject modelElement) {
					List<IElementType> types = new ArrayList<IElementType>();

					if(relationshipType.equals(UMLElementTypes.GENERALIZATION)) {
						types.add(
								ZDLElementTypeUtil.getElementType(modelElement, IDL3PlusNames.CONNECTOR_DEF));
					}
					
					return types;
				}
				@Override
				protected List<IElementType> caseConnectorFragment(EObject modelElement) {
					List<IElementType> types = new ArrayList<IElementType>();

					if(relationshipType.equals(UMLElementTypes.GENERALIZATION)) {
						types.add(
								ZDLElementTypeUtil.getElementType(modelElement, IDL3PlusNames.CONNECTOR_FRAGMENT));
					}
					
					return types;
				}
				@Override
				protected List<IElementType> caseConnectorAssembly(EObject modelElement) {
					List<IElementType> types = new ArrayList<IElementType>();

					if(relationshipType.equals(UMLElementTypes.GENERALIZATION)) {
						types.add(
								ZDLElementTypeUtil.getElementType(modelElement, IDL3PlusNames.CONNECTOR_DEF));
					}
					
					return types;
				}
				@Override
				protected List<IElementType> caseConnectorImplementation(
						EObject modelElement) {
					List<IElementType> types = new ArrayList<IElementType>();

					if(relationshipType.equals(UMLElementTypes.GENERALIZATION)) {
						types.add(
								ZDLElementTypeUtil.getElementType(modelElement, IDL3PlusNames.CONNECTOR_DEF));
					}
					
					return types;
				}
				@Override
				protected List<IElementType> caseFragmentAssembly(EObject modelElement) {
					List<IElementType> types = new ArrayList<IElementType>();

					if(relationshipType.equals(UMLElementTypes.GENERALIZATION)) {
						types.add(
								ZDLElementTypeUtil.getElementType(modelElement, IDL3PlusNames.CONNECTOR_FRAGMENT));
					}
					
					return types;
				}
				@Override
				protected List<IElementType> caseFragmentImplementation(
						EObject modelElement) {
					List<IElementType> types = new ArrayList<IElementType>();

					if(relationshipType.equals(UMLElementTypes.GENERALIZATION)) {
						types.add(
								ZDLElementTypeUtil.getElementType(modelElement, IDL3PlusNames.CONNECTOR_FRAGMENT));
					}
					
					return types;
				}
				@Override
				public List<IElementType> defaultCase(EObject object) {
					return Collections.emptyList();
				}
			};
		
		public List<IElementType> doSwitch(EObject theEObject, IElementType relationshipType) {
			this.relationshipType = relationshipType;
			return factory.doSwitch(theEObject);
		}
	}
	
	protected static class TypesForTargetFactory {
		public TypesForTargetFactory() {
			super();
		}
		
		protected IElementType relationshipType;
		
		private IDL3PlusSwitch<List<IElementType>> factory 
			= new IDL3PlusSwitch<List<IElementType>>() {

				@Override
				protected List<IElementType> caseConnectorDef(EObject modelElement) {
					List<IElementType> types = new ArrayList<IElementType>();
					
					if(relationshipType.equals(UMLElementTypes.GENERALIZATION)) {
						types.add(
			    				ZDLElementTypeUtil.getElementType(modelElement, IDL3PlusNames.CONNECTOR_ASSEMBLY));
						types.add(
			    				ZDLElementTypeUtil.getElementType(modelElement, IDL3PlusNames.CONNECTOR_IMPLEMENTATION));
					} 
					return types;
				}
				@Override
				protected List<IElementType> caseConnectorFragment(EObject modelElement) {
					List<IElementType> types = new ArrayList<IElementType>();
					
					if(relationshipType.equals(UMLElementTypes.GENERALIZATION)) {
						types.add(
			    				ZDLElementTypeUtil.getElementType(modelElement, IDL3PlusNames.FRAGMENT_ASSEMBLY));
						types.add(
			    				ZDLElementTypeUtil.getElementType(modelElement, IDL3PlusNames.FRAGMENT_IMPLEMENTATION));
					} 
					return types;
				}

				@Override
				public List<IElementType> defaultCase(EObject object) {
					return Collections.emptyList();
				}
			};
		
		public List<IElementType> doSwitch(EObject theEObject, IElementType relationshipType) {
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
		
		private IDL3PlusSwitch<List<IElementType>> factory = new IDL3PlusSwitch<List<IElementType>>() {

			@Override
			protected List<IElementType> caseConnectorDef(EObject modelElement) {
				List<IElementType> types = new ArrayList<IElementType>();
				if (ZDLUtil.isZDLConcept(target, IDL3PlusNames.CONNECTOR_DEF)) {
					types.add(UMLElementTypes.GENERALIZATION);
				}
				return types;
			}
			@Override
			protected List<IElementType> caseConnectorFragment(EObject modelElement) {
				List<IElementType> types = new ArrayList<IElementType>();
				if (ZDLUtil.isZDLConcept(target, IDL3PlusNames.CONNECTOR_FRAGMENT)) {
					types.add(UMLElementTypes.GENERALIZATION);
				}
				return types;
			}
			@Override
			protected List<IElementType> caseConnectorAssembly(EObject modelElement) {
				List<IElementType> types = new ArrayList<IElementType>();
				if (ZDLUtil.isZDLConcept(target, IDL3PlusNames.CONNECTOR_DEF)) {
					types.add(UMLElementTypes.GENERALIZATION);
				}
				return types;
			}
			@Override
			protected List<IElementType> caseConnectorImplementation(EObject modelElement) {
				List<IElementType> types = new ArrayList<IElementType>();
				if (ZDLUtil.isZDLConcept(target, IDL3PlusNames.CONNECTOR_DEF)) {
					types.add(UMLElementTypes.GENERALIZATION);
				}
				return types;
			}
			@Override
			protected List<IElementType> caseFragmentAssembly(EObject modelElement) {
				List<IElementType> types = new ArrayList<IElementType>();
				if (ZDLUtil.isZDLConcept(target, IDL3PlusNames.CONNECTOR_FRAGMENT)) {
					types.add(UMLElementTypes.GENERALIZATION);
				}
				return types;
			}
			@Override
			protected List<IElementType> caseFragmentImplementation(EObject modelElement) {
				List<IElementType> types = new ArrayList<IElementType>();
				if (ZDLUtil.isZDLConcept(target, IDL3PlusNames.CONNECTOR_FRAGMENT)) {
					types.add(UMLElementTypes.GENERALIZATION);
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
