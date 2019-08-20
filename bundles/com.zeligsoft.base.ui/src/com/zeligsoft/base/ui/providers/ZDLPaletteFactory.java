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

package com.zeligsoft.base.ui.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.Request;
import org.eclipse.gef.Tool;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteStack;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.tools.ConnectionCreationTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.CreationTool;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.ui.ElementTypeImageDescriptor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.IPluginContribution;
import org.eclipse.ui.activities.WorkbenchActivityHelper;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.base.toolingmodel.Drawer;
import com.zeligsoft.base.toolingmodel.Expression;
import com.zeligsoft.base.toolingmodel.LinkTool;
import com.zeligsoft.base.toolingmodel.OawExpression;
import com.zeligsoft.base.toolingmodel.OawXtend;
import com.zeligsoft.base.toolingmodel.Palette;
import com.zeligsoft.base.toolingmodel.Stack;
import com.zeligsoft.base.toolingmodel.ToolingModelPackage;
import com.zeligsoft.base.ui.l10n.Messages;
import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.ui.utils.ZDLActivityUtil;
import com.zeligsoft.base.zdl.type.ZDLElementType;
import com.zeligsoft.base.zdl.type.ZDLElementTypeManager;
import com.zeligsoft.base.zdl.type.ZDLElementTypeUtil;
import com.zeligsoft.base.zdl.util.OawEvaluationUtil.OawDescriptor;
import com.zeligsoft.base.zdl.util.OawEvaluationUtil.OawExpressionDescriptor;
import com.zeligsoft.base.zdl.util.OawEvaluationUtil.OawXtendDescriptor;
import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * Palette factory for Zeligsoft for tools defined in the ZDL generator model.
 * These tools are generic, manipulating the model using the ZDL reflection API.
 * 
 * @author Christian W. Damus (cdamus)
 * @author Jon Corchis (jcorchis)
 */
public class ZDLPaletteFactory {
	public static final String CONFIGURE_EXPRESSIONS = 
		"com.zeligsoft.base.ui.palette.expression"; //$NON-NLS-1$
	
	private Collection<Profile> domainProfiles;

	private String diagramKind;
	
	static private Map<IElementType, ElementTypeImageDescriptor> imageDescriptors = new HashMap<IElementType, ElementTypeImageDescriptor>(11);

	/**
	 * Create me.
	 * 
	 * @param editor
	 */
	public ZDLPaletteFactory(DiagramEditor editor) {
		this.diagramKind = editor.getDiagram().getType();

		Package context = (Package) EMFCoreUtil.getContainer(editor
			.getDiagram(), UMLPackage.Literals.PACKAGE);

		if (context != null) {
			domainProfiles = ZDLUtil.getZDLProfiles(context);
		}
	}

	/**
	 * Adds Palette entries to the given PaletteRoot
	 * 
	 * @param paletteRoot
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		List<PaletteDrawer> drawers = createDrawers();
		paletteRoot.addAll(drawers);
	}

	/**
	 * Creates the drawers as specified in the ZDL generator model.
	 * 
	 * @return the drawers
	 */
	private List<PaletteDrawer> createDrawers() {
		List<PaletteDrawer> result = new java.util.ArrayList<PaletteDrawer>();

		if (domainProfiles != null) {
			for (Profile next : domainProfiles) {
				EAnnotation annot = next
					.getEAnnotation(ToolingModelPackage.eNS_URI);

				if (annot != null) {
					Palette palette = (Palette) EcoreUtil.getObjectByType(annot
						.getContents(), ToolingModelPackage.Literals.PALETTE);

					if (palette != null) {
						addDrawers(result, next, palette);
					}
				}
			}
		}

		return result;
	}

	/**
	 * Adds to a list of drawers the drawers specified in the given palette
	 * model.
	 * 
	 * @param result
	 *            the acumulator of drawers
	 * @param profile
	 *            the contextual domain profile
	 * @param palette
	 *            the palette model
	 */
	private void addDrawers(List<PaletteDrawer> result, Profile profile,
			Palette palette) {
		String idPrefix = ZDLActivityUtil.ID_PREFIX
			+ UML2Util.getValidJavaIdentifier(profile.getName()) + '.';

		for (Drawer next : palette.getDrawer()) {
			if (next.getTargetDiagram().isEmpty()  
			|| next.getTargetDiagram().contains(diagramKind)) {			
				final PaletteDrawer drawer = createDrawer(next, profile, idPrefix);
				IPluginContribution pc = ZDLActivityUtil.
					PluginContributionFactory.INSTANCE.create(drawer.getId());
				if(!WorkbenchActivityHelper.filterItem(pc)) {
					result.add(drawer);
				}
			}
		}
	}

	/**
	 * Creates a drawer entry from the model's specification.
	 * 
	 * @param drawerSpec
	 *            the drawer specification
	 * @param profile
	 *            the contextual domain profile
	 * @param idPrefix
	 *            a prefix on which to base the drawer entry's ID
	 * @return the drawer entry
	 */
	private PaletteDrawer createDrawer(Drawer drawerSpec, Profile profile,
			String idPrefix) {
		PaletteDrawer result = new PaletteDrawer(drawerSpec.getName());

		String id = idPrefix
			+ UML2Util.getValidJavaIdentifier(drawerSpec.getName());
		result.setId(id);
		result.setDescription(drawerSpec.getName());

		idPrefix = id + '.';
		for (com.zeligsoft.base.toolingmodel.Tool next : drawerSpec.getTool()) {
			PaletteEntry entry = createTool(next, profile, idPrefix);
			if (entry != null) {
				result.add(entry);
			}
		}

		return result;
	}

	/**
	 * Creates a tool entry from the model's specification.
	 * 
	 * @param toolSpec
	 *            the tool specification
	 * @param profile
	 *            the contextual domain profile
	 * @param idPrefix
	 *            a prefix on which to base the tool entry's ID
	 * @return the tool entry, or <code>null</code> if the tool does not
	 *         belong in the current diagram kind
	 */
	private PaletteEntry createTool(
			com.zeligsoft.base.toolingmodel.Tool toolSpec, Profile profile,
			String idPrefix) {
		PaletteEntry result;

		if (toolSpec instanceof Stack) {
			Stack stack = (Stack) toolSpec;

			if (stack.getTargetDiagram().isEmpty()
				|| stack.getTargetDiagram().contains(diagramKind)) {
				
				result = createStack(stack, profile, idPrefix);
			} else {
				result = null;
			}
		} else if (toolSpec instanceof com.zeligsoft.base.toolingmodel.CreationTool) {

			com.zeligsoft.base.toolingmodel.CreationTool creationTool = (com.zeligsoft.base.toolingmodel.CreationTool)toolSpec;		
			if (creationTool.getConcept() != null) {
				result = createCreationTool(
					creationTool,
					profile, idPrefix);
			} else {
				String id = creationTool.getElementTypeHint();
				String hintId = ZDLElementTypeManager.INSTANCE.getElementTypeIdFromHint(id);
				if (ZDLElementTypeUtil.isRealizationshipHint(id)) {
					result = createLinkElementTypeTool(hintId);
				} else {
					result = createNodeElementTypeTool(hintId, creationTool.getExpression());
				}
			}
		} else if (toolSpec instanceof LinkTool) {
			result = createLinkTool((LinkTool) toolSpec, profile, idPrefix);
		} else {
			throw new IllegalArgumentException("unsupported tool kind: " //$NON-NLS-1$
				+ toolSpec.eClass().getName());
		}

		return result;
	}

	
	/**
	 * Creates a NodeToolEntry for the given Element Type id.
	 * 
	 * @param id
	 *            the ElementType identifier
	 * @return the NodeToolEntry
	 */
	private ToolEntry createNodeElementTypeTool(String id, List<Expression> expression) {
		IElementType elementType = ElementTypeRegistry.getInstance()
			.getType(id);

		if (elementType != null) {

			return new NodeToolEntry(id, elementType.getDisplayName(),
				NLS.bind(Messages.GenericPaletteCreationTool_label, elementType.getDisplayName()),
				getElementTypeImageDescriptor(elementType), elementType, expression);
		}
		return null;
	}

	/**
	 * Creates a stack entry from its specification in th palette model.
	 * 
	 * @param stackSpec
	 *            the stack model
	 * @param profile
	 *            the contextual domain profile
	 * @param idPrefix
	 *            a prefix on which to base the stack entry's ID
	 * @return the stack entry, or <code>null</code> if the stack does not
	 *         belong in the current diagram kind
	 */
	private PaletteStack createStack(Stack stackSpec, Profile profile,
			String idPrefix) {
		PaletteStack result = new PaletteStack(stackSpec.getName(), stackSpec
			.getName(), null/* TODO */);

		String id = idPrefix
			+ UML2Util.getValidJavaIdentifier(stackSpec.getName());
		result.setId(id);

		idPrefix = id + '.';
		for (com.zeligsoft.base.toolingmodel.Tool next : stackSpec.getTool()) {
			PaletteEntry entry = createTool(next, profile, idPrefix);
			if (entry != null) {
				result.add(entry);

				if (next == stackSpec.getActiveTool()) {
					result.setActiveEntry(entry);
					result.setSmallIcon(entry.getSmallIcon());
					result.setLargeIcon(entry.getLargeIcon());
				}
			}
		}

		return result;

	}

	/**
	 * Creates a creation tool entry from its specification in the model.
	 * 
	 * @param toolSpec
	 *            the tool specfication in the palette model
	 * @param profile
	 *            the contextual domain profile
	 * @param idPrefix
	 *            a prefix on which to base the creation tool entry's ID
	 * @return the creation tool entry
	 */
	private ToolEntry createCreationTool(
			com.zeligsoft.base.toolingmodel.CreationTool toolSpec,
			Profile profile, String idPrefix) {

		ElementTypeRegistry reg = ElementTypeRegistry.getInstance();

		// get the base UML metaclass of our concept
		Class base = ZDLUtil.getBaseMetaclass(profile, toolSpec.getConcept());
		if(base == null || base.isAbstract()) {
			// It is possible that a concept is not mapped or mapped to a 
			// abstract meta-class, in this case it does not make sense to create
			// a tool.
			return null;
		}
		EClass eclass = (EClass) UMLPackage.eINSTANCE.getEClassifier(base
			.getName());
		String specId = null;
		String hint = toolSpec.getElementTypeHint();
		if (UML2Util.isEmpty(hint)) {
			specId = ZDLElementTypeUtil.getZDLSpecializationElementTypeId(
				profile, toolSpec.getConcept());
		} else {
			specId = ZDLElementTypeUtil
				.getZDLHintedSpecializationElementTypeId(profile, toolSpec
					.getConcept().getQualifiedName(), toolSpec
					.getElementTypeHint());
		}

		IElementType toolType = reg.getType(specId);
		
		// ElementType not yet registered
		if (toolType == null) {
			IElementType zdl = ZDLElementTypeManager.INSTANCE
				.getElementType(toolSpec.getConcept());
			Stereotype stereotype = (Stereotype) ZDLUtil.getProfileClass(
				profile, toolSpec.getConcept());
			if (UML2Util.isEmpty(toolSpec.getElementTypeHint())) {
				IElementType umlBase = ElementTypeRegistry.getInstance()
					.getElementType(eclass);
				toolType = ZDLElementTypeManager.INSTANCE.getStereotypeType(
					(ZDLElementType) zdl, umlBase, stereotype);
			} else {
				toolType = ZDLElementTypeManager.INSTANCE
					.getHintedStereotypedType((ZDLElementType) zdl, toolSpec
						.getElementTypeHint(), stereotype);
			}
		}
		String id = idPrefix
			+ UML2Util.getValidJavaIdentifier(toolSpec.getName());

		// create the tool entry
		if (ZDLElementTypeUtil.isRelationshipElementType(toolType)) {
			return new ConnectionToolEntry(id, toolSpec.getName(), toolSpec
				.getName(), getElementTypeImageDescriptor(toolType), toolType, toolSpec.getExpression());
		} else {
			return new NodeToolEntry(id, toolSpec.getName(),
				toolSpec.getName(), getElementTypeImageDescriptor(toolType),
				toolType, toolSpec.getExpression());
		}
	}

	/**
	 * Creates a connection tool entry from its specification in the model.
	 * 
	 * @param toolSpec
	 *            the specification of the link tool in the model
	 * @param profile
	 *            the contextual domain profile
	 * @param idPrefix
	 *            a prefix on which to base the link tool entry's ID
	 * @return the link tool entry
	 */
	private ToolEntry createLinkTool(LinkTool toolSpec, Profile profile,
			String idPrefix) {

		Property reference = toolSpec.getReference();
		Class concept = reference.getClass_();
		List<Expression> expressions = Collections.emptyList();

		IElementType referenceType = ZDLElementTypeManager.INSTANCE
			.getElementType(concept, reference);

		String id = idPrefix
			+ UML2Util.getValidJavaIdentifier(toolSpec.getName());

		return new ConnectionToolEntry(id, toolSpec.getName(), toolSpec
			.getName(), getElementTypeImageDescriptor(referenceType),
			referenceType, expressions);
	}
	
	/**
	 * Creates a relationship ToolEntry for the given Element Type id.
	 * @param id
	 * 			the ElementType identifier
	 * @return the link tool entry
	 */
	private ToolEntry createLinkElementTypeTool(String id) {
		IElementType elementType = ElementTypeRegistry.getInstance()
			.getType(id);
		List<Expression> expressions = Collections.emptyList();

		if (elementType != null) {

			return new ConnectionToolEntry(id, elementType.getDisplayName(),
				NLS.bind(Messages.GenericPaletteCreationTool_label, elementType
					.getDisplayName()),
				getElementTypeImageDescriptor(elementType), elementType, expressions);
		}
		return null;
	}

	/**
	 * Obtains an image descriptor that delegates to the icon defined by the
	 * given element type.
	 * 
	 * @param elementType
	 *            an element type
	 * @return an image descriptor that provides the element type's icon
	 */
	private ImageDescriptor getElementTypeImageDescriptor(
			IElementType elementType) {
		ElementTypeImageDescriptor desc = imageDescriptors.get(elementType);
		if (desc == null){
			desc = new ElementTypeImageDescriptor(elementType);
			imageDescriptors.put(elementType, desc);
		}		
		return desc;
	}

	//
	// Nested classes
	//

	/**
	 * A generic ZDL creation tool entry.
	 */
	private static class NodeToolEntry
			extends ToolEntry {

		private final IElementType elementType;
		private final List<Expression> expression;
		
		private NodeToolEntry(String id, String title, String description,
				ImageDescriptor icon, IElementType elementType, List<Expression> list) {
			super(title, description, icon, icon);
			setId(id);
			this.elementType = elementType;
			this.expression = list;
		}
		
		@Override
		public Tool createTool() {
			List<OawDescriptor> descriptors = null;
			if(expression != null && !expression.isEmpty()) {
				descriptors = new ArrayList<OawDescriptor>(expression.size());
				for(Expression rawexpr : expression) {
					if(rawexpr instanceof OawExpression) {
						OawExpression expr = (OawExpression) rawexpr;
						OawExpressionDescriptor oed = new OawExpressionDescriptor(null, 
								Collections.singletonList(expr.getExpression()), 
								expr.getMetamodel(), expr.getVariableName());
						descriptors.add(oed);
					} else if(rawexpr instanceof OawXtend) {
						OawXtend expr = (OawXtend) rawexpr;
						OawXtendDescriptor oed = 
							new OawXtendDescriptor(null, 
								Collections.singletonList(expr.getExpression()), 
								expr.getMetamodel(),
								expr.getExtensionFile());
						descriptors.add(oed);
					}
				}
			}
			Tool tool = new NodeCreationTool(elementType, descriptors);
			return tool;
		}
	}

	/**
	 * A generic ZDL link tool entry.
	 */
	private static class ConnectionToolEntry
			extends ToolEntry {

		private final IElementType elementType;
		private final List<Expression> expression;

		private ConnectionToolEntry(String id, String title,
				String description, ImageDescriptor icon,
				IElementType elementType, List<Expression> list) {
			super(title, description, icon, icon);
			setId(id);
			this.elementType = elementType;
			this.expression = list;
		}

		@Override
		public Tool createTool() {
			List<OawDescriptor> descriptors = null;
			if(expression != null && !expression.isEmpty()) {
				descriptors = new ArrayList<OawDescriptor>(expression.size());
				for(Expression rawexpr : expression) {
					if(rawexpr instanceof OawExpression) {
						OawExpression expr = (OawExpression) rawexpr;
						OawExpressionDescriptor oed = new OawExpressionDescriptor(null, 
								Collections.singletonList(expr.getExpression()), 
								expr.getMetamodel(), expr.getVariableName());
						descriptors.add(oed);
					} else if(rawexpr instanceof OawXtend) {
						OawXtend expr = (OawXtend) rawexpr;
						OawXtendDescriptor oed = 
							new OawXtendDescriptor(null, 
								Collections.singletonList(expr.getExpression()), 
								expr.getMetamodel(),
								expr.getExtensionFile());
						descriptors.add(oed);
					}
				}
			}
			
			Tool tool = new ZDLConnectionCreationTool(elementType, descriptors);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
	
	/**
	 * 
	 *	A generic creation tool for nodes in a CX diagram. It will
	 *	add a property to hold the expressions to execute as part of
	 *	the element creation process.
	 */
	private static class NodeCreationTool extends CreationTool {
		
		final List<OawDescriptor> descriptor;
		
		IElementType type = null;
		
		private NodeCreationTool(IElementType type, List<OawDescriptor> descriptor) {
			super(type);
			this.descriptor = descriptor;
			this.type = type;
		}
		
		@SuppressWarnings("unchecked")
		@Override
		protected CreateRequest getCreateRequest() {
			CreateRequest req = super.getCreateRequest();
			req.getExtendedData().put(CONFIGURE_EXPRESSIONS, descriptor);
			return req;
		}
		
		// This code is for fixing RSA bug where two ports are created when one
		// is intended using palate, refer SCXB-2692
		@Override
		protected void executeCurrentCommand() {
			if (BaseUIUtil.isUMLPort(type)) {
				Command currentCommand = getCurrentCommand();
				if (currentCommand instanceof CompoundCommand) {
					CompoundCommand createCommand = null;
					for (Object command : ((CompoundCommand) currentCommand)
							.getCommands()) {
						if (command instanceof CompoundCommand) {
							String debugLabel = ((CompoundCommand) command)
									.getDebugLabel();
							if ("Chained Commands Create SCA Port" //$NON-NLS-1$
							.equals(debugLabel)
									|| "Chained Commands Create Interface Port" //$NON-NLS-1$
									.equals(debugLabel)
									|| "Chained Commands Create Device That Loaded This Component Ref" //$NON-NLS-1$
									.equals(debugLabel)
									|| "Chained Commands Create Device Used By This Component Ref" //$NON-NLS-1$
									.equals(debugLabel)
									|| "Chained Commands Create SCA Log Connection" //$NON-NLS-1$
									.equals(debugLabel)
									|| "Chained Commands Create SCA File Manager Connection" //$NON-NLS-1$
									.equals(debugLabel)
									|| "Chained Commands Create SCA Naming Service Connection" //$NON-NLS-1$
									.equals(debugLabel)
									|| "Chained Commands Create SCA Event Channel Connection" //$NON-NLS-1$
									.equals(debugLabel)
									|| "Chained Commands Create SCA Find By Naming Service" //$NON-NLS-1$
									.equals(debugLabel)
									|| "Chained Commands Create Service Name Conn" //$NON-NLS-1$
									.equals(debugLabel)
									|| "Chained Commands Create Service Type Conn" //$NON-NLS-1$
									.equals(debugLabel)) {
								createCommand = (CompoundCommand) command;
								break;
							}
						}
					}
					if (createCommand != null
							&& createCommand.getCommands().size() > 1) {
						Integer indexToRemove = null;
						for (Object command : createCommand.getCommands()) {
							if (command instanceof ICommandProxy) {
								String label = ((ICommandProxy) command)
										.getLabel();
								if (((ICommandProxy) command).getICommand() instanceof CompositeTransactionalCommand) {
									if ("Create SCA Port" //$NON-NLS-1$
									.equals(label) 
											|| "Create Interface Port" //$NON-NLS-1$
									.equals(label)
											|| "Create Device That Loaded This Component Ref" //$NON-NLS-1$
											.equals(label)
											|| "Create Device Used By This Component Ref" //$NON-NLS-1$
											.equals(label)
											|| "Create SCA Log Connection" //$NON-NLS-1$
											.equals(label)
											|| "Create SCA File Manager Connection" //$NON-NLS-1$
											.equals(label)
											|| "Create SCA Naming Service Connection" //$NON-NLS-1$
											.equals(label)
											|| "Create SCA Event Channel Connection" //$NON-NLS-1$
											.equals(label)
											|| "Create SCA Find By Naming Service" //$NON-NLS-1$
											.equals(label)
											|| "Create Service Name Conn" //$NON-NLS-1$
											.equals(label)
											|| "Create Service Type Conn" //$NON-NLS-1$
											.equals(label)) {
										indexToRemove = createCommand
												.getCommands().indexOf(command);
										break;
									}
								}
							}
						}
						if (indexToRemove != null) {
							createCommand.getCommands().remove(
									indexToRemove.intValue());
						}
					}
				}
			}
			super.executeCurrentCommand();
		}
		
	}
	
	private static class ZDLConnectionCreationTool extends ConnectionCreationTool {
		final List<OawDescriptor> descriptor;
		
		private ZDLConnectionCreationTool(IElementType type, List<OawDescriptor> descriptor) {
			super(type);
			this.descriptor = descriptor;
		}
		
		@SuppressWarnings("unchecked")
		@Override
		protected Request createTargetRequest() {
			Request req = super.createTargetRequest();
			req.getExtendedData().put(CONFIGURE_EXPRESSIONS, descriptor);
			return req;
		}
	}
}
