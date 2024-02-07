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

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent2;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

/**
 * This component executes a system command. <h2>
 * Properties</h2>
 * <table border="1">
 * <tr>
 * <th>Property</th>
 * <th>Type</th>
 * <th>Mandatory</th>
 * <th>Description</th>
 * </tr>
 * <tr>
 * <td><tt>command</tt></td>
 * <td>String</td>
 * <td>yes</td>
 * <td>The command to execute.</td>
 * </tr>
 * <tr>
 * <td><tt>directory</tt></td>
 * <td>String</td>
 * <td>no</td>
 * <td>Execution directory.</td>
 * </tr>
 * <tr>
 * <td><tt>arg</tt></td>
 * <td>String</td>
 * <td>no</td>
 * <td>(multiple) command arguments.</td>
 * </tr>
 * <tr>
 * <td><tt>env</tt></td>
 * <td>String</td>
 * <td>no</td>
 * <td>(multiple) additional environment entries. Format: [key],[value]</td>
 * </tr>
 * </table>
 *
 * <h2>Example</h2>
 *
 * <pre>
 * &lt;component class=&quot;org.ecipse.xtend.util.stdlib.SystemCommand&quot;&gt;
 * 	&lt;directory value=&quot;src-gen&quot;/&gt;
 * 	&lt;command value=&quot;sh&quot;/&gt;
 * 	&lt;arg value=&quot;processdot.sh&quot;/&gt;
 * &lt;/component&gt;
 * </pre>
 *
 * @author Karsten Thoms
 * @since 4.3.1
 */
public class SystemCommand extends AbstractWorkflowComponent2 {
	private final static Logger log = LogManager.getLogger(SystemCommand.class);

	/**
	 * The execute command.
	 */
	private String command;

	private File directory = new File(".");

	private final boolean inheritEnvironment = false;

	private final List<String> args = new ArrayList<String>();
	private final List<String> enventry = new ArrayList<String>();

	@Override
	protected void checkConfigurationInternal(final Issues issues) {
		if (command == null) {
			issues.addError("command not specified");
		}
	}

	@Override
	protected void invokeInternal(final WorkflowContext ctx, final ProgressMonitor monitor, final Issues issues) {
		try {
			int rc;
			final List<String> pbArgs = new ArrayList<String>();
			pbArgs.add(command);
			pbArgs.addAll(args);
			final ProcessBuilder pb = new ProcessBuilder(pbArgs);
			if (directory != null) {
				pb.directory(directory);
			}
			for (final String env : enventry) {
				final String[] keyvalue = env.split(",");
				pb.environment().put(keyvalue[0], keyvalue[1]);
			}
			if (inheritEnvironment) {
				log.debug("Inheriting system environment.");
				pb.environment().putAll(System.getenv());
			}
			if (log.isDebugEnabled()) {
				log.debug("Environment:");
				log.debug(pb.environment());
				log.debug(System.getenv());
			}
			log
					.info("Running command '" + pb.command() + "' in directory " + pb.directory().getAbsolutePath()
							+ " ...");
			final Process p = pb.start();
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

			String lineRead;
			while ((lineRead = br.readLine()) != null) {
				log.info(lineRead);
			}

			br = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			while ((lineRead = br.readLine()) != null) {
				log.error(lineRead);
			}
			rc = p.waitFor();
			if (rc != 0) {
				issues.addError("Error running '" + command + "'");
				return;
			}
			rc = p.exitValue();
			if (rc != 0) {
				issues.addError("Execution of command failed with error.");

			}
			else {
				log.info("Execution of command was successful.");
			}
		}
		catch (final Exception re) {
			issues.addError("Runtime error: " + re.getMessage());
		}
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(final String command) {
		this.command = command;
	}

	public void setDirectory(final String directory) {
		this.directory = new File(directory);
	}

	public void addArg(final String arg) {
		args.add(arg);
	}

	public void addEnv(final String entry) {
		if (!entry.matches("\\A[^,]+,.+\\z"))
			throw new IllegalArgumentException(entry);
		enventry.add(entry);
	}

}
