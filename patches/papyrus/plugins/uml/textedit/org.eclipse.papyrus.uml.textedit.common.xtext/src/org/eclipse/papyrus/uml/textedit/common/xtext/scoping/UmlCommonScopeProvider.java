package org.eclipse.papyrus.uml.textedit.common.xtext.scoping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.QualifiedName;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Type;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.SimpleScope;

/**
 * This class contains custom scoping description.
 *
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it
 *
 */
public class UmlCommonScopeProvider extends AbstractDeclarativeScopeProvider {

	/**
	 *
	 * Constructor.
	 *
	 */
	public UmlCommonScopeProvider() {
	}

	/**
	 * Getter for {@link #model}
	 *
	 * @return
	 *         {@link #model}
	 */
	protected Namespace getModel(EObject xtextElement) {
		EObject semanticElement = ContextElementUtil.getContextElement(xtextElement.eResource());
		if (semanticElement instanceof Element) {
			Element element = (Element) semanticElement;
			List<Namespace> namespaces = element.getNearestPackage().allNamespaces();
			if (namespaces.size() == 0) {
				return element.getNearestPackage();
			} else {
				return namespaces.get(namespaces.size() - 1);
			}
		}

		return null;
	}

	/**
	 * Rule for computing the scope of PropertyRule
	 *
	 * @param ctx
	 *
	 * @param ref
	 * @return
	 */
	public IScope scope_TypeRule_type(org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.TypeRule ctx, EReference ref) {
		return create___TypeRule_type___Scope(ctx);
	}

	/**
	 * Shall overridden to restrict the possible {@link Type}
	 *
	 * This method provides the scope for the {@link Type}
	 *
	 * @param ctx
	 * @return
	 */
	protected IScope create___TypeRule_type___Scope(org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.TypeRule ctx) {
		if (ctx.getPath() == null) {
			Iterator<EObject> i = ContextElementUtil.getContextElement(ctx.eResource()).eResource().getAllContents();
			List<EObject> allContent = new ArrayList<EObject>();
			while (i.hasNext()) {
				EObject object = i.next();
				if (object instanceof Element) {
					if (isWantedType((Element) object)) {
						allContent.add(object);
					}
				}
			}
			Iterable<IEObjectDescription> visibleParameterBoxes = Scopes.scopedElementsFor(allContent);
			return new SimpleScope(visibleParameterBoxes);
		} else {
			// In the case where a path (qualified name prefix) has been specified,
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
					tmpVisiblePropertiesFromPath.addAll(getOwnedAndImportedType(nearestNamespace));
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
	 *
	 * shall be overridden to restrict the possible {@link Type}
	 *
	 *
	 * Returns the owned and imported {@link Type} imported namespace
	 *
	 * @param visited
	 *            the visited namespace
	 * @return
	 *         the owned and imported {@link Type} imported namespace
	 */
	protected List<Element> getOwnedAndImportedType(Namespace visited) {
		List<Element> visibleElements = new ArrayList<Element>();
		// first retrieves imported properties
		for (ElementImport eImport : visited.getElementImports()) {
			if (isWantedType(eImport.getImportedElement())) {
				visibleElements.add(eImport.getImportedElement());
			}
		}
		// then retrieves owned properties
		for (NamedElement n : visited.getOwnedMembers()) {
			if (isWantedType(n)) {
				visibleElements.add(n);
			}
			if (n instanceof Namespace) {
				visibleElements.addAll(getOwnedAndImportedType((Namespace) n));
			}
		}
		return visibleElements;
	}

	/**
	 * Returns the imported {@link Namespace}
	 *
	 * @param visited
	 *            the visited namespace
	 * @return
	 *         the imported {@link Namespace}
	 */
	protected List<Namespace> getImportedNamespaces(Namespace visited) {
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

		return namespaces;
	}

	/**
	 * Returns the owned and imported {@link Namespace}
	 *
	 * @param visited
	 *            the visited namespace
	 * @return
	 *         the owned and imported {@link Namespace}
	 */
	protected List<Namespace> getOwnedAndImportedNamespaces(Namespace visited) {
		List<Namespace> namespaces = new ArrayList<Namespace>();
		// first retrieves imported namespaces
		namespaces.addAll(getImportedNamespaces(visited));
		// then retrieves owned namespaces
		for (NamedElement n : visited.getOwnedMembers()) {
			if (n instanceof Namespace) {
				namespaces.add((Namespace) n);
			}
		}
		return namespaces;
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
			visibleNamespaces.addAll(getOwnedAndImportedNamespaces(parentNameSpace));
		} else {
			visibleNamespaces.add(getModel(ctx));
			visibleNamespaces.addAll(getImportedNamespaces(getModel(ctx)));
		}
		Iterable<IEObjectDescription> iterableIEobjectDescription = Scopes.scopedElementsFor(visibleNamespaces);
		return new SimpleScope(iterableIEobjectDescription);
	}

	/**
	 * Inherited class should overridden this method in order to have a mode specific type
	 *
	 * Tests if the element is an instance of the wanted type
	 *
	 * @param e
	 *            the element to test
	 * @return
	 *         <code>true</code> is the element is an instance of the wanted type
	 */
	protected boolean isWantedType(Element e) {
		return e instanceof Type;
	}
}
