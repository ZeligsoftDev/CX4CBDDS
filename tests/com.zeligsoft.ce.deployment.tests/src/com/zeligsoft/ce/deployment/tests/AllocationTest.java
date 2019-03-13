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
package com.zeligsoft.ce.deployment.tests;

import com.zeligsoft.ce.deployment.Allocation;
import com.zeligsoft.ce.deployment.DeploymentFactory;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Allocation</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AllocationTest extends TestCase {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	//public static final String copyright = "* Copyright (c) 2008 Zeligsoft Inc.\r\n *\r\n * All rights reserved. \r\n *  \r\n * THIS PROGRAM IS THE UNPUBLISHED, PROPRIETARY PROPERTY OF ZELIGSOFT INC. AND\r\n * IS TO BE MAINTAINED IN STRICT CONFIDENCE.  UNAUTHORIZED REPRODUCTION, \r\n * DISTRIBUTION OR DISCLOSURE OF THIS PROGRAM, OR ANY PROGRAM DERIVED FROM IT,\r\n * IS STRICTLY PROHIBITED.";
	public static final String copyright = "* Copyright 2018 ADLINK Technology Limited. \r\n *\r\nLicensed under the Apache License, Version 2.0";
	/**
	 * The fixture for this Allocation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Allocation fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AllocationTest.class);
	}

	/**
	 * Constructs a new Allocation test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllocationTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Allocation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Allocation fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Allocation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Allocation getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(DeploymentFactory.eINSTANCE.createAllocation());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //AllocationTest
