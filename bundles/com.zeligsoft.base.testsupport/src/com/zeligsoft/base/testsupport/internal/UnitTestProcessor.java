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
package com.zeligsoft.base.testsupport.internal;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.osgi.framework.Bundle;

import com.zeligsoft.base.testsupport.annotations.ValidationTestSuite;
import com.zeligsoft.base.testsupport.annotations.ValidationUnitTest;
import com.zeligsoft.base.testsupport.model.ValidationModel.TestContainer;
import com.zeligsoft.base.testsupport.model.ValidationModel.UnitTest;
import com.zeligsoft.base.util.WorkflowUtil;


/**
 * A Java Annotation processor for in-house Validation JUnits to help us determine
 * coverage.
 * 
 * @author Sean McFee
 * 
 */
@SuppressWarnings("nls")
@SupportedSourceVersion(SourceVersion.RELEASE_6)
@SupportedAnnotationTypes({ 
	"com.zeligsoft.base.testsupport.annotations.ValidationUnitTest", 
	"com.zeligsoft.base.testsupport.annotations.ValidationTestSuite" })
public class UnitTestProcessor extends AbstractProcessor {

	private static ResourceSet unitTestResourceSet = new ResourceSetImpl();

	/*
	 * Default constructor
	 */
	public UnitTestProcessor() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.annotation.processing.AbstractProcessor#process(java.util.Set,
	 * javax.annotation.processing.RoundEnvironment)
	 */
	@Override
	public boolean process(Set<? extends TypeElement> annotations,
			RoundEnvironment roundEnv) {
		
		for (TypeElement typedElement : annotations) {
			processAnnotation(roundEnv, typedElement);
		}
		
		return true;
	}

	private void processAnnotation(RoundEnvironment roundEnv,
			TypeElement typedElement) {
		for (Element element : roundEnv.getElementsAnnotatedWith(typedElement)) {
			processElement(element);
		}
	}

	/**
	 * Process the TestCase/TestSuite annotation.
	 */
	private void processElement(Element element) {
		
		ValidationUnitTest test = element.getAnnotation(ValidationUnitTest.class);
		ValidationTestSuite suite = element.getAnnotation(ValidationTestSuite.class);
		
		if( test != null ) {
			processTestCase(element, test);	
		}
		if( suite != null ) {
			processTestSuite(element, suite);
		}
	}

	private static Map<String, String> packageToModelMap = new HashMap<String, String>();
	
	private static void processTestSuite( Element element, ValidationTestSuite suite ) {
	
		String key = element.getEnclosingElement().toString();
		
		if( packageToModelMap.containsKey(key) == false) {
			packageToModelMap.put(key, suite.domainModel());
		}
	}
	
	/**
	 * Process the test case; open the validation model and mark the constraints
	 * validated by the test as covered.
	 */
	private static void processTestCase(Element element, ValidationUnitTest annot) {
		
		String[] constraints = annot.constraintVerified();
		
		try {
			
		
		Element container = element.getEnclosingElement();
		String name = (String) container.toString().subSequence(0, container.toString().lastIndexOf("."));
		URI uri = URI.createFileURI(Platform.getLocation().toString() + "/" + name + "/models/validationModel.valModel");
		
		java.net.URI javaUri = new java.net.URI(uri.toString());
		File file = new File(javaUri);
		if( !file.exists()) {
			generateValidationModel(uri, container);
		}
		
		Resource r = unitTestResourceSet.getResource(uri, true);
		TestContainer testContainer = (TestContainer) r.getContents().get(0);
		
		for( String s : constraints ) {
			for( UnitTest test : testContainer.getTests()) {
				if( test.getId().matches(s)) {
					test.setIsTested(true);
				}
			}
		}
		
		r.save(null);
		r.unload();
		unitTestResourceSet.getResources().remove(r);
		
		} catch( Exception e ) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Generate the validation model for a plug-in.
	 * 
	 * @param modelURI
	 * @param container
	 */
	public static void generateValidationModel(URI modelURI, Element container) {

		String modelName = packageToModelMap.get(container.getEnclosingElement().toString());
		
		if( modelName == null ) {
			return;
		}
		
		URI mmLoc = URI.createPlatformPluginURI(modelName, true);
		Resource res = unitTestResourceSet.getResource(mmLoc, true);
		if( res == null ) {
			return;
		}
		EObject model = res.getContents().get(0);
		
		Map<String, Object> slotContents = new HashMap<String, Object>();
		slotContents.put("model", model);//$NON-NLS-1$
		Map<String, String> parameters = new HashMap<String, String>();
		
		slotContents.put("targetURI", modelURI); //$NON-NLS-1$

		Bundle bundle = Platform.getBundle("com.zeligsoft.base.testsupport"); //$NON-NLS-1$
		URL workflow = bundle.getResource("com/zeligsoft/base/testsupport/oaw/domainModelToValidationModel.oaw"); //$NON-NLS-1$
		WorkflowUtil.executeWorkflow (workflow, new NullProgressMonitor(), parameters, slotContents);
		
		res.unload();
		unitTestResourceSet.getResources().remove(res);
	}
}
