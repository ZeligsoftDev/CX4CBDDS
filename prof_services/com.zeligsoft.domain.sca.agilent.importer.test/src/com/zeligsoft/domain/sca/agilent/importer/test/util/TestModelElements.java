package com.zeligsoft.domain.sca.agilent.importer.test.util;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.zeligsoft.domain.sca.agilent.SystemvueModel.DocumentRoot;
import com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModel;

public class TestModelElements {
	private static final Resource TestModel
		= new ResourceSetImpl().createResource(
				URI.createURI(AgilentImporterTestUtil.getLocalURL("models/test.systemvue").toString(), true));
	
	static {
		try {
			TestModel.load(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static final DocumentRoot DocRoot =
		(DocumentRoot) TestModel.getContents().get(0);
	public static final SystemvueModel Model =
		DocRoot.getSystemvueModel();
}
