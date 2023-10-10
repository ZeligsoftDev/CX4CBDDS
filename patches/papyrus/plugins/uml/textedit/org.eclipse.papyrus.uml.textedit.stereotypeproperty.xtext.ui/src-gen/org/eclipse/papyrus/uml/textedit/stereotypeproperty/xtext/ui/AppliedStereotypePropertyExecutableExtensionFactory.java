/*
 * generated by Xtext
 */
package org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.ui;

import org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.ui.internal.AppliedStereotypePropertyActivator;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass.
 */
public class AppliedStereotypePropertyExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return AppliedStereotypePropertyActivator.getInstance().getBundle();
	}

	@Override
	protected Injector getInjector() {
		return AppliedStereotypePropertyActivator.getInstance().getInjector(AppliedStereotypePropertyActivator.ORG_ECLIPSE_PAPYRUS_UML_TEXTEDIT_STEREOTYPEPROPERTY_XTEXT_APPLIEDSTEREOTYPEPROPERTY);
	}

}