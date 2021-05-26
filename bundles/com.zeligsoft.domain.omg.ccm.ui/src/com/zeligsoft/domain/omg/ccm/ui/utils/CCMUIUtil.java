package com.zeligsoft.domain.omg.ccm.ui.utils;

import java.util.function.Predicate;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.CompositeStructureDiagramEditPart;
import org.eclipse.uml2.uml.Component;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;

/**
 * CCM UI Utils
 * 
 * @author Young-Soo Roh
 *
 */
public class CCMUIUtil {

	/**
	 * Queries if the given diagram is an assembly diagram
	 * 
	 * @param diagram
	 * @return
	 */
	public static boolean isAssemblyDiagram(Diagram diagram) {
		if (diagram == null) {
			return false;
		}
		if (CompositeStructureDiagramEditPart.MODEL_ID.equals(diagram.getType())) {
			EObject modelElement = diagram.getElement();
			if (ZDLUtil.isZDLConcept(modelElement, CCMNames.ASSEMBLY_IMPLEMENTATION)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Get assembly diagram
	 * 
	 * @param component
	 * @return
	 */
	public static Diagram getAssemblyStructureDiagram(Component component) {
		return getDiagram(component, CCMUIUtil::isAssemblyDiagram);
	}

	/**
	 * Get diagram for the given context
	 * 
	 * @param context
	 * @param filter
	 * @return
	 */
	public static Diagram getDiagram(EObject context, Predicate<? super Diagram> filter) {
		if (filter == null) {
			filter = __ -> true;
		}

		return EMFHelper.getUsages(context).stream().filter(s -> s.getEObject() instanceof Diagram)
				.filter(s -> s.getEStructuralFeature() == NotationPackage.Literals.VIEW__ELEMENT)
				.map(s -> s.getEObject()).filter(o -> o.eResource() != null).map(Diagram.class::cast).filter(filter)
				.findAny().orElse(null);
	}
}
