/*******************************************************************************
 * Copyright (c) 2005, 2009 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/

package org.eclipse.xpand2;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.mwe.core.ConfigurationException;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.internal.xpand2.XpandTokens;
import org.eclipse.internal.xpand2.ast.Definition;
import org.eclipse.internal.xpand2.ast.ExpandStatement;
import org.eclipse.internal.xpand2.ast.Template;
import org.eclipse.internal.xpand2.parser.XpandParseFacade;
import org.eclipse.internal.xpand2.pr.ProtectedRegionResolver;
import org.eclipse.internal.xpand2.pr.ProtectedRegionResolverImpl;
import org.eclipse.internal.xtend.xtend.parser.ParseException;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.Output;
import org.eclipse.xpand2.output.OutputImpl;
import org.eclipse.xpand2.output.PostProcessor;
import org.eclipse.xtend.expression.AbstractExpressionsUsingWorkflowComponent;
import org.eclipse.xtend.expression.ResourceManager;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtend.typesystem.MetaModel;

public class Generator extends AbstractExpressionsUsingWorkflowComponent {

	private static final String COMPONENT_NAME = "Xpand Generator";

	/** @since 1.4 */
	protected String expand = null;

	private String fileEncoding = System.getProperty("file.encoding");

	private List<? extends PostProcessor> beautifier = new ArrayList<PostProcessor>();

	/** @since 1.4 */
	protected final List<String> advices = new ArrayList<String>();

	/** @since 1.4 */
	protected final List<String> extensionAdvices = new ArrayList<String>();

	private boolean automaticHyphens = false;

	private Output output = null;
	
	private ProtectedRegionResolverImpl prResolver;

	/**
	 * Enables or disables the automatic hyphenation. If automatic hyphenation
	 * is enabled, redundant blank lines are avoided automatically.
	 *
	 * @param automaticHyphens
	 *            If <code>true</code>, automatic hyphenation is enabled,
	 *            otherwise disabled.
	 */
	public void setAutomaticHyphens(final boolean automaticHyphens) {
		this.automaticHyphens = automaticHyphens;
	}

	/**
	 * @see org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent#getLogMessage()
	 */
	@Override
	public String getLogMessage() {
		final Set<String> outletDescriptions = new HashSet<String>();
		for (final Outlet outlet : outlets) {
			outletDescriptions.add(outlet.toString());
		}
		final String outletDesc = outletDescriptions.size() == 1 ? outletDescriptions.iterator().next()
				: outletDescriptions.toString();
		return "generating '" + expand + "' => " + outletDesc;
	}

	/**
	 * Adds an advice.
	 *
	 * @param advice
	 *            the advice
	 */
	@Override
	public void addAdvice(final String advice) {
		if (!advices.contains(advice)) {
			advices.add(advice);
		}
	}

	/**
	 * Adds an extension advice.
	 *
	 * @param extensionAdvice
	 *            the extension advice
	 */
	@Override
	public void addExtensionAdvice(final String extensionAdvice) {
		if (!extensionAdvices.contains(extensionAdvice)) {
			extensionAdvices.add(extensionAdvice);
		}
	}

	/**
	 * Returns the list of beautifiers that will be applied to the generated
	 * output.
	 *
	 * @return list of beautifiers
	 * @deprecated Will be removed in 2.0
	 */
	@Deprecated
	public List<? extends PostProcessor> getBeautifier() {
		return beautifier;
	}

	/**
	 * Sets the list of beautifiers that will be applied to the generated output.
	 *
	 * @param beautifiers
	 *            list of beautifiers
	 * @deprecated Configure PostProcessors per Outlet
	 */
	@Deprecated
	public void setBeautifier(final List<? extends PostProcessor> beautifiers) {
		beautifier = beautifiers;
		if (!getOutlets().isEmpty()) {
			throw new IllegalStateException ("'beautifier' must be configured before any Outlet.");
		}
	}

	/**
	 * Sets the character encoding used for the output file.
	 *
	 * @param fileEncoding
	 *            name of character encoding
	 */
	public void setFileEncoding(final String fileEncoding) {
		this.fileEncoding = fileEncoding;
		if (!getOutlets().isEmpty()) {
			throw new IllegalStateException ("'fileEncoding' must be configured before any Outlet.");
		}
	}

	/**
	 * Returns the name of character encoding used for the output file.
	 *
	 * @return name of character encoding
	 */
	public String getFileEncoding() {
		return fileEncoding;
	}

	/**
	 * Sets the path for always generated sources. This will create two Outlets for this path:
	 * The default outlet, and an Outlet with name "APPEND" and setting append=true
	 * @deprecated use {@link #addOutlet(Outlet)} instead
	 */
	@Deprecated
	public void setGenPath(final String genPath) {
		Outlet o = createOutlet();
		o.setAppend(false);
		o.setFileEncoding(fileEncoding);
		o.setOverwrite(true);
		o.setPath(fixPath(genPath));
		outlets.add(o);

		o = createOutlet();
		o.setAppend(true);
		o.setFileEncoding(fileEncoding);
		o.setName("APPEND");
		o.setOverwrite(true);
		o.setPath(genPath);
		outlets.add(o);
	}

	/**
	 * Sets the statement that is to expand by the generator.
	 *
	 * @param invoke
	 *            statement to expand
	 */
	public void setExpand(final String invoke) {
		expand = invoke;
	}

	/**
	 * Enables oder disables the default excludes for protected regions.
	 *
	 * @param prDefaultExcludes
	 *            If <code>true</code>, the default excludes are enabled,
	 *            otherwise disabled.
	 */
	public void setPrDefaultExcludes(final boolean prDefaultExcludes) {
		if (prResolver==null) prResolver = new ProtectedRegionResolverImpl();
		prResolver.setDefaultExcludes(prDefaultExcludes);
	}

	/**
	 * Sets the additional excludes for protected regions.
	 *
	 * @param prExcludes
	 *            the excludes
	 */
	public void setPrExcludes(final String prExcludes) {
		if (prResolver==null) prResolver = new ProtectedRegionResolverImpl();
		prResolver.setIgnoreList(prExcludes);
	}

	/**
	 * Sets the source paths for protected regions.
	 *
	 * @param prSrcPathes
	 *            the source paths
	 */
	public void setPrSrcPaths(final String prSrcPathes) {
		if (prResolver==null) prResolver = new ProtectedRegionResolverImpl();
		prResolver.setSrcPathes(prSrcPathes);
	}

	/**
	 * @see org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent#getComponentName()
	 */
	@Override
	public String getComponentName() {
		return COMPONENT_NAME;
	}

	/**
	 *
	 * @deprecated use outlets instead
	 */
	@Deprecated
	public void setSrcPath(final String srcPath) {
		final Outlet o = createOutlet();
		o.setAppend(false);
		o.setFileEncoding(fileEncoding);
		o.setName("ONCE");
		o.setOverwrite(false);
		o.setPath(fixPath(srcPath));

		outlets.add(o);
	}

	private String fixPath(final String p) {
		if (p.endsWith("\\"))
			return p.replace('\\', '/');
		if (p.endsWith("/"))
			return p;
		return p + "/";
	}

	@Override
	protected void invokeInternal2(final WorkflowContext ctx, final ProgressMonitor monitor, final Issues issues) {
		final ExpandStatement es = getStatement();
		if (es == null)
			throw new ConfigurationException("property 'expand' has wrong syntax!");

		XpandExecutionContext executionContext = createExecutionContext(ctx, monitor, issues);
		es.evaluate(executionContext);

		for (final Outlet element : getOutlets()) {
			final String name = (element.getName() == null ? "[default]" : element.getName()) + "(" + element.getPath()
					+ ")";
			if (element.getFilesWrittenAndClosed() > 0) {
				log.info("Written " + element.getFilesWrittenAndClosed() + " files to outlet " + name);
			}
			if (element.getFilesCreated() > element.getFilesWrittenAndClosed()) {
				log.info("Skipped writing of " + (element.getFilesCreated() - element.getFilesWrittenAndClosed())
						+ " files to outlet " + name);
			}
		}
	}
	
	/**
	 * Creates the execution context that is used for evaluation of the Xpand generator.
	 * @since 1.4
	 */
	protected XpandExecutionContext createExecutionContext (WorkflowContext wfContext, ProgressMonitor monitor, Issues issues) {
		ProtectedRegionResolver prs = getProtectedRegionResolver();
		ResourceManager resourceManager = getResourceManager();
		final Output out = getOutput();

		XpandExecutionContextImpl executionContext = new XpandExecutionContextImpl(
				resourceManager,
				out,
				prs,
				getGlobalVars(wfContext),
				monitor,
				exceptionHandler,
				getNullEvaluationHandler(),
				callback);

		for (final MetaModel mm : metaModels) {
			executionContext.registerMetaModel(mm);
		}


		final String[] names = wfContext.getSlotNames();
		for (final String name : names) {
			executionContext = (XpandExecutionContextImpl) executionContext.cloneWithVariable(new Variable(name, wfContext
					.get(name)));
		}

		for (final String advice : advices) {
			final String[] allAdvices = advice.split(",");
			for (final String string : allAdvices) {
				executionContext.registerAdvices(string.trim());
			}
		}

		for (final String advice : extensionAdvices) {
			final String[] allAdvices = advice.split(",");
			for (final String string : allAdvices) {
				executionContext.registerExtensionAdvices(string.trim());
			}
		}
		return executionContext;
	}

	protected ProtectedRegionResolver getProtectedRegionResolver () {
		if (prResolver==null) prResolver = new ProtectedRegionResolverImpl();
		prResolver.setFileEncoding(fileEncoding);
		return prResolver;
	}

	private final List<Outlet> outlets = new ArrayList<Outlet>(2);

	/**
	 * Adds an outlet.
	 *
	 * @param outlet
	 *            the outlet
	 */
	public void addOutlet(final Outlet outlet) {
		outlets.add(outlet);
		if (outlet.postprocessors.isEmpty()) {
			for (final Object name : beautifier) {
				final PostProcessor element = (PostProcessor) name;
				outlet.addPostprocessor(element);
			}
		}
		// Initialize file encoding for outlets. If it is not set then
		// take the Generator
		// default encoding. If this not set also then take System
		// default.
		if (outlet.getFileEncoding() == null) {
			outlet.setFileEncoding(fileEncoding);
		}
	}

	/**
	 * Sets the output.
	 *
	 * @param output
	 *            the output
	 */
	public void setOutput(final Output output) {
		this.output = output;
		if (!getOutlets().isEmpty()) {
			for (Outlet o: getOutlets()) {
				output.addOutlet(o);
			}
		} else {
			log.warn("No Outlet configured for Generator component. Make sure that the configured Output has Outlets configured.");
		}
	}

	/**
	 * @since 1.4
	 */
	protected final Output getOutput() {
		if (output == null) {
			// lazy initialization
			this.output = createOutput();
		}
		return output;
	}
	
	/**
	 * Retrieves the configured and initialized outlets of the generator.
	 */
	public final List<Outlet> getOutlets() {
		return Collections.unmodifiableList(outlets);
	}

	/**
	 * @since 1.4
	 */
	protected final ExpandStatement getStatement() {
		final Template tpl = XpandParseFacade.file(new StringReader(XpandTokens.LT + "DEFINE test FOR test"
				+ XpandTokens.RT + XpandTokens.LT + "EXPAND " + expand + XpandTokens.RT + XpandTokens.LT + "ENDDEFINE"
				+ XpandTokens.RT), null);
		ExpandStatement es = null;
		try {
			es = (ExpandStatement) ((Definition) tpl.getDefinitions()[0]).getBody()[1];
		}
		catch (final Exception e) {
			log.error(e);
		}
		return es;
	}

	@Override
	protected void checkConfigurationInternal(final Issues issues) {
		super.checkConfigurationInternal(issues);
		if (getOutlets().isEmpty()) {
			issues.addError(this, "You need to configure at least one outlet!");
		}
		int defaultOutlets = 0;
		for (final Outlet o : getOutlets()) {
			if (o.getName() == null) {
				defaultOutlets++;
			}
		}
		if (defaultOutlets > 1) {
			issues.addError(this,
					"Only one outlet can be the default outlet. Please specifiy a name for the other outlets!");
		}
		else if (defaultOutlets == 0) {
			issues.addWarning(this, "No default outlet configured!");
		}
		if (expand == null) {
			issues.addError(this, "property 'expand' not configured!");
		}
		else {
			try {
				final ExpandStatement es = getStatement();
				if (es == null) {
					issues.addError(this, "property 'expand' has wrong syntax!");
				}
			}
			catch (final ParseException e) {
				issues.addError(this, "property 'expand' has wrong syntax : " + e.getMessage());
			}
		}
	}
	
	/**
	 * Creates an Output instance.
	 * @return Instance of OutputImpl. Setting automaticHyphens will be considered.
	 * @since 1.4
	 */
	protected Output createOutput () {
		OutputImpl out = new OutputImpl();
		out.setAutomaticHyphens(automaticHyphens);
		for (Outlet o: getOutlets()) {
			out.addOutlet(o);
		}
		return out;
	}
	
	/**
	 * Creates an Outlet instance.
	 * @since 1.4
	 */
	protected Outlet createOutlet () {
		return new Outlet();
	}
	

}
