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
package com.zeligsoft.domain.posix.codegen.test.util;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

/**
 * This utility class loads populates EMF objects describing various elements in the TokenRingCluster
 * test model.
 */
public class TokenRingClusterElements {

	private static final Resource TokenRingCluster
		= new ResourceSetImpl().createResource(
				URI.createURI( CodegenTestUtil.getLocalURL("Models/TokenRingCluster.emx").toString(), true ) );
	static {
		try { TokenRingCluster.load( null ); }
		catch( IOException e ) { e.printStackTrace(); }
	}

	public static final EObject Deployment = TokenRingCluster.getEObject("_TCG3Ac09Ed2T4qWTq06etg");
	public static final EObject producer = TokenRingCluster.getEObject("_TYTqEePyEd2du4DC-pMM2Q");
	public static final EObject consumer = TokenRingCluster.getEObject("_TYTqE-PyEd2du4DC-pMM2Q");
	public static final EObject client_a = TokenRingCluster.getEObject("_T4yg8ePyEd2du4DC-pMM2Q");
	public static final EObject client_b = TokenRingCluster.getEObject("_T4yg8-PyEd2du4DC-pMM2Q");
	public static final EObject process1 = TokenRingCluster.getEObject("_NZMnUOPyEd2du4DC-pMM2Q");
	public static final EObject process2 = TokenRingCluster.getEObject("_N-wLcOPyEd2du4DC-pMM2Q");
	public static final EObject process3 = TokenRingCluster.getEObject("_OXolgOPyEd2du4DC-pMM2Q");

	public static final EObject Producer_in = TokenRingCluster.getEObject("_O9MFoMu0Ed2n-J82rpDHeA");
	public static final EObject Producer_out = TokenRingCluster.getEObject("_byhcgMu4Ed2n-J82rpDHeA");
	public static final EObject TokenOwner_out = TokenRingCluster.getEObject("_lONdMMufEd2n9582rpDHeA");
	public static final EObject TokenOwner_in = TokenRingCluster.getEObject("_kUPvUMufEd2n9582rpDHeA");
}
