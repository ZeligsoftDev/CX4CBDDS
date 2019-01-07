
package com.zeligsoft.ce.deployment.rsm.profile.tooling.providers;

import com.ibm.xtools.uml.ui.internal.dialogs.SelectElementDialog;

import com.zeligsoft.ce.deployment.rsm.profile.tooling.types.ZDLDeploymentElementTypes;

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
public class ZDLDeploymentModelingAssistant extends ModelingAssistantProvider {

    /**
     * @generated
     */
    public List getRelTypesOnSource(IAdaptable source) {
        EObject eObject = (EObject)source.getAdapter(EObject.class);
        if (eObject != null) {
            List result = new ArrayList();
            for (int i = 0; i < ZDLDeploymentElementTypes.RELATIONSHIP_TYPES.length; ++i) {
                IElementType elementType = ZDLDeploymentElementTypes.RELATIONSHIP_TYPES[i];
                if (ZDLDeploymentElementTypes.matchesSource(elementType, eObject)) {
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
            for (int i = 0; i < ZDLDeploymentElementTypes.RELATIONSHIP_TYPES.length; ++i) {
                IElementType elementType = ZDLDeploymentElementTypes.RELATIONSHIP_TYPES[i];
                if (ZDLDeploymentElementTypes.matchesSource(elementType, sourceEObject) &&
                        ZDLDeploymentElementTypes.matchesTarget(elementType, targetEObject)) {
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
            for (int i = 0; i < ZDLDeploymentElementTypes.RELATIONSHIP_TYPES.length; ++i) {
                IElementType elementType = ZDLDeploymentElementTypes.RELATIONSHIP_TYPES[i];
                if (ZDLDeploymentElementTypes.matchesTarget(elementType, eObject)) {
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
            return removeAbstractTypes(ZDLDeploymentElementTypes.getSources(relationshipType), eObject);
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public List getTypesForTarget(IAdaptable source, IElementType relationshipType) {
        EObject eObject = (EObject)source.getAdapter(EObject.class);
        if (eObject != null) {
            return removeAbstractTypes(ZDLDeploymentElementTypes.getTargets(relationshipType), eObject);
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
            List sourceTypes = Arrays.asList(ZDLDeploymentElementTypes.getSources(relationshipType));
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
            List targetTypes = Arrays.asList(ZDLDeploymentElementTypes.getTargets(relationshipType));
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