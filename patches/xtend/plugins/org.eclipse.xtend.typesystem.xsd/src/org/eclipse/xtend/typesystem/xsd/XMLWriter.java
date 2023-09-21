/*******************************************************************************
 * Copyright (c) 2005 - 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtend.typesystem.xsd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.Logger;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.ExecutionContextImpl;
import org.eclipse.xtend.expression.ExpressionFacade;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtend.typesystem.MetaModel;
import org.eclipse.xtend.typesystem.xsd.util.XSDLog;
import org.eclipse.xtend.typesystem.xsd.util.XSDUtil;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XMLWriter extends AbstractXMLWorkflowComponent {

	public static class DoctypeInfo {
		private String publicId;
		private String systemId;

		public void checkConfiguration(Issues issues) {
			if (systemId == null || "".equals(systemId)) {
				issues.addError("The DoctypeInfo needs a systemId");
			}
			if (publicId == null || "".equals(publicId)) {
				issues.addError("The DoctypeInfo needs an publicId");
			}
		}

		public String getPublicId() {
			return publicId;
		}

		public String getSystemId() {
			return systemId;
		}

		public void setPublicId(String publicId) {
			this.publicId = publicId;
		}

		public void setSystemId(String systemId) {
			this.systemId = systemId;
		}
	}

	public static class ExpressionWithVarname {
		private String expression;
		private Pattern EXT = Pattern.compile("([a-zA-Z0-9\\-_]+::)+");
		private ArrayList<String> extFiles = new ArrayList<String>();

		private String varName;

		public ExpressionWithVarname() {
			super();
		}

		public ExpressionWithVarname(String varName, String expression) {
			super();
			this.varName = varName;
			this.expression = expression;
		}

		public void checkConfiguration(Issues issues) {
			if (varName == null || "".equals(varName)) {
				issues.addError("The uriExpression needs a varName");
			}
			if (expression == null || "".equals(expression)) {
				issues.addError("The uriExpression needs an expression");
			}
		}

		public String getExpression() {
			return expression;
		}

		public String getVarName() {
			return varName;
		}

		public void setExpression(String exp) {
			// TODO: make sure string ends with "(" to avoid mixup with
			// enumerations
			Matcher m = EXT.matcher(exp);
			while (m.find()) {
				String s = m.group(0);// .replace("::", "/");
				s = s.substring(0, s.length() - 2);
				extFiles.add(s);
			}
			expression = m.replaceAll("");
		}

		public void setVarName(String varName) {
			this.varName = varName;
		}
	}

	private class XMLWriterResource implements
			org.eclipse.xtend.expression.Resource {
		private String name = "noName";

		public String getFullyQualifiedName() {
			return name;
		}

		public String[] getImportedExtensions() {
			return uriExpression.extFiles
					.toArray(new String[uriExpression.extFiles.size()]);
		}

		public String[] getImportedNamespaces() {
			return new String[0];
		}

		public void setFullyQualifiedName(final String fqn) {
			name = fqn;
		}
	}

	private static final String COMPONENT_NAME = "XML Writer";

	protected DoctypeInfo doctypeInfo;

	protected Logger log = XSDLog.getLog(getClass());

	protected Map<String, Object> options = new HashMap<String, Object>();

	protected ExpressionWithVarname uriExpression;

	public void addOption(OptionsEntry entry) {
		options.put(entry.getKey(), entry.getValue());
	}

	@Override
	public void checkConfiguration(Issues issues) {
		if (uri == null && uriExpression == null) {
			issues.addError(this, "The output file name must be specified "
					+ "via 'uri' or 'uriExpression'.");
		}
		if (uri != null && uriExpression != null) {
			issues.addError(this, "The output file name must be specified "
					+ "with either 'uri' or 'uriExpression', but not "
					+ "with both at the same time.");
		}
		if (uriExpression != null) {
			uriExpression.checkConfiguration(issues);
		}
		if (doctypeInfo != null) {
			doctypeInfo.checkConfiguration(issues);
		}
		super.checkConfiguration(issues);
	}

	@Override
	public String getComponentName() {
		return COMPONENT_NAME;
	}

	protected ExecutionContextImpl getExecutionContext(final WorkflowContext ctx) {
		HashMap<String, Variable> vars = new HashMap<String, Variable>();
		for (String s : ctx.getSlotNames()) {
			vars.put(s, new Variable(s, ctx.get(s)));
		}
		ExecutionContextImpl ec = new ExecutionContextImpl(vars);
		for (MetaModel mm : getAllMetaModels()) {
			ec.registerMetaModel(mm);
		}
		return ec;
	}

	@Override
	public String getLogMessage() {
		return "Writing " + ((uri == null) ? "XML files..." : uri.toString());
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {
		Object cnt = ctx.get(getModelSlot());
		if (cnt == null) {
			issues.addError(this, "slot '" + getModelSlot() + "' is empty.");
			return;
		}
		if (cnt instanceof Collection) {
			if (uriExpression == null) {
				issues.addError(this, "The value of slot '" + getModelSlot()
						+ "' is a Collection, therefore the filename "
						+ "must be specified using 'uriExpression'");
				return;
			}
			for (Object obj : (Collection) cnt) {
				save(ctx, obj, issues);
			}
		} else {
			save(ctx, cnt, issues);
		}
	}

	protected void save(EObject obj, URI uri, Issues issues) {
		if (!(obj.eResource() instanceof OawXMLResource)) {
			if (obj.eResource() != null) {
				issues.addWarning(this,
						"Overwriting resource for model in slot '"
								+ getModelSlot() + "' for file '" + uri + "'");
			}
			Resource res = new OawXMLResource(uri, getMetaModel());
			res.getContents().add(obj);
		} else {
			obj.eResource().setURI(uri);
		}
		try {
			if (uriExpression != null) {
				log.info("Writing " + uri);
			}
			if (doctypeInfo != null) {
				((XMLResource) obj.eResource()).setDoctypeInfo(doctypeInfo
						.getPublicId(), doctypeInfo.getSystemId());
				options.put(XMLResource.OPTION_SAVE_DOCTYPE, Boolean.TRUE);
			}
			obj.eResource().save(options);
		} catch (IOException e) {
			issues.addError(this, "Error while saving XML file.", e);
		}
	}

	protected void save(WorkflowContext ctx, Object obj, Issues issues) {
		if (!(obj instanceof EObject)) {
			issues.addError(this, "slot '" + getModelSlot()
					+ "' does not contain an EObject");
			return;
		}
		if (uriExpression != null) {
			ExecutionContext ec = getExecutionContext(ctx);
			ec = ec.cloneWithVariable(new Variable(uriExpression.getVarName(),
					obj));
			ec = ec.cloneWithResource(new XMLWriterResource());
			ExpressionFacade ef = new ExpressionFacade(ec);
			Object r = ef.evaluate(uriExpression.getExpression());
			if (!(r instanceof String)) {
				issues.addError(this, "The expression '" + uriExpression
						+ "' needs to return a string for value '" + obj + "'");
				return;
			}
			uri = r.toString();
		}
		save((EObject) obj, XSDUtil.strToURI(uri), issues);
	}

	public void setDoctypeInfo(final DoctypeInfo info) {
		doctypeInfo = info;
	}

	public void setUriExpression(final ExpressionWithVarname uriExpression) {
		this.uriExpression = uriExpression;
	}
}
