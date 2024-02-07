/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL debugger framework
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.vm.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.utils.Trace;
import org.eclipse.ocl.xtext.base.as2cs.BaseLocationInFileProvider;

/**
 * The activator class controls the plug-in life cycle
 */
public abstract class VMDebugCore
{
	public static @NonNull URI getResourceURI(IResource resource) {
		return URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
	}

	//	public static final @NonNull String BREAKPOINT_MARKER_ID = "org.eclipse.ocl.examples.debug.OCLBreakpointMarker"; //$NON-NLS-1$

	//	public static final @NonNull String MODEL_ID = "org.eclipse.ocl.examples.debug"; //$NON-NLS-1$

	//	public static final @NonNull String DEBUGGER_ACTIVE_PROPERTY = "org.eclipse.ocl.examples.debug.debuggerActive"; //$NON-NLS-1$

	// The plug-in fBreakpointID
	//	public static final @NonNull String PLUGIN_ID = OCLDebugPlugin.PLUGIN_ID; //$NON-NLS-1$

	// The shared instance
	//	private static OCLDebugCore plugin;

	private Map<URI, URI> platformPluginMap;
	//	private IResourceChangeListener resourceListener;
	private @NonNull Object pluginMapLock = new Object();

	/**
	 * The constructor
	 */
	public VMDebugCore() {
		super();
	}

	public void error(String message, Throwable throwable) {
		error(0, message, throwable);
	}

	public void error(Throwable throwable) {
		error("", throwable); //$NON-NLS-1$
	}

	public void error(String message) {
		error(0, message, null);
	}

	/**
	 * Generates an error log for the specified plug-in, with the specified
	 * status code, message, and throwable.
	 *
	 * @param code
	 *            The status code for the log.
	 * @param message
	 *            The message for the log.
	 * @param throwable
	 *            The throwable for the log.
	 *
	 */
	public void error(int code, String message, Throwable throwable) {
		log(Diagnostic.ERROR, code, message, throwable);
	}

	public abstract @NonNull String getBreakpointMarkerId();

	public abstract @NonNull String getDebuggerActiveProperty();

	public abstract @NonNull String getModelId();

	public abstract @Nullable ILog getLog();

	public abstract @NonNull String getPluginId();

	public abstract @NonNull Trace getTrace();

	public abstract @NonNull String getVMThreadName();

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 *
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;

		TRACE.start(plugin);

		resourceListener = createResourceListen();
		ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceListener);
	} */

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 *
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);

		TRACE.stop();
		if(resourceListener != null) {
			ResourcesPlugin.getWorkspace().removeResourceChangeListener(resourceListener);
		}
	} */

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	//	public static OCLDebugCore getDefault() {
	//		return plugin;
	//	}

	public @NonNull IStatus createDebugError(String string, IOException e) {
		return createStatus(IStatus.ERROR, string, e);
	}

	public @NonNull IStatus createStatus(int severity, String message, Throwable throwable) {
		return new Status(severity, getPluginId(), message, throwable);
	}

	public @NonNull IStatus createStatus(int severity, String message) {
		return createStatus(severity, message, null);
	}

	public @NonNull IStatus createError(String message, int code,  Throwable throwable) {
		return new Status(IStatus.ERROR, getPluginId(), code, message, throwable);
	}

	public abstract @NonNull String getDebugTargetName();

	public abstract @NonNull String getDebugThreadName();

	public abstract @NonNull List<@NonNull ? extends VMLineBreakpoint> getLineBreakpoints();

	public abstract @NonNull BaseLocationInFileProvider getLocationInFileProvider();

	public @NonNull <@NonNull T extends IBreakpoint> List<T> getOCLBreakpoints(@NonNull Class<T> breakpointType) {
		IBreakpoint[] breakpoints = DebugPlugin.getDefault().getBreakpointManager().getBreakpoints(getModelId());
		List<T> result = new ArrayList<T>(breakpoints.length);
		for (IBreakpoint bp : breakpoints) {
			if(breakpointType.isInstance(bp)) {
				result.add(breakpointType.cast(bp));
			}
		}
		return result;
	}

	public void log(int severity, int code, String message, Throwable throwable) {
		//
		// Status ctor requires a non-null message
		String msg = message == null
				? "" //$NON-NLS-1$
						: message;

		try {
			ILog log = getLog();
			if (log != null) {
				// Eclipse environment
				log.log(new Status(severity, getPluginId(), code, msg, throwable));
			} else {
				// not in the Eclipse environment
				//if (shouldTrace()) {
				switch (code) {
				case Diagnostic.WARNING :
					System.err.print("WARNING "); //$NON-NLS-1$
					break;
				case Diagnostic.ERROR :
				case Diagnostic.CANCEL :
					System.err.print("ERROR "); //$NON-NLS-1$
					break;
				default :
					// don't output INFO or OK messages
					return;
				}

				System.err.print(code);
				System.err.print(": "); //$NON-NLS-1$
				System.err.println(message);

				if (throwable != null) {
					throwable.printStackTrace(System.err);
				}
				//}
			}
		} catch (IllegalArgumentException iae) {
			iae.printStackTrace();
		}
	}

	public void log(IStatus status) {
		ILog log = getLog();
		if (log != null) {
			log.log(status);
		}
	}

	public void log(Throwable e) {
		log(new Status(IStatus.ERROR, getPluginId(), "Exception caught", e)); //$NON-NLS-1$
	}

	public URI resolvePlatformPluginURI(IFile file) {
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		return resolvePlatformPluginURI(uri);
	}

	public URI resolvePlatformPluginURI(URI uri) {
		Map<URI, URI> uriMap = getPlatformPluginMap();

		if(uri.isPlatformResource() && uri.segmentCount() > 2) {
			URI baseURI = uri.trimSegments(uri.segmentCount() - 2);
			// key requires trailing slash
			URI key = baseURI.appendSegment(""); //$NON-NLS-1$
			URI mappedBaseURI = uriMap.get(key);
			if(mappedBaseURI == null) {
				mappedBaseURI = uriMap.get(baseURI);
			}

			if(mappedBaseURI != null) {
				List<String> segmentsList = uri.segmentsList();
				segmentsList = segmentsList.subList(2, segmentsList.size());
				if(mappedBaseURI.hasTrailingPathSeparator()) {
					mappedBaseURI = mappedBaseURI.trimSegments(1);
				}
				return mappedBaseURI.appendSegments(segmentsList.toArray(new String[segmentsList.size()]));
			}
		}

		return null;
	}

	/*	public IFile resolveWorskpaceFile(URI uri) {
		IFile sourceFile = OCLDebugUtil.toFile(uri);

		if(sourceFile == null && uri.isPlatformPlugin() && uri.segmentCount() > 2) {
			Map<URI, URI> uriMap = getPlatformPluginMap();

			URI baseURI = uri.trimSegments(uri.segmentCount() - 2);

			// key requires trailing slash
			URI key = baseURI.appendSegment(""); //$NON-NLS-1$
			URI mappedBaseURI = uriMap.get(key);
			if(mappedBaseURI == null) {
				mappedBaseURI = uriMap.get(baseURI);
			}

			if(mappedBaseURI != null) {
				List<String> segmentsList = uri.segmentsList();
				segmentsList = segmentsList.subList(2, segmentsList.size());
				URI mappedURI = mappedBaseURI.appendSegments(segmentsList.toArray(new String[segmentsList.size()]));
				sourceFile = OCLDebugUtil.toFile(mappedURI);
			}
		}

		return sourceFile;
	} */

	private Map<URI, URI> getPlatformPluginMap() {
		synchronized (pluginMapLock) {
			if(platformPluginMap == null) {
				platformPluginMap = new HashMap<URI, URI>();

				Map<URI, URI> plugin2ResourceMap = EcorePlugin.computePlatformURIMap(true);
				platformPluginMap.putAll(plugin2ResourceMap);

				for (Map.Entry<URI, URI> entry : plugin2ResourceMap.entrySet()) {
					platformPluginMap.put(entry.getValue(), entry.getKey());
				}
			}
		}

		return platformPluginMap;
	}

	/*	private void resetPlatformPluginMap() {
		synchronized (pluginMapLock) {
			platformPluginMap = null;
		}
	} */

	/*	private boolean process(IResourceDelta delta) {
		IResource resource = delta.getResource();
		if(isManifest(resource)) {
			return true;
		}

		IResourceDelta[] affectedChildren = delta.getAffectedChildren();
		for (IResourceDelta childDelta : affectedChildren) {
			if(process(childDelta)) {
				return true;
			}
		}
		return false;
	} */

	/*	private boolean isManifest(IResource resource) {
		if (resource.getType() == IResource.FILE
				&& resource.getName().equals("MANIFEST.MF") //$NON-NLS-1$
				&& resource.getProjectRelativePath().equals(
						new Path("META-INF/MANIFEST.MF"))) { //$NON-NLS-1$
			return true;
		}
		return false;
	} */

	/*	private IResourceChangeListener createResourceListen() {
		return new IResourceChangeListener() {

			public void resourceChanged(IResourceChangeEvent event) {
				if(event.getResource() instanceof IProject) {
					VMDebugCore.this.resetPlatformPluginMap();
				}

				if(event.getDelta() != null) {
					if(process(event.getDelta())) {
						VMDebugCore.this.resetPlatformPluginMap();
					}
				}
			}
		};
	} */

	public IFile resolveWorskpaceFile(URI uri) {
		IFile sourceFile = toFile(uri);

		/*		if(sourceFile == null && uri.isPlatformPlugin() && uri.segmentCount() > 2) {
			Map<URI, URI> uriMap = getPlatformPluginMap();

			URI baseURI = uri.trimSegments(uri.segmentCount() - 2);

			// key requires trailing slash
			URI key = baseURI.appendSegment(""); //$NON-NLS-1$
			URI mappedBaseURI = uriMap.get(key);
			if(mappedBaseURI == null) {
				mappedBaseURI = uriMap.get(baseURI);
			}

			if(mappedBaseURI != null) {
				List<String> segmentsList = uri.segmentsList();
				segmentsList = segmentsList.subList(2, segmentsList.size());
				URI mappedURI = mappedBaseURI.appendSegments(segmentsList.toArray(new String[segmentsList.size()]));
				sourceFile = OCLDebugUtil.toFile(mappedURI);
			}
		} */
		return sourceFile;
	}

	public IFile toFile(URI uri) {
		List<IFile> files = toFiles(uri);
		return files.isEmpty() ? null : files.get(0);
	}

	public List<IFile> toFiles(URI uri) {
		if (uri.isPlatformResource()) {
			String platformString = uri.toPlatformString(true);
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(platformString));
			return Collections.singletonList(file);
		} else if(uri.isFile()) {
			java.net.URI javaURI;
			try {
				javaURI = java.net.URI.create(uri.toString());
			} catch(IllegalArgumentException e) {
				// not a valid EMF uri, can't look for IFile
				log(e);
				return Collections.emptyList();
			}

			IFile[] files = ResourcesPlugin.getWorkspace().getRoot().findFilesForLocationURI(javaURI);
			List<IFile> result = new ArrayList<IFile>(files.length);

			for (IFile nextFile : files) {
				result.add(nextFile);
			}
			return result;
		}
		return Collections.emptyList();
	}
}
