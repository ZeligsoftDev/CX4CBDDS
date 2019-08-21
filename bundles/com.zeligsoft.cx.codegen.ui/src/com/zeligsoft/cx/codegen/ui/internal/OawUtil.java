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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.xtend.expression.AbstractExpressionsUsingWorkflowComponent;
import org.eclipse.xtend.typesystem.MetaModel;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;
import org.eclipse.xtend.typesystem.uml2.profile.ProfileMetaModel;

import com.zeligsoft.base.util.IWorkflowCallbacks;
import com.zeligsoft.base.util.WorkflowUtil;
import com.zeligsoft.base.zdl.oaw.ZDLMetamodel;
import com.zeligsoft.cx.build.factory.ProjectFactory;
import com.zeligsoft.cx.codegen.editor.IEditSourceExtraParamFactory;
import com.zeligsoft.cx.codegen.editor.IUserEditableElementDescriptor;
import com.zeligsoft.cx.codegen.ui.CodeGenUIPlugin;
import com.zeligsoft.cx.codegen.ui.l10n.Messages;

public class OawUtil
{
	private static final String PLATFORM_URI = "platform-uri"; //$NON-NLS-1$
	private static final String MODEL_URI_STRING = "modelURI"; //$NON-NLS-1$
	private static final String ELEMENT_STRING = "element"; //$NON-NLS-1$
	private static final String BUILD_ELEMENT = "buildElement"; //$NON-NLS-1$
	private static final String DESC = "elementdescriptor"; //$NON-NLS-1$

	private static final String M2M_RULE = "m2m-rule"; //$NON-NLS-1$
	private static final String M2M_OUTPUT = "m2m-output"; //$NON-NLS-1$
	private static final String M2M_METAMODEL_CLASSES = "m2m-metaModelClasses"; //$NON-NLS-1$
	private static final String M2M_PROFILE_METAMODELS = "m2m-profileMetaModels"; //$NON-NLS-1$
	private static final String M2M_EMF_METAMODEL_PACKAGES = "m2m-emfMetaModelPackages"; //$NON-NLS-1$
	private static final String M2M_ZDL_METAMODELS = "m2m-zdlMetaModels"; //$NON-NLS-1$

	private static final String M2T_RULE = "m2t-rule"; //$NON-NLS-1$
	private static final String M2T_METAMODEL_CLASSES = "m2t-metaModelClasses"; //$NON-NLS-1$
	private static final String M2T_PROFILE_METAMODELS = "m2t-profileMetaModels"; //$NON-NLS-1$
	private static final String M2T_EMF_METAMODEL_PACKAGES = "m2t-emfMetaModelPackages"; //$NON-NLS-1$
	private static final String M2T_ZDL_METAMODELS = "m2t-zdlMetaModels"; //$NON-NLS-1$

	private static final String GENERATED_PROJECT = "generatedProject"; //$NON-NLS-1$
	private static final String SRC_GEN = "src-gen"; //$NON-NLS-1$

	/**
	 * Creates and returns an oaw properties map that can be used to generate the argument
	 * model element within an OAW workflow.
	 */
	public static Map<String, String> createGenProperties( EObject element )
	{
		Map<String, String> map = new HashMap<String, String>();

		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		String location = root.getLocation().toOSString();
		map.put( PLATFORM_URI, location );
		map.put( MODEL_URI_STRING, element.eResource().getURI().toString() );
		return map;
	}

	public static boolean applyWorkflowProperties( Map<String, String> map, IUserEditableElementDescriptor desc )
	{
		// supports one (optional) M2M transformation
		boolean hasM2M = false;
		for( IUserEditableElementDescriptor.IM2MTransformationDescriptor m2mDesc : desc.getM2MDescriptors() )
		{
			if( hasM2M )
			{
				CodeGenUIPlugin.getDefault().error( Messages.UserEditableElement_OnlyOneM2MSupported, null );
				continue;
			}

			map.put( M2M_RULE, m2mDesc.getRule()  );
			map.put( M2M_OUTPUT, m2mDesc.getOutput() );
			map.put( M2M_METAMODEL_CLASSES, buildList( m2mDesc.getMetaModelClasses() ) );
			map.put( M2M_PROFILE_METAMODELS, buildList( m2mDesc.getUmlProfiles() ) );
			map.put( M2M_EMF_METAMODEL_PACKAGES, buildList( m2mDesc.getEMFMetaModelPackages() ) );
			map.put( M2M_ZDL_METAMODELS, buildList( m2mDesc.getZDLMetaModels() ) );
			hasM2M = true;
		}

		// supports one M2T transformation
		boolean hasM2T = false;
		for( IUserEditableElementDescriptor.IM2TTransformationDescriptor m2tDesc : desc.getM2TDescriptors() )
		{
			if( hasM2T )
			{
				CodeGenUIPlugin.getDefault().error( Messages.UserEditableElement_ExactlyOneM2TSupported, null );
				continue;
			}

			map.put( M2T_RULE, m2tDesc.getRule()  );
			map.put( M2T_METAMODEL_CLASSES, buildList( m2tDesc.getMetaModelClasses() ) );
			map.put( M2T_PROFILE_METAMODELS, buildList( m2tDesc.getUmlProfiles() ) );
			map.put( M2T_EMF_METAMODEL_PACKAGES, buildList( m2tDesc.getEMFMetaModelPackages() ) );
			map.put( M2T_ZDL_METAMODELS, buildList( m2tDesc.getZDLMetaModels() ) );
			hasM2T = true;
		}

		if( ! hasM2T )
			CodeGenUIPlugin.getDefault().error( Messages.UserEditableElement_ExactlyOneM2TSupported, null );

		return true;
	}

	private static String buildList( Iterable<String> values )
	{
		boolean first = true;
		StringBuilder list = new StringBuilder();
		if( values != null )
			for( String value : values )
			{
				if( first )
					first = false;
				else
					list.append( ',' );

				list.append( value );
			}

		return list.toString();
	}

	private static Iterable<String> parseStringList( String list )
	{
		List<String> values = new LinkedList<String>();
		for( int l = 0, n = 0; n >= 0; l = n + 1 )
		{
			n = list.indexOf( ',', l );
			String value
				= n < 0
					? list.substring( l )
					: list.substring( l, n );
			value = value.trim();
			if( ! value.isEmpty() )
				values.add( value );
		}

		return values;
	}

	@SuppressWarnings("unchecked")
	public static void setMetaModelClasses( AbstractExpressionsUsingWorkflowComponent wfComp, String metaModels )
	{
		for( String metaModel : OawUtil.parseStringList( metaModels ) )
		{
			try
			{
				Class<MetaModel> mmClass = (Class<MetaModel>)Class.forName( metaModel );
				wfComp.addMetaModel( mmClass.newInstance() );
			}
			catch( ClassNotFoundException e )
			{
				CodeGenUIPlugin.getDefault().error(
					NLS.bind( Messages.UserEditableElement_CannotFindMetaModelClass, metaModel ),
					e );
			}
			catch( IllegalAccessException e )
			{
				CodeGenUIPlugin.getDefault().error(
					NLS.bind( Messages.UserEditableElement_CannotCreateMetaModelInstance, metaModel ),
					e );
			}
			catch( InstantiationException e )
			{
				CodeGenUIPlugin.getDefault().error(
					NLS.bind( Messages.UserEditableElement_CannotCreateMetaModelInstance, metaModel ),
					e );
			}
		}
	}

	public static void setProfileMetaModels( AbstractExpressionsUsingWorkflowComponent wfComp, String profiles )
	{
		for( String profile : OawUtil.parseStringList( profiles ) )
		{
			ProfileMetaModel mm = new ProfileMetaModel();
			mm.addProfile( profile );
			wfComp.addMetaModel( mm );
		}
	}

	public static void setEMFMetaModelPackages( AbstractExpressionsUsingWorkflowComponent wfComp, String mmPackages )
	{
		for( String mmPackage : OawUtil.parseStringList( mmPackages ) )
		{
			EmfMetaModel mm = new EmfMetaModel();
			mm.setMetaModelPackage( mmPackage );
			wfComp.addMetaModel( mm );
		}
	}

	public static void setZDLMetaModels( AbstractExpressionsUsingWorkflowComponent wfComp, String zdlMMs )
	{
		for( String zdlMM : OawUtil.parseStringList( zdlMMs ) )
		{
			ZDLMetamodel mm = new ZDLMetamodel();
			mm.setZdl( zdlMM );
			wfComp.addMetaModel( mm );
		}
	}

	public static Map<String, Object> createExternalSlots( EObject element, IUserEditableElementDescriptor desc )
	{
		Map<String, Object> slots = new HashMap<String, Object>();
		slots.put( ELEMENT_STRING, element );
		slots.put( DESC, desc );

		for( IUserEditableElementDescriptor.IM2MTransformationDescriptor m2mDesc : desc.getM2MDescriptors() )
			for( IEditSourceExtraParamFactory paramFactory : m2mDesc.getExtraParamFactories() )
				paramFactory.populateExtraSlots( slots, element );

		return slots;
	}

	/**
	 * Applies the properties that are required by the workflow to build the code generated for
	 * the argument element.  This method will build the output project if required.
	 * @return true the project into which code is generated or null if the project could not
	 *              be created
	 */
	public static IProject applyProjectProperties( Map<String, String> map, EObject element, IProgressMonitor monitor )
	{
		return applyProjectProperties( map, element, monitor , ProjectFactory.MODE_CREATE_BASIC);
	}
	
	public static IProject applyProjectProperties( Map<String, String> map, EObject element, IProgressMonitor monitor , int mode)
	{
		IProject project = ProjectFactory.getProject( element, monitor, mode );
		if( project == null )
			return null;

		if( element instanceof NamedElement )
			map.put( BUILD_ELEMENT, ( (NamedElement)element ).getQualifiedName() );

		map.put( GENERATED_PROJECT, project.getName() );
		map.put( SRC_GEN, project.getLocation().makeAbsolute().toOSString() );
		return project;
	}

	public static IStatus createFilesIn( IProject project, Map<String, String> properties, IProgressMonitor monitor, IWorkflowCallbacks callbacks )
	{
		try
		{
			return WorkflowUtil.executeWorkflow( callbacks, callbacks.getWorkflowUrl(), monitor, properties );
		}
		finally
		{
			try
			{
				project.refreshLocal( IResource.DEPTH_INFINITE, monitor );
			}
			catch( CoreException e )
			{
				CodeGenUIPlugin.getDefault()
					.error( Messages.TransformAction_ProjectRefreshFailedLog, e );
			}
		}
	}

	public static void openEditors( final Iterable<IFile> files, final EObject element, final IUserEditableElementDescriptor desc, final MultiStatus rc )
	{
		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				for( IFile file : files )
					try
					{
						IEditorPart part = IDE.openEditor( page, file );
						if( desc.getCodeLocator() != null )
						{
							int line = desc.getCodeLocator().getLineNumber( file, element, desc.getConcept(), desc.getProperty() );
							if( line > 0
							 && ! navigateWithSelectAndReveal( rc, part, file, line ) )
								navigateWithMarker( rc, part, file, line );
						}
					}
					catch( PartInitException e )
					{
						rc.add( new Status( IStatus.ERROR, CodeGenUIPlugin.PLUGIN_ID, e.getMessage() ) );
					}
			}
		} );
	}

	/**
	 * Attempt to make visible the relevant portion of the file using the more efficient
	 * selectAndReveal API.  Return true if successful and false otherwise.
	 */
	private static boolean navigateWithSelectAndReveal( MultiStatus rc, IEditorPart part, IFile file, int line )
	{
		if( ! ( part instanceof ITextEditor ) )
			return false;

		ITextEditor textEditor = (ITextEditor)part;
		IDocument doc = textEditor.getDocumentProvider().getDocument( part.getEditorInput() );
		if( doc == null )
			return false;

		try
		{
			textEditor.selectAndReveal( doc.getLineOffset( line ), 0 );
			return true;
		}
		catch( BadLocationException e )
		{
			rc.add( new Status( IStatus.ERROR, CodeGenUIPlugin.PLUGIN_ID, e.getMessage() ) );
		}

		return false;
	}

	/**
	 * Attempt to make visible the relevant portion of the file using the less efficient
	 * gotoMarker API.  Return true if successful and false otherwise.
	 */
	private static boolean navigateWithMarker( MultiStatus rc, IEditorPart part, IFile file, int line )
	{
		try
		{
			IMarker marker = file.createMarker( IMarker.MARKER );
			marker.setAttribute( IMarker.LINE_NUMBER, line );
			IDE.gotoMarker( part, marker );
			return true;
		}
		catch( CoreException e )
		{
			rc.add( new Status( IStatus.ERROR, CodeGenUIPlugin.PLUGIN_ID, e.getMessage() ) );
		}

		return false;
	}
}
