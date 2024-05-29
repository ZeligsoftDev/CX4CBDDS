/*******************************************************************************
 * Copyright (c) 2012, 2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.impl;

import org.eclipse.emf.compare.FeatureMapChange;
import org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.IStructuralFeatureAccessor;
import org.eclipse.emf.compare.rcp.ui.internal.EMFCompareRCPUIMessages;
import org.eclipse.emf.compare.rcp.ui.internal.configuration.IEMFCompareConfiguration;
import org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer.accessor.impl.FeatureMapKeyChangeAccessorImpl;
import org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer.accessor.impl.ResourceContentsAccessorImpl;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.ICompareColor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.jface.viewers.ContentViewer;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

/**
 * A concrete implementation of {@link AbstractTableOrTreeMergeViewer} for TableViewer.
 * 
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @since 4.0
 */
public class TableMergeViewer extends AbstractTableOrTreeMergeViewer {

	/** The TableViewer. */
	private TableViewer fTableViewer;

	/** The InfoViewer. */
	private InfoViewer fInfoViewer;

	/**
	 * Default constructor.
	 * 
	 * @param parent
	 *            the parent widget of this viewer.
	 * @param side
	 *            the side of this viewer.
	 * @param colorProvider
	 *            the color provider to use with this viewer.
	 * @param compareConfiguration
	 *            the compare configuration object to use with this viewer.
	 */
	public TableMergeViewer(Composite parent, MergeViewerSide side, ICompareColor.Provider colorProvider,
			IEMFCompareConfiguration compareConfiguration) {
		super(parent, side, colorProvider, compareConfiguration);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.impl.AbstractMergeViewer#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(1, false);
		layout.marginLeft = -1;
		layout.marginRight = -1;
		layout.marginTop = -1;
		layout.marginBottom = 0;
		layout.horizontalSpacing = 0;
		layout.verticalSpacing = 0;
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		composite.setLayout(layout);

		fInfoViewer = new InfoViewer(composite, getSide());
		fInfoViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));

		fTableViewer = new TableViewer(composite,
				SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION);
		fTableViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		return composite;
	}

	public final int getVerticalOffset() {
		return fInfoViewer.getControl().getSize().y - 2;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.mergeviewer.impl.AbstractMergeViewer.ui.internal.contentmergeviewer.AbstractMergeViewer#getStructuredViewer()
	 */
	@Override
	public final TableViewer getStructuredViewer() {
		return fTableViewer;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.impl.AbstractMergeViewer#setContentProvider(org.eclipse.jface.viewers.IContentProvider)
	 */
	@Override
	public void setContentProvider(IContentProvider contentProvider) {
		super.setContentProvider(contentProvider);
		fInfoViewer.setContentProvider(contentProvider);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.impl.AbstractMergeViewer#setLabelProvider(org.eclipse.jface.viewers.IBaseLabelProvider)
	 */
	@Override
	public void setLabelProvider(IBaseLabelProvider labelProvider) {
		super.setLabelProvider(labelProvider);
		fInfoViewer.setLabelProvider(labelProvider);
	}

	@Override
	protected void hookDispose() {
		fTableViewer = null;
		fInfoViewer = null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.Viewer#inputChanged(java.lang.Object, java.lang.Object)
	 */
	@Override
	protected void inputChanged(Object input, Object oldInput) {
		fTableViewer.setInput(input);
		fInfoViewer.setInput(input);
		((Composite)getControl()).layout(true);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.Viewer#refresh()
	 */
	@Override
	public void refresh() {
		fInfoViewer.refresh();
		fTableViewer.refresh();
	}

	/**
	 * A content viewer is a model-based adapter on a widget which accesses its model by means of a content
	 * provider and a label provider. This InfoViewer is the top part of the TableMergeViewer. It contains the
	 * object an the feature concerned by the Diff.
	 * 
	 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
	 * @since 4.0
	 */
	private static class InfoViewer extends ContentViewer {

		/** The side of this viewer. */
		private final MergeViewerSide fSide;

		/** The control associated with this viewer. */
		private final Composite fControl;

		/** The Icon of the EObject concerned by the Diff. */
		private final Label fEObjectIcon;

		/** The Label of the EObject concerned by the Diff. */
		private final Label fEObjectLabel;

		/** The Icon of the feature concerned by the Diff. */
		private final Label fFeatureIcon;

		/** The Label of the feature concerned by the Diff. */
		private final Label fFeatureLabel;

		/** Stores the selection for this viewer. */
		private ISelection fSelection;

		/** Stores the input of this viewer. */
		private Object fInput;

		/**
		 * Default constructor.
		 * 
		 * @param parent
		 *            the parent widget of this viewer.
		 * @param side
		 *            the side of this viewer.
		 */
		public InfoViewer(Composite parent, MergeViewerSide side) {
			this.fControl = new Composite(parent, SWT.BORDER);
			this.fSide = side;

			fControl.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
			GridLayout layout = new GridLayout(3, false);
			layout.verticalSpacing = 0;
			layout.horizontalSpacing = 0;
			layout.marginLeft = 1;
			layout.marginHeight = 0;
			layout.marginWidth = 0;
			layout.marginBottom = 0;
			fControl.setLayout(layout);

			Composite eObjectComposite = new Composite(fControl, SWT.NONE);
			GridLayout eObjectCompositelayout = new GridLayout(2, false);
			eObjectCompositelayout.verticalSpacing = 0;
			eObjectCompositelayout.horizontalSpacing = 0;
			eObjectCompositelayout.marginLeft = 0;
			eObjectCompositelayout.marginHeight = 0;
			eObjectCompositelayout.marginWidth = 0;
			eObjectCompositelayout.marginBottom = 0;
			eObjectComposite.setLayout(eObjectCompositelayout);
			fEObjectIcon = new Label(eObjectComposite, SWT.NONE);
			fEObjectIcon.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
			fEObjectLabel = new Label(eObjectComposite, SWT.NONE);
			fEObjectLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			eObjectComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, true, 3, 1));

			Label lblIn = new Label(fControl, SWT.NONE);
			lblIn.setText("    "); //$NON-NLS-1$

			fFeatureIcon = new Label(fControl, SWT.NONE);
			fFeatureIcon.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
			fFeatureLabel = new Label(fControl, SWT.NONE);
			fFeatureLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

			hookControl(fControl);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.jface.viewers.Viewer#getControl()
		 */
		@Override
		public Control getControl() {
			return fControl;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.jface.viewers.Viewer#inputChanged(java.lang.Object, java.lang.Object)
		 */
		@Override
		protected void inputChanged(Object input, Object oldInput) {
			fInput = input;
			fControl.setRedraw(false);
			try {
				refresh();
			} finally {
				fControl.setRedraw(true);
			}
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.jface.viewers.Viewer#getSelection()
		 */
		@Override
		public ISelection getSelection() {
			return fSelection;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.jface.viewers.Viewer#refresh()
		 */
		@Override
		public void refresh() {
			if (fInput instanceof FeatureMapKeyChangeAccessorImpl) {
				FeatureMapKeyChangeAccessorImpl featureMapAccessor = (FeatureMapKeyChangeAccessorImpl)fInput;

				final FeatureMapChange diff = featureMapAccessor.getFeatureMapChange();
				final FeatureMap.Entry entry = (FeatureMap.Entry)diff.getValue();
				final Object entryValue = entry.getValue();

				if (getLabelProvider() instanceof ILabelProvider) {
					ILabelProvider labelProvider = (ILabelProvider)getLabelProvider();

					fFeatureLabel.setText(
							EMFCompareRCPUIMessages.getString("TableMergeViewer.featureMapEntryKeyLabel")); //$NON-NLS-1$

					fEObjectIcon.setImage(labelProvider.getImage(entryValue));
					fEObjectLabel.setText(labelProvider.getText(entryValue));
				}

				fControl.layout(true);
			} else if (fInput instanceof IStructuralFeatureAccessor) {
				IStructuralFeatureAccessor featureAccessor = (IStructuralFeatureAccessor)fInput;

				EObject eObject = featureAccessor.getEObject(fSide);
				if (eObject == null) {
					if (fSide != MergeViewerSide.ANCESTOR) {
						eObject = featureAccessor.getEObject(MergeViewerSide.ANCESTOR);
						if (eObject == null) {
							eObject = featureAccessor.getEObject(fSide.opposite());
						}
					} else {
						eObject = featureAccessor.getEObject(MergeViewerSide.LEFT);
						if (eObject == null) {
							eObject = featureAccessor.getEObject(MergeViewerSide.RIGHT);
						}
					}
				}
				EStructuralFeature structuralFeature = featureAccessor.getStructuralFeature();

				if (getLabelProvider() instanceof ILabelProvider) {
					ILabelProvider labelProvider = (ILabelProvider)getLabelProvider();

					fFeatureIcon.setImage(labelProvider.getImage(structuralFeature));
					fFeatureLabel.setText(labelProvider.getText(structuralFeature));

					fEObjectIcon.setImage(labelProvider.getImage(eObject));
					fEObjectLabel.setText(labelProvider.getText(eObject));
				}

				fControl.layout(true);
			} else if (fInput instanceof ResourceContentsAccessorImpl) {
				final ResourceContentsAccessorImpl resourceContentAccessor = (ResourceContentsAccessorImpl)fInput;
				final Resource resource = resourceContentAccessor.getResource(fSide);

				if (getLabelProvider() instanceof ILabelProvider) {
					ILabelProvider labelProvider = (ILabelProvider)getLabelProvider();
					fFeatureLabel.setText(EMFCompareRCPUIMessages
							.getString("TableMergeViewer.directResourceContentsLabel")); //$NON-NLS-1$

					fEObjectIcon.setImage(labelProvider.getImage(resource));
					fEObjectLabel.setText(labelProvider.getText(resource));
				}

				fControl.layout(true);
			}
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.jface.viewers.Viewer#setSelection(org.eclipse.jface.viewers.ISelection, boolean)
		 */
		@Override
		public void setSelection(ISelection selection, boolean reveal) {
			fSelection = selection;
		}

	}
}
