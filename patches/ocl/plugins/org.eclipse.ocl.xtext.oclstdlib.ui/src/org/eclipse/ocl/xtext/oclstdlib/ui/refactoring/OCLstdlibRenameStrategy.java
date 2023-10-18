/*******************************************************************************
 * Copyright (c) 2011, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.oclstdlib.ui.refactoring;


/**
 * Encapsulates the model changes of a rename refactoring.
 */
//@SuppressWarnings("restriction")
public class OCLstdlibRenameStrategy { /*extends AbstractRenameStrategy {

	public static class Provider implements IRenameStrategy.Provider
	{
		@Inject
		private ILocationInFileProvider locationProvider;

		public IRenameStrategy get(EObject targetEObject, IRenameElementContext renameElementContext) {
			if (targetEObject instanceof NamedElement)
				return new OCLstdlibRenameStrategy(renameElementContext, (NamedElement) targetEObject, locationProvider);
			else
				return null;
		}
	}

	private XtextEditor editor;
	private URI contextResourceURI;
	private ILocationInFileProvider locationProvider;

	protected OCLstdlibRenameStrategy(IRenameElementContext renameElementContext, NamedElement targetEObject, ILocationInFileProvider locationProvider) {
		super(targetEObject, PivotPackage.Literals.NAMED_ELEMENT__NAME);
		this.contextResourceURI = renameElementContext.getContextResourceURI();
		this.editor = (XtextEditor) renameElementContext.getTriggeringEditor();
		this.locationProvider = locationProvider;
	}
	public void createDeclarationUpdates(String newName, ResourceSet resourceSet, IRefactoringUpdateAcceptor updateAcceptor) {
		applyDeclarationChange(newName, resourceSet);
		Resource targetResource = resourceSet.getResource(getTargetElementOriginalURI().trimFragment(), false);
		EObject targetElement = resourceSet.getEObject(getTargetElementOriginalURI(), false);
		IXtextDocument document = editor.getDocument();
		ITextRegion textRegion = locationProvider.getSignificantTextRegion(targetElement);
		ReplaceEdit textEdit = new ReplaceEdit(textRegion.getOffset(), textRegion.getLength(), newName);
		updateAcceptor.accept(contextResourceURI, textEdit);
	}

	@Override
	protected EObject setName(URI targetElementURI, String newName, ResourceSet resourceSet) {
		EObject targetElement = resourceSet.getEObject(targetElementURI, false);
		if (targetElement == null) {
			throw new RefactoringStatusException("Target element not loaded.", true);
		}
		if (targetElement instanceof NamedElement) {
			((NamedElement) targetElement).setName(newName);
			return targetElement;
		}
		EAttribute nameAttribute = getNameAttribute();
		targetElement.eSet(nameAttribute, newName);
		return targetElement;
	} */

}
