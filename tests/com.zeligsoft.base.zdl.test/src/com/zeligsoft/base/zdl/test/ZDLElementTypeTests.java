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
package com.zeligsoft.base.zdl.test;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.SpecializationType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ibm.xtools.modeler.ui.UMLModeler;
import com.zeligsoft.base.zdl.type.ZDLElementType;
import com.zeligsoft.base.zdl.type.ZDLElementTypeManager;
import com.zeligsoft.base.zdl.type.ZDLElementTypeUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Tests for ZDLElementTypes and Util.
 * 
 * @author jcorchis
 * 
 */
public class ZDLElementTypeTests  {

	private Resource modelResource = null;

	private org.eclipse.uml2.uml.Element root = null;

	private static Profile domainProfile = null;

	private TransactionalEditingDomain domain = null;

	@Before
	public void setUp()
			throws Exception {

		URI modelURI = URI.createPlatformPluginURI(
			"com.zeligsoft.base.zdl.test/models/my_model.emx", true); //$NON-NLS-1$
		// TODO: RSM dependency
		root = UMLModeler.openModelResource(modelURI);
		modelResource = root.eResource();

		domain = TransactionalEditingDomain.Factory.INSTANCE
			.getEditingDomain(modelResource.getResourceSet());

		assertNotNull("Test model resource not available", modelResource); //$NON-NLS-1$
		assertTrue("Test model resource not loaded", modelResource.isLoaded()); //$NON-NLS-1$

		Collection<Profile> profiles = ZDLUtil.getZDLProfiles(root);
		domainProfile = (Profile) profiles.toArray()[0];

		assertEquals("MyDomain", domainProfile.getName());//$NON-NLS-1$
	}

	@After
	public void tearDown()
			throws Exception {

		modelResource.unload();
		modelResource.eAdapters().clear();
		modelResource.getResourceSet().getResources().remove(modelResource);
	}

	/**
	 * Tests that the expected ZDL and Specialization type ids match the
	 * expected id pattern.
	 */
	@Test
	public void test_ZDLElementTypeUtilNames() {

		String ZDL_APPLICATION_ID = "com.zeligsoft.zdl.MyDomain__MyBlock__Application";//$NON-NLS-1$
		String SPECIALIZATION_APP_ID = "com.zeligsoft.zdl.MyDomain.MyDomain__MyBlock__Application";//$NON-NLS-1$

		// ZDL tests
		String applicationId = ZDLElementTypeUtil
			.getZDLElementTypeId(MyDomainNames.APPLICATION);
		assertEquals(ZDL_APPLICATION_ID, applicationId);
		applicationId = null;

		Stereotype applicationStereotype = (Stereotype) domainProfile
			.getOwnedMember("Application");//$NON-NLS-1$
		List<NamedElement> defs = ZDLUtil
			.getZDLDefinition(applicationStereotype);
		org.eclipse.uml2.uml.Class concept = (org.eclipse.uml2.uml.Class) defs
			.get(0);
		applicationId = ZDLElementTypeUtil.getZDLElementTypeId(concept);
		assertEquals(ZDL_APPLICATION_ID, applicationId);

		// Stereotype tests
		applicationId = ZDLElementTypeUtil.getZDLSpecializationElementTypeId(
			domainProfile, MyDomainNames.APPLICATION);
		assertEquals(SPECIALIZATION_APP_ID, applicationId);
		applicationId = null;
		applicationId = ZDLElementTypeUtil.getZDLSpecializationElementTypeId(
			domainProfile, concept);
		assertEquals(SPECIALIZATION_APP_ID, applicationId);

	}
	
	/**
	 * Test the contents of the ZDL ElementType and SpecialiationTypes
	 */
	@Test
	public void test_VerifyElementType() {
		
		ElementTypeRegistry reg = ElementTypeRegistry.getInstance();
		
		// Check the ZDL type for the application concept.
		String applicationId = ZDLElementTypeUtil
		.getZDLElementTypeId(MyDomainNames.APPLICATION);
		
		IElementType type = reg.getType(applicationId);
		assert(type instanceof ZDLElementType);
		ZDLElementType t = (ZDLElementType) type;
		assertEquals(t.getDomainConcept(), MyDomainNames.APPLICATION);
		assertEquals(t.getDisplayName(), "Application");//$NON-NLS-1$
		assertEquals(t.getSpecializedTypeIds()[0], ZDLElementTypeUtil
			.getZDLElementTypeId(ZMLMMNames.STRUCTURAL_REALIZATION));
		assertNull(t.getEClass());
		
		// Check the corresponding specialization type.
		applicationId = ZDLElementTypeUtil
			.getZDLSpecializationElementTypeId(domainProfile,
				MyDomainNames.APPLICATION);

		type = reg.getType(applicationId);
		assertNotNull(type instanceof SpecializationType);
		SpecializationType st = (SpecializationType) type;
		assertEquals(st.getEClass(), UMLPackage.eINSTANCE.getComponent());
		String id = ZDLElementTypeManager.INSTANCE.getElementTypeIdFromHint("component");//$NON-NLS-1$
		assertEquals(st.getSpecializedTypeIds()[0], id);
		assertEquals(
			st.getIconURL().toString(),
			"platform:/plugin/com.zeligsoft.domain.zml/icons/full/obj16/structuralRealization.gif");//$NON-NLS-1$
		assertEquals(st.getDisplayName(), "Application");//$NON-NLS-1$
	
	}

	/**
	 * Test the creation of the ZDL ElementType and SpecialiationTypes
	 * 
	 * @throws ExecutionException
	 */
	@Test
	public void test_CreateElementsUsingZDLElementTypes()
			throws ExecutionException {

		// Test using generated id
		ElementTypeRegistry reg = ElementTypeRegistry.getInstance();
		String applicationId = ZDLElementTypeUtil
			.getZDLSpecializationElementTypeId(domainProfile,
				MyDomainNames.APPLICATION);

		IClientContext ctx = ZDLElementTypeUtil.getClientContext(root);
		IElementType type = reg.getType(applicationId);
		assertNotNull(type);

		CreateElementRequest req = new CreateElementRequest(domain, root, type);
		req.setClientContext(ctx);
		ICommand cmd = getCommand(req);
		EObject application = null;
		if (cmd != null && cmd.canExecute()) {
			try {
				OperationHistoryFactory.getOperationHistory().execute(cmd,
					new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
				//
			}
			CommandResult result = cmd.getCommandResult();
			application = (EObject) result.getReturnValue();
		}

		assertNotNull(application);
		assertTrue(ZDLUtil.isZDLConcept(application, MyDomainNames.APPLICATION));
		assertEquals(application.eContainer(), root);

		cmd = null;
		req = null;

		// Test using the get type to create from ZDLElementTypeUtil
		type = ZDLElementTypeUtil.getElementType(root,
			MyDomainNames.APPLICATION);

		req = new CreateElementRequest(domain, root, type);
		req.setClientContext(ctx);
		cmd = getCommand(req);
		EObject application2 = null;
		if (cmd != null && cmd.canExecute()) {
			try {
				OperationHistoryFactory.getOperationHistory().execute(cmd,
					new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
				assertTrue(e.getLocalizedMessage(), false);
			}
			CommandResult result = cmd.getCommandResult();
			application2 = (EObject) result.getReturnValue();
		}

		assertNotNull(application2);
		assertTrue(ZDLUtil.isZDLConcept(application2, MyDomainNames.APPLICATION));
		assertEquals(application2.eContainer(), root);

	}

	private ICommand getCommand(CreateElementRequest request) {
		if (request != null) {
			IElementType contextType = ElementTypeRegistry.getInstance()
				.getElementType(request.getEditHelperContext());

			if (contextType != null) {
				ICommand createCommand = contextType.getEditCommand(request);

				if (createCommand != null && createCommand.canExecute()) {
					return createCommand;
				}
			}
		}

		return null;
	}

}
