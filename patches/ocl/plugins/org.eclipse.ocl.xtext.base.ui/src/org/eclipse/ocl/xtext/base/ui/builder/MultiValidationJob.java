/*******************************************************************************
 * Copyright (c) 2017, 2021 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation based on org.eclipse.xtext.builder.nature.XtextNature
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.ui.builder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.ui.EMFEditUIPlugin;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotDiagnostician;
import org.eclipse.ocl.pivot.internal.utilities.PivotDiagnostician.BasicDiagnosticWithRemove;
import org.eclipse.ocl.pivot.resource.CSResource;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.LabelUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.ThreadLocalExecutor;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.ocl.xtext.base.ui.BaseUiModule;
import org.eclipse.ocl.xtext.base.ui.BaseUiPluginHelper;
import org.eclipse.ocl.xtext.base.ui.messages.BaseUIMessages;
import org.eclipse.ocl.xtext.base.utilities.PivotDiagnosticConverter;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.IDiagnosticConverter;
import org.eclipse.xtext.validation.Issue;
import org.osgi.framework.Bundle;
import org.osgi.framework.wiring.BundleWiring;

/**
 * A MultiValidationJob maintains a queue of workspaceRelativeFileNames in need of validation.
 *
 * Validations are performed in a separate job from the builder since the success/failure of an OCL validation
 * does not need to force users to wait as occurs for builder active.
 */
public class MultiValidationJob extends Job
{
	public static final @NonNull TracingOption VALIDATOR = new TracingOption(BaseUiPluginHelper.PLUGIN_ID, "validator");

	/**
	 * An AddMarkersOperation accumulates the future markers for an IResource via the accept methods.
	 * Old markers are deleted and the new markers are installed by a single execution per resource.
	 */
	protected static class AddMarkersOperation extends WorkspaceModifyOperation implements IAcceptor<@NonNull Issue>
	{
		protected final @NonNull IResource resource;
		protected final @NonNull String issueMarkerType;
		protected final @NonNull List<@NonNull MarkerData> markerDatas = new ArrayList<>();

		public AddMarkersOperation(@NonNull IResource resource, @NonNull String issueMarkerType) {
			this.resource = resource;
			this.issueMarkerType = issueMarkerType;
		}

		public void accept(@NonNull Diagnostic diagnostic, @Nullable Diagnostic parentDiagnostic) {
			if (diagnostic.getSeverity() != Diagnostic.OK) {
				markerDatas.add(new DiagnosticMarkerData(diagnostic, issueMarkerType, parentDiagnostic));
			}
		}

		public void accept(Resource.@NonNull Diagnostic diagnostic, int severity) {
			markerDatas.add(new ResourceDiagnosticMarkerData(diagnostic, issueMarkerType, severity));
		}

		@Override
		public void accept(@NonNull Issue issue) {
			markerDatas.add(new IssueMarkerData(resource, issueMarkerType, issue));
		}

		public void addMessage(/*@NonNull*/ String markerType, int severity, @NonNull String message) {
			assert markerType != null;
			markerDatas.add(new SimpleMarkerData(markerType, severity, message));
		}

		@Override
		protected void execute(final IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
			if (!resource.exists()) {
				return;
			}
			resource.deleteMarkers(issueMarkerType, true, IResource.DEPTH_INFINITE);
			for (@NonNull MarkerData markerData : markerDatas) {
				if (monitor.isCanceled()) {
					return;
				}
				markerData.createMarker(resource);
			}
		}

		public @NonNull List<@NonNull MarkerData> getMarkerDatas() {
			return markerDatas;
		}

		public boolean isEMF() {
			return issueMarkerType == EValidator.MARKER;
		}
	}

	public interface MarkerData
	{
		@NonNull IMarker createMarker(@NonNull IResource resource) throws CoreException;

		@NonNull String getMessageText();
	}

	/**
	 * A DiagnosticMarkerData describes the future Marker created from a Diagnostic.
	 */
	//This class is based on org.eclipse.emf.edit.ui.action.ValidateAction.EclipseResourcesUtil
	protected static class DiagnosticMarkerData /*extends ValidateAction.EclipseResourcesUtil*/ implements MarkerData
	{
		protected final @NonNull String markerType;
		protected final @NonNull Object severity;
		protected final /*@NonNull*/ String message;
		protected @Nullable String location = null;
		protected /*@NonNull*/ Integer lineNumber = null;
		protected @Nullable String uriAttribute = null;
		protected final @Nullable String relatedURIsAttribute;

		public DiagnosticMarkerData(@NonNull Diagnostic diagnostic, @NonNull String markerType, @Nullable Diagnostic parentDiagnostic) {
			this.markerType = markerType;
			//
			//	MarkerHelper.createMarkers
			//
			int severity = diagnostic.getSeverity();
			if (severity < Diagnostic.WARNING) {
				this.severity = IMarker.SEVERITY_INFO;
			}
			else if (severity < Diagnostic.ERROR) {
				this.severity = IMarker.SEVERITY_WARNING;
			}
			else {
				this.severity = IMarker.SEVERITY_ERROR;
			}
			//			this.message = composeMessage(diagnostic, parentDiagnostic);
			this.message = diagnostic.getMessage();
			//
			//	Logic from EditUIMarkerHelper.adjustMarker
			//
			List<?> data = diagnostic.getData();
			if ((data == null) && (parentDiagnostic != null)) {
				data = parentDiagnostic.getData();
			}
			StringBuilder relatedURIs = null;
			if (data != null) {
				boolean first = true;
				for (Object element : data) {
					if (element instanceof EObject)		// ValidateAction.adjustMarker
					{
						EObject eObject = (EObject)element;
						if (first) {
							first = false;
							uriAttribute = EcoreUtil.getURI(eObject).toString();
						}
						else
						{
							if (relatedURIs == null) {
								relatedURIs = new StringBuilder();
							}
							else {
								relatedURIs.append(' ');
							}
							relatedURIs.append(URI.encodeFragment(EcoreUtil.getURI(eObject).toString(), false));
						}
					}
					else if (element instanceof Resource.Diagnostic) {		// FIXME is this needed?
						Resource.Diagnostic resourceDiagnostic = (Resource.Diagnostic)element;
						if (resourceDiagnostic.getLocation() != null) {
							String lineString = Integer.toString(resourceDiagnostic.getLine());
							String columnString = Integer.toString(resourceDiagnostic.getColumn());
							this.location = EMFEditUIPlugin.getPlugin().getString("_UI_MarkerLocation", new String[] { lineString, columnString });
							this.lineNumber = resourceDiagnostic.getLine();
							try {
								Method getObjectMethod = resourceDiagnostic.getClass().getMethod("getObject");
								Object object = getObjectMethod.invoke(resourceDiagnostic);
								if (object instanceof EObject) {
									this.uriAttribute = EcoreUtil.getURI((EObject)object).toString();
									Method getFeatureMethod = resourceDiagnostic.getClass().getMethod("getFeature");
									Object feature = getFeatureMethod.invoke(resourceDiagnostic);
									if (feature instanceof EObject)
									{
										if (relatedURIs == null) {
											relatedURIs = new StringBuilder();
										}
										else {
											relatedURIs.append(' ');
										}
										relatedURIs.append(URI.encodeFragment(EcoreUtil.getURI((EObject)feature).toString(), false));
									}
								}
							}
							catch (Throwable throwable) {
								// Ignore.
							}
							break;
						}
					}
				}
			}
			this.relatedURIsAttribute = relatedURIs != null ? relatedURIs.toString() : null;
		}

		@Override
		public @NonNull IMarker createMarker(@NonNull IResource resource) throws CoreException {
			IMarker marker = resource.createMarker(markerType);
			marker.setAttribute(IMarker.LOCATION, location);
			marker.setAttribute(IMarker.SEVERITY, severity);
			marker.setAttribute(IMarker.LINE_NUMBER, lineNumber);
			marker.setAttribute(IMarker.MESSAGE, message);
			if (uriAttribute != null) {
				marker.setAttribute(EValidator.URI_ATTRIBUTE, uriAttribute);
			}
			if (relatedURIsAttribute != null) {
				marker.setAttribute(EValidator.RELATED_URIS_ATTRIBUTE, relatedURIsAttribute);
			}
			return marker;
		}

		@Override
		public @NonNull String getMessageText() {
			return String.valueOf(message);
		}
	}

	/**
	 * An IssueMarkerData describes the future Marker created from an Issue.
	 */
	//This class is based on org.eclipse.xtext.ui.editor.validation.MarkerCreator
	protected static class IssueMarkerData implements MarkerData
	{
		//		private static final String FIXABLE_KEY = "FIXABLE_KEY";		// FIXME this is MarkerCreator.FIXABLE_KEY

		protected final @NonNull String markerType;
		protected final @NonNull String location;
		protected final /*@NonNull*/ String codeKey;
		protected final @NonNull Object severity;
		protected final /*@NonNull*/ Integer charStart;
		protected @Nullable Integer charEnd;
		protected final /*@NonNull*/ Integer lineNumber;
		protected final /*@NonNull*/ Integer columnKey;
		protected final /*@NonNull*/ String message;
		protected @Nullable String uriKey;
		protected @Nullable String dataKey;
		//		protected final @Nullable Boolean fixableKey;
		protected final @Nullable String uriAttribute;
		protected @Nullable String relatedURIsAttribute = null;

		public IssueMarkerData(@NonNull IResource resource, @NonNull String markerType, @NonNull Issue issue) {
			this.markerType = markerType;
			String lineNR = "";
			if (issue.getLineNumber() != null) {
				lineNR = "line: " + issue.getLineNumber() + " ";
			}
			this.location = lineNR + resource.getFullPath().toString();
			this.codeKey = issue.getCode();
			switch (issue.getSeverity()) {
				case ERROR : this.severity = IMarker.SEVERITY_ERROR; break;
				case WARNING : this.severity = IMarker.SEVERITY_WARNING; break;
				case INFO : this.severity = IMarker.SEVERITY_INFO; break;
				default: throw new IllegalArgumentException(String.valueOf(issue.getSeverity()));
			}
			this.charStart = issue.getOffset();
			if (issue.getOffset() != null && issue.getLength() != null) {
				this.charEnd = issue.getOffset() + issue.getLength();
			}
			this.lineNumber = issue.getLineNumber();
			this.columnKey = issue.getColumn();
			this.message = issue.getMessage();
			if (issue.getUriToProblem() != null) {
				this.uriKey = issue.getUriToProblem().toString();
			}
			if (issue.getData() != null && issue.getData().length > 0) {
				this.dataKey = Strings.pack(issue.getData());
			}
			//	if (resolutionProvider != null && resolutionProvider.hasResolutionFor(issue.getCode())) {
			//		attributeKey2value.put(FIXABLE_KEY, true);
			//	}
			String[] data = issue.getData();
			StringBuilder relatedURIs = null;
			String uriAttribute = null;
			boolean first = true;
			if (data != null) {
				for (String string : data) {
					if (first) {
						first = false;
						uriAttribute = string;
					}
					else {
						if (relatedURIs == null) {
							relatedURIs = new StringBuilder();
						}
						else {
							relatedURIs.append(' ');
						}
						relatedURIs.append(URI.encodeFragment(string, false));
					}
				}
			}
			this.uriAttribute = uriAttribute;
			if (relatedURIs != null) {
				this.relatedURIsAttribute = relatedURIs.toString();
			}
		}

		@Override
		public @NonNull IMarker createMarker(@NonNull IResource resource) throws CoreException {
			IMarker marker = resource.createMarker(markerType);
			marker.setAttribute(IMarker.LOCATION, location);
			marker.setAttribute(Issue.CODE_KEY, codeKey);
			marker.setAttribute(IMarker.SEVERITY, severity);
			marker.setAttribute(IMarker.CHAR_START, charStart);
			if (charEnd != null) {
				marker.setAttribute(IMarker.CHAR_END, charEnd);
			}
			marker.setAttribute(IMarker.LINE_NUMBER, lineNumber);
			marker.setAttribute(Issue.COLUMN_KEY, columnKey);
			marker.setAttribute(IMarker.MESSAGE, message);
			if (uriKey != null) {
				marker.setAttribute(Issue.URI_KEY, uriKey);
			}
			if (dataKey != null) {
				marker.setAttribute(Issue.DATA_KEY, dataKey);
			}
			//			if (fixableKey != null) {
			//				marker.setAttribute(FIXABLE_KEY, fixableKey);
			//			}
			if (uriAttribute != null) {
				marker.setAttribute(EValidator.URI_ATTRIBUTE, uriAttribute);
			}
			if (relatedURIsAttribute != null) {
				marker.setAttribute(EValidator.RELATED_URIS_ATTRIBUTE, relatedURIsAttribute);
			}
			return marker;
		}

		@Override
		public @NonNull String getMessageText() {
			return String.valueOf(message);
		}
	}

	/**
	 * A DiagnosticMarkerData describes the future Marker created from a Diagnostic.
	 */
	//This class is based on org.eclipse.emf.edit.ui.util.EditUIMarkerHelper
	protected static class ResourceDiagnosticMarkerData implements MarkerData
	{
		protected final @NonNull String markerType;
		protected final @NonNull Object severity;
		protected final /*@NonNull*/ String message;
		protected @Nullable String location = null;
		protected /*@NonNull*/ Integer lineNumber = null;
		protected @Nullable String uriAttribute = null;
		protected final @Nullable String relatedURIsAttribute;

		public ResourceDiagnosticMarkerData(Resource.@NonNull Diagnostic diagnostic, @NonNull String markerType, int severity) {
			this.markerType = markerType;
			//
			//	MarkerHelper.createMarkers
			//
			if (severity < Diagnostic.WARNING) {
				this.severity = IMarker.SEVERITY_INFO;
			}
			else if (severity < Diagnostic.ERROR) {
				this.severity = IMarker.SEVERITY_WARNING;
			}
			else {
				this.severity = IMarker.SEVERITY_ERROR;
			}
			//			this.message = composeMessage(diagnostic, parentDiagnostic);
			this.message = diagnostic.getMessage();
			String relatedURIsAttribute = null;
			if (diagnostic.getLocation() != null) {
				String lineString = Integer.toString(diagnostic.getLine());
				String columnString = Integer.toString(diagnostic.getColumn());
				this.location = EMFEditUIPlugin.getPlugin().getString("_UI_MarkerLocation", new String[] { lineString, columnString });
				this.lineNumber = diagnostic.getLine();
				try {
					Method getObjectMethod = diagnostic.getClass().getMethod("getObject");
					Object object = getObjectMethod.invoke(diagnostic);
					if (object instanceof EObject)
					{
						this.uriAttribute = EcoreUtil.getURI((EObject)object).toString();
						Method getFeatureMethod = diagnostic.getClass().getMethod("getFeature");
						Object feature = getFeatureMethod.invoke(diagnostic);
						if (feature instanceof EObject) {
							relatedURIsAttribute = EcoreUtil.getURI((EObject)feature).toString();
						}
					}
				}
				catch (Throwable throwable) {
					// Ignore.
				}
			}
			this.relatedURIsAttribute = relatedURIsAttribute;
		}

		@Override
		public @NonNull IMarker createMarker(@NonNull IResource resource) throws CoreException {
			IMarker marker = resource.createMarker(markerType);
			marker.setAttribute(IMarker.LOCATION, location);
			marker.setAttribute(IMarker.SEVERITY, severity);
			marker.setAttribute(IMarker.LINE_NUMBER, lineNumber);
			marker.setAttribute(IMarker.MESSAGE, message);
			if (uriAttribute != null) {
				marker.setAttribute(EValidator.URI_ATTRIBUTE, uriAttribute);
			}
			if (relatedURIsAttribute != null) {
				marker.setAttribute(EValidator.RELATED_URIS_ATTRIBUTE, relatedURIsAttribute);
			}
			return marker;
		}

		@Override
		public @NonNull String getMessageText() {
			return String.valueOf(message);
		}
	}

	/**
	 * A SimpleMarkerData describes the future Marker for a simple message.
	 */
	protected static class SimpleMarkerData implements MarkerData
	{
		protected final @NonNull String markerType;
		protected final @NonNull Object severity;
		protected final @NonNull String message;

		public SimpleMarkerData(@NonNull String markerType, int severity, @NonNull String message) {
			this.markerType = markerType;
			this.severity = severity;
			this.message = message;
		}

		@Override
		public @NonNull IMarker createMarker(@NonNull IResource resource) throws CoreException {
			IMarker marker = resource.createMarker(markerType);
			marker.setAttribute(IMarker.SEVERITY, severity);
			marker.setAttribute(IMarker.MESSAGE, message);
			return marker;
		}

		@Override
		public @NonNull String getMessageText() {
			return message;
		}
	}

	/**
	 * ValidationQueue ensures that all accesses to the inter-thread queue are synchronized.
	 */
	private static final class ValidationQueue
	{
		private final @NonNull Set<@NonNull ValidationEntry> queue = new HashSet<>();

		public synchronized boolean addAll(@NonNull Iterable<@NonNull ValidationEntry> entries) {
			boolean added = false;
			for (@NonNull ValidationEntry entry : entries) {
				if (queue.add(entry)) {
					added = true;
				}
			}
			return added;
		}

		public synchronized void clear() {
			queue.clear();
		}

		public synchronized @NonNull List<@NonNull ValidationEntry> getValidationList() {
			return new ArrayList<>(queue);
		}

		public synchronized void remove(@NonNull ValidationEntry entry) {
			queue.remove(entry);
		}
	}

	private static final Logger log = LogManager.getLogger(MultiValidationJob.class);
	private static final @NonNull IDiagnosticConverter converter = new PivotDiagnosticConverter();

	private final @NonNull ValidationQueue validationQueue = new ValidationQueue();

	public MultiValidationJob() {
		super(BaseUIMessages.MultiValidationJob_Name);
//        ResourceSetImpl.liveResourceSets = new WeakHashMap<>();
//    	PivotMetamodelManager.liveMetamodelManagers = new WeakHashMap<>();
//		StandaloneProjectMap.liveStandaloneProjectMaps = new WeakHashMap<>();
	}

	/**
	 * Add the files to the queue of validations. If the validation job is not
	 * already running, it is scheduled to run.
	 */
	public void addValidations(@NonNull Iterable<@NonNull ValidationEntry> entries) {
		if (validationQueue.addAll(entries)) {
			int state = getState();
			if (state == Job.NONE) {
				schedule();
			}
		}
	}

	@Override
	protected synchronized void canceling() {
		validationQueue.clear();
		super.canceling();
	}

	protected boolean checkResourceErrors(@NonNull AddMarkersOperation operation, @NonNull Resource resource, @NonNull IProgressMonitor monitor) {
		if (operation.isEMF()) {
			for (Resource.@NonNull Diagnostic error : resource.getErrors()) {
				if (monitor.isCanceled()) {
					return false;
				}
				operation.accept(error, Diagnostic.ERROR);
			}
			for (Resource.@NonNull Diagnostic warning : resource.getWarnings()) {
				if (monitor.isCanceled()) {
					return false;
				}
				operation.accept(warning, Diagnostic.WARNING);
			}
		}
		else {
			for (Resource.@NonNull Diagnostic error : resource.getErrors()) {
				if (monitor.isCanceled()) {
					return false;
				}
				converter.convertResourceDiagnostic(error, Severity.ERROR, operation);
			}
			for (Resource.@NonNull Diagnostic warning : resource.getWarnings()) {
				if (monitor.isCanceled()) {
					return false;
				}
				converter.convertResourceDiagnostic(warning, Severity.WARNING, operation);
			}
		}
		return true;
	}

	protected boolean checkValidatorDiagnostics(@NonNull AddMarkersOperation operation, @NonNull Resource resource, @NonNull IProgressMonitor monitor) {
		Map<Object, Object> validationContext = LabelUtil.createDefaultContext(Diagnostician.INSTANCE);
		BasicDiagnostic diagnostics = new BasicDiagnosticWithRemove(EObjectValidator.DIAGNOSTIC_SOURCE, 0, EcorePlugin.INSTANCE.getString("_UI_DiagnosticRoot_diagnostic", new Object[] { resource.getURI() }), new Object [] { resource });
		ResourceSet resourceSet = resource.getResourceSet();
		assert resourceSet != null;
		Diagnostician instance = PivotDiagnostician.createDiagnostician(resourceSet, EValidator.Registry.INSTANCE, null/*adapterFactory*/, monitor);
		for (EObject eObject : resource.getContents()) {
			if (monitor.isCanceled()) {
				return false;
			}
			instance.validate(eObject, diagnostics, validationContext);
		}
		convertValidatorDiagnostics(operation, diagnostics, null);
		return true;
	}

	protected void convertValidatorDiagnostics(@NonNull AddMarkersOperation operation, @NonNull Diagnostic diagnostic, @Nullable Diagnostic parentDiagnostic) {
		//
		// The logic here replicates that in the Runnable body of MarkerHelper.createMarkers
		//
		if (diagnostic.getChildren().isEmpty()) {
			operation.accept(diagnostic, null);
		}
		else {
			List<@NonNull Diagnostic> childDiagnostics = ClassUtil.nullFree(diagnostic.getChildren());
			if (diagnostic.getMessage() == null) {
				for (Diagnostic childDiagnostic : childDiagnostics) {
					convertValidatorDiagnostics(operation, childDiagnostic, null);
				}
			}
			else {
				for (Diagnostic childDiagnostic : childDiagnostics) {
					operation.accept(childDiagnostic, diagnostic);
				}
			}
		}
	}

	protected void doValidate(final @NonNull ValidationEntry entry, @NonNull SubMonitor monitor) throws CoreException {
		Throwable throwable = null;
		AddMarkersOperation operation = null;
		try {
			final @NonNull IFile file = entry.getFile();
			IProject project = file.getProject();
			if ((project == null) || !project.isOpen()) {
				return;
			}
			ThreadLocalExecutor.reset();
			//
			//	Ensure entry's project's class loader is useable (to resolve JavaClassCS references)
			//
			OCL ocl = entry.createOCL();
			EnvironmentFactory environmentFactory = ocl.getEnvironmentFactory();
			ClassLoader classLoader = getClassLoader(project);
			if (classLoader != null) {
				((MetamodelManagerInternal)environmentFactory.getMetamodelManager()).addClassLoader(classLoader);
			}
			monitor.worked(1);			// Work Item 1 - Initialize done
			final @NonNull String markerType = entry.getMarkerId();
			URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			//		System.out.println("OCL:Validating " + uri.toString());
			ResourceSet resourceSet = ocl.getResourceSet();
			Resource resource = null;
			try {
				resource = resourceSet.getResource(uri, true);
			}
			catch (Exception e) {
				throwable = e;
			}
			monitor.worked(1);			// Work Item 2 - Load done
			operation = new AddMarkersOperation(file, markerType);
			if (resource != null) {
				EcoreUtil.resolveAll(resourceSet);
				monitor.worked(3);			// Work Item 3 - Resolve done
				if (!checkResourceErrors(operation, resource, monitor)) {
					return;
				}
				if (resource instanceof CSResource) {
					Resource asResource = ((CSResource)resource).getASResource();
					if (!checkResourceErrors(operation, asResource, monitor)) {
						return;
					}
					if (!checkValidatorDiagnostics(operation, asResource, monitor)) {
						return;
					}
					// FIXME accumulate/cache dependencies
				}
				else {
					if (!checkValidatorDiagnostics(operation, resource, monitor)) {
						return;
					}
				}
			} else {
				monitor.worked(1);			// Work Item 3 - Resolve 'done'
				operation.addMessage(BaseUiModule.MARKER_ID, IMarker.SEVERITY_ERROR, "Failed to create EMF Resource for '" + uri + "'");
			}
			monitor.worked(1);			// Work Item 4 - Validate 'done'
			try {
				operation.run(monitor);
			} catch (InvocationTargetException e) {
				log.error("Could not create marker.", e);
			} catch (InterruptedException e) {
				// cancelled by user; ok
			}
			monitor.worked(1);			// Work Item 5 - Add Markers 'done'
			ocl.dispose();
			ThreadLocalExecutor.reset();
		}
		catch (Throwable e) {
			if (throwable == null) {
				throwable = e;
			}
			throw e;
		}
		finally {
			synchronized (entry) {
				if (throwable != null) {
					if (throwable instanceof WrappedException) {
						entry.setThrowable(((WrappedException)throwable).getCause());
					}
					else {
						entry.setThrowable(throwable);
					}
				}
				else if (operation != null) {
					entry.setMarkerDatas(operation.getMarkerDatas());
				}
				entry.notifyAll();
			}
			ThreadLocalExecutor.reset();
		}
	}

	/**
	 * Return the ClassLoader for the bundle/workspace project.
	 */
	protected @Nullable ClassLoader getClassLoader(@NonNull IProject project) throws CoreException {
		Bundle bundle = Platform.getBundle(project.getName());
		if (bundle != null) {
			BundleWiring bundleWiring = bundle.adapt(BundleWiring.class);
			if (bundleWiring != null) {
				return bundleWiring.getClassLoader();
			}
			else {
				return null;
			}
		}
		else { // from org.eclipse.jdt.internal.compiler.apt.util.EclipseFileManager.getClassLoader
			   // and https://sdqweb.ipd.kit.edu/wiki/JDT_Tutorial:_Class_Loading_in_a_running_plugin

			IJavaProject javaProject = JavaCore.create(project);
			String[] defaultRuntimeClassPath= null;
			try {
				defaultRuntimeClassPath = JavaRuntime.computeDefaultRuntimeClassPath(javaProject);
			}
			catch (JavaModelException e) {
				// maybe not a Java project
			}
			if (defaultRuntimeClassPath == null) {
				return null;
			}
			List<@NonNull URL> urlList = new ArrayList<>();
			for (String classPathEntry : defaultRuntimeClassPath) {
				IPath classPathEntryPath = new Path(classPathEntry);
				java.net.URI classPathEntryURI = classPathEntryPath.toFile().toURI();
				try {
					urlList.add(classPathEntryURI.toURL());
				}
				catch (MalformedURLException e) {
					// the url is malformed - this should not happen
					throw new RuntimeException(e);
				}
			}
			@NonNull URL[] urlArray = urlList.toArray(new @NonNull URL[urlList.size()]);
			return new URLClassLoader(urlArray, javaProject.getClass().getClassLoader());
		}
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		List<@NonNull ValidationEntry> validationList;
		while (!(validationList = validationQueue.getValidationList()).isEmpty()) {
			SubMonitor subMonitor = SubMonitor.convert(monitor, 5 * validationList.size());
			//			System.out.println(Thread.currentThread().getName() + " " + NameUtil.debugSimpleName(subMonitor) + " converted from: " + NameUtil.debugSimpleName(monitor));
			Collections.sort(validationList, NameUtil.TO_STRING_COMPARATOR);
			for (@NonNull ValidationEntry entry : validationList) {
				if (subMonitor.isCanceled()) {
					return Status.CANCEL_STATUS;
				}
				long start = System.currentTimeMillis();
				try {
					String message = NLS.bind(BaseUIMessages.MultiValidationJob_Validating, entry.getFile().getFullPath().toString());
//					if (VALIDATOR.isActive()) {
//						VALIDATOR.println(Thread.currentThread().getName() + " " + NameUtil.debugSimpleName(subMonitor) + " subTask: " + message);
//						VALIDATOR.println(entry.getFile().getFullPath().toString());
//					}
					subMonitor.subTask(message);
					doValidate(entry, subMonitor);
				} catch (OperationCanceledException canceled) {
					return Status.CANCEL_STATUS;
				} catch (Throwable e) {
					log.error("Error running " + getName(), e);
					//					return Status.OK_STATUS;
				}
				finally {
					if (VALIDATOR.isActive()) {
						long end = System.currentTimeMillis();
						VALIDATOR.println((end -start) + " ms for \"" + entry.getFile().getFullPath().toString() + "\" on \"" + Thread.currentThread().getName() + "\"");
					}
				}
				validationQueue.remove(entry);		// Remove so that failure does not repeat
				//				System.out.println(Thread.currentThread().getName() + " " + NameUtil.debugSimpleName(subMonitor) + " worked: " + 1);
				subMonitor.worked(1);
			}
			//			System.out.println(Thread.currentThread().getName() + " " + NameUtil.debugSimpleName(subMonitor) + " done");
			subMonitor.done();
		}
		if (monitor != null) {
			//			System.out.println(Thread.currentThread().getName() + " " + NameUtil.debugSimpleName(monitor) + " done");
			monitor.done();
		}
		return Status.OK_STATUS;
	}
}