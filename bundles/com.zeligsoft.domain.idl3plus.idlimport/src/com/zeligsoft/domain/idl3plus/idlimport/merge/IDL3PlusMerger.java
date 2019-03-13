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
package com.zeligsoft.domain.idl3plus.idlimport.merge;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Type;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;
import com.zeligsoft.domain.omg.corba.idlimport.merge.IDLElementKey;
import com.zeligsoft.domain.omg.corba.idlimport.merge.IDLMerger;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Merger that understands IDL3+ concepts.
 * 
 * @author smcfee
 *
 */
public class IDL3PlusMerger extends IDLMerger {

	@Override
	protected com.zeligsoft.base.util.ModelMerger.IKeyExtractor<EObject, IHierarchicalKey> createKeyExtractor() {

		return new IDL3KeyExtractor<EObject, IHierarchicalKey>();
		
	}
	
	protected static class IDL3KeyExtractor<T extends EObject, K extends IHierarchicalKey> implements IKeyExtractor<T, K> {

		@SuppressWarnings("unchecked")
		public K getKey(T element) {
			
			if( ZDLUtil.isZDLConcept(element, CORBADomainNames.CORBANAMED_ELEMENT) == true ) {
				return (K) new IDLElementKey(element);			
			} else if( ZDLUtil.isZDLConcept(element, IDL3PlusNames.MODULE_BINDING)) {
				return (K) new ModuleBindingKey(element);
			} else if( ZDLUtil.isZDLConcept(element, IDL3PlusNames.PARAMETER_BINDING)) {
				return (K) new ParameterBindingKey(element);
			} else if( ZDLUtil.isZDLConcept(element, CCMNames.PROPERTY)) {
				return (K) new PropertyKey(element);
			} else if( ZDLUtil.isZDLConcept(element, CCMNames.MONOLITHIC_IMPLEMENTATION)) {
				return (K) new MonolithicImplementationKey(element);
			}
			return null;
		}
		
	}
	
	/**
	 * Create a customized pruner.
	 * 
	 * @return an IDL pruner
	 */
	@Override
	protected TargetPruner createTargetPruner() {
		return new IDL3TargetPruner();
	}
	
	protected class IDL3TargetPruner extends IDLTargetPruner {
		
		@Override
		protected void prune(EObject object) {
			
			EObject source = findSource(object);

			if (source == null ) {
				if( ZDLUtil.isZDLConcept(object, CCMNames.PROPERTY) == false) {
					super.prune(object);
				}
				// and don't continue down the tree
			} else {
				// prune mergeable feature values that are not in the source
				// model. Don't propagate null values from the source model
				// because we consider them as "uninitialized"
				for (EStructuralFeature feature : object.eClass()
					.getEAllStructuralFeatures()) {
					if (isMergeableFeature(object, feature)) {
						if (FeatureMapUtil.isMany(object, feature)) {
							EList<?> targetValue = (EList<?>) object
								.eGet(feature);
							EList<?> sourceValue = (EList<?>) source
								.eGet(feature);

							targetValue.retainAll(sourceValue);
						} else if (source.eIsSet(feature)
							&& (source.eGet(feature) == null)) {
							object.eSet(feature, null);
						}
					}
				}

				// continue down the tree
				pruneContents(object);
			}
		}
	}
	
	@Override
	protected List<EObject> getContentsToMerge(EObject object, Phase phase) {

		List<EObject> result = super.getContentsToMerge(object, phase);

		if (object instanceof Element && (
				ZDLUtil.isZDLConcept(object, CORBADomainNames.CORBANAMED_ELEMENT) ||
				ZDLUtil.isZDLConcept(object, CCMNames.PROPERTY) ||
				ZDLUtil.isZDLConcept(object, CCMNames.MONOLITHIC_IMPLEMENTATION)	
			)) {
			// the stereotype applications also have to be merged.
			Element element = (Element) object;

			List<EObject> stereos = element.getStereotypeApplications();
			if (!stereos.isEmpty()) {
				result = safeList(result, phase);
				result.addAll(stereos);
			}
		}

		return result;
	}
	
	@Override
	protected ReferenceFixer createReferenceFixer() {
		return new IDL3ReferenceFixer();
	}
	
	/**
	 * An IDL reference fixer that extends the IDL reference fixer to
	 * fix references to ports.
	 * 
	 * @author Sean McFee
	 */
	protected class IDL3ReferenceFixer extends IDLReferenceFixer {

		/**
		 * Recursively fixes references in the specified <tt>objects</tt> and
		 * their children.
		 * 
		 * @param objects
		 *            a list of objects whose references are to be fixed
		 */
		@Override
		protected void fixReferences(List<EObject> objects) {
			for (EObject next : objects) {
				if (fixReferences(next)) {
					fixReferences(getContentsToMerge(next, Phase.FIX));
				}
			}
		}

		/**
		 * Implements the cross-reference fixing behaviour for an object in the
		 * target model.
		 * 
		 * @param object
		 *            an object whose references should be fixed
		 * @return whether to continue into the descendants of the object
		 */
		@Override
		protected boolean fixReferences(EObject object) {
			super.fixReferences(object);
			EObject container = object.eContainer();
			
			if( ZDLUtil.isZDLConcept(object, CCMNames.INTERFACE_PORT)) {
				
				EObject fixedRole = null; // Old port reference that needs to be updated
				
				for( TreeIterator<EObject> iter = object.eResource().getAllContents(); iter.hasNext(); ) {
					EObject next = iter.next();
					
					if( next instanceof ConnectorEnd ) {
						
						ConnectorEnd ce = (ConnectorEnd)next;
						if( fixableInterfacePort(object, ce, container)) {
							fixedRole = ce.getRole();
							ce.setRole((Port)object);
						}
					} 
				}
				
				for( TreeIterator<EObject> iter = object.eResource().getAllContents(); iter.hasNext(); ) {
					EObject next = iter.next();
					
					if( next instanceof Node ) {
						Node node = (Node)next;
						if( node.getElement() instanceof Port ) {
							Port nodeElement = (Port)node.getElement();
							if( nodeElement == fixedRole ) {
								node.setElement(object);
							}
						}
					}
				}
			}
			
			return true;
		}
		
		private boolean fixableInterfacePort(EObject importedPort, ConnectorEnd ce, EObject importedPortContainer) {
			ConnectableElement role = ce.getRole();
			if( ce.getPartWithPort() == null ) {
				return false;
			}
			Type type = ce.getPartWithPort().getType();
			if( role instanceof Port ) {
				Port rolePort = (Port)role;
				return ZDLUtil.getValue(importedPort, ZMLMMNames.NAMED_ELEMENT, ZMLMMNames.NAMED_ELEMENT__NAME).equals(rolePort.getName())
					&& importedPort != ce.getRole() // if they are the same object there is no fixing needed	
					&& importedPortContainer == type;
			} 
			
			return false;
		}

	}
}
