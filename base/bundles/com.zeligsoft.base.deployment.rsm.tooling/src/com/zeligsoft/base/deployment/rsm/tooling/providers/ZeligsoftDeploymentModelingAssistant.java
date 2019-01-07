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
package com.zeligsoft.base.deployment.rsm.tooling.providers;

import com.ibm.xtools.uml.ui.internal.dialogs.SelectElementDialog;

import com.zeligsoft.base.deployment.rsm.tooling.types.ZeligsoftDeploymentElementTypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IMetamodelType;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;

import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;

import org.eclipse.jface.viewers.IFilter;

import org.eclipse.jface.window.Window;

/**
 * @generated
 */
public class ZeligsoftDeploymentModelingAssistant extends ModelingAssistantProvider {

    /**
     * @generated
     */
    public List getRelTypesOnSource(IAdaptable source) {
        EObject eObject = (EObject)source.getAdapter(EObject.class);
        if (eObject != null) {
            List result = new ArrayList();
            for (int i = 0; i < ZeligsoftDeploymentElementTypes.RELATIONSHIP_TYPES.length; ++i) {
                IElementType elementType = ZeligsoftDeploymentElementTypes.RELATIONSHIP_TYPES[i];
                if (ZeligsoftDeploymentElementTypes.matchesSource(elementType, eObject)) {
                    result.add(elementType);
                }
            }
            return result;
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public List getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
        EObject sourceEObject = (EObject)source.getAdapter(EObject.class);
        EObject targetEObject = (EObject)target.getAdapter(EObject.class);
        if (sourceEObject != null && targetEObject != null) {
            List result = new ArrayList();
            for (int i = 0; i < ZeligsoftDeploymentElementTypes.RELATIONSHIP_TYPES.length; ++i) {
                IElementType elementType = ZeligsoftDeploymentElementTypes.RELATIONSHIP_TYPES[i];
                if (ZeligsoftDeploymentElementTypes.matchesSource(elementType, sourceEObject) &&
                        ZeligsoftDeploymentElementTypes.matchesTarget(elementType, targetEObject)) {
                    result.add(elementType);
                }
            }
            return result;
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public List getRelTypesOnTarget(IAdaptable target) {
        EObject eObject = (EObject)target.getAdapter(EObject.class);
        if (eObject != null) {
            List result = new ArrayList();
            for (int i = 0; i < ZeligsoftDeploymentElementTypes.RELATIONSHIP_TYPES.length; ++i) {
                IElementType elementType = ZeligsoftDeploymentElementTypes.RELATIONSHIP_TYPES[i];
                if (ZeligsoftDeploymentElementTypes.matchesTarget(elementType, eObject)) {
                    result.add(elementType);
                }
            }
            return result;
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public List getTypesForSource(IAdaptable target, IElementType relationshipType) {
        EObject eObject = (EObject)target.getAdapter(EObject.class);
        if (eObject != null) {
            return removeAbstractTypes(ZeligsoftDeploymentElementTypes.getSources(relationshipType), eObject);
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public List getTypesForTarget(IAdaptable source, IElementType relationshipType) {
        EObject eObject = (EObject)source.getAdapter(EObject.class);
        if (eObject != null) {
            return removeAbstractTypes(ZeligsoftDeploymentElementTypes.getTargets(relationshipType), eObject);
        }
        return Collections.EMPTY_LIST;
    }
    
    /**
     * @generated
     */
    private List removeAbstractTypes(IElementType[] elementTypes, EObject eObject) {
        if (elementTypes == null || elementTypes.length == 0) {
            return Collections.EMPTY_LIST;
        }
        List result = new ArrayList();
        for (int i = 0; i < elementTypes.length; ++i) {
            if (elementTypes[i].getEClass() == null || !elementTypes[i].getEClass().isAbstract()) {
                result.add(elementTypes[i]);
            }
        }
        return result;
    }

    /**
     * @generated
     */
    public EObject selectExistingElementForSource(IAdaptable target,
            IElementType relationshipType) {
        EObject eObject = (EObject)target.getAdapter(EObject.class);
        if (eObject != null) {
            List sourceTypes = Arrays.asList(ZeligsoftDeploymentElementTypes.getSources(relationshipType));
            if (!sourceTypes.isEmpty()) {
                return openSelectElementDialog(target, sourceTypes);
            }
        }
        return null;
    }

    /**
     * @generated
     */
    public EObject selectExistingElementForTarget(IAdaptable source,
            IElementType relationshipType) {
        EObject eObject = (EObject)source.getAdapter(EObject.class);
        if (eObject != null) {
            List targetTypes = Arrays.asList(ZeligsoftDeploymentElementTypes.getTargets(relationshipType));
            if (!targetTypes.isEmpty()) {
                return openSelectElementDialog(source, targetTypes);
            }
        }
        return null;
    }

    /**
     * @generated
     */
    private EObject openSelectElementDialog(IAdaptable context, final List elementTypes) {
        Object eObject = context.getAdapter(EObject.class);
        
        final IFilter filter = new IFilter() {

            public boolean select(Object toTest) {
                if (toTest instanceof EObject) {
                    EObject eObject = (EObject)toTest;
                    for (Iterator it = elementTypes.iterator(); it.hasNext(); ) {
                        IElementType elementType = (IElementType)it.next();
                        if (elementType instanceof IMetamodelType) {
                            if (elementType.getEClass().isSuperTypeOf(eObject.eClass())) {
                                return true;
                            }
                        } else if (elementType instanceof ISpecializationType) {
                            if (((ISpecializationType)elementType).getMatcher() == null) {
                                if (elementType.getEClass().isSuperTypeOf(eObject.eClass())) {
                                    return true;
                                }
                            } else if (((ISpecializationType)elementType).getMatcher().matches(eObject)) {
                                return true;
                            }
                        } 
                    }
                }
                return false;
            }
            
        };
        
        SelectElementDialog dialog = new SelectElementDialog((EObject) eObject, filter) {
            protected boolean isValidSelection(List currentSelectedElements) {
                return filter.select(currentSelectedElements.get(0));
            }
        };

        if (dialog.open() != Window.OK) {
            // user canceled gesture
            return null;
        }
        
        return (EObject) dialog.getSelectedElements().get(0);
    }
}