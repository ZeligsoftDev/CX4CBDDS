/**
 * Copyright 2018 ADLINK Technology Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.cx.codegen.ui.internal;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.osgi.util.NLS;

import com.zeligsoft.cx.codegen.editor.ICodeLocator;
import com.zeligsoft.cx.codegen.editor.IEditSourceExtraParamFactory;
import com.zeligsoft.cx.codegen.editor.IUserEditableElementDescriptor;
import com.zeligsoft.cx.codegen.editor.IValidationFactory;
import com.zeligsoft.cx.codegen.ui.CodeGenUIPlugin;
import com.zeligsoft.cx.codegen.ui.l10n.Messages;

public class UserEditableElementFactory
{
	public static final String ELEMENT_TAG = "usereditableelement"; //$NON-NLS-1$

	private static final String LABEL_ATTR = "label"; //$NON-NLS-1$
	private static final String CONCEPT_ATTR = "concept"; //$NON-NLS-1$
	private static final String CONTAINER_CONCEPT_ATTR = "containerConcept"; //$NON-NLS-1$
	private static final String PROPERTY_ATTR = "property"; //$NON-NLS-1$

	private static final String M2M_TRANSFORMATION_ELEMENT = "m2m-transformation"; //$NON-NLS-1$
	private static final String M2T_TRANSFORMATION_ELEMENT = "m2t-transformation"; //$NON-NLS-1$
	private static final String ORDER_ATTR = "order"; //$NON-NLS-1$
	private static final String OUTPUT_ATTR = "output"; //$NON-NLS-1$
	private static final String RULE_ATTR = "rule"; //$NON-NLS-1$
	private static final String EXTRAPARAMFACTORY_ELEMENT = "extraparamfactory"; //$NON-NLS-1$
	private static final String CLASS_ATTR = "class"; //$NON-NLS-1$

	private static final String METAMODELCLASS_ELEMENT = "metamodelclass"; //$NON-NLS-1$
	private static final String UMLPROFILE_ELEMENT = "umlprofile"; //$NON-NLS-1$
	private static final String EMFMETAMODELPACKAGE_ELEMENT = "emfmetamodelpackage"; //$NON-NLS-1$
	private static final String ZDLMETAMODEL_ELEMENT = "zdlmetamodel"; //$NON-NLS-1$
	private static final String VALUE_ATTR = "value"; //$NON-NLS-1$

	private static final String CODELOCATOR_ATTR = "codeLocator"; //$NON-NLS-1$
	private static final String VALIDATIONFACTORY_ATTR = "validationFactory"; //$NON-NLS-1$

	private static class UserEditableElementDescriptor implements IUserEditableElementDescriptor
	{
		public String label;
		public String concept;
		public String containerConcept;
		public String property;
		public ICodeLocator codeLocator;
		public IValidationFactory validationFactory;
		public List<IUserEditableElementDescriptor.IM2MTransformationDescriptor> m2mDescs = new LinkedList<IUserEditableElementDescriptor.IM2MTransformationDescriptor>();
		public List<IUserEditableElementDescriptor.IM2TTransformationDescriptor> m2tDescs = new LinkedList<IUserEditableElementDescriptor.IM2TTransformationDescriptor>();

		@Override
		public String getLabel() { return this.label; }
		@Override
		public String getConcept() { return this.concept; }
		@Override
		public String getContainerConcept() { return this.containerConcept; }
		@Override
		public String getProperty() { return this.property; }
		@Override
		public ICodeLocator getCodeLocator() { return this.codeLocator; }
		@Override
		public IValidationFactory getValidationFactory() { return this.validationFactory; }
		@Override
		public Iterable<IUserEditableElementDescriptor.IM2MTransformationDescriptor> getM2MDescriptors() { return this.m2mDescs; }
		@Override
		public Iterable<IUserEditableElementDescriptor.IM2TTransformationDescriptor> getM2TDescriptors() { return this.m2tDescs; }
	}

	private static abstract class AbstractTransformation
	{
		public int order = 0;
		public String rule;
		public List<String> metaModelClasses = new LinkedList<String>();
		public List<String> umlProfiles = new LinkedList<String>();
		public List<String> emfPackages = new LinkedList<String>();
		public List<String> zdlMetaModels = new LinkedList<String>();

		public int getOrder() { return this.order; }
		public String getRule() { return this.rule; }
		public Iterable<String> getMetaModelClasses() { return this.metaModelClasses; }
		public Iterable<String> getUmlProfiles() { return this.umlProfiles; }
		public Iterable<String> getEMFMetaModelPackages() { return this.emfPackages; }
		public Iterable<String> getZDLMetaModels() { return this.zdlMetaModels; }

		protected void populate( IConfigurationElement configElement )
		{
			String orderStr = getStringAttr( configElement, ORDER_ATTR, null );
			if( orderStr != null )
				try { this.order = Integer.parseInt( orderStr ); }
				catch( NumberFormatException e )
				{
					CodeGenUIPlugin.getDefault().error(
							NLS.bind( Messages.UserEditableElement_BadOrderInteger, orderStr ),
							e );
				}

			this.rule = getStringAttr( configElement, RULE_ATTR, Messages.UserEditableElement_ExtensionMissingAttribute );

			for( IConfigurationElement child : configElement.getChildren() )
			{
				if( METAMODELCLASS_ELEMENT.equals( child.getName() ) )
					this.metaModelClasses.add( getStringAttr( child, VALUE_ATTR, Messages.UserEditableElement_ExtensionMissingAttribute ) );
				else if( UMLPROFILE_ELEMENT.equals( child.getName() ) )
					this.umlProfiles.add( getStringAttr( child, VALUE_ATTR, Messages.UserEditableElement_ExtensionMissingAttribute ) );
				else if( EMFMETAMODELPACKAGE_ELEMENT.equals( child.getName() ) )
					this.emfPackages.add( getStringAttr( child, VALUE_ATTR, Messages.UserEditableElement_ExtensionMissingAttribute ) );
				else if( ZDLMETAMODEL_ELEMENT.equals( child.getName() ) )
					this.zdlMetaModels.add( getStringAttr( child, VALUE_ATTR, Messages.UserEditableElement_ExtensionMissingAttribute ) );
			}
		}
	}

	private static class M2MTransformation extends AbstractTransformation implements IUserEditableElementDescriptor.IM2MTransformationDescriptor
	{
		private String output;
		private List<IEditSourceExtraParamFactory> extraParamFactories = new LinkedList<IEditSourceExtraParamFactory>();

		@Override
		public String getOutput() { return this.output; }
		@Override
		public Iterable<IEditSourceExtraParamFactory> getExtraParamFactories() { return this.extraParamFactories; }

		public M2MTransformation populateFrom( IConfigurationElement configElement )
		{
			super.populate( configElement );
			this.output = getStringAttr( configElement, OUTPUT_ATTR, Messages.UserEditableElement_ExtensionMissingAttribute );
			for( IConfigurationElement child : configElement.getChildren() )
			{
				if( EXTRAPARAMFACTORY_ELEMENT.equals( child.getName() ) )
				{
					IEditSourceExtraParamFactory f
						= getEditSourceParamFactory( child, CLASS_ATTR, Messages.UserEditableElement_ExtensionMissingAttribute );
					if( f != null )
						extraParamFactories.add( f );
				}
			}

			return this;
		}
	}

	private static class M2TTransformation extends AbstractTransformation implements IUserEditableElementDescriptor.IM2TTransformationDescriptor
	{
		public M2TTransformation populateFrom( IConfigurationElement configElement )
		{
			super.populate( configElement );
			return this;
		}
	}

	public static IUserEditableElementDescriptor create( IConfigurationElement configElement )
	{
		UserEditableElementDescriptor desc = new UserEditableElementDescriptor();

		desc.label = getStringAttr( configElement, LABEL_ATTR, Messages.UserEditableElement_ExtensionMissingAttribute );
		desc.concept = getStringAttr( configElement, CONCEPT_ATTR, Messages.UserEditableElement_ExtensionMissingAttribute );
		desc.containerConcept = getStringAttr( configElement, CONTAINER_CONCEPT_ATTR, null );
		desc.property = getStringAttr( configElement, PROPERTY_ATTR, Messages.UserEditableElement_ExtensionMissingAttribute );

		desc.codeLocator = getCodeLocatorAttr( configElement, CODELOCATOR_ATTR, Messages.UserEditableElement_ExtensionMissingAttribute );
		desc.validationFactory = getValidationFactoryAttr( configElement, VALIDATIONFACTORY_ATTR, null );

		for( IConfigurationElement child : configElement.getChildren() )
		{
			String elementName = child.getName();
			if( M2M_TRANSFORMATION_ELEMENT.equals( elementName ) )
				desc.m2mDescs.add( new M2MTransformation().populateFrom( child ) );
			else if( M2T_TRANSFORMATION_ELEMENT.equals( elementName ) )
				desc.m2tDescs.add( new M2TTransformation().populateFrom( child ) );
		}

		return desc;
	}

	private static String getStringAttr( IConfigurationElement configElement, String attrName, String errorMessage )
	{
		String value = configElement.getAttribute( attrName );
		if( value != null )
			return value;

		// attribute is optional when #errorMessage is null
		if( errorMessage != null )
			CodeGenUIPlugin.getDefault().error(
				NLS.bind( errorMessage, configElement.getNamespaceIdentifier() ),
				null );

		return null;
	}

	private static ICodeLocator getCodeLocatorAttr( IConfigurationElement configElement, String attrName, String errorMessage )
	{
		if( configElement.getAttribute( attrName ) == null )
		{
			// attribute is optional when #errorMessage is null
			if( errorMessage != null )
				CodeGenUIPlugin.getDefault().error(
						NLS.bind( errorMessage, configElement.getNamespaceIdentifier() ),
						null );
			return null;
		}

		Object inst = null;
		try
		{
			inst = configElement.createExecutableExtension( attrName );
		}
		catch( CoreException e )
		{
			CodeGenUIPlugin.getDefault().error(
					NLS.bind(
						Messages.UserEditableElement_BadClassName,
						ICodeLocator.class.getName(),
						configElement.getNamespaceIdentifier() ),
					e );
			return null;
		}

		if( inst == null
		 || ! ( inst instanceof ICodeLocator ) )
		{
			CodeGenUIPlugin.getDefault().error(
					NLS.bind(
						Messages.EditSourceActionProvider_CodeLocatorWrongClass,
						configElement.getNamespaceIdentifier() ),
					null );
			return null;
		}

		return (ICodeLocator)inst;
	}

	private static IValidationFactory getValidationFactoryAttr( IConfigurationElement configElement, String attrName, String errorMessage )
	{
		if( configElement.getAttribute( attrName ) == null )
		{
			// attribute is optional when #errorMessage is null
			if( errorMessage != null )
				CodeGenUIPlugin.getDefault().error(
						NLS.bind( errorMessage, configElement.getNamespaceIdentifier() ),
						null );
			return null;
		}

		Object inst = null;
		try
		{
			inst = configElement.createExecutableExtension( attrName );
		}
		catch( CoreException e )
		{
			CodeGenUIPlugin.getDefault().error(
					NLS.bind(
						Messages.UserEditableElement_BadClassName,
						ICodeLocator.class.getName(),
						configElement.getNamespaceIdentifier() ),
					e );
			return null;
		}

		if( inst == null
		 || ! ( inst instanceof IValidationFactory ) )
		{
			CodeGenUIPlugin.getDefault().error(
					NLS.bind(
						Messages.EditSourceActionProvider_CodeLocatorWrongClass,
						configElement.getNamespaceIdentifier() ),
					null );
			return null;
		}

		return (IValidationFactory)inst;
	}
	
	private static IEditSourceExtraParamFactory getEditSourceParamFactory( IConfigurationElement configElement, String attrName, String errorMessage )
	{
		if( configElement.getAttribute( attrName ) == null )
		{
			// attribute is optional when #errorMessage is null
			if( errorMessage != null )
				CodeGenUIPlugin.getDefault().error(
						NLS.bind( errorMessage, configElement.getNamespaceIdentifier() ),
						null );
			return null;
		}

		Object inst = null;
		try
		{
			inst = configElement.createExecutableExtension( attrName );
		}
		catch( CoreException e )
		{
			CodeGenUIPlugin.getDefault().error(
					NLS.bind(
						Messages.UserEditableElement_BadClassName,
						ICodeLocator.class.getName(),
						configElement.getNamespaceIdentifier() ),
					e );
			return null;
		}

		if( inst == null
		 || ! ( inst instanceof IEditSourceExtraParamFactory ) )
		{
			CodeGenUIPlugin.getDefault().error(
					NLS.bind(
						Messages.EditSourceActionProvider_CodeLocatorWrongClass,
						configElement.getNamespaceIdentifier() ),
					null );
			return null;
		}

		return (IEditSourceExtraParamFactory)inst;
	}
}
