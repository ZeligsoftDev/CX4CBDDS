/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.property.xtext.scoping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.QualifiedName;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.RedefinesRule;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.SubsetsRule;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.TypeRule;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementUtil;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Property;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.SimpleScope;

/**
 * This class contains custom scoping description.
 *
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping on
 * how and when to use it
 *
 */
public class UmlPropertyScopeProvider extends AbstractDeclarativeScopeProvider {

	/**
	 * Rule for computing the scope of PropertyRule
	 *
	 * @param ctx
	 * @param ref
	 * @return
	 */
	public IScope scope_TypeRule_type(TypeRule ctx, EReference ref) {
		return create___TypeRule_type___Scope(ctx);
	}

	private IScope create___TypeRule_type___Scope(TypeRule ctx) {
		if (ctx.getPath() == null) {
			EObject contextElement = ContextElementUtil.getContextElement(ctx.eResource());
			Namespace root = (Namespace) EcoreUtil.getRootContainer(contextElement);
			Iterator<EObject> i = root.eResource().getAllContents();
			List<EObject> allContent = new ArrayList<EObject>();
			while (i.hasNext()) {
				EObject object = i.next();
				if (object instanceof Classifier) {
					allContent.add(object);
				}
			}
			Iterable<IEObjectDescription> visibleClassifiers = Scopes.scopedElementsFor(allContent);
			return new SimpleScope(visibleClassifiers);
		} else {
			// In the case where a path (qualified name prefix) has been
			// specified,
			// retrieves visible elements from this name space
			List<Element> tmpVisibleElementsFromPath = new ArrayList<Element>();
			if (ctx.getPath() != null) {
				QualifiedName qualifiedName = ctx.getPath();
				while (qualifiedName.getRemaining() != null) {
					qualifiedName = qualifiedName.getRemaining();
				}
				Namespace nearestNamespace = qualifiedName.getPath();
				if (nearestNamespace != null) {
					List<Element> tmpVisiblePropertiesFromPath = new ArrayList<Element>();
					tmpVisiblePropertiesFromPath.addAll(new Visitor_GetOwnedAndImportedClassifiers().visit(nearestNamespace));
					for (Element e : tmpVisiblePropertiesFromPath) {
						tmpVisibleElementsFromPath.add(e);
					}
				}
			}

			// builds the nested scope base on hierarchy and then inheritance
			SimpleScope resultScope = null;

			Iterable<IEObjectDescription> iterableIEobjectDescriptions;
			if (!tmpVisibleElementsFromPath.isEmpty()) {
				iterableIEobjectDescriptions = Scopes.scopedElementsFor(tmpVisibleElementsFromPath);
				resultScope = resultScope != null ? new SimpleScope(resultScope, iterableIEobjectDescriptions) : new SimpleScope(iterableIEobjectDescriptions);
			}

			return resultScope != null ? resultScope : new SimpleScope(Scopes.scopedElementsFor(new ArrayList<Element>()));
		}
	}

	/**
	 * @param ctx
	 * @param ref
	 * @return
	 */
	public IScope scope_QualifiedName_path(QualifiedName ctx, EReference ref) {
		List<Namespace> visibleNamespaces = new ArrayList<Namespace>();
		if (ctx != null && ctx.eContainer() != null && ctx.eContainer() instanceof QualifiedName) {
			Namespace parentNameSpace = ((QualifiedName) ctx.eContainer()).getPath();
			visibleNamespaces.addAll(new Visitor_GetOwnedNamespacesAndImportedNamespaces().visit(parentNameSpace));
		} else {
			EObject contextElement = ContextElementUtil.getContextElement(ctx.eResource());
			Namespace root = (Namespace) EcoreUtil.getRootContainer(contextElement);
			visibleNamespaces.add(root);
			visibleNamespaces.addAll(new Visitor_GetOwnedNamespacesAndImportedNamespaces().visit(root));
		}
		Iterable<IEObjectDescription> iterableIEobjectDescription = Scopes.scopedElementsFor(visibleNamespaces);
		return new SimpleScope(iterableIEobjectDescription);
	}

	private class Visitor_GetImportedNamespaces {

		public List<Namespace> visit(Namespace visited) {
			List<Namespace> namespaces = new ArrayList<Namespace>();

			// retrieves imported namespaces
			for (PackageImport pImport : visited.getPackageImports()) {
				namespaces.add(pImport.getImportedPackage());
			}
			for (ElementImport eImport : visited.getElementImports()) {
				if (eImport.getImportedElement() instanceof Namespace) {
					namespaces.add((Namespace) eImport.getImportedElement());
				}
			}
			// get top-level packages (imported or not)
			namespaces.addAll(PackageUtil.getTopLevelPackages(visited));

			return namespaces;
		}
	}

	private class Visitor_GetOwnedNamespacesAndImportedNamespaces extends Visitor_GetImportedNamespaces {

		@Override
		public List<Namespace> visit(Namespace visited) {
			List<Namespace> namespaces = new ArrayList<Namespace>();
			// first retrieves imported namespaces
			namespaces.addAll(super.visit(visited));
			// then retrieves owned namespaces
			for (NamedElement n : visited.getOwnedMembers()) {
				if (n instanceof Namespace) {
					namespaces.add((Namespace) n);
				}
			}
			return namespaces;
		}
	}

	private class Visitor_GetOwnedAndImportedClassifiers {

		public List<Element> visit(Namespace visited) {
			List<Element> visibleElements = new ArrayList<Element>();
			// first retrieves imported properties
			for (ElementImport eImport : visited.getElementImports()) {
				if (eImport.getImportedElement() instanceof Classifier) {
					visibleElements.add(eImport.getImportedElement());
				}
			}
			// then retrieves owned properties
			for (NamedElement n : visited.getOwnedMembers()) {
				if (n instanceof Classifier) {
					visibleElements.add(n);
				}
			}

			return visibleElements;
		}

	}

	/**
	 * Rule for computing the scope of PropertyRule
	 *
	 * @param ctx
	 * @param ref
	 * @return
	 */
	public IScope scope_RedefinesRule_property(RedefinesRule ctx, EReference ref) {
		Iterable<IEObjectDescription> iterableIEobjectDescription = Scopes.scopedElementsFor(retrieveInheritedProperties(ctx));
		return new SimpleScope(iterableIEobjectDescription);
	}

	/**
	 * Rule for computing the scope of PropertyRule
	 *
	 * @param ctx
	 * @param ref
	 * @return
	 */
	public IScope scope_SubsetsRule_property(SubsetsRule ctx, EReference ref) {
		Iterable<IEObjectDescription> iterableIEobjectDescription = Scopes.scopedElementsFor(retrieveInheritedProperties(ctx));
		return new SimpleScope(iterableIEobjectDescription);
	}

	public static List<Property> retrieveInheritedProperties(EObject model) {
		if (model == null) {
			return Collections.emptyList();
		}

		EObject editionContext = ContextElementUtil.getContextElement(model.eResource());
		if (!(editionContext instanceof Property)) {
			return Collections.emptyList();
		}

		Property editedProperty = (Property) editionContext;

		Classifier owner = (Classifier) editedProperty.getNamespace();
		List<Property> inheritedProperties = new ArrayList<Property>();
		for (Classifier parent : owner.getGenerals()) {
			for (Property p : parent.getAllAttributes()) {
				if (!inheritedProperties.contains(p)) {
					;
				}
				inheritedProperties.add(p);
			}
		}
		return inheritedProperties;
	}
}
