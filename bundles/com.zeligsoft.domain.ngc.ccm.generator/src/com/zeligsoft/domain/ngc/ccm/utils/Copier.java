package com.zeligsoft.domain.ngc.ccm.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class Copier {

	public static EObject copy(EObject eObject) {
		if (com.zeligsoft.cx.codegen.internal.OawDebug.isDebugEnabled()) {
			System.out.println("making copy of " + eObject.toString());
			for (EObject sub: eObject.eContents()) {
				System.out.println("\t" + sub.toString());
			};
		}
		EcoreUtil.Copier copier = new EcoreUtil.Copier();
		EObject result = copier.copy(eObject);
		copier.copyReferences();
		// TODO: Copy EAnnotations
//		if (eObject instanceof EModelElement) {
//			EModelElement elem = (EModelElement) eObject;
//			EList<EAnnotation> annotations = elem.getEAnnotations();
//			// Copy EAnnotations
//		}
		return result;
	}
	
	public static Object copy(Object obj) {
		if (obj instanceof EObject) {
			System.out.println("copy: copying an EObject " + obj);
			return copy((EObject)obj);
		} else {
			System.out.println("copy: returning same object " + obj);
		}
		return obj;
	}

	public static <T> EList<T> copyAll(EList<T> eList) {
		EcoreUtil.Copier copier = new EcoreUtil.Copier();
		Collection<T> collection = copier.copyAll(eList);
		EList<T> result = new BasicEList<T>(collection);
		copier.copyReferences();
		return result;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List copyListOfEObjects(List list) {
		List listCopy = new ArrayList();
		for (Object obj : list) {
			Object objCopy = copy(obj);
			listCopy.add(objCopy);
		}
		return listCopy;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List copyAll(List obj) {
		if (obj instanceof EList) {
			System.out.println("copyAll: copying an EList " + obj);
			return copyAll((EList)obj);
		} else if (obj instanceof List) {
			System.out.println("copyAll: copying a List of EObjects " + obj);
			List<?> copy = copyListOfEObjects(obj);
			return copy;
		} else {
			System.out.println("copyAll: returning same object");
		}
		return obj;
	}

	@SuppressWarnings({ "rawtypes" })
	public static Object copyAll(Object obj) {
		if (obj instanceof List) {
			System.out.println("copyAll: copying a List Object" + obj);
			return copyAll((List)obj);
		}
		return obj;
	}

}
