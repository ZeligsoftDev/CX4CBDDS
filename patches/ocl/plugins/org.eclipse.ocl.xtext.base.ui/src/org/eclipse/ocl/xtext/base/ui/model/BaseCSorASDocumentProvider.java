/*******************************************************************************
 * Copyright (c) 2014, 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.ui.model;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.internal.resource.OCLASResourceFactory;
import org.eclipse.ocl.pivot.internal.resource.StandaloneProjectMap;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotConstantsInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.CSResource;
import org.eclipse.ocl.pivot.resource.CSResource.CSResourceExtension2;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.ocl.pivot.utilities.XMIUtil;
import org.eclipse.ocl.xtext.base.ui.BaseUiModule;
import org.eclipse.ocl.xtext.base.ui.BaseUiPluginHelper;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.xtext.parsetree.reconstr.XtextSerializationException;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.IConcreteSyntaxValidator.InvalidConcreteSyntaxException;

/**
 * BaseCSorASDocumentProvider orchestrates the load and saving of optional XMI content
 * externally while maintaining the serialised human friendly form internally.
 */
public abstract class BaseCSorASDocumentProvider extends BaseDocumentProvider
{
	public class UnresolvedProxyDiagnostic implements Resource.Diagnostic
	{
		protected final @NonNull String message;

		public UnresolvedProxyDiagnostic(@NonNull String message) {
			this.message = message;
		}

		@Override
		public int getColumn() {
			return 0;
		}

		@Override
		public int getLine() {
			return 0;
		}

		@Override
		public String getLocation() {
			return null;
		}

		@Override
		public String getMessage() {
			return message;
		}

		@Override
		public String toString() {
			return message;
		}
	}

	private static final Logger log = LogManager.getLogger(BaseCSorASDocumentProvider.class);

	public static final String PERSIST_AS_PIVOT = "pivot";
	public static final String PERSIST_AS_TEXT = "text";

	/**
	 * Representation used when loaded.
	 */
	protected Map<IDocument,String> loadedAsMap = new HashMap<IDocument,String>();
	/**
	 * Delegate URI to be used when exporting, null for default.
	 */
	protected Map<IDocument,String> exportDelegateURIMap = new HashMap<IDocument,String>();
	/**
	 * Representation to be used when saved.
	 */
	protected Map<IDocument,String> saveAsMap = new HashMap<IDocument,String>();

	protected Map<IDocument, URI> uriMap = new HashMap<IDocument, URI>();		// Helper for setDocumentContent

	/**
	 * Flag to inhibit CoreException appearing in both Console Log and initial Editor Failure Page
	 */
	private boolean setDocumentContentInProgress = true;

	public static @NonNull InputStream createResettableInputStream(@NonNull InputStream inputStream) throws IOException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			byte[] buffer = new byte[16384];
			int len;
			while ((len = inputStream.read(buffer, 0, buffer.length)) > 0) {
				outputStream.write(buffer, 0, len);
			}
			return new ByteArrayInputStream(outputStream.toByteArray());
		}
		finally {
			outputStream.close();
		}
	}

	protected void diagnoseErrors(XtextResource xtextResource, Exception e) throws CoreException {
		List<Diagnostic> diagnostics = xtextResource.validateConcreteSyntax();
		if (diagnostics.size() > 0) {
			StringBuilder s = new StringBuilder();
			s.append("Concrete Syntax validation failed");
			for (Diagnostic diagnostic : diagnostics) {
				s.append("\n");
				s.append(diagnostic.toString());
			}
			throwCoreException(s.toString(), e);
		}
		else {
			throwCoreException("Failed to load", e);
		}
	}

	protected abstract @NonNull String createTestDocument(@NonNull URI uri, @NonNull String lastSegment);

	@Override
	protected void doSaveDocument(IProgressMonitor monitor, Object element, IDocument document, boolean overwrite) throws CoreException {
		String saveAs = saveAsMap.get(document);
		if ((element instanceof IFileEditorInput) && (document instanceof BaseDocument) && !isText(saveAs)) {
			StringWriter xmlWriter = new StringWriter();
			try {
				URI uri = EditUIUtil.getURI((IFileEditorInput)element);
				if (uri == null) {
					log.warn("No URI");
				}
				else if (PERSIST_AS_PIVOT.equals(saveAs)) {
					((BaseDocument) document).saveAsPivot(xmlWriter);
				}
				else {
					log.warn("Unknown saveAs '" + saveAs + "'");
				}
				IDocument saveDocument = new Document();
				saveDocument.set(xmlWriter.toString());
				super.doSaveDocument(monitor, element, saveDocument, overwrite);
				loadedAsMap.put(document, saveAs);
			} catch (Exception e) {
				BaseUiPluginHelper helper = BaseUiPluginHelper.INSTANCE;
				String title = helper.getString("_UI_SaveFailure_title", true);
				String message = helper.getString("_UI_SaveFailure_message", true);
				ErrorDialog.openError(null, title, message, helper.createErrorStatus(e));
				monitor.setCanceled(true);				// Still dirty
			}
		}
		else {
			super.doSaveDocument(monitor, element, document, overwrite);
		}
	}

	protected abstract String getCScontentType();

	protected abstract @NonNull String getFileExtension();

	protected String getPluginId() {
		return BaseUiModule.PLUGIN_ID;
	}

	@Override
	protected void handleCoreException(CoreException exception, String message) {
		if (!setDocumentContentInProgress ) {
			super.handleCoreException(exception, message);
		}
	}

	@Override
	protected void handleElementContentChanged(IFileEditorInput fileEditorInput) {
		FileInfo info= (FileInfo) getElementInfo(fileEditorInput);
		if (info == null)
			return;
		if (info.fDocument == null) {
			super.handleElementContentChanged(fileEditorInput);
		}
		IDocument document = info.fDocument;
		String oldContent= document.get();
		IStatus status= null;

		try {

			try {
				refreshFile(fileEditorInput.getFile());
			} catch (CoreException x) {
				handleCoreException(x, "FileDocumentProvider.handleElementContentChanged"); //$NON-NLS-1$
			}

			cacheEncodingState(fileEditorInput);
			setDocumentContent(document, fileEditorInput, info.fEncoding);

		} catch (CoreException x) {
			status= x.getStatus();
		}

		String newContent= document.get();

		if ( !newContent.equals(oldContent)) {

			// set the new content and fire content related events
			fireElementContentAboutToBeReplaced(fileEditorInput);

			removeUnchangedElementListeners(fileEditorInput, info);

			info.fDocument.removeDocumentListener(info);
			info.fDocument.set(newContent);
			info.fCanBeSaved= false;
			info.fModificationStamp= computeModificationStamp(fileEditorInput.getFile());
			info.fStatus= status;

			addUnchangedElementListeners(fileEditorInput, info);

			fireElementContentReplaced(fileEditorInput);

		} else {

			removeUnchangedElementListeners(fileEditorInput, info);

			// fires only the dirty state related event
			info.fCanBeSaved= false;
			info.fModificationStamp= computeModificationStamp(fileEditorInput.getFile());
			info.fStatus= status;

			addUnchangedElementListeners(fileEditorInput, info);

			fireElementDirtyStateChanged(fileEditorInput, false);
		}
	}

	@Override
	public boolean isDeleted(Object element) {
		IDocument document = getDocument(element);
		String loadIsEcore = loadedAsMap.get(document);
		String saveIsEcore = saveAsMap.get(document);
		if ((loadIsEcore != null) && !loadIsEcore.equals(saveIsEcore)) {
			return true;		// Causes Save to do SaveAs
		}
		return super.isDeleted(element);
	}

	protected boolean isText(String loadedAs) {
		return PERSIST_AS_TEXT.equals(loadedAs);
	}

	/**
	 * @deprecated No longer used.
	 */
	@Deprecated
	protected boolean isXML(@NonNull InputStream inputStream) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		try {
			String line = reader.readLine();
			inputStream.reset();
			return (line != null) && line.startsWith("<?xml");
		}
		finally {
			reader.close();
		}
	}

	protected boolean isXML(@NonNull InputStream inputStream, String encoding) throws IOException {
		String xmlIntro = "<?xml";
		inputStream.mark(xmlIntro.length());
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, encoding));
		try {
			String line = reader.readLine();
			return (line != null) && line.startsWith(xmlIntro);
		}
		finally {
			inputStream.reset();
		}
	}

	@Override
	protected void loadResource(XtextResource resource, String document, String encoding) throws CoreException {
		assert resource != null;
		getEnvironmentFactory().adapt(resource);
		super.loadResource(resource, document, encoding);
	}

	@Override
	protected boolean setDocumentContent(IDocument document, IEditorInput editorInput, String encoding) throws CoreException {
		URI uri = EditUIUtil.getURI(editorInput);
		uriMap.put(document, uri);
		boolean savedSetDocumentContentInProgress = setDocumentContentInProgress;
		try {
			setDocumentContentInProgress = true;
			return super.setDocumentContent(document, editorInput, encoding);
		}
		finally {
			setDocumentContentInProgress = savedSetDocumentContentInProgress;
		}
	}

	@Override
	protected void setDocumentContent(IDocument document, InputStream inputStream, String encoding) throws CoreException {
		//		@NonNull String displayText = sourceText;
		try {
			//			String xmlEncoding = URIConverter.ReadableInputStream.getEncoding(sourceText);
			if (!inputStream.markSupported()) {
				inputStream = createResettableInputStream(inputStream);
			}
			boolean isXML = isXML(inputStream, encoding);
			String persistAs = PERSIST_AS_TEXT;
			if (isXML) {
				ResourceSet asResourceSet = getEnvironmentFactory().getMetamodelManager().getASResourceSet();
				StandaloneProjectMap projectMap = StandaloneProjectMap.getAdapter(asResourceSet);
				StandaloneProjectMap.IConflictHandler conflictHandler = StandaloneProjectMap.MapToFirstConflictHandlerWithLog.INSTANCE; //null; 			// FIXME
				projectMap.configure(asResourceSet, StandaloneProjectMap.LoadFirstStrategy.INSTANCE, conflictHandler);
				StandaloneProjectMap.IProjectDescriptor pivotPackageDescriptor = projectMap.getProjectDescriptor(PivotConstantsInternal.PLUGIN_ID);
				if (pivotPackageDescriptor != null) {
					pivotPackageDescriptor.configure(asResourceSet, StandaloneProjectMap.LoadBothStrategy.INSTANCE, conflictHandler);
				}
				URI uri = uriMap.get(document);
				XMLResource xmiResource = (XMLResource) asResourceSet.getResource(uri, false);
				if ((xmiResource == null) || (xmiResource.getResourceSet() == null)) {	// Skip built-ins and try again as a file read.
					xmiResource = (XMLResource) asResourceSet.createResource(uri, null);
				}
				else {
					xmiResource.unload();
				}
				//				xmiResource.load(new InputSource(new StringReader(sourceText)), null);
				xmiResource.load(inputStream, null);
				//
				//	Check that all proxies are resolved. (This is EcoreUtil.resolveAll(asResourceSet) plus diagnostics.)
				//
				List<@NonNull Resource> asResources = ClassUtil.nullFree(asResourceSet.getResources());
				for (int i = 0; i < asResources.size(); i++) {			// Proxy resolution grows domain.
					Resource resource = asResources.get(i);
					for (EObject eObject : new TreeIterable(resource)) {
						for (Iterator<EObject> it =  eObject.eCrossReferences().iterator(); it.hasNext(); ) {
							EObject eReferencedObject = it.next();
							if (eReferencedObject.eIsProxy() ) {
								resource.getErrors().add(new UnresolvedProxyDiagnostic("Unresolved proxy '" + EcoreUtil.getURI(eReferencedObject) + "' at '" + EcoreUtil.getURI(eObject) + "'"));
							}
						}
					}
				}

				List<Resource.Diagnostic> allErrors = null;
				for (Resource resource : asResourceSet.getResources()) {
					List<Resource.Diagnostic> errors = resource.getErrors();
					if (errors.size() > 0) {
						if (allErrors == null) {
							allErrors = new ArrayList<Resource.Diagnostic>();
						}
						allErrors.addAll(errors);
					}
				}
				if (allErrors != null) {
					Throwable firstThrowable = null;
					StringBuilder s = new StringBuilder();
					boolean isFirst = true;
					for (Resource.Diagnostic diagnostic : allErrors) {
						Object diag = diagnostic;
						if (!isFirst) {
							s.append("\n");
						}
						if (diag instanceof Throwable) {
							while (((Throwable)diag).getCause() != null) {
								diag = ((Throwable)diag).getCause();
							}
							s.append(diag.toString());
							if (firstThrowable == null) {
								firstThrowable = (Throwable) diagnostic;
								s.append("\n  (see Error Log for details.)");
							}
						}
						else {
							s.append(diag.toString());
						}
						isFirst = false;
					}
					throwCoreException(s.toString(), null); //firstThrowable);
				}
				ASResource asResource = null;
				EObject xmiRoot = null;
				EList<EObject> contents = xmiResource.getContents();
				if (contents.size() > 0) {
					xmiRoot = contents.get(0);
					if (xmiRoot instanceof Model) {
						asResource = (ASResource) xmiResource;
						persistAs = PERSIST_AS_PIVOT;
					}

					// FIXME general extensibility
				}
				if (asResource == null) {
					throwCoreException("Failed to load - " + (xmiRoot != null ? "root should be a 'Model' but is a '" + xmiRoot.eClass().getName() + "'" : "no root"), null);
					return;		// Never happens
				}
				//
				ResourceSetImpl csResourceSet = (ResourceSetImpl)getEnvironmentFactory().getResourceSet();
				csResourceSet.getPackageRegistry().put(PivotPackage.eNS_URI, PivotPackage.eINSTANCE);
				URI textURI = xmiResource.getURI().appendFileExtension(getFileExtension());
				CSResource csResource = (CSResource) csResourceSet.getResource(textURI, false);
				if (csResource == null) {
					csResource = (CSResource) csResourceSet.createResource(textURI, getCScontentType());
					Map<URI, Resource> map = csResourceSet.getURIResourceMap();
					map.put(textURI, csResource);
					csResource.setURI(xmiResource.getURI());
				}
				//
				//	ResourceSet contains
				//		Ecore XMI resource with *.ecore URI, possibly in URIResourceMap as *.ecore
				//		CS resource with *.ecore URI, in URIResourceMap as *.ecore.oclinecore
				//
				csResource.updateFrom(asResource, getEnvironmentFactory());
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				inputStream = new ByteArrayInputStream(outputStream.toByteArray());
				//				StringWriter writer = new StringWriter();
				try {
					//					csResource.save(new URIConverter.WriteableOutputStream(writer, xmlEncoding), null);
					Map<Object, Object> saveOptions = XMIUtil.createPivotSaveOptions();
					try {
						csResource.save(outputStream, saveOptions);
					}
					catch (RuntimeException e) {
						outputStream.reset();
						Resource csResource2 = new XMIResourceFactoryImpl().createResource(csResource.getURI().appendFileExtension("xmi"));
						csResource2.getContents().addAll(csResource.getContents());
						csResource2.save(outputStream, saveOptions);
						csResource.getContents().addAll(csResource2.getContents());
						BaseUiPluginHelper helper = BaseUiPluginHelper.INSTANCE;
						String title = helper.getString("_UI_SerializationFailure_title", true);
						String message = helper.getString("_UI_SerializationFailure_message", true);
						Status errorStatus = helper.createErrorStatus(e);
						ErrorDialog.openError(null, title, message, errorStatus);
						//						helper.log("2" + title, errorStatus);
						//						inputStream = new ByteArrayInputStream(outputStream.toByteArray());
						//						super.setDocumentContent(document, inputStream, encoding);
						//						throw e;
					}
					inputStream = new ByteArrayInputStream(outputStream.toByteArray());
				} catch (InvalidConcreteSyntaxException e) {
					diagnoseErrors((XtextResource) csResource, e);
				} catch (XtextSerializationException e) {
					diagnoseErrors((XtextResource) csResource, e);
				}
				csResource.unload();
				//				@SuppressWarnings("null")@NonNull String string = writer.toString();
				//				displayText = string;
				////				CS2ASResourceAdapter resourceAdapter = ((BaseCSResource)csResource).getCS2ASAdapter();
				////				resourceAdapter.dispose();
				csResourceSet.getResources().remove(csResource);
				//				inputStream = new ByteArrayInputStream(outputStream.toByteArray());
			}
			//			else if (sourceText.length() <= 0) {		// Empty document
			else if (inputStream.available() == 0) {		// Empty document
				URI uri = ClassUtil.nonNullState(uriMap.get(document));
				Resource.Factory factory = Resource.Factory.Registry.INSTANCE.getFactory(uri);
				if (factory instanceof OCLASResourceFactory) {
					persistAs = PERSIST_AS_PIVOT;
				}
				//				else if (factory instanceof UMLResourceFactoryImpl) {
				//					persistAs = PERSIST_AS_UML;
				//				}
				String lastSegment = uri.trimFileExtension().lastSegment();
				if (lastSegment == null) {
					lastSegment = "Default";
				}
				String testDocument = createTestDocument(uri, lastSegment);
				inputStream = new ByteArrayInputStream(testDocument.getBytes());
			}
			loadedAsMap.put(document, persistAs);
			saveAsMap.put(document, persistAs);
			//		} catch (ParserException e) {
			//			throw new CoreException(new Status(IStatus.ERROR, OCLExamplesCommonPlugin.PLUGIN_ID, "Failed to load", e));
			//		} catch (WrappedException e) {
			//			throw new CoreException(new Status(IStatus.ERROR, getPluginId(), "Failed to load", e.exception()));
		} catch (IOException e) {
			throwCoreException("Failed to load", e);
			/*		} catch (Throwable e) {
			Runnable displayRefresh = new Runnable() {
				@Override
				public void run() {
					StringWriter stringWriter = new StringWriter();
					PrintWriter pw = new PrintWriter(stringWriter);
					e.printStackTrace(pw);
					String string = stringWriter.toString().replace("\r", "");
					MessageDialog.openError(null, BaseUIMessages.LoadError_Title, string);
				}
			};
			Display.getDefault().asyncExec(displayRefresh);
			displayText = "/* Load failed * /";
			 */		}
		/*
		 * 		This fails to setup Xtext correctly: No state leads to NPE from EcoreUtil.resolveAll.
		 *
  		if (reload) {
			final InputStream finalInputStream = inputStream;
			((XtextDocument)document).modify(new IUnitOfWork<Object, XtextResource>() {

				public Object exec(XtextResource state) throws Exception {
					QVTimperativeDocumentProvider.super.setDocumentContent(document, finalInputStream, encoding);
					return null;
				}
			});
		}
		else { */
		super.setDocumentContent(document, inputStream, encoding);
		//		superSetDocumentText(document, displayText);
		//		}
	}

	@Override
	protected void setDocumentResource(XtextDocument xtextDocument, IEditorInput editorInput, String encoding) throws CoreException {
		String loadedAs = loadedAsMap.get(xtextDocument);
		boolean needModify = false;
		if (!isText(loadedAs) && (xtextDocument instanceof BaseDocument)) {
			EnvironmentFactoryInternal environmentFactory = ((BaseDocument)xtextDocument).basicGetEnvironmentFactory();
			if (environmentFactory != null) {
				needModify = true;
			}
		}
		if (!needModify) {
			super.setDocumentResource(xtextDocument, editorInput, encoding);
		}
		else {		// Fix Bug 573982 avoid concurrent load / reconcile
			xtextDocument.modify(new IUnitOfWork<Object, XtextResource>()
			{
				@Override
				public Object exec(XtextResource state) throws Exception {
					BaseCSorASDocumentProvider.super.setDocumentResource(xtextDocument, editorInput, encoding);
					return null;
				}
			});
		}
		assert loadedAs == loadedAsMap.get(xtextDocument);
		if (!isText(loadedAs)) {
			xtextDocument.readOnly(new IUnitOfWork<Object, XtextResource>()
			{
				@Override
				public Object exec(XtextResource state) throws Exception {
					if (state instanceof CSResourceExtension2) {
						((CSResourceExtension2)state).setDerived(true);
					}
					return null;
				}
			});
		}
	}

	public void setExportDelegateURI(Object element, String uri) {
		exportDelegateURIMap.put(getDocument(element), uri);
	}

	public void setPersistAs(Object element, String persistAs) {
		saveAsMap.put(getDocument(element), persistAs);
		setCanSaveDocument(element);
	}

	protected void superDoSaveDocument(IProgressMonitor monitor, Object element, IDocument document,
			boolean overwrite) throws CoreException {
		super.doSaveDocument(monitor, element, document, overwrite);
	}

	/**
	 * @deprecated no longer used - does nothing - retained for API compatibility
	 */
	@Deprecated
	protected void superSetDocumentText(@NonNull XtextDocument document, @NonNull String displayText) throws CoreException {}

	protected void superSetDocumentContent(IDocument document, InputStream inputStream, String encoding) throws CoreException {
		super.setDocumentContent(document, inputStream, encoding);
	}

	protected void throwCoreException(@NonNull String string, @Nullable Throwable e) throws CoreException {
		if (e != null) {
			StringWriter s = new StringWriter();
			PrintWriter pw = new PrintWriter(s);
			e.printStackTrace(pw);
			pw.close();
			throw new CoreException(new Status(IStatus.ERROR, getPluginId(), string + "\n" + s.toString(), e));
		}
		else {
			throw new CoreException(new Status(IStatus.ERROR, getPluginId(), string));
		}
	}
}
