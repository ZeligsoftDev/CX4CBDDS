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
package com.zeligsoft.base.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.infra.core.resource.ReadOnlyAxis;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.emf.readonly.ReadOnlyManager;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Element;

/**
 * Utility class
 * 
 * @author ysroh
 * 
 */
public class BaseUtil {

	public static final String ZCX_ANNOTATION_SOURCE = "zcx"; //$NON-NLS-1$
	
	public static final String UML_MODEL_EXTENSION = "uml"; //$NON-NLS-1$
	
	public static final String ZCX_MODEL_LIBRARY_KEY = "model_library"; //$NON-NLS-1$


	/**
	 * Return sorted list of give EObjects
	 * 
	 * @param elements
	 * @return
	 * @throws IllegalArgumentException
	 */
	@SuppressWarnings("rawtypes")
	public static List sortEObjectsByName(Collection elements)
			throws IllegalArgumentException {
		Map<String, EObject> map = new HashMap<String, EObject>();
		for (Object o : elements) {
			if (o instanceof EObject) {
				map.put(EMFCoreUtil.getName((EObject) o), (EObject) o);
			} else {
				throw new IllegalArgumentException();
			}
		}
		Object[] keyArray = map.keySet().toArray();
		Arrays.sort(keyArray);
		List<EObject> result = new ArrayList<EObject>();
		for (Object key : keyArray) {
			result.add(map.get(key));
		}
		return result;
	}

	
	public static Command getDeleteCommand(EObject selectedElement) {
		return getDeleteCommand(Collections.singletonList(selectedElement));
	}
	
	/**
	 * Delete element command
	 * @param selectedElements
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Command getDeleteCommand(Collection<EObject> selectedElements) {

		ICommand gmfCommand = null;

		Map parameters = new HashMap();

		for (EObject selectedEObject : selectedElements) {

			if (selectedEObject == null) {
				continue;
			}

			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(selectedEObject);
			if (provider == null) {
				continue;
			}

			DestroyElementRequest request = new DestroyElementRequest(selectedEObject, false);
			request.getParameters().putAll(parameters);

			ICommand deleteCommand = provider.getEditCommand(request);

			// Add current EObject destroy command to the global command
			gmfCommand = CompositeCommand.compose(gmfCommand, deleteCommand);

			// Store the new parameters for next delete command.
			parameters.clear();
			parameters.putAll(request.getParameters());
		}

		if (gmfCommand == null) {
			return UnexecutableCommand.INSTANCE;
		}

		return GMFtoEMFCommandWrapper.wrap(gmfCommand.reduce());
	}
	
	/**
	 * Queries the boolean value of ZCX annotation detail
	 * 
	 * @param context
	 * @param detail
	 * @param defaultValue
	 * @return
	 */
	public static String getZCXAnnotationDetail(Element context, String detail,
			String defaultValue) {
		EAnnotation anno = context.getEAnnotation(ZCX_ANNOTATION_SOURCE);
		String value = null;
		if (anno != null) {
			value = anno.getDetails().get(detail);
		}
		if (value == null) {
			return defaultValue;
		}
		return value;
	}

	/**
	 * puts the boolean value of ZCX annotation detail
	 * 
	 * @param context
	 * @param detail
	 * @param value
	 */
	@SuppressWarnings("unlikely-arg-type")
	public static void putZCXAnnotationDetail(Element context, String detail,
			String value) {
		
		EAnnotation anno = context.getEAnnotation(ZCX_ANNOTATION_SOURCE);
		if (anno == null && !UML2Util.isEmpty(value)) {
			anno = context.createEAnnotation(ZCX_ANNOTATION_SOURCE);
		}
		if (UML2Util.isEmpty(value)) {
			anno.getDetails().remove(detail);
			if(anno.getDetails().isEmpty()) {
				EcoreUtil.delete(anno);
			}
		} else {
			anno.getDetails().put(detail, value);
		}
	}
	
	/**
	 * Queries if the given model is a read-only model
	 * 
	 * @param context
	 * @return
	 */
	public static boolean isReadOnlyReferencedModel(EObject context) {
		if(context == null || context.eResource() == null) {
			return false;
		}
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(context);
		if (domain != null
				&& ReadOnlyManager.getReadOnlyHandler(domain).isReadOnly(ReadOnlyAxis.anyAxis(), context).or(false)) {
			// resource is read-only
			return true;
		}
		return false;
	}
}