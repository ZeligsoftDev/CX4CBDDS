/*******************************************************************************
 * Copyright (c) 2013, 2018 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.ui.providers;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.ocl.examples.emf.validation.validity.AbstractNode;
import org.eclipse.ocl.examples.emf.validation.validity.ConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.LeafConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.Result;
import org.eclipse.ocl.examples.emf.validation.validity.ResultConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.ResultValidatableNode;
import org.eclipse.ocl.examples.emf.validation.validity.Severity;
import org.eclipse.ocl.examples.emf.validation.validity.ValidatableNode;
import org.eclipse.ocl.examples.emf.validation.validity.messages.ValidityMessages;
import org.eclipse.ocl.examples.emf.validation.validity.ui.view.SeveritiesDecorator;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;

public class NodeLabelProvider extends ColumnLabelProvider
{
	protected class Summary
	{
		private int oks = 0;
		private int infos = 0;
		private int warnings = 0;
		private int errors = 0;
		private int fatals = 0;
		private int defaults = 0;
		
		public void accumulate(@NonNull EObject eObject) {
			Result worstResult = null;
			if (eObject instanceof ResultValidatableNode) {
				worstResult = ((ResultValidatableNode)eObject).getWorstResult();
			}
			else if (eObject instanceof ResultConstrainingNode) {
				worstResult = ((ResultConstrainingNode)eObject).getWorstResult();
			}
			if (worstResult != null) {
				Severity severity = worstResult.getSeverity();
				switch (severity) {
				case OK: oks++; break;
				case INFO: infos++; break;
				case WARNING: warnings++; break;
				case ERROR: errors++; break;
				case FATAL: fatals++; break;
				default: defaults++; break;
				}
			}
		}
		
		public @NonNull String toString() {
			String separator = ", "; //"\n";
			StringBuilder s = new StringBuilder();
			s.append(oks + " ok" + (oks != 1 ? "s" : ""));
			if (infos > 0) {
				s.append(separator + infos + " info" + (oks != 1 ? "s" : ""));
			}
			if (warnings > 0) {
				s.append(separator + warnings + " warning" + (warnings != 1 ? "s" : ""));
			}
			if (errors > 0) {
				s.append(separator + errors + " error" + (errors != 1 ? "s" : ""));
			}
			if (fatals > 0) {
				s.append(separator + fatals + " fatal" + (fatals != 1 ? "s" : ""));
			}
			if (defaults > 0) {
				s.append(separator + defaults + " other" + (defaults != 1 ? "s" : ""));
			}
			return s.toString();
		}
	}
	
	private final @NonNull ILabelProvider labelProvider;
	private final Color validatableColor;
	private final Color constrainingNodeColor;
	private final Font italicFont = JFaceResources.getFontRegistry().getItalic(JFaceResources.DEFAULT_FONT);

	public NodeLabelProvider(@NonNull ILabelProvider labelProvider, Color validatableColor, Color constrainingNodeColor) {
		this.labelProvider = labelProvider;
		this.validatableColor = validatableColor;
		this.constrainingNodeColor = constrainingNodeColor;
	}

	@Override
	public void addListener(ILabelProviderListener listener) {
		labelProvider.addListener(listener);
	}

	protected void appendResourceDiagnostic(@NonNull StringBuilder s, @NonNull Diagnostic diagnostic) {
		boolean isFirst = true;
		List<Diagnostic> children = diagnostic.getChildren();
		if (!children.isEmpty()) {
			for (Diagnostic child : diagnostic.getChildren()) {
				if (isFirst) {
					s.append(child.getMessage());
					isFirst = false;
				} else {
					s.append("\n" + child.getMessage());
				}
			}
		} else {
			s.append(diagnostic.getMessage());
		}
	}

	public Color getBackground(Object element) {
		return null;
	}

	public Font getFont(Object element) {
		if (element instanceof ResultConstrainingNode) {
			return null;
		}
		else if (element instanceof ResultValidatableNode) {
			return italicFont;
		}
		else if (element instanceof ConstrainingNode) {
			return italicFont;
		}
		else {
			return null;
		}
	}

	public Color getForeground(Object element) {
		if (element instanceof ResultConstrainingNode) {
			return validatableColor;
		}
		else if (element instanceof ResultValidatableNode) {
			return constrainingNodeColor;
		}
		else if (element instanceof ConstrainingNode) {
			return constrainingNodeColor;
		}
		else {
			return validatableColor;
		}
	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof ResultValidatableNode) {
			ConstrainingNode constrainingNode = ((ResultValidatableNode)element).getResultConstrainingNode().getParent();
			return labelProvider.getImage(constrainingNode != null ? constrainingNode.getConstrainingObject() : null);
//			if (constrainingNode instanceof LeafConstrainingNode) {
//				Object image = ((LeafConstrainingNode)constrainingNode).getConstraintLocator().getImage();
//				return ExtendedImageRegistry.INSTANCE.getImage(image);
//			}
//			else {
//				return labelProvider.getImage(constrainingNode.getConstrainingObject());
//			}
		}
		else if (element instanceof ResultConstrainingNode) {
			ValidatableNode validatableNode = ((ResultConstrainingNode)element).getResultValidatableNode().getParent();
			return labelProvider.getImage(validatableNode != null ? validatableNode.getConstrainedObject() : null);
		}
		else if (element instanceof ConstrainingNode) {
			return labelProvider.getImage(((ConstrainingNode)element).getConstrainingObject());
		}
		else if (element instanceof ValidatableNode) {
			return labelProvider.getImage(((ValidatableNode)element).getConstrainedObject());
		}
		else {
			return labelProvider.getImage(element);
		}
	}

	protected @NonNull String getResultToolTip(@Nullable Result result) {
		if (result == null) {
			return "No result available";
		}
		if (result.getSeverity() == Severity.OK) {
			return "Successful";
		}
		StringBuilder s = new StringBuilder();
		Object diagnostic = result.getDiagnostic();
		if (diagnostic == null) {
			s.append("<<null diagnostic message>>");
		}
		else if (diagnostic instanceof Diagnostic) {
			appendResourceDiagnostic(s, (Diagnostic)diagnostic);
		}
		else {
			s.append(String.valueOf(diagnostic));
		}
		Throwable exception = result.getException();
		if (exception != null) {
			s.append("\n" + exception.getClass().getName() + ":\n");
			StringWriter sw = new StringWriter();
			sw.append(s.toString());
			exception.printStackTrace(new PrintWriter(sw));	
		}
		return s.toString();
	}

	protected @NonNull String getSummaryToolTip(@NonNull AbstractNode node) {
		Summary summary = new Summary();
		summary.accumulate(node);
		for (TreeIterator<EObject> tit = node.eAllContents(); tit.hasNext(); ) {
			@SuppressWarnings("null")@NonNull EObject eObject = tit.next();
			summary.accumulate(eObject);
		}
		return summary.toString();
	}

	@Override
	public String getText(Object element) {
		return ((AbstractNode)element).getLabel();
	}

	@Override
	public Image getToolTipImage(Object object) {
		Object severityImage = SeveritiesDecorator.getSeverityImage(object);
		return ExtendedImageRegistry.INSTANCE.getImage(severityImage);
	}

	@Override
	public @Nullable String getToolTipText(Object element) {
		if (element instanceof LeafConstrainingNode) {
			LeafConstrainingNode leafConstrainingNode = ((LeafConstrainingNode) element);
			return getLeafConstrainingNodeHover(leafConstrainingNode, false);
		} else if (element instanceof ResultConstrainingNode) {
			return getResultToolTip(((ResultConstrainingNode) element).getWorstResult());
		} else if (element instanceof ResultValidatableNode) {
			Result result = ((ResultValidatableNode) element).getWorstResult();
			if (result != null) {
				LeafConstrainingNode leafConstrainingNode = result.getLeafConstrainingNode();
				return getLeafConstrainingNodeHover(leafConstrainingNode, true);
			} else {
				ConstrainingNode contrainingNode = ((ResultValidatableNode) element).getResultConstrainingNode().getParent();
				if (contrainingNode instanceof LeafConstrainingNode){
					LeafConstrainingNode leafConstrainingNode = ((LeafConstrainingNode) contrainingNode);
					return getLeafConstrainingNodeHover(leafConstrainingNode, true);
				}
				return getResultToolTip(result);
			}
		} else if (element instanceof AbstractNode) {
			return getSummaryToolTip((AbstractNode) element);
		} else {
			return "Unknown";
		}
	}

	private String getLeafConstrainingNodeHover(LeafConstrainingNode leafConstrainingNode, boolean withDiagnosisMessage) {
		StringBuilder s = new StringBuilder();
		Resource resource = leafConstrainingNode.getConstraintResource();
		s.append("Location: ");
		if (resource != null) {
			s.append(resource.getURI().toString());
		} else {
			s.append(ValidityMessages.ValidityView_Constraints_LabelProvider_NonExistentResource);
		}
		
		String expression = leafConstrainingNode.getConstraintString();
		s.append("\nExpression: ");
		if (expression != null) {
			s.append(expression);
		} else {
			s.append(ValidityMessages.ValidityView_Constraints_LabelProvider_ExpressionNotAvailable);
		}
		
		if (withDiagnosisMessage) {
			s.append("\nEvaluation Result: ");
			s.append(getResultToolTip(leafConstrainingNode.getWorstResult()));
		}
		s.append("\n");
		s.append(getSummaryToolTip(leafConstrainingNode));
		return s.toString();
	}

	public int getToolTipTimeDisplayed(Object object) {
		return 15000;
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		if (element instanceof ConstrainingNode) {
			return labelProvider.isLabelProperty(((ConstrainingNode)element).getConstrainingObject(), property);
		}
		else if (element instanceof ValidatableNode) {
			return labelProvider.isLabelProperty(((ValidatableNode)element).getConstrainedObject(), property);
		}
		else {
			return labelProvider.isLabelProperty(element, property);
		}
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		labelProvider.removeListener(listener);
	}
}
