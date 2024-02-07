/*******************************************************************************
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.uml.internal.utilities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreSwitch;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.util.UMLSwitch;

/**
 * Generate a distinct stable xmi:id for a UML model element.
 * <p>
 * Disclaimer. This class is exercised to support conversion of the UML source of the Pivot. It is not sufficiently
 * developed for more general use.
 * <p>
 * The name generation principle is to produce dot-separated names from NamedElements on the composition hierarchy
 * and dot-separate riles with indexes for references and unnamed nodes.
 * <p>
 * Composed names have a distinct capitalized first letter such as P for package to separate conflicting child namespaces.
 * <p>
 * Other names have a lower case first letter and may use the shaortNames mapping to save space. A numeric suffix
 * disambiguates position-wise amongst many children.
 */
public class UMLXMIID extends UMLSwitch<String>
{
	protected static final @NonNull Map<String, String> shortNames = new HashMap<String, String>();
	
	static {
		shortNames.put("defaultValue", "dlV");
		shortNames.put("eAnnotations", "eA");
		shortNames.put("generalization", "g");
		shortNames.put("lowerValue", "lV");
		shortNames.put("ownedComment", "oC");
		shortNames.put("ownedParameter", "oP");
		shortNames.put("ownedParameteredElement", "oPE");
		shortNames.put("ownedTemplateSignature", "oTS");
		shortNames.put("profileApplication", "pA");
		shortNames.put("upperValue", "uV");
	}
	
	protected EcoreSwitch<String> ecoreSwitch = new EcoreSwitch<String>()
	{
		@Override
		public String caseEAnnotation(EAnnotation object) {
			assert object != null;
			StringBuilder s = new StringBuilder();
			appendPositionHierarchy(s, object);
			return s.toString();
		}
		
		@Override
		public String defaultCase(EObject object) {
			System.out.println("Unsupported UMLXMIID for '" + object.eClass().getName() + "'");
			return null;
		}
	};
	
	protected final @NonNull XMLResource resource;
	
	public UMLXMIID(@NonNull XMLResource resource) {
		this.resource = resource;
	}

	protected void appendNameHierarchy(@NonNull StringBuilder s, @NonNull String prefix, @NonNull EObject object, @Nullable String name) {
		EObject container = object.eContainer();
		if (container instanceof NamedElement) {
			String id = doSwitch(container);
			s.append(id);
			s.append(".");
		}
		s.append(prefix);
		s.append(String.valueOf(name));
	}

	protected void appendPositionHierarchy(@NonNull StringBuilder s, @NonNull EObject object) {
		EObject container = object.eContainer();
		assert container != null;
		if (container instanceof NamedElement) {
			String id = doSwitch(container);
			s.append(id);
			s.append(".");
		}
		else {
			appendPositionHierarchy(s, container);
			s.append(".");
		}
		EReference eContainmentFeature = object.eContainmentFeature();
		String name = eContainmentFeature.getName();
		String shortName = shortNames.get(name);
		s.append(shortName != null ? shortName : String.valueOf(name));
		if (eContainmentFeature.isMany()) {
			int index = ((List<?>)container.eGet(eContainmentFeature)).indexOf(object);
			s.append(index);
		}
	}

	public void assign() {
		Map<String, EObject> id2EObject = new HashMap<String, EObject>();
		for (TreeIterator<EObject> tit = resource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			String id = doSwitch(eObject);
			if (id != null) {
				EObject oldEObject = id2EObject.put(id,  eObject);
				if (oldEObject != null) {
					System.out.println("Duplicate xmi:id " + id);
				}
			}
			resource.setID(eObject, id);
		}
	}

	@Override
	public String caseAssociation(Association object) {
		assert object != null;
		String name = object.getName();
		if (name == null) {
			StringBuilder s = new StringBuilder();
			for (Property end : object.getMemberEnds()) {
				s.append("_");
				String endName = end.getName();
				if (endName != null) {
					s.append(endName);
				}
				else {
					s.append(end.getType().getName());
				}
			}
			name = s.toString();
		}
		StringBuilder s = new StringBuilder();
		appendNameHierarchy(s, name.startsWith("A_") ? "" : "A", object, name);
		return s.toString();
	}

	@Override
	public String caseComment(Comment object) {
		assert object != null;
		StringBuilder s = new StringBuilder();
		appendPositionHierarchy(s, object);
		return s.toString();
	}

	@Override
	public String caseEnumerationLiteral(EnumerationLiteral object) {
		assert object != null;
		StringBuilder s = new StringBuilder();
		appendNameHierarchy(s, "L", object, object.getName());
		return s.toString();
	}

	@Override
	public String caseOperation(Operation object) {
		assert object != null;
		StringBuilder s = new StringBuilder();
		if (object.getOwningTemplateParameter() != null) {
			appendPositionHierarchy(s, object);
		}
		else {
			appendNameHierarchy(s, "O", object, object.getName());
			int iThis = 0;
			int iMax = 0;
			Element owner = object.getOwner();
			List<Operation> ownedOperations = null;
			if (owner instanceof Class) {
				ownedOperations = ((Class)owner).getOwnedOperations();
			}
			else if (owner instanceof Interface) {
				ownedOperations = ((Interface)owner).getOwnedOperations();
			}
			if (ownedOperations != null) {
				String name = object.getName();
				int i = 0;
				for (Operation op : ownedOperations) {
					if (op == object) {
						iThis = i;
					}
					if (name.equals(op.getName())) {
						iMax++;
					}
					i++;
				}
			}
			if (iMax > 1) {
				s.append(".");
				s.append(iThis);
			}
		}
		return s.toString();
	}

	@Override
	public String casePackage(Package object) {
		assert object != null;
		StringBuilder s = new StringBuilder();
		appendNameHierarchy(s, "P", object, object.getName());
		return s.toString();
	}

	@Override
	public String caseParameter(Parameter object) {
		assert object != null;
		StringBuilder s = new StringBuilder();
		appendNameHierarchy(s, "P", object, object.getName());
		return s.toString();
	}

	@Override
	public String caseProperty(Property object) {
		assert object != null;
		StringBuilder s = new StringBuilder();
		appendNameHierarchy(s, "P", object, object.getName());
		return s.toString();
	}

	@Override
	public String caseRelationship(Relationship object) {
		assert object != null;
		StringBuilder s = new StringBuilder();
		appendPositionHierarchy(s, object);
		return s.toString();
	}

	@Override
	public String caseTemplateParameter(TemplateParameter object) {
		assert object != null;
		StringBuilder s = new StringBuilder();
		appendPositionHierarchy(s, object);
		return s.toString();
	}

	@Override
	public String caseTemplateSignature(TemplateSignature object) {
		assert object != null;
		StringBuilder s = new StringBuilder();
		appendPositionHierarchy(s, object);
		return s.toString();
	}

	@Override
	public String caseType(Type object) {
		assert object != null;
		StringBuilder s = new StringBuilder();
		if (object.getOwningTemplateParameter() != null) {
			appendPositionHierarchy(s, object);
		}
		else {
			appendNameHierarchy(s, "T", object, object.getName());
		}
		return s.toString();
	}

	@Override
	public String caseValueSpecification(ValueSpecification object) {
		assert object != null;
		StringBuilder s = new StringBuilder();
		appendPositionHierarchy(s, object);
		return s.toString();
	}

	@Override
	public String defaultCase(EObject object) {
		if (object.eClass().getEPackage() == EcorePackage.eINSTANCE) {
			return ecoreSwitch.doSwitch(object);
		}
		else if (object instanceof DynamicEObjectImpl) {
			return pseudoCaseDynamicEObjectImpl((DynamicEObjectImpl)object);
		}
		else {
			System.out.println("Unsupported UMLXMIID for '" + object.eClass().getName() + "'");
		}
		return null;
	}

	protected String pseudoCaseDynamicEObjectImpl(@NonNull DynamicEObjectImpl object) {
		for (EStructuralFeature eFeature : object.eClass().getEStructuralFeatures()) {
			if ((eFeature instanceof EReference) && eFeature.getName().startsWith("base_") && !eFeature.isMany()) {
				EObject eObject = (EObject) object.eGet(eFeature);
				if (eObject != null) {
					StringBuilder s = new StringBuilder();
					s.append("PA.");
					s.append(doSwitch(eObject));
					return s.toString();
				}
			}
		}
		System.out.println("Unsupported DUMLXMIID for '" + object.eClass().getName() + "'");
		return null;
	}
}
