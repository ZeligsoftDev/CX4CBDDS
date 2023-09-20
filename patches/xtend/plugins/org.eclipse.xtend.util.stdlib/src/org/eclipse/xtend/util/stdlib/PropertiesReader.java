/*******************************************************************************
 * Copyright (c) 2005, 2007 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.xtend.util.stdlib;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent2;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.emf.mwe.core.resources.ResourceLoader;
import org.eclipse.emf.mwe.core.resources.ResourceLoaderFactory;

/**
 * Reads a property file and makes it accessible through the
 * <tt>org::openarchitectureware::util::stdlib::properties</tt> extensions.
 * 
 * <h2>
 * Properties</h2>
 * <table>
 * <tr>
 * <th>Property</th>
 * <th>Type</th>
 * <th>Mandatory</th>
 * <th>Description</th>
 * </tr>
 * <tr>
 * <td><tt>propertiesFile</tt></td>
 * <td>String</td>
 * <td>yes</td>
 * <td>The properties file to read.</td>
 * </tr>
 * </table>
 * 
 * <h2>Example</h2> Workflow configuration:
 * 
 * <pre>
 * &lt;component class=&quot;org.eclipse.xtend.util.stdlib.PropertiesReader&quot;&gt;
 * 	&lt;propertiesFile value=&quot;src/config1.properties&quot;/&gt;
 * 	&lt;propertiesFile value=&quot;src/config2.properties&quot;/&gt;
 * &lt;/component&gt;
 * </pre>
 * 
 * Config file <tt>config.properties</tt>:
 * 
 * <pre>
 * shapes = box,polygon,ellipse,point
 * </pre>
 * 
 * Usage in an extension file:
 * 
 * <pre>
 * extension org::openarchitectureware::util::stdlib::properties;
 * 
 * cached List[String] SHAPES () : getProperty(&quot;shapes&quot;).split(&quot;,&quot;).trim();
 * </pre>
 * 
 */
public class PropertiesReader extends AbstractWorkflowComponent2 {
	private static final Logger LOG = LogManager.getLogger(PropertiesReader.class);
	private static final String COMPONENT_NAME = "Properties Reader";

	private List<String> propertiesFile;

	@Override
	protected void checkConfigurationInternal(final Issues issues) {
		if (propertiesFile == null || propertiesFile.isEmpty()) {
			issues.addError("propertiesFile not set. ");
		}
		else {
			for (final String uri : propertiesFile) {
				final URL url = ResourceLoaderFactory.createResourceLoader().getResource(uri);
				if (url == null) {
					issues.addError("propertiesFile '" + uri + "' not found.");
				}
			}
		}
	}

	@Override
	protected void invokeInternal(final WorkflowContext ctx, final ProgressMonitor monitor, final Issues issues) {
		final ResourceLoader rl = ResourceLoaderFactory.createResourceLoader();
		for (final String uri : propertiesFile) {
			try {
				final Properties p = new Properties();
				if (LOG.isDebugEnabled()) {
					LOG.debug("Reading properties file " + uri);
				}
				p.load(rl.getResourceAsStream(uri));
				PropertiesExtension.setProperties(p);
			}
			catch (final Exception e) {
				issues.addError(e.getMessage(), e);
			}
		}
	}

	/**
	 * Adds a properties file.
	 * 
	 * @param propertiesFile
	 *            A properties file
	 */
	public final void addPropertiesFile(final String propFile) {
		if (propertiesFile == null) {
			propertiesFile = new ArrayList<String>();
		}
		this.propertiesFile.add(propFile);
	}

	/**
	 * @see org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent#getComponentName()
	 */
	@Override
	public String getComponentName() {
		return COMPONENT_NAME;
	}

}
