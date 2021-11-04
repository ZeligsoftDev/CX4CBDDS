/*****************************************************************************
 * Copyright (c) 2014, 2016 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 425270
 *  Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Bug 496905
 *  Christian W. Damus - bug 508629
 *
 /*****************************************************************************/
package org.eclipse.papyrus.uml.tools.providers;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.emf.utils.TextReferencesHelper;
import org.eclipse.papyrus.infra.ui.emf.providers.EMFLabelProvider;
import org.eclipse.papyrus.uml.internationalization.utils.utils.UMLLabelInternationalization;
import org.eclipse.papyrus.uml.tools.Activator;
import org.eclipse.papyrus.uml.tools.namereferences.NameReferencesHelper;
import org.eclipse.papyrus.uml.tools.utils.ImageUtil;
import org.eclipse.papyrus.uml.tools.utils.MultiplicityElementUtil;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.ClassifierTemplateParameter;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.ExtensionEnd;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.LiteralNull;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.OperationTemplateParameter;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.PackageMerge;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateParameterSubstitution;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.edit.UMLEditPlugin;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * A global LabelProvider for UML
 *
 * @author Camille Letavernier
 *
 */
public class UMLLabelProvider extends EMFLabelProvider implements ILabelProvider {

	/** icon for metaclass */
	public static final String ICON_METACLASS = "/icons/Metaclass.gif";//$NON-NLS-1$

	private DelegatingItemLabelProvider labelProvider = new DelegatingItemLabelProvider(DelegatingItemLabelProvider.SHOW_LABEL | DelegatingItemLabelProvider.SHOW_METACLASS);

	private final CopyOnWriteArrayList<ILabelProviderListener> listeners = new CopyOnWriteArrayList<>();
	private final INotifyChangedListener forwardingListener = this::notifyChanged;

	/**
	 * Initializes me.
	 */
	public UMLLabelProvider() {
		super();

		labelProvider.addListener(forwardingListener);
	}

	@Override
	public void dispose() {
		try {
			labelProvider.removeListener(forwardingListener);
			labelProvider.dispose();
		} finally {
			super.dispose();
		}
	}

	private void notifyChanged(Notification msg) {
		if (msg instanceof ViewerNotification) {
			ViewerNotification vnot = (ViewerNotification) msg;
			if (vnot.isLabelUpdate() && !listeners.isEmpty()) {
				LabelProviderChangedEvent event = new LabelProviderChangedEvent(this, vnot.getElement());
				listeners.forEach(l -> {
					try {
						l.labelProviderChanged(event);
					} catch (Exception e) {
						Activator.log.error("Uncaught exception in label provider listener", e); //$NON-NLS-1$
					}
				});
			}
		}
	}

	/**
	 *
	 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
	 *
	 * @param element
	 * @return
	 *         <ul>
	 *         <li>if stereotypes are applied on the elements : return the image corresponding to the first applied stereotype</li>
	 *         <li>if the element is a {@link DecorationNode}, returns the image corresponding to a compartment</li>
	 *         <li><code>null</code> if no image was found</li>
	 *         </ul>
	 */
	@Override
	protected Image getImage(EObject element) {

		element = resolveElement(element);

		// test for other UML Elements
		if (element instanceof Element) {
			// return the stereotype image if a stereotype is applied on the
			// element
			Image image = Activator.getDefault().getIconElement((Element) element);

			// If image is null, return the standard EMF image
			return image == null ? super.getImage(element) : image;
		}

		return super.getImage(element);
	}

	/**
	 * If the inputElement is a StereotypeApplication, we want to provide the label
	 * of the stereotyped element, instead of the one of the StereotypeApplication
	 *
	 * @param inputElement
	 *            The EObject for which we want to provide a label
	 * @return
	 * 		The Base Element if the input is a StereotypeApplication ; the inputElement instead
	 */
	protected EObject resolveElement(EObject inputElement) {
		if (inputElement == null) {
			return null;
		}

		if (inputElement instanceof Element) {
			return inputElement; // An Element cannot be a Stereotype
		}

		// It is not an Element: test if it is a Stereotype
		Element baseElement = UMLUtil.getBaseElement(inputElement);

		if (baseElement != null) {
			// Stereotype Application
			// We return the label of the Stereotyped element, not the one of the
			// StereotypeApplication itself
			return baseElement;
		}

		// This is another kind of EObject
		return inputElement;
	}

	@Override
	public String getText(Object element) {
		// For comments, we want to use hard coded labels. Do not use the EMF Facet label Provider
		EObject eObject = EMFHelper.getEObject(element);
		if (eObject instanceof Comment) {
			return getText(eObject);
		}

		if ((!(eObject instanceof Element)) && UMLUtil.getBaseElement(eObject) instanceof Comment) {
			return getText(eObject);
		}
		
		if (eObject instanceof Property) {
			// Ensure that the item provider is attached to send label updates
			labelProvider.getText(element);

			return getText((Property) eObject);
		}

		return super.getText(element);
	}

	protected String getText(final Property property) {
		final StringBuffer text = new StringBuffer();

		final Type type = property.getType();

		if (property.isDerived()) {
			appendString(text, "/"); //$NON-NLS-1$
		}

		final String label = UMLLabelInternationalization.getInstance().getLabel(property, shouldTranslate());

		if (!UML2Util.isEmpty(label)) {
			appendString(text, label);
		} else if (property.getAssociation() != null && type != null) {
			final String typeName = UMLLabelInternationalization.getInstance().getLabel(type, shouldTranslate());

			if (!UML2Util.isEmpty(typeName)) {
				if (property instanceof ExtensionEnd) {
					appendString(text, "extension_" + typeName);
				} else {
					appendString(text, Character.toLowerCase(typeName.charAt(0))
						+ typeName.substring(1));
				}
			}
		}

		if (type != null) {
			final String typeLabel = type.getLabel(shouldTranslate());

			if (!UMLUtil.isEmpty(typeLabel)) {
				appendString(text, ": " + typeLabel); //$NON-NLS-1$
			}
		}

		if (property.eIsSet(UMLPackage.Literals.MULTIPLICITY_ELEMENT__LOWER)
			|| property.eIsSet(UMLPackage.Literals.MULTIPLICITY_ELEMENT__UPPER)) {
			final String multiplicityAsString = MultiplicityElementUtil.getMultiplicityAsString(property);
			if (!multiplicityAsString.isEmpty()) {
				text.append(multiplicityAsString);
			}
		}
		
		return text.toString();
	}
	
	protected StringBuffer appendString(StringBuffer text, String string) {
		if (!UML2Util.isEmpty(string)) {
			if (text.length() > 0) {
				text.append(' ');
			}
			text.append(string);
		}
		return text;
	}
	
	protected StringBuffer appendKeywords(StringBuffer text, Property property) {
		final Iterator<Stereotype> appliedStereotypes = property
			.getAppliedStereotypes().iterator();
		final Iterator<String> keywords = property.getKeywords().iterator();

		if (appliedStereotypes.hasNext() || keywords.hasNext()) {
			if (text.length() > 0) {
				text.append(' ');
			}
			text.append("<<"); //$NON-NLS-1$

			while (appliedStereotypes.hasNext()) {
				text.append(appliedStereotypes.next().getKeyword(
					shouldTranslate()));

				if (appliedStereotypes.hasNext() || keywords.hasNext()) {
					text.append(", "); //$NON-NLS-1$
				}
			}

			while (keywords.hasNext()) {
				text.append(keywords.next());

				if (keywords.hasNext()) {
					text.append(", "); //$NON-NLS-1$
				}
			}

			text.append(">>"); //$NON-NLS-1$
		}

		return text;
	}
	
	protected boolean shouldTranslate() {
		return UMLEditPlugin.INSTANCE.shouldTranslate();
	}
	
	/**
	 *
	 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
	 *
	 * @param element
	 * @return
	 *         <ul>
	 *         <li>if element is a {@link NamedElement}, we return its name</li>
	 *         <li>else if element is a {@link Element}, we return its type + a index</li>
	 *         <li>else return Messages#EditorLabelProvider_No_name</li>
	 *         </ul>
	 */
	@Override
	protected String getText(EObject element) {
		element = resolveElement(element);

		if (element == null) {
			return "<Undefined>";
		}

		// Ensure that the item provider is attached to send label updates
		final String defaultLabel = labelProvider.getText(element);

		if (element instanceof org.eclipse.uml2.uml.Image) {
			// imageName
			// location
			// imageName : location
			// Image
			org.eclipse.uml2.uml.Image image = ((org.eclipse.uml2.uml.Image) element);

			String imageName = ImageUtil.getName(image);
			String location = image.getLocation();

			if (isEmptyString(imageName)) {
				if (isEmptyString(location)) {
					return "Image";
				}
				return location;
			}

			if (isEmptyString(location)) {
				return imageName;
			}

			return imageName + " : " + location; //$NON-NLS-1$
		} else if (element instanceof PackageImport) {
			return defaultLabel;
		} else if (element instanceof ElementImport) {
			return defaultLabel;
		} else if (element instanceof PackageMerge) {
			return defaultLabel;
		} else if (element instanceof NamedElement) {
			if (element instanceof ValueSpecification) { // Format : [name=]value
				String value = null;
				if (element instanceof InstanceValue) {
					InstanceSpecification specification = ((InstanceValue) element).getInstance();
					if (specification != null) {
						value = getText(specification);
					}
				} else if (element instanceof LiteralString) {
					value = "\"" + ((ValueSpecification) element).stringValue() + "\""; //$NON-NLS-1$ //$NON-NLS-2$
				} else if (element instanceof LiteralNull) {
					value = "null";
				} else {
					value = ((ValueSpecification) element).stringValue();
				}

				if (value != null) {
					if (((NamedElement) element).isSetName() && null != ((NamedElement) element).getName()) {
						return UMLLabelInternationalization.getInstance().getLabel(((NamedElement) element), shouldTranslate()) + "=" + value; //$NON-NLS-1$
					} else {
						// TODO: Maybe use labelInternationalization? But how qualifiedName must be set?
						return value;
					}
				} else {
					if (((NamedElement) element).isSetName() && null != ((NamedElement) element).getName()) {
						return UMLLabelInternationalization.getInstance().getLabel(((NamedElement) element), shouldTranslate());
					} else {
						// TODO: Maybe use labelInternationalization? But how qualifiedName must be set?
						return ""; //$NON-NLS-1$
					}
				}
			} else {
				return defaultLabel;
			}
		} else if (element instanceof Comment) {
			Comment comment = (Comment) element;
			return getText(comment);
		} else if (element instanceof PackageMerge) {
			return defaultLabel;
		}
		// TODO: Temporary solution for template parameters
		// Note: In the class diagram, for template parameters,
		// org.eclipse.papyrus.uml.diagram.clazz.custom.parsers.TemplateParameterParser is used for computing the label
		// This code is duplicated here in the following "else" clause, as well as in the "displayOperation" method
		else if (element instanceof TemplateParameter) {
			final TemplateParameter templateParam = (TemplateParameter) element;
			if (templateParam.getParameteredElement() == null) {
				return "<UNDEFINED>";
			}
			String out = "";
			if (templateParam.getParameteredElement() instanceof NamedElement) {
				NamedElement namedElement = (NamedElement) templateParam.getParameteredElement();
				out = UMLLabelInternationalization.getInstance().getLabel(namedElement, shouldTranslate()) + ": " + namedElement.eClass().getName();
			}

			if (templateParam instanceof OperationTemplateParameter) {
				if (templateParam.getParameteredElement() != null) {
					Operation op = (Operation) (templateParam.getParameteredElement());
					out = displayOperation(op);
				}
			} else if (templateParam instanceof ClassifierTemplateParameter) {
				if (!((ClassifierTemplateParameter) templateParam).getConstrainingClassifiers().isEmpty()) {
					out = out + ">";
					for (int i = 0; i < ((ClassifierTemplateParameter) templateParam).getConstrainingClassifiers().size(); i++) {
						out = out + UMLLabelInternationalization.getInstance().getLabel(((ClassifierTemplateParameter) templateParam).getConstrainingClassifiers().get(i), shouldTranslate());
						if (i < ((ClassifierTemplateParameter) templateParam).getConstrainingClassifiers().size() - 1) {
							out = out + ", ";
						}
					}

				}
			}
			if (templateParam.getDefault() instanceof Operation) {
				out = out + "=" + displayOperation((Operation) templateParam.getDefault());
			} else if (templateParam.getDefault() instanceof NamedElement) {
				out = out + "=" + UMLLabelInternationalization.getInstance().getLabel(((NamedElement) templateParam.getDefault()), shouldTranslate());
			}
			return out;
		}
		// TODO: Temporary solution for template parameter substitutions
		// Note: In the class diagram, for template parameters,
		// org.eclipse.papyrus.uml.diagram.clazz.custom.parsers.TemplateBindingParser is used for computing the label
		// This code is duplicated here in the following "else" clause
		else if (element instanceof TemplateParameterSubstitution) {
			String out = "";
			TemplateParameterSubstitution substitution = (TemplateParameterSubstitution) element;
			if (substitution.getFormal() != null && substitution.getFormal().getParameteredElement() instanceof NamedElement) {
				out = out + UMLLabelInternationalization.getInstance().getLabel(((NamedElement) substitution.getFormal().getParameteredElement()), shouldTranslate());
			}
			if (substitution.getActual() instanceof NamedElement) {
				out = out + " -> " + UMLLabelInternationalization.getInstance().getLabel(((NamedElement) substitution.getActual()), shouldTranslate()) + "\n";
			}
			return out;
		}
		// END TODO
		else if (element instanceof Element) {
			return defaultLabel;
		}

		return super.getText(element);
	}

	/**
	 * Returns a truncated string representing the body of the comment
	 *
	 * @param comment
	 * @return
	 */
	protected String getText(Comment comment) {
		TextReferencesHelper helper = new NameReferencesHelper(comment.eResource()) {

			@Override
			protected String decorate(String text) {
				return text; // Do not decorate the string. Html is not supported in most cases
			}
		};

		String body = comment.getBody();

		if (body == null) {
			return "<Empty Comment>";
		}

		// Truncate extra lines
		int nIndex = body.indexOf('\n');
		int rIndex = body.indexOf('\r');

		int minIndex = -1;

		if (nIndex > -1) { // Multiline
			if (rIndex > -1) {
				minIndex = Math.min(nIndex, rIndex);
			} else {
				minIndex = nIndex;
			}
		} else if (rIndex > -1) {
			minIndex = rIndex;
		}

		boolean isTruncated = false;

		String singleLineText;
		if (minIndex > -1) { // Multiline
			singleLineText = body.substring(0, minIndex);
			isTruncated = true;
		} else {
			singleLineText = body;
		}

		// Replace references

		singleLineText = helper.replaceReferences(singleLineText);

		// Truncate long texts

		String truncatedText;
		int maxLength = 60;
		if (singleLineText.length() > maxLength) {
			truncatedText = singleLineText.substring(0, maxLength);
			isTruncated = true;
		} else {
			truncatedText = singleLineText;
		}

		// Append truncated marker
		if (isTruncated) {
			truncatedText += "...";
		}

		return truncatedText;
	}

	private boolean isEmptyString(String s) {
		return s == null || s.trim().equals(""); //$NON-NLS-1$
	}

	/**
	 * Computes the label corresponding to an UML Operation
	 *
	 * @param op
	 *            the operation from which the label is computed
	 * @return the label
	 */
	protected String displayOperation(Operation op) {
		String out = UMLLabelInternationalization.getInstance().getLabel(op, shouldTranslate()) + "(";
		Iterator<Parameter> iter = op.getOwnedParameters().iterator();
		while (iter.hasNext()) {
			Parameter param = iter.next();
			out = out + UMLLabelInternationalization.getInstance().getLabel(param, shouldTranslate());
			if (!param.equals(op.getOwnedParameters().get(op.getOwnedParameters().size() - 1))) {
				out = out + ", ";
			}
		}
		out = out + ")";
		return out;

	}

	@Override
	protected EObject getParent(EObject object) {
		return (object instanceof Element) ? ((Element) object).getOwner() : super.getParent(object);
	}

	@Override
	protected String getQualifiedText(EObject object) {
		return (object instanceof NamedElement) ? ((NamedElement) object).getQualifiedName() : super.getQualifiedText(object);
	}

	@Override
	public void addListener(ILabelProviderListener listener) {
		listeners.addIfAbsent(listener);

		super.addListener(listener);
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		super.removeListener(listener);

		listeners.remove(listener);
	}
}
