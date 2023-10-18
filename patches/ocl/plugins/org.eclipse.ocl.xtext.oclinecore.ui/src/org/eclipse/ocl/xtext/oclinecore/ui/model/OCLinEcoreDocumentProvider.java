/*******************************************************************************
 * Copyright (c) 2010, 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.oclinecore.ui.model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.internal.delegate.DelegateInstaller;
import org.eclipse.ocl.pivot.internal.ecore.es2as.Ecore2AS;
import org.eclipse.ocl.pivot.internal.resource.OCLASResourceFactory;
import org.eclipse.ocl.pivot.internal.resource.StandaloneProjectMap;
import org.eclipse.ocl.pivot.internal.utilities.PivotConstantsInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.CSResource;
import org.eclipse.ocl.pivot.uml.internal.es2as.UML2AS;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.XMIUtil;
import org.eclipse.ocl.xtext.base.ui.model.BaseCSorASDocumentProvider;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.oclinecore.ui.OCLinEcoreUiModule;
import org.eclipse.ocl.xtext.oclinecore.ui.OCLinEcoreUiPluginHelper;
import org.eclipse.ocl.xtext.oclinecorecs.OCLinEcoreCSPackage;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.xtext.parsetree.reconstr.XtextSerializationException;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.validation.IConcreteSyntaxValidator.InvalidConcreteSyntaxException;

/**
 * OCLinEcoreDocumentProvider orchestrates the load and saving of optional XMI content
 * externally while maintaining the serialised human friendly form internally.
 */
public class OCLinEcoreDocumentProvider extends BaseCSorASDocumentProvider
{		// FIXME share more code with BaseCSorASDocumentProvider
	private static final Logger log = LogManager.getLogger(OCLinEcoreDocumentProvider.class);

	public static final String PERSIST_AS_ECORE = "as-ecore";
	public static final String PERSIST_IN_ECORE = "in-ecore";
	//	public static final String PERSIST_AS_PIVOT = "pivot";
	public static final String PERSIST_AS_OCLINECORE = "oclinecore";
	public static final String PERSIST_AS_UML = "uml";

	@Override
	protected @NonNull String createTestDocument(@NonNull URI uri, @NonNull String lastSegment) {
		return "package " + lastSegment + " : pfx = '"+ uri + "' {\n" + "}\n";
	}

	private void diagnoseErrors(Resource resource) throws CoreException {
		List<Resource.Diagnostic> errors = resource.getErrors();
		if (errors.size() > 0) {
			String formattedMessage = PivotUtil.formatResourceDiagnostics(errors, "Failed to load", "\n");
			throw new CoreException(new Status(IStatus.ERROR, OCLinEcoreUiModule.PLUGIN_ID, formattedMessage));
		}
	}

	@Override
	protected void doSaveDocument(IProgressMonitor monitor, Object element, IDocument document, boolean overwrite) throws CoreException {
		String saveAs = saveAsMap.get(document);
		if ((element instanceof IFileEditorInput) && (document instanceof OCLinEcoreDocument) && !PERSIST_AS_OCLINECORE.equals(saveAs)) {
			StringWriter xmlWriter = new StringWriter();
			try {
				ASResource asResource = ((OCLinEcoreDocument) document).getASResource();
				URI uri = EditUIUtil.getURI((IFileEditorInput)element);
				if (asResource != null) {
					EcoreUtil.resolveAll(asResource);
				}
				if (uri == null) {
					log.warn("No URI");
				}
				else if (PERSIST_AS_ECORE.equals(saveAs)) {
					((OCLinEcoreDocument) document).saveAsEcore(xmlWriter, uri, exportDelegateURIMap.get(document));
				}
				else if (PERSIST_IN_ECORE.equals(saveAs)) {
					((OCLinEcoreDocument) document).saveInEcore(xmlWriter, uri, exportDelegateURIMap.get(document));
				}
				else if (PERSIST_AS_PIVOT.equals(saveAs)) {
					URI savedURI = asResource != null ? asResource.getURI() : null;
					try {
						if (asResource != null) {
							asResource.setURI(uri);						// Tweak URI for simple EMF save
						}
						((OCLinEcoreDocument) document).saveAsPivot(xmlWriter);		// FIXME localize/avoid uri tweak
					}
					finally {
						if ((asResource != null) && (savedURI != null)) {
							asResource.setURI(savedURI);				// Restore URI after simple EMF save
						}
					}
				}
				else if (PERSIST_AS_UML.equals(saveAs)) {
					((OCLinEcoreDocument) document).saveAsUML(xmlWriter, uri);
				}
				else {
					log.warn("Unknown saveAs '" + saveAs + "'");
				}
				IDocument saveDocument = new Document();
				saveDocument.set(xmlWriter.toString());
				super.doSaveDocument(monitor, element, saveDocument, overwrite);
				loadedAsMap.put(document, saveAs);
			} catch (Exception e) {
				OCLinEcoreUiPluginHelper helper = OCLinEcoreUiPluginHelper.INSTANCE;
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

	@Override
	protected String getCScontentType() {
		return OCLinEcoreCSPackage.eCONTENT_TYPE;
	}

	@Override
	protected @NonNull String getFileExtension() {
		return "oclinecore";
	}

	@Override
	protected String getPluginId() {
		return OCLinEcoreUiModule.PLUGIN_ID;
	}

	@Override
	protected boolean isText(String loadedAs) {
		return PERSIST_AS_OCLINECORE.equals(loadedAs) || super.isText(loadedAs);
	}

	@Override
	protected void setDocumentContent(IDocument document, InputStream inputStream, String encoding) throws CoreException {
		boolean reload = false;
		//		@NonNull String displayText = sourceText;
		try {
			//			String xmlEncoding = URIConverter.ReadableInputStream.getEncoding(sourceText);
			if (!inputStream.markSupported()) {
				inputStream = createResettableInputStream(inputStream);
			}
			boolean isXML = isXML(inputStream, encoding);
			String persistAs = PERSIST_AS_OCLINECORE;
			if (isXML) {
				ResourceSet esResourceSet = getEnvironmentFactory().getResourceSet();
				StandaloneProjectMap projectMap = StandaloneProjectMap.getAdapter(esResourceSet);
				StandaloneProjectMap.IConflictHandler conflictHandler = StandaloneProjectMap.MapToFirstConflictHandlerWithLog.INSTANCE; //null; 			// FIXME
				projectMap.configure(esResourceSet, StandaloneProjectMap.LoadFirstStrategy.INSTANCE, conflictHandler);
				StandaloneProjectMap.IProjectDescriptor pivotPackageDescriptor = projectMap.getProjectDescriptor(PivotConstantsInternal.PLUGIN_ID);
				if (pivotPackageDescriptor != null) {
					pivotPackageDescriptor.configure(esResourceSet, StandaloneProjectMap.LoadBothStrategy.INSTANCE, conflictHandler);
				}
				URI uri = uriMap.get(document);
				XMLResource xmiResource = (XMLResource) esResourceSet.getResource(uri, false);
				if ((xmiResource == null) || (xmiResource.getResourceSet() == null)) {	// Skip built-ins and try again as a file read.
					xmiResource = (XMLResource) esResourceSet.createResource(uri, null);
				}
				else {
					xmiResource.unload();
					reload = true;
				}
				//				xmiResource.load(new InputSource(new StringReader(sourceText)), null);
				xmiResource.load(inputStream, null);
				EcoreUtil.resolveAll(esResourceSet);
				List<Resource.Diagnostic> allErrors = null;
				for (Resource resource : esResourceSet.getResources()) {
					List<Resource.Diagnostic> errors = resource.getErrors();
					if (errors.size() > 0) {
						if (allErrors == null) {
							allErrors = new ArrayList<Resource.Diagnostic>();
						}
						allErrors.addAll(errors);
					}
				}
				if (allErrors != null) {
					StringBuilder s = new StringBuilder();
					for (Resource.Diagnostic diagnostic : allErrors) {
						s.append("\n");
						s.append(diagnostic.toString());
					}
					throwCoreException(s.toString(), null);
				}
				ASResource asResource = null;
				EList<EObject> contents = xmiResource.getContents();
				if (contents.size() > 0) {
					EObject xmiRoot = contents.get(0);
					if (xmiRoot instanceof EPackage) {
						Ecore2AS ecore2as = Ecore2AS.getAdapter(xmiResource, getEnvironmentFactory());
						Model pivotModel = ecore2as.getASModel();
						asResource = (ASResource) pivotModel.eResource();
						if (asResource != null) {
							if (reload) {
								ecore2as.update(asResource, contents);
							}
							diagnoseErrors(asResource);		// FIXME On reload, this throws a CoreException which loses the user's source text
						}
						persistAs = PERSIST_AS_ECORE;
						exportDelegateURIMap.put(document, DelegateInstaller.getDelegateURI(contents));
					}
					else if (xmiRoot instanceof Model) {
						asResource = (ASResource) xmiResource;
						persistAs = PERSIST_AS_PIVOT;
					}
					else if (xmiRoot instanceof org.eclipse.uml2.uml.Package) {
						UML2AS uml2as = UML2AS.getAdapter(xmiResource, getEnvironmentFactory());
						Model pivotModel = uml2as.getASModel();
						asResource = (ASResource) pivotModel.eResource();
						persistAs = PERSIST_AS_OCLINECORE;		// FIXME
					}
					// FIXME general extensibility
				}
				if (asResource == null) {
					throwCoreException("Failed to load", null);
					return; 	// never happens
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
				//		QVTimperative CS resource with *.ecore URI, in URIResourceMap as *.ecore.oclinecore
				//
				csResource.updateFrom(asResource, getOCL().getEnvironmentFactory());
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				//				StringWriter writer = new StringWriter();
				try {
					//					csResource.save(new URIConverter.WriteableOutputStream(writer, xmlEncoding), null);
					Map<Object, Object> saveOptions = XMIUtil.createPivotSaveOptions();
					csResource.save(outputStream, saveOptions);
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
				((BaseCSResource)csResource).dispose();
				csResourceSet.getResources().remove(csResource);
				inputStream = new ByteArrayInputStream(outputStream.toByteArray());
			}
			//			else if (sourceText.length() <= 0) {		// Empty document
			else if (inputStream.available() == 0) {		// Empty document
				URI uri = ClassUtil.nonNullState(uriMap.get(document));
				Resource.Factory factory = Resource.Factory.Registry.INSTANCE.getFactory(uri);
				if (factory instanceof EcoreResourceFactoryImpl) {
					persistAs = PERSIST_AS_ECORE;
				}
				else if (factory instanceof OCLASResourceFactory) {
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
		} catch (ParserException e) {
			throwCoreException("Failed to load", e);
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
		superSetDocumentContent(document, inputStream, encoding);
		//		superSetDocumentText(document, displayText);
		//		}
	}
}
