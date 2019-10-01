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
package com.zeligsoft.base.zdl.type;

import java.net.URL;
import java.util.Enumeration;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.ClientContextManager;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IContainerDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IElementTypeFactory;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationTypeDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.NullElementType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.osgi.util.NLS;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

import com.zeligsoft.base.ZeligsoftAbstractPlugin;
import com.zeligsoft.base.util.RSMUtil;
import com.zeligsoft.base.zdl.Activator;
import com.zeligsoft.base.zdl.l10n.Messages;
import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * Lazily-instantiated registry of ZDL Concept element types, delegating to the
 * GMF element type registry.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ZDLElementTypeManager {

	/** The shared ZDL element-type manager instance. */
	public static final ZDLElementTypeManager INSTANCE = new ZDLElementTypeManager();

	/** Set this parameter to true to ignore ZDL default stereotype check*/
	public static final String IGNORE_ZDL_STEREOTYPE_ADVICE = "ignoreZDLStereotype"; //$NON-NLS-1$

	private ZDLElementTypeManager() {
		super();

		// bind the types that we will generate to the UML context
		// TODO RSM-dependent
//		ClientContextManager.getInstance().getClientContext(
//			"com.zeligsoft.domain.cbdds.atcd.architecture").bindPattern( //$NON-NLS-1$
//			Pattern.compile("com\\.zeligsoft\\.zdl\\..*")); //$NON-NLS-1$
//		ClientContextManager.getInstance().getClientContext(
//				"com.zeligsoft.domain.cbdds.axcioma.architecture").bindPattern( //$NON-NLS-1$
//				Pattern.compile("com\\.zeligsoft\\.zdl\\..*")); //$NON-NLS-1$		
	}

	/**
	 * Obtains the element type representing the specified ZDL concept.
	 * 
	 * @param concept
	 *            a ZDL concept (in any resource-set context)
	 * @return the element type definition for the concept
	 */
	public IElementType getElementType(Class concept) {

		String id = ZDLElementTypeUtil.getZDLElementTypeId(concept);
		ElementTypeRegistry reg = ElementTypeRegistry.getInstance();
		IElementType result = reg.getType(id);

		if (result == null) {
			// create and inject an element type

			ISpecializationTypeDescriptor desc = new ZDLConceptTypeDescriptor(
				id, concept);
			IElementTypeFactory factory = reg.getElementTypeFactory(desc.getKindName());

			result = factory.createSpecializationType(desc);

			ElementTypeRegistry.getInstance().register(
				(ISpecializationType) result);

		}

		return result;
	}

	/**
	 * Obtains the element type representing the specified ZDL reference.
	 * 
	 * @param concept
	 *            a ZDL concept (in any resource-set context)
	 * @param reference
	 *            a reference property owned by the <tt>concept</tt>
	 * @return the element type definition of the concept
	 */
	public IElementType getElementType(Class concept, Property reference) {
		IElementType conceptType = getElementType(concept);

		String id = ZDLElementTypeUtil.getZDLElementTypeId(concept, reference);
		
		ElementTypeRegistry reg = ElementTypeRegistry.getInstance();
		IElementType result = reg.getType(id);

		if (result == null) {
			// create and inject an element type

			ISpecializationTypeDescriptor desc = new ZDLReferenceTypeDescriptor(
				id, conceptType, reference);
			IElementTypeFactory factory = reg.getElementTypeFactory(desc
				.getKindName());

			result = factory.createSpecializationType(desc);

			ElementTypeRegistry.getInstance().register(
				(ISpecializationType) result);

		}

		return result;
	}

	/**
	 * Obtains a stereotyped UML element type definition for the specified
	 * stereotype extension of a base UML type. This is not a ZDL element type,
	 * but it will extend the specified ZDL element type. This is appropriate
	 * for use in, say, creation tools that re-use the host application's
	 * element types for creation of stereotyped UML elements in a particular
	 * domain profile context.
	 * 
	 * @param zdl
	 *            the ZDL element type to extend
	 * @param umlBase
	 *            the UML element type describing the base metaclass of the
	 *            stereotype extension
	 * @param stereotype
	 *            the extending stereotype
	 * @return the new element type, which has a specialization of the ZDL type
	 *         and is based on the UML stereotype mapping
	 */
	public IElementType getStereotypeType(ZDLElementType zdl,
			IElementType umlBase, Stereotype stereotype) {

		String zdlSpecElementId = ZDLElementTypeUtil
			.getZDLSpecializationElementTypeId(stereotype.getProfile(), zdl
				.getDomainConcept());
		ISpecializationType specializationType = (ISpecializationType) ElementTypeRegistry
			.getInstance().getType(zdlSpecElementId);

		if (specializationType == null) {

			StereotypedElementTypeDescriptor desc = new StereotypedElementTypeDescriptor(
				zdl, umlBase, stereotype);

			IElementTypeFactory factory = ElementTypeRegistry.getInstance()
				.getElementTypeFactory(desc.getKindName());

			specializationType = factory.createSpecializationType(desc);

			ElementTypeRegistry.getInstance().register(specializationType);
			
		}
		return specializationType;
	}
	
	/**
	 * Obtains a stereotyped UML element type definition for the specified
	 * stereotype extension of a base UML type. This is not a ZDL element type,
	 * but it will extend the specified ZDL element type. This is appropriate
	 * for use in, say, creation tools that re-use the host application's
	 * element types for creation of stereotyped UML elements in a particular
	 * domain profile context.
	 * 
	 * @param zdl
	 *            the ZDL element type to extend
	 * @param hint
	 *            the element type hint
	 * @param stereotype
	 *            the extending stereotype
	 * @return the new element type, which has a specialization of the ZDL type
	 *         and is based on the hinted type mapping
	 */
	public IElementType getHintedStereotypedType(ZDLElementType zdl,
			String hint, Stereotype stereotype) {

		String zdlHintedSpecElementId = ZDLElementTypeUtil
			.getZDLHintedSpecializationElementTypeId(stereotype.getProfile(),
				zdl.getDomainConcept(), hint);

		ISpecializationType specializationType = (ISpecializationType) ElementTypeRegistry
			.getInstance().getType(zdlHintedSpecElementId);

		if (specializationType == null) {

			// Lookup the hint to find an appropriate type
			String hintedTypeId = ElementTypeMap.getElementTypeID(hint);
			IElementType hintedType = ElementTypeRegistry.getInstance()
				.getType(hintedTypeId);

			if (hintedType != null) {

				StereotypedElementTypeDescriptor desc = new StereotypedElementTypeDescriptor(
					zdlHintedSpecElementId, zdl, hintedType, stereotype);

				IElementTypeFactory factory = ElementTypeRegistry.getInstance()
					.getElementTypeFactory(desc.getKindName());

				specializationType = factory.createSpecializationType(desc);

				ElementTypeRegistry.getInstance().register(specializationType);

			} else {
				// Warn user hinted type could not be found.
				ZeligsoftAbstractPlugin.warning(Activator.getDefault(), NLS
					.bind(
						Messages.ZDLElementTypeManager_unabledToLoadHintedType,
						hint), null);
			}

		}

		return specializationType;
	}

	//
	// Nested types
	//

	/**
	 * A partial implementation of a specialization-type descriptor, used to
	 * specify the parameters of a specialization type to an element-type
	 * factory for instantiation.
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	private static abstract class AbstractSpecializationTypeDescriptor
			implements ISpecializationTypeDescriptor {

		private String id;

		private String name;
		
		private URL icon;

		protected IElementType[] base;

		AbstractSpecializationTypeDescriptor(String id, String name, URL icon) {
			this.id = id;
			this.name = name;
			this.icon = icon;
		}

		public String getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public IElementType[] getSpecializedTypes() {
			return base;
		}

		public URL getIconURL() {
			if (icon == null) {
				icon = base[0].getIconURL();
			}
			
			return icon;
		}

		public IContainerDescriptor getContainerDescriptor() {
			// never specified by the RSM-generated tooling
			return null;
		}

		public IElementMatcher getMatcher() {
			// a matcher will be assigned by the factory, if needed
			return null;
		}
	}

	/**
	 * A refinement of the abstract element-type descriptor, describing ZDL
	 * element types.
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	private static abstract class ZDLTypeDescriptor
			extends AbstractSpecializationTypeDescriptor {

		protected String concept;

		ZDLTypeDescriptor(String id, String concept, String name, URL icon) {
			super(id, name, icon);

			this.concept = concept;
		}

		public String getKindName() {
			return ZDLElementTypeFactory.KIND;
		}

		public String getParamValue(String paramName) {
			return ZDLElementTypeFactory.PARAM_CONCEPT.equals(paramName)
				? concept
				: null;
		}
	}

	/**
	 * A concrete element-type descriptor for ZDL Concept types.
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	private static class ZDLConceptTypeDescriptor
			extends ZDLTypeDescriptor {

		private IEditHelperAdvice advice;

		ZDLConceptTypeDescriptor(String id, Class concept) {
			super(id, concept.getQualifiedName(), concept.getLabel(), ZDLUtil.getIcon(concept));

			EList<Class> supers = concept.getSuperClasses();
			if (supers.isEmpty()) {
				this.base = new IElementType[]{NullElementType.getInstance()};
			} else {
				this.base = new IElementType[supers.size()];

				for (int i = 0; i < base.length; i++) {
					base[i] = ZDLElementTypeManager.INSTANCE
						.getElementType(supers.get(i));
				}
			}

			this.advice = new ZDLConceptAdvice(id, this.concept, concept
				.getLabel());
		}

		public IEditHelperAdvice getEditHelperAdvice() {
			return advice;
		}
	}

	/**
	 * A concrete element-type descriptor for ZDL Reference types.
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	private static class ZDLReferenceTypeDescriptor
			extends ZDLTypeDescriptor {

		protected String reference;

		private IEditHelperAdvice advice;

		ZDLReferenceTypeDescriptor(String id, IElementType conceptType,
				Property reference) {
			super(id, ((ZDLElementType) conceptType).getDomainConcept(), NLS
				.bind(Messages.ZDLElementTypeManager_reyTypeName, conceptType
					.getDisplayName(), reference.getLabel()), ZDLUtil.getIcon(reference));

			this.reference = reference.getName();
			this.base = new IElementType[]{NullElementType.getInstance()};

			this.advice = new ZDLReferenceAdvice(id, this.concept,
				this.reference, getName());
		}

		@Override
		public String getParamValue(String paramName) {
			return ZDLElementTypeFactory.PARAM_REFERENCE.equals(paramName)
				? reference
				: super.getParamValue(paramName);
		}

		public IEditHelperAdvice getEditHelperAdvice() {
			return advice;
		}

		@Override
		public URL getIconURL() {
			URL result = super.getIconURL();
			
			if (result == null) {
				result = Activator.getDefault().getBundle().getEntry(
					"icons/obj16/zdl_reference.gif"); //$NON-NLS-1$
			}
			
			return result;
		}
	}

	/**
	 * A concrete element-type descriptor for stereotyped UML element types.
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	private static class StereotypedElementTypeDescriptor
			extends AbstractSpecializationTypeDescriptor {

		private Stereotype stereotype;

		private IEditHelperAdvice advice;

		StereotypedElementTypeDescriptor(ZDLElementType zdl, IElementType uml,
				final Stereotype stereotype) {
			
			super(ZDLElementTypeUtil.getZDLSpecializationElementTypeId(
				stereotype.getProfile(), zdl.getDomainConcept()), zdl
				.getDisplayName(), zdl.getIconURL());

			this.stereotype = stereotype;
			this.base = new IElementType[]{uml, zdl};
		}
		
		StereotypedElementTypeDescriptor(String id, ZDLElementType zdl,
				IElementType uml, final Stereotype stereotype) {
			
			super(id, zdl.getDisplayName(), zdl.getIconURL());
			this.stereotype = stereotype;
			this.base = new IElementType[]{uml, zdl};
		}

		public String getKindName() {
			return "org.eclipse.gmf.runtime.emf.type.core.IHintedType"; //$NON-NLS-1$
		}

		public String getParamValue(String paramName) {
			return "stereotype".equals(paramName) //$NON-NLS-1$
				? stereotype.getQualifiedName()
				: null;
		}

		@Override
		public IElementMatcher getMatcher() {
			return new IElementMatcher() {

				public boolean matches(EObject object) {
					return (object instanceof Element)
						&& ((Element) object).isStereotypeApplied(stereotype);
				}

			};
		}

		public IEditHelperAdvice getEditHelperAdvice() {
			if (advice == null) {

				advice = new AbstractEditHelperAdvice() {

					@Override
					protected ICommand getAfterConfigureCommand(
							final ConfigureRequest request) {

						return new AbstractTransactionalCommand(TransactionUtil
							.getEditingDomain(request.getEditingDomain()),
							"Apply Stereotype", null) {//$NON-NLS-1$

							@Override
							protected CommandResult doExecuteWithResult(
									IProgressMonitor monitor, IAdaptable info)
									throws ExecutionException {

								EObject object = request
									.getElementToConfigure();

								if (object instanceof Element) {
									Element element = (Element) object;
									if (!element
										.isStereotypeApplied(stereotype)) {

										Object ignoreStereotype = request
											.getParameters().get(
												IGNORE_ZDL_STEREOTYPE_ADVICE);

										if (ignoreStereotype != null) {

											if (!(Boolean) ignoreStereotype) {
												element
													.applyStereotype(stereotype);
											}
										}
									}
								}

								return CommandResult.newOKCommandResult();
							}

						};
					}
					
					@Override
					protected ICommand getBeforeConfigureCommand(
							final ConfigureRequest request) {

						return new AbstractTransactionalCommand(TransactionUtil
							.getEditingDomain(request.getEditingDomain()),
							"Apply Stereotype", null) {//$NON-NLS-1$

							@Override
							protected CommandResult doExecuteWithResult(
									IProgressMonitor monitor, IAdaptable info)
									throws ExecutionException {

								EObject object = request
									.getElementToConfigure();

								if (object instanceof Element) {
									Element element = (Element) object;
									if (!element
										.isStereotypeApplied(stereotype)) {

										Object ignoreStereotype = request
											.getParameters().get(
												IGNORE_ZDL_STEREOTYPE_ADVICE);

										if (ignoreStereotype != null) {

											if (!(Boolean) ignoreStereotype) {
												element
													.applyStereotype(stereotype);
											}
										}
									}
								}

								return CommandResult.newOKCommandResult();
							}

						};
					}					
				};
			}

			return advice;
		}
	}

	private static class ElementTypeMap {
	
		static Map<String, String> hints = new java.util.HashMap<String, String>();
		static String resource;
	
		static {
			try {
				resource = "com.zeligsoft.base.zdl.type.elementTypes"; //$NON-NLS-1$
	
				if (RSMUtil.isRSMAvailable()) {
					resource = resource + "_rsm"; //$NON-NLS-1$
				}
	
				ResourceBundle bundle = ResourceBundle.getBundle(resource);
	
				for (Enumeration<String> keys = bundle.getKeys(); keys
					.hasMoreElements();) {
					String next = keys.nextElement();
					hints.put(next, bundle.getString(next));
				}
			} catch (Exception e) {
				ZeligsoftAbstractPlugin.warning(Activator.getDefault(), NLS
					.bind(
						Messages.ZDLElementTypeManager_errorWhileTryingToLoadHintedElementTypePropertyResource,
						resource), e);
				
			}
		}
	
		static String getElementTypeID(String hint) {
			return hints.get(hint);
		}
	}
	
	/**
	 * Converts the given hint to a ElementTypeId if the given hint is mapped
	 * to an ElementTypeId.  This is used to abstract the underlying IElementType
	 * based on the configuration.
	 * 
	 * @param hint
	 * @return the ElementType identifier
	 */
	public String getElementTypeIdFromHint(String hint) {
		return ElementTypeMap.getElementTypeID(hint);
	}
	
	/**
	 * Returns an IElementType if the given hint is mapped to an ElementType.  
	 * This is used to abstract the underlying IElementType based on the configuration.
	 * 
	 * @param hint the ElementType hint
	 * @return the IElementType
	 */
	public IElementType getElementTypeFromHint(String hint) {
		String id = getElementTypeIdFromHint(hint);
		return ElementTypeRegistry.getInstance().getType(id);
	}
}
