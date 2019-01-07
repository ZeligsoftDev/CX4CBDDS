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
package com.zeligsoft.domain.omg.corba.idlimport.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.junit.Test;

/**
 * Test IDL import preprocessor
 * 
 * @author ysroh
 * 
 */
@SuppressWarnings("nls")
public class PreprocessorTests extends IDLImportTestCase {

	@Test
	public void testInclude() {
		ArrayList<String> idlFiles = new ArrayList<String>();
		idlFiles.add("idl/preprocess/test_include/test.idl");

		final boolean importOk = importIDL(idlFiles);

		// make sure that there were no issues
		assertTrue(importOk);

		String qualifiedPath = modelName + "::" + IMPORTED_PACKAGE_NAME;

		// find all of the elements that were supposed to be created
		// during the import action
		String interface1 = qualifiedPath.concat("::test");

		EObject idlFileElement = lookup(interface1);
		EObject twoPartThree = lookup(interface1 + "::TwoPartThree");
		EObject twoPartTwo = lookup(interface1 + "::TwoPartTwo");
		EObject twoPartThreeInterface = lookup(interface1
				+ "::TwoPartThree::SecondInterface");
		EObject twoPartTwoInterface = lookup(interface1 + "::TwoPartTwo::SecondInterface");

		String interface2 = qualifiedPath.concat("::test30");
		EObject idlFileElement2 = this.lookup(interface2);
		EObject moduleA = lookup(interface2 + "::A");
		EObject moduleB = lookup(interface2 + "::A::B");
		EObject intfC = lookup(interface2 + "::A::B::C");

		assertIDLFile(idlFileElement);
		assertModule(twoPartThree);
		assertModule(twoPartTwo);
		assertInterface(twoPartThreeInterface);
		assertInterface(twoPartTwoInterface);

		assertIDLFile(idlFileElement2);
		assertModule(moduleA);
		assertModule(moduleB);
		assertInterface(intfC);

	}

	@Test
	public void testIncludesAndDefines() {
		ArrayList<String> idlFiles = new ArrayList<String>();
		idlFiles.add("idl/preprocess/test_includes_and_defines_1/test.idl");

		List<String> includes = new ArrayList<String>();
		File file = new File(URI.createFileURI("idl/preprocess/test_includes_and_defines_2").devicePath());
		includes.add(file.getAbsolutePath());

		List<String> defines = new ArrayList<String>();
		defines.add("TEST");

		final boolean importOk = importIDL(idlFiles, includes, defines);

		// make sure that there were no issues
		assertTrue(importOk);

		String qualifiedPath = modelName + "::" + IMPORTED_PACKAGE_NAME;

		// find all of the elements that were supposed to be created
		// during the import action
		String interface1 = qualifiedPath.concat("::test");

		EObject idlFileElement = lookup(interface1);
		EObject twoPartThree = lookup(interface1 + "::TwoPartThree");
		EObject twoPartTwo = lookup(interface1 + "::TwoPartTwo");
		EObject twoPartThreeInterface = lookup(interface1
				+ "::TwoPartThree::SecondInterface");
		EObject twoPartTwoInterface = lookup(interface1 + "::TwoPartTwo::SecondInterface");

		String interface2 = qualifiedPath.concat("::test30");
		EObject idlFileElement2 = this.lookup(interface2);
		EObject testD = lookup(interface2 + "::testD");
		EObject testDInterface = lookup(interface2 + "::testD::aa");

		EObject moduleA = lookup(interface2 + "::A");
		EObject moduleB = lookup(interface2 + "::A::B");
		EObject intfC = lookup(interface2 + "::A::B::C");

		assertIDLFile(idlFileElement);
		assertModule(twoPartThree);
		assertModule(twoPartTwo);
		assertInterface(twoPartThreeInterface);
		assertInterface(twoPartTwoInterface);

		assertModule(testD);
		assertInterface(testDInterface);

		assertIDLFile(idlFileElement2);
		assertModule(moduleA);
		assertModule(moduleB);
		assertInterface(intfC);

	}
	
	@Test
	public void testIncludesAndDefines2() {
		ArrayList<String> idlFiles = new ArrayList<String>();
		idlFiles.add("idl/preprocess/test_includes_and_defines_1/test.idl");

		List<String> includes = new ArrayList<String>();
		File file = new File(URI.createFileURI("idl/preprocess/test_includes_and_defines_2").devicePath());
		includes.add(file.getAbsolutePath());

		List<String> defines = new ArrayList<String>();
		//In this test, we are making sure that the elements under the 'TEST' define
		//are not imported if the 'TEST' defines is not defined
		//defines.add("TEST");

		final boolean importOk = importIDL(idlFiles, includes, defines);

		// make sure that there were no issues
		assertTrue(importOk);

		String qualifiedPath = modelName + "::" + IMPORTED_PACKAGE_NAME;

		// find all of the elements that were supposed to be created
		// during the import action
		String interface1 = qualifiedPath.concat("::test");

		EObject idlFileElement = lookup(interface1);
		EObject twoPartThree = lookup(interface1 + "::TwoPartThree");
		EObject twoPartTwo = lookup(interface1 + "::TwoPartTwo");
		EObject twoPartThreeInterface = lookup(interface1
				+ "::TwoPartThree::SecondInterface");
		EObject twoPartTwoInterface = lookup(interface1 + "::TwoPartTwo::SecondInterface");

		String interface2 = qualifiedPath.concat("::test30");
		EObject idlFileElement2 = this.lookup(interface2);
		EObject testD = lookup(interface2 + "::testD");
		EObject testDInterface = lookup(interface2 + "::testD::aa");

		EObject moduleA = lookup(interface2 + "::A");
		EObject moduleB = lookup(interface2 + "::A::B");
		EObject intfC = lookup(interface2 + "::A::B::C");

		assertIDLFile(idlFileElement);
		assertModule(twoPartThree);
		assertModule(twoPartTwo);
		assertInterface(twoPartThreeInterface);
		assertInterface(twoPartTwoInterface);

		assertNull(testD);
		assertNull(testDInterface);

		assertIDLFile(idlFileElement2);
		assertModule(moduleA);
		assertModule(moduleB);
		assertInterface(intfC);

	}
	
	@Test
	public void testExcludes1(){
		ArrayList<String> idlFiles = new ArrayList<String>();
		idlFiles.add("idl/preprocess/test_excludes1/test.idl");

		List<String> includes = new ArrayList<String>();
		List<String> defines = new ArrayList<String>();
		
		List<String> excludes = new ArrayList<String>();
		excludes.add("Components.idl");

		final boolean importOk = importIDL(idlFiles, includes, defines, excludes);

		// make sure that there were no issues
		assertTrue(importOk);
		
		// Ensure the proper elements were imported
		assertExcludes();
	}
	
	@Test
	public void testExcludes2(){
		ArrayList<String> idlFiles = new ArrayList<String>();
		idlFiles.add("idl/preprocess/test_excludes2/test.idl");

		List<String> includes = new ArrayList<String>();
		List<String> defines = new ArrayList<String>();
				
		List<String> excludes = new ArrayList<String>();
		excludes.add("Components.idl");

		final boolean importOk = importIDL(idlFiles, includes, defines, excludes);

		// make sure that there were no issues
		assertTrue(importOk);
		
		// Ensure the proper elements were imported
		assertExcludes();
	}
	
	@Test
	public void testExcludes3(){
		ArrayList<String> idlFiles = new ArrayList<String>();
		idlFiles.add("idl/preprocess/test_excludes3/test.idl");

		List<String> includes = new ArrayList<String>();
		List<String> defines = new ArrayList<String>();
		
		List<String> excludes = new ArrayList<String>();
		excludes.add("*nent?.idl");
		excludes.add("*never*");

		final boolean importOk = importIDL(idlFiles, includes, defines, excludes);

		// make sure that there were no issues
		assertTrue(importOk);
		
		// Ensure the proper elements were imported
		assertExcludes();
	}
	
	private void assertExcludes(){
		String qualifiedPath = modelName + "::" + IMPORTED_PACKAGE_NAME;

		// find all of the elements that were supposed to be created
		// during the import action
		String interface1 = qualifiedPath.concat("::test");
		
		EObject idlFileElement = lookup(interface1);
		EObject twoPartThree = lookup(interface1 + "::TwoPartThree");
		EObject twoPartTwo = lookup(interface1 + "::TwoPartTwo");
		EObject twoPartThreeInterface = lookup(interface1
				+ "::TwoPartThree::SecondInterface");
		EObject twoPartTwoInterface = lookup(interface1 + "::TwoPartTwo::SecondInterface");

		assertIDLFile(idlFileElement);
		assertModule(twoPartThree);
		assertModule(twoPartTwo);
		assertInterface(twoPartThreeInterface);
		assertInterface(twoPartTwoInterface);
	}
}
