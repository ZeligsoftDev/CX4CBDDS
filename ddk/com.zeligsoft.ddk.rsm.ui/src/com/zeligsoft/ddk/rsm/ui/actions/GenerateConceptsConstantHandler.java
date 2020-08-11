/**
 * Copyright 2020 Northrop Grumman Systems Corporation.
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
package com.zeligsoft.ddk.rsm.ui.actions;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchMatch;
import org.eclipse.jdt.core.search.SearchParticipant;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.SearchRequestor;
import org.eclipse.jdt.core.search.TypeDeclarationMatch;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.dialogs.SelectionDialog;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Package;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.ddk.rsm.ui.Activator;
import com.zeligsoft.ddk.rsm.ui.DomainDevelopmentConstants;
import com.zeligsoft.ddk.rsm.ui.l10n.Messages;
import com.zeligsoft.ddk.rsm.ui.operations.GenerateConceptsOperation;

/**
 * Handler for validating a subtree
 */
public class GenerateConceptsConstantHandler extends AbstractHandler {

	private String packageName;

	private IFolder folder;

	private List<IType> searchResults;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		StructuredSelection selection = (StructuredSelection) BaseUIUtil.getSelection();
		final Package model = (Package) BaseUIUtil.getEObjectFromSelection(selection);

		if (model == null) {
			return null;
		}

		findExistingType(model);
		if (folder == null) {
			selectFolder();
		}
		if (folder != null) {
			GenerateConceptsOperation op = new GenerateConceptsOperation(Display.getCurrent().getActiveShell(), model,
					folder, packageName);
			op.run();
		}

		return null;
	}

	/**
	 * Returns the IContainer for the Java type to be created by first searching for
	 * an existing Java type (based on the name of the model).
	 * 
	 * @param model
	 * @return
	 */
	private void findExistingType(Package model) {

		String fileNamePattern = UML2Util.getValidJavaIdentifier(model.getName()) + "Names";//$NON-NLS-1$

		SearchPattern pattern = SearchPattern.createPattern(fileNamePattern, IJavaSearchConstants.CLASS,
				IJavaSearchConstants.DECLARATIONS, SearchPattern.R_EXACT_MATCH | SearchPattern.R_CASE_SENSITIVE);

		IJavaSearchScope scope = SearchEngine.createWorkspaceScope();

		searchResults = new ArrayList<IType>();

		SearchRequestor requestor = new SearchRequestor() {

			@Override
			public void acceptSearchMatch(SearchMatch match) throws CoreException {
				if (match instanceof TypeDeclarationMatch) {
					TypeDeclarationMatch m = (TypeDeclarationMatch) match;
					Object o = m.getElement();
					if (o instanceof IType) {
						IType ty = (IType) o;
						searchResults.add(ty);
					}

				}
			}

		};

		SearchEngine searchEngine = new SearchEngine();
		try {
			searchEngine.search(pattern, new SearchParticipant[] { SearchEngine.getDefaultSearchParticipant() }, scope,
					requestor, null);
		} catch (CoreException e) {
			Activator.getDefault().error(
					NLS.bind(Messages.ZDLConstantsGenerationActionDelegate_workspaceSearchException, fileNamePattern),
					e);
		}

		if (searchResults.size() > 1) {
			// Select among existing locations
			IJavaElement[] scopeElements = new IJavaElement[searchResults.size()];
			for (int i = 0; i < searchResults.size(); i++) {
				scopeElements[i] = searchResults.get(i).getPackageFragment();
			}
			scope = SearchEngine.createJavaSearchScope(scopeElements, IJavaSearchScope.SOURCES);

			IRunnableContext context = new IRunnableContext() {

				@Override
				public void run(boolean fork, boolean cancelable, IRunnableWithProgress runnable)
						throws InvocationTargetException, InterruptedException {
					runnable.run(new NullProgressMonitor());
				}
			};

			SelectionDialog dialog = JavaUI.createPackageDialog(Display.getCurrent().getActiveShell(), context, scope,
					false, true, "");//$NON-NLS-1$
			dialog.setTitle(Messages.ZDLConstantsGenerationActionDelegate_selectionDlgTitle);
			dialog.setMessage(Messages.ZDLConstantsGenerationActionDelegate_multipleMatches);
			if (dialog.open() == Window.OK) {
				Object[] resultArray = dialog.getResult();
				if (resultArray.length > 0) {
					Object result = resultArray[0];
					if (result instanceof IPackageFragment) {
						IPackageFragment packageFragment = (IPackageFragment) result;
						packageName = packageFragment.getElementName();
						try {
							folder = (IFolder) packageFragment.getCorrespondingResource();
						} catch (JavaModelException e) {
							e.printStackTrace();
						}
					}
				}
			}
		} else if (searchResults.size() == 1) {
			IType type = searchResults.get(0);
			IPackageFragment pf = type.getPackageFragment();
			packageName = pf.getElementName();
			try {
				folder = (IFolder) pf.getCorrespondingResource();
			} catch (JavaModelException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Opens a workspace Package selection dialog.
	 * 
	 * @param model
	 * @return the selected package
	 */
	private void selectFolder() {

		IJavaSearchScope scope = SearchEngine.createWorkspaceScope();
		IRunnableContext context = new IRunnableContext() {

			@Override
			public void run(boolean fork, boolean cancelable, IRunnableWithProgress runnable)
					throws InvocationTargetException, InterruptedException {
				runnable.run(new NullProgressMonitor());
			}
		};

		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		String namesPackageFilter = store.getString(DomainDevelopmentConstants.NAMES_PACKAGE_FILTER);

		SelectionDialog dialog = JavaUI.createPackageDialog(Display.getCurrent().getActiveShell(), context, scope,
				false, true, namesPackageFilter);
		dialog.setTitle(Messages.ZDLConstantsGenerationActionDelegate_selectionDlgTitle);
		dialog.setMessage(Messages.ZDLConstantsGenerationActionDelegate_selectionDlgDescription);

		if (dialog.open() == Window.OK) {
			IPackageFragment pf = (IPackageFragment) dialog.getResult()[0];
			folder = (IFolder) pf.getResource();
			packageName = pf.getElementName();
		}
	}

}
